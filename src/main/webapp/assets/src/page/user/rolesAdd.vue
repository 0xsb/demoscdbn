<template>
    <div class="tile">
        <div class="module-header"><h4>创建新权限</h4></div>
        <div class="module-roles">
            <div class="title">
                <label>权限名称：</label>
                <Input v-model="roleName" style="width: 300px;"></Input>
            </div>
            <div class="power-title mt-20">
                <strong>设备管理</strong>
                <p class="power-list" v-if="deviceIsCheck">未选择</p>
                <p class="power-list" v-else>已选择</p>
                <em class="czicon" :class="{on:treeShow==1}" @click="treeShow=1"></em>
            </div>
            <div class="power-tree" :class="{on:treeShow==1}">
                <span class="power-name mt-20">设备列表</span>
                <Tree :data="data.deviceList" show-checkbox @on-check-change="setDeviceList"></Tree>
                <span class="power-name mt-10">设备上传</span>
                <Tree :data="data.deviceImport" show-checkbox @on-check-change="setDeveiceImport"></Tree>
            </div>
            <div class="power-title mt-20">
                <strong>端口管理</strong>
                <p class="power-list" v-if="portIsCheck">未选择</p>
                <p class="power-list" v-else>已选择</p>
                <em class="czicon" :class="{on:treeShow==2}" @click="treeShow=2"></em>
            </div>
            <div class="power-tree" :class="{'on':treeShow==2}">
                <span class="power-name mt-20">端口列表</span>
                <Tree :data="data.portList" show-checkbox @on-check-change="setPortList"></Tree>
                <span class="power-name mt-10">端口上传</span>
                <Tree :data="data.portImport" show-checkbox @on-check-change="setPortImport"></Tree>
            </div>
            <div class="power-tree" :class="{'on':treeShow==3}">
                <ul id="businessTree" class="ztree">
                    <Tree :data="data.other" show-checkbox></Tree>
                </ul>
            </div>
            <Button type="primary" class="f16 mt-20" style="width: 90px;height:36px" @click="roleAdd" :disabled="roleBTN">创建</Button>
            <Button type="ghost" class="f16 mt-20" style="margin-left: 8px; width: 90px;height:36px" @click="$router.push('/user/rolesShow')">取消</Button>
        </div>
        <modal :title="this.modal.title" :content="this.modal.content" :dialog="this.modal.dialog" :url="this.modal.url"></modal>
    </div>
</template>
<style lang="less">
.module-roles{
    padding: 10px 35px;
}

    h4 {
        color: #666;
        font-size: 18px;
        line-height: 48px;
    }

    .tile-content {
        padding: 30px;
    }

    .name label {
        font-weight: normal;
        margin-bottom: 0px;
        color: #666;
        font-size: 14px;
    }

    .name input {
        border: 1px solid #ccc;
        width: 298px;
        height: 28px;
        line-height: 28px;
        font-size: 14px;
        border-radius: 3px;
        outline: none;
    }

    .name span {
        font-size: 12px;
        color: #ff673f;
        display: none;
    }

    .power-title {
        border-left: 4px solid #89acfc;
        box-sizing: border-box;
        padding: 7px 0px 10px 20px;
        background: #f6f7fd;
        overflow: hidden;
        vertical-align: middle;
        display: table;
        width: 100%;
        height: 100%;
    }

    .power-title strong {
        font-size: 18px;
        vertical-align: middle;
        display: table-cell;
        width: 120px;
        color: #333;
        font-weight: normal;
    }

    .power-list {
        font-size: 14px;
        color: #6f6f6f;
        line-height: 24px;
        float: left;
        width: 100%;
        height: 100%;
        margin-bottom: 0px;
    }

    .czicon {
        display: table-cell;
        width: 11px;
        height: 7px;
        vertical-align: middle;
        background: url(../../assets/imgs/ticon.png) no-repeat center;
        padding: 0 19px 0 20px;
        cursor: pointer;
    }

    .czicon.on {
        background: url(../../assets/imgs/bicon.png) no-repeat center
    }

    .power-tree {
        height: 0;
        width: 100%;
        box-sizing: border-box;
        border:1px solid #eaecf5;
        overflow: hidden;
        transition: all 1s ease;
        -webkit-transition: all 1s ease;
        -moz-transition: all 1s ease;
        -o-transition: all 1s ease;
        -ms-transition: all 1s ease;
        .ivu-tree{
            float: left;
        }
        .power-name{
            float: left;
            font-size: 16px;
            color: #333;
            margin-left: 20px;
            width: 100%;
        }
    }

    .power-tree.on {
        height: auto;
    }
</style>
<script type="text/ecmascript-6">
import {config} from '../../assets/js/data'
import modal from '../../components/common/modal.vue'
import role from '../../../static/role.json'
    export default {
        data () {
            return {
                data:{
                    deviceList:[],
                    deviceImport:[],
                    portList:[],
                    portImport:[]
                },
                temp:{
                    deviceList:[],
                    deviceImport:[],
                    portList:[],
                    portImport:[]
                },
                roleName:'',
                treeShow:1,
                modal:{
                    title:'',
                    content:'',
                    dialog:0,
                    url:''
                }
            }
        },
        methods:{
            setPortList(value){
                this.temp.portList = value;
            },
            setDeviceList(value){
                this.temp.deviceList = value;
            },
            setDeveiceImport(value){
                this.temp.deviceImport = value;
            },
            setPortImport(value){
                this.temp.portImport = value;
            },
            arrToString(){
                let str = '';
                let idArr = [...this.temp.deviceList,...this.temp.deviceImport,...this.temp.portList,...this.temp.portImport];
                for(let i=0;i<idArr.length;i++){
                    str+='&menuIds[]=' + (idArr[i].id||idArr[i].menuId)
                }
                return str;
            },
            roleAdd(){
                let roleIdS = this.arrToString();
                let data = 'roleName='+this.roleName + roleIdS;
                this.$http.post('role/roles/addOrUpdate?',data,config).then((res)=>{
                    if(res.data=='success'){
                        this.modal.dialog++;
                        this.modal.title = '操作成功';
                        this.modal.url = '/user/rolesShow';
                    }else if(res.data == 'error'){
                        this.modal.dialog--;
                        this.modal.title = `操作失败`;
                        this.modal.content = `请求失败,请稍后再试`
                    }else if(res.data == 'same'){
                        this.modal.dialog--;
                        this.modal.title = `操作失败`;
                        this.modal.content = `权限名称重复，请修改`
                    }
                }).catch((res)=>{
                    console.log('发送请求失败'+res)
                })
            }
        },
        mounted(){
            this.$http.get('/role/roles/menus').then((res)=>{
                this.data.deviceImport = res.data[0].menuDeviceAdd;
                this.data.deviceList = res.data[0].menuDeviceList
                this.data.portImport = res.data[0].menuPortAdd
                this.data.portList = res.data[0].menuPortList
            }).catch((res)=>{
                console.log('获取用户权限列表失败'+res)
            })
        },
        computed:{
            roleBTN() {
                if(this.roleName){
                    return false;
                }else{
                    return true;
                }
            },
            deviceIsCheck(){
                if(this.temp.deviceImport.length>0||this.temp.deviceList.length>0){
                    return false;
                }else{
                    return true;
                }
            },
            portIsCheck(){
                if(this.temp.portImport.length>0||this.temp.portList.length>0){
                    return false;
                }else{
                    return true;
                }
            }
        },
        components:{
            modal
        }
    }
</script>
