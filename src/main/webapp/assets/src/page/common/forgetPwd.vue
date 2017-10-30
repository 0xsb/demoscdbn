<template>
    <div>
        <my-head-show></my-head-show>
        <div class="main-container forget">
            <h4>忘记密码</h4>
            <Form label-position="right" :label-width="100" class="forgetPwd" :model="formItem" :rules="forgetPwd" ref="forgetPwd">
                <Form-item label="用户名 :" prop="userName">
                    <Input v-model="formItem.userName" style="width: 300px;"></Input>
                </Form-item>
                <Form-item label="邮箱 :" prop="email">
                    <Input  v-model="formItem.email" style="width: 300px"></Input>
                </Form-item>
                <Form-item>
                    <Button v-if="show" type="primary" class="btn-submit" style="width: 300px;" @click="handleSubmit()" >重置密码
                    </Button>
                    <Button v-else disabled type="primary" class="btn-submit" style="width: 300px;" @click="handleSubmit()" >重置密码
                    </Button>
                </Form-item>
            </Form>
            <vmodal :title="modal.title" :content="modal.content" :dialog="modal.dialog" :url="modal.url" :color="modal.color"></vmodal>
        </div>
        <my-foot></my-foot>
    </div>
</template>
<style lang="less">
.forget {
    margin-top: 240px;
    background-color: #fff;
    height: 300px;
    padding:2px 37px;
}
.forget h4{
    width: 355px !important;
    color: #000 !important;
    font-weight:500;
    font-size: 20px;
    margin:0 auto !important;
}
.forgetPwd{
    width: 420px;
    margin: 10px auto;
}
.btn-submit{
    height:35px !important;
    font-size: 18px !important;
    line-height: 18px !important;
}
.ivu-form-item-label{
    font-size: 15px !important;
    color: #666 !important;
}
.ivu-form-item-required .ivu-form-item-label:before{
    content: '' !important;
}
.resetP{
    text-align: left !important;
    width: 95% !important;
}
</style>
<script type="text/ecmascript-6">
    import myHeadShow from '../../components/common/header-show'
    import myFoot from '../../components/common/foot'
    import {BASEURL,config} from '../../assets/js/data'
    import vmodal from '../../components/common/modal.vue'
    export default{
        components:{
            myHeadShow,myFoot,vmodal
        },
        data() {
            return {
                formItem: {
                    userName: '',
                    email: '',
                },
                forgetPwd:{
                    userName:[
                        { required: true, message: '请填写用户名', trigger: 'blur' },
                        { type: 'string', min: 6, message: '用户名不正确，请重新输入!', trigger: 'blur' }
                    ],
                    email: [
                        { required: true, message: '请填写邮箱', trigger: 'blur' },
                        { type: 'email', message: '邮箱地址不正确，请重新输入!', trigger: 'blur' }
                    ],
                },
                modal:{
                    title:'',
                    content:'',
                    dialog:0,
                    url: '',
                    color: 'green'
                },
                show:true,
            }
        },
        methods:{
            handleSubmit(){
                this.$refs['forgetPwd'].validate((valid)=>{
                    if(valid){
                        this.show = false;
                        let url = '/getpassword/presentreset.html?';
                        let data = 'userName='+this.formItem.userName+'&email='+this.formItem.email;
                        this.$http.get(url+data)
                            .then((res)=>{
                                if(res.data.msg=='success'){
                                    this.modal.dialog++;
                                    this.modal.title = '操作成功';
                                    this.modal.content = '<p class="resetP">您的密码重置申请已收到，密码重置链接已经发送到您的邮箱。</p>'+
                                        '<p class="resetP">请登录邮箱，通过密码重置链接重置密码。</p>'+
                                        '<p class="resetP">密码重置链接24H内有效。</p>';
                                    this.modal.url='/login';
                                }else if(res.data.msg == 'fail'){
                                    this.modal.dialog--;
                                    this.modal.title = '操作失败';
                                    this.modal.content = `请输入正确的用户信息`
                                }else if(res.data.msg == 'error'){
                                    this.modal.dialog--;
                                    this.modal.title = '操作失败';
                                    this.modal.content = `发送邮件失败`
                                }
                            }).catch(()=>{
                                console.log('error')
                        })
                    }
                })
            }
        }
    }
</script>
