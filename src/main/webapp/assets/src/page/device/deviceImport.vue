<template>
    <div>
        <div class="module-header">
            <h4>设备导入
                <Tooltip placement="bottom-start">
                    <span class="info-question"></span>
                    <div slot="content">
                        <p>1、批量添加操作仅支持公网地址设备，私网地址设备信息的填报导入工作请联系集团负责人，联系电话：52686688-1062；</p>
                        <p>2、请开通设备SNMP采集权限，总部采集设备地址为117.136.187.8-15、117.136.191.38</p>
                    </div>
                </Tooltip>
                <span class="role-text ml-20">权限选择</span>
                <Select v-model="province" :label-in-value="true" @on-change="checkData" style="width:160px;margin-left: 15px">
                    <Option v-for="item in selectionList" :value="item.value" :key="item">{{ item.label }}</Option>
                </Select>
            </h4>
        </div>
        <Tabs type="card" :animated="false">
            <Tab-pane label="批量添加snmp V2设备">
                <div class="usermanage">
                    <div class="module-search">
                        <div class="step">
                            <p><span class="step-label">Step 1</span>下载设备添加模版， 点此 <a class="download-text" href="/cdnManage/downloadTemp?type=device_v2">下载</a></p>
                            <p><span class="step-label">Step 2</span>正确填写设备添加模版并上传，点此<a @click="modal('device_v2')">上传</a></p>
                            <p><span class="step-label">Step 3</span>在待添加设备列表中核对设备信息无误后，点击确定添加 完成操作</p>
                        </div>
                    </div>
                    <div class="module-header mt-20">
                        <h4>待添加snmp V2设备列表
                            <span class="info-text ml-20">已校验<i class="red"> {{snmp2Data.length}} </i>条设备信息</span>
                            <Button type="ghost"  @click="cancelUpload" class="right ml-10 f14">取消添加</Button>
                            <Button type="primary" @click="confirmUpload" :disabled="pythonBtn" class="btn-search right f14">确定添加</Button>
                        </h4>
                    </div>
                    <div class="tableContent">
                        <Table width="auto" stripe border :columns="columns2" :data="snmp2Data" style="margin-top: 10px"></Table>
                    </div>
                </div>
            </Tab-pane>
            <!--snmp v3 设备区域-->
            <Tab-pane label="批量添加snmp V3设备">
                <div class="usermanage">
                    <div class="module-search">
                        <div class="step">
                            <p><span class="step-label">Step 1</span>下载设备添加模版， 点此 <a class="download-text" href="/cdnManage/downloadTemp?type=device_v3">下载</a></p>
                            <p><span class="step-label">Step 2</span>正确填写设备添加模版并上传，点此<a @click="modal('device_v3')">上传</a></p>
                            <p><span class="step-label">Step 3</span>在待添加设备列表中核对设备信息无误后，点击确定添加 完成操作</p>
                        </div>
                    </div>
                    <div class="module-header mt-20">
                        <h4>待添加snmp V3设备列表
                            <span class="info-text ml-20">已校验<i class="red"> {{snmp3Data.length}} </i>条设备信息</span>
                            <Button type="ghost"  @click="cancelUpload" class="right ml-10 f14">取消添加</Button>
                            <Button type="primary" @click="confirmUpload" :disabled="pythonBtn" class="btn-search right f14">确定添加</Button>
                        </h4>
                    </div>
                    <div class="tableContent">
                        <Table width="auto" stripe border :columns="columns3" :data="snmp3Data" style="margin-top: 10px"></Table>
                    </div>
                </div>
            </Tab-pane>
        </Tabs>
        <!--上传-->
        <Modal v-model="dialog.upload" :mask-closable="false" title="文件上传">
            <div class="clearfix uploadModalContent">
                <span class="x-label">上传文件：</span>
                <span class="x-input">{{uploadData.name}}</span>
                <span class="x-button">
                    <Upload action="/cdnManage/upload" :data="this.uploadData.data" :format="['xlsx','xls']" :on-format-error="handleFormatError" :on-success="uploadSuccess" :on-error="uploadError" :on-progress="uoloading" :show-upload-list="false">
                        <Button type="primary">上传文件</Button>
                    </Upload>
                </span>
            </div>
            <p style="width: 75%; margin: 20px auto">
                注意： 请务必使用正确的设备／端口批量导入文件模版，不匹配的模版将导致批量添加操作失败。仅支持上传xls、xlsx类型的文件。
            </p>
            <div class="uploading" v-if="dialog.uploading">
                <Spin fix v-if="dialog.uploading">
                    <Icon type="load-c" size=38 class="demo-spin-icon-load"></Icon>
                    <div>上传中，请稍等...</div>
                </Spin>
            </div>
            <div class="errorInfo" v-if="dialogError.flag">
                <h6 class="red f16 text-center">上传失败！</h6>
                <p style="width: 75%; margin: 0 auto">{{dialogError.content}}</p>
            </div>
            <div class="errorInfo" v-if="dialogSuccess">
                <h6 class="red f16 text-center">上传成功！</h6>
            </div>
            <div slot="footer">
                <Button type="primary" @click="toPython" :disabled="uploadLoad">确定</Button>
                <Button type="ghost" @click="close">取消</Button>
            </div>
        </Modal>
        <Modal v-model="resultDialog" title="提示" class="userRole cdn-modal" :width="700">
            <div class="clearfix dialog-body">
                <h1>操作结果反馈</h1>
                <p class="f16"><span class="text-blue inline">{{username}}</span>用户的<span class="text-blue inline">设备</span>导入操作，返回信息如下:</p>
                <p class="result-container"v-html="resultContent">{{resultContent}}</p>
            </div>
            <div slot="footer" style="text-align: center">
                <Button type="primary" style="width:88px;" @click="reload">确定</Button>
            </div>
        </Modal>

        <Modal v-model="waitDialog" :mask-closable="false" title="正在写入" class="userRole cdn-modal">
            <div class="clearfix dialog-body">
                <p class="f14 text-center">正在与数据库同步数据中，请稍候...</p>
                <div class="spin-container mt-10">
                    <Spin fix>
                        <Icon type="load-c" size=40 class="demo-spin-icon-load"></Icon>
                    </Spin>
                </div>
                <p class="f14 text-center"> 请勿离开或关闭此页面</p>
            </div>
            <div slot="footer"></div>
        </Modal>
        <myModal :title="this.myModal.title" :content="this.myModal.content" :dialog="this.myModal.dialog"></myModal>
    </div>
</template>
<style lang="less">
    .uploading{
        position: relative;
        height: 60px;
    }
    .step{
        font-size: 14px;
    p{
        margin-bottom: 10px;
    }
    .step-label{
        color:#3694f2;
        width: 60px;
        display: inline-block;
    }
    }
    .uploadModalContent{
        padding: 30px 0;
    }
    .x-input{
        border:1px solid #d7dde4;
        display: inline-block;
        float: left;
        width: 300px;
        height: 32px;
        line-height: 32px;
        padding: 0 10px;
    }
    .x-label{
        height: 32px;
        line-height: 32px;
        display: inline-block;
        float: left;
    }
    .x-button{
        float: left;
        margin-left: 10px;
    }
    .x-area{
    h3{
        font-size: 22px;
        color: #333;
        text-align: center;
        font-weight: normal;
    }
    p{
        font-size: 14px;
        color: #666;
        text-align: center;
        margin-top: 15px;
    }
    }
    .spin-container{
        position: relative;
        height: 46px;
    }
    .demo-spin-icon-load{
        animation: ani-demo-spin 1s linear infinite;
    }
    @keyframes ani-demo-spin {
        from { transform: rotate(0deg);}
        50%  { transform: rotate(180deg);}
        to   { transform: rotate(360deg);}
    }
    .ivu-icon-ios-close-empty{
        color: #a299a5 !important;
    }
    .inline{
        display: inline !important;
    }
</style>
<script type="text/ecmascript-6">
    import {showDataSelection,snmp2tables,snmp3tables,config} from '../../assets/js/data'
    import myModal from '../../components/common/modal.vue'
    export default{
        data() {
            return {
                selectionList: [],
                roleId:this.$store.getters.getuserRoleId,
                username:this.$store.getters.getusername,
                dialog:{
                    success: false,
                    waitting: false,
                    error: false,
                    upload: false,
                    watting: false,
                    uploading: false
                },
                waitDialog:false,
                resultDialog:false,
                myModal:{
                    title:'',
                    content:'',
                    dialog:0
                },
                dialogError:{
                    flag: false,
                    content: ''
                },
                dialogSuccess:false,
                checked: 'false',
                province:'',
                pythondata:[],
                pythodFlag:0,
                snmp2Data:[],
                columns2:snmp2tables.columns,
                snmp3Data: [],
                columns3:snmp3tables.columns,
                uploadData: {
                    name: '',
                    state: 0,
                    data:{
                        type:'',
                        roleId: this.$store.getters.getuserRoleId,
                        menuName: ''
                    }
                },

            }
        },
        methods:{
            checkData(value) {      //切换数据来源
                this.province = value.value;
                this.uploadData.data.menuName = value.value;
            },
            modal(type){        //激活上传文件对话框，同步用户上传文件类型
                this.dialog.upload = true;
                this.uploadData.data.type = type;
            },
            handleFormatError (f) {         //上传格式校验
                this.dialog.uploading = false;
                this.dialogError.flag = true;
                this.dialogError.content = `文件格式错误，仅支持xls，xlsx格式文件`;
            },
            uploadError(f){                 //上传失败,网络原因
                this.dialog.uploading = false;
                this.dialogError.flag = true;
                this.dialogError.content = `网络连接错误，请稍后再试`;
            },
            uoloading(){
                this.dialog.uploading = true;
                this.dialogError.flag = false;
                this.dialogError.content = '';
            },
            uploadSuccess(res, file) {       //上传成功回传
                this.dialog.uploading = false;
                if(res.error.msg){
                    this.dialogError.flag = true;
                    this.dialogError.content = res.error.msg;
                }else if(!res.error.length){
                    this.uploadData.name = file.name;
                    this.uploadData.state = 1;
                    this.pythondata = res.data;
                    this.checked = res.checked;
                    this.dialogSuccess = true;
                }
            },
            toPython() {             //点击上传对话框
                this.dialog.upload = false;
                if(this.uploadData.data.type=='device_v2'){
                    this.snmp2Data = this.pythondata
                }else if(this.uploadData.data.type=='device_v3'){
                    this.snmp3Data = this.pythondata
                }
            },
            pythonShow() {          //数据展示
                if(this.uploadData.data.type=='device_v2'){
                    this.snmp2Data = this.pythondata
                }else if(this.uploadData.data.type=='device_v3'){
                    this.snmp3Data = this.pythondata
                }
                this.dialog.watting = false;
            },
            cancelUpload() {        //取消同步
                if(this.uploadData.data.type=='device_v2'){
                    this.snmp2Data = [];
                }else if(this.uploadData.data.type=='device_v3'){
                    this.snmp3Data = [];
                    /*this.$http.get('/cdnManage/clear?type=device_v3').then(res=>{
                     console.log(res)
                     });*/
                }
            },
            confirmUpload() {       //开始同步
                this.waitDialog = true;
                this.$http.get('/cdnManage/import?type='+this.uploadData.data.type).then(res=>{
                    this.waitDialog = false;
                    this.resultDialog = true;
                    this.resultContent = res.data;
                    this.snmp2Data = [];
                    this.snmp3Data = [];
                }).catch(res=>{
                    this.waitDialog = false;
                    this.myModal.dialog--;
                    this.myModal.title = `同步失败`;
                    this.myModal.content = `请稍后再试`;
                });
            },
            close() {
                this.uploadData.name = '';
                this.dialog.upload = false;
            },
            reset() {
                if(!this.dialog.upload){
                    this.dialogError.flag = false;
                    this.dialogError.content = '';
                    this.uploadData.name = '';
                    this.uploadData.state = 0;
                    this.dialog.uploading = false;
                    this.dialogSuccess = false;
                }
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
            }
        },
        mounted() {
            this.$http.get('/role/roles/menus?roleId='+this.roleId+'&type=deviceAdd').then(res=>{
                this.selectionList = this.userRoleList(res.data[0].menuDeviceAdd[0]);
                this.province = this.selectionList[0].value;
                this.uploadData.data.menuName = this.selectionList[0].value;
            }).catch(res=>{
                console.log('获取用户权限数据失败'+res)
            });
        },
        computed:{
            BtnDisabled(){
                if(this.selection.length){
                    return false;
                }else{
                    return true;
                }
            },
            uploadLoad() {
                if(this.uploadData.state!=1){
                    return true;
                }
            },
            snmp2DataLength() {
                if(this.snmp2Data.length>0){
                    return true;
                }else{
                    return false;
                }
            },
            snmp3DataLength() {
                if(this.snmp3Data.length>0){
                    return true;
                }else{
                    return false;
                }
            },
            pythonBtn() {
                if(this.checked=='false'){
                    return true;
                }else{
                    return false;
                }
            }
        },
        watch:{
            'dialog.upload':'reset'
        },
        components:{
            myModal
        }
    }
</script>