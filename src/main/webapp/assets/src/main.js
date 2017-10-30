import Vue from 'vue'
import App from './App'
import router from './router/config_router'
import iView from 'iview'
import 'iview/dist/styles/iview.css'
import store from './store/store'
import axios from 'axios'

Vue.use(iView);

Vue.prototype.$http = axios;
Vue.config.productionTip = false;

router.beforeEach((to,from,next) => {
    let loginStatus = JSON.parse(window.localStorage.getItem('user')) || null;
    let real_path = to.path.split('/')[1];
    store.dispatch('pathToRefresh',real_path);
    if(!to.meta.browse){
        if(loginStatus){
            next();
        }else{
            if(real_path=='demo'){
                next();
            }
            if(real_path=='resetPwd'){
                next();
            }
            if(real_path=='proAnalysis'){
                next();
            }
            if(real_path=="sessionTimeout"){
                next();
            }else{
                next({
                    path: '/login',
                })
            }
        }
    }else{
        next();
    }
})

// http response 拦截器
axios.interceptors.response.use(
    res => {
        var code = res.data;
        var msg = res.data.msg;
        if (code&&code.code == 2017) {
            router.replace({
                path: '/sessionTimeout',
                query: {message: msg}
            })
        }
        return res;
    },
    error => {
        // return Promise.reject(error.response.data);
    });

new Vue({
    el: '#app',
    router,
    store,
    template: '<App/>',
    components: { App },
})







