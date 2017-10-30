/**
 * Created by syzx9801@163.com on 2017/4/17.
 */

import actions from './action'
import mutations from './mutations'
import getters from './getters'

export default {
    state: {
        user_name: "",
        user_permission: "",
        logStatus: false,
        user_role_navlist:{},
        pathtorefresh:''
    },
    actions: actions,
    mutations: mutations,
    getters: getters
}