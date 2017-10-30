import Vue from 'vue';
import Router from 'vue-router';
import store from '../store/store'
import * as path from './path'
Vue.use(Router);

export default new Router({
//    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: function(){
                return '/home'
            },
            meta: { browse: true }
        },
        {
            path: '/demo',
            meta: { browse: true },
            component: path.MAP,
            children:[
                {
                    path:'',
                    redirect: function(){
                        return 'map7'
                    },
                },
                {
                    path: 'map1',
                    meta: { browse: true },
                    component: path.DEMO_MAP_1,
                },
                {
                    path: 'map2',
                    meta: { browse: true },
                    component: path.DEMO_MAP_2,
                },
                {
                    path: 'map3',
                    meta: { browse: true },
                    component: path.DEMO_MAP_3,
                },
                {
                    path: 'map4',
                    meta: { browse: true },
                    component: path.DEMO_MAP_4,
                },
                {
                    path: 'map5',
                    meta: { browse: true },
                    component: path.DEMO_MAP_5,
                },
                {
                    path: 'map6',
                    meta: { browse: true },
                    component: path.DEMO_MAP_6,
                },
                {
                    path: 'map7',
                    meta: { browse: true },
                    component: path.DEMO_MAP_7,
                },
                {
                    path: 'map8',
                    meta: { browse: true },
                    component: path.DEMO_MAP_8,
                },
                {
                    path: 'map10',
                    meta: { browse: true },
                    component: path.DEMO_MAP_10,
                },
            ]
        },
        {
            path: '/map9',
            meta: { browse: true },
            component: path.DEMO_MAP_9,
        },
        {
            path: '/mapList',
            component: path.MAP_LIST,
            meta: {name: '数据视图'},
            meta: { browse: true }
        },
        {
            path:'/tinyMce',
            component:path.TINYMCE,
        },
        {
            path: '/mapList/map1',
            component: path.MAP_1,
            meta: {name: '视图详情'},
            meta: { browse: true }
        },
        {
            path: '/mapList/map2',
            component: path.MAP_2,
            meta: {name: '视图详情'},
            meta: { browse: true }
        },
        {
            path: '/mapList/map3',
            component: path.MAP_3,
            meta: {name: '视图详情'},
            meta: { browse: true }
        },
        {
            path: '/mapList/map4',
            component: path.MAP_4,
            meta: {name: '视图详情'},
            meta: { browse: true }
        },
        {
            path: '/mapList/map5',
            component: path.MAP_5,
            meta: {name: '视图详情'},
            meta: { browse: true }
        },
        {
            path: '/home',
            component: path.HOME,
            meta: { browse: true }
        },
        {
            path: '/login',
            component: path.LOGIN,
            meta: { browse: true }
        },
        {
            path:'/loginOverload',
            component:path.LOGINOVERLOAD,
            meta:{ browse:true }
        },
        {
            path: '/forgetPwd',
            component: path.FORGETPASSWORD,
            meta: { browse: true }
        },
        {
            path:'/resetPwd',
            component:path.RESETPASSWORD,
            meta:{ browse:true }
        },
        {
            path:'/resetPwdError',
            component:path.RESETPASSWORDERROR,
            meta:{ browse:true }
        },
        {
            path: '/user',
            meta: {name: '用户管理'},
            component: path.LAYOUT_SHOW,
            children: [
                {
                    path: '',
                    redirect: ()=>{
                        return 'usersShow'
                    }
                },
                {
                    path: 'usersShow',
                    component: path.USERS_SHOW,
                    meta: {name: '用户列表'}
                },
                {
                    path: 'rolesShow',
                    component: path.ROLES_SHOW,
                    meta: {name: '权限列表'}
                },
                {
                    path: 'usersAdd',
                    component: path.USERS_ADD,
                    meta: {name: '用户新增'}
                },
                {
                    path: 'usersEdit',
                    component: path.USERS_EDIT,
                    meta: {name: '用户编辑'}
                },
                {
                    path: 'usersDetail',
                    component: path.USERS_DETAIL,
                    meta: {name: '用户详情'}
                },
                {
                    path: 'rolesAdd',
                    component: path.ROLES_ADD,
                    meta: {name: '权限新增'}
                },
                {
                    path: 'rolesEdit',
                    component: path.ROLES_EDIT,
                    meta: {name: '权限编辑'}
                },
                {
                    path: 'rolesDetail',
                    component: path.ROLES_DETAIL,
                    meta: {name: '权限详情'}
                }
            ]
        },
        {
            path: '/export',
            component: path.LAYOUT_SHOW,
            meta: {name: '业务数据管理'},
            children: [
                {
                    path: '',
                    redirect: ()=>{
                        return 'adminHistoryData'
                    }
                },
                {
                    path: 'adminHistoryData',
                    component: path.ADMIN_HISTORY_DATA,
                    meta: {name: '历史数据'}
                },
                {
                    path: 'customQueryList',
                    component: path.CUSTOM_QUERY_LIST,
                    meta: {name: '自定义查询'}
                },
                {
                    path:'dataPublish',
                    component:path.DATA_PUBLISH,
                    meta:{name:'数据发布'},
                },
                {
                    path:'add',
                    component:path.DATA_ADD,
                    meta:{name:'新建报表'}
                },
                {
                    path:'edit',
                    component:path.DATA_EDIT,
                    meta:{name:'数据修改'}
                },
                {
                    path:'detail',
                    component:path.DATA_DETAIL,
                    meta:{name:'数据查看'}
                },
                {
                    path:'delete',
                    component:path.DATA_DELETE,
                    meta:{name:'数据删除'}
                }
            ]
        },
        {
            path:'/operateLog',
            component: path.LAYOUT_SHOW,
            meta: {name: '系统管理'},
            children: [
                {
                    path: '',
                    redirect: ()=>{
                    return 'showLogList'
                }
                },
                {
                    path: 'showLogList',
                    component: path.SHOW_LOG_LIST,
                    meta: {name: '日志管理'}
                }
            ]
        },
        {
            path: '/dataview',
            component: path.LAYOUT_SHOW,
            meta: {name: '数据总览'},
            children: [
                {
                    path: '',
                    redirect: ()=>{
                        return 'showDataSum'
                    }
                },
                {
                    path: 'showDataSum',
                    component: path.SHOW_DATA_SUM,
                    meta: {name: ''}
                },
                {
                    path: 'download',
                    component: path.DOWNLOAD
                }
            ]
        },
        {
            path: '/device',
            component: path.LAYOUT_SHOW,
            meta: {name: '设备管理'},
            children: [
                {
                    path: '',
                    redirect: ()=>{
                        return 'deviceList'
                    }
                },
                {
                    path: 'deviceList',
                    component: path.DEVICE_LIST,
                    meta: {name: '设备列表'},

                },
                {
                    path: 'deviceImport',
                    component: path.DEVICE_IMPORT,
                    meta: {name: '设备导入'}
                },
                {
                    path: 'deviceConcat',
                    component: path.DEVICE_CONCAT
                },
            ]
        },
        {
            path: '/datamanage',
            component: path.LAYOUT_SHOW,
            meta: {name: '数据管理'},
            children: [
                {
                    path: '',
                    redirect: ()=>{
                        return 'provinceRate'
                    }
                },
                {
                    path: 'provinceRate',
                    component: path.PROVINCERATE,
                    meta: {name: '本省率分析'}
                }
            ]
        },
        {
            path: '/deviceEdit',
            meta: {name: '设备信息编辑'},
            component: path.DEVICE_EDIT,
            beforeEnter: (to, from, next) => {
                if(!store.state.page.device_list.length){
                    next({
                        path: '/device',
                    });
                }else{
                    next();
                }
            }
        },
        {
            path: '/port',
            component: path.LAYOUT_SHOW,
            meta: {name: '端口管理'},
            children: [
                {
                    path: '',
                    redirect: ()=>{
                        return 'portList'
                    }
                },
                {
                    path: 'portList',
                    component: path.PORT_LIST,
                    meta: {name: '端口列表'}
                },
                {
                    path: 'portImport',
                    component: path.PORT_IMPORT,
                    meta: {name: '端口导入'}
                },

                {
                    path: 'portConcat',
                    component: path.PORT_CONCAT
                }
            ]
        },
        {
            path: '/portEdit',
            component: path.PORT_EDIT,
            meta: {name: '端口'},
            beforeEnter: (to, from, next) => {
                if(!store.state.page.port_list.length){
                    next({
                        path: '/port',
                    });
                }else{
                    next();
                }
            }
        },
        {
            path: '/sessionTimeout',
            meta: {name: '登陆超时'},
            component: path.SESSION_TIMEOUT
        },
        {
            path: '*',
            component: path.NOTFOUND
        }
    ]
})
