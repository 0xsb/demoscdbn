<template>
    <div>
        <div class="module-header">
            <h4>本省率分析
                <span class="role-text ml-20">权限选择</span>
                <Select v-model="province" :label-in-value="true" style="width:160px;margin-left: 15px">
                    <Option v-for="item in selectionList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                </Select>
            </h4>
        </div>
        <Tabs type="card" class="country" :animated="false">
            <Tab-pane label="日视图">
                <div class="search-item">
                    <span class="role-text ml-20">数据选择：</span>
                    <DatePicker type="date" placement="bottom-end" :clearable="false" :value="dayView.searchTime" :options="options" @on-change="setDayTime" placeholder="选择查询日期"></DatePicker >
                    <span class="role-text ml-20">{{provinceFormat}}</span>
                </div>
                <div class="text-center f18 view-title">
                    <span>{{provinceFormat}}</span>
                    <span class="ml-20">{{dateFormat}}</span>
                    <span class="ml-20">数据</span>
                </div>
                <div class="country" v-show="init||province=='country'">
                    <Row class="mt-20">
                        <Col span="16">
                            <div id="dayMap" style="width:100%;height: 800px;"></div>
                        </Col>
                        <Col span="8">
                            <Table :columns="dayView.columns" :data="dayView.countryData"></Table>
                        </Col>
                    </Row>
                </div>
                <div class="province f16" v-show="init||province!='country'">
                    <Row class="mt-20">
                        <Col span="12">
                            <Card class="rateCard" :padding="25">
                                <p>
                                    <span>流量本省率</span>
                                    <span class="rate-value"><span class="rate-blue">{{dayView.provinceData.flowRate}}</span>%</span>
                                </p>
                                <p>
                                    <span>地市用户入流量日均值</span>
                                    <span class="rate-value"><span class="rate-blue">{{dayView.provinceData.companyInflow.mean}}</span>Gbps</span>
                                </p>
                                <p>
                                    <span>省建Cache流量日均值</span>
                                    <span class="rate-value"><span class="rate-blue">{{dayView.provinceData.PCache.mean}}</span>Gbps</span>
                                </p>
                                <p>
                                    <span>省建CDN流量日均值</span>
                                    <span class="rate-value"><span class="rate-blue">{{dayView.provinceData.PCDN.mean}}</span>Gbps</span>
                                </p>
                                <p>
                                    <span>统建CDN流量日均值 </span>
                                    <span class="rate-value"><span class="rate-blue">{{dayView.provinceData.SCDN.mean}}</span>Gbps</span>
                                </p>
                                <p>
                                    <span>IDC流量日均值 </span>
                                    <span class="rate-value"><span class="rate-blue">{{dayView.provinceData.IDC.mean}}</span>Gbps</span>
                                </p>
                            </Card>
                        </Col>
                        <Col span="12">
                            <div id="dayGauge" style="height:400px;"></div>
                        </Col>
                    </Row>
                    <div id="dayLine" style="height:400px;"></div>
                </div>
            </Tab-pane>
            <Tab-pane label="周视图">

            </Tab-pane>
            <Tab-pane label="月视图">

            </Tab-pane>
        </Tabs>
    </div>
</template>
<style lang="less" scoped>
    .search-item{
        font-size: 14px;
        height: 60px;
        line-height: 60px;
        background-color: #fafbfd;
    }
    .rate-value{
        float: right;
    }
    .rateCard{
        margin: 43px;
        line-height: 2;
        p{
            clear: both;
        }
    }
    .rate-blue{
        color: #3694f2;
        font-size: 20px !important;
        margin-right: 5px;
    }
    .fa{
        margin-left: 2px;
    }
    .fa-long-arrow-up{
        color: #ff944c;
    }
    .fa-long-arrow-down{
        color: #afdb27;
    }
    .fa-same{
        color: #3694f2;
        font-size: 2em;
    }
    .view-title{
        padding: 40px;
    }
</style>
<script type="text/ecmascript-6">
    import echarts from 'echarts'
    import china from 'echarts/map/js/china'
    import {axisLine,axisLabel,textStyle,map3data,timeData} from '../../assets/js/demoCharts'
    export default{
        data() {
            return {
                init: true,
                selectionList: [],
                province: 'country',
                dayView:{
                    mapChart: '',
                    gaugeChart: '',
                    lineChart: '',
                    searchTime: new Date(new Date()-24*60*60*1000).toLocaleDateString(),
                    provinceData: {
                        flowRate: 0,
                        companyInflow: {mean:0, peak:0},
                        PCache: {mean:0, peak:0},
                        PCDN: {mean:0, peak:0},
                        SCDN: {mean:0, peak:0},
                        IDC: {mean:0, peak:0}
                    },
                    countryData:[],
                    columns: [
                        {
                            type: 'index',
                            align: 'center',
                            title: '排名'
                        },
                        {
                            title: '省份',
                            key: 'province'
                        },
                        {
                            title: '本省率',
                            key: 'provinceRate',
                            sortable: true,
                            render: (h, params) =>{
                                let className = '';
                                let child = [];
                                switch(params.row.trend){
                                    case 'up': className = 'fa fa-long-arrow-up fa-lg';  break;
                                    case 'down': className = 'fa fa-long-arrow-down fa-lg'; break;
                                    case 'same': className = 'fa fa-lg fa-same'; child.push('-');break;
                                }
                                return h('div', [params.row.provinceRate+'%', h('i', {class: className}, child)]);
                            }
                        }
                    ]
                },
                options:{
                    disabledDate (date) {
                        return date && date.valueOf() > Date.now() - 86400000;
                    }
                }
            }
        },
        methods:{
            setDayTime(value){
                this.dayView.searchTime = value;
            },
            drawDayMap(){
                this.dayView.mapChart = echarts.init(document.getElementById('dayMap'));
                this.dayView.mapChart.setOption({
                    tooltip: {
                        trigger: 'item',
                        formatter:'{b}:{c}%'
                    },
                    legend:{
                        show: false
                    },
                    visualMap: {
                        min: 0,
                        max: 100,
                        left: 'center',
                        top: 'bottom',
                        text: ['100', '0'],
                        orient: 'horizontal',
                        inRange: {
                            color: ['#e1f0ff', '#3694f2']
                        },
                        calculable: false
                    },
                    series: [
                        {
                            type: 'map',
                            top: '20px',
                            mapType: 'china',
                            roam: false,
                            label: {
                                normal: {
                                    normal: {
                                        show: true
                                    },
                                    emphasis: {
                                        show: true
                                    }
                                },
                            },
                            data: []
                        }
                    ]
                })
            },
            drawDayGauge(){
                this.dayView.gaugeChart = echarts.init(document.getElementById('dayGauge'));
                this.dayView.gaugeChart.setOption({
                    title: {
                        text: '流量本省率',
                        left: 'center'
                    },
                    tooltip: {
                        formatter: "{a} <br/>{b} : {c}%"
                    },
                    toolbox: {
                        show: false
                    },
                    series: [
                        {
                            splitLine:{
                                show: false
                            },
                            axisTick: {
                                show: false
                            },
                            axisLine: {
                                lineStyle: {
                                    color: [
                                        [0.2, '#ff944c'],
                                        [0.8, '#3694f2'],
                                        [1, '#b7e331']
                                    ],
                                    width: 12
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: '#999999'
                                }
                            },
                            name: '',
                            type: 'gauge',
                            detail : {
                                // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                                formatter: function (value) {
                                    return value+'%';
                                },
                                offsetCenter: [0, '65%'],
                                fontFamily: 'Arial',
                                color: '#7f7f7f',
                                fontSize: 27
                            },
                            data: []
                        }
                    ]
                })
            },
            drawDayLine(){
                this.dayView.lineChart = echarts.init(document.getElementById('dayLine'));
                this.dayView.lineChart.setOption({
                    title: {
                        text: '本省流量详情分布',
                        x:'center'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        x:'right',
                        y: '20px',
                        orient: 'vertical',
                        data:['日流量均值', '日流量峰值']
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    toolbox: {
                        show: false
                    },
                    xAxis: {
                        type: 'category',
                        data: ['地市公司入流量','省建Cache','统建CDN','省建CDN','IDC']
                    },
                    yAxis: {
                        type: 'value',
                        splitLine:{
                            show:false
                        }
                    },
                    color:['#3694f2','#ff944c'],
                    series: [
                        {
                            symbol:'rect',
                            symbolSize: 10,
                            name:'日流量均值',
                            type:'line',
                            data:[]
                        },
                        {
                            symbol:'rect',
                            symbolSize: 10,
                            name:'日流量峰值',
                            type:'line',
                            data:[]
                        }
                    ]
                })
            },
            getMapData(data){
                let mapData = [];
                data.forEach((item, index)=>{
                    let mapItem = {};
                    mapItem.name = item.province;
                    mapItem.value = item.provinceRate;
                    mapData.push(mapItem);
                });
                return mapData;
            },
            getMapHeight(){
                let height = (document.documentElement.clientWidth - 260)/2;
                document.getElementById('dayMap').style.height = height+'px';
            },
            renderDayView() {
                if (this.init) {
                    this.drawDayMap();
                    this.drawDayGauge();
                    this.drawDayLine();
                    this.init = false;
                }
                if (this.province == 'country') {
//                    this.$http.get('/dataManage/getCountryData?searchTime='+this.dayView.searchTime+'&provine='+this.province).then(res => {
                    this.dayView.countryData = [{"province":"北京","provinceRate":26,"trend":"up"},{"province":"安徽","provinceRate":57,"trend":"same"},{"province":"浙江","provinceRate":74,"trend":"down"}];
//                        res.data = [{"province":"北京","provinceRate":26,"trend":"up"},{"province":"安徽","provinceRate":57,"trend":"same"},{"province":"浙江","provinceRate":74,"trend":"down"}];
//                        this.dayView.countryData = res.data;
                        this.dayView.mapChart.setOption({
                            series: [{
                                data: this.getMapData(this.dayView.countryData)
                            }]
                        });
//                    });
                } else {
                    this.$http.get('/dataManage/getProvinceDay?searchTime='+this.dayView.searchTime+'&provine='+this.province).then(res => {
                       res.data = {"flowRate":13,"companyInflow":{"mean":154,"peak":474},"PCache":{"mean":115,"peak":498},"PCDN":{"mean":235,"peak":488},"SCDN":{"mean":100,"peak":465},"IDC":{"mean":420,"peak":371}};
                        res = res.data;
                        this.dayView.provinceData = res;
                        this.dayView.gaugeChart.setOption({
                            series: [{
                                name: this.provinceFormat,
                                data: [{value: res.flowRate, name: '流量本省率'}]
                            }]
                        });
                        this.dayView.lineChart.setOption({
                            series: [
                                {data: [res.companyInflow.mean, res.PCache.mean, res.PCDN.mean, res.SCDN.mean, res.IDC.mean]},
                                {data: [res.companyInflow.peak, res.PCache.peak, res.PCDN.peak, res.SCDN.peak, res.IDC.peak]}
                            ]
                        });
                    });
                }
            }
        },
        mounted() {
//            this.$http.get('/dataManage/getProvinceList?').then(res=>{
//                res.data = [{"value":"country","label":"全国"},{"value":"beijing","label":"北京"},{"value":"zhejiang","label":"浙江"},{"value":"anhui","label":"安徽"}];
                this.selectionList = [{"value":"c untry","label":"全国"},{"value":"beijing","label":"北京"},{"value":"zhejiang","label":"浙江"},{"value":"anhui","label":"安徽"}];
//            });
            this.getMapHeight();
            this.renderDayView();

            window.addEventListener("resize", ()=>{
                if(this.dayView.mapChart){
                    this.getMapHeight();
                    this.dayView.mapChart.resize();
                }
                this.dayView.gaugeChart?this.dayView.gaugeChart.resize():'';
                this.dayView.lineChart?this.dayView.lineChart.resize():'';
            }, false);
        },
        watch: {
            'province': 'renderDayView',
            'dayView.searchTime': 'renderDayView'
        },
        computed: {
            dateFormat(){
                let date = this.dayView.searchTime.replace(/[^0-9]/ig,',').split(',');
                return date[0] + '年' + date[1] + '月' + date[2] + '日';
            },
            provinceFormat(){
                for(let i=0;i<this.selectionList.length;i++){
                    if(this.selectionList[i].value == this.province){
                        return this.selectionList[i].label;
                        break;
                    }
                }
            }
        }
    }
</script>
