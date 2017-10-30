<style lang="less">
@import "../../assets/css/me.less";
.wrapper{
    position: absolute;
    width: 100%;
    height: 100%;
    background: url("../../assets/imgs/login-bg.jpg") left top no-repeat;
    background-size: cover;
}
.content {
    margin: 0 auto;
    width: 420px;
}
.login-logo {
    padding: 35% 0 10%;
}
@media screen and (max-width: 1440px) {
    .login-logo {
        padding: 17% 0 7%;
    }
}
.main-container {
    height: 360px;
    background-color: #fff;
    padding:46px 37px;
}
.login{
    .ivu-input{
        width: 100%;
        float: left;
        border: 1px solid #ccc;
        border-radius: 2px;
        height: 44px;
        line-height: 44px;
        padding: 0 10px;
        font-size: 16px;
    }
    .input-item{
        position: relative;
    }
    .point{
        position: absolute;
        top:7px;
        right:10px;
        color: #3694f2;
        font-size: 14px;
    }
    .code-item{
        position: absolute;
        top:0px;
        right:0px;
        width: 96px;
        background: #eaf2fd;
        height: 44px;
        cursor: pointer;
    }
    .btn-submit{
        width: 100%;
        height: 44px;
        border-radius: 2px;
        border:0;
        background: #3694f2;
        color: #FFF;
        font-size: 16px;
        cursor:pointer;
        margin-top: 20px;
    }
}

</style>
<template>
<div class="wrapper">
    <div class="content">
        <div class="login-logo text-center">
            <img src="../../assets/imgs/login-logo.png">
        </div>
        <div class="main-container login">
            <Form :model="user" :rules="login" ref="login">
                <Form-item prop="userName">
                    <Input v-model="user.userName" placeholder="用户名" :maxlength="50"></Input>
                </Form-item>
                <Form-item prop="userPassword" class="input-item">
                    <Input type="password" v-model="user.userPassword" placeholder="密码" :maxlength="20"></Input>
                    <a class="point" @click="$router.push('/forgetPwd')">忘记密码？</a>
                </Form-item>
                <Form-item prop="code">
                    <Input v-model="user.code" placeholder="输入验证码" :maxlength="4" style="width:240px;"></Input>
                    <span class="code-item" @click="getCode">
                        <img :src="imgSrc">
                    </span>
                </Form-item>
                <Form-item>
                    <Button type="primary" :loading="loading" class="btn-submit f16" @click="handleSubmit()">
                        <span v-if="!loading">登   录</span>
                        <span v-else>登录中...</span>
                    </Button>
                </Form-item>
            </Form>
        </div>
    </div>
</div>
</template>

<script>
import { validatePass,validateTel } from '../../assets/js/formrule'
import {BASEURL,config} from '../../assets/js/data'
import md5 from 'md5'
export default {
    data() {
        return {
            user: {
                userName: '',
                userPassword: '',
                code: ''
            },
            loading:false,
            imgSrc: '/img/checkImg?a='+Math.random()+100,
            login: {
                userName:[
                    { required: true, message: '请填写用户名', trigger: 'blur' },
                    { type: 'string', min: 5, message: '账号不能少于5位', trigger: 'blur' }
                ],
                userPassword: [
                    { required: true, message: '请填写密码',trigger: 'blur' }
                //    { validator: validatePass,trigger: 'blur'}
                ],
                code: [
                    { required: true, message: '请填写验证码', trigger: 'blur' }
                ],
            }
        }
    },
    methods: {
        handleSubmit() {
            this.$refs['login'].validate((valid) => {
                if(valid){
                    this.loading = true;
                    let data = 'userName='+this.user.userName+'&userPassword='+md5(this.user.userPassword)+'&code='+this.user.code;
                    this.$http.post('/login',data,config)
                    .then((res) => {
                        if(res.data.code==0){
                            let path = res.data.tree.children[0].resouce;
                            this.$store.dispatch('loginSet',{'user_name':this.user.userName,'logStatus':true,'user_permission':res.data.roleId});
                            this.$router.push(path);
                        }else if(res.data.code == 1){
                            alert('用户名或密码错误');
                        }else if(res.data.code == 2){
                            alert('验证码不正确');
                        }else if(res.data.code==3){
                            alert('您的账号权限不足，请先联系管理员');
                        }
                        this.loading = false;
                    }).catch((res)=>{
                        this.$store.dispatch('loginSet',{'user_name':this.user.userName,'user_permission':1,'logStatus':true});
                        if(this.user.user_name=='admin'){
                            this.$router.push('/user');
                        }else{
                            this.$router.push('/device');
                        }
                    })
                }
            })
        },
        getCode() {
            this.imgSrc = '/img/checkImg?a='+Math.random()+100
        },
        enter(){
            document.onkeydown = ()=>{
                let keycode = window.event.keyCode;
                if(keycode == 13){
                    this.handleSubmit();
                }
            }
        }
    },
    mounted:function(){
        this.enter();
    }
}
</script>
