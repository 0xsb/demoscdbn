<template>
    <div id="map">
        <div class="main_container">
            <div class="top_show">
                <div id="chart1">
                    <div class="title">国际流量连接示意图</div>
                </div>
                <div class="top_rightShow">
                    <div class="chart2">
                        <div id="chart2-1"></div>
                        <div id="chart2-2"></div>
                    </div>
                    <div id="chart3"></div>
                </div>
            </div>
            <div id="chart4"></div>
        </div>
    </div>
</template>
<style lang="less">
#map{
    width: 100%;
    .main_container{
        width: 1380px;
        margin:0 auto;
        height: 1050px;
    }
    .top_show{
        width: 100%;
        height: 65%;
        #chart1{
            float: left;
            width: 40%;
            height: 100%;
            background: url("../../assets/imgs/yuntu.svg") no-repeat center;
            background-size: 85% 85%;
            background-position-y: 15%;
            border: 2px solid #2c3e65;
            border-right:none;
            border-bottom:none;
            .title{
                width: 552px;
                text-align: center;
                font-size:24px;
                color: white;
                margin-top:20px;
                cursor:default ;
            }
        }
        .top_rightShow{
            float: left;
            width: 60%;
            height: 100%;
            .chart2{
                width: 100%;
                height: 50%;
                overflow:hidden;
                #chart2-1{
                    float: left;
                    width: 50%;
                    height: 100%;
                    border: 2px solid #2c3e65;
                    border-right:none;
                    border-bottom:none;
                }
                #chart2-2{
                    float: left;
                    width: 50%;
                    height: 100%;
                    border: 2px solid #2c3e65;
                    border-bottom:none;
                }
            }
            #chart3{
                height: 50%;
                border: 2px solid #2c3e65;
                border-bottom:none;
            }
        }
    }
    #chart4{
        width: 1380px;
        height: 28%;
        border: 2px solid #2c3e65;
    }
}
</style>
<script type="text/ecmascript-6">

    import echarts from 'echarts'
    import {axisLine,axisLabel,textStyle,map3data,timeData} from '../../assets/js/demoCharts'
    const braColor = ['#D5CB68','#5b9fe2','#6c5095','#c55475'];

    let data = Object.values(map3data.qsfx);

    export default{
        data() {
            return {
                chart: null,
                width: '1200px',
                dkll:[],  //map1  带宽流量--带宽
                liuliang:[],  //map1   带宽流量 --流量
                gjll:[],   //map2  国际流量付费率
                top10dk:[],  //map3   top10客户 带宽
                top10ll:[],  //map3  top10客户 流量,
                mapData:[],
                xzhou:[],
            };
        },
        methods:{
            drawTube(id,dkname,dkvalue,llvalue){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title: {
                        text: '带宽流量/Gbps',
                        x:'center',
                        y:15,
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
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    legend: {
                        right:'2%',
                        y:'20',
                        data: ['带宽','流量'],
                        itemWidth:15,
                        itemHeight:15,
                        textStyle:{
                            color: 'white',
                        }
                    },
                    xAxis: {
                        type: 'category',
                        axisLine,
                        data: dkname,
                    },
                    yAxis: {
                        type: 'value',
                        name: 'Gbps',
                        nameLocation: 'middle',
                        nameGap:30,
                        splitLine:{
                            show:false
                        },
                        axisLine,
                        splitNumber:10
                    },
                    series: [
                        {
                            name: '带宽',
                            type: 'bar',
                            data: dkvalue,
                            itemStyle: {
                                normal: {
                                    label: {
                                        show: true,//是否展示
                                        position: 'top',
                                    },
                                    color:'#5cb1ef'
                                }
                            },
                        },
                        {
                            name: '流量',
                            type: 'bar',
                            data: llvalue,
                            itemStyle: {
                                normal: {
                                    label: {
                                        show: true,//是否展示
                                        position: 'top',
                                    },
                                    color:'#F4D64A'
                                }
                            },
                        }
                    ]
                })
            },
            drawGuage(id,value){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title:{
                        text:'国际流量付费率',
                        x:'center',
                        y:20,
                        textStyle
                    },
                    tooltip : {
                        formatter: "付费率 <br/>{c}%",
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        }
                    },
                    series: [
                        {
                            type: 'gauge',
                            detail: {
                                formatter:'{value}%',
                                textStyle:{
                                    color:'white'
                                },
                                offsetCenter: [0, '50%'],
                            },
                            data: [{value: value}],
                            radius:'112.5',
                            center: ['50%', '60%'],
                            pointer:{
                            },
                            axisLabel:{
                                show:false
                            },
                            axisTick:{
                                show:false
                            },
                            axisLine: {            // 坐标轴线
                                lineStyle: {       // 属性lineStyle控制线条样式
                                    color: [[0.2, '#5cb1ef'], [0.7, '#F4D64A'], [1, '#EF5E80']],
                                    width:'28'
                                }
                            },
                            splitLine:{
                                show:false
                            },
                        }
                    ]
                })
            },
            drawTube2(id,top10name,dkvalue,llvalue,blankV1,blankV2){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    tooltip: {
                        backgroundColor:'rgba(255,255,255,0.9)',
                        padding:10,
                        textStyle:{
                            color: '#333'
                        },
                    },
                    title: [{
                        text: 'Top 10客户/Gbps',
                        x: '50%',
                        y:'10',
                        textAlign: 'center',
                        textStyle
                    }, ],
                    grid: [{
                        top: 50,
                        left:5,
                        width: '50%',
                        bottom:50,
                        containLabel: true
                    }, {
                        top: 50,
                        width: '45%',
                        left: '45%',
                        bottom:50,
                        containLabel: true
                    }],
                    legend: {
                        left:'45%',
                        bottom:'20',
                        data: ['带宽','流量'],
                        itemWidth:15,
                        itemHeight:15,
                        textStyle:{
                            color: 'white',
                        }
                    },
                    xAxis: [{
                        show:false
                    }, {
                        type: 'value',
                        gridIndex: 1,
                        splitLine: {
                            show: false
                        },
                        show:false
                    }],
                    yAxis: [{
                        type: 'category',
                        data: top10name,
                        axisLabel: {
                            interval: 0,
                        },
                        inverse:true,
                        splitNumber:10,
                        axisLine:{
                            show:false,
                            lineStyle:{
                                color:'#30436d'
                            }
                        },
                        axisTick:{
                            show:false,
                        },
                        splitLine: {
                            show: false
                        },
                        axisLine

                    }, {
                        show:false,
                        gridIndex: 1,
                        type: 'category',
                        data: top10name,
                        axisLabel: {
                            interval: 0,
                        },
                        splitLine: {
                            show: false
                        },
                        inverse:true,
                    }],
                    series: [{
                        name:'带宽',
                        type: 'bar',
                        stack: 'chart',
                        z: 3,
                        label: {
                            normal: {
                                position: 'right',
                                show: true,
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: '#5cb1ef'
                            }
                        },
                        barWidth:15,
                        data: dkvalue
                    }, {
                        type: 'bar',
                        stack: 'chart',
                        silent: true,
                        itemStyle: {
                            normal: {
                                color: '#1d2b46'
                            }
                        },
                        data: blankV1
                    },
                        {
                        name:'流量',
                        type: 'bar',
                        stack: 'component',
                        xAxisIndex: 1,
                        yAxisIndex: 1,
                        z: 3,
                        label: {
                            normal: {
                                position: 'right',
                                show: true,
                            },
                        },
                        inverse:true,
                        itemStyle: {
                            normal: {
                                color: '#f27554'
                            }
                        },
                        barWidth:15,
                        data: llvalue
                    },
                        {
                        type: 'bar',
                        stack: 'component',
                        silent: true,
                        xAxisIndex: 1,
                        yAxisIndex: 1,
                        itemStyle: {
                            normal: {
                                color: '#1d2b46'
                            }
                        },
                        data: blankV2
                    }, ]
                })
            },
            drawLine(id,value,xArias){       //实时流量分析
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title: {
                        text: '实时流量分析/Gbps',
                        x:'45%',
                        y:20,
                        textStyle
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {},
                            dataView: {},
                            magicType: {
                                type: ['stack', 'tiled']
                            },
                            restore: {show: true}
                        },
                    },
                    legend: {
                        left:'5%',
                        y:'25',
                        data: ['付费直连','付费穿透','免费直连','收费客户'],
                        itemWidth:15,
                        itemHeight:15,
                        textStyle:{
                            color: 'white',
                        }
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
                       /* formatter: function formatter(data) {
                            if (data[0].dataIndex == 24 || data[0].dataIndex == 0) {
                                if (data[0].dataIndex == 24) {
                                    return "今日"+data[0].dataIndex+"时:"+data[0].value;
                                }
                                if (data[0].dataIndex == 0) {
                                    return "昨日"+data[0].dataIndex+"时:"+data[0].value;
                                }
                            }else{
                                if (data[0].dataIndex>24) {
                                    return (data[0].dataIndex-24)+"时:"+data[0].value;
                                }
                                return data[0].dataIndex+"时:"+data[0].value;
                            }
                        }*/
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '10%',
                    },
                    xAxis: [
                        {
                            show:true,
                            type: 'category',
                            boundaryGap: false,
//                            data: this.timeColumn(),
                            data:xArias,
                            axisLabel: {
                                interval:((xArias.length-1)/24*3)-1,
                                show:true,
                                textStyle:{
                                    color: '#c0c6c4',
                                }
                            },
                            splitLine: {
                                show: false
                            },
                        }
                    ],
                    yAxis: [
                        {
                            show:true,
                            type: 'value',
                            name: 'Gbps',
                            nameLocation: 'middle',
                            nameGap:30,
                            splitLine: {
                                show: false
                            },
                            axisLine
                        }
                    ],
                    series: this.getmapData(value)
                })
            },
            getDataName(array){
                let arr = [];
                array.map((item)=>{
                    arr.push(item.name);
                });
                return arr;
            },
            getDataValue(array){
                let arr = [];
                array.map((item)=>{
                    arr.push(item.value);
                });
                return arr;
            },
            getBlankValue(array){
                let arr = [];
                array.map((item)=>{
                    arr.push(200-item.value);
                });
                return arr;
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

            getllRank(array,array2){
                let arr = [];
                array.map(item=>{
                   array2.map(item2=>{
                       if (item==item2.name){
                           arr.push({
                               "name":item2.name,
                               "value":item2.value
                           })
                       }
                   })
                });
                return arr;
            },
            tagMore(name,data){
                let array = [];
                    for(let i of data){
                        for(let j=0;j<i.length;j++){
                            if(name==i[j].name){
                                array.push(i[j].trafficins.toFixed(2))
                            }
                        }
                    }
                return array;
            },
            getmapData(value){
                let arr = Object.values(value);
                let array = [];
                for(let i=0;i<4;i++){
                    array.push(
                        {
                            name: arr[0][i].name,
                            type: 'line',
                            areaStyle: {
                                normal: {
                                    color:braColor[i]
                                }
                            },
                            data: this.tagMore(arr[0][i].name,arr),
                            smooth:true,
                            stack: '总量',
                            itemStyle: {
                                normal: {
                                    color:braColor[i]
                                }
                            },
                            symbol:'circle',
                        }
                    )
                }
                return array;
            },
            timeColumn(){
                let array = [];
                let str = '';
                let arr = Object.keys(this.mapData);
                /*for(let k=0;k<arr.length;k++){
                    if (k == 0) {
                        str = '昨日0' + '时';
                    }
                    if (k == 24) {
                        str = '今日0' + '时';
                    }
                    if (k > 24 && k < 48) {
                        str = k - 24 + '时';
                    }
                    if(k>0&&k<24){
                        str = k+'时';
                    }
                    array.push(str);
                }*/
                return arr;
            },
        },
        mounted(){
            this.$nextTick(function() {
                this.$http.get('/data/showdatajson?child=gjll&name=zonghe').then(res=>{
                    this.dkll = res.data.zonghe.dkll;
                    this.liuliang = res.data.zonghe.liuliang;
                    this.gjll = res.data.gjll.value;
                    this.top10dk = res.data.top10.daikuan;
                    this.top10ll = res.data.top10.liuliang;
                }).then(()=>{
                    this.drawTube("chart2-1",this.getDataName(this.dkll),this.getDataValue(this.dkll),this.getDataValue(this.liuliang));
                    this.drawGuage("chart2-2",this.gjll);
                    this.drawTube2('chart3',this.getNameRank(this.top10dk),this.getValueRank(this.top10dk),this.getllRank(this.getNameRank(this.top10dk),this.top10ll),this.getBlankValue(this.top10dk
                    ),this.getBlankValue(this.top10ll));
                }).catch((res)=>{
                    console.log(res);
                })
                this.$http.get('/data/showdatajson?child=gjll&name=ssllfx').then(res=>{
                    this.mapData = res.data.ssllfx;
                    this.xzhou = res.data.xzhou;
                }).then(()=>{
                    this.drawLine('chart4',this.mapData,this.xzhou);
                })
            });
        }
    }
</script>
