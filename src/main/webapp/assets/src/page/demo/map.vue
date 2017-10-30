<template>
    <div class="demo-map-wrapper">
        <div id="demo-map-container">
            <h1>
                <span class="select left">
                    <Select v-model="defaultSelect.value" @on-change="checkPage">
                        <Option v-for="item in mapList" :value="item.value" :key="item.value">{{ item.label }}</Option>
                    </Select>
                </span>
                <span class="titleWords">内容网络流量管理系统</span>
                <b class="now">{{resetDate}}</b>
            </h1>
            <div class="demo-map-item">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>
<style lang="less">
.demo-map-wrapper{
    width: 100%;
    height: 100%;
    background:#1d2b46;
}
#demo-map-container{
    background: #1d2b46;
    width: 1400px;
    height: 1050px;
    /*margin: 0 auto;*/
    overflow: hidden;
    padding: 0 20px 20px 20px;
    padding-left:0px;
    h1{
        font-size: 26px;
        height: 52.5px;
        line-height: 52.5px;
        color: #FFF;
        position: relative;
        text-align: center;
        .now{
            color: #feffff;
            float: right;
            font-size: 20px;
            font-weight: normal;
            height: 20px;
            width: 275px;
            line-height: 80px;
        }
        .titleWords{
            position: absolute;
            left:40%;
        }
        .select{
            position: absolute;
            left: 0;
            line-height: normal;
            bottom:-3px;
            width: 300px;
            height: 50px;
            background: url(../../assets/imgs/select_bg.png) no-repeat;
            background-size:contain;
            .ivu-select-dropdown{
                border-radius: 0;
                margin: 0;
                padding: 0;
                min-height: 240px;
                background: transparent;
                color: #FFF;
                font-size: 14px;
                width: 263px !important;
            }
            .ivu-select-selected-value{
                height: 50px;
            }
            .ivu-select-selection{
                border:0;
                background: none;
                height: 50px;
                box-shadow: none;
            }
            .ivu-select-item{
                height: 40px;
                text-align: left;
            }
            .ivu-select-item-selected, .ivu-select-item-selected:hover,.ivu-select-item:hover{
                background: #1d2b46;
                color:#f8db54
            }
            .ivu-select-item.ivu-select-item-selected{
                color: #f8db54;
            }
            .ivu-select-item{
                font-size: 16px !important;
                color: #FFF;
                background: #1d2b46;
                filter:alpha(opacity=80);
                -moz-opacity:0.8;
                -khtml-opacity: 0.8;
                opacity: 0.8;
            }
            .ivu-select-arrow{
                right:35px;
                font-size: 20px;
                color: #FFF;
            }
            .ivu-select-single .ivu-select-selection .ivu-select-placeholder, .ivu-select-single .ivu-select-selection .ivu-select-selected-value{
                font-size: 20px;
                color: #FFF;
                line-height: 50px;
                text-align: left;
                padding-left: 20px;
            }
        }
    }
    .border{
        border: 2px solid #2c3e65;
    }
    .ivu-select.ivu-select-single{
        width: 265px;
        height: 50px;
        margin-left: -35px;
    }
}
.demo-map-item{
    background: #1d2b46;
    overflow: hidden;
    height:997.5px;
}
.update-time{
    font-size: 14px;
    color: #FFF;
}
.clearfix{
    overflow: hidden;
    zoom: 1;
}
.h475{
    height: 475px;
}
.map-container{
    display: flex;
}
.h585{
    height: 585px;
}
.w750{
    width: 750px;
}
</style>
<script type="text/ecmascript-6">
    export default{
        data(){
            return {
                mapList:[
                    {
                        label:'内容网络建设情况',
                        value: 'map7'
                    },
                    {
                        label: '内容网络流量情况',
                        value: 'map8'
                    },
                    {
                        label:'全网流量分析',
                        value: 'map1'
                    },
                    {
                        label: '互联网公司流量分析',
                        value: 'map2'
                    },
                    {
                        label: '国际流量分析',
                        value: 'map3'
                    },
                    {
                        label: '拥塞监控效果提升',
                        value: 'map4'
                    },
                    {
                        label: '内容网络点击分析',
                        value: 'map5'
                    },
                    {
                        label: 'IP户籍计划',
                        value: 'map6'
                    },
                ],
                defaultSelect:{
                    label:'内容网络建设情况',
                    value: 'map7'
                },
                resetDate:''
            }
        },
        methods:{
            checkPage(value){
                this.$router.push('/demo/'+value);
                window.localStorage.setItem('page',value);
            }
        },
        mounted(){
            this.$http.get('/data/showdatajson?child=hlwll&name=cjdk').then(res=>{
                this.resetDate = '数据更新:'+res.data.time;
            }).catch((res)=>{
                console.log(res);
            });
            /*setInterval(()=>{
                const D = new Date();
                let YY = D.getFullYear();
                let MM = (D.getMonth()+1)<10?'0'+(D.getMonth()+1):(D.getMonth()+1);
                let DD = D.getDate()<10?'0'+D.getDate():D.getDate();
                let HH = D.getHours()<10?'0'+D.getHours():D.getHours();
                let MI = D.getMinutes()<10?'0'+D.getMinutes():D.getMinutes();
                let SS = D.getSeconds()<10?'0'+D.getSeconds():D.getSeconds();
                let string = YY+ '-' + MM + '-'+ DD +'  ' + HH + ':' + MI + ':' + SS;
            },1000);*/
//            setInterval(()=>{
//                window.location.reload();
//            },300000);
//            this.defaultSelect.value = window.localStorage.getItem('page') || 'map7'
        }
    }

</script>
