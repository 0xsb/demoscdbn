<template>
    <div class="edge">
        <div id="map9">
            <div class="map9_head">
                <h1>双11重点ICP业务质量保障</h1>
                <span class="date">{{date}}</span>
            </div>
            <ul class="map9_container">
            <li class="map9_map">
                <div class="map9_top">
                    <h3>{{cpName}}</h3>
                    <div id="map9_line"></div>
                </div>
                <div class="map9_bot">
                    <div id="map9_map"></div>
                </div>
            </li>
            <li class="map9_banner" @mouseover='mouseIn()'  @mouseout="mouseOut()">
                <ul>
                    <li v-for="(item,index) in cpData" :class="['cp-icon',{'active':index==cpindex}]" @click="check(index,item.name)" >
                        <div>
                            <img v-if="item.url!='NULL'" :src="item.url" alt="" class="map9_img"> <img v-else :src="default_imgurl" alt="" class="map9_img"><span class='cpName'>{{item.chinese}}</span>
                        </div>
                        <div class="left left1">
                            <p style="font-size: 14px;color: #fff;">实时流量</p>
                            <p class="ss">{{item.shishi}}<span class="tbps">{{item.danwei}}</span></p>
                        </div>
                        <div class="left left2">
                            <p style="font-size: 14px;color: #fff;">今日峰值</p>
                            <p class="jrfz">{{item.tfengzhi}}<span class="tbps">{{item.danwei}}</span></p>
                        </div>
                        <div class="left left3">
                            <p style="font-size: 14px;color:#fff;">昨日峰值</p>
                            <p class="zrfz">{{item.yfengzhi}}<span class="tbps">{{item.danwei}}</span></p>
                        </div>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</template>
<style lang="less" type="text/less">
.edge{
    background: #1d2b46;
    width:100%;
    height:100%;
    font-family: Microsoft YaHei;
    #map9{
        background: #1d2b46;
        width: 1400px;
        height: 1050px;
        overflow: hidden;
        padding: 0 20px 15px 20px;
        .map9_head{
            width:1380px;
            h1 {
                font-size: 30px;
                height: 85px;
                line-height: 85px;
                color: #FFF;
                position: relative;
                text-align: center;
            }
            span.date{
                color: #cbcbd1;
                width:300px;
                font-size: 24px;
                position: absolute;
                top: 29px;
                left: 960px;
            }
        }
        .map9_container{
            width: 1380px;
            height: 945px;
            border: 2px solid #2c3e65;
            .map9_map{
                width:72%;
                height:100%;
                float: left;
                .map9_top{
                    width: 100%;
                    height: 342px;
                    color: #fff;
                    padding-top: 37.5px;
                    font-weight:lighter;
                    h3{
                        font-size: 21px;
                        font-weight: bold;
                        text-align: center;
                    }

                    #map9_line{
                        width: 100%;
                        height:100%;
                        padding-bottom: 63px;
                        -webkit-box-sizing: border-box;
                        -moz-box-sizing: border-box;
                        box-sizing:border-box;
                    }
                }
                .map9_bot{
                    width: 100%;
                    height:598px;
                    #map9_map{
                        width: 100%;
                        height: 100%;
                    }
                }
            }
            .map9_banner{
                width:28%;
                height:100%;
                float: left;
                ul{
                    width: 100%;
                    height: 866px;
                    padding: 0px 25px 40px 27px;
                    margin-top: 40px;
                    border-left: 2px solid #2c3e65;
                }
                .cp-icon{
                    width: 100%;
                    height: 160px;
                    padding: 21.5px 15px 23.5px 16px;
                    box-sizing: border-box;
                    background-color: #202d4a;
                    zoom: 1;
                    margin-bottom: 17px;
                    .cpName{
                        font-size: 18px;
                        color: #546c9c;
                        margin-left: 20px;
                        line-height: 40px;
                    }
                    .map9_img{
                        border-style: none;
                        width: 40px;
                        vertical-align: bottom;
                    }
                    .cp-icon:after {
                        content: "\0020";
                        display: block;
                        height: 0;
                        clear: both;
                    }
                    .left{
                        float: left;
                        margin-top:22px;
                    }
                    .left1{
                        width:83px;
                        .ss{
                            line-height: 30px;
                            font-size: 24px;
                            color: #33d0b0;
                            margin-top: 4px;
                            animation:fadein 1s linear 1;
                            -webkit-animation:fadein 1s linear 1;
                            -moz-animation:fadein 1s linear 1;
                            -o-animation:fadein 1s linear 1;
                            -ms-animation:fadein 1s linear 1;
                            .tbps{
                                font-size: 12px;
                                color: #fff;
                                margin-left: 10px;
                                vertical-align: middle;
                            }
                        }
                    }
                    .left2{
                        margin-left: 25px;
                        width: 83px;
                        .jrfz{
                            line-height: 30px;
                            font-size: 24px;
                            color: #f2aa0e;
                            margin-top: 4px;
                            animation:fadein 1s linear 1;
                            -webkit-animation:fadein 1s linear 1;
                            -moz-animation:fadein 1s linear 1;
                            -o-animation:fadein 1s linear 1;
                            -ms-animation:fadein 1s linear 1;
                            .tbps{
                                font-size: 12px;
                                color: #fff;
                                margin-left: 10px;
                                vertical-align: middle;
                            }
                        }
                    }
                    .left3{
                        margin-left: 24px;
                        width: 83px;
                        .zrfz{
                            line-height: 30px;
                            font-size: 24px;
                            color: #ff8831;
                            margin-top: 4px;
                            animation:fadein 1s linear 1;
                            -webkit-animation:fadein 1s linear 1;
                            -moz-animation:fadein 1s linear 1;
                            -o-animation:fadein 1s linear 1;
                            -ms-animation:fadein 1s linear 1;
                            .tbps{
                                font-size: 12px;
                                color: #fff;
                                margin-left: 10px;
                                vertical-align: middle;
                            }
                        }
                    }
                    &:hover,&.active{
                        background-color:#4464a6;
                        border: 1px solid #2c3e65;
                    }
                    &:hover{
                        .cpName{
                            color:#fff;
                        }
                    }
                    &.active{
                        .cpName{
                            color:#fff !important;
                        }
                    }
                }
            }
        }
    }
}
@keyframes fadein{
    0%{opacity: 0;
    }
    100%{
        opacity: 1;

    }
}
@-webkit-keyframes fadein{
    0%{opacity: 0;
    }
    100%{
        opacity: 1;

    }
}
@-moz-keyframes fadein{
    0%{opacity: 0;
    }
    100%{
        opacity: 1;

    }
}
@-o-keyframes fadein{
    0%{opacity: 0;
    }
    100%{
        opacity: 1;
    }
}
@-ms-keyframes fadein{
    0%{opacity: 0;
    }
    100%{
        opacity: 1;
    }
}
</style>
<script type="text/ecmascript-6">
import echarts from 'echarts'
import {axisLine,axisLabel,textStyle,map3data,timeData} from '../../assets/js/demoCharts'

export default{
    data() {
        return {
            chart: null,
            width: '1200px',
            dataArray:[], //map9_1
            xzhou:[], //map9_1
            mapArray:[],//map9_2
            run: null,// interval  折线图
            run2:true,//折现开关
            runner:null,// cp interval
            run1:true,  // CP img name开关
            date:'',
            cpData:[],
            cpindex:0,
            cpName:'',
            default_imgurl:'/static/css/static/img/map9_default.png',
//            flag:false,
//            flag1:false,
        };
    },
    methods:{
        getName1(array,index){
//            console.log(array[index].name);
            return array[index].name
        },
        mouseIn(){
            this.run1 = false;
        },
        mouseOut(){
            this.run1 = true;
        },
        check(index,name){
            console.log(name);
            console.log(index);
            this.cpindex = index;
            this.cpName = this.cpData[index].chinese;
            this.drawLine("map9_line",this.getXdata(name),this.xzhou);
            this.drawMap('map9_map',this.mapArray[index].name,this.mapArray[index].value,this.getMax(this.mapArray[0].value));
        },
        drawLine(id,series,xArias){       //实时流量分析
            this.chart = echarts.init(document.getElementById(id));
            this.chart.setOption({
                title: {
                    text: '实时流量曲线',
                    textStyle:{
                        color: '#feffff',
                        fontSize: 18,
                        fontWeight: 'normal'
                    },
                    left:50,
                },
                tooltip : {
                    trigger: 'axis',
                    /*axisPointer: {
                        type: 'cross',
                    },*/
//                    formatter:"{a} : {c}Tbps",
                    backgroundColor:'rgba(255,255,255,0.9)',
                    padding:10,
                    textStyle:{
                        color: '#333'
                    },
                },
                legend: {
                    data:['基准','实时'],
                    textStyle:{
                        color:'white'
                    },
                    top:40,
                },
                color:['#b3ff80','#51dfed'],
                grid: {
                    left: '50',
                    right: '8%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis : [
                    {
                        show:true,
                        type: 'category',
                        boundaryGap: false,
                        data:xArias,
                        axisLabel: {
                            interval:((xArias.length-1)/24*3)-1,
                            show:true,
                            textStyle:{
                                color: '#c0c6c4',
                            }
                        },
                        axisLine,
                        splitLine:{
                            show:false
                        },
//                        nameTextStyle:{
//                            color:'#30436d'
//                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        axisLine,
                        axisLabel: {
                            textStyle:{
                                color: '#c0c6c4',
                            }
                        },
                        splitLine:{
                            show:false
                        },
                        /*nameTextStyle:{
                            color:'#30436d'
                        }*/
                    }
                ],
                series : series
            })
        },
        drawMap(id,name,value,max){
            let arr = [];
            arr.push(name);
            this.chart = echarts.init(document.getElementById(id));
            this.chart.setOption({
//                backgroundColor: '#1d2b46',
                title:{
                    text:'实时链路拥塞',
                    textStyle:{
                        color: '#feffff',
                        fontSize: 18,
                        fontWeight: 'normal'
                    },
                    left:50,
                    y:20
                },
                legend:{
                    orient: 'horizontal',
                    data:arr,
                    textStyle:{
                        color:'#FFF',
                        fontSize: 12
                    },
                    itemWidth:15,
                    itemHeight:15,
                    bottom:25,
                },
                tooltip: {
                    trigger: 'item',
                },
                visualMap: {
                    min: 0,
                    max: max==0?1:max,
                    top:'middle',
                    right: '75',
                    text: ['高','低'],           // 文本，默认为数值文本
                    calculable: false,
                    inRange: {
                        color:['#1d2b46','#f8ab3d'],
                    },
                    textStyle:{
                        color:'#5971a3'
                    }
                },
                series: [
                    {
                        name: name,
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: true
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: '#ffda57',
                                areaColor: '#fcac03',
                                borderColor: '#54689a',
                            },
                            emphasis: {
                                areaColor: '#ffda57',
                                shadowBlur: 10,
                            }
                        },
                        data:value
                    }]
            });
        },
        getFirstName(array,index){
            return Object.keys(array[0])[index];
        },
        getXdata(name){
            let array = [];
            this.dataArray.map(i=>{
                array.push(i[name]);
            });
            var arr1 = [];
            var arr2 = [];
            for(let i=0;i<array.length;i++){
                arr1.push(array[i].jizhun);
                arr2.push(array[i].shishi);
            }
            let res=[
                {
                    name:'基准',
                    type:'line',
                    stack: 'sum',
                    areaStyle: {
                        normal: {
                            color:'#b3ff80' ,
                        }
                    },
                    data:arr1,
                    symbol:'diamond',
                    symbolSize: 5,
                    showSymbol:false,
                },
                {
                    name:'实时',
                    type:'line',
                    stack: 'sum',
                    areaStyle: {
                        normal: {
                            color:'#51dfed'
                        }
                    },
                    data:arr2,
                    symbol:'rect',
                    symbolSize: 5,
                    showSymbol:false,
                }
            ];
            return res;
        },
        getMax(array){
            let arr = [];
            array.map(item=>{
                arr.push(item.value);
            })
            return this.getMaxmin(arr,'max');
        },
        getMaxmin(arr,maxmin){
            if(maxmin=='max'){
                return Math.max.apply(Math,arr);
            }
        }
    },
    created(){

    },
    mounted(){
        window.setInterval(()=>{
            const D = new Date();
            let YY = D.getFullYear();
            let MM = (D.getMonth()+1)<10?'0'+(D.getMonth()+1):(D.getMonth()+1);
            let DD = D.getDate()<10?'0'+D.getDate():D.getDate();
            let HH = D.getHours()<10?'0'+D.getHours():D.getHours();
            let MI = D.getMinutes()<10?'0'+D.getMinutes():D.getMinutes();
            let SS = D.getSeconds()<10?'0'+D.getSeconds():D.getSeconds();
            this.date = YY+ '-' + MM + '-'+ DD +'  ' + HH + ':' + MI + ':' + SS;
        },1000);

        this.$nextTick(()=>{
            this.$http.get('/data/showdatajson?child=map9&name=ssll').then(res=>{
                this.dataArray = res.data.ssll;
                this.xzhou = res.data.xzhou;
            }).then(()=>{
                this.drawLine('map9_line',this.getXdata(this.getFirstName(this.dataArray,this.cpindex)),this.xzhou);
            }).then(()=>{
                this.run = window.setInterval(()=>{
                    this.$http.get('/data/showdatajson?child=map9&name=ssll').then(res=>{
                        this.dataArray = res.data.ssll;
                        this.xzhou = res.data.xzhou;
                    }).then(()=>{
                        this.drawLine('map9_line',this.getXdata(this.getFirstName(this.dataArray,this.cpindex)),this.xzhou);
                    }).catch(res=>{

                    });
                },5000);
            }).catch(res=>{
                console.log(res);
            });

            this.$http.get('/data/getNameAndUrl?child=map9&name=ssandfz').then(res=> {
                this.cpData = res.data;
                this.cpName = res.data[0].chinese;
            }).then(()=>{
                this.runner = window.setInterval(()=>{
                    this.$http.get('/data/getNameAndUrl?child=map9&name=ssandfz').then(res=> {
                        this.cpData = res.data;
                        this.cpName = res.data[this.cpindex].chinese;
                    }).then(()=>{
                        if(this.run1 == true){
                            this.cpindex++;
                            if(this.cpindex>4){
                                this.cpindex=0;
                                this.check(this.cpindex,this.cpData[this.cpindex].name);
                            }else{
                                this.check(this.cpindex,this.cpData[this.cpindex].name);
                            }
                        }

                    }).catch(res=>{

                    });
                },10000);
            }).catch(res=>{
                console.log(res)
            })

            this.$http.get('/data/showdatajson?child=map9&name=llys').then(res=>{
                this.mapArray = res.data.llys;
            }).then(()=>{
                this.drawMap('map9_map',this.mapArray[0].name,this.mapArray[0].value,this.getMax(this.mapArray[0].value));
            }).catch(res=>{
                console.log(res);
            });

        })
    },
    beforeDestroy(){
        clearInterval(this.run);
        clearInterval(this.runner);
    }
}
</script>
