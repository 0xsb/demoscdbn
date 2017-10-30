<template>
    <div>
        <my-head></my-head>
        <div class="map">
            <div class="web_404">
                <p class="login_overload">登陆超时</p>
                <p class="blue">{{msg}}</p>
                <p style="text-align:left;">请<span style="color: blue;text-decoration: underline;" @click="$router.push('/login')">点击此处</span>，重新登录。</p>
            </div>
        </div>
        <my-foot></my-foot>
    </div>
</template>
<style lang="less">
    .web_404{
        width: 600px;
        margin:150px auto;
        text-align:left;
    .login_overload{
        font-size:32px !important;
        text-align:left !important;
    }
    .blue{
        color: blue !important;
        text-align:left !important;
    }
    }
</style>
<script type="text/ecmascript-6">
    import myFoot from '../../components/common/foot'
    import myHead from '../../components/common/header'
    export default{
        components:{
            myFoot,myHead
        },
        data(){
          return {
              msg:''
          }
        },
        mounted:function (){
            this.msg  = this.$route.query.message;
        }
    }
</script>
