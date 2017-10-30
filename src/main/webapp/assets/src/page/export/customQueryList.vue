<template>
    <div>
        <div class="module-header">
            <h4>数据查询</h4>
        </div>
        <div class="module-query">
            <h4 class="f16">新建一个查询</h4>
            <div class="query-item">
                <label>查询名称：</label>
                <Input v-model="query.name" style="width: 300px"></Input>
            </div>
            <div class="query-item">
                <label>检索语句：</label>
                <Input v-model="query.sql" type="textarea" :rows="4" style="width:650px;" placeholder="请输入检索用的SQL语句，仅支持select"></Input>
            </div>
            <div class="query-item">
                <Button type="primary" class="btn-search f16 ml-80" style="width:150px" @click="setSearch('save')" :disabled="btnDefault">保存语句并计算</Button>
                <Button type="primary" class="btn-search f16 ml-10 orange" @click="setSearch('get')" :disabled="btnDefault">立即计算</Button>
            </div>
        </div>
        <div class="module-header f16 mt-20">
            <h4>历史查询</h4>
        </div>
        <div class="tableContent">
            <Table width="auto" stripe height="600" style="margin-top: 10px;" border :columns="columns" :data="data"></Table>
        </div>
        <Modal v-model="dialog.search" title="数据检索" class="userRole">
            <div class="clearfix dialog-body">
                <div class="search-item" v-if="!searchResult">
                    <p >查询名称：{{query.name}}</p>
                    <p class="mt-20">计算完成，请点击下载结果</p>
                </div>
                <Spin fix>
                    <Icon type="load-c" size=30 class="demo-spin-icon-load" v-if="searchResult"></Icon>
                    <div v-if="searchResult">正在检索，请稍后...</div>
                </Spin>
            </div>
            <div slot="footer">
                <span></span>
                <a :href="searchUrl" @click="dialog.search=!dialog.search" v-if="searchUrl.length">下载文件</a>
            </div>
        </Modal>
        <modal :title="this.modal.title" :content="this.modal.content" :dialog="this.modal.dialog"></modal>
    </div>
</template>
<style lang="less">
.orange{
    border-color:#ff9e40 !important;
    background-color: #ff9e40 !important;
    &[disabled]{
         border-color:#d7dde4 !important;
         background-color: #f7f7f7 !important;
     }
}
.dialog-body{
    .ivu-spin-fix{
        position: relative;
    }
}
.demo-spin-icon-load{
    animation: ani-demo-spin 1s linear infinite;
}
@keyframes ani-demo-spin {
    from { transform: rotate(0deg);}
    50%  { transform: rotate(180deg);}
    to   { transform: rotate(360deg);}
}
</style>
<script type="text/ecmascript-6">
import {customquerytables} from '../../assets/js/data'
import modal from '../../components/common/modal.vue'
    export default{
        data(){
            return {
                columns:[
                    {
                        title: '查询名称',
                        key: 'queryName',
                        align: 'center',
                        width: 200
                    },
                    {
                        title: 'SQL语句详情',
                        key: 'querySqlShow',
                        align: 'center',
                    },
                    {
                        title: '创建时间',
                        key: 'createTimeView',
                        align: 'center',
                        width: 200
                    },
                    {
                        title: '操作',
                        key: 'action',
                        align: 'center',
                        width: 200,
                        render:(fc,obj)=> {
                            return fc('a',{
                                on:{
                                    click:()=>{
                                        this.copythis(obj.index)
                                    }
                                }
                            },`复制`)
                        }

                    }
                ],
                data: [],
                dialog: {
                    search: false
                },
                searchResult:true,
                searchUrl: '',
                query:{
                    name: '',
                    sql: ''
                },
                modal:{
                    title:'',
                    content:'',
                    dialog:0,
                }
            }
        },
        methods:{
            setSearch(type){
                this.dialog.search = true;
                let data = '';
                let path = '';
                if(type=='save'){
                    data = '/export/exportForsuperManagerJudge?querySql='+this.query.sql+'&queryName='+ this.query.name+ '&saveOrNot=save';
                    path = '/export/exportForsuperManager?querySql='+this.query.sql+'&queryName='+ this.query.name+ '&saveOrNot=save';
                }else{
                    data = '/export/exportForsuperManagerJudge?querySql='+this.query.sql+'&queryName='+ this.query.name+ '&saveOrNot=Not';
                    path = '/export/exportForsuperManager?querySql='+this.query.sql+'&queryName='+ this.query.name+ '&saveOrNot=Not';
                }
                this.$http.get(data)
                        .then(res=>{
                            if(res.data=='ok'){
                                this.searchResult = false;
                                this.searchUrl = path;
                            }else{
                                this.modal.dialog--;
                                this.modal.title = '查询出错';
                                this.modal.content = `请稍后再试`;
                                this.dialog.search = false;
                            }
                        })
                        .catch(res=>{
                            /*this.searchResult = false;
                            this.searchUrl = '';*/
                            this.dialog.search = false;
                            this.modal.dialog--;
                            this.modal.title = '查询出错';
                            this.modal.content = `${res}`
                        })
            },
            copythis(index){
                this.query.sql = this.data[index].querySqlShow;
            },
            reset(){        //初始化
                this.searchResult = true;
                this.searchUrl = '';
            }
        },
        computed: {
            btnDefault(){
                if(this.query.name==""||this.query.sql==""){
                    return true;
                }
            }
        },
        watch:{
            'dialog.search':'reset'
        },
        mounted(){
            this.$http.get('/export/customQueryList').then(res=>{
                this.data = res.data.CustomQueryList
            }).catch(res=>{
                console.log('获取自定义查询默认数据失败'+res)
            })
        },
        components:{
            modal
        }
    }
</script>
