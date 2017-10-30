<template>
    <div>
        <my-head-show></my-head-show>
        <div class="main-container reset">
            <h4>重置密码</h4>
            <p>{{user.name}}，请设置您的新密码</p>
            <Form label-position="right" :label-width="120" class="resetPwd" :rules="resetPwd" :model="formItem" ref="pwd">
                <Form-item label="设置新密码:" prop="newPassword">
                    <Input type="password" v-model="formItem.newPassword" style="width: 300px" prop="password"></Input>
                </Form-item>
                <Form-item label="确认新密码:" prop="ensurePassword">
                    <Input type="password" v-model="formItem.ensurePassword" style="width: 300px"  prop="password"></Input>
                </Form-item>
                <Form-item>
                    <Button type="primary" class="btn-submit" style="width: 300px;" @click="handleSubmit('pwd')">确定
                    </Button>
                </Form-item>
            </Form>
            <Modal v-model="successModal" :mask-closable="false" title="设置成功" width="500" style="padding:20px 30px" class="removeAll" @on-cancel="cancel">
                <div class="clearfix text-center">
                    <p>密码已设置成功</p>
                    <p class="mt-20">请使用新密码重新登录平台。</p>
                </div>
                <div slot="footer" class="text-center">
                    <Button type="primary" style="width:80px" class="align f14" @click="re_login">去登陆</Button>
                </div>
            </Modal>
            <vmodal :title="modal.title" :content="modal.content" :dialog="modal.dialog" :url="modal.url" :color="modal.color"></vmodal>
        </div>
        <my-foot></my-foot>
    </div>
</template>
<style lang="less" >
/*@import "../../assets/css/me.less";*/
.reset {
    margin-top: 240px;
    background-color: #fff;
    height: 300px;
    padding:2px 37px;
    h4{
        width: 360px !important;
        color: #000;
        font-weight:500;
        margin: 0 auto !important;
        font-size: 20px !important;
    }
    p{
        width: 360px !important;
        margin: 0 auto 60px auto !important;
        font-size: 15px !important;
    }
}
.resetPwd{
    width: 420px;
    margin: 10px auto;
}
</style>
<script type="text/ecmascript-6">
    import myHeadShow from '../../components/common/header-show'
    import myFoot from '../../components/common/foot'
    import vmodal from '../../components/common/modal.vue'
    import {config} from '../../assets/js/data'
    export default{
        components:{
            myHeadShow,myFoot,vmodal
        },
        data() {
            const validatePass = (rule, value, callback) => {
                let pattern = /^[a-zA-Z0-9]{6,20}$/;
                if(!pattern.test(value)){
                    callback(new Error('密码长度不符合要求，请输入6-20位字母或数字的组合'));
                }

                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.formItem.ensurePassword !== '') {
                        // 对第二个密码框单独验证
                        this.$refs.pwd.validateField('ensurePassword');
                    }
                    callback();
                }
            };
            const validatePassCheck = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.formItem.newPassword) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                formItem: {
                    newPassword: '',
                    ensurePassword: '',
                },
                resetPwd:{
                    newPassword: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    ensurePassword: [
                        { validator: validatePassCheck, trigger: 'blur' }
                    ],
                },
                modal:{
                    title:'',
                    content:'',
                    dialog:0,
                    url: '',
                    color: 'green'
                },
                successModal: false,
                user:{
                    userId: '',
                    uuid: '',
//                    name: this.$store.getters.getusername
                    name:''
                }
            }
        },
        methods:{
            handleSubmit(pwd){
                this.$refs[pwd].validate((valid) => {
                    if(valid){
                        if(this.formItem.newPassword != this.formItem.ensurePassword){
                            this.$Message.error('两次输入的密码不一致!');
                        }else{
                            let data = 'password='+this.formItem.newPassword+'&userId='+this.user.userId+'&uuid='+this.user.uuid;
                            this.$http.post('getpassword/reset.html',data,config).then(res=>{
                                if(res.data = 'success'){
                                    this.successModal = true;
                                }else if(res.data == 'error'){
                                    this.modal.dialog--;
                                    this.modal.title = '操作失败';
                                    this.modal.content = `<p style="color:#ff5021">请求失败，请稍后再试</p>`;
                                    this.modal.url='/login';
                                }
                            }).catch(res=>{
//                                this.$router.push('/resetPwdExpire')
                                console.log('error');
                            })
                        }
                    }
                })
            },
            // 获取url中的参数
            getUrlKey:function(name){
                let _this =window;
                return _this.decodeURIComponent((new RegExp('[?|&]'+name+'='+'([^&;]+?)(&|#|;|$)').exec(location.href)||[,""])[1].replace(/\+/g,'%20'))||null;
            },
            re_login(){
                this.$router.push('/login ');
            },
            cancel(){
                this.successModal = false;
                setTimeout(function(){
                    window.location.href = './login';
                }, 1000);
            }
        },
        mounted:function (){
           this.user.userId  = this.getUrlKey("userId");
            this.user.uuid = this.getUrlKey("uuid");
            this.user.name = this.getUrlKey("name");
//            console.log("userId:"+this.user.userId);
//            console.log("uuid:"+this.user.uuid);
        }
    }
</script>
