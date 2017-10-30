<template>
    <div>
        <my-head-show></my-head-show>
        <div class="main-container">
            <img src="../../assets/imgs/login-Expire.png" >
            <div class="msg">
                <h2>该链接已过期，请重新提交重置密码请求</h2>
                <p>请<a href="#">点击此处</a>,返回平台首页。</p>
            </div>
        </div>
        <my-foot></my-foot>
    </div>
</template>
<style lang="less" scoped>
@import "../../assets/css/me.less";
.main-container{
    width: 620px;
    margin:240px auto 0 auto;
}
img{
    vertical-align: top;
}
.msg{
    display: inline-block;
    margin-left:12px;
    h2{
        font-size: 23px;
        font-weight: 500;
    }
    p{
        font-size: 14px;
        margin-bottom: 12px;
    }
}
</style>
<script type="text/ecmascript-6">
    import myHeadShow from '../../components/common/header-show'
    import myFoot from '../../components/common/foot'
    export default{
        components:{
            myHeadShow,myFoot
        }
    }
</script>
