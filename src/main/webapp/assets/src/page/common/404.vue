<template>
    <div>
        <my-head></my-head>
        <div class="map">
            <div class="web_404">
                <img src="../../assets/imgs/web_404.png">
                <p>您访问的页面正在建设中，请稍后访问</p>
                <p class="jump"><span id="time">5</span>秒钟后自动跳转，如果没有自动跳转 <a href="javascript:history.back();">请点击这里</a></p>
            </div>
        </div>
        <my-foot></my-foot>
    </div>
</template>
<style lang="less">
.web_404{
    width: 600px;
    margin: 75px auto;
    p{
        font-size: 18px;
        color: #333;
        text-align: center;
        margin-top: 15px;
    }
}
</style>
<script type="text/ecmascript-6">
    import myFoot from '../../components/common/foot'
    import myHead from '../../components/common/header'
    export default{
        components:{
            myFoot,myHead
        }
    }
</script>
