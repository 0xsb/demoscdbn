<template>
    <div>
        <div class="module-header">
            <h4>请选择数据
                <Select v-model="defaultData.value" :label-in-value="true" @on-change="checkup" style="width:200px;margin-left: 20px" class="selction">
                    <Option v-for="item in selectionList" :value="item.value" :key="item">{{ item.label }}</Option>
                </Select>
                <a class="btn-blue w80 ml-20">下载数据</a>
            </h4>
        </div>
        <div class="tile-content mt-20">
            <p>当前数据:<span id="winDate">{{update}}</span>
                <span><a @click="$router.push('/dataview/download')">历史数据</a></span>
            </p>
            <div>
                <h3 class="mb-15 mt-15">设备数据</h3>
                <table class="table table-indent text-center table-bordered-noheader">
                    <thead>
                    <tr>
                        <th>{{defaultData.label}}</th>
                        <th>昨日新增</th>
                        <th>累计总量</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr v-for="item in deviceList">
                            <td>{{item.title}}</td>
                            <td>{{item.yesterday}}</td>
                            <td>{{item.all}}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="table-responsive">
                <h3 class="mb-15">端口数据</h3>
                <table class="table table-indent text-center table-bordered-noheader">
                    <thead>
                    <tr>
                        <th>{{defaultData.label}}</th>
                        <th>昨日新增</th>
                        <th>全部数据</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr v-for="item in deviceList">
                            <td>{{item.title}}</td>
                            <td>{{item.yesterday}}</td>
                            <td>{{item.all}}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="table-responsive">
                <h3 class="mb-15">流量数据</h3>
                <table class="table table-indent text-center table-bordered-noheader">
                    <thead>
                    <tr>
                        <th>{{defaultData.label}}</th>
                        <th>本期数据</th>
                        <th>全部数据</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr v-for="item in dataUsageList">
                            <td>{{item.title}}</td>
                            <td>{{item.yesterday}}</td>
                            <td>{{item.all}}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>
<style lang="less">
    .table td a {
        padding: 0 3px;
    }
    .ivu-select-selection span{
        background-image: none !important;
    }
    .table label {
        font-weight: 400;
    }


    .fz {
        font-size: 16px;
    }

    #list tr th {
        width: 33.3%;
    }

    h4.border {
        border-bottom: 1px solid #E7EEFF;
    }

    .mr-2 {
        margin-right: 2px;
    }
</style>
<script type="text/ecmascript-6">
    import {showDataSelection,showDataList} from '../../assets/js/data'
    export default{
        data() {
            return {
                selectionList: showDataSelection.dataList,
                deviceList:showDataList.deviceList,
                portList:showDataList.portList,
                dataUsageList: showDataList.dataUsageList,
                defaultData:{
                    value: 'all',
                    label: '全国数据'
                }
            }
        },
        computed:{
            update(){
                let D = new Date();
                let date = D.getFullYear()+'年'+(D.getMonth()+1)+'月'+D.getDate() + '日 0：00'
                return date
            }
        },
        methods:{
            checkup(value){
                this.defaultData = value;
            }
        }
    }
</script>
