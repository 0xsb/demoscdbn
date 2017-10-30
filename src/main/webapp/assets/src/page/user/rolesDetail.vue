<template>
    <div>
        <div class="module-header">
            <h4>权限详情</h4>
        </div>
        <div class="userDetail">
            <div class="item">
                <div class="label">权限名称：</div>
                <div class="desc">{{rolesDetail.roleName}}</div>
            </div>
            <div class="item">
                <div class="label">权限详情：</div>
                <div class="desc-content" v-html="rolesContent">
                   <!-- {{rolesContent}}
                    {{rolesDetail.role.roleDesc}}-->
                    <!--<ul>
                        <li class="bg-odd">
                            <span class="title">设备管理</span>
                            <span class="content">未选</span>
                        </li>
                        <li >
                            <span class="title">端口管理</span>
                            <span class="content">未选</span>
                        </li>
                    </ul>-->
                </div>
            </div>
            <div class="item">
                <div class="label">创建时间：</div>
                <div class="desc">{{rolesDetail.role.createTime}}</div>
            </div>
            <div class="item">
                <div class="label">最近修改：</div>
                <div class="desc">{{rolesDetail.role.lastTime}}</div>
            </div>
            <div class="item">
                <div class="label">用户数量：</div>
                <div class="desc">{{rolesDetail.userCount}}</div>
                <div class="desc-content" v-if="rolesDetail.userCount">
                    <ul>
                        <li class="user-item" v-for="i in rolesDetail.userByRoleId">{{i.userName}}<i>({{i.lastTime}})</i></li>
                    </ul>
                </div>
            </div>
        </div>
        <Button type="primary" class="f16" style="width:90px;margin-left: 40px" @click="toEdit">修改权限</Button>
        <Button type="ghost" class="f16 ml-10" style="width:90px;" @click="$router.push('/user/rolesShow')">返回</Button>
    </div>
</template>
<style lang="less">
.desc-content{
    color: #333;
    float: left;
    width: 100%;
    padding: 15px 35px;
    margin-left: 10px;
    li{
        overflow: hidden;
        line-height: 40px;
        .title,.content{
            float: left;
        }
        .title{
            width: 120px;
            text-align: center;
            font-size: 14px;
            color: #333;
        }
        .content{
            width: 640px !important;
        }
    }
    .user-item{
        height: 30px;
        line-height: 30px;
        padding: 0 10px;
        display: inline-block;
        border:1px solid #6db3fa;
        i{
            color: #999;
        }
    }
}
</style>
<script type="text/ecmascript-6">
    import {roleslisttables} from '../../assets/js/data'
    export default{
        data() {
            return {
                rolesDetail:{},
                rolesId: this.$store.getters.getuserrole
            }
        },
        methods:{
            getRoleDetail:function(){
                this.$http.get('/role/roles/tail?roleId='+this.rolesId)
                        .then((res) => {
                            this.rolesDetail = res.data;
                        })
                        .catch((res)=>{
                            console.log('获取权限详情失败'+res)
                        })
            },
            toEdit: function(){
                this.$router.push('/user/rolesEdit')
            }
        },
        mounted(){
            this.getRoleDetail();
        },
        computed : {
            rolesContent(){
                let HTML = '<ul>';
                let data = this.rolesDetail.role.roleDesc;
                let _array = data.split(';');
                for(let i=0;i<_array.length;i++){
                    if(i%2==0){
                        HTML+= '<li><span class="title">'+_array[i].substr(0,5) + '</span><span class="content">' +_array[i].substr(5)+'</span></li>'
                    }else{
                        HTML+= '<li class="bg-odd"><span class="title">'+_array[i].substr(0,5) + '</span><span class="content">' +_array[i].substr(5)+'</span></li>'
                    }
                }
                HTML+= '</ul>';
                return HTML;
            }
        }
    }
</script>
