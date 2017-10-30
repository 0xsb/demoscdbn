<template>
    <div class="header">
        <div class="container clearfix" style="width: 1200px">
            <div class="pull-left logo-info">
                <a href="/"><img src="../../assets/imgs/logo.png"/></a>
                <span>内容网络流量管理系统</span>
                <div></div>
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
    export default{}
</script>
