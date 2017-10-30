<template>
    <div id="map">
        <my-head></my-head>
        <ol class="breadcrumb">
            <li>
                <a href="/">首页</a>
            </li>
            <li>
                <a @click="$router.push('/mapList')">数据视图</a>
            </li>
            <li>
                数据详情
            </li>
        </ol>
        <h1>全网业务流量分布地图（图例）</h1>
        <h2>网络部 <span>2017-06-30 13:00</span></h2>
        <div class="map clearfix">
            <div id="china-charts-map"></div>
            <div id="china-charts-lines"></div>
            <p class="data-info pull-left" style="width: 1000px; margin-bottom: 50px;">数据来源：网络部 2017-07-20 13:00 —— 2017-07-20 13:00</p>
        </div>
        <my-foot></my-foot>
    </div>
</template>
<style lang="less">
    #china-charts-map{
        background: #1b1b1b;
        width: 850px;
        height: 650px;
        float: left;
    }
    #china-charts-lines{
        float: left;
        margin-top: 100px;
        width: 300px;
        height: 300px;
    }
    .echart-circle{
        display: inline-block;
        width: 12px;
        height: 12px;
        border-radius: 50%;
        margin-right: 5px;
        background: #FFF;
    }
</style>
<script type="text/ecmascript-6">
    import echarts from 'echarts';
    import china from 'echarts/map/js/china'
    import myFoot from '../../components/common/foot'
    import myHead from '../../components/common/header-show'
    import {echartData} from '../../assets/js/data'
    import {map4,color,colorD} from '../../assets/js/chartsData'

    let data = (type)=>{
        let array = [];
        map4.mapdata.map((item)=>{
            array.push({
                name: item.name,
                value: item.value[type]
            })
        })
        return array;
    }

    let ser = ()=>{
        let array = [];
        let labelArray = [{name:'统建CDN',item:'CDN'},{name:'IDC',item:'IDC'},{name:'省建Cache',item:'PCache'},{name:'统建Cache',item:'Cache'},{name:'省建OTT',item:'POTT'},{name:'',item:''}]
        for(let i=0;i<labelArray.length;i++){
            array.push({
                name: labelArray[i].name,
                type: 'map',
                mapType: 'china',
                selectedMode : 'single',
                zoom: 1.2,
                label: {
                    normal: { show: false},
                    emphasis: { show: false}
                },
                itemStyle: {
                    normal: {
                        color: Object.values(color)[i],
                        areaColor: '#e0ffff',
                        borderColor: 'rgba(100,149,237,1)',
                        opacity: '0.6'
                    },
                    emphasis: {
                        areaColor: colorD,
                        shadowColor: 'rgba(0, 0, 0, 0.5)',
                        shadowBlur: 10,
                        opacity: '0.8'
                    }
                },
                roam: true,
                data:data(labelArray[i].item)
            })
        }
        return array;
    }
    let series = ser();
    let option = {
        backgroundColor: '#FFF',
        tooltip : {
            trigger: 'item',
        },
        zoom: 1.5,
        toolbox: {
            show: true,
            top:'0',
            left: '1%',
            feature: {
                dataView: {readOnly: true},
                restore: {},
                saveAsImage: {}
            }
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text: ['高','低'],
            calculable: true,
            inRange: {
                color: ['#e0ffff', '#006edd']
            },
        },
        legend: {
            orient: 'horizontal',
            left: '20%',
            top: '1%',
            data:['统建CDN','IDC','省建Cache','统建Cache','省建OTT'],

        },
        tooltip:{
            trigger: 'item',
            formatter: function(obj){
                let data = map4.mapdata[obj.dataIndex];
                return `<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 16px;padding-bottom: 7px;margin-bottom: 7px">
                            全网业务流量分布地图
                        </div>
                        省份：${data.name}<br/>
                        <b class="echart-circle" style="background: ${Object.values(color)[0]}"></b>统建CDN：${data.value.CDN}GBPS<br />
                        <b class="echart-circle" style="background: ${Object.values(color)[1]}"></b>IDC：${data.value.IDC}GBPS<br />
                        <b class="echart-circle" style="background: ${Object.values(color)[2]}"></b>统建Cache：${data.value.Cache}GBPS<br />
                        <b class="echart-circle" style="background: ${Object.values(color)[3]}"></b>省建Cache：${data.value.PCache}GBPS<br />
                        <b class="echart-circle" style="background: ${Object.values(color)[4]}"></b>省建OTT：${data.value.POTT}GBPS<br />
                        <b class="echart-circle" style="background: #0063dd"></b>总计流量：${(data.value.POTT+data.value.CDN+data.value.IDC+data.value.Cache+data.value.PCache).toFixed(2)}GBPS<br />
                        `
            }
        },
        series: series,
    };
    export default{
        data(){
            return {
                width: '1200px',
                province: new Set(),
                chart : null

            }
        },
        methods:{
            drawmap(id){
                let that = this;
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption(option);
                this.chart.on('click',function(data){
                    that.setData(data);
                });
            },
            setData(data){
                let {name,dataIndex} = data;
                let seriesData = [
                    {
                        name:`${name}`,
                        type: 'bar',
                        data:Object.values(map4.mapdata[dataIndex].value)
                    }
                ];
                let option = {
                    title: {
                        text: `${name}流量数据`,
                        left: 'center',
                        textStyle:{
                            fontSize: 16,
                            fontWeight: 'normal'
                        }
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter:(item)=>{
                            return `<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 16px;padding-bottom: 7px;margin-bottom: 7px">${name}流量数据</div>
                                    ${item.name}：${item.value}GBPS<br/>`
                        }
                    },
                    legend: {
                        data: ['统建CDN','IDC','省建Cache','统建Cache','省建OTT']
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    itemStyle:{
                        normal:{
                            color: function (params){
                                return Object.values(color)[params.dataIndex]
                            }
                        }
                    },
                    xAxis: {
                        type: 'value',
                        boundaryGap: [0, 0.01]
                    },
                    yAxis: {
                        type: 'category',
                        data: ['统建CDN','IDC','省建Cache','统建Cache','省建OTT']
                    },
                    series:seriesData
                };
                this.chart = echarts.init(document.getElementById('china-charts-lines'));
                this.chart.setOption(option);
            }
        },
        mounted(){
            this.$nextTick(function() {
                this.drawmap('china-charts-map');
            });
        },
        components:{
            myHead,myFoot
        }
    }
</script>
