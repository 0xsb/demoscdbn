<template>
    <div class="map10">
        <div id="leftMap" class="leftMap">
            <div class="header_content info-view mt-30">
                <div class="info-img">
                    <div class="img-danger">
                        <img src="../../assets/imgs/warning1.gif">
                        <!--<span class="img-icon"></span>-->
                        <span class="txt-icon">{{wData1}}</span>个告警
                    </div>
                    <div class="img-warn">
                        <img src="../../assets/imgs/warning2.gif">
                        <!--<span class="img-icon"></span>-->
                        <span class="txt-icon">{{wData2}}</span>个告警
                    </div>
                </div>
                <div class="info-text mt-10">
                    <div class="info-container">
                        <div class="info1">
                            <ul class="infos">
                                <li v-for="item in infos" :style="{ color: item.color }">
                                    <span>{{ item.text }}</span>
                                </li>
                            </ul>
                        </div>
                        <div class="info2"></div>
                    </div>
                </div>
            </div>
            <div id="warningMap"></div>
        </div>
        <div id="rightLine" class="rightLine">
            <Tabs type="card">
                <TabPane label="省份维度">
                    <Table v-bind:height="data1.length?825:null" :columns="columns1" :data="data1"></Table>
                </TabPane>
                <TabPane label="CP业务">
                    <Table v-bind:height="data1.length?825:null"  :columns="columns2" :data="data2"></Table>
                </TabPane>
            </Tabs>
        </div>
    </div>
</template>
<style lang="less">
    .map10{
        width: 1380px;
        height: 978px;
        zoom: 1;
    }
    .map10:after{
        content: "\0020";
        display: block;
        height: 0;
        clear: both;
    }
    .map10 .leftMap, .map10 .rightLine{
        height: 978px !important;
        border-top: 2px solid #2c3e65;
        font-size: 18px;
    }
    .map10 .leftMap{
        padding: 45px 60px 85px 85px!important;
    }
    .map10 .rightLine{
        padding: 50px 50px 50px 30px !important;
        ::-webkit-scrollbar
        {
            width: 10px;
            height: 6px;
        }
        ::-webkit-scrollbar-track-piece
        {
            background-color: #1c2a47;
            -webkit-border-radius: 10px;
        }
        ::-webkit-scrollbar-thumb:vertical
        {
            height: 10px;
            background-color: #283655;
            -webkit-border-radius: 10px;
        }
    }
    .map10 #warningMap{
        width: 764px;
        height: 634px;
        margin-top: 60px;
        margin-left: 15px;
    }
    .info-view{
        height: 140px;
    }
    .info-text{
        overflow: hidden;
        .info-container{
            width: 5000%;
            .info1,.info2{
                float: left;
            }
            .infos{
                list-style: disc;
                li{
                    float: left;
                    margin-right: 47px;
                }
            }
        }
    }
    .info-img{
        color:#CDCFD3;
        .txt-icon{
            font-size: 45px;
            color: #fff;
        }
        .img-danger, .img-warn{
            display: inline-block;
            img{
                width: 80px;
                height: 80px;
                margin-bottom: -20px;
            }
        }
        .img-warn{
            margin-left: 55px;
        }
    }
    .tipTitle{
        font-weight: normal;
        font-size: 21px;
        margin-bottom: 12px;
    }
    .map10{
        .ivu-tabs-nav-container{
            font-size: 19px;
            height: 45px !important;
        }
        .ivu-tabs-bar{
            margin-bottom: 0;
        }
        .ivu-tabs-nav{
            width: 100%;
        }
        .ivu-tabs.ivu-tabs-card>.ivu-tabs-bar .ivu-tabs-tab{
            background: #283655;
            border: none;
            color: #7a8090;
            border-radius: 0;
            margin-right: 0;
            width: 50%;
            text-align: center;
            height: 45px;
            line-height: 45px;
            padding: 0;
        }
        .ivu-tabs.ivu-tabs-card>.ivu-tabs-bar .ivu-tabs-tab-active{
            background: #234385;
            border: none;
            color: #fff;
            border-radius: 0;
            height: 45px;
            line-height: 45px;
            width: 50%;
            text-align: center;
            padding: 0;
        }
        .ivu-tabs-bar{
            border-bottom: none;
        }
        .ivu-tabs{
            border: 2px solid #2c3e65;
        }
        .ivu-tabs .ivu-tabs-tabpane{
            height: 830px;
            border-top: 0;
        }
        .ivu-table{
            background-color: #1d2b46;
            color: #fff;
            font-size: 18px;
            .ivu-table-body, .ivu-table-tip{
                padding: 10px 0 23px 0;
            }
            th{
                background-color: #1f2e4d;
                border-bottom: none;
                color: #525b73;
                height: 45px;
                font-weight: normal;
            }
            td{
                background-color: #1d2b46;
                border-bottom: none;
            }
            tr td:first-child{
                width: 150px;
            }
        }
        .ivu-table:before{
            background-color: #1d2b46;
        }
        .ivu-table:after{
            background-color: #1d2b46;
        }
        .ivu-table-wrapper{
            border: none;
        }
    }

</style>
<script type="text/ecmascript-6">
    import echarts from 'echarts'
    import {demo,color,colorD,textStyle,labelStyle,seriesLabelStyle,itemHeight,itemWidth,axisLabel,axisLine} from '../../assets/js/demoCharts'
    export default{
        data(){
            return {
                infos:[],
                wData1: 0,
                wData2: 0,
                timer: '',
                columns1: [
                    {
                        title: '省份',
                        key: 'province'
                    },
                    {
                        title: '告警1',
                        key: 'warning1'
                    },
                    {
                        title: '告警2',
                        key: 'warning2'
                    }
                ],
                data1: [],
                columns2: [
                    {
                        title: '业务',
                        key: 'CP'
                    },
                    {
                        title: '告警1',
                        key: 'warning1'
                    },
                    {
                        title: '告警2',
                        key: 'warning2'
                    }
                ],
                data2: [],
                mapChart: '',
                geoCoordMap: [{
                    '北京':[116.4551-1, 40.2539],
                    '天津':[117.4219-1, 39.4189],
                    '河北省':[114.4995-1, 38.1006],
                    '山西省':[112.3352-1, 37.9413],
                    '内蒙古':[111.4124-1, 40.4901],
                    '辽宁省':[123.1238-1, 42.1216],
                    '吉林省':[125.8154-1, 44.2584],
                    '黑龙江省':[127.9688-1, 45.368],
                    '上海':[121.4648-1, 31.2891],
                    '江苏省':[118.8062-1, 31.9208],
                    '浙江省':[119.5313-1, 29.8773],
                    '安徽省':[117.29-1, 32.0581],
                    '福建省':[119.4543-1, 25.9222],
                    '江西省':[116.0046-1, 28.6633],
                    '山东省':[117.1582-1, 36.8701],
                    '河南省':[113.4668-1, 34.6234],
                    '湖北省':[114.3896-1, 30.6628],
                    '湖南省':[113.0823-1, 28.2568],
                    '广东省':[113.5107-1, 23.2196],
                    '广西省':[108.479-1, 23.1152],
                    '海南省':[110.3893-1, 19.8516],
                    '重庆省':[107.7539-1, 30.1904],
                    '四川省':[103.9526-1, 30.7617],
                    '贵州省':[106.6992-1, 26.7682],
                    '云南省':[102.9199-1, 25.4663],
                    '西藏':[91.1865-1, 30.1465],
                    '陕西省':[109.1162-1, 34.2004],
                    '甘肃省':[103.5901-1, 36.3043],
                    '青海省':[101.4038-1, 36.8207],
                    '宁夏':[106.3586-1, 38.1775],
                    '新疆':[87.9236-1, 43.5883],
                },
                {
                    '北京':[116.4551, 40.2539],
                    '天津':[117.4219, 39.4189],
                    '河北省':[114.4995, 38.1006],
                    '山西省':[112.3352, 37.9413],
                    '内蒙古':[111.4124, 40.4901],
                    '辽宁省':[123.1238, 42.1216],
                    '吉林省':[125.8154, 44.2584],
                    '黑龙江省':[127.9688, 45.368],
                    '上海':[121.4648, 31.2891],
                    '江苏省':[118.8062, 31.9208],
                    '浙江省':[119.5313, 29.8773],
                    '安徽省':[117.29, 32.0581],
                    '福建省':[119.4543, 25.9222],
                    '江西省':[116.0046, 28.6633],
                    '山东省':[117.1582, 36.8701],
                    '河南省':[113.4668, 34.6234],
                    '湖北省':[114.3896, 30.6628],
                    '湖南省':[113.0823, 28.2568],
                    '广东省':[113.5107, 23.2196],
                    '广西省':[108.479, 23.1152],
                    '海南省':[110.3893, 19.8516],
                    '重庆省':[107.7539, 30.1904],
                    '四川省':[103.9526, 30.7617],
                    '贵州省':[106.6992, 26.7682],
                    '云南省':[102.9199, 25.4663],
                    '西藏':[91.1865, 30.1465],
                    '陕西省':[109.1162, 34.2004],
                    '甘肃省':[103.5901, 36.3043],
                    '青海省':[101.4038, 36.8207],
                    '宁夏':[106.3586, 38.1775],
                    '新疆维吾尔自治区':[87.9236, 43.5883],
                },
                {
                    '北京':[116.4551+1, 40.2539],
                    '天津':[117.4219+1, 39.4189],
                    '河北省':[114.4995+1, 38.1006],
                    '山西省':[112.3352+1, 37.9413],
                    '内蒙古自治区':[111.4124+1, 40.4901],
                    '辽宁省':[123.1238+1, 42.1216],
                    '吉林省':[125.8154+1, 44.2584],
                    '黑龙江省':[127.9688+1, 45.368],
                    '上海':[121.4648+1, 31.2891],
                    '江苏省':[118.8062+1, 31.9208],
                    '浙江省':[119.5313+1, 29.8773],
                    '安徽省':[117.29+1, 32.0581],
                    '福建省':[119.4543+1, 25.9222],
                    '江西省':[116.0046+1, 28.6633],
                    '山东省':[117.1582+1, 36.8701],
                    '河南省':[113.4668+1, 34.6234],
                    '湖北省':[114.3896+1, 30.6628],
                    '湖南省':[113.0823+1, 28.2568],
                    '广东省':[113.5107+1, 23.2196],
                    '广西省':[108.479+1, 23.1152],
                    '海南省':[110.3893+1, 19.8516],
                    '重庆省':[107.7539+1, 30.1904],
                    '四川省':[103.9526+1, 30.7617],
                    '贵州省':[106.6992+1, 26.7682],
                    '云南省':[102.9199+1, 25.4663],
                    '西藏自治区':[91.1865+1, 30.1465],
                    '陕西省':[109.1162+1, 34.2004],
                    '甘肃省':[103.5901+1, 36.3043],
                    '青海省':[101.4038+1, 36.8207],
                    '宁夏':[106.3586+1, 38.1775],
                    '新疆维吾尔自治区':[87.9236+1, 43.5883],
                }]
            }
        },
        methods:{
            Marquee(container, demo){
                if(demo.offsetWidth-container.scrollLeft<=0){
                    container.scrollLeft-=demo.offsetWidth;
                }else{
                    container.scrollLeft++;
                }
            },
            /**
             * 消息轮播
             */
            scrollView(){
                let container = document.getElementsByClassName('info-text')[0];
                let demo1 = document.getElementsByClassName('info1')[0];
                if(container.offsetWidth < demo1.offsetWidth ){
                    let demo2 = document.getElementsByClassName('info2')[0];
                    demo2.innerHTML = demo1.innerHTML;
                    let $this = this;
                    this.timer = setInterval(function(){
                        $this.Marquee(container, demo2);
                    },30);
                }else{
                    if(this.timer){
                        clearInterval(this.timer);
                    }
                }
            },
            /**
             * 格式化地图数据
             */
            getMapData(){
                let oData = JSON.parse(JSON.stringify(this.data1));
                let mapData = {};
                let pLength = {};
                let names = ['warning1', 'warning2', 'normal'];
                oData.forEach(function(Item, I) {
                    pLength[Item.province] = 0;
                    names.forEach(function(item, i){
                        if(Item[item]!=0){
                            if(!mapData[item]){
                                mapData[item] = {};
                            }
                            mapData[item][Item.province] = Item[item];
                            if(i != 2){
                                pLength[Item.province]++;
                            }

                        }
                    })
                });

                return [mapData, pLength];
            },
            /**
             * 绘制地图
             */
            drawDayMap(){
                this.mapChart = echarts.init(document.getElementById('warningMap'));
                let [mapData, pLength] = this.getMapData();
                let color = {
                    'warning1':'#ef5e80',
                    'warning2':'#ff9e40',
                    'normal':'#66cc99'
                };
                let name = {
                    'warning1':'告警1',
                    'warning2':'告警2',
                    'normal':'正常'
                };
                let series = [];
                let $this = this;
                let count = 0;
                for(var key in mapData){
                    if(key != 'normal'){
                        series.push({ //被攻击点样式
                            name: name[key],
                            type: 'effectScatter',
                            coordinateSystem: 'geo',
                            zlevel: 2,
                            rippleEffect: { //涟漪特效
                                period: 4, //动画时间，值越小速度越快
                                brushType: 'stroke', //波纹绘制方式 stroke, fill
                                scale: 10 //波纹圆环最大限制，值越大波纹越大
                            },
                            label: {
                                normal: {
                                    show: true,
                                    position: 'right',//显示位置
                                    offset:[5, 0], //偏移设置
                                    formatter: '{b}', //圆环显示文字
                                    textStyle:{
                                        color: '#fff'
                                    }
                                },
                                emphasis: {
                                    show: false
                                }
                            },
                            symbol: 'circle',
                            symbolSize: function(val) {
                                return 5; //圆环大小
                            },
                            itemStyle: {
                                normal: {
                                    show: false,
                                    color: color[key]
                                }
                            },
                            data: (function(){
                                let sData = [];
                                for(var province in mapData[key]){
                                    pLength[province]--;
                                    if($this.geoCoordMap[count][province]){
                                        sData.push({
                                            name: province,
                                            value: $this.geoCoordMap[count][province].concat(mapData[key][province]),
                                            label: {
                                                normal: {
                                                    show: pLength[province]==0?true:false
                                                },
                                            },
                                        });
                                    }
                                }
                                return sData;
                            })()
                        });
                        count++;
                    }
                }
                let option = {
                    title: {
                        text: '全网实时告警信息',
                        left:'center',
                        top: 15,
                        textStyle: {
                            fontSize: 21,
                            color: '#fff',
                            fontWeight: 400
                        }
                    },
                    tooltip: {
                        trigger: 'item',
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding: 10,
                        textStyle:{
                            color: '#333'
                        },
                        formatter: function(params) {
                            let pName = params.name;
                            return `<div style="padding: 10px; font-size: 18px;">
                                    <div class="tipTitle">全网安全监控</div>
                                    省份:<span>${pName}</span><br/>
                                    <div style="margin-top: 10px;"><b class="echart-circle line-20" style="background-color: ${color['warning1']}"></b>告警1：${mapData['warning1'][pName]?mapData['warning1'][pName]:0}个</div>
                                    <div style="margin-top: 10px;"><b class="echart-circle" style="background-color: ${color['warning2']}"></b>告警2：${mapData['warning2'][pName]?mapData['warning2'][pName]:0}个</div>
                                    <div style="margin-top: 10px;"><b class="echart-circle" style="background-color: ${color['normal']}"></b>正常：<span>${mapData['normal'][pName]?mapData['normal'][pName]:0}个</span></div>
                                    </div>
                                    `
                        }
                    },
                    legend: {
                        orient: 'horizontal',
                        left: 50,
                        bottom: 0,
                        itemWidth: 13,
                        itemHeight: 13,
                        itemGap: 50,
                        textStyle:{
                            color: '#fff',
                            fontSize: 18,
                        },
                        data: [name['warning1'], name['warning2']]
                    },
                    geo: {
                        map: 'china',
                        label: {
//                            normal: {
//                                show: true,
//                                textStyle: {
//                                    color: '#fff'
//                                }
//                            },
                            emphasis: {
                                show: false
                            }
                        },
                        layoutCenter: ['50%', '53%'], //地图位置
                        layoutSize: "108%",
                        itemStyle: {
                            normal: {
                                color: 'rgba(51, 69, 89, .5)', //地图背景色
                                borderColor: 'rgba(100,149,237,1)' //省市边界线
                            },
                            emphasis: {
                                color: 'rgba(37, 43, 61, .5)' //悬浮背景
                            }
                        }
                    },
                    series: series
                };
                this.mapChart.setOption(option);
            }
        },
        mounted(){
            this.infos = [{color: '#ff7394', text: '2017/10/13 15:34:33  江苏/机房GL-GZL-10312/80 疑似激增'},{color: '#ffab5a', text: '2017/10/13 15:34:33  江苏/机房GL-G -负载'}];
            this.wData1 = 37;
            this.wData2 = 101;
            // 头部数据
//            this.$http.get('/map/getInfoData').then(res=>{
//                res.data = [{color: '#ff7394', text: '2017/10/13 15:34:33  江苏/机房GL-GZL-10312/80 疑似激增'},{color: '#ffab5a', text: '2017/10/13 15:34:33  江苏/机房GL-G -负载'}];
//                this.infos = res.data.infos;
//                this.wData1 = res.data.warning1;
//                this.wData1 = res.data.warning2;
//            });

            this.data1 = [{province:'北京', warning1: 74, warning2: 30, normal: 50},{province:'上海', warning1: 36, warning2: 0, normal: 60},{province:'新疆维吾尔自治区', warning1: 0, warning2: 20, normal: 0}];
            this.drawDayMap();
            //省份维度数据
//            this.$http.get('/map/getProvinceData').then(res=>{
//                res.data = [{province:'北京', warning1: 74, warning2: 30, normal: 50},{province:'上海', warning1: 36, normal: 60},{province:'新疆维吾尔自治区', warning2: 20}];
//                this.data1 = res.data;
//                this.drawDayMap();
//            });
            //CP业务数据
            this.data2 = [{CP:'CP1-业务1', warning1: 74, warning2: 30, normal: 50},{CP:'CP2-业务2', warning1: 36, warning2: 0, normal: 60},{CP:'CP3-业务3', warning1: 0, warning2: 20, normal: 0},{CP:'CP1-业务1', warning1: 74, warning2: 30, normal: 50},{CP:'CP2-业务2', warning1: 36, warning2: 0, normal: 60},{CP:'CP3-业务3', warning1: 0, warning2: 20, normal: 0},{CP:'CP1-业务1', warning1: 74, warning2: 30, normal: 50},{CP:'CP2-业务2', warning1: 36, warning2: 0, normal: 60},{CP:'CP3-业务3', warning1: 0, warning2: 20, normal: 0},{CP:'CP1-业务1', warning1: 74, warning2: 30, normal: 50},{CP:'CP2-业务2', warning1: 36, warning2: 0, normal: 60},{CP:'CP3-业务3', warning1: 0, warning2: 20, normal: 0},{CP:'CP1-业务1', warning1: 74, warning2: 30, normal: 50},{CP:'CP2-业务2', warning1: 36, warning2: 0, normal: 60},{CP:'CP3-业务3', warning1: 0, warning2: 20, normal: 0},{CP:'CP1-业务1', warning1: 74, warning2: 30, normal: 50},{CP:'CP2-业务2', warning1: 36, warning2: 0, normal: 60},{CP:'CP3-业务3', warning1: 0, warning2: 20, normal: 0},{CP:'CP1-业务1', warning1: 74, warning2: 30, normal: 50},{CP:'CP2-业务2', warning1: 36, warning2: 0, normal: 60},{CP:'CP3-业务3', warning1: 0, warning2: 20, normal: 0}];
            this.drawDayMap();
//            this.$http.get('/map/getCPData').then(res=>{
//                res.data = [{CP:'CP1-业务1', warning1: 74, warning2: 30, normal: 50},{CP:'CP2-业务2', warning1: 36, normal: 60},{CP:'CP3-业务3', warning2: 20}];
//                this.data2 = res.data;
//                this.drawDayMap();
//            });

            this.$nextTick(function(){
                this.scrollView();
            })
        },
        beforeDestroy(){
            clearInterval(this.timer);
        }
    }
</script>
