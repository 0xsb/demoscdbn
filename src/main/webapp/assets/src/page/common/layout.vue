<template>
    <div id="content">
        <my-head></my-head>
        <div id="main">
            <my-nav></my-nav>
            <bread></bread>
            <div class="main">
                <router-view></router-view>
            </div>
        </div>
        <my-foot></my-foot>
    </div>
</template>
<style lang="less">
</style>
<script type="text/ecmascript-6">
import myHead from   '../../components/common/header'
import myFoot from '../../components/common/foot'
import myNav from '../../components/common/navShow'
import bread from '../../components/common/bread'
export default{
    data() {
        return {

        }
    },
    computed:{
        bread: function(){
            return this.$store.getters.getbreaditem;
        }
    },
    components:{
        myHead,
        myFoot,
        myNav,
        bread
    }
}
</script>
