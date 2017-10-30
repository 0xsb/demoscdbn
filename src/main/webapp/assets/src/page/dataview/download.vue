<template>
    <div>
        <div class="module-header">
            <h4>业务数据下载</h4>
        </div>
        <form class="form" id="resume_form">
            <div class="form-group">
                <label class="label">数据范围：</label>
                <Select v-model="defaultData.value" :label-in-value="true" @on-change="checkdata" style="width:300px;margin-left: 15px">
                    <Option v-for="item in selectionList" :value="item.value" :key="item">{{ item.label }}</Option>
                </Select>
            </div>
            <div class="form-group">
                <label class="label">数据类型：</label>
                <Select v-model="defaultType.value" :label-in-value="true" @on-change="checktype" style="width:300px;margin-left: 15px">
                    <Option v-for="item in dataTypeSelection" :value="item.value" :key="item">{{ item.label }}</Option>
                </Select>
            </div>
            <div class="form-group">
                <label class="label">开始时间：</label>
                <span class="datePicker">
                    <Date-picker type="date" placeholder="选择开始日期" @on-change="setStart" :options="options" style="width: 300px"></Date-picker>
                </span>
            </div>
            <div class="form-group">
                <label class="label">结束时间：</label>
                <span class="datePicker">
                    <Date-picker type="date" placeholder="选择结束日期" @on-change="setFin" :options="options" style="width: 300px"></Date-picker>
                </span>
            </div>
            <div class="form-group">
                <label class="label"></label>
                <a class="btn-blue w80 mr-15">确定</a>
                <a class="btn-default w80" @click="$router.push('/dataview')">取消</a>
            </div>
        </form>
    </div>
</template>
<style lang="less">
.datePicker{
    display: inline-block;
    margin-left: 15px;
    width: 300px;
}
</style>
<script type="text/ecmascript-6">
    import {showDataSelection,showDataList} from '../../assets/js/data'
    export default{
        data() {
            return {
                selectionList: showDataSelection.dataList,
                dataTypeSelection: showDataSelection.dataTypeList,
                defaultData:{
                    value: 'all',
                    label: '全国数据'
                },
                defaultType:{
                    value: 'all',
                    label: '全部数据'
                },
                options: {
                    disabledDate (date) {
                        return date && date.valueOf() > Date.now();
                    }
                },
                date: {
                    start_date: '',
                    finish_date: ''
                },
            }
        },
        computed:{

        },
        methods:{
            checkdata(value){
                this.defaultData = value;
            },
            checktype(value){
                this.defaultType = value;
            },
            setStart(date) {
                this.date.start_date = date;
                if(this.date.finish_date && this.date.start_date>this.date.finish_date){
                    alert('起始时间不能晚于结束时间！');
                    return false;
                }
            },
            setFin(date) {
                this.date.finish_date = date;
                if(this.date.finish_date<this.date.start_date){
                    alert('结束时间不能早于起始时间！');
                    return false;
                }
            },
        }
    }
</script>
