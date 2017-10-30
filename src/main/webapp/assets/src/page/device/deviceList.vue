<template>
    <div>
        <div class="module-header">
            <h4>设备列表
                <Select v-model="device.province" :label-in-value="true" @on-change="selectProvince" style="width:160px;margin-left: 15px">
                    <Option v-for="item in selectionProvence" :value="item.value" :key="item">{{ item.label }}</Option>
                </Select>
            </h4>
        </div>
        <div class="module-search">
            <div class="search-itemr">
                <div class="item">
                    <span class="datelabel">上传时间</span>
                    <div class="search-item">
                        <Date-picker type="date" placement="bottom-end" :clearable="false" :value="device.beginTime" :options="options" @on-change="setStart" placeholder="选择起始日期" style="width: 155px"></Date-picker>
                    </div>
                    <div class="line"></div>
                    <div class="search-item">
                        <Date-picker type="date" placement="bottom-end" :clearable="false" :value="device.endTime" :options="options" @on-change="setFin" placeholder="选择结束日期" style="width: 155px"></Date-picker>
                    </div>
                </div>
                <div class="item">
                    <span class="datelabel">设备属性</span>
                    <div class="search-label">
                        省份：
                    </div>
                    <div class="search-item">
                        <Select v-model="device.province" :label-in-value="true" @on-change="selectProvince1" style="width:160px;margin-left: 15px">
                            <Option v-for="item in selectionProvence" :value="item.value" :key="item">{{ item.label }}</Option>
                        </Select>
                    </div>
                    <div class="search-label ml-20">
                        设备类型：
                    </div>
                    <div class="search-item">
                        <Select v-model="device.type" :label-in-value="true" @on-change="v=>{ setOption(v,'type')}" style="width:138px;">
                            <Option v-for="item in deviceTypeList" :value="item.value" :key="item">{{ item.label }}</Option>
                        </Select>
                    </div>
                    <div class="search-label ml-20">
                        SNMP版本：
                    </div>
                    <div class="search-item">
                        <Select v-model="device.snmpVersionView" :label-in-value="true" @on-change="selectSMNP" style="width:88px;">
                            <Option v-for="item in SMNPList" :value="item.value" :key="item">{{ item.label }}</Option>
                        </Select>
                    </div>
                    <!--<div class="search-label ml-20">-->
                        <!--端口：-->
                    <!--</div>-->
                    <!--<div class="search-item">-->
                        <!--<Select v-model="device.snmpPort" :label-in-value="true" @on-change="selectPort" style="width:88px;">-->
                            <!--<Option v-for="item in portList" :value="item.value" :key="item">{{ item.label }}</Option>-->
                        <!--</Select>-->
                    <!--</div>-->
                    <div class="search-label ml-20 search-labelm1">
                        设备状态：
                    </div>
                    <div class="search-item search-itemm1">
                        <Select v-model="device.statusView" :label-in-value="true" @on-change="selectStatus" style="width:150px;">
                            <Option v-for="item in deviceStatus" :value="item.value" :key="item">{{ item.label }}</Option>
                        </Select>
                    </div>
                </div>
                <div class="item">
                    <span class="datelabel">设备IP检索</span>
                    <Input v-model="device.ipAddr" style="width: 350px"></Input>
                </div>
            </div>
            <div class="search-ctrll">
                <Button type="primary" class="btn-search ml-20 mt-40" @click.native="searchSubmit" :loading="loading">
                    <span v-if="!loading">立即检索</span>
                    <span v-else>检索中</span>
                </Button>
                <a class="text-blue" @click="reset">清空</a>
            </div>
        </div>
        <div class="search-result">
            <p class="search-content">已查找到<span>{{page.totalList}}</span>条数据</p>
            <a class="search-download" :href="downloadhref" v-if="deviceData.length">下载检索结果文件</a>
        </div>
        <div class="tableContent">
            <Table width="auto" stripe border :columns="columns" @on-selection-change="con" :data="deviceData" style="margin-top: 10px"></Table>
            <div class="table-set">
                <Button type="ghost" :disabled="BtnDisabled" style="margin-left: 10px" @click="download">下载所选</Button>
                <!--<Button type="ghost" :disabled="BtnDisabled" style="margin-left: 10px"><a :href="downloadsec">下载所选</a></Button>-->
                <Button type="ghost" :disabled="BtnDisabled" style="margin-left: 10px" @click="removeall">批量删除</Button>
                <Button type="ghost" :disabled="BtnDisabled" style="margin-left: 10px" @click="editAll">批量修改</Button>
                <span v-if="selection.length" class="result-info ml-20">已选中 {{selection.length}} 条记录</span>
            </div>
            <div class="page" v-if="deviceData">
                <Page :total="page.totalList" :page-size="50" @on-change="onChange" :current="page.pageNum"></Page>
            </div>
        </div>
        <!--批量删除-->
        <Modal v-model="dialog.removeAll" :mask-closable="false" title="批量删除" class="removeAll" width="640">
            <div class="clearfix">
                <div>
                    <p class="mb-10">是否确定删除以下设备？</p>
                    <div class="tableContent">
                        <Table width="auto" stripe border :columns="removeColumns" :data="removeData" style="margin-top: 10px"></Table>
                    </div>
                    <p class="mt-10">操作人员：{{operatUser}}</p>
                    <p class="gray mt-10 f12">注意：</p>
                    <p class="gray f12">删除设备后，设备状态会立即标记为“已删除”，10分钟后数据库中的信息会被同步清空。</p>
                </div>
            </div>
            <div slot="footer">
                <Button type="primary" style="width:80px" class="align f14" @click="remove_con">确定</Button>
                <Button type="ghost" style="width:80px" class="align f14" @click="dialog.removeAll=!dialog.removeAll">取消</Button>
            </div>
        </Modal>

        <Modal v-model="dialog.result" title="提示" class="userRole cdn-modal" :width="700">
            <div class="clearfix dialog-body">
                <h1>操作结果反馈</h1>
                <p class="f16"><span class="text-blue inline">{{operatUser}}</span>用户的<span class="text-blue inline">设备</span>删除操作，返回信息如下:</p>
                <p class="result-container" v-html="dialog.resultContent">{{dialog.resultContent}}</p>
            </div>
            <div slot="footer" style="text-align: center">
                <Button type="primary" style="width:88px;" @click="reload">确定</Button>
            </div>
        </Modal>

        <modal :title="this.modal.title" :content="this.modal.content" :dialog="this.modal.dialog"></modal>
    </div>
</template>
<style lang="less">
.text-blue{
    display: block;
    margin-top:10px;
    text-align: center;
}
.btn-search{
    span{
        font-size: 16px;
    }
}
.removeAll{
    .ivu-modal-body{
        padding: 15px 30px;
        font-size: 14px;
        color: #666;
    }
}
.page{
    float: right;
    margin-top: 10px;
}
.module-search{
    .search-itemr{
        width: 85%;
        float: left;
    }
    .search-ctrll{
        float: left;
        width: 140px;
        height: 120px;
        margin-top: 10px;
        border-left:1px solid #ededed;
    }
}
.module-search:after{
    content: '';
    display: block;
    clear: both;
}
@media  screen and (max-width: 1220px){
    .search-label{
        margin-left: 0px !important;
    }
}
@media  screen and (min-width: 500px) and (max-width: 750px){
    .search-label{
        margin-left: 0px !important;
    }
    .ivu-btn ivu-btn-ghost{
        margin-left: 0px !important;
    }
    .main{
        padding:50px 30px 100px 30px !important;
    }
    .cm-accordion-menu{
        display: none !important;
    }
    .breadcrumb {
        position: absolute;
        top: 20px;
        left: 30px !important;
        font-size: 14px;
        color: #999;
    }
   
}
.con-before{
    text-align: left;
    margin-bottom: 20px;
}
.inline{
	display: inline !important;
}
.text-black{
    color:black;
}
.text-blue1{
    margin-top: 10px;
    text-align: center;
}
</style>
<script type="text/ecmascript-6">
    import {showDataSelection,devicetables,removeData,config} from '../../assets/js/data'
    import modal from '../../components/common/modal.vue'
    export default{
        data() {
            return {
                 deviceData: [],                     //列表数据
//                deviceData:[
//                    {
//                        id: 331,
//                        province: '浙江',
//                        name: 'NXYC-PB-CMNET-RT01',
//                        ipAddr: '218.203.128.1',
//                        room: '生产中心三楼数据机房',
//                        snmpPort:'161'
//                    },
//                    {
//                        id: 334,
//                        province: '浙江',
//                        name: 'NXYC-PB-CMNET-RT01',
//                        ipAddr: '218.203.128.1',
//                        room: '生产中心三楼数据机房',
//                        type: '省网设备',
//                        snmpPort:'162'
//                    }
//                ],
                operatUser: this.$store.getters.getusername,
                roleId:this.$store.getters.getuserRoleId,
                selectionProvence: [],

                deviceTypeList: showDataSelection.deviceTypeList,
                SMNPList: showDataSelection.SMNPList,
                portList: showDataSelection.portList,
                deviceStatus:showDataSelection.deviceStatus,

                columns: devicetables.columns,      //列表头
                removeColumns:removeData.columns,   //批量删除字段
                removeData:[],
                options: {
                    disabledDate (date) {
                        return date && date.valueOf() > Date.now();
                    }
                },
                device: {               //上传数据
                    ipAddr: '',
                    beginTime: '2010-01-01',
                    endTime: this.getDate(),
                    province: '全国',
                    type: '全部',
                    snmpVersionView: '全部',
                    statusView:'全部'
                },
                downloadhref:'',
                downloadsec:'',
                page:{
                    totalList: 0,
                    pageNum: 1,
                    pageSize: 50
                },
                loading:false,
                selection: [],
                dialog:{
                    removeAll:false,
                    result: false,
                    resultContent: ''
                },
                modal:{
                    title:'',
                    content:'',
                    dialog:0
                },
            }
        },
        methods:{
            dataFormat(pageSize,pageNum){       //数据处理
                let str = ''
                for(var item in this.device){
                    str+='&'+item+'=' + this.device[item];
                }
                str+= '&pageSize='+ pageSize + '&pageNum='+ pageNum;
                return str;
            },
            searchSubmit(e,pageSize=50,pageNum = 1) {        //立即检索
                this.loading = true;
                let data = this.dataFormat(pageSize,pageNum);
                this.page.pageNum = 1;
                this.$http.post('/cdnManage/deviceList',data,config).then(res=>{
                    this.deviceData = res.data.list;
                    this.page.totalList = res.data.totalCount;
                    this.loading = false;
                    this.downloadhref= '/cdnManage/exportDevicesList?totlePage='+this.page.totalList+data;
                }).catch(res=>{
                    this.loading = false;
                })
            },
            remove_con(){       //批量删除同步后台
                this.dialog.removeAll = false;
                let json = [];
                for(var item of this.removeData){
                    json.push({
                        id: item.id,
                        province: item.province,
                        name:item.name,
                        ipAddr:item.ipAddr
                    })
                }
                let data = 'type=device&json='+JSON.stringify(json);
                this.$http.post('/cdnManage/delete',data,config).then(res=>{
                    this.dialog.result = true;
                    this.dialog.resultContent = `${res.data}`;                
                }).catch(res=>{
                    this.modal.dialog--;
                    this.modal.title = '删除失败'
                    this.modal.content = `请检查网络，稍后再试`
                })
            },
            editAll(){      //批量修改
                this.$store.dispatch('editdevicelist',this.selection);
                this.$router.push('/deviceEdit');
            },
            onChange(pageNum){         //分页查询
                let data = this.dataFormat(50,pageNum);
                this.$http.post('/cdnManage/deviceList',data,config).then(res=>{
                    this.deviceData = res.data.list;
                    this.page.totalList = res.data.totalCount;
                    this.loading = false;
                    this.downloadhref= '/cdnManage/exportDevicesList?totlePage='+this.page.totalList+data;
                }).catch(res=>{
                    this.loading = false;
                })
                this.page.pageNum = pageNum;
            },
            setStart(date) {
                this.device.beginTime = date;
                if(this.device.endTime && this.device.beginTime>this.device.endTime){
                    alert('起始时间不能晚于结束时间！');
                    return false;
                }
            },
            setFin(date) {
                this.device.endTime = date;
                if(this.device.endTime<this.device.beginTime){
                    alert('结束时间不能早于起始时间！');
                    return false;
                }
            },
            selectDevice(value) {   //切换设备类型
                this.device.type = value.value
            },
            selectSMNP(v) {         //切换smnp
                this.device.snmpVersionView = v.value
            },
            selectProvince(v) {     //切换归属省份
                this.device.province = v.value
            },
            selectProvince1(v){
                this.device.province = v.value
            },
            selectStatus(v){
                this.device.statusView = v.value
            },
            selectPort(v) {         //切换端口
                this.device.snmpPort = v.value
            },

            con(selection){
                this.selection = selection;
                let data = '';
                for(let i of selection){
                    data+= 'ids[]='+i.id + '&';
                }
                this.downloadsec = '/cdnManage/exportSelDevicesList?'+ data.substr(0, data.length-1);
            },
            removeall() {       //激活批量删除Moadl
                this.dialog.removeAll = true;
                this.removeData = this.selection;
            },
            reset(){        //清空检索条件
                this.device.ipAddr = "";
                this.device.beginTime = '2010-01-01';
                this.device.endTime = this.getDate();
                this.device.province = '全国';
                this.device.type = '全部';
                this.device.snmpVersionView = '全部';
                this.device.snmpPort = '全部';
                this.device.statusView = '全部';
            },
            getDate(){
                let date = new Date();
                let seperator1 = "-";
                let month = date.getMonth() + 1;
                let strDate = date.getDate();
                if (month >= 1 && month <= 9) {
                    month = "0" + month;
                }
                if (strDate >= 0 && strDate <= 9) {
                    strDate = "0" + strDate;
                }
                let currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
                return currentdate;
            },
            userRoleList(data){     //处理用户列表可用权限
                let roleList = [];
                if(data.checked){
                    roleList.push({label:'全国',value:'全国'})
                }
                for(var item of data.children){
                    if(item.checked){
                        var _temp = {
                            label: item.img,
                            value: item.img
                        }
                        roleList.push(_temp)
                    }
                }
                return roleList;
            },
            reload() {
                window.location.reload();
            },
            download(){
                window.location.href = this.downloadsec;
            }
        },
        computed:{
            BtnDisabled(){
                if(this.selection.length){
                    return false;
                }else{
                    return true;
                }
            }
        },
        mounted(){
            //拉取用户的权限列表
            this.$http.get('/role/roles/menus?roleId='+this.roleId+'&type=deviceList').then(res=>{
                this.selectionProvence = this.userRoleList(res.data[0].menuDeviceList[0]);
                this.device.province = this.selectionProvence[0].value;
            }).catch(res=>{
                console.log('获取用户权限数据失败'+res)
            });
            /*//获取设备信息全部数据
            this.$http.get('/cdnManage/devicesList?province='+).then(res=>{
                this.deviceData = res.data;
                this.page.totleList = res.data.totleList;
            }).catch(res=>{
                console.log('获取设备信息列表数据失败'+res);
            })*/
        },
        components:{
            modal
        }
    }
</script>
