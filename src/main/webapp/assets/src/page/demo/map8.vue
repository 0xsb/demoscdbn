<template>
    <div id="map8" @mouseover='mouseIn()'  @mouseout="mouseOut()">
        <ul class="goods">
            <!--<li v-for="(value,key,index) in data" class="liuliang-icon" @click="check(index)" :class="['liuliang-icon-'+key,{'active':index==mapindex}]"><span class="goods-title">{{value.title}}</span></li>-->
            <!--<li v-for="(item,index) in data" class="liuliang-icon" @click="check(index)" :class="['liuliang-icon-'+(arrayName.indexOf(index)+1),{'active':arrayName.indexOf(index)==mapindex}]"><span class="goods-title">{{item.title}}</span></li>-->
            <li v-for="(item,index) in arrayName" class="liuliang-icon" @click="check(index)" :class="['liuliang-icon-'+(index+1),{'active':index==mapindex}]"><span class="goods-title">{{changeName(item)}}</span></li>
        </ul>
        <div class="map8-content">
            <h2 id="title">{{mapName}} - 流量分析</h2>
            <ul class="map8-desc">
                <li class="desc-item richang">
                    <span class="rollImg"></span>
                    <div class="roll-content">
                        <span class="rollTitle">全国日常流量</span>
                        <br /><rollNum :num="richang"></rollNum>
                        <span class="rollTitle ml-10" style="height: 60px; line-height: 60px">{{flag}}</span>
                    </div>
                </li>
                <li class="desc-item shishi">
                    <span class="rollImg"></span>
                    <div class="roll-content">
                        <span class="rollTitle">全国实时流量</span>
                        <br /><rollNum :num="shishi"></rollNum>
                        <span class="rollTitle ml-10" style="height: 60px; line-height: 60px">{{flag}}</span>

                    </div>
                </li>
            </ul>
            <div id="map8-map1">

            </div>
        </div>
    </div>
</template>
<style lang="less">
    #map8{
        border:2px solid #2c3e65;
    .goods{
        padding: 52.5px 20px;
    li{
        display: inline-block;
        position: relative;
        margin-left: 20px;
        padding: 23px;
        width: 128px;
        height: 128px;
        cursor:pointer;
    &:hover,&.active{
                 border:2px solid #52a5f7;
             }
    .goods-title{
        text-align: center;
        position: absolute;
        bottom: 0;
        color: #7e8699;
        font-size: 18px;
        width: 100%;
        left: 0;
    }
    }
    .liuliang-icon-1{
        background: url(../../assets/imgs/liuliang-icon-1.png) no-repeat center;
        background-size:57%;
    }
    .liuliang-icon-2{
        background: url(../../assets/imgs/liuliang-icon-2.png) no-repeat center;;
        background-size:57%;
    }
    .liuliang-icon-3{
        background: url(../../assets/imgs/liuliang-icon-3.png) no-repeat center;;
        background-size:57%;
    }
    .liuliang-icon-4{
        background: url(../../assets/imgs/liuliang-icon-4.png) no-repeat center;;
        background-size:57%;
    }
    .liuliang-icon-5{
        background: url(../../assets/imgs/liuliang-icon-5.png) no-repeat center;;
        background-size:57%;
    }
    .liuliang-icon-6{
        background: url(../../assets/imgs/liuliang-icon-6.png) no-repeat center;;
        background-size:57%;
    }
    .liuliang-icon-7{
        background: url(../../assets/imgs/liuliang-icon-7.png) no-repeat center;;
        background-size:57%;
    }
    .liuliang-icon-8{
        background: url(../../assets/imgs/liuliang-icon-8.png) no-repeat center;;
        background-size:57%;
    }
    .liuliang-icon-9{
        /*background: url(../../assets/imgs/liuliang-icon-9.png) no-repeat center;;*/
        background-size:57%;
    }
    }
    #title{
        text-align: center;
        margin: 0 auto;
        font-size: 24px;
        color: #FFF;
        padding: 30px;
        background: #1d2b46;
        position: absolute;
        top:-50px;
        left: 40%;
    }
    .map8-content{
        width: 1380px;
        margin: 0 auto;
        position: relative;
        border: 2px solid #2c3e65;
    }
    .map8-desc{
        padding: 43px 0;
        font-size: 20px;
        color: #FFF;
    .richang{
        border-right:2px solid #2c3e65;
    }
    .richang .rollImg{
        background: url(../../assets/imgs/richang-bg.png) no-repeat center;
        background-size: 80%;
        margin-left: 30%;
        width: 100px;
        height: 100px;
        float: left;
    }
    .shishi .rollImg{
        background: url(../../assets/imgs/shishi-bg.png) no-repeat center;
        background-size: 80%;
        margin-left: 30%;
        width: 100px;
        height: 100px;
        float: left;
    }
    .roll-content{
        height: 100px;
        padding: 10px;
        float: left;
    }
    .desc-item{
        width: 49%;
        height: 100px;
        display: inline-block;
        text-align: center;
    }
    .rollTitle{
        float: left;
        font-size: 18px;
        height: 26px;
    }
    .rollText{
        float: left;
        font-size: 40px;
        color: #FFF;
        height: 60px;
    }
    .rollNum .num-con{
        height: 60px;
        width: 26px;
    }
    .rollNum .num-item li {
        text-align: center;
        height: 60px;
    }
    }
    #map8-map1{
        width: 1380px;
        border-top: 2px solid #2c3e65;
        margin: 0 auto;
        height: 533px;
    }
    }
</style>
<script type="text/ecmascript-6">
    import echarts from 'echarts'
    import china from 'echarts/map/js/china'
    import rollNum from '../../components/common/rollNum.vue'
    import {seller,column,demo,textStyle,labelStyle,seriesLabelStyle,itemHeight,itemWidth,axisLabel,axisLine,timeData,timeValue,provinceData} from '../../assets/js/demoCharts'
    //随机假数据
    let newData = ()=>{
        let array = [];
        for(let i=0;i<column.length;i++){
            let obj = {
                name: column[i],
                value: parseInt(Math.random()*10000)
            }
            array.push(obj);
        }
        return array;
    }
    //对原始数据进行排序
    let dataSort = array =>{
//        array.splice(0);
        let obj = {
            data:[],
            column:[]
        }
        array.sort((a,b)=>{
            return b.value - a.value;
        })
        array.map(i=>{
            obj.column.push(i.name);
            obj.data.push(i.value);
        });
        return obj;
    };
    let arrayName = ["ott", "tengxun", "migushiping", "fenghuangshiping", "miguyinyue", "hemap", "yidongmm", "139mail"];
    export default{
        data(){
            return {
                data:[],
                arrayName:["ott", "tengxun", "migushiping", "fenghuangshiping", "miguyinyue", "hemap", "yidongmm", "139mail",],
                mapindex: 0,
                mapName: 'OTT',
                richang: 0,
                shishi: 0,
                flag:'',
                map:[],  //map4 map5
                run: true,
                step: 10000
            }
        },
        methods:{
            check(index){
                this.mapindex = index;
                this.mapName = this.changeName(this.arrayName[this.mapindex]);
                this.richang = this.data[this.arrayName[this.mapindex]].richang.toString();
                this.shishi = this.data[this.arrayName[this.mapindex]].shishi.toString();
                this.flag = this.data[this.arrayName[this.mapindex]].danwei;
                this.drawpro('map8-map1',dataSort(this.concatData(this.map,this.arrayName[this.mapindex])),this.mapName,this.flag);
            },
            drawpro(id,data,title,flag) {       //分省流量柱状图
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            type: 'shadow'
                        },
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        },
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {},
                            magicType: {
                                type: ['line'],
                                option:{
                                    line:{
                                        areaStyle: {normal: {}},
                                        symbolSize: 15
                                    }
                                }
                            },
                            restore: {show: true},
                        },
                    },
                    xAxis: [
                        {
                            axisLine,
                            show:true,
                            data:data.column,
                            axisLabel: {
                                show:true,
                                interval:0,
                                textStyle:{
                                    color: '#c0c6c4',
                                    fontSize: 8
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
                            axisLabel:{
                                show:true,
                                textStyle:{
                                    color: '#c0c6c4',
                                    fontSize: 14
                                },
                            },
                            axisLine,
                            type: 'value',
                            name: `${flag}`,
                            nameLocation: 'middle',
                            nameGap: '25',
                            splitLine:{
                                show:false
                            },
                        }
                    ],
                    series: [
                        {
                            name: `${title}`,
                            type: 'bar',
                            barWidth: 20,
                            label: {
                                normal: {
                                    show: true,
                                    position: 'top',
                                    distance :'20',
                                    textStyle:{
                                        color: '#FFF'
                                    },
                                    rotate:90
                                }
                            },
                            itemStyle:{
                                normal:{
                                    color: '#affd87'
                                }
                            },
                            data: data.data
                        }
                    ]
                });
            },
            changeName(key1){
                let obj = {
                    'ott':'OTT',
                    'tengxun':'腾讯视频',
                    'migushiping':'咪咕视频',
                    'fenghuangshiping':'凤凰视频',
                    'miguyinyue':'咪咕音乐',
                    'hemap':'和地图',
                    'yidongmm':'移动MM',
                    '139mail':'139邮箱',
                    'cachell':'缓存流量'
                }
                return obj[key1]
            },
            concatData(array,index){
                array.map(item=>{
                    if(item.name=="全国"){
                        let i = array.indexOf(item);
                        array.splice(i,1);
                    }
                })
                let arr = [];
                for(let item of array){
                    let obj = {
                        name:item.name,
                        value:item[index]
                    }
                    arr.push(obj);
                }
                return arr;
            },
            resetMap(){
                if(this.run){
                    this.mapindex++;
                    console.log(this.mapindex);
                    if(this.mapindex == 8){
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
            }
        },
        components:{
            rollNum
        },
        mounted(){
            this.$nextTick(function(){
                this.$http.get('/data/showdatajson?child=wlll&name=ll').then(res=>{
                    this.data = res.data.ll;
                    this.mapName = this.changeName('ott');
                    this.richang = res.data.ll.ott.richang.toString();
                    this.shishi = res.data.ll.ott.shishi.toString();
                    this.flag = res.data.ll.ott.danwei;
                }).then(()=>{

                }).catch(res=>{
                    console.log(res);
                })

                this.$http.get('/data/showdatajson?child=wlll&name=llfx').then(res=>{
                    this.map = res.data.llfx;
                }).then(()=>{
                    this.drawpro('map8-map1',dataSort(this.concatData(this.map,'ott')),this.mapName,this.flag);
                }).catch(res=>{
                    console.log(res);
                })
                window.setInterval(this.resetMap, this.step);
            })
        },
        beforeDestroy(){
            this.run = false;
        }
    }
</script>

