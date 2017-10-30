/**
 * Created by syzx9801@163.com on 2017/4/18.
 */
export default{
    getusername :function(state){
        let username = state.user_name || JSON.parse(localStorage.getItem('user')).user_name;
        return username;
    },
    getLogStatus: function(state){
        let status = state.logStatus || JSON.parse(localStorage.getItem('user')).logStatus;
        return status;
    },
    getuserRoleId: function(state){
        let userRoleId = state.user_permission || JSON.parse(localStorage.getItem('user')).user_permission;
        return userRoleId;
    },
    getuserrolenavlist: function(state){
        let _temp = state.user_role_navlist || JSON.parse(localStorage.getItem('userrolenavlist'))
        return _temp;
    },
    getpathtorefresh:function(state){
        let path = state.pathtorefresh || JSON.parse(localStorage.getItem('pathtorefresh'));
        return path;
    }
}