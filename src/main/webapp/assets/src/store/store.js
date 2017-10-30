/**
 * Created by syzx9801@163.com on 2017/3/29.
 */
import 'babel-polyfill'
import Vue from 'vue'
import Vuex from 'vuex'

import login from './login/index'
import page from './page/index'

Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        login,
        page
    }
})