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
        <h1>全网统建CDN、IDC、统建Cache、省建Cache、省建OTT业务流量分析日报</h1>
        <h2>网络部 <span>{{createTimeView}}</span></h2>
        <div class="map">
            <div id="map-content">
                <h3>一、统建CDN业务分析</h3>
                <div class="map-wrapper">
                    <div id="map-item-1"></div>
                    <p class="data-info">数据来源：网络部 {{createTimeView}} —— {{createTimeView}}</p>
                </div>
                <h3>二、统建Cache业务分析</h3>
                <div class="map-wrapper">
                    <div id="map-item-2"></div>
                    <p class="data-info">数据来源：网络部 {{createTimeView}} —— {{createTimeView}}</p>
                </div>
                <h3>三、IDC 业务分析</h3>
                <div class="map-wrapper">
                    <div id="map-item-3"></div>
                    <p class="data-info">数据来源：网络部 {{createTimeView}} —— {{createTimeView}}</p>
                </div>
                <h3>四、省建Cache 业务分析</h3>
                <div class="map-wrapper">
                    <div id="map-item-4"></div>
                    <p class="data-info">数据来源：网络部 {{createTimeView}} —— {{createTimeView}}</p>
                </div>
                <h3>五、OTT 业务分析</h3>
                <div class="map-wrapper mb-60">
                    <div id="map-item-5"></div>
                    <p class="data-info">数据来源：网络部 {{createTimeView}} —— {{createTimeView}}</p>
                </div>
            </div>
        </div>
        <my-foot></my-foot>
    </div>
</template>
<style lang="less">
    #map-item-1,#map-item-2,#map-item-3,#map-item-4,#map-item-5{
        width: 1024px;
        height: 480px;
        margin: 0 auto;
    }
    #map-item-5{
        margin-bottom: 30px;
    }
    .data-info{
        width: 1024px;
        margin: 10px auto 0 auto;
        text-align: right;
    }
</style>
<script type="text/ecmascript-6">
    import echarts from 'echarts';
    import myFoot from '../../components/common/foot'
    import myHead from '../../components/common/header-show'
    import {echartData} from '../../assets/js/data'
    const color = {
        lightblue: '#85cef4',
        blue: '#4ba3fa',
        lightgreen: '#b7e331',
        yellow: '#ffd957',
        orange: '#ff944c',
        envy: '#96afff',
        violet: '#986bff',
        red: '#46d185',
        green: '#ec5845'
    }
    export default{
        data(){
            return {
                chart:null,
                width: '1200px',
                data1:[],
                CDN:{
                    trafficin:[],
                    trafficout:[]
                },
                cache:{
                    trafficin:[],
                    trafficout:[]
                },
                IDC:{
                    trafficin:[],
                    trafficout:[]
                },
                pcache:{
                    trafficin:[],
                    trafficout:[]
                },
                pott:{
                    trafficin:[],
                    trafficout:[]
                },
                createTimeView:''
            }
        },
        methods:{
            drawbar(id,columns,data1,data2,color) {
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    tooltip: {
                        trigger: 'axis',
                        "axisPointer": {
                            "type": "shadow"
                        },
                    },
                    legend:{
                        data:['入流量Gbps','出流量Gbps']
                    },
                    grid:{
                        bottom:60,
                        height:400
                    },
                    dataZoom:[
                        {
                            type: 'slider',
                            show: true,
                            xAxisIndex: [0],
                            start: 1,
                            end: 25,
                        },
                        {
                            type: 'inside',
                            xAxisIndex: [0],
                            start: 1,
                            end: 25
                        },
                    ],
                    toolbox: {
                        feature: {
                            saveAsImage: {},
                            dataView: {},
                            magicType: {
                                type: ['stack', 'tiled','line']
                            },
                            restore: {show: true}
                        },
                        right: 15,
                        top: 10
                    },
                    grid: {
                        left: '5%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis: [
                        {
                            "axisLabel": {
                                "interval": 0,
                                "show": true,
                                "splitNumber": 15,
                                "textStyle": {
                                    "fontFamily": "微软雅黑",
                                    "fontSize": 12
                                }
                            },
                            "data": columns
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value',
                            name: '流量,Gbps',
                            nameLocation: 'middle',
                            nameGap:30
                        }
                    ],
                    series: [
                        {
                            name: '入流量Gbps',
                            type: 'bar',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideTop'
                                }
                            },
                            itemStyle:{
                                normal:{
                                    color: color[0]
                                }
                            },
                            data: data1
                        },
                        {
                            name: '出流量Gbps',
                            type: 'bar',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'insideTop'
                                }
                            },
                            itemStyle:{
                                normal:{
                                    color: color[1]
                                }
                            },
                            data: data2
                        }
                    ]
                });
            },
            formatter(data){
                let obj = {
                    trafficin:[],
                    trafficout:[]
                };
                for(let item of data){
                    obj.trafficin.push(item.trafficin);
                    obj.trafficout.push(item.trafficout);
                }
                return obj;
            },
            formatterPro(data){
                let array = [];
                for(let item of data){
                    array.push(item.province)
                }
                return array;
            }
        },
        mounted(){
            this.$http.get('/data/showdaydata').then(res=>{
                this.createTimeView = res.data.PCache[0].createtime+ '  13:00';
                this.data1 = this.formatterPro(res.data.PCache);
                this.CDN = this.formatter(res.data.CDN)
                this.cache = this.formatter(res.data.Cache);
                this.IDC = this.formatter(res.data.IDC);
                this.pcache = this.formatter(res.data.PCache);
                this.pott = this.formatter(res.data.POTT);
            }).then(()=>{
                this.$nextTick(function() {
                    this.drawbar('map-item-1',this.data1,this.CDN.trafficin,this.CDN.trafficout,[color.lightblue,color.orange]);
                    this.drawbar('map-item-2',this.data1,this.cache.trafficin,this.cache.trafficout,[color.yellow,color.violet]);
                    this.drawbar('map-item-3',this.data1,this.IDC.trafficin,this.IDC.trafficout,[color.red,color.green]);
                    this.drawbar('map-item-4',this.data1,this.pcache.trafficin,this.pcache.trafficout,[color.envy,color.red]);
                    this.drawbar('map-item-5',this.data1,this.pott.trafficin,this.pott.trafficout,[color.violet,color.blue]);
                });
            });
        },
        components:{
            myHead,myFoot
        }
    }
</script>
