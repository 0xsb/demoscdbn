<template>
    <div>
        <div class="module-header">
            <h4>历史数据</h4>
        </div>
        <div class="tableContent">
            <Table width="auto" stripe height="600" style="margin-top: 10px;" border :columns="columns" :data="data"></Table>
        </div>
    </div>
</template>
<style lang="less">
</style>
<script type="text/ecmascript-6">
    import {datahistorytables} from '../../assets/js/data'
    export default{
        data(){
            return {
                columns:[
                    {
                        title: '数据名称',
                        key: 'dataName',
                        align: 'center',
                        width:400
                    },
                    {
                        title: '更新时间',
                        key: 'upadateTimeView',
                        align: 'center',
                    },
                    {
                        title: '数据下载',
                        key: 'downloadData',
                        align: 'center',
                        width:100,
                        render:(fc,obj)=>{
                            //    return `<a :href="${obj.row.dataDownload}">立即下载</a>`;
                            return fc('a',{

                            },'立即下载')
                        }

                    }
                ],
                data: []
            }
        },
        mounted(){
            this.$http.get('/export/adminHistoryData').then(res=>{
                this.data = res.data.adminHistoryDataList
            }).catch(res=>{
                console.log('获取历史默认数据失败'+res)
            })
        }
    }
</script>
