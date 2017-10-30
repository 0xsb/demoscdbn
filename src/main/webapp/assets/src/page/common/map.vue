<template>
    <div id="map">
        <div class="header">
            <div class="pull-left logo-info">
                <img src="../../assets/imgs/logo.png" @click="$router.push('/home')">
                <span>全网流量资源管理平台</span>
            </div>
        </div>
        <h1>国际公司流量分析专题</h1>
        <h2>网络部 <span>2017-06-30 13:00</span></h2>
        <div class="map">
            <div id="map-content">
                <h3>一、国际公司整体分析
                </h3>
                <div class="map-wrapper">
                    <div id="port"></div>
                    <div id="port2"></div>
                </div>
                <div class="map-wrapper">
                    <div id="port3"></div>
                    <div id="tobuy"></div>
                    <p class="info">*：图中数据为示意数据，下同</p>
                    <p class="info">#：CMNET国际流量为计算出流量，下同</p>
                    <p class="info">数据来源：网络部自采数据 2017-06-25</p>
                </div>
                <h3>二、国际公司各业务流量详情分析</h3>
                <div class="map-wrapper">
                    <div id="rose"></div>
                    <div id="rose2"></div>
                </div>
                <div class="map-wrapper">
                    <div id="rose3"></div>
                    <div id="rose4"></div>
                    <p class="info">*：图中数据为示意数据，下同</p>
                    <p class="info">#：CMNET国际流量为计算出流量，下同</p>
                    <p class="info">数据来源：网络部自采数据 2017-06-25</p>
                </div>
                <h3>三、国际公司各业务流量趋势分析</h3>
                <div class="map-wrapper">
                    <div id="line"></div>
                    <p class="info">*：图中数据为示意数据，下同</p>
                    <p class="info">#：CMNET国际流量为计算出流量，下同</p>
                    <p class="info">数据来源：网络部自采数据 2017-06-25</p>
                </div>
            </div>
        </div>
        <my-foot></my-foot>
    </div>
</template>
<style lang="less">
.info{
    font-size: 12px;
    color: #999;
    text-align: right;
}
#map{
    h1{
        width: 80%;
        margin: 98px auto 10px auto;
        text-align: center;
        font-size: 24px;
        color: #333;
        padding-bottom: 10px;
        border-bottom: 1px solid #eee;
    }
    h2{
        width: 80%;
        margin: 0 auto;
        text-align: center;
        font-weight: normal;
        font-size: 14px;
    }
}
.map{
    width: 1200px;
    margin: 20px auto;
    padding-top:30px;
    h3{
        width: 100%;
        text-align: left;
        font-size: 16px;
        font-weight: normal;
        padding-bottom: 20px;
        border-bottom: 1px solid #eee;
    }
}
.map-wrapper{
    width: 100%;
    overflow: hidden;
    margin-bottom: 40px;
    margin-top: 10px;
}
.map-nav{
    float: right;
    span{
        width: 90px;
        height: 36px;
        font-size: 14px;
        color: #333;
        background: #f0f5fd;
        text-align: center;
        line-height: 36px;
        display: inline-block;
        cursor: pointer;
        &.active{
            background: #3694f2;
            color: #FFF;
         }
    }
}
#map-content{
    height: 490px;
    float: left;
    width: 100%;
}
#port,#port2,#port3,#tobuy,#rose,#rose2,#rose3,#rose4{
    width: 575px;
    height: 400px;
    float: left;
}
#port2,#tobuy,#rose2,#rose4{
    margin-left: 50px;
}

#line{
    width: 1000px;
    height: 400px;
    margin: 0 auto;
}
</style>
<script type="text/ecmascript-6">
    import echarts from 'echarts';
    import myFoot from '../../components/common/foot'
    const portData = {
        xData: ['CMNET国际','付费穿透','付费直连','免费直连','收费用户'],
        portNumber: [67.000,25.000,4.000,91.000,61.000],
        portNumber2: [365.9099,165.7301,11.6208,217.7476,46.9006],
        portNumber3: [621.5172,232.8306,37.2529,1031.9054,458.3411]
    }
    const tobuy = {
        roseData: ['PCCW','GTT','Level3','TeliaSonera','NTT'],
        detaiData: [
            {name:'PCCW',value:'18'},
            {name: 'NTT',value: '47.8418'},
            {name: 'Level3',value: '23.9290'},
            {name: 'TeliaSonera',value: '28.9887'},
            {name: 'GTT',value: '35.5489'},
        ],
        roseData2:['苹果','Akamai','淘宝...','ACT...','微软','HOSTSPACE NETWORKS LLC','Vietnam Telecom International (VNPT-I)','China Mobile Hong Kong Ltd','Mega Target Communication Ltd','Enzu Inc.','其他'],
        roseDetailData:[
            {name:'苹果',value:'25.0424'},
            {name:'淘宝...',value:'1.9949'},
            {name:'微软',value:'1.1436'},
            {name:'HOSTSPACE NETWORKS LLC',value:'0.7628'},
            {name:'Vietnam Telecom International (VNPT-I)',value:'0.4652'},
            {name:'China Mobile Hong Kong Ltd',value:'0.4163'},
            {name:'Akamai',value:'14.2259'},
            {name:'ACT...',value:'1.1212'},
            {name:'Mega Target Communication Ltd',value:'0.3132'},
            {name:'Enzu Inc',value:'1.0210'},
            {name:'其他',value:'1.0210'},
        ],
        roseData3:['Equinix Internet Exchange','HKIX','卓越亚马逊','Hurricane Electric','HiNet','苹果','Any2','Akamai','CloudFlare','DE-CIX','其他'],
        roseDetailData3:[
            {name:'Equinix Internet Exchange',value:'37.6756'},
            {name:'HKIX',value:'28.1729'},
            {name:'卓越亚马逊',value:'20.2679'},
            {name:'Hurricane Electric',value:'15.7592'},
            {name:'HiNet',value:'13.6477'},
            {name:'苹果',value:'12.8147'},
            {name:'Any2',value:'12.1886'},
            {name:'Akamai',value:'12.0563'},
            {name:'CloudFlare',value:'8.3562'},
            {name:'DE-CIX',value:'7.8349'},
            {name:'其他',value:'48.9735'},
        ]
    }
    const line = {
        tagName : ['付费穿透','付费直连','收费客户','免费直连'],
        data:[
            {
                name:'付费穿透',
                type:'bar',
                data:[165.7301,65.7301,144.7301, 95.7301,115.7301,68.7301,201.7301]
            },
            {
                name:'付费直连',
                type:'bar',
                data:[11.6209,34.6209, 52.6209, 33.6209,26.6209, 77.6209,11.6209]
            },
            {
                name:'收费客户',
                type:'bar',
                data:[46.9007, 42.9007, 51.9007, 41.9007, 47.9007, 38.9007,33.9007]
            },
            {
                name:'免费直连',
                type:'bar',
                data:[217.7477,217.7477,222.7477, 198.7477, 165.7477,177.7477,167.7477]
            },
            {
                name:'付费穿透',
                type:'line',
                yAxisIndex: 1,
                data:[22,25,21,24,22,23,26]
            },
            {
                name:'付费直连',
                type:'line',
                yAxisIndex: 1,
                data:[24,26,23,26,24,25,28]
            },
            {
                name:'收费客户',
                type:'line',
                yAxisIndex: 1,
                data:[19,22,20,23,22,23,25]
            },
            {
                name:'免费直连',
                type:'line',
                yAxisIndex: 1,
                data:[41,42,43,41,39,38,36]
            }
        ]
    }
    const color = ['#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
        '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
        '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'];
    export default {
        data() {
            return {
                chart: null
            };
        },
        components:{
            myFoot
        },
        methods: {
            drawbar(id) {           //一号柱状图
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title : {
                        text: '国际公司端口分布',
                        textStyle:{
                            fontWeight: 'normal',
                            fontSize: 14
                        },
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {},
                            dataView: {}
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
                            type: 'category',
                            boundrayGap: false,
                            data:portData.xData
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value',
                            name: '端口数量，个',
                            max: 100,
                            nameLocation: 'middle',
                            nameGap:30
                        }
                    ],
                    series: [
                        {
                            name: '端口数量',
                            type: 'bar',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'top'
                                }
                            },
                            itemStyle:{
                                normal:{
                                    color: function (params){
                                        var colorList = ['#4ba3fa','#85cef4','#ff944c','#ffd957','#b7e331'];
                                        return colorList[params.dataIndex];
                                    }
                                }
                            },
                            barWidth:'50px',
                            data: portData.portNumber
                        }
                    ]
                });
            },
            drawbar2(id) {           //二号柱状图
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title : {
                        text: '国际公司带宽分布*',
                        textStyle:{
                            fontWeight: 'normal',
                            fontSize: 14
                        },
                        left : 'center'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {},
                            dataView: {}
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
                            type: 'category',
                            boundrayGap: false,
                            data:portData.xData
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value',
                            name: '带宽',
                            max: 1200,
                            nameLocation: 'middle',
                            nameGap:30
                        }
                    ],
                    series: [
                        {
                            name: '国际公司带宽分布*',
                            type: 'bar',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'top'
                                }
                            },
                            itemStyle:{
                                normal:{
                                    color: function (params){
                                        var colorList = ['#4ba3fa','#85cef4','#ff944c','#ffd957','#b7e331'];
                                        return colorList[params.dataIndex];
                                    }
                                }
                            },
                            barWidth:'50px',
                            data: portData.portNumber3
                        }
                    ]
                });
            },
            drawbar3(id){       //三号柱状图
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title : {
                        text: '国际公司各类业务日均流量#',
                        textStyle:{
                            fontWeight: 'normal',
                            fontSize: 14
                        },
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {},
                            dataView: {}
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
                            type: 'category',
                            boundrayGap: false,
                            data:portData.xData
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value',
                            name: '日均流量GBPS',
                            max: 400,
                            nameLocation: 'middle',
                            nameGap:30
                        }
                    ],
                    series: [
                        {
                            name: '日均流量GBPS',
                            type: 'bar',
                            label: {
                                normal: {
                                    show: true,
                                    position: 'top'
                                }
                            },
                            itemStyle:{
                                normal:{
                                    color: function (params){
                                        var colorList = ['#4ba3fa','#85cef4','#ff944c','#ffd957','#b7e331'];
                                        return colorList[params.dataIndex];
                                    }
                                }
                            },
                            barWidth:'50px',
                            data: portData.portNumber2
                        }
                    ]
                });
            },
            drawpie(id) {
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    tooltip : {
                        formatter: "{a} <br/>{b} : {c}%"
                    },
                    title:{
                        text: '国际流量付费率',
                        subtext: '付费率=（付费穿透+付费直连）/ CMNET国际流量',
                        textStyle:{
                            fontWeight: 'normal',
                            fontSize: 14
                        },
                        left: 'center'
                    },
                    grid: {
                        left: '15%',
                        right: '4%',
                        bottom: '15%',
                        containLabel: true
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            mark : {show: true},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    series : [
                        {
                            name:'国际流量付费率',
                            type:'gauge',
                            detail : {formatter:'{value}%'},
                            data:[{value: 48.47, name: '付费率'}]
                        }
                    ]
                });
            },
            drawrose(id) {
                this.chart = echarts.init(document.getElementById(id),'infographic');
                this.chart.setOption({
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    title : {
                        text: '国际公司付费穿透业务TOP10流量分布',
                        textStyle:{
                            fontWeight: 'normal',
                            fontSize: 14
                        },
                        left: 'center'
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {},
                            dataView: {}
                        },
                        right: 15,
                        top: 10
                    },
                    legend: {
                        orient: 'vertical',
                        left: 5,
                        top: 50,
                        data: tobuy.roseData,
                    },
                    calculable: true,
                    series: [
                        {
                            name: '日均流量，GBPS',
                            type: 'pie',
                            radius: [0, '75%'],
                            center: ['60%', '50%'],
                            roseType: 'radius',
                            data: tobuy.detaiData,
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
                    ]
                });
            },
            drawrose2(id) {
                this.chart = echarts.init(document.getElementById(id),'infographic');
                this.chart.setOption({
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    title : {
                        text: '国际公司付费直联业务TOP10流量分布',
                        textStyle:{
                            fontWeight: 'normal',
                            fontSize: 14
                        },
                        left: 'center'
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {},
                            dataView: {}
                        },
                        right: 15,
                        top: 10
                    },
                    legend: {
                        orient: 'vertical',
                        left: 5,
                        top: 50,
                        data: ['Cogent'],
                    },
                    calculable: true,
                    series: [
                        {
                            name: '日均流量，GBPS',
                            type: 'pie',
                            radius: [0, '75%'],
                            center: ['60%', '50%'],
                            roseType: 'radius',
                            data: [{name:'Cogent',value:'11.6208'}],
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
                    ]
                });
            },
            drawrose3(id) {
                this.chart = echarts.init(document.getElementById(id),'infographic');
                this.chart.setOption({
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    title : {
                        text: '国际公司收费客户业务TOP10 流量分布',
                        textStyle:{
                            fontWeight: 'normal',
                            fontSize: 14
                        },
                        left: 'center'
                    },
                    startAngle:0,
                    toolbox: {
                        feature: {
                            saveAsImage: {},
                            dataView: {}
                        },
                        right: 15,
                        top: 10
                    },
                    legend: {
                        orient: 'vertical',
                        left: 5,
                        top: 50,
                        data: tobuy.roseData2,
                    },
                    calculable: true,
                    series: [
                        {
                            name: '日均流量，GBPS',
                            type: 'pie',
                            radius: [0, '75%'],
                            center: ['60%', '50%'],
                            roseType: 'radius',
                            data: tobuy.roseDetailData,
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
                    ]
                });
            },
            drawrose4(id) {
                this.chart = echarts.init(document.getElementById(id),'infographic');
                this.chart.setOption({
                    tooltip: {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    title : {
                        text: '国际公司免费直连业务TOP10 流量分布',
                        textStyle:{
                            fontWeight: 'normal',
                            fontSize: 14
                        },
                        left: 'center'
                    },
                    startAngle:0,
                    toolbox: {
                        feature: {
                            saveAsImage: {},
                            dataView: {}
                        },
                        right: 15,
                        top: 10
                    },
                    legend: {
                        orient: 'vertical',
                        left: 5,
                        top: 50,
                        data: tobuy.roseData3,
                    },
                    calculable: true,
                    series: [
                        {
                            name: '日均流量，GBPS',
                            type: 'pie',
                            radius: [0, '75%'],
                            center: ['60%', '50%'],
                            roseType: 'radius',
                            data: tobuy.roseDetailData3,
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
                    ]
                });
            },
            drawline(id) {
                this.chart = echarts.init(document.getElementById(id), 'line');
                this.chart.setOption(
                    {
                        title:{
                            text:'国际公司各类业务流量趋势分析*',
                            textStyle:{
                                fontWeight: 'normal',
                                fontSize: 14
                            },
                            left: 'center'
                        },
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'cross',
                                crossStyle: {
                                    color: '#999'
                                }
                            }
                        },
                        toolbox: {
                            feature: {
                                dataView: {show: true, readOnly: false},
                                magicType: {show: true, type: ['line', 'bar']},
                                restore: {show: true},
                                saveAsImage: {show: true}
                            }
                        },
                        legend: {
                            data:line.tagName,
                            top: '8%'
                        },
                        xAxis: [
                            {
                                type: 'category',
                                data: ['Day1','Day2','Day3','Day4','Day5','Day6','Day7'],
                                axisPointer: {
                                    type: 'shadow'
                                }
                            }
                        ],
                        yAxis: [
                            {
                                type: 'value',
                                name: '日均流量GBPS',
                                min: 0,
                                max: 250,
                                nameLocation: 'middle',
                                nameGap:30
                            },
                            {
                                type: 'value',
                                name: '百分比',
                                min: 0,
                                max: 100,
                                axisLabel: {
                                    formatter: '{value} %'
                                },
                                nameLocation: 'middle',
                                nameGap:30
                            }
                        ],
                        series: line.data
                    }
                );
            }
        },
        mounted() {
            this.$nextTick(function() {
                this.drawbar('port');
                this.drawbar2('port2');
                this.drawbar3('port3');
                this.drawpie('tobuy');
                this.drawrose('rose');
                this.drawrose2('rose2');
                this.drawrose3('rose3');
                this.drawrose4('rose4');
                this.drawline('line');
            });
        }
    }
</script>
