<template>
    <span class="rollNum rollText">
        <div class="num-con" v-for="i in numArray.length">
            <ul class="num-item" v-if="numArray[i-1]!='.'" :class="['moveTo-'+numArray[i-1]]">
                <li>0</li>
                <li v-for="index in 9">{{index}}</li>
                <li>0</li>
                <li v-for="index in 9">{{index}}</li>
                <li>0</li>
                <li v-for="index in 9">{{index}}</li>
            </ul>
            <ul class="num-item" v-else>.</ul>
        </div>
    </span>
</template>
<style lang="less">
.rollNum{
    overflow: hidden;
    display: inline-block;
    .num-con{
        width: 20px;
        height: 30px;
        overflow: hidden;
        position: relative;
        display: inline-block;
    }
    .num-item{
        width:100%;
        position: absolute;
        top:0;
        li{
            text-align: center;
        }
    }
    .moveTo-1{animation: to1 1.5s ease forwards;}
    .moveTo-2{animation: to2 1.5s ease forwards;}
    .moveTo-3{animation: to3 1.5s ease forwards;}
    .moveTo-4{animation: to4 1.5s ease forwards;}
    .moveTo-5{animation: to5 1.5s ease forwards;}
    .moveTo-6{animation: to6 1.5s ease forwards;}
    .moveTo-7{animation: to7 1.5s ease forwards;}
    .moveTo-8{animation: to8 1.5s ease forwards;}
    .moveTo-9{animation: to9 1.5s ease forwards;}
    .moveTo-0{animation: to0 1.5s ease forwards;}
    @keyframes to1{ 100% {top:-1100%}}
    @keyframes to2{ 100% {top:-2200%} }
    @keyframes to3{ 100% {top:-300%} }
    @keyframes to4{ 100% {top:-1400%} }
    @keyframes to5{ 100% {top:-2500%} }
    @keyframes to6{ 100% {top:-2600%} }
    @keyframes to7{ 100% {top:-700%} }
    @keyframes to8{ 100% {top:-1800%} }
    @keyframes to9{ 100% {top:-1900%} }
    @keyframes to0{ 100% {top:-2000%} }
}
</style>
<script type="text/ecmascript-6">
    export default{
        props: ['num'],
        data(){
            return{
                numArray:[]
            }
        },
        watch:{
            'num':'setNum'
        },
        methods:{
            setNum(){
                //  把字符串转化为数组。
                this.numArray = [...this.num.toString()];
            }
        },
    }
</script>
