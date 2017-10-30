<template>
    <div>
        <ul class="header_content">
            <li class="content">
                <p class="mt-20 fz-20">全网边缘节点</p>
                <div class="num-map">
                    <span class="rollImg1"></span><rollNum :num="edgeNode1" class="rollNum1"></rollNum><span class="rollUnit1">个</span>
                </div>
                <div class="num-map">
                    <span class="rollImg2"></span><rollNum :num="edgeNode2" class="rollNum2"></rollNum><span class="rollUnit2">台</span>
                </div>
            </li>
            <li class="content">
                <p class="mt-20 fz-20">建设容量/Tbps</p>
                <div class="num-map">
                    <span class="rollImg3"></span><rollNum :num="buildContent" class="rollNum3"></rollNum><span class="rollUnit3">Tbps</span>
                </div>
            </li>
            <li class="content">
                <p class="mt-20 fz-20">利用率%</p>
                <div class="num-map">
                    <span class="rollImg4"></span><rollNum :num="usageRate" class="rollNum3"></rollNum><span class="rollUnit3">%</span>
                </div>
            </li>
        </ul>
        <div class="mouseIn" @mouseover='mouseIn()'  @mouseout="mouseOut()">
            <div class="navContent">
                <div class="navbar">
                    <Select v-model="defaultSelect.value" @on-change="checkPage">
                        <Option v-for="item in mapList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                </div>
            </div>
            <div id="leftMap" class="leftMap"></div>
            <div id="rightLine" class="rightLine"></div>
        </div>
    </div>
</template>
<style lang="less" >
.header_content {
    width: 100%;
    height: 248px;
    .content {
        float: left;
        height:100%;
        width: 33.3%;
        color: white;
        text-align: center;
        border:2px solid #2c3e65;
        box-sizing:border-box;
        .mt-20{
            margin-top:20px;
            font-size:20px;
        }
        .num-map{
            width: 100% !important;
            margin: 0 auto;
            overflow:hidden;
        .rollImg1{
            width: 60px;
            height: 40px;
            float: left;
            margin-left: 140px;
            background: url(../../assets/imgs/map7-1.png) no-repeat;
            background-size:contain;
            margin-top: 20px;
        }
        .rollNum1{
            width: 100px;
            height:50px;
            margin-top: 20px;
            float: left;
            margin-left: 30px;
        }
        .rollUnit1{
            float: left;
            color: #9297a1;
            font-size: 18px;
            margin-top: 35px;
            margin-left:10px;
            vertical-align: bottom;
        }
        .rollImg2{
            width: 60px;
            height: 40px;
            float: left;
            margin-left: 140px;
            background: url(../../assets/imgs/map7-2.png) no-repeat;
            background-size:contain;
            margin-top: 30px;
        }
        .rollNum2{
            width: 130px;
            height:50px;
            float: left;
            margin-top: 30px;
        }
        .rollUnit2{
            float: left;
            color: #9297a1;
            font-size: 18px;
            margin-top: 45px;
            margin-left: 10px;
            vertical-align: bottom;
        }
        .rollImg3{
            width: 60px;
            height: 60px;
            float: left;
            margin-left: 90px;
            background: url(../../assets/imgs/map7-3.png) no-repeat;
            background-size:contain;
            margin-top: 40px;
        }
        .rollNum3{
            width: 160px;
            height:60px;
            float: left;
            margin-top: 40px;
            margin-left:30px;
                .num-con{
                    display: inline-block;
                    width: 40px;
                    height: 60px;
                    position: relative;
                    overflow: hidden;
                    &:nth-of-type(3){
                        .num-item{
                            position: absolute;
                            width: 40px;
                            font-size: 52px;
                            color: #F0F0F0;
                            height: 80px;
                            margin-top: 0px;
                        }
                     }
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
                    width: 40px;
                    font-size: 36px;
                    color: #F0F0F0;
                    height: 40px;
                li{
                    height: 60px;
                    line-height: 65px;
                    text-align: center;
                    font-size: 65px;
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
        .rollUnit3{
            float: left;
            color: #9297a1;
            font-size: 25px;
            margin-top: 65px;
            margin-left: 10px;
            vertical-align: bottom;
        }
        .rollImg4{
            width: 60px;
            height: 60px;
            float: left;
            margin-left: 110px;
            background: url(../../assets/imgs/map7-4.png) no-repeat;
            background-size:contain;
            margin-top: 40px;
        }
        .num-con{
            display: inline-block;
            width: 25px;
            height: 50px;
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
    width: 25px;
    font-size: 33px;
    color: #F0F0F0;
    height: 40px;
li{
    height: 50px;
    line-height: 50px;
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
        .num-map:last-child{
            width: 240px;
            margin: 0px auto;
            font-size: 20px;
            padding-top: 5px;
        }
        .unit{
            display: inline-block;
            font-size:20px;
        }
    }
    .content:nth-child(2){
        border-left:0;
        border-right:0;
    }

}
.mouseIn {
    overflow:hidden;
    height:730px;
    .navContent {
        width: 99.9%;
        border-left: 2px solid #2c3e65;
        border-right: 2px solid #2c3e65;
        padding-top: 30px;

    .navbar {
        /*margin-top: 30px !important;*/
        border-top: none;
        border-bottom: none;
        box-sizing: border-box;

    .ivu-select-selection {
        height: 50px !important;
        background: #273759;
        border: none;
        border-radius: 0;
        &:hover {
            background: #3c92f7;
        }
    }
    .ivu-select-selected-value {
        height: 50px !important;
        font-size: 20px !important;
        line-height: 50px !important;
        color: #fff;
        margin-left: 10px;
    }

    .ivu-select-arrow {
        right: 20px;
        font-size: 20px;
        color: #FFF;
    }

    .ivu-select-dropdown {
        border-radius: 0;
        margin: 0;
        padding: 0;
        min-height: 120px;
        background: transparent;
        color: #FFF;
        font-size: 14px;
        width: 268px !important;
    }

    .ivu-select-item {
        height: 40px;
        font-size: 18px !important;
        line-height: 30px;
        color: white;
    }

    .ivu-select-item-selected, .ivu-select-item-selected:hover, .ivu-select-item:hover {
        background: #1d2b46 !important;
        color: #f8db54
    }

    .ivu-select-item.ivu-select-item-selected {
        color: #f8db54;
    }

    }
    }
}


#demo-map-container .navbar{
    width: 255px;
    margin:0 auto;
    height:50px;
}
#leftMap{
    float: left;
    width:953px;
    height: 635px;
    border-left:2px solid #2c3e65;
    border-bottom:2px solid #2c3e65;
}
#rightLine{
    float: left;
    width: 427px;
    height: 635px;
    border-right:2px solid #2c3e65;
    border-bottom:2px solid #2c3e65;
}
</style>
<script type="text/ecmascript-6">
    import echarts from 'echarts'
    import{map7lyl,map7jsrl,map7byjd}from '../../assets/js/demoCharts'
    import rollNum from '../../components/common/rollNum.vue'
    import {axisLine,axisLabel,textStyle,map3data,timeData} from '../../assets/js/demoCharts'
    let sortProvince =(data)=>{
        let obj = {
            name:[],
            value:[]
        };
        let array = [];
        for(let obj of data){
            if(obj.name!='全国'){
                array.push(obj);
            }
        }
        array.sort((a,b)=>{
            return b.value- a.value;
        })
        array.map(i=>{
            obj.name.push(i.name);
            obj.value.push(i.value);
        });
        obj.name = obj.name.slice(0,10);
        obj.value = obj.value.slice(0,10);
        return obj;
    }
    let sortBuildusage = (data)=>{
        let obj = {
            value:[],
            name:[]
        };
        let array = [];
        for(let obj of data){
            if(obj.name!='全国'){
                array.push(obj);
            }
        }
        array.sort((a,b)=>{
            return b.value- a.value;
        })
        array.map(i=>{
            obj.name.push(i.name);
            obj.value.push(i.value);
        });
        obj.name = obj.name.slice(0,10);
        obj.value = obj.value.slice(0,10);
        return obj;
    }
    let sortEdgenode = (data)=>{
        let obj = {
            name:[],
            value:[]
        };
        let array = [];
        for(let obj of data){
            if(obj.name!='全国'){
                array.push(obj);
            }
        }
        array.sort((a,b)=>{
            return b.value- a.value;
        })
        array.map(i=>{
            obj.name.push(i.name);
            obj.value.push(i.value);
        });
        obj.name = obj.name.slice(0,10);
        obj.value = obj.value.slice(0,10);
        return obj;
    }
    export default{
        data(){
            return {
                flag:true,
                defaultSelect:{
                    label:'利用率全网对比',
                    value: 'map7-1'
                },
                edgeNode1:'',
                edgeNode2:'',
                buildContent:'',
                usageRate:'',
                mapList:[
                    {
                        label:'利用率全网对比',
                        value: 'map7-1'
                    },
                    {
                        label:'建设容量全网对比',
                        value: 'map7-2'
                    },
                    {
                        label:'边缘节点全网对比',
                        value: 'map7-3'
                    },
                ],
                lyl:[],
                jsrl:[],
                byjd:[],
                run:true,
            }
        },
        methods:{
            drawMap(id,data){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title: {
                        text: '全国各省分布',
                        left: '450px',
                        top:'10px',
                        textStyle:{
                            color:'#cdcfd3',
                            fontSize:20,
                            fontWeight:'bold'
                        },
                    },
                    toolbox:{
                        right:60,
                        feature:{
                            saveAsImage: {},
                            restore: {},
                            dataView: {},
                        }
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter:'{b}:{c}%',
                    },
                    visualMap: {
                        type: 'piecewise', //分段型。
                        splitNumber: 6,
                        inverse: true,
                        textGap:5,
                        pieces: [{
                            min: 0,
                            max: 20,
                            label:'<20%',
                            color: '#33d0b0'
                        },
                            {
                                min: 20,
                                max: 40,
                                label:'20%-40%',
                                color: '#ffde69'
                            },
                            {
                                min: 40,
                                label:'>40%',
                                color: '#419ffc'
                            }],
                        left: '6%',
                        bottom: '5%',
                        textStyle: {
                            color: '#fff'
                        },
                    },
                    series: [
                        {
                            type: 'map',
                            mapType: 'china',
                            left: '10%',
                            top: '15%',
                            roam: false,
                            zoom:1,
                            itemStyle:{
                                normal: {
                                    areaColor: '#1d2b46',
                                    borderColor:'#ccc'
                                },
                            },
                            label: {
                                normal: {
                                    show: true,
                                    textStyle: {
                                        color: '#fff',
                                    },
                                    formatter: function (params) {
                                        if(!params.value){
                                            return params.name
                                        }else{
                                            return params.name +'\n'+ params.value+'%';
                                        }
                                    },
                                },
                            },
                            data: data,
                        }
                    ]
                })
            },
            drawLine(id,data,formatter){
                this.chart = echarts.init(document.getElementById(id));
                this.chart.setOption({
                    title: {
                        text: 'TOP 10省份',
                        left: 'center',
                        top:'10px',
                        textStyle:{
                            color:'#cdcfd3',
                            fontWeight:'bold'
                        },
                    },
                    tooltip : {
                        trigger: 'axis',
                        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                        },
                        formatter:function(data){
                            let t = data[0];
                            if(formatter=='map7-1'){
                                return `${t.name}:${t.value}%`
                            }else if(formatter=='map7-2'){
                                return `${t.name}:${t.value} Tbps`
                            }else if(formatter=='map7-3'){
                                return `${t.name}:${t.value}个`
                            }
                        }
                    },
                    toolbox:{
                        right:20,
                        feature:{
                            saveAsImage: {},
                            restore: {},
                            dataView: {},
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis : [
                        {
                            type : 'value',
                            axisLine,
                            splitLine:{
                                show:false
                            },
                        },
                    ],
                    yAxis : [
                        {
                            type: 'category',
                            data: data.name,
                            inverse:'true',
                            axisLine,
                            splitLine:{
                                show:false
                            },
                        },
                    ],
                    series : [
                        {
                            type:'bar',
                            barWidth: '60%',
                            data:data.value,
                            label: {
                                normal: {
                                    show: true,
                                    position: 'right',
                                    formatter:function(data){
                                        if(formatter=='map7-1'){
                                            return `${data.value}%`
                                        }else if(formatter=='map7-2'){
                                            return `${data.value}Tbps`
                                        }else if(formatter=='map7-3'){
                                            return `${data.value}个`
                                        }
                                    }
                                },
                                emphasis:{
                                    formatter:function(data){
                                        if(formatter=='map7-1'){
                                            return `${data.value}%`
                                        }else if(formatter=='map7-2'){
                                            return `${data.value}Tbps`
                                        }else if(formatter=='map7-3'){
                                            return `${data.value}个`
                                        }
                                    }
                                }
                            },
                            itemStyle: {
                                normal: {
                                    color: function(params) {
                                        var colorList = [
                                            '#ef5e80', '#da5ef9','#566eff','#68c5f5','#3abaa0',
                                            '#3aba70','#b7e871','#f4de4a','#ffb54c','#ff6666',
                                        ];
                                        return colorList[params.dataIndex]
                                    },
                                }
                            },
                        }
                    ]
                })
            },
            checkPage(v,name){
                if(name=='map7-1'){
                    this.defaultSelect.value='map7-1';
                }
                if(name=='map7-2'){
                    this.defaultSelect.value='map7-2';
                }
                if(name=='map7-3'){
                    this.defaultSelect.value='map7-3';
                }
                if(v=='map7-1'){
                    this.drawMap("leftMap",this.changeValue(this.lyl,'liyonglv'));
                    this.drawLine('rightLine',sortProvince(this.changeValue(this.lyl,'liyonglv')),'map7-1');
                }
                if(v=='map7-2'){
                    this.$http.get('/data/showdatajson?child=wljs&name=jsrl').then(res=>{
                        this.jsrl = this.changeValue(res.data.jsrl,'rongliang');
                    }).then(res=>{
                        this.chart = echarts.init(document.getElementById('leftMap'));
                        this.chart.setOption({
                            title: {
                                text: '全国各省分布',
                                left: '450px',
                                top:'10px',
                                textStyle:{
                                    color:'#cdcfd3',
                                    fontSize:20,
                                    fontWeight:'bold'
                                },
                            },
                            toolbox:{
                                right:60,
                                feature:{
                                    saveAsImage: {},
                                    restore: {},
                                    dataView: {},
                                }
                            },
                            tooltip: {
                                trigger: 'item',
                                formatter:'{b}:{c}',
                            },
                            visualMap: {
                                type: 'piecewise', //分段型。
                                splitNumber: 6,
                                inverse: true,
                                textGap:5,
                                pieces: [{
                                    min: 0,
                                    max: 0.5,
                                    label:'<0.5 Tbps',
                                    color: '#33d0b0'
                                }, {
                                    min: 0.5,
                                    max: 2,
                                    label:'0.5-2 Tbps',
                                    color: '#ffde69'
                                }, {
                                    min: 2,
                                    label:'>2 Tbps',
                                    color: '#419ffc'
                                }],
                                left: '6%',
                                bottom: '5%',
                                textStyle: {
                                    color: '#fff'
                                },
                            },
                            series: [
                                {
                                    type: 'map',
                                    mapType: 'china',
                                    left: '10%',
                                    top: '15%',
                                    roam: false,
                                    zoom:1,
                                    label: {
                                        normal: {
                                            borderColor: 'white',
                                            show: true,
                                            formatter: function (params) {
                                                if(!params.value){
                                                    return params.name
                                                }else{
                                                    return params.name +'\n'+ params.value;
                                                }
                                            },
                                        },
                                    },
                                    data: this.jsrl,
                                }
                            ]
                        })
                        this.drawLine("rightLine",sortBuildusage(this.jsrl),'map7-2');
                    }).catch(res=>{
                        console.log(res);
                    })
                }
                if(v=='map7-3'){
                    this.$http.get('/data/showdatajson?child=wljs&name=byjd').then(res=>{
                        this.byjd = this.changeValue(res.data.byjd,'geshu');
                    }).then(res=>{
                        this.chart = echarts.init(document.getElementById('leftMap'));
                        this.chart.setOption({
                            title: {
                                text: '全国各省分布',
                                left: '450px',
                                top:'10px',
                                textStyle:{
                                    color:'#cdcfd3',
                                    fontSize:20,
                                    fontWeight:'bold'
                                },
                            },
                            toolbox:{
                                right:60,
                                feature:{
                                    saveAsImage: {},
                                    restore: {},
                                    dataView: {},
                                }
                            },
                            tooltip: {
                                trigger: 'item',
                                formatter:'{b}:{c}',
                            },
                            visualMap: {
                                type: 'piecewise', //分段型。
                                splitNumber: 6,
                                inverse: true,
                                textGap:5,
                                pieces: [{
                                    min: 0,
                                    max: 5,
                                    label:'<5(个)',
                                    color: '#33d0b0'
                                }, {
                                    min: 5,
                                    max: 10,
                                    label:'5-10(个)',
                                    color: '#ffde69'
                                }, {
                                    min: 10,
                                    label:'>10(个)',
                                    color: '#419ffc'
                                }],
                                left: '6%',
                                bottom: '5%',
                                textStyle: {
                                    color: '#fff'
                                },
                            },
                            series: [
                                {
                                    name: '',
                                    type: 'map',
                                    mapType: 'china',
                                    left: '10%',
                                    top: '15%',
                                    roam: false,
                                    zoom:1,
                                    label: {
                                        normal: {
                                            show: true,
                                            formatter: function (params) {
                                                if(!params.value){
                                                    return params.name
                                                }else{
                                                    return params.name +'\n'+ params.value;
                                                }
                                            },
                                        },
                                    },
                                    data: this.byjd,
                                }
                            ]
                        })
                        this.drawLine('rightLine',sortEdgenode(this.byjd),'map7-3')
                    }).catch(res=>{
                        console.log(res);
                    })
                }
            },
            changeValue(array,key){
                let arr = [];
                for(let item of array){
                    arr.push({
                        "name":item.name,
                        "value":item[key]
                    })
                }
                return arr;
            },
            mouseIn(){
                this.run = false;
                console.log(this.run);
            },
            mouseOut(){
                this.run = true;
                console.log(this.run);
            }
        },
        mounted(){
            this.$nextTick(function(){
                this.$http.get('/data/showdatajson?child=wljs&name=zonghe').then(res=>{
                    this.zonghe = res.data.zonghe;
                    this.edgeNode1 = this.zonghe.byjdgeshu;
                    this.edgeNode2 = this.zonghe.byjdtaishu;
                    this.buildContent = this.zonghe.jsrl;
                    this.usageRate = this.zonghe.lyl;
                }).catch(res=>{
                    console.log(res);
                })

                this.$http.get('/data/showdatajson?child=wljs&name=lyl').then(res=>{
                    this.lyl = res.data.lyl;
                }).then(()=>{
                    this.drawMap("leftMap",this.changeValue(this.lyl,'liyonglv'));
                    this.drawLine('rightLine',sortProvince(this.changeValue(this.lyl,'liyonglv')),'map7-1')
                }).then(()=>{
                    let i = 1;
                    setInterval(()=>{
                        if(this.run == true){
                            i++;
                            this.checkPage('map7-'+i,'map7-'+i);
                            if(i==3){
                                i=0;
                            }
                        }
                    },10000);
                }).catch(res=>{
                    console.log(res);
                });
            })
        },
        beforeDestroy(){
            this.run = false;
        },
        components:{
            rollNum
        }
    }
</script>
