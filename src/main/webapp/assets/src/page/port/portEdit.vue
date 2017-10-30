<template>
    <div>
        <my-head></my-head>
        <div class="edit">
            <h2>编辑端口信息</h2>
            <h3>
                <span>用户：<i>{{username}}</i></span>
                <span style="margin-left: 40px">时间：<i>{{now}}</i></span>
            </h3>
            <div class="editInfo2">
                <p class="c3 mb-5">操作须知：</p>
                <p>1.当前仅支持对标识为可编辑的字段进行编辑，如需变更标识为不可编辑的字段，请直接联系管理员</p>
                <p>2.请按照端口管理要求进行信息的修改，不符合规则的修改将无法生效</p>
                <ul class="ml-10">
                    <li>端口类型：请按照实际情况选择：上联、下联、级联</li>
                    <li>业务大类：省公司请选择：省网上联、省际直连、三方出口、IDC、ICP直连、统建内容网络、省建Cache、省建CDN、第三方CDN、固网用户、手机用户；</li>
                    <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;国际公司请选择：付费穿透、付费直连、收费客户、免费直连、省际直连、统建内容网络、IDC</li>
                    <li>业务小类：必填字段，请按照业务大类选择对应的业务小类，具体填写方法请参考端口上传模版</li>
                    <li>对端设备：必填字段，按照实际情况填写</li>
                </ul>
            </div>
            <div class="editTable2 mt-20">
                <table cellspacing="0" cellpadding="0" border="0">
                    <tr height="42" style="background: #dce8fc; color: #333;">
                        <!--<td width="50">ID</td>-->
                        <td width="100">省份</td>
                        <td width="200">设备名称</td>
                        <td width="200">设备IP</td>
                        <td width="250">端口名称</td>
                        <td width="100">端口类型</td>
                        <td width="180">业务大类</td>
                        <td width="180">业务小类</td>
                        <td width="180">对端设备</td>
                    </tr>
                    <tr v-for="(item,index) in portData" height="48" :class="{active:index%2==0}">
                        <!--<td>{{item.id}}</td>-->
                        <td>{{item.province}}</td>
                        <td>{{item.devicesName}}</td>
                        <td>{{item.devicesIp}}</td>
                        <td>{{item.name}}</td>
                        <td>
                            <Select v-model="item.type" style="width:100px">
                                <Option v-for="i in typeList" :value="i.value" :key="i.value">{{i.label}}</Option>
                            </Select>
                        </td>
                        <td>
                            <Select v-model="item.service1View" style="width:120px">
                                <Option v-for="i in typeList2" :value="i.value" :key="i.value">{{i.label}}</Option>
                            </Select>
                         </td>
                        <td>
                            <Input v-model="item.service2View"  style="width: 170px"></Input>
                        </td>
                        <td>
                            <Input v-model="item.peerDevice"  style="width: 80px"></Input>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="text-center mt-20">
                <Button type="primary" @click="submit" style="width: 80px">确定</Button>
                <Button type="ghost" @click="cancel" style="margin-left: 10px;width: 80px">取消</Button>
            </div>
            <!---->
            <modal :title="this.modal.title" :content="this.modal.content" :dialog="this.modal.dialog" :url="this.modal.url" :cancel="this.modal.cancel"></modal>

            <Modal v-model="resultDialog" title="提示" class="userRole cdn-modal" :width="700">
                <div class="clearfix dialog-body">
                    <h1>操作结果反馈</h1>
                    <p class="f16"><span class="text-blue inline">{{username}}</span>用户的<span class="text-blue inline">端口</span>信息编辑操作，返回信息如下:</p>
                    <p class="result-container" v-html="resultContent">{{resultContent}}</p>
                    <p class="f12 text-center">点击［确定］ ，完成本次修改操作返回来源列表；点击［返回修改］，关闭弹窗并停留在编辑页面</p>
                </div>
                <div slot="footer" style="text-align: center">
                    <Button type="primary" style="width:88px; margin-right:60px;" @click="$router.push('/port/portList')">确定</Button>
                    <Button type="primary" @click="resultDialog=!resultDialog">返回修改</Button>
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
        </div>
    </div>
</template>
<style lang="less">
    .edit{
    margin-top:87px;
    padding:0 30px;
    h2{
        padding-bottom: 10px;
        font-size: 18px;
        color: #666;
        border-bottom: 2px solid #eceff9;
    }
    h3{
        padding: 15px 0;
        font-size: 14px;
        font-weight: normal;
        color:#333;
    i{
        color: #666;
    }
    }
    .editInfo2{
        color: #666;
        line-height: 1.7;
        font-size: 14px;
    }
    }
    .editTable2{
        padding-bottom: 5px;
        width:100%;
        overflow-x: auto;
    table{
        font-size: 14px;
        text-align: center;
        color: #999;
        width:1280px;
    tr{
        background: #f1f5fc;
    &.active{
         background: #FFF;
     }
    td:first-child{
        color:#666;
    }
    }
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
    .result-container{
        margin: 30px auto 100px auto !important;
        padding-left: 15px;
    }
    .inline{
    	display: inline !important;
    }
</style>
<script type="text/ecmascript-6">
    let flag = 0;
    let arr = ["上联",'下联','级联'];
    let arr2 = ['省网上联','省际直连','三方出口','IDC','ICP直连','统建内容网络','省建Cache','省建CDN','第三方CDN','固网用户','手机用户','付费穿透','付费直连','收费客户','免费直连'];
    let msg1 = '';
    let msg2 = '';
    let msg3 = '';
    import {edittables,config,showDataSelection} from '../../assets/js/data'
    import modal from '../../components/common/modal.vue'
    import myHead from '../../components/common/header'

    export default{
        data(){
            return {
                portData:this.$store.state.page.port_list ,
                typeList: showDataSelection.portTypelist,
                typeList2:showDataSelection.portTypelist2,
                waitDialog:false,
                resultDialog:false,
                resultContent:'',
                modal:{
                    title: '',
                    content: '',
                    url:'',
                    dialog: 0,
                    cancel: ''
                }
            }
        },
        methods:{
            submit(){
                let json = [];
                for(let item of this.portData){
                    if(item.service2View=='' || item.peerDevice==''||item.service2View== null || item.peerDevice == null){
                        flag = 1;
                        msg1 = '设备小类、对端设备不能为空';
                    }
                    if(item.type==''||arr.indexOf(item.type)==-1){
                        flag = 1;
                        msg2 = '端口类型不符合下拉范围';
                    }
                    if(item.service1View==''|| arr2.indexOf(item.service1View)==-1){
                        flag = 1;
                        msg3 = '业务大类类型不符合下拉范围'
                    }
                    json.push({
                        id:item.id,
                        deviceid:item.deviceid,
                        province:item.province,
                        devicesName:item.devicesName,
                        devicesIp:item.devicesIp,
                        name:item.name,
                        type:item.type,
                        service1View:item.service1View,
                        service2View:item.service2View,
                        peerDevice:item.peerDevice,
                    })
                }
                let data = 'type=port&json='+JSON.stringify(json);
                   if(flag==0){
                    this.waitDialog = true;
                    this.$http.post('/cdnManage/update',data,config).then((res)=>{
                        this.waitDialog = false;
                        this.resultDialog = true;
                       // document.getElementsByClassName('result-container')[0].innerHTML = res.data;
                        this.resultContent = res.data;
                    }).catch(res=>{
                        this.waitDialog = false;
                        this.modal.dialog--;
                        this.modal.title='更新失败';
                        this.modal.content = res.data;
                    })
                }else {
                    this.modal.dialog--;
                    this.modal.title='您输入的信息不正确，请检查后重新输入';
                    this.modal.content = msg1+'</br>'+msg2+'</br>'+msg3;
                    flag=0;
                }
            },
            cancel(){
                this.modal.dialog++;
                this.modal.content = '是否确认取消本次编辑？<br />取消后您已作出的修改将丢失'
                this.modal.url = '/port/portList';
                this.modal.cancel = 'cancel'
            }
        },
        computed: {
            username:function(){
                return this.$store.getters.getusername;
            },
            now: function(){
                const D = new Date();
                let YY = D.getFullYear();
                let MM = (D.getMonth()+1)<10?'0'+(D.getMonth()+1):(D.getMonth()+1);
                let DD = D.getDate()<10?'0'+D.getDate():D.getDate();
                let HH = D.getHours()<10?'0'+D.getHours():D.getHours();
                let MI = D.getMinutes()<10?'0'+D.getMinutes():D.getMinutes();
                let SS = D.getSeconds()<10?'0'+D.getSeconds():D.getSeconds();
                let string = YY+ '-' + MM + '-'+ DD +'  ' + HH + ':' + MI ;
                return string;
            }
        },
        components:{
            modal,
            myHead
        }
    }
</script>
