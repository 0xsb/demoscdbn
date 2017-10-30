/**
 * Created by syzx9801@163.com on 2017/4/26.
 */
//前台展现数据
export const showDataSelection = {
    dataTypeList: [
        {
            value:'all',
            label: '全部数据'
        },
        {
            value: 'user',
            label: '用户数据'
        },
        {
            value: 'show',
            label: '数据总览'
        }
    ],
    dataPublishClassify:[
        {
            value: '全部',
            label: '全部'
        },
        {
            value:'全国数据',
            label:'全国数据'
        },
        {
            value:'流量分析',
            label:'流量分析'
        },
        {
            value:'链路分析',
            label:'链路分析'
        },
        {
            value:'拥塞监控',
            label:'拥塞监控'
        },
    ],
    deviceStatus:[
        {
        value: '全部',
        label: '全部'
        },{
            value: '0_1',
            label: '导入未采集'
        },{
            value: '3',
            label: '导入已采集'
        },{
            value: '4_5',
            label: '已删除'
        },
    ],
    portStatus:[{
        value: '全部',
        label: '全部'
    },{
        value: '0_1',
        label: '导入未采集'
    },{
        value: '3',
        label: '导入已采集'
    },{
        value: '4_5',
        label: '已删除'
    },],
    portTypelist:[
        {
            value: '上联',
            label: '上联'
        },
        {
            value: '下联',
            label: '下联'
        },
        {
            value: '级联',
            label: '级联'
        },
    ],
    portTypelist2:[
        {
            value: '省网上联',
            label: '省网上联'
        },
        {
            value: '省际直连',
            label: '省际直连'
        },
        {
            value: '三方出口',
            label: '三方出口'
        },
        {
            value: 'IDC',
            label: 'IDC'
        },
        {
            value: 'ICP直连',
            label: 'ICP直连'
        },
        {
            value: '统建内容网络',
            label: '统建内容网络'
        },
        {
            value: '省建Cache',
            label: '省建Cache'
        },
        {
            value: '省建CDN',
            label: '省建CDN'
        },
        {
            value: '第三方CDN',
            label: '第三方CDN'
        },
        {
            value: '固网用户',
            label: '固网用户'
        },
        {
            value: '手机用户',
            label: '手机用户'
        },
        {
            value: '付费穿透',
            label: '付费穿透'
        },
        {
            value: '付费直连',
            label: '付费直连'
        },
        {
            value: '收费客户',
            label: '收费客户'
        },
        {
            value: '免费直连',
            label: '免费直连'
        },
    ],
    deviceTypeList: [
        {
            value: '全部',
            label: '全部'
        },
        {
            value: '省网设备',
            label: '省网设备'
        },
        {
            value: '城域网设备',
            label: '城域网设备'
        },
        {
            value: 'IDC设备',
            label: 'IDC设备'
        },
        {
            value: '国际设备',
            label: '国际设备'
        },
        {
            value: '骨干网设备',
            label: '骨干网设备'
        },
        /*{
            value: 'Cache/CDN设备',
            label: 'Cache/CDN设备'
        },
        {
            value: 'PB设备-省网核心',
            label: 'PB设备-省网核心'
        },
        {
            value: 'PC设备-省网汇入',
            label: 'PC设备-省网汇入'
        }*/
    ],
    deviceTypeList2: [
        {
            value: '省网设备',
            label: '省网设备'
        },
        {
            value: '城域网设备',
            label: '城域网设备'
        },
        {
            value: 'IDC设备',
            label: 'IDC设备'
        },
        {
            value: '国际设备',
            label: '国际设备'
        },
        {
            value: '骨干网设备',
            label: '骨干网设备'
        },
        /*{
         value: 'Cache/CDN设备',
         label: 'Cache/CDN设备'
         },
         {
         value: 'PB设备-省网核心',
         label: 'PB设备-省网核心'
         },
         {
         value: 'PC设备-省网汇入',
         label: 'PC设备-省网汇入'
         }*/
    ],
    SMNPList: [
        {
            value: '全部',
            label: '全部'
        },
        {
            value: 1,
            label: 'v1'
        },
        {
            value: 2,
            label: 'v2c'
        },
        {
            value: 3,
            label: 'v3'
        }
    ],
    portList: [
        {
            value: '全部',
            label: '全部'
        },
        {
            value: 'V1',
            label: 'V1'
        }, {
            value: 'V2C',
            label: 'V2C'
        }, {
            value: 'V3',
            label: 'V3'
        }
    ],
    portType:[
        {
            label: '全部',
            value: '全部'
        },
        {
            label: '上联',
            value: '上联'
        },
        {
            label: '下联',
            value: '下联'
        },
        {
            label: '级联',
            value: '级联'
        },
       /* {
            label: '其他',
            value: '其他'
        }*/
    ],
    serviceList: [
        {
            label: '全部',
            value: '全部'
        },
        {
            label: '省网上联',
            value: 7387
        },
        {
            label: '省际直连',
            value: 7862
        },
        {
            label: '三方出口',
            value: 424
        },
        {
            label: 'IDC',
            value: 69
        },
        {
            label: 'ICP直连',
            value: 2153
        },
        {
            label: '统建内容网络',
            value: 943
        },
        {
            label: '省建Cache',
            value: 7347
        },
        {
            label: '省建CDN',
            value: 14799
        },
        {
            label: '第三方CDN',
            value: 309
        },
        {
            label: '固网用户',
            value: 5581
        },
        {
            label: '手机用户',
            value: 5576
        },
        {
            label: '付费穿透',
            value: 31927
        },
        {
            label: '付费直连',
            value: 32037
        },
        {
            label: '收费客户',
            value: 32172
        },
        {
            label: '免费直连',
            value: 32022
        }
    ],
    logTypeList: [
        {
            label: '全部',
            value: 'all'
        },
        {
            label: '新增设备',
            value: 'add'
        },
        {
            label: '修改设备',
            value: 'modify'
        },
        {
            label: '删除设备',
            value: 'delete'
        }
    ],
    sourceList: [
        {
            label: '全部来源',
            value: 'all'
        },
        {
            label: '用户操作',
            value: 'user'
        },
        {
            label: '后台同步',
            value: 'computer'
        }
    ],
    resultList: [
        {
            label: '全部',
            value: 'all'
        },
        {
            label: '成功',
            value: 'success'
        },
        {
            label: '失败',
            value: 'faild'
        },
        {
            label: '异常',
            value: 'error'
        },
    ]
}
export const showDataList = {
    deviceList: [
        {
            title:'已导入数据',
            yesterday: '10355',
            all: '33546'
        }
    ],
    portList: [
        {
            title:'已导入数据',
            yesterday: '10355',
            all: '33546'
        }
    ],
    dataUsageList: [
        {
            title:'已导入数据',
            yesterday: '10355',
            all: '33546'
        }
    ]
}
export const devicetables = {
    columns: [
        {
            type: 'selection',
            fixed: 'left',
            width: 60
        },
        // {
        //     title: '设备ID',
        //     key: 'id',
        //     width:100
        // },
        {
            title: '设备状态',
            key: 'status',
            width: 100,
            render:(fc, obj)=>{
                let text = '';
                if(obj.row.status=='0'||obj.row.status=='1'){
                    text = '导入未采集'
                }else if(obj.row.status=='3'){
                    text = '导入已采集'
                }else if(obj.row.status=='4'||obj.row.status=='5'){
                    text = '已删除'
                }
                return `${text}`;
            }
        },
        {
            title: '省份',
            key: 'province',
            width: 80,
        },
        {
            title: '设备名称',
            key: 'name',
            width: 200
        },
        {
            title: '设备IP',
            key: 'ipAddr',
            width: 150
        },
        {
            title: '所属机房',
            key: 'room',
            width: 200
        },
        {
            title: '设备类型',
            key: 'type',
            width: 100,
            render:(fc,obj)=>{
                let text = '';
                if(obj.row.type==''||obj.row.type=='null'){
                    text = 'NULL';
                }else{
                    text = obj.row.type;
                }
                return text;
            }
        },

        {
            title: 'SNMP版本',
            key: 'snmpVersion',
            width: 80,
            render:(fc,obj)=>{
                let text = '';
                if(obj.row.snmpVersion==1){
                    text = 'v1'
                }else if(obj.row.snmpVersion == 2){
                    text = 'v2c'
                }else if(obj.row.snmpVersion == 3){
                    text = 'v3'
                }else{
                    text = 'NULL'
                }
                return `${text}`;
            }
        },
        {
            title: 'SNMP端口',
            key: 'snmpPort',
            width: 80,
        },
        {
            title: 'SNMP团体字',
            key: 'snmpCommunity',
            width:120
        },
        {
            title: 'SNMPv3安全名称',
            key: 'snmpv3Securityname',
            width: 120
        },
        {
            title: 'SNMPv3安全级别',
            key: 'snmpv3Securitylevel',
            width: 120,
        },
        {
            title: 'SNMPv3认证协议',
            key: 'snmpv3Authprotocol',
            width: 120
        },
        {
            title: 'SNMPv3认证口令',
            key: 'snmpv3Authpassphrase',
            width: 120
        },
        {
            title: 'SNMPv3加密协议',
            key: 'snmpv3Privprotocol',
            width: 120
        },
        {
            title: 'SNMPv3私有密钥',
            key: 'snmpv3Privpassphrase',
            width: 120
        },
        {
            title: '备注',
            key: 'description',
            width:120
        },
        {
            title: '上传时间',
            key: 'lastmodifiedTimeView',
            width: 120
        }
    ]
}
export const porttables = {
    columns: [
        {
            type: 'selection',
            align: 'center',
            fixed: 'left',
            width: 60
        },
        // {
        //     title: '端口ID',
        //     key: 'id',
        //     width:100
        // },
        {
            title: '端口状态',
            key: 'status',
            width: 100,
            render:(fc, obj)=>{
                let text = '';
                if(obj.row.status=='0'||obj.row.status=='1'){
                    text = '导入未采集'
                }else if(obj.row.status=='3'){
                    text = '导入已采集'
                }else if(obj.row.status=='4'||obj.row.status=='5'){
                    text = '已删除'
                }
                return `${text}`;
            }
        },
        {
            title: '设备ID',
            key: 'deviceid',
            width:80
        },
        {
            align: 'center',
            title: '省份',
            key:'province',
            width: 80
        },
        {
            title: '设备名称',
            key: 'devicesName',
            width: 260
        },
        {
            title: '设备IP',
            key: 'devicesIp',
            width: 160
        },
        {
            title: '端口名称',
            key: 'name',
            width: 210
        },
        {
            title: '端口类型',
            key: 'type',
            width: 120,
            render:(fc,obj)=>{
                let text = '';
                if(obj.row.type==''||obj.row.type=='null'){
                    text = 'NULL';
                }else{
                    text = obj.row.type;
                }
                return text;
            }
        },

        {
            title: '业务大类',
            key: 'service1View',
            width: 135
        },
        {
            title: '业务小类',
            key: 'service2View',
            width: 135
        },
        {
            title: '对端设备',
            key: 'peerDevice',
            width: 135
        },
        {
            title: '上传时间',
            key: 'lastmodifiedTimeView',
            align: 'center',
            width: 135
        }
    ]
}
export const snmp2tables = {
    columns: [
        {
            type: 'index',
            align: 'center',
            title: '序号',
            fixed: 'left',
            width: 100
        },
        {
            title: '校验',
            align: 'center',
            key: 'check',
            width: 200,
            render:(fc,obj)=>{
                if(obj.row.check=='正常无错误'){
                    return fc('p',{class:'sure'},obj.row.check)
                }else{
                    return fc('p',{class:'wrong'},obj.row.check)
                }
            }
        },
        {
            title: '设备状态',
            align: 'center',
            key: 'deviceState',
            width: 100
        },
        {
            title: '省份',
            align: 'center',
            key: 'province',
            width: 100
        },
        {
            title: '设备名称',
            key: 'deviceName',
            align: 'center',
            width: 200
        },
        {
            title: '设备IP',
            key: 'IP',
            align: 'center',
            width: 200
        },
        {
            title: '所属机房',
            key: 'labs',
            align: 'center',
            width: 250
        },
        {
            title: '设备类型',
            key: 'deviceType',
            align: 'center',
            width: 200
        },
        {
            title: 'snmp版本',
            key: 'snmpVersion',
            align: 'center',
            width: 200,
        },
        {
            title: 'snmp端口',
            key: 'snmpPort',
            width: 200
        },
        {
            title: 'snmp团体字',
            key: 'snmpRaid',
            width: 200
        }
    ]
}
export const snmp3tables = {
    columns: [
        {
            type: 'index',
            align: 'center',
            title: '序号',
            fixed: 'left',
            width: 100
        },
        {
            title: '校验',
            align: 'center',
            key: 'check',
            width: 200,
            render(fc,obj){
                if(obj.row.check=='正常无错误'){
                    return fc('p',{class:'sure'},obj.row.check)
                }else{
                    return fc('p',{class:'wrong'},obj.row.check)
                }
            }
        },
        {
            title: '设备状态',
            align: 'center',
            key: 'deviceState',
            width: 100
        },
        {
            title: '省份',
            align: 'center',
            key: 'province',
            width: 100
        },
        {
            title: '设备名称',
            key: 'deviceName',
            width: 200
        },
        {
            title: '设备IP',
            key: 'IP',
            width: 200
        },
        {
            title: '所属机房',
            key: 'labs',
            width: 250
        },
        {
            title: '设备类型',
            key: 'deviceType',
            width: 200,
        },
        {
            title: 'snmp版本',
            key: 'snmpVersion',
            width: 200,
        },
        {
            title: 'SNMPv3安全名称',
            key: 'snmpSaveName',
            width: 200
        },
        {
            title: 'SNMPv3安全级别',
            key: 'snmpv3SaveLevel',
            width: 200
        },
        {
            title: 'SNMPv3认证协议',
            key: 'snmpv3Protocol',
            width: 200
        },
        {
            title: 'SNMPv3认证口令',
            key: 'snmpv3Command',
            width: 200
        },
        {
            title: 'SNMPv3加密协议',
            key: 'snmpv3Encryp',
            width: 200
        },
        {
            title: 'SNMPv3私有密钥',
            key: 'snmpv3EncrypCode',
            width: 200
        },
        {
            title: '备注',
            key: 'description',
            width: 200
        }
    ]
}
export const portCheckTables = {
    columns: [
        {
            type: 'index',
            align: 'center',
            title: '序号',
            fixed: 'left',
            width: 100
        },
        {
            title: '校验',
            align: 'center',
            key: 'check',
            width: 200,
            render(fc,obj){
                if(obj.row.check=='正常无错误'){
                    return fc('p',{class:'sure'},obj.row.check)
                }else{
                    return fc('p',{class:'wrong'},obj.row.check)
                }
            }
        },
        {
            title: '端口状态',
            align: 'center',
            key: 'portState',
            width: 100
        },
        {
            align: 'center',
            title: '省份',
            key: 'province',
            width: 100
        },
        {
            title: '设备名称',
            key: 'deviceName',
            width: 200
        },
        {
            title: '设备IP',
            key: 'IP',
            width: 200
        },
        {
            title: '端口名称',
            key: 'portName',
            width: 250
        },
        {
            title: '端口类型',
            key: 'portType',
            width: 200,
        },
        {
            title: '业务大类',
            key: 'service',
            width: 200,
        },
        {
            title: '业务小类',
            key: 'serviceSuper',
            width: 200
        },
        {
            title: '对端设备',
            key: 'pearDevice',
            width: 200
        },
        {
            title: '备注',
            key: 'description',
            width: 200
        },
    ]
}
export const removeData = {  //设备批量删除
    columns:[       //表头
        {
            title: '省份',
            key: 'province',
            width: 75
        },
        {
            title: '设备名称',
            key: 'name'
        },
        {
            title: '设备IP',
            key: 'ipAddr'
        },
        {
            title: '设备类型',
            key: 'type'
        }
    ],
    portColumns:[
        {
            title: '省份',
            key: 'province',
            width: 75
        },
        {
            title: '端口名称',
            key: 'name'
        },
        {
            title: '设备IP',
            key: 'devicesIp'
        },
        {
            title: '端口类型',
            key: 'type'
        }
    ]
}
export const edittables = {
    device: [
        {
            title: 'ID',
            key: 'id',
            width:100
        },
        {
            title: '省份',
            key: 'province',
            width: 75
        },
        {
            title: '设备名称',
            key: 'name',
            width: 185
        },
        {
            title: '设备IP',
            key: 'ipAddr',
            width: 180
        },
        {
            title: '所属机房',
            key: 'room',
            width: 280
        },
        {
            title: '设备类型',
            key: 'type',
            width: 200,
            render:(fc,obj)=>{
                let text = '';
                if(obj.row.type==null){
                    text = '';
                }else{
                    text = obj.row.type;
                }
                return text;
            }
        },
        {
            title: 'SNMP版本',
            key: 'snmpVersion',
            width: 140,
            render:(fc,obj)=>{
                const text = obj.row.snmpVersion ? '有':'无';
                return `${text}`;
            }
        },
        {
            title: 'SNMP端口',
            key: 'snmpPort',
            width: 140,
        },
        {
            title: 'SNMP团体字',
            key: 'snmpCommunity',
            width: 200
        },
        {
            title: 'SNMPv3安全名称',
            key: 'snmpv3Securityname',
            width: 200
        },
        {
            title: 'SNMPv3安全级别',
            key: 'snmpv3Securitylevel',
            width: 200,
        },
        {
            title: 'SNMPv3认证协议',
            key: 'snmpv3Authprotocol',
            width: 200
        },
        {
            title: 'SNMPv3认证口令',
            key: 'snmpv3Authpassphrase',
            width: 200
        },
        {
            title: 'SNMPv3加密协议',
            key: 'snmpv3Privprotocol',
            width: 200
        },
        {
            title: 'SNMPv3私有密钥',
            key: 'snmpv3Privpassphrase',
            width: 200
        }
    ],
    deviceData:[
        {
            id: 331,
            province: '浙江',
            name: 'NXYC-PB-CMNET-RT01',
            ipAddr: '218.203.128.1',
            room: '生产中心三楼数据机房',
            type: '省网设备',
        },
        {
            id: 334,
            province: '浙江',
            name: 'NXYC-PB-CMNET-RT01',
            ipAddr: '218.203.128.1',
            room: '生产中心三楼数据机房',
            type: 3,
        }
    ]
}

//管理后台数据
export const userlisttables = {
    columns:[
        {
            type: 'selection',
            align: 'center',
            width: 100
        },
        {
            type: 'index',
            align: 'center',
            title: '序号',
            width: 100
        },
        {
            title: '账户名称',
            key: 'userName',
            align: 'center',
        },
        {
            title: '公司',
            key: 'company',
            align: 'center',
        },
        {
            title: '权限分配',
            key: 'roleName',
            align: 'center',

        },
        {
            title: '状态',
            key: 'state',
            align: 'center',
            width: 170
        },
        {
            title: '最近在线',
            key: 'delayDate',
            align: 'center',
            width: 170,
            render (fc,obj){
                if(obj.row.loginStatus){
                    return `当前在线`
                }else{
                    return `${obj.row.lastTime}`
                }
            }
        },
        {
            title: '操作',
            key: 'action',
            width: 160,
            align: 'center',
            render: (fc,obj)=>{
                return fc('div',[fc('a',{
                    on:{
                        click:()=>{
                            this.detail(obj.row.userId)
                        }
                    }
                },`查看`),fc('a',{
                    style:{
                        marginLeft: '10px'
                    },
                    on:{
                        click:()=>{
                            this.remove(obj.row.userId)
                        }
                    }
                },`修改`)])
            }
        }
    ]
}
export const roleslisttables = {
    columns:[
        {
            type: 'selection',
            width: 100
        },
        {
            type: 'index',
            title: '序号',
            width: 100
        },
        {
            title: '权限名称',
            key: 'roleName',
            width: 200
        },
        {
            title: '权限详情',
            key: 'roleDesc',
        },
        {
            title: '用户数量',
            key: 'usersCount',
            align: 'center',
            width: 100
        },
        {
            title: '操作',
            key: 'action',
            width: 240,
            align: 'center',
            render: (fc,obj)=>{
                if(obj.row.usersCount<1){
                //    return `<a @click="detail(${obj.row.roleId})">查看</a> <a style="margin-left: 10px" @click="edit(${obj.row.roleId})">修改</a> <a style="margin-left: 10px" @click="remove(${obj.row.roleId})">删除</a>`;
                    return fc('div',[fc('a',{
                        on:{
                            click:()=>{
                                this.detail(obj.row.roleId)
                            }
                        }
                    },'查看'),fc('a',{
                        on:{
                            click:()=>{
                                this.edit(obj.row.roleId)
                            }
                        },
                        style:{
                            marginLeft: '10px'
                        }
                    },'修改'),fc('a',{
                        on:{
                            click:()=>{
                                this.remove(obj.row.roleId)
                            }
                        },
                        style:{
                            marginLeft: '10px'
                        }
                    },'删除')])
                }else{
                    return fc('div',[fc('a',{
                        on:{
                            click:()=>{
                                this.detail(obj.row.roleId)
                            }
                        }
                    },'查看'),fc('a',{
                        on:{
                            click:()=>{
                                this.edit(obj.row.roleId)
                            }
                        },
                        style:{
                            marginLeft: '10px'
                        }
                    },'修改')])
                }
            }
        }
    ]
}
export const datahistorytables = {
    columns:[
        {
            title: '数据名称',
            key: 'dataName',
            align: 'center',
            width:400
        },
        {
            title: '更新时间',
            key: 'upadateTimeView',
            align: 'center',
        },
        {
            title: '数据下载',
            key: 'download',
            align: 'center',
            width:100,
            render:(fc,obj)=>{
                return fc('a',{
                    attrs:{
                        'href': obj.row.dataDownload
                    },
                },'立即下载')
            }

        }
    ]
}
export const customquerytables = {
    columns:[
        {
            title: '查询名称',
            key: 'queryName',
            align: 'center',
            width: 200
        },
        {
            title: 'SQL语句详情',
            key: 'querySqlShow',
            align: 'center',
        },
        {
            title: '创建时间',
            key: 'createTimeView',
            align: 'center',
            width: 200
        },
        {
            title: '操作',
            key: 'action',
            align: 'center',
            width: 200,
            render:(fc,obj)=> {
                return fc('a',{
                    on:{
                        click:()=>{
                            this.copythis(obj.index)
                        }
                    }
                },`复制`)
            }

        }
    ]
}
export const loglisttables = {
    columns:[
        {
            title: 'ID',
            key: 'userId',
            width: 200
        },
        {
            title: '操作类型',
            key:"type",
            width: 100
        },
        {
            title: '来源',
            key: 'source',
            width: 100
        },
        {
            title: '用户姓名',
            key: 'userNameShow',
            width: 200,
        },
        {
            title: '操作详情',
            key: 'operateContentShow'
        },
        {
            title: '操作时间',
            key: 'operateTimeShow',
            width: 200
        },
        {
            title: '结果',
            key: 'result',
            width: 100
        }
    ]
}

export const BASEURL = '/demoms'  //路径
export const config = {
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
    },
}
export const download = {
    headers: {
        'Content-Type': 'application/json',
    },
}
export const dateOptions = {
    defaultDate:new Date(),
    options: {
        disabledDate (date) {
            return date && date.valueOf() > Date.now();
        }
    },
}
//地图数据
export const mapList = {
    data : [
        {
            title: '全网统建CDN、IDC、统建Cache、省建Cache、省建OTT业务流量分析日报',
            img: 'img-view-2',
            createTime: '2017-07-17 13：00',
            id: '2'
        },
        {
            title: '全网统建CDN、IDC、统建Cache、省建Cache、省建OTT业务流量分析周报',
            img: 'img-view-2',
            createTime: '2017-07-17 13：00',
            id: '5'
        },
        {
            title: '国际公司流量分析专题',
            img: 'img-view-1',
            createTime: '2017-06-30 13：00',
            id: '1'
        },
        /*{
            title: '全网流量迁移地图（图例）',
            img: 'img-view-3',
            createTime: '2017-06-20 13：00',
            id: '3'
        },*/
        {
            title: '全国流量示意图',
            img: 'img-view-3',
            createTime: '2017-06-20 13:00',
            id: '4'
        }
    ]
}
//图表详情数据
export const echartData = {
    //统建CDN业务分析数据
    data1:['安徽','北京','福建','甘肃','广东','广西','贵州','河南','河北','黑龙江','湖北','湖南','吉林','江苏','江西','辽宁','内蒙古','宁夏','青海','山东','山西','陕西','上海','四川','天津','西藏','新疆','云南','浙江','重庆']
}