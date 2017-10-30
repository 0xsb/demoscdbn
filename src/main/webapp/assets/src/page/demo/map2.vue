<template>
    <div id="map2">
        <div class="map-container h360 clearfix">
            <div class="item border" id="map2-map1">
                <h2>采集CP/个</h2>
                <div class="num-map">
                    <rollNum :num="liuliangnum"></rollNum>
                </div>
                <!--<div class="num-map">
                    <div class="num-con" ><ul :class="{move:flag}"><li>0</li><li v-for="index in 9">{{index}}</li><li>0</li><li v-for="index in 9">{{index}}</li><li>0</li><li v-for="index in 9">{{index}}</li></ul></div>
                    <div class="num-con" ><ul :class="{move:flag}"><li>0</li><li v-for="index in 9">{{index}}</li><li>0</li><li v-for="index in 9">{{index}}</li><li>0</li><li v-for="index in 9">{{index}}</li></ul></div>
                    <div class="num-con" ><ul :class="{move:flag}"><li>0</li><li v-for="index in 9">{{index}}</li><li>0</li><li v-for="index in 9">{{index}}</li><li>0</li><li v-for="index in 9">{{index}}</li></ul></div>
                    <div class="num-con" ><ul :class="{move:flag}"><li>0</li><li v-for="index in 9">{{index}}</li><li>0</li><li v-for="index in 9">{{index}}</li><li>0</li><li v-for="index in 9">{{index}}</li></ul></div>
                </div>-->

            </div>
            <div class="item border" id="map2-map2"></div>
            <div class="item border" id="map2-map3"></div>
        </div>
        <ul class="goods"  @mouseover='mouseIn()'  @mouseout="mouseOut()">
            <!--<li v-for="(item,index) in data" class="map-icon" @click="check(index)" :class="['map-icon-'+changeName(item.name),{'active':index==mapindex}]"></li>-->
            <li v-for="(item,index) in data" class="map-icon" @click="check(index)" :class="['map-icon-'+index,{'active':index==mapindex}]"></li>
        </ul>
        <div class="map-container clearfix border"  @mouseover='mouseIn()'  @mouseout="mouseOut()">
            <div class="left" style="width:675px;height:528.5px">
                <div id="map2-map4"></div>
                <div id="map2-map5"></div>
            </div>
            <div class="map-container left clearfix " style="width: 568.5px;height:528.5px;">
                <div class="item " style="width: 650px" id="map2-map6"></div>
            </div>
        </div>
    </div>
</template>
<style lang="less">
    #map2{
        overflow:hidden;
        height:997.5px;
    .item{
        float: left;
    h2{
        font-size: 22px;
        margin-top: 15px;
        color: #FFF;
        text-align: center;
        font-weight: normal;
        font-family: "微软雅黑", sans-serif;
    }
    }

    .num-map{
        width: 240px;
        margin: 70px auto;
    .num-con{
        display: inline-block;
        width: 55px;
        height: 100px;
        position: relative;
        overflow: hidden;
    &:first-of-type ul.move{
         animation: top1 1.5s ease forwards;
     }
    &:nth-child(2) ul.move{
         animation: top2 1.5s ease forwards;
     }
    &:nth-child(3) ul.move{
         animation: top3 1.5s ease forwards;
     }
    &:nth-child(4) ul.move{
         animation: top4 1.5s ease forwards;
     }
    }
    ul{
        position: absolute;
        top:0;
        width: 55px;
        font-size: 80px;
        color: #F0F0F0;
        height: 100px;
    li{
        height: 100px;
        line-height: 100px;
        text-align: center;
    }
    }
    @keyframes top1{
        100% {top:-1000px}
    }
    @keyframes top2{
        100% {top:-1100px}
    }
    @keyframes top3{
        100% {top:-2000px}
    }
    @keyframes top4{
        100% {top:-2100px}
    }
    .num-info{
        height: 100px;
        line-height: 100px;
        font-size: 54px;
        text-align: center;
        font-weight: bold;
        display: inline-block;
        position: absolute;
        top:0;
    }
    }
    #map2-map1,#map2-map2{
        width: 386.5px;
        height: 297.5px;
    }
    #map2-map3{
        width: 612.5px;
        height: 297.5px;
    }
    #map2-map4{
        width: 675px;
        height: 262.5px;
        float: none;
    }
    #map2-map5{
        height: 262.5px;
        width: 675px;
        float: none;
    }
    .goods{
        padding: 20px;
        border:2px solid #2c3e65;
        border-top:0px;
        border-bottom:0px;
    li{
        display: inline-block;
        margin-left: 20px;
        width: 113px;
        height: 113px;
        cursor:pointer;
    &:hover,&.active{
                 border:2px solid #52a5f7;
             }
    }
    .map-icon-0{
        background: url(../../assets/imgs/map-icon-0.png) no-repeat;
        background-size:contain;
    }
    .map-icon-1{
        background: url(../../assets/imgs/map-icon-1.png) no-repeat;
        background-size:contain;
    }
    .map-icon-2{
        background: url(../../assets/imgs/map-icon-2.png) no-repeat;
        background-size:contain;
    }
    .map-icon-3{
        background: url(../../assets/imgs/map-icon-3.png) no-repeat;
        background-size:contain;
    }
    .map-icon-4{
        background: url(../../assets/imgs/map-icon-4.png) no-repeat;
        background-size:contain;
    }
    .map-icon-5{
        background: url(../../assets/imgs/map-icon-5.png) no-repeat;
        background-size:contain;
    }
    .map-icon-6{
        background: url(../../assets/imgs/map-icon-6.png) no-repeat;
        background-size:contain;
    }
    .map-icon-7{
        background: url(../../assets/imgs/map-icon-7.png) no-repeat;
        background-size:contain;
    }
    .map-icon-8{
        background: url(../../assets/imgs/map-icon-8.png) no-repeat;
        background-size:contain;
    }
    .map-icon-9{
        background: url(../../assets/imgs/map-icon-9.png) no-repeat;
        background-size:contain;
    }
    }

    }
</style>
<script type="text/ecmascript-6">
    import echarts from 'echarts'
    import china from 'echarts/map/js/china'
    import rollNum from '../../components/common/rollNum.vue'
    import {seller,column,demo,textStyle,labelStyle,seriesLabelStyle,itemHeight,itemWidth,axisLabel,axisLine,timeData,timeValue,provinceData} from '../../assets/js/demoCharts'
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
                data:demo.map2.map4,
                mapindex: 0,
                flag:true,
                dataArray:[],  //map5,
                xArias:[],//map5
                liuliangnum: '',  // map 1
                daikuan:0, //map2
                icpllTop:[], //map3
                MapData:[],  //map4 map6
                ProvinceData:[],   //map4 map6
                run: true,
                step: 10000
            }
        },
        methods:{
            init(){     //初始化假数据    暂时没用
                let data = [];
                seller.map((item)=>{
                    data.push({
                        name: item
                    })
                });
                return data;
            },
            getMapData(name){
                let array = [];
                this.MapData.map(i=>{
                    array.push(i[name])
                });
                return array;
            },
            getAreaData(name){
                let array = [];
                this.MapData.map(i=>{
                    array.push({
                        name: i.name,
                        value: i[name]
                    })
                });
                return array;
            },
            drawrose(id,res,max,title) {     //带宽环形图
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title : {
                        text: `${title}/Tbps`,
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
                    legend: {
                        orient: 'horizontal',
                        left: 'center',
                        bottom: 0,
                        data: ['IDC','CDN','CACHE','OTT'],
                    },
                    calculable: true,
                    series: {
                        name: '带宽',
                        type: 'pie',
                        radius: ['45%', '60%'],
                        center: ['50%', '50%'],
                        data: [
                            res,
                            {
                                value:(max-res.value).toFixed(1),
                                name:'invisible',
                                itemStyle : placeHolderStyle
                            }
                        ],
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c}T"
                        },
                        avoidLabelOverlap: false,
                        label: {
                            normal: {
                                show: true,
                                position: 'center',
                                textStyle: {
                                    fontSize: '24',
                                    fontWeight: 'normal',
                                },
                                formatter: "{c}T"
                            },
                            emphasis: {
                                show: true,
                                textStyle: {
                                    fontSize: '24',
                                    fontWeight: 'normal'
                                }
                            }
                        },
                        itemStyle: {
                            normal:{
                                color: '#ffb54c'
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
            drawbar(id,name,value,title){       //ICP柱状图
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title : {
//                        text: `${title}/Tbps`,
                        text:title,
                        subtext:'单位:Tbps,5分钟数据',
                        textStyle,
                        top:20,
                        left: 'center'
                    },
                    color: ['#3398DB'],
                    tooltip : {
                        trigger: 'item',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#000'
                        },
                    },
                    xAxis : [
                        {
                            show:true,
                            type: 'category',
                            data: name,
                            axisLine,
                            axisLabel: {
                                show:true,
                                interval:0,
                                textStyle: {
                                    color: '#c0c6c4'
                                }
                            },
                        }
                    ],
                    yAxis : [
                        {
                            show:true,
                            name: 'Tbps',
                            nameLocation: 'middle',
                            nameGap: '25',
                            type:'value',
                            axisLine,
                            axisLabel: {
                                textStyle: {
                                    color: '#c0c6c4'
                                }
                            },
                            splitLine:{
                                show:false
                            }
                        }
                    ],
                    barWidth:30,
                    label: {
                        normal: {
                            show: true,
                            position: 'top',
                            textStyle:{
                                color:'#FFF'
                            },
                            formatter: function(data){
                                return `${data.name}\n${data.value}`
                            }
                        },
                        emphasis:{
                            show:true,
                            position: 'top',
                            textStyle:{
                                color:'#FFF'
                            },
                            formatter: function(data){
                                return `${data.name}\n${data.value}`
                            }
                        }
                    },
                    itemStyle:{
                        normal:{
                            color: function (params){
                                return Object.values(demo.colorTen)[params.dataIndex]
                            }
                        }
                    },
                    series: [
                        {
                            name:'ICP流量TOP10',
                            type: 'bar',
                            data: value
                        }
                    ]
                });
            },
            drawpro(id,res,title) {       //分省流量柱状图
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title:{
                        text:`分省实时流量`,
                        subtext:`单位:Gbps,5分钟数据`,
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
                            axisLabel,axisLine,
                            type: 'value',
                            name: 'Gbps',
                            splitLine:{
                                show:false
                            },
                        }
                    ],
                    legend:{
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
                    },
                    series: [
                        {
                            name: `${title}`,
                            type: 'bar',
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
                            data: res
                        }
                    ]
                });
            },
            drawarea(id,data,title,xArias){        //分时流量折线图
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title:{
                        text:`分时流量`,
                        subtext:`单位:Gbps,5分钟数据`,
                        textStyle,
                        top:20,
                        left:'center'
                    },
                    tooltip: {
                        trigger: 'axis',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        },
                        axisPointer: {
                            type: 'cross',
                            label: {
                                backgroundColor: '#6a7985'
                            }
                        },
                        /*formatter: function formatter(data) {
                            if (data[0].dataIndex == 24 || data[0].dataIndex == 0) {
                                if (data[0].dataIndex == 24) {
                                    return "今日" + data[0].dataIndex + "时"+'</br>'+data[0].marker+data[0].seriesName+":" + data[0].value;
                                }
                                if (data[0].dataIndex == 0) {
                                    return "昨日" + data[0].dataIndex + "时" +'</br>'+data[0].marker+data[0].seriesName+":"+ data[0].value;
                                }
                            } else {
                                if (data[0].dataIndex > 24) {
                                    return data[0].dataIndex - 24 + "时"+'</br>'+data[0].marker+data[0].seriesName+":" + data[0].value;
                                }
                                return data[0].dataIndex + "时"+'</br>'+data[0].marker+data[0].seriesName+":" + data[0].value;
                            }
                        }*/
                    },
                    legend:{
                        show:true,
                        data:[title],
                        right:'10%',
                        itemWidth:15,
                        itemHeight:15,
                        top:20,
                        textStyle:{
                            color:'#FFF',
                            fontSize: 14
                        },
//                        formatter:'{b}:{c}%',
                    },
                    grid:{
                        show:false,
                        bottom:'24%',
                    },
                    xAxis: [
                        {
                            type:'category',
                            boundaryGap:false,
                            show:true,
                            axisLabel: {
                                show:true,
                                interval:((xArias.length-1)/24*6)-1,
                                textStyle:{
                                    color: '#c0c6c4',
                                },
                            },
                            axisLine,
//                            data: this.timeColumn(),
                            data:xArias,
                            splitLine: {
                                show: false
                            },
//                            nameGap:0,
                        }
                    ],
                    yAxis: [
                        {
                            show:true,
                            type:'value',
                            name: 'Gbps',
                            axisLabel,
                            axisLine,
                            splitLine:{
                                show:false
                            }
                        }
                    ],
                    series: [
                        {
                            name: `${title}`,
                            type: 'line',
                            areaStyle: {normal: {}},
                            itemStyle:{
                                normal:{
                                    color: '#52a5f7'
                                }
                            },
                            smooth:true,
                            showSymbol:true,
                            symbol: 'circle',
//                            symbolSize: 10,
                            data: data
                        }
                    ]
                });
            },
            drawmap(id,title,data,max){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    backgroundColor: '#1d2b46',
                    title:{
                        text:`实时流量地图`,
                        subtext:`单位:Gbps,5分钟数据`,
                        textStyle,
                        right:20,
                        top:20,
                        left: 'center'
                    },
                    right:20,
                    zoom:2,
                    legend:{
                        show:true,
                        data:[title],
                        itemWidth:15,
                        itemHeight:15,
                        top:60,
                        right:'3%',
                        textStyle:{
                            color:'#FFF',
                            fontSize: 14
                        },
                    },
                    visualMap: {
                        min: 0,
                        max: max==0?max+1:max,
                        right: '5%',
                        precision:2,
                        top: 'center',
                        text: ['高','低'],
                        calculable: false,
                        inRange: {
                            color: ['#1d2b46', '#affd87']
                        },
                        textStyle:{
                            color:'#5971a3'
                        }
                    },
                    tooltip:{
                        trigger: 'item',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        },
                    },
                    series: {
                        name: `${title}`,
                        type: 'map',
                        map: 'china',
                        zoom: 1.6,
                        roam: false,
                        top: '25%',
                        right: 0,
                        label: {
                            normal: { show: false},
                            emphasis: { show: false}
                        },
                        itemStyle: {
                            normal: {
                                color: '#affd87',
                                areaColor: '#9bfc71',
                                borderColor: 'rgba(100,149,237,1)',
                                opacity: '0.6'
                            },
                            emphasis: {
                                areaColor: '#70e9a3',
                                shadowColor: 'rgba(0, 0, 0, 0.5)',
                                shadowBlur: 10,
                                opacity: '0.8'
                            }
                        },
                        data: data
                    },
                })
            },
            check(index){
                //切换
                this.mapindex = index;
                let title = this.data[index].name;
                let obj = {
                    '腾讯':'tengxun',
                    '爱奇艺':'aiqiyi',
                    '阿里巴巴':'alibaba',
                    '优酷土豆网':'youku',
                    '百度':'baidu',
                    '乐视网':'leshi',
                    '芒果TV':'mangguo',
                    '金山网络':'jinshan',
                    '搜狐':'souhu',
                    '新浪':'xinlang',
                };
                let areaData = this.getMapData(obj[title]);
                let maxNum = areaData.sort((a,b)=>{
                    return a-b;
                });
                this.drawarea('map2-map5',this.getTimeData(obj[title]),title,this.xArias);
                this.drawpro('map2-map4',this.getMapData(obj[title]),title);
                this.drawmap('map2-map6',title,this.getAreaData(obj[title]),maxNum[30]);
            },
            getTimeData(name){
                let array = [];
                this.dataArray.map(i=>{
                    array.push(i[name]);
                })
                return array;
            },
            getDataRank(array){
                let func = ((a,b)=>{
                    return b.value-a.value;
                });
                array.sort(func);
                return array;
            },
            getNameRank(array){
                let arr = [];
                this.getDataRank(array).map(item=>{
                    arr.push(item.name);
                });
                return arr;
            },
            getValueRank(array){
                let arr = [];
                this.getDataRank(array).map(item=>{
                    arr.push(item.value);
                });
                return arr;
            },
            dealValue(obj){
                let len = (parseInt(obj.value)).toString().length;
                let num = Math.pow(10, len - 1);
                return num * (Math.floor(obj.value / num) + 1);
            },
            resetMap(){
                if(this.run){
                    this.mapindex++;
                    if(this.mapindex == 10){
                        this.mapindex = 0;
                    }
                    this.check(this.mapindex);
                }
            },
            mouseIn(){
                this.run = false;
            },
            mouseOut(){
                this.run = true;
            },
            /*timeColumn(){
                let array = [];
                let i=0;
                let str = '';
                this.dataArray.map(item=>{
                    i++;
                    if (i == 1 ) {
                        str = '昨日' + item.time.slice(1, 2) + '时';
                    }
                    if(i == 25 ) {
                        str = '今日' + item.time.slice(1, 2) + '时';
                    }
                    if(i!=1&&i!=25){
                        if((i<=24&&i>=10)||(i>=36&&i<=48)){
                            str = item.time.slice(1,3)
                        }else{
                            str = item.time.slice(1,2);
                        }
                    }
                    array.push(str);
                })
                return array;
            },*/
            timeColumn(){
                let array = [];
                this.dataArray.map(item=>{
                    array.push(item.time);
                });
            },
            getMax(){
                let areaData = this.getMapData('tengxun');
                let maxNum = areaData.sort((a,b)=>{
                    return a-b;
                });
                return maxNum[30];
            }
        },
        mounted(){
            this.$nextTick(function(){
                this.$http.get('/data/showdatajson?child=hlwll&name=cjdk').then(res=>{
                    this.liuliangnum = res.data.cjdk.caiji.value;
                    this.daikuan = res.data.cjdk.daikuan;
                }).then(()=>{
                    this.drawrose('map2-map2',this.daikuan,this.dealValue(this.daikuan),'带宽');
                }).catch(res=>{
                    console.log(res);
                })

                this.$http.get('/data/showdatajson?child=hlwll&name=lltop').then(res=>{
                    this.icpllTop = res.data.lltop;
                }).then(()=>{
                    this.drawbar('map2-map3',this.getNameRank(this.icpllTop),this.getValueRank(this.icpllTop),'ICP实时流量TOP10');
                }).catch(res=>{
                    console.log(res);
                })

                this.$http.get('/data/showdatajson?child=hlwll&name=lldt').then(res=>{
                    this.MapData = res.data.lldt;
                }).then(()=>{
                    this.drawpro('map2-map4',this.getMapData('tengxun'),'腾讯');
                    this.drawmap('map2-map6','腾讯',this.getAreaData('tengxun'),this.getMax());
                }).catch(res=>{
                    console.log(res);
                })

                this.$http.get('/data/showdatajson?child=hlwll&name=fsll').then(res=>{
                    this.dataArray = res.data.fsll;
                    this.xArias = res.data.xzhou;
                }).then(res=>{
                    this.drawarea('map2-map5',this.getTimeData('tengxun'),'腾讯',this.xArias);
                })
                window.setInterval(this.resetMap, this.step);
            })
        },
        beforeDestroy(){
            this.run = false;
        },
        components:{
            rollNum
        },
    }
</script>

