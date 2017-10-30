<template>
    <div class="home">
        <header>
            <div class="pull-left logo-info">
                <a @click="$router.push('/home')"><img src="../../assets/imgs/logo_home.png" id="logoToHome"></a>
                <span>内容网络流量管理系统</span>
            </div>
        </header>
        <div class="homeBg">
            <img src="../../assets/imgs/map.png" width="72%" />
            <span class="login" @click="$router.push('/login')">用户登录</span>
            <span id="map" @click="$router.push('/mapList')">数据汇总</span>
        </div>
        <my-foot></my-foot>
    </div>
</template>
<style lang="less">
.home{
    position:relative;
    header{
        height: 70px;
        line-height: 70px;
        overflow: hidden;
        width: 100%;
        color: #FFF;
        background: linear-gradient(to bottom,#1a71bb,#1d80c7);
    }
    .logo-info{
        width: 1200px;
        margin: 0 auto;
        float:none;
        cursor: default;
        span{
            color: #FFF;
        }
        a{
            cursor: default;
        }
    }
    .homeBg{
        width: 100%;
        background: url("../../assets/imgs/home_bg.jpg") no-repeat;
        background-size: cover;
        width: 100%;
        position: fixed;
        text-align: center;
        min-height: 1100px;
        .map{
            background: url("../../assets/imgs/map.png") no-repeat;
            width: 1200px;
            height: 663px;
            margin: 0 auto;
        }
        .title{
            background: url("../../assets/imgs/title.png") no-repeat;
            width: 1200px;
            height: 130px;
            position: absolute;
            top:300px;
        }
        .login{
            display: inline-block;
            width: 156px;
            height: 56px;
            line-height: 56px;
            color: #fff;
            background: #feb343;
            font-size: 24px;
            position: absolute;
            cursor: pointer;
            border-radius: 3px;
            top:45%;
            left: 40%;
            margin-left: -78px;
        }
        #map{
            display: inline-block;
            width: 156px;
            height: 56px;
            line-height: 56px;
            color: #fff;
            background: #feb343;
            font-size: 24px;
            position: absolute;
            cursor: pointer;
            border-radius: 3px;
            top:45%;
            left: 60%;
            margin-left: -78px;
        }
    }
    .footer{
        border:0;
    }
    .pull-right{
        float: right;
        height: 67px;
        font-size: 14px;
        color: #666;
        line-height: 67px;
        a{
            color: #FFF;
            margin-right: 45px;
        }
    }
}
@media (max-width: 1440px) {
    .login,#map{
        top:35% !important;
    }
}
</style>
<script type="text/ecmascript-6">
import myFoot from '../../components/common/foot'
export default{
    components:{
        myFoot
    }
}
</script>
