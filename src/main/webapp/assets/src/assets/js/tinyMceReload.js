/**
 * Created by adminpc on 2017/8/2.
 */
//tinyMce刷新问题
export let tinyReolad = ()=>{
    if(!window.sessionStorage.getItem('tinyMceFlag')){
        window.sessionStorage.setItem('tinyMceFlag','tinyMceFlag');
        window.location.reload();
    }else{
        window.sessionStorage.removeItem('tinyMceFlag');
    }
}