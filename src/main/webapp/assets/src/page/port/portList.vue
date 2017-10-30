<template>
    <div>
        <div class="module-header">
            <h4>端口列表
                <Select v-model="port.province" :label-in-value="true" @on-change="selectProvince" style="width:100px;margin-left: 15px">
                    <Option v-for="item in selectionProvence" :value="item.value" :key="item">{{ item.label }}</Option>
                </Select>
            </h4>
        </div>
        <div class="module-search">
            <div class="search-itemr">
                <div class="item">
                    <span class="datelabel">上传时间</span>
                    <div class="search-item">
                        <Date-picker type="date" placement="bottom-end" :value="port.beginTime" :options="options" @on-change="setStart" placeholder="选择起始日期" style="width: 155px"></Date-picker>
                    </div>
                    <div class="line"></div>
                    <div class="search-item">
                        <Date-picker type="date" placement="bottom-end" :value="port.endTime" :options="options" @on-change="setFin" placeholder="选择结束日期" style="width: 155px"></Date-picker>
                    </div>
                </div>
                <div class="item">
                    <span class="datelabel">端口属性</span>
                    <div class="search-label">
                        省份：
                    </div>
                    <div class="search-item">
                        <Select v-model="port.province" :label-in-value="true" @on-change="selectProvince" style="width:88px;">
                            <Option v-for="item in selectionProvence" :value="item.value" :key="item">{{ item.label }}</Option>
                        </Select>
                    </div>
                    <div class="search-label ml-20">
                        端口类型：
                    </div>
                    <div class="search-item">
                        <Select v-model="port.type" :label-in-value="true" @on-change="selectPortType" style="width: 80px">
                            <Option v-for="item in portTypeList" :value="item.value" :key="item">{{ item.label }}</Option>
                        </Select>
                    </div>
                    <div class="search-label ml-20">
                        业务大类：
                    </div>
                    <div class="search-item">
                        <Select v-model="port.service" :label-in-value="true" @on-change="selectService" style="width: 130px">
                            <Option v-for="item in serviceList" :value="item.value" :key="item">{{ item.label }}</Option>
                        </Select>
                    </div>
                    <div class="search-label ml-20">
                        端口状态：
                    </div>
                    <div class="search-item">
                        <Select v-model="port.statusView" :label-in-value="true" @on-change="selectportStatus" style="width: 130px">
                            <Option v-for="item in portStatus" :value="item.value" :key="item">{{ item.label }}</Option>
                        </Select>
                    </div>
                </div>
                <div class="item">
                    <span class="datelabel">设备IP检索</span>
                    <Input v-model="port.ipAddr" style="width: 350px"></Input>
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
            <a class="search-download" v-if="portData.length" :href="downloadhref">下载检索结果文件</a>
        </div>
        <div class="tableContent">
            <Table width="auto" stripe border :columns="columns" @on-selection-change="con" :data="portData" style="margin-top: 10px"></Table>
            <div class="table-set">
                <Button type="ghost" :disabled="BtnDisabled" style="margin-left: 10px" @click="download">下载所选</Button>
                <!--<Button type="ghost" :disabled="BtnDisabled" style="margin-left: 10px"><a :href="downloadsec">下载所选</a></Button>-->
                <Button type="ghost" :disabled="BtnDisabled" style="margin-left: 10px" @click="removeall">批量删除</Button>
                <Button type="ghost" :disabled="BtnDisabled" style="margin-left: 10px" @click="editAll">批量修改</Button>
                <span v-if="selection.length" class="result-info ml-20">已选中 {{selection.length}} 条记录</span>
            </div>
            <div class="page" v-if="portData">
                <Page :total="page.totalList" :page-size="50" @on-change="onChange" :current="page.pageNum"></Page>
            </div>
        </div>
        <Modal v-model="dialog.removeAll" :mask-closable="false" title="批量删除" class="removeAll" width="640">
            <div class="clearfix">
                <div>
                    <p class="mb-10">是否确定删除以下端口？</p>
                    <div class="tableContent">
                        <Table width="auto" stripe border :columns="removeColumns" :data="removeData" style="margin-top: 10px"></Table>
                    </div>
                    <p class="mt-10">操作人员：{{operatUser}}</p>
                    <p class="gray mt-10 f12">注意：</p>
                    <p class="gray f12">删除端口后，端口状态会立即标记为“已删除”，10分钟后数据库中的信息会被同步清空。</p>
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
                <p class="f16"><span class="text-blue inline">{{operatUser}}</span>用户的<span class="text-blue inline">端口</span>删除操作，返回信息如下:</p>
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
    .module-search:after{
        content: '';
        display: block;
        clear: both;
    }
    .search-itemr{
        width: 85%;
        float: left;
    }
    .search-ctrll{
        float: left;
        width: 140px;
        height: 80px;
        border-left:1px solid #ededed;
    }
    .con-before{
        text-align: left;
        margin-bottom: 20px;
    }
    .inline{
    	display: inline !important;
    }
    .text-blue1{
        margin-top: 10px;
        text-align: center;
    }
    .text-black{
        color:black;
    }
</style>
<script type="text/ecmascript-6">
    import {showDataSelection,porttables,config,removeData,download} from '../../assets/js/data'
    import modal from '../../components/common/modal.vue'
    export default{
        data() {
            return {
                selectionProvence: [],
                portTypeList: showDataSelection.portType,
                serviceList: showDataSelection.serviceList,
                portStatus:showDataSelection.portStatus,
                portData:[],
//                portData: [{
//                    devicesName:'NXYC-PB-CMNET-RT01',
//                    deviceid:'13',
//                    id:'1',
//                    province:'宁夏',
//                    devicesIp:'218.203.128.1',
//                    name:'GigabitEthernet2/6/0/0',
//                    service1View:'IDC',
//                    service2View:'无',
//                    peerDevice:null,
//                },
//                    {
//                        devicesName:'NXYC-PB-CMNET-RT02',
//                        deviceid:'15',
//                        id:'2',
//                        province:'宁夏啊',
//                        devicesIp:'218.203.128.2',
//                        IP:'218.203.128.2',
//                        name:'Vlan70',
//                        service1View:'IDC',
//                        service2View:'爱奇艺',
//                        peerDevice:null
//                    },],
                columns: porttables.columns,
                operatUser: this.$store.getters.getusername,
                roleId:this.$store.getters.getuserRoleId,
                removeData:[],
                removeColumns:removeData.portColumns,   //批量删除字段
                options: {
                    disabledDate (date) {
                        return date && date.valueOf() > Date.now();
                    }
                },
                port: {
                    ipAddr: '',
                    beginTime:'2010-01-01',
                    endTime: this.getDate(),
                    province: '全国',
                    type: '全部',
                    service: '全部',
                    statusView:'全部'
                },
                downloadhref: '',
                downloadsec: '',
                modal:{
                    title:'',
                    content:'',
                    dialog:0
                },
                loading:false,
                dialog:{
                    removeAll:false,
                    result: false,
                    resultContent: ''
                },
                page:{
                    totalList: 0,
                    pageNum: 1,
                    pageSize: 50
                },
                selection: []
            }
        },
        methods:{
            dataFormat(pageSize,pageNum){       //数据处理
                let str = ''
                for(var item in this.port){
                    str+='&'+item+'=' + this.port[item];
                }
                str+= '&pageSize='+ pageSize + '&pageNum='+ pageNum;
                return str;
            },
            searchSubmit(e,pageSize=50,pageNum=1) {        //立即检索
                this.loading = true;
                let data = this.dataFormat(pageSize,pageNum);
                this.page.pageNum = 1;
                this.$http.post('/cdnManage/portList',data,config).then(res=>{
                    this.portData = res.data.list;
                    this.page.totalList = res.data.totalCount;
                    this.loading = false;
                    this.downloadhref= '/cdnManage/exportPortsList?totlePage='+this.page.totalList+data;
                }).catch(res=>{
                    this.loading = false;
                })
            },
            //@click="removeall"
            removeall(){
                this.dialog.removeAll = true;
                this.removeData = this.selection;
            },
            editAll(){
                this.$store.dispatch('editportlist',this.selection);
                this.$router.push('/portEdit');
            },
            onChange(pageNum){         //分页查询
                let data = this.dataFormat(50,pageNum);
                this.$http.post('/cdnManage/portList',data,config).then(res=>{
                    this.portData = res.data.list;
                    this.page.totalList = res.data.totalCount;
                    this.loading = false;
                    this.downloadhref= '/cdnManage/exportPortsList?totlePage='+this.page.totalList+data;
                }).catch(res=>{
                    this.loading = false;
                })
                this.page.pageNum = pageNum;
            },
            remove_con(){       //批量删除同步后台
                this.dialog.removeAll = false;
                let json = [];
                for(var item of this.removeData){
                    json.push({
                        id: item.id,
                        province: item.province,
                        name:item.name,
                        devicesName: item.devicesName,
                        devicesIp: item.devicesIp,
                    })
                }

                let data = 'type=port&json='+JSON.stringify(json);
                this.$http.post('/cdnManage/delete',data,config).then(res=>{
                    this.dialog.result = true;
                    this.dialog.resultContent = `${res.data}`;                
                }).catch(res=>{
                    this.modal.dialog--;
                    this.modal.title = '删除失败'
                    this.modal.content = `请检查网络，稍后再试`
                })
            },
            setStart(date) {
                this.port.beginTime = date;
                if(this.port.endTime && this.port.beginTime>this.port.endTime){
                    alert('起始时间不能晚于结束时间！');
                    return false;
                }
            },
            setFin(date) {
                this.port.endTime = date;
                if(this.port.endTime<this.port.beginTime){
                    alert('结束时间不能早于起始时间！');
                    return false;
                }
            },
            selectProvince(v) {     //切换归属省份
                this.port.province = v.value
            },
            selectPortType(v) {     //切换端口类型
                this.port.type = v.value
            },
            selectService(v) {      //切换业务大类
                this.port.service = v.value
            },
            selectportStatus(v){
                this.port.statusView = v.value
            },
            con(selection){         //批量选择
                this.selection = selection;
                let data = '';
                for(let i of selection){
                    data+= 'ids[]='+i.id + '&';
                }
                this.downloadsec = '/cdnManage/exportSelPortsList?'+ data.substr(0, data.length-1);
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
            reset(){                //初始化
                this.port.ipAddr = '';
                this.port.beginTime = '2010-01-01';
                this.port.endTime = this.getDate();
                this.port.province = '全国';
                this.port.type = '全部';
                this.port.service = '全部';
                this.port.statusView = '全部';
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
        mounted(){
            //拉取用户的权限列表
            this.$http.get('/role/roles/menus?roleId='+this.roleId+'&type=portList').then(res=>{
                this.selectionProvence = this.userRoleList(res.data[0].menuPortList[0]);
                this.port.province = this.selectionProvence[0].value;
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
            }
        },
        components:{
            modal
        }
    }
</script>
