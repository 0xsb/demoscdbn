<template>
    <div id="map5">
        <div class="map-container clearfix" style="height: 350px;">
            <div class="item" id="map5-map1"></div>
            <div class="item" id="map5-map2"></div>
            <div class="item" id="map5-map3"></div>
        </div>
        <div class="map-container clearfix border" style="height: 315px; width: 1380px;">
            <div  id="map5-map4"></div>
        </div>
        <div class="map-container clearfix border" style="height: 315px; width: 1380px;">
            <div  id="map5-map5"></div>
        </div>
    </div>
</template>
<style lang="less">
/*#map5{
    width: 1560px;
    height: 1080px;
    background: url(../../assets/imgs/map5.jpg) no-repeat;
    background-size: contain;
}*/
#map5{
    .item{
        float: left;
    }
    #map5-map1,#map5-map2,#map5-map3{
        width: 520px;
        height: 350px;
        box-sizing: border-box;
        padding:10px;
        border:2px solid #2c3e65;
    }
    #map5-map4,#map5-map5{
        width: 1380px;
        height: 315px;
        float: none;
    }
}
</style>
<script type="text/ecmascript-6">
    import {demo,column,textStyle,labelStyle,seriesLabelStyle,axisLabel,axisLine} from '../../assets/js/demoCharts'
    import echarts from 'echarts/lib/echarts';

    const map5 = {
        map1:{
            name: '手机点击本网率',
            value: 93.4
        },
        map2:{
            name: '流量本网率',
            value: 96.9
        },
        map3:{
            name: '引入深度',
            value: 70.5
        },
        map4(){
            let array = [];
            for(let i=0;i<31;i++){
                array.push((Math.random()*100).toFixed(2))
            }
            return array;
        }
    }
    const placeHolderStyle = {
        normal : {
            color: 'rgba(0,0,0,0)',
            label: {show:false},
            labelLine: {show:false}
        },
        emphasis : {
            color: 'rgba(0,0,0,0)'
        }
    };
    export default{
        data(){
            return {
                map5zonghe:[],  //map1-3
                map5_4:[],  //map4
                map5_5:[],  //map5
            }
        },
        methods:{
            drawrose(id,title,data,color){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title : {
                        text: `${title}`,
                        textStyle,
                        left: 'center',
                        top:20,
                    },
                    tooltip: {
                        trigger: 'item',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        }
                    },
                    calculable: true,
                    series:  {
                        name: `${title}`,
                        type: 'pie',
                        radius: ['45%', '60%'],
                        center: ['50%', '50%'],
                        data: [
                            data,
                            {
                                value:(100-data.value).toFixed(1),
                                name:'invisible',
                                itemStyle : placeHolderStyle
                            }
                        ],
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br /> {c}%"
                        },
                        avoidLabelOverlap: false,
                        label: {
                            normal: {
                                show: true,
                                position: 'center',
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'normal',
                                },
                                formatter: "{c}%"
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: '30',
                                    fontWeight: 'normal'
                                }
                            }
                        },
                        itemStyle: {
                            normal:{
                                color: color
                            },
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffset: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                });
            },
            drawbar(id,title,data) {       //各省指标柱状图
                console.log(data);
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title:{
                        text:`${title}`,
                        textStyle,
                        left: 'center',
                        top:20
                    },
                    tooltip: {
                        trigger: 'item',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#000'
                        },
                    },
                    xAxis: [
                        {
                            axisLine,
                            show:true,
                            data:column,
                            axisLabel: {
                                show:true,
                                interval:0,
                                textStyle:{
                                    color: '#c0c6c4',
                                    fontSize: 14
                                },
                                formatter:(val,index)=>{
                                    let arr = [...val].join('\n');
                                    return `${arr}`;
                                }
                            }
                        }
                    ],
                    yAxis: [
                        {
                            show:true,
                            axisLine,

                            min: 80,
                            max: 100,
                            type: 'value',
                            splitLine:{
                                show:false
                            },
                            axisLabel:{
                                show:true,
                                textStyle:{
                                    color: '#c0c6c4',
                                    fontSize: 14
                                },
                                formatter: '{value}%'
                            }
                        }
                    ],
                    /*legend:{
                        show:true,
                        data:[title],
                        right:'10%',
                        itemWidth:15,
                        itemHeight:15,
                        top:20,
                        textStyle:{
                            color:'#FFF',
                            fontSize: 14

                        }
                    },*/
                    series: [
                        {
                            name: `${title}`,
                            type: 'bar',
                            barWidth: 25,
                            label: {
                                normal: {
                                    show: false,
                                    position: 'insideTop'
                                }
                            },
                            itemStyle:{
                                normal:{
                                    color: '#affd87'
                                }
                            },
                            data: data
                        }
                    ]
                });
            },
            getDataValue(array){
                let arr = [];
                array.map((item)=>{
                    arr.push(Number(item.value));
                });
                return arr;
            }
        },
        mounted(){
            this.$nextTick(function(){
                this.$http.get('/data/showdatajson?child=nrdj&name=zonghe').then(res=>{
                    this.map5zonghe = res.data.zonghe;
                }).then(()=>{
                    this.drawrose('map5-map1','手机点击本网率',this.map5zonghe.sjdj,'#f05f40');
                    this.drawrose('map5-map2','流量本网率',this.map5zonghe.llbw,'#f0ca39');
                    this.drawrose('map5-map3','引入深度',this.map5zonghe.yrsd,'#4b9fe8');
                }).catch(res=>{
                    console.log(res);
                })

                this.$http.get('/data/showdatajson?child=nrdj&name=sjbwl').then(res=>{
                    this.map5_4 = res.data.sjbwl;
                }).then(()=>{
                    this.drawbar('map5-map4','手机点击本网率全网对比',this.getDataValue(this.map5_4));
                }).catch(res=>{
                    console.log(res);
                })

                this.$http.get('/data/showdatajson?child=nrdj&name=llbwl').then(res=>{
                    this.map5_5 = res.data.llbwl;
                }).then(()=>{
                    this.drawbar('map5-map5','流量本网率全网对比',this.getDataValue(this.map5_5));
                }).catch(res=>{
                    console.log(res);
                })
            })
        }
    }
</script>
