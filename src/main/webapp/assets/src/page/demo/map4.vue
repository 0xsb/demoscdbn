<template>
    <div id="map">
        <!--<h1>内容流量全网资源平台</h1>-->
        <ul class="header_show">
            <div class="main_title"><!--实时拥塞--></div>
            <li id="circle1" :style="{width:'460px',height:'354px'}"></li>
            <li id="circle2" :style="{width:'460px',height:'354px'}"></li>
            <li id="circle3" :style="{width:'460px',height:'354px'}"></li>
        </ul>
        <ul class="footer_show">
            <li class="left">
                <div id="left_top" :style="{width:'560px',height:'306px'}"></div>
                <div id="left_bot" :style="{width:'560px',height:'306px'}"></div>
            </li>
            <li class="right" @mouseover='mouseIn()'  @mouseout="mouseOut()">
                <ul>
                    <li v-for="(item,index) in mapData" class="map-icon" @click="changeMap(index)" :class="['map-icon-'+index,{'active':index==mapindex}]"></li>
                    <!--<li v-for="(item,index) in ysdt" class="map-icon" @click="changeMap(index)" :class="['map-icon-'+changeName(item.name),{'active':index==mapindex}]"></li>-->
                </ul>
                <div id="right_content" :style="{width:'656px',height:'607px'}"></div>
            </li>
        </ul>
    </div>
</template>

<style lang="less">
    .main_title{
        border: 2px solid #2c3e65;
        font-size: 32px;
        border-bottom: none;
        text-align: center;
        color: white;
        line-height: 75px;
    }
    #map{
        width:100%;
        height: 997.5px;
    .header_show{
    overflow:hidden;
    li{
        float: left;
    }
    #circle1{
        border: 2px solid #2c3e65;
        border-right:none;
        border-bottom:none;
        border-top: none ;
    }
    #circle3{
        border: 2px solid #2c3e65;
        border-left: none;
        border-bottom: none;
        border-top:none;
    }
    }
    .footer_show{
    height:680px;
    li{
        float: left;
    }
    li.left{
        width: 560px;
        height:680px;
        overflow:hidden;
    #left_top,#left_bot{
        height:50%;
        border: 2px solid #2c3e65;
        box-sizing: border-box;
    }
    #left_top{
        border-bottom:none;
    }
    }
    li.right{
        width: 820px;
        height: 612px;
        float: left;
        border: 2px solid #2c3e65;
        border-left:none;
        overflow:hidden;
    ul{
        width: 105px;
        float: left;
    li{
        display: inline-block;
        margin-left: 25px;
        width: 50px;
        height: 50px;
        margin-top:10px;
        cursor:pointer;
    &:hover,&.active{
                 border:2px solid #52a5f7;
             }
    }
    }
    #right_content{
        float: left;
    }
    }
    }
    .map-icon{

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
        background: url(../../assets/imgs/map-icon-9.png) no-repeat;
        background-size:contain;
    }
    .map-icon-9{
        background: url(../../assets/imgs/map-icon-8.png) no-repeat;
        background-size:contain;
    }
</style>
<script type="text/ecmascript-6">
    import echarts from 'echarts'
    import {axisLine,axisLabel,textStyle} from '../../assets/js/demoCharts'

    const jamLinkRole = {
        legendData:['腾讯','爱奇艺','百度','阿里巴巴','搜狐','360','优酷土豆网'],
        jamBandwidthG:[610,300,90,70,40,20,10],
        all: 114,
        jamPercent:[6.40,5.42,9.47,1.82,9.30,6.25,0.40],
        jamSolve:["腾讯", "爱奇艺", "阿里巴巴", "优酷土豆网","百度", "360", "芒果TV","搜狐","汽车之家","PPTV"],
    };
    const dataStyle = {
        normal: {
            label: {show:false},
            labelLine: {show:false}
        }
    };
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
        data() {
            return {
                chart: null,
                mapindex: 0,
                width: '1200px',
                run: true,
                step: 10000,
                chartsasd:'',
                mapData:[
                    {name:'腾讯', value:[
                        {name: '安徽',value: 6 },
                        {name: '北京',value: 0 },
                        {name: '福建',value: 4 },
                        {name: '甘肃',value: 0 },
                        {name: '广东',value: 0 },
                        {name: '广西',value: 0 },
                        {name: '海南',value: 0 },
                        {name: '河北',value: 0 },
                        {name: '河南',value: 6 },
                        {name: '黑龙江',value: 0 },
                        {name: '湖北',value: 0 },
                        {name: '湖南',value:0 },
                        {name: '吉林',value: 0 },
                        {name: '江苏',value: 17 },
                        {name: '江西',value: 0 },
                        {name: '辽宁',value: 6 },
                        {name: '宁夏',value: 0 },
                        {name: '山东',value: 0 },
                        {name: '山西',value: 0 },
                        {name: '陕西',value: 4 },
                        {name: '上海',value: 0 },
                        {name: '四川',value: 0 },
                        {name: '天津',value: 0 },
                        {name: '西藏',value: 0 },
                        {name: '新疆',value: 0 },
                        {name: '云南',value: 4 },
                        {name: '浙江',value: 4 },
                        {name: '重庆',value: 10 },
                        {name: '贵州',value: 0 },
                        {name: '内蒙古',value: 0 },
                        {name: '青海',value: 0 },
                    ]},
                    {name:'爱奇艺', value:[
                        {name: '安徽',value: 3 },
                        {name: '北京',value: 0 },
                        {name: '福建',value: 0 },
                        {name: '甘肃',value: 0 },
                        {name: '广东',value: 0 },
                        {name: '广西',value: 0 },
                        {name: '海南',value: 2 },
                        {name: '河北',value: 0 },
                        {name: '河南',value: 23 },
                        {name: '黑龙江',value: 0 },
                        {name: '湖北',value: 2 },
                        {name: '湖南',value:0 },
                        {name: '吉林',value: 0 },
                        {name: '江苏',value: 0 },
                        {name: '江西',value: 0 },
                        {name: '辽宁',value: 0 },
                        {name: '宁夏',value: 0 },
                        {name: '山东',value: 0 },
                        {name: '山西',value: 0 },
                        {name: '陕西',value: 0 },
                        {name: '上海',value: 0 },
                        {name: '四川',value: 0 },
                        {name: '天津',value: 0 },
                        {name: '西藏',value: 0 },
                        {name: '新疆',value: 0 },
                        {name: '云南',value: 0 },
                        {name: '浙江',value: 0 },
                        {name: '重庆',value: 0 },
                        {name: '贵州',value: 0 },
                        {name: '内蒙古',value: 0 },
                        {name: '青海',value: 0 },
                    ]},
                    {name:'阿里巴巴', value:[
                        {name: '安徽',value: 0 },
                        {name: '北京',value: 0 },
                        {name: '福建',value: 0 },
                        {name: '甘肃',value: 0 },
                        {name: '广东',value: 2 },
                        {name: '广西',value: 0 },
                        {name: '海南',value: 0 },
                        {name: '河北',value: 0 },
                        {name: '河南',value: 0 },
                        {name: '黑龙江',value: 0 },
                        {name: '湖北',value: 0 },
                        {name: '湖南',value:0 },
                        {name: '吉林',value: 0 },
                        {name: '江苏',value: 0 },
                        {name: '江西',value: 0 },
                        {name: '辽宁',value: 0 },
                        {name: '宁夏',value: 0 },
                        {name: '山东',value: 5 },
                        {name: '山西',value: 0 },
                        {name: '陕西',value: 0 },
                        {name: '上海',value: 0 },
                        {name: '四川',value: 0 },
                        {name: '天津',value: 0 },
                        {name: '西藏',value: 0 },
                        {name: '新疆',value: 0 },
                        {name: '云南',value: 0 },
                        {name: '浙江',value: 0 },
                        {name: '重庆',value: 0 },
                        {name: '贵州',value: 0 },
                        {name: '内蒙古',value: 0 },
                        {name: '青海',value: 0 },
                    ]},
                    {name:'优酷土豆网', value:[
                        {name: '安徽',value: 0 },
                        {name: '北京',value: 1 },
                        {name: '福建',value: 0 },
                        {name: '甘肃',value: 0 },
                        {name: '广东',value: 0 },
                        {name: '广西',value: 0 },
                        {name: '海南',value: 0 },
                        {name: '河北',value: 0 },
                        {name: '河南',value: 0 },
                        {name: '黑龙江',value: 0 },
                        {name: '湖北',value: 0 },
                        {name: '湖南',value:0 },
                        {name: '吉林',value: 0 },
                        {name: '江苏',value: 0 },
                        {name: '江西',value: 0 },
                        {name: '辽宁',value: 0 },
                        {name: '宁夏',value: 0 },
                        {name: '山东',value: 0 },
                        {name: '山西',value: 0 },
                        {name: '陕西',value: 0 },
                        {name: '上海',value: 0 },
                        {name: '四川',value: 0 },
                        {name: '天津',value: 0 },
                        {name: '西藏',value: 0 },
                        {name: '新疆',value: 0 },
                        {name: '云南',value: 0 },
                        {name: '浙江',value: 0 },
                        {name: '重庆',value: 0 },
                        {name: '贵州',value: 0 },
                        {name: '内蒙古',value: 0 },
                        {name: '青海',value: 0 },
                    ]},
                    {name:'百度', value:[
                        {name: '安徽',value: 0 },
                        {name: '北京',value: 0 },
                        {name: '福建',value: 0 },
                        {name: '甘肃',value: 0 },
                        {name: '广东',value: 8 },
                        {name: '广西',value: 0 },
                        {name: '海南',value: 0 },
                        {name: '河北',value: 0 },
                        {name: '河南',value: 0 },
                        {name: '黑龙江',value: 0 },
                        {name: '湖北',value: 0 },
                        {name: '湖南',value:0 },
                        {name: '吉林',value: 0 },
                        {name: '江苏',value: 0 },
                        {name: '江西',value: 0 },
                        {name: '辽宁',value: 0 },
                        {name: '宁夏',value: 0 },
                        {name: '山东',value: 0 },
                        {name: '山西',value: 0 },
                        {name: '陕西',value: 0 },
                        {name: '上海',value: 0 },
                        {name: '四川',value: 0 },
                        {name: '天津',value: 0 },
                        {name: '西藏',value: 0 },
                        {name: '新疆',value: 0 },
                        {name: '云南',value: 1 },
                        {name: '浙江',value: 0 },
                        {name: '重庆',value: 0 },
                        {name: '贵州',value: 0 },
                        {name: '内蒙古',value: 0 },
                        {name: '青海',value: 0 },
                    ]},
                    {name:'乐视网', value:[
                        {name: '安徽',value: 0 },
                        {name: '北京',value: 6 },
                        {name: '福建',value: 0 },
                        {name: '甘肃',value: 0 },
                        {name: '广东',value: 0 },
                        {name: '广西',value: 0 },
                        {name: '海南',value: 0 },
                        {name: '河北',value: 0 },
                        {name: '河南',value: 0 },
                        {name: '黑龙江',value: 0 },
                        {name: '湖北',value: 0 },
                        {name: '湖南',value:0 },
                        {name: '吉林',value: 0 },
                        {name: '江苏',value: 0 },
                        {name: '江西',value: 0 },
                        {name: '辽宁',value: 0 },
                        {name: '宁夏',value: 0 },
                        {name: '山东',value: 0 },
                        {name: '山西',value: 0 },
                        {name: '陕西',value: 0 },
                        {name: '上海',value: 2.5 },
                        {name: '四川',value: 0 },
                        {name: '天津',value: 0 },
                        {name: '西藏',value: 0 },
                        {name: '新疆',value: 0 },
                        {name: '云南',value: 0 },
                        {name: '浙江',value: 4 },
                        {name: '重庆',value: 0 },
                        {name: '贵州',value: 0 },
                        {name: '内蒙古',value: 0 },
                        {name: '青海',value: 0 },
                    ]},
                    {name:'芒果TV', value:[
                        {name: '安徽',value: 1 },
                        {name: '北京',value: 0 },
                        {name: '福建',value: 0 },
                        {name: '甘肃',value: 0 },
                        {name: '广东',value: 0 },
                        {name: '广西',value: 0 },
                        {name: '海南',value: 0 },
                        {name: '河北',value: 0 },
                        {name: '河南',value: 0 },
                        {name: '黑龙江',value: 0 },
                        {name: '湖北',value: 0 },
                        {name: '湖南',value:0 },
                        {name: '吉林',value: 0 },
                        {name: '江苏',value: 1 },
                        {name: '江西',value: 0 },
                        {name: '辽宁',value: 0 },
                        {name: '宁夏',value: 0 },
                        {name: '山东',value: 0 },
                        {name: '山西',value: 0 },
                        {name: '陕西',value: 0 },
                        {name: '上海',value: 0 },
                        {name: '四川',value: 0 },
                        {name: '天津',value: 0 },
                        {name: '西藏',value: 0 },
                        {name: '新疆',value: 0 },
                        {name: '云南',value: 0 },
                        {name: '浙江',value: 0 },
                        {name: '重庆',value: 0 },
                        {name: '贵州',value: 0 },
                        {name: '内蒙古',value: 0 },
                        {name: '青海',value: 0 },
                    ]},
                    {name:'金山科技', value:[
                        {name: '安徽',value: 0 },
                        {name: '北京',value: 6 },
                        {name: '福建',value: 0 },
                        {name: '甘肃',value: 0 },
                        {name: '广东',value: 0 },
                        {name: '广西',value: 0 },
                        {name: '海南',value: 0 },
                        {name: '河北',value: 0 },
                        {name: '河南',value: 0 },
                        {name: '黑龙江',value: 0 },
                        {name: '湖北',value: 0 },
                        {name: '湖南',value:0 },
                        {name: '吉林',value: 0 },
                        {name: '江苏',value: 0 },
                        {name: '江西',value: 0 },
                        {name: '辽宁',value: 0 },
                        {name: '宁夏',value: 0 },
                        {name: '山东',value: 0 },
                        {name: '山西',value: 0 },
                        {name: '陕西',value: 0 },
                        {name: '上海',value: 2.5 },
                        {name: '四川',value: 0 },
                        {name: '天津',value: 0 },
                        {name: '西藏',value: 0 },
                        {name: '新疆',value: 0 },
                        {name: '云南',value: 0 },
                        {name: '浙江',value: 4 },
                        {name: '重庆',value: 0 },
                        {name: '贵州',value: 0 },
                        {name: '内蒙古',value: 0 },
                        {name: '青海',value: 0 },
                    ]},
                    {name:'新浪', value:[
                        {name: '安徽',value: 0 },
                        {name: '北京',value: 0 },
                        {name: '福建',value: 0 },
                        {name: '甘肃',value: 0 },
                        {name: '广东',value: 0 },
                        {name: '广西',value: 0 },
                        {name: '海南',value: 0 },
                        {name: '河北',value: 0 },
                        {name: '河南',value: 0 },
                        {name: '黑龙江',value: 0 },
                        {name: '湖北',value: 0 },
                        {name: '湖南',value:0 },
                        {name: '吉林',value: 0 },
                        {name: '江苏',value: 1 },
                        {name: '江西',value: 0 },
                        {name: '辽宁',value: 0 },
                        {name: '宁夏',value: 0 },
                        {name: '山东',value: 0 },
                        {name: '山西',value: 0 },
                        {name: '陕西',value: 0 },
                        {name: '上海',value: 0 },
                        {name: '四川',value: 0 },
                        {name: '天津',value: 0 },
                        {name: '西藏',value: 0 },
                        {name: '新疆',value: 0 },
                        {name: '云南',value: 0 },
                        {name: '浙江',value: 0 },
                        {name: '重庆',value: 0 },
                        {name: '贵州',value: 0 },
                        {name: '内蒙古',value: 0 },
                        {name: '青海',value: 0 },
                    ]},
                    {name:'搜狐', value:[
                        {name: '安徽',value: 0 },
                        {name: '北京',value: 0 },
                        {name: '福建',value: 0 },
                        {name: '甘肃',value: 0 },
                        {name: '广东',value: 0 },
                        {name: '广西',value: 0 },
                        {name: '海南',value: 0 },
                        {name: '河北',value: 0 },
                        {name: '河南',value: 0 },
                        {name: '黑龙江',value: 0 },
                        {name: '湖北',value: 4 },
                        {name: '湖南',value:0 },
                        {name: '吉林',value: 0 },
                        {name: '江苏',value: 0 },
                        {name: '江西',value: 0 },
                        {name: '辽宁',value: 0 },
                        {name: '宁夏',value: 0 },
                        {name: '山东',value: 0 },
                        {name: '山西',value: 0 },
                        {name: '陕西',value: 0 },
                        {name: '上海',value: 0 },
                        {name: '四川',value: 0 },
                        {name: '天津',value: 0 },
                        {name: '西藏',value: 0 },
                        {name: '新疆',value: 0 },
                        {name: '云南',value: 0 },
                        {name: '浙江',value: 0 },
                        {name: '重庆',value: 0 },
                        {name: '贵州',value: 0 },
                        {name: '内蒙古',value: 0 },
                        {name: '青海',value: 0 },
                    ]},
                ],
//                mapArray:['腾讯','爱奇艺','阿里巴巴','优酷土豆网','百度','乐视网','芒果TV','金山科技','新浪','搜狐'],
                yongsailianlu:[], //map1 拥塞链路
                yongsaidaikuan:[],  //map2  拥塞带宽
                yongsaizhanbi:[], //map3  用赛占比
                yongsailianlushu:[],  //map4 ICP用赛链路分析
                jiejueyongsailianlushu:[],  //map4
                icp_yongsaijiejuefenxi:[], // ICP用赛解决分析
                ysdt:[],  // map6  地图
            };
        },
        methods:{
            drawPie1(id,name,rank,sum,max){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title:{
                        text:`拥塞链路 \n `+sum,
                        x: 'center',
                        y: '50%',
                        itemGap: 50,
                        textStyle
                    },
                    gird:{
                        top:'20%',
                        left:'20'
                    },
                    tooltip : {
                        show: true,
                        formatter: "{b} : {c}",
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        },
                    },
                    color:['#4CDEEF', '#AFFD87','#566EFF','#EF5E80','#F4D64A','#F27554','#3ABAA0'],
                    legend: {
                        orient : 'vertical',
                        x : document.getElementById('circle1').offsetWidth / 2,
                        y : 25,
                        itemGap:5,
                        itemWidth:15,
                        itemHeight:15,
                        data:name,
                        textStyle:{
                            color:'white'
                        }
                    },
                    series : [
                        {
                            name:'1',
                            type:'pie',
                            clockWise:false,
                            radius : ['70%','80%'],
                            itemStyle : dataStyle,
                            endAngle:'',
                            data:[
                                rank[0],
                                {
                                    value:max-rank[0].value,
                                    name:'invisible',
                                    itemStyle : placeHolderStyle,
                                }
                            ]
                        },
                        {
                            name:'2',
                            type:'pie',
                            clockWise:false,
                            radius : ['60%', '70%'],
                            itemStyle : dataStyle,
                            data:[
                                rank[1],
                                {
                                    value:max-rank[1].value,
                                    name:'invisible',
                                    itemStyle : placeHolderStyle,

                                }
                            ]
                        },
                        {
                            name:'3',
                            type:'pie',
                            clockWise:false,
                            radius : ['50%', '60%'],
                            itemStyle : dataStyle,
                            data:[
                                rank[2],
                                {
                                    value:max-rank[2].value,
                                    name:'invisible',
                                    itemStyle : placeHolderStyle,

                                }
                            ]
                        },
                        {
                            name:'4',
                            type:'pie',
                            clockWise:false,
                            radius : ['40%', '50%'],
                            itemStyle : dataStyle,
                            data:[
                                rank[3],
                                {
                                    value:max-rank[3].value,
                                    name:'invisible',
                                    itemStyle : placeHolderStyle,

                                }
                            ]
                        },
                        {
                            name:'5',
                            type:'pie',
                            clockWise:false,
                            radius : ['30%', '40%'],
                            itemStyle : dataStyle,
                            data:[
                                rank[4],
                                {
                                    value:max-rank[4].value,
                                    name:'invisible',
                                    itemStyle : placeHolderStyle,

                                }
                            ]
                        },
                        {
                            name:'6',
                            type:'pie',
                            clockWise:false,
                            radius : ['20%', '30%'],
                            itemStyle : dataStyle,
                            data:[
                                rank[5],
                                {
                                    value:max-rank[5].value,
                                    name:'invisible',
                                    itemStyle : placeHolderStyle
                                },
                            ]},
                        {
                            name:'7',
                            type:'pie',
                            clockWise:false,
                            radius : ['10%', '20%'],
                            itemStyle : dataStyle,
                            data:[
                                rank[6],
                                {
                                    value:max-rank[6].value,
                                    name:'invisible',
                                    itemStyle : placeHolderStyle
                                }
                            ]}
                    ]
                })
            },
            drawPie2(id,name,value){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title: {
                        text: '拥塞带宽',
                        x:'center',
                        textStyle,
                        y:10
                    },
                    legend: {
                        x: document.getElementById("circle2").offsetWidth/3*2,
                        y:20,
                        data: ['拥塞带宽(单位Gbps)'],
                        itemWidth:18,
                        itemHeight:18,
                        textStyle:{
                            color:'white'
                        }
                    },
                    color:['#F27554'],
                    tooltip: {
                        trigger: 'axis',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        },
                    },
                    grid: {
                        bottom: '10%',
                        containLabel: true
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data:name,
                        axisLabel:{
                            interval:0,//横轴信息全部显示
                        },
                        axisLine,
                        splitLine:{
                            show:false
                        }
                    },
                    yAxis: {
                        type: 'value',
                        splitLine:{
                            show:false
                        },
                        axisLine
                    },
                    series: [
                        {
                            name:'拥塞带宽(单位Gbps)',
                            type:'line',
                            data:value,
                            symbol:'diamond',
                            symbolSize:'15'
                        }
                    ]
                })
            },
            drawPie3(id,max,value,xdata){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title: {
                        text: '拥塞占比',
                        x:'center',
                        textStyle,
                        y:10
                    },
                    legend: {
                        x: document.getElementById("circle3").offsetWidth/3*2,
                        y:20,
                        data: ['拥塞占比'],
                        icon:"circle",
                        textStyle:{
                            color:'white'
                        }
                    },
                    grid: {
                        left:"3%",
                        bottom: '10%',
                        containLabel: true
                    },
                    xAxis: {
                        show:false,
//                        data:jamLinkRole.legendData,
                        data:xdata,
                        boundaryGap: false,
                        axisLabel:{
                            interval:'auto',//横轴信息全部显示
                        },
                        axisLine,
                        splitLine:{
                            show:false
                        }
                    },
                    yAxis: {
                        splitLine: {
                            show:false
                        },
                        axisLine,
                        axisLabel: {
                            show: true,
                            interval: 'auto',
                            formatter: '{value}.00 %'
                        },
                    },
                    series: [{
                        name: '拥塞占比',
                        data:value,
                        type: 'scatter',
                        symbolSize: function (data) {
                            return data * 1.6;
                        },
                        label: {
                            emphasis: {
                                show: true,
                                position: 'top',
                            }
                        },
                        itemStyle: {
                            normal: {
                                label: {
                                    show: true,
                                    position: 'inside',
                                    formatter: '{b}:\n{c}%'
                                },
                                color:'#57B3f5'
                            }
                        }
                    }]
                })
            },
            drawLine(id,xdata,value1,value2){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title:{
                        text:"ICP 拥塞链路分析(2017年)",
                        x:'center',
                        y:20,
                        textStyle,
                    },
                    tooltip : {
                        trigger: 'axis',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        },
                    },
                    legend:{
                        data:["拥塞链路数","解决拥塞链路数"],
                        x:document.getElementById("left_top").offsetWidth/3*2+50,
                        y:25,
                        textStyle:{
                            color:'white'
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '2%',
                        containLabel: true
                    },
                    color:['#EF5E80','#F4D64A'],
                    xAxis : [
                        {
                            type : 'category',
                            data : xdata,
                            splitLine:{
                                show:false
                            },
                            axisLine
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            max:140,
                            splitLine:{
                                show:false
                            },
                            splitNumber:7,
                            axisLine
                        }
                    ],
                    series : [
                        {
                            name:'拥塞链路数',
                            type:'line',
                            data:value1,
                            symbol:'diamond',
                            symbolSize: 14,
                        },
                        {
                            name:'解决拥塞链路数',
                            type:'line',
                            data:value2,
                            symbol:'rect',
                            symbolSize: 10,
                        }
                    ]
                })
            },
            drawLine2(id,nameRank,valueRank){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title: {
                        text: 'ICP 拥塞解决分析(2017年)',
                        x:'center',
                        y:20,
                        textStyle,
                    },
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
                    legend: {
                        data: ['解决拥塞链路数'],
                        x:document.getElementById("left_bot").offsetWidth/3*2+70,
                        itemWidth:15,
                        itemHeight:15,
                        y:30,
                        textStyle:{
                            color:'white'
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis: {
                        type: 'value',
                        splitLine:{
                            show:false
                        },
                        axisLine
                    },
                    yAxis :
                        {
                            type : 'category',
                            data:nameRank,
                            inverse:true,
                            axisLine
                        },
                    series: [
                        {
                            name:'解决拥塞链路数',
                            type:'bar',
                            barWidth: '60%',
                            data:valueRank,
                            itemStyle:{
                                normal:{
                                    color:'#3ABAA0'
                                }
                            }
                        }
                    ]
                })
            },
            drawMap(id,value){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    backgroundColor: '#1d2b46',
                    title:{
                        text:'拥塞地图',
                        textStyle,
                        left:'40%',
                        y:20
                    },
                    legend:{
                        data:['腾讯'],
                        right:'10%',
                        itemWidth:15,
                        itemHeight:15,
                        top:30,
                        textStyle:{
                            color:'#FFF',
                            fontSize: 14
                        }
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    visualMap: {
                        min: 0,
                        max: 17,
                        left: '5%',
                        bottom:'10%',
                        text: ['高','低'],           // 文本，默认为数值文本
                        calculable: false,
                        inRange: {
                            color: ['#1d2b46', '#ef5e80']
                        },
                        textStyle:{
                            color:'#5971a3'
                        }
                    },
                    series: [
                        {
                            name: '腾讯',
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
                                    color: '#ef5e80',
                                    areaColor: '#ef5e80',
                                    borderColor: 'rgba(100,149,237,1)',
                                    opacity: '0.6'
                                },
                                emphasis: {
                                    areaColor: '#FF678C',
                                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                                    shadowBlur: 10,
                                    opacity: '0.8'
                                }
                            },
                            data:value
                        }]
                });
            },
            changeMap(index){
                this.mapindex = index;
                let maxNum = [];
                Object.values(this.ysdt[index].value).map(i=>{
                    maxNum.push(i.value)
                });
                maxNum.sort((a,b)=>{
                    return a-b
                });
                this.chart = echarts.init(document.getElementById('right_content'));
                this.chart.setOption({
                    title:{
                        text:'拥塞地图',
                        textStyle,
                        left:'40%',
                        y:20
                    },
                    legend:{
                        data:[this.ysdt[index].name],
                        right:'10%',
                        itemWidth:15,
                        itemHeight:15,
                        top:30,
                        textStyle:{
                            color:'#FFF',
                            fontSize: 14
                        }
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    visualMap: {
                        min: 0,
                        max: maxNum[maxNum.length-1]==0?maxNum[maxNum.length-1]+1:maxNum[maxNum.length-1],
                        left: '5%',
                        bottom:'10%',
                        text: ['高','低'],
                        calculable: false,
                        inRange: {
                            color: ['#1d2b46', '#ef5e80']
                        },
                        textStyle:{
                            color:'#5971a3'
                        }
                    },
                    series:[
                        {
                            name: this.ysdt[index].name,
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
                                    color: '#ef5e80',
                                    areaColor: '#ef5e80',
                                    borderColor: 'rgba(100,149,237,1)',
                                    opacity: '0.6'
                                },
                                emphasis: {
                                    areaColor: '#FF678C',
                                    shadowColor: 'rgba(0, 0, 0, 0.5)',
                                    shadowBlur: 10,
                                    opacity: '0.8'
                                }
                            },
                            data:this.ysdt[index].value
                        }]
                })
            },
            getDataName(array){
                let arr = [];
                array.map((item)=>{
                    arr.push(item.name);
                });
                return arr;
            },
            getDataName1(array){
                let arr = [];
                array.map((item)=>{
                    arr.push((item.name).toString());
                });
                return arr;
            },
            getDataValue(array){
                let arr = [];
                array.map((item)=>{
                    arr.push(Number(item.value));
                });
                return arr;
            },
            getDataValue2(array){
                let arr = ['腾讯','爱奇艺','百度','阿里巴巴','搜狐','360','优酷土豆网'];
                let arr2 = [];
                arr.map(items=>{
                    array.map(item=>{
                        if(item.name==items){
                            arr2.push(Number(item.value));
                        }
                    })
                });
                return arr2;
            },
            getDataRank(array){
                let func = ((a,b)=>{
                    return b.value-a.value;
                });
                array.sort(func);
                return array;
            },
            sumData(array){
                let arr = [];
                let str = 0;
                array.map((item)=>{
                    arr.push(item.value);
                });
                for (let i in arr){
                    let reali = Number(arr[i]);
                    str += reali;
                }
                return str;
            },
            getMaxValue(array){
                let arr = [];
                array.map((item)=>{
                    arr.push(Number(item.value));
                });
                arr.sort((a,b)=>{
                    return b-a;
                })
                return arr[0];
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
            getXdata(array){
                let arr = [];
                let arr2 = [];
                array.map(item=>{
                    arr.push(item.name);
                })
                for(let i=0;i<arr.length;i++){
                    arr2.push(arr[i]+'月份');
                }
                return arr2;
            },
            dealValue(value){
                let len = value.toString().length;
                let num = Math.pow(10, len - 1);
                return num * (Math.floor(value / num) + 1);
            },
            resetMap(){
                if(this.run){
                    this.mapindex++;
                    if(this.mapindex == 10){
                        this.mapindex = 0;
                    }
                    this.changeMap(this.mapindex);
                }
            },
            mouseIn(){
                this.run = false;
            },
            mouseOut(){
                this.run = true;
            }
        },
        mounted(){
            this.$nextTick(function() {
                this.$http.get('/data/showdatajson?child=ysjk&name=zonghe').then(res=>{
                    this.yongsailianlu = res.data.zonghe.yongsailianlu;
                    this.yongsaidaikuan = res.data.zonghe.yongsaidaikuan;
                    this.yongsaizhanbi = res.data.zonghe.yongsaizhanbi;
                    this.yongsailianlushu = res.data.zonghe.icp_yongsaifenxi.yongsailianlushu;
                    this.jiejueyongsailianlushu = res.data.zonghe.icp_yongsaifenxi.jiejueyongsailianlushu;
                    this.icp_yongsaijiejuefenxi = res.data.zonghe.icp_yongsaijiejuefenxi;
                }).then(()=>{
                    this.drawPie1("circle1",this.getDataName(this.yongsailianlu),this.getDataRank(this.yongsailianlu),this.sumData(this.yongsailianlu),this.dealValue(this.getDataRank(this.yongsailianlu)[0].value));
                    this.drawPie2("circle2",this.getDataName(this.yongsaidaikuan),this.getDataValue(this.yongsaidaikuan));
                    this.drawPie3("circle3",this.getMaxValue(this.yongsaizhanbi),this.getDataValue(this.yongsaizhanbi),this.getDataName1(this.yongsaizhanbi));
                    this.drawLine("left_top",this.getXdata(this.yongsailianlushu),this.yongsailianlushu,this.jiejueyongsailianlushu);
                    this.drawLine2("left_bot",this.getNameRank(this.icp_yongsaijiejuefenxi),this.getValueRank(this.icp_yongsaijiejuefenxi));
                }).catch((res)=>{
                    console.log(res);
                })

                this.$http.get('/data/showdatajson?child=ysjk&name=ysdt').then(res=>{
                    this.ysdt = res.data.ysdt;
                }).then(()=>{
                    this.drawMap("right_content",this.ysdt[0].value);
//                    this.drawmap('map2-map6','腾讯',this.getAreaData('tengxun'),this.getMax());
                }).catch(res=>{
                    console.log(res);
                })
            });

            window.setInterval(this.resetMap, this.step);
        },
        beforeDestroy(){
            this.run = false;
        },
    }
</script>
