<template>
    <div>
        <div class="module-header">
            <h4>用户账户详情</h4>
        </div>
        <div class="userDetail">
            <div class="item">
                <div class="label">账号：</div>
                <div class="desc">{{userDetail.userName}}</div>
            </div>
            <div class="item">
                <div class="label">姓名：</div>
                <div class="desc">{{userDetail.userRelname}}</div>
            </div>
            <div class="item">
                <div class="label">手机号码：</div>
                <div class="desc">{{userDetail.phone}}</div>
            </div>
            <div class="item">
                <div class="label">邮箱地址：</div>
                <div class="desc">{{userDetail.email}}</div>
            </div>
            <div class="item">
                <div class="label">公司：</div>
                <div class="desc">{{userDetail.company}}</div>
            </div>
            <div class="item">
                <div class="label">创建时间：</div>
                <div class="desc">{{userDetail.createTime}}</div>
            </div>
            <div class="item">
                <div class="label">权限分配：</div>
                <div class="desc">{{userDetail.roleName}}</div>
            </div>
            <div class="item">
                <div class="label">账户状态：</div>
                <div class="desc" v-if="userDetail.state==1">已启用</div>
                <div class="desc" v-if="userDetail.state==0">已禁用</div>
            </div>
            <div class="item">
                <div class="label">最近登陆：</div>
                <div class="desc" v-if="!userDetail.loginStatus">{{userDetail.lastTime}}</div>
                <div class="desc" v-if="userDetail.loginStatus">当前在线</div>
            </div>
        </div>
        <Button type="primary" class="f16" style="width:90px; margin-left:110px" @click="toEdit(userID)">修改信息</Button>
        <Button type="ghost" class="f16 ml-10" style="width:90px;" @click="$router.push('/user')">返回</Button>
    </div>
</template>
<style lang="less">
    .userDetail{
        font-size: 14px;
        padding: 25px 0;
    .item{
        overflow: hidden;
        margin-bottom: 20px;
    }
    .label{
        color: #666;
        float: left;
        width: 110px;
        text-align: right;
    }
    .desc{
        color: #333;
        float: left;
        margin-left: 10px;
    }
    }
</style>
<script type="text/ecmascript-6">
import {userDetail,BASEURL} from '../../assets/js/data'
export default{
    data() {
        return {
            userDetail:{},
            userID: this.$store.getters.getuserid
        }
    },
    methods:{
        getUserDetail:function(){
            this.$http.get('/user/userTail/'+this.userID)
                    .then((res) => {
                        this.userDetail = res.data.user;
                    })
                    .catch((res)=>{
                        console.log('获取用户详情信息失败'+res)
                    })
        },
        toEdit: function(index){
            this.$router.push('/user/usersEdit')
        }
    },
    mounted(){
        this.getUserDetail();
    }
}
</script>
