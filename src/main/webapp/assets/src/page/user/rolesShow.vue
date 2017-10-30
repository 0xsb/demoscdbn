<template>
    <div>
        <div class="module-header">
            <h4>权限列表
                <Button type="primary" @click="$router.push('/user/rolesAdd')" class="btn-search right f14">创建新权限</Button>
            </h4>
        </div>
        <div class="tableContent">
            <Table width="auto" stripe height="600" style="margin-top: 10px;" border :columns="columns" @on-selection-change="con" :data="data"></Table>
            <div class="table-set" style="border-top: 0">
                <Button type="ghost" style="width: 80px" :disabled="BtnDisabled" @click="dialog.removeAll=!dialog.removeAll">批量删除</Button>
                <span v-if="selection.length" class="result-info ml-20">已选中 {{selection.length}} 条记录</span>
            </div>
            <div class="page" v-if="data">
                <Page :total="page.totalList" :page-size="50" @on-change="onChange" :current="page.pageNum"></Page>
            </div>
        </div>
        <!--批量删除-->
        <Modal v-model="dialog.removeAll" :mask-closable="false" title="删除权限" class="userRole" @on-cancel="cancel">
            <div class="clearfix dialog-body">
                <p class="dialog-title">是否确认删除下述权限？</p>
                <div v-if="removeItem">
                    <p class="roleBody mt-10">权限名称：{{removeItem.roleName}}</p>
                </div>
                <div v-else>
                    <ul class="roleBody mt-10" >
                        <li class="roleItem mb-5" v-for="i in selection">权限名称：{{i.roleName}}</li>
                    </ul>
                </div>
                <p class="red mt-20" v-if="isRemove">当一个权限下已分配了有效的用户时，该权限不可被删除。</p>
            </div>
            <div slot="footer">
                <Button type="primary" style="width:80px" class="align f14" :disabled="isRemove" @click="userrole_con">确定</Button>
                <Button type="ghost" style="width:80px" class="align f14" @click="cancel">取消</Button>
            </div>
        </Modal>
        <modal :title="this.modal.title" :content="this.modal.content" :dialog="this.modal.dialog"></modal>
    </div>
</template>
<style lang="less">
.dialog-title{
    color: #666;
    font-size: 14px;
}
.roleBody{
    max-height: 150px;
    overflow: auto;
}
</style>
<script type="text/ecmascript-6">
    import modal from '../../components/common/modal.vue'
    import {roleslisttables,config} from '../../assets/js/data'
    export default{
        data() {
            return {
                columns:[
                    {
                        type: 'selection',
                        width: 100
                    },
                    {
                        type: 'index',
                        title: '序号',
                        width: 100
                    },
                    {
                        title: '权限名称',
                        key: 'roleName',
                        width: 200
                    },
                    {
                        title: '权限详情',
                        key: 'roleDesc',
                    },
                    {
                        title: '用户数量',
                        key: 'usersCount',
                        align: 'center',
                        width: 100
                    },
                    {
                        title: '操作',
                        key: 'action',
                        width: 240,
                        align: 'center',
                        render: (fc,obj)=>{
                            if(obj.row.usersCount<1){
                                //    return `<a @click="detail(${obj.row.roleId})">查看</a> <a style="margin-left: 10px" @click="edit(${obj.row.roleId})">修改</a> <a style="margin-left: 10px" @click="remove(${obj.row.roleId})">删除</a>`;
                                return fc('div',[fc('a',{
                                    on:{
                                        click:()=>{
                                            this.detail(obj.row.roleId)
                                        }
                                    }
                                },'查看'),fc('a',{
                                    on:{
                                        click:()=>{
                                            this.edit(obj.row.roleId)
                                        }
                                    },
                                    style:{
                                        marginLeft: '10px'
                                    }
                                },'修改'),fc('a',{
                                    on:{
                                        click:()=>{
                                            this.remove(obj.row)
                                        }
                                    },
                                    style:{
                                        marginLeft: '10px'
                                    }
                                },'删除')])
                            }else{
                                return fc('div',[fc('a',{
                                    on:{
                                        click:()=>{
                                            this.detail(obj.row.roleId)
                                        }
                                    }
                                },'查看'),fc('a',{
                                    on:{
                                        click:()=>{
                                            this.edit(obj.row.roleId)
                                        }
                                    },
                                    style:{
                                        marginLeft: '10px'
                                    }
                                },'修改')])
                            }
                        }
                    }
                ],
                data: [],
                selection: [],
                removeState: 0,
                removeItem: false,
                dialog:{
                    removeAll:false,
                },
                modal:{
                    title:'',
                    content:'',
                    dialog:0
                },
                res:[],
                page:{
                    totalList: 0,
                    pageNum: 1,
                    pageSize:50
                },
            }
        },
        methods:{
            con(selection){
                this.selection = selection;
            },
            detail(index){
                this.$store.dispatch('setuserrole',index);
                this.$router.push('/user/rolesDetail')
            },
            edit(index){
                this.$store.dispatch('setuserrole',index);
                this.$router.push('/user/rolesEdit')
            },
            remove(row){
                this.removeItem = row;
                this.dialog.removeAll = true;
            },
            userrole_con(){     //批量删除
                this.dialog.removeAll = false;
                let data = '';
                if(this.removeItem){
                    data = 'roleIds[]='+this.removeItem.roleId;
                }else{
                    for(let i=0;i<this.selection.length;i++){
                        data+= 'roleIds[]='+this.selection[i].roleId+'&';
                    }
                }
                let _data = data;
                this.removeItem = false;
                this.$http.post('/role/roles/del?',_data,config).then(res=>{
                    if(res.data=='success'){
                        this.modal.dialog++;
                        this.modal.title = '删除成功'
                    }else if(res.data == 'error'){
                        this.modal.dialog--;
                        this.modal.title = '删除失败'
                        this.modal.content = ``
                    }
                })
            },
	    cancel(){
                this.dialog.removeAll = false;
                let that = this;
                setTimeout(function(){
                    if (that.removeItem) {
                        that.removeItem = false;
                    }
                }, 1000);
            },
            getData(e,pageSize=50,pageNum = this.page.pageNum){
                this.$http.get('/role/rolesShow?pageSize=50&pageNum='+pageNum).then((res)=>{
                    this.data = res.data.rolesList;
                    this.page.totalList = res.data.totalSize;
                }).catch(res=>{
                    console.log('获取权限列表失败'+res)
                })
            },
            onChange(pageNum){
                this.getData(null,50,pageNum);
                this.page.pageNum = pageNum;
            }
        },
        computed: {
            BtnDisabled(){
                if(this.selection.length){
                    return false;
                }else{
                    return true;
                }
            },
            isRemove(){
                let flag;
                if(this.removeItem){
                    flag = false;
                }else{
                    flag = this.selection.some((item,index,array)=>{
                        return item.usersCount!=0;
                    })
                }
                return flag;
            },
        },
        watch:{

        },
        mounted(){
            this.getData();
        },
        components:{
            modal
        }
    }
</script>
