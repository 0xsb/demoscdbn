/**
 * Created by syzx9801@163.com on 2017/4/17.
 */

import actions from './action'
import mutations from './mutations'
import getters from './getters'

export default {
    state: {
        users_id: "",
        roles_id: "",
        device_list: [],
        port_list: [],
    },
    actions: actions,
    mutations: mutations,
    getters: getters
}