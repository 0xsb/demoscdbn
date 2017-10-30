<template>
    <div class="header">
        <div class="container clearfix" :style="{width:autowidth}">
            <div class="pull-left logo-info">
                <img src="../../assets/imgs/logo.png" />
                <span>内容网络流量管理系统</span>
            </div>
            <div class="pull-right user-info">
                <span>{{username}} 你好</span>
                <i></i>
                <a @click="loginout">退出</a>
            </div>
        </div>
    </div>
</template>
<style lang="less">
.container{
    margin: 0 auto;
}
.header{
    height: 67px;
    width: 100%;
    padding: 0 30px;
    background: #FFF;
    border-bottom: 2px solid #3694f2;
    position: fixed;
    top:0;
    z-index:500;
}
.pull-left{
    float: left;
    line-height: 67px;
    height: 67px;
    img{
        vertical-align: middle;
    }
    span{
        font-size: 18px;
        color: #666;
        padding: 4px 16px;
        border-left: 1px solid #ccc;
        margin-left: 16px;
    }
}
.pull-right{
    float: right;
    height: 67px;
    font-size: 14px;
    color: #666;
    line-height: 67px;
    span{
        padding: 2px 10px;
        border-right:1px solid #ccc;
        margin-right: 10px;
    }
    a{
        color: #3694f2;
    }
}
</style>
<script type="text/ecmascript-6">
    export default{
        computed: {
            username:function(){
                if(this.$store.getters.getusername=='systemadmin'){
                    return '管理员 - '+this.$store.getters.getusername;
                }else{
                    return '用户 - '+this.$store.getters.getusername;
                }
            }
        },
        props:{
            autowidth:{
                default: '100%'
            }
        },
        methods: {
            loginout(){
                this.$router.push('/login');
                this.$store.dispatch('loginout');
            }
        }
    }
</script>
