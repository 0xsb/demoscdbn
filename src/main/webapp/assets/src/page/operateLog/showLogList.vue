<template>
    <div class="log">
        <div class="module-header">
            <h4>日志操作</h4>
        </div>
        <div class="module-search">
            <div class="search-itemr">
                <div class="item">
                    <div class="search-label">上传时间：</div>
                    <div class="search-item">
                        <Date-picker type="date" placement="bottom-end" :value="log.startDate" :options="options" @on-change="setStart" placeholder="选择起始日期" style="width: 155px"></Date-picker>
                    </div>
                    <div class="line"></div>
                    <div class="search-item">
                        <Date-picker type="date" placement="bottom-end" :value="log.finDate" :options="options" @on-change="setFin" placeholder="选择结束日期" style="width: 155px"></Date-picker>
                    </div>
                    <div class="search-label ml-20">
                        类型：
                    </div>
                    <div class="search-item">
                        <Select v-model="log.logType" :label-in-value="true" @on-change="selectLog" style="width:110px;">
                            <Option v-for="item in logTypeList" :value="item.value" :key="item">{{ item.label }}</Option>
                        </Select>
                    </div>
                    <div class="search-label ml-20">
                        来源：
                    </div>
                    <div class="search-item">
                        <Select v-model="log.source" :label-in-value="true" @on-change="selectSource" style="width:110px;">
                            <Option v-for="item in sourceList" :value="item.value" :key="item">{{ item.label }}</Option>
                        </Select>
                    </div>
                </div>
                <div class="item">
                    <div class="search-label" style="width:80px;text-align:right;">结果：</div>
                    <div class="search-item">
                        <Select v-model="log.result" :label-in-value="true" @on-change="selectResult" style="width:110px;">
                            <Option v-for="item in resultList" :value="item.value" :key="item">{{ item.label }}</Option>
                        </Select>
                    </div>
                    <div class="search-label ml-20" style="width:80px;text-align:right;">用户姓名：</div>
                    <Input v-model="log.user" style="width: 350px"></Input>
                </div>
            </div>
            <div class="search-ctrll">
                <Button type="primary" class="btn-search ml-20 mt-10" @click="getLogData" :loading="loading">
                    <span v-if="!loading">立即检索</span>
                    <span v-else>检索中</span>
                </Button>
                <a class="text-blue" @click="reset">清空</a>
            </div>
        </div>
        <div class="search-result">
            <p class="search-content">已查找到<span>{{page.totalList}}</span>条数据</p>
            <a class="search-download" :src="download">下载检索结果文件</a>
        </div>
        <div class="tableContent">
            <Table width="auto" stripe border :columns="columns" :data="data" style="margin-top: 10px;"></Table>
            <div class="page" v-if="data">
                <Page :total="page.totalList" :page-size="50" @on-change="onChange"></Page>
            </div>
        </div>

    </div>
</template>
<style lang="less">
.log{
    .module-search:after{
        content: '';
        display: block;
        clear: both;
    }
    .search-itemr{
        width: 85%;
        float: left;
    }
    .search-ctrll{
        float: left;
        width: 140px;
        height: 80px;
        border-left:1px solid #ededed;
    }
}
@media (max-width:1255px){
    .log{
        .search-itemr{
            display: block;
            float: none;
            width: 100%;
        }
        .search-ctrll{
            display: block;
            float: none;
            width: 140px;
            height: 80px;
            border-left:1px solid #ededed;
        }
    }
}

</style>
<script type="text/ecmascript-6">
    import {loglisttables,showDataSelection,dateOptions} from '../../assets/js/data'
    import * as types from '../../assets/js/const'
    export default{
        data(){
            return {
                columns: loglisttables.columns,
                data: [],
                download:'',
                logTypeList:showDataSelection.logTypeList,
                sourceList: showDataSelection.sourceList,
                resultList: showDataSelection.resultList,
                options: dateOptions.options,
                log:{
                    user:'',
                    logType: 'all',
                    source: 'all',
                    result: 'all',
                    startDate: '2010-01-01',
                    finDate: this.getDate()
                },
                page:{
                    totalList: 0,
                    pageNum: 1,
                    pageSize: 50
                },
                loading:false,
            }
        },
        methods:{
            getLogData(e,pageSize=50,pageNum = this.page.pageNum){
                this.loading = true;
                let data = 'operateLog/showLogList?pageSize=50&userName='+this.log.user+'&beginTime='+this.log.startDate+'&endTime='+this.log.finDate+'&pageNum='+pageNum;
                this.$http.get(data).then((res)=>{
                    console.log(res);
                    this.page.totalList = res.data.allRecordNumber;
                    this.data = res.data.OperateLogList;
                    this.loading = false;
                    this.download = '/operateLog/exportLogList';
                }).catch((res)=>{
                    this.loading = false;
                })
            },
            selectLog(value){
                this.log.logType = value.value
            },
            selectSource(value){
                this.log.source = value.value
            },
            selectResult(value){
                this.log.result = value.value
            },
            reset(){
                this.log.user = '';
                this.log.logType = 'all';
                this.log.source = 'all';
                this.log.result = 'all';
                this.log.startDate = "2010-01-01";
                this.log.finDate = this.getDate();
            },
            setStart(date) {
                this.log.startDate = date;
                if(this.log.finDate && this.log.startDate>this.log.startDate){
                    alert('起始时间不能晚于结束时间！');
                    return false;
                }
            },
            setFin(date) {
                this.log.finDate = date;
                if(this.log.startDate<this.log.startDate){
                    alert('结束时间不能早于起始时间！');
                    return false;
                }
            },
            getDate(){
                let date = new Date();
                let seperator1 = "-";
                let month = date.getMonth() + 1;
                let strDate = date.getDate();
                if (month >= 1 && month <= 9) {
                    month = "0" + month;
                }
                if (strDate >= 0 && strDate <= 9) {
                    strDate = "0" + strDate;
                }
                let currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
                return currentdate;
            },
            onChange(pageNum){
                this.getLogData(null,50,pageNum);
                this.page.pageNum = pageNum;
            }
        },
        mounted(){
            this.getLogData();
        }
    }
</script>
