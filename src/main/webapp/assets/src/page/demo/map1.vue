<template>
    <div id="map1">
        <div class="map-container clearfix">
            <div class="item" id="map1-map1"></div>
            <div class="item" id="map1-map2"></div>
            <div class="item" id="map1-map3"></div>
        </div>
        <div class="map-container clearfix border" style="height: 560px;width: 1380px;" @mouseover='mouseIn()'  @mouseout="mouseOut()">
            <div class="item" id="map1-map4"></div>
            <div class="item" id="map1-map5"></div>
        </div>
    </div>
</template>
<style lang="less">
#map1{
    overflow:hidden;
    height:997.5px;
    .item{
        float: left;
    }
    #map1-map1,#map1-map2{
        width: 466px;
        height: 415px;
        box-sizing: border-box;
        padding:10px;
        border:2px solid #2c3e65;
    }
    #map1-map3{
        width: 466px;
        height: 415px;
        box-sizing: border-box;
        padding:10px;
        border:2px solid #2c3e65;
    }
    #map1-map4{
        width: 785px;
        height: 510px;
    }
    #map1-map5{
        width: 350px;
        height: 280px;
        margin-top: 130px;
    }
}
</style>
<script type="text/ecmascript-6">
    import {demo,color,colorD,textStyle,labelStyle,seriesLabelStyle,itemHeight,itemWidth,axisLabel,axisLine} from '../../assets/js/demoCharts'
    import echarts from 'echarts'

    const map1 =  {
        name: '端口数量',
        type: 'pie',
        radius: ['20%', '65%'],
        center: ['50%', '50%'],
        roseType: 'radius',
        data: demo.map1.map1,
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c}个 ({d}%)"
        },
        label: {
            normal: {
                show: true,
                textStyle:{
                    color:'#FFF',
                    fontSize: 20
                },
                position: 'inside',
                formatter:'{c}'
            },
            emphasis: {
                show: true
            }
        },
        lableLine: {
            normal: {
                show: false
            },
            emphasis: {
                show: false
            }
        },
        itemStyle: {
            normal:{
                color: function (params){
                    return color[params.dataIndex];
                }
            },
            emphasis: {
                shadowBlur: 10,
                shadowOffset: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        }
    }
    const map2 = {
        name: '带宽',
        type: 'pie',
        radius: ['45%', '65%'],
        center: ['50%', '50%'],
        data: demo.map1.map2,
        avoidLabelOverlap: false,
        label: {
            normal: {
                show: true,
                position: 'inside',
                textStyle:{
                    color:'#FFF',
                    fontSize: 20
                },
                formatter:'{c}'
            },
            emphasis: {
                show: true,
            }
        },
        labelLine: {
            normal: {
                show: false
            }
        },
        itemStyle: {
            normal:{
                color: function (params){
                    return color[params.dataIndex];
                }
            },
            emphasis: {
                shadowBlur: 10,
                shadowOffset: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c}Tbps ({d}%)"
        },
    }
    const map3 = {
        name: '流量',
        type: 'bar',
        label: {
            normal: {
                show: true,
                position: 'top',
                textStyle:seriesLabelStyle.textStyle,
                formatter: function(data){
                    return `${data.name}\n${data.data}`
                }
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c}Tbps"
        },
        itemStyle:{
            normal:{
                color: function (params){
                    return color[params.dataIndex];
                }
            }
        },
        barWidth:'auto',
        data:demo.map1.map3
    }
    let data = (type,res,index)=>{
        let array = [];
        res.map((item)=>{
            if(item.name==res[index].name){
                array.push({
                    name: item.name,
                    value: item.value[type],
                    selected:true
                })
            }else{
                array.push({
                    name: item.name,
                    value: item.value[type]
                })
            }
        })
        return array;
    }
    let series = (res,index)=>{
        let array = [];
        let labelArray = [{name:'统建CDN',item:'统建CDN'},{name:'IDC',item:'IDC'},{name:'Cache',item:'Cache'},{name:'省建OTT',item:'省建OTT'},{name:'',item:''}]
        for(let i=0;i<labelArray.length;i++){
            array.push({
                name: labelArray[i].name,
                type: 'map',
                mapType: 'china',
                selectedMode : 'single',
                zoom:1.4,
                roam: false,
                label: {
                    normal: { show: false},
                    emphasis: { show: false}
                },
                itemStyle: {
                    normal: {
                        color: color[labelArray[i].name],
                        areaColor: '#1d2b46',
                        borderColor: 'rgba(100,149,237,1)',
                        opacity: '0.6'
                    },
                    emphasis: {
                        areaColor: '#ff9e40',
                        shadowColor: 'rgba(0, 0, 0, 0.5)',
                        shadowBlur: 10,
                        opacity: '0.8'
                    }
                },
                data:data(labelArray[i].item,res,index)
            })
        }
        return array;
    }
    let option = {
        backgroundColor: '#1d2b46',
        title:{
            text:'全网地图流量/Gbps',
            textStyle,
            right:20,
            top:20
        },
        right:20,
        zoom:1.4,
        visualMap: {
            min: 0,
            max: 2500,
            left: '5%',
            top: 'center',
            text: ['高','低'],
            calculable: false,
            inRange: {
                color: ['#1d2b46', '#205dda']
            },
            textStyle:{
                color:'#5971a3'
            }
        },
        legend: {
            orient: 'horizontal',
            right: 0,
            bottom: 10,
            itemWidth,
            itemHeight,
            textStyle:labelStyle.textStyle,
            data:['CDN','IDC','Cache','OTT'],
        },
        tooltip:{
            trigger: 'item',
            backgroundColor:'rgba(255,255,255,0.9)',
            padding:10,
            textStyle:{
                color: '#333'
            },
            formatter: function(obj){
                let data = demo.map1.map4[obj.dataIndex];
                return `<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 16px;padding-bottom: 7px;margin-bottom: 7px">
                            全网流量地图
                        </div>
                        省份：${data.name}<br/>
                        <b class="echart-circle" style="background: ${Object.values(color)[0]}"></b>CDN：${data.value.CDN}Gbps<br />
                        <b class="echart-circle" style="background: ${Object.values(color)[1]}"></b>IDC：${data.value.IDC}Gbps<br />
                        <b class="echart-circle" style="background: ${Object.values(color)[2]}"></b>Cache：${data.value.Cache}Gbps<br />
                        <b class="echart-circle" style="background: ${Object.values(color)[3]}"></b>OTT：${data.value.PCache}Gbps<br />
                        <b class="echart-circle" style="background: #0063dd"></b>总计流量：${(data.value.CDN+data.value.IDC+data.value.Cache+data.value.PCache).toFixed(2)}Gbps<br />
                        `
            }
        },
        series: series,
    };
    export default{
        data(){
            return {
                obj:{},//全网流量 3个图
                obj2:{},//全国流量 地图
                run:true,
            }
        },
        methods:{
            drawrose(id,res,title) {
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title : {
                        text: title,
                        textStyle,
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        }
                    },
                    legend: {
                        orient: 'horizontal',
                        left: 'center',
                        bottom: 0,
                        textStyle:labelStyle.textStyle,
                        itemWidth,
                        itemHeight,
                        data: ['统建CDN','IDC','Cache','省建OTT'],
                    },
                    calculable: true,
                    series:{
                        name: '端口数量',
                        type: 'pie',
                        radius: ['20%', '65%'],
                        center: ['50%', '50%'],
                        roseType: 'radius',
                        data: res,
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c}个 ({d}%)"
                        },
                        label: {
                            normal: {
                                show: true,
                                textStyle:{
                                    color:'#FFF',
                                    fontSize: 20
                                },
                                position: 'inside',
                                formatter:'{c}'
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        lableLine: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: false
                            }
                        },
                        itemStyle: {
                            normal:{
                                color: function (params){
                                    console.log(params)
                                    return color[params.name];
                                }
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
            drawrose2(id,res,title,legend){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title : {
                        text: title,

                        textStyle,
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        }
                    },
                    legend: {
                        orient: 'horizontal',
                        left: 'center',
                        bottom: 0,
                        textStyle:labelStyle.textStyle,
                        itemWidth,
                        itemHeight,
                        data: ['统建CDN','IDC','Cache','省建OTT'],
                    },
                    calculable: true,
                    series:{
                        name: '带宽',
                        type: 'pie',
                        radius: ['45%', '65%'],
                        center: ['50%', '50%'],
                        data: res,
                        avoidLabelOverlap: false,
                        label: {
                            normal: {
                                show: true,
                                position: 'inside',
                                textStyle:{
                                    color:'#FFF',
                                    fontSize: 20
                                },
                                formatter:'{c}'
                            },
                            emphasis: {
                                show: true,
                            }
                        },
                        labelLine: {
                            normal: {
                                show: false
                            }
                        },
                        itemStyle: {
                            normal:{
                                color: function (params){
                                    return color[params.name];
                                }
                            },
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffset: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c}Tbps ({d}%)"
                        },
                    }
                });
            },
            drawbar(id,res,title,subtitle,legend,max){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title : {
                        text: title,
                        subtext:subtitle,
                        textStyle,
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        }
                    },
                    grid:{
                        top:100
                    },
                    calculable: true,
                    series: {
                        name: '流量',
                        type: 'bar',
                        label: {
                            normal: {
                                show: true,
                                position: 'top',
                                textStyle:seriesLabelStyle.textStyle,
                                formatter: function(data){
                                    return `${data.name}\n${data.value}`
                                }
                            }
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c}Tbps"
                        },
                        itemStyle:{
                            normal:{
                                color: function (params){
                                    return color[params.name];
                                }
                            }
                        },
                        barWidth:'auto',
                        data:res
                    } ,
                    xAxis: [
                        {
                            type: 'category',
                            boundrayGap: false,
                            axisLine:{
                                show: false
                            },
                            show:false,
                            splitNumber: 4,
                            data:['统建CDN','IDC','Cache','省建OTT']
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value',
                            max: max,
                            nameLocation: 'middle',
                            nameGap:30,
                            show:false
                        }
                    ],
                });
            },
            drawmap(id,res,index,legend){
                let that = this;
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    backgroundColor: '#1d2b46',
                    title:{
                        text:'全网实时流量',
                        subtext:'单位:Gbps,5分钟数据',
                        textStyle,
                        right:20,
                        top:20
                    },
                    right:20,
                    zoom:1.4,
                    visualMap: {
                        min: 0,
                        max: 2500,
                        left: '5%',
                        top: 'center',
                        text: ['高','低'],
                        calculable: false,
                        inRange: {
                            color: ['#1d2b46', '#205dda']
                        },
                        precision:2,
                        textStyle:{
                            color:'#5971a3'
                        }
                    },
                    legend: {
                        orient: 'horizontal',
                        right: 0,
                        bottom: 10,
                        itemWidth,
                        itemHeight,
                        textStyle:labelStyle.textStyle,
                        data:['统建CDN','IDC','Cache','省建OTT'],
                    },
                    tooltip:{
                        trigger: 'item',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        },
                        formatter: function(obj){
//                            let data = demo.map1.map4[obj.dataIndex];
                            let data = res[obj.dataIndex];
                            return `<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 16px;padding-bottom: 7px;margin-bottom: 7px">
                            全网流量地图
                        </div>
                        省份：${data.name}<br/>
                        <b class="echart-circle" style="background: ${color['统建CDN']}"></b>统建CDN：${data.value['统建CDN']}Gbps<br />
                        <b class="echart-circle" style="background: ${color['IDC']}"></b>IDC：${data.value.IDC}Gbps<br />
                        <b class="echart-circle" style="background: ${color['Cache']}"></b>Cache：${data.value.Cache}Gbps<br />
                        <b class="echart-circle" style="background: ${color['省建OTT']}"></b>省建OTT：${data.value['省建OTT']}Gbps<br />
                        <b class="echart-circle" style="background: #0063dd"></b>总计流量：${(data.value['统建CDN']+data.value.IDC+data.value.Cache+data.value['省建OTT']).toFixed(2)}Gbps<br />
                        `
                        }
                    },
                    series: series(res,index)
                });
                this.chart.on('click',function(data){
                    that.drawTbra(data,res);
                });
            },
            drawTbra(data,res,legend){
                let {name,dataIndex} = data;
                let seriesData = [
                    {
                        name:`${name}`,
                        type: 'bar',
                        data:this.sortY(res[dataIndex].value)
                    }
                ];
                let option = {
                    title: {
                        text: `${name}流量数据`,
                        left: 'center',
                        textStyle:{
                            color:'#feffff',
                            fontSize:18,
                            fontWeight:'normal'
                        }
                    },
                    tooltip: {
                        trigger: 'item',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        },
                        formatter:(item)=>{
                            console.log(item);
                            return `<div style="border-bottom: 1px solid rgba(255,255,255,.3); font-size: 16px;padding-bottom: 7px;margin-bottom: 7px">${name}流量数据</div>
                                    ${item.name}:${item.value}Gbps<br/>`
                        }
                    },
//                    legend: {
//                        data: ['统建CDN','IDC','Cache','省建OTT'],
//                        textStyle:labelStyle.textStyle,
//                    },
                    grid: {
                        left: '25%',
//                        right: '4%',
//                        bottom: '3%',
//                        containLabel: true
                    },
                    itemStyle:{
                        normal:{
                            color: function (params){
                                return color[params.name]
                            }
                        }
                    },
                    barWidth: '60%',
                    xAxis: {
                        type: 'value',
                        boundaryGap: [0, 0.01],
                        axisLine,
                        splitLine:{
                            lineStyle:axisLine.lineStyle,
                            show:false,
                        },
                        axisLabel:{
                            show:true,
                            textStyle:{
                                color: '#c0c6c4',
                                fontSize: 14
                            },
                            interval:0
                        }
                    },
                    yAxis: {
                        type: 'category',
                        data: ['统建CDN','IDC','Cache','省建OTT'],
                        inverse:true,
                        axisLine,
                        splitLine:{
                            lineStyle:axisLine.lineStyle
                        },
                        axisLabel
                    },
                    series:seriesData
                };
                this.chart = echarts.init(document.getElementById('map1-map5'));
                this.chart.setOption(option);
            },
            mouseIn(){
                this.run = false;
            },
            mouseOut(){
                this.run = true;
            },
            sortY(res){
                let array = ['统建CDN','IDC','Cache','省建OTT'];
                let arr = [];
                array.map(item=>{
                    arr.push(res[item])
                })
                console.log(arr)
                return arr;
            },
            getLegend(array){
                let arr =[];
                array.map(item=>{
                    arr.push(item.name);
                })
                return arr;
            },
            sortDataY(array){
                let arr = ['统建CDN','IDC','Cache','省建OTT'];
                let arr2 = [];
                arr.map(imm=>{
                    array.map(item=>{
                        if(imm==item.name){
                            arr2.push({
                                name:item.name,
                                value:item.value
                            })
                        }
                    })
                })
                return arr2;
            },
            getMax(array){
                let arr = [];
                array.map(item=>{
                    arr.push(item.value);
                })
                let maxN = Math.max.apply(null,arr);
                return maxN;
            }
        },
        mounted(){
            this.$nextTick(function(){
                this.$http.get('/data/showdatajson?child=qwll&name=qwll').then((res)=>{
                    this.obj = res.data;
                }).then((res)=>{
                    this.drawrose('map1-map1',this.sortDataY(this.obj.qwll.port),'端口',this.getLegend(this.obj.qwll.port));
                    this.drawrose2('map1-map2',this.sortDataY(this.obj.qwll.dk),'带宽/Tbps','单位:Tbps,5分钟数据',this.getLegend(this.obj.qwll.dk));
                    this.drawbar('map1-map3',this.sortDataY(this.obj.qwll.ll),'当前流量','单位:Tbps,5分钟数据',this.getLegend(this.obj.qwll.ll),this.getMax(this.obj.qwll.ll));
                }).catch((res)=>{
                    console.log(res);
                });

                this.$http.get('/data/showdatajson?child=qwll&name=qgll').then((res)=>{
                    this.obj2 = res.data;
                }).then(res=>{
                    this.drawmap('map1-map4',this.obj2.qgll,0,this.getLegend(this.obj2.qgll));
                    this.drawTbra({
                        name:this.obj2.qgll[0].name,
                        dataIndex: 0
                    },this.obj2.qgll,this.getLegend(this.obj2.qgll));
                }).then(res=>{
                    setInterval(()=>{
                        if(this.run ==true){
                            let i = parseInt(Math.random()*31);
                            this.drawmap('map1-map4',this.obj2.qgll,i);
                            this.drawTbra({
                                dataIndex:i,
                                name:this.obj2.qgll[i].name
                            },this.obj2.qgll);
                        }
                    },10000);
                }).catch(res=>{
                    console.log('error'+res);
                })
            })
        }
    }
</script>
