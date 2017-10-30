<template>
    <div>
        <div class="module-header">
            <h4>数据图表列表
                <Button type="primary" @click="$router.push('/export/add')" class="btn-search right f14" >新建报表</Button>
            </h4>
        </div>
        <div class="module-search">
            <div class="item">
                <div class="search-label1">
                    分类：
                </div>
                <div class="search-item1">
                    <Select v-model="init.classify" :label-in-value="true" @on-change="selectClassify" style="width:88px;">
                        <Option v-for="item in selectionClassify" :value="item.value" :key="item">{{ item.label }}</Option>
                    </Select>
                </div>
                <div class="search-item1">
                    <Button type="primary" style="margin-left: 20px;height: 36px;width: 90px;float: left;margin-top:7px" @click="handleSubmit()">确定</Button>
                    <div class="block">清空</div>
                </div>
                <div class="search-item">
                    <Input v-model="formItem.input" icon="ios-search-strong" placeholder="请输入..." style="width: 240px;margin-left:40px;margin-top: 10px;float: left;" ></Input>
                    <div class="block2">重置</div>
                </div>
            </div>
        </div>
        <div class="search-result">
            <p class="search-content">已查找到<span>{{page.totalList}}</span>条数据</p>
        </div>
        <div class="tableContent">
            <Table width="auto" stripe border :columns="columns" :data='dataMap' style="margin-top: 10px" ></Table>
            <!--<div class="page" v-if="dataMap">-->
                <!--<Page :total="page.totalList" :page-size="15" ></Page>-->
            <!--</div>-->
        </div>
        <modal :title="this.modal.title" :content="this.modal.content" :dialog="this.modal.dialog"></modal>
    </div>
</template>
<style lang="less">
    .search-label1,.block{
        float: left;
        font-size: 14px;
        line-height: 50px;
    }
    .search-item1{
        float: left;
        line-height: 50px;
    }
    .block{
        margin-left:10px;
        color: #3694f2;
        font-size: 14px;
    }
    .block2{
        float: left;
        margin-left:10px;
        color: #3694f2;
        font-size: 14px;
        line-height: 50px;
    }
</style>
<script type="text/ecmascript-6">
    import {dataMapTables,showDataSelection} from '../../assets/js/data'
    import modal from '../../components/common/modal.vue'
    export default{
        data(){
            return {
                formItem:{
                    select:'',
                    input:'',
                    id:''
                },
                selectionClassify:showDataSelection.dataPublishClassify,
                init:{
                    classify:'全部'
                },
                page:{
                    totalList:''
                },
                dataMap:[],
                modal:{
                    title:'',
                    content:'',
                    dialog:''
                },
                columns:[
                        {
                            type: 'selection',
                            fixed: 'left',
                            width: 50
                        },
                        {
                            title: 'ID',
                            key: 'id',
                            width:100
                        },
                        {
                            title: '标题',
                            key: 'title',
                        },
                        {
                            title: '分类',
                            key: 'classify',
                            width: 150
                        },
                        {
                            title: '发布者',
                            key: 'publisher',
                            width: 150
                        },
                        {
                            title: '发布状态',
                            key: 'publishStatus',
                            width: 150
                        },
                        {
                            title: '发布时间',
                            key: 'publishTime',
                            width: 250
                        },
                        {
                            title: '编辑时间',
                            key: 'updateTime',
                            width: 250
                        },
                        {
                            title: '操作',
                            key: 'operation',
                            width: 150,
                            render: (fc,obj)=>{
                                return fc('div',[fc('a',{
                                    on:{
                                        click:()=>{
                                            this.detail(obj.row.id)
                                        }
                                    }
                                },`查看`),
                                    fc('a',{
                                    style:{
                                        marginLeft: '10px'
                                    },
                                    on:{
                                        click:()=>{
                                            this.edit(obj.row.id)
                                        }
                                    }
                                },`修改`),
                                    fc('a',{
                                    style:{
                                        marginLeft:'10px'
                                    },
                                    on:{
                                        click:()=>{
                                            this.remove(obj.row.id)
                                        }
                                    }
                                },'删除')
                                ])
                            }
                        },
                    ]
            }
        },
        methods:{
            detail(index){
                this.$store.dispatch('setuserrole',index);
                this.$router.push('/export/detail')
            },
            edit(index){
                this.$store.dispatch('setuserrole',index);
                this.$router.push('/export/edit')
            },
            remove(){
                this.modal.dialog++;
                this.modal.title = '删除成功'
            },
            handleReset(){
                this.formItem.select=''
                this.formItem.input=''
            },
            handleSubmit(){
                this.$http.get().then(()=>{

                })
            },
            selectClassify(v){
                this.init.classify = v.value;
            }
        },
        mounted(){
            this.$http.get('/export/dataPublish').then((res)=>{
                this.dataMap = res.data.dataPublish;
            }).catch(res=>{
                console.log('获取数据发布列表失败'+res)
            })
        },
        components:{
            modal
        }
    }
</script>
