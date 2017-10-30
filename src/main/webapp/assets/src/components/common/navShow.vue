<template>
    <div class="cm-accordion-menu">
        <ul class="accordion clearfix">
            <li class="level-1" v-for="(item,index) in navList" :class="{open:state==index}" @click="state=index">
                <div class="link" :id="'m'+item.id"><i></i>{{item.name}}<Icon type="plus"></Icon></div>
                <ul class="submenu clearfix" v-show="state==index">
                    <li class="level-2" v-for="i in item.children">
                        <router-link :to="item.resouce + i.resouce">{{i.name}}</router-link>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</template>
<style lang="less">
.cm-accordion-menu{
    background: #FFF;
    width: 200px;
    margin-bottom:-3000px;
    padding-bottom:3000px;
    position: fixed;
    font-size: 14px;
    color: #7a8599;
    font-weight: normal;
    left: 0;
    top:67px;
    border-right:1px solid #d2d9e7;
    box-shadow: none;
    overflow-y: auto
}
.accordion{
    margin-top: 10px;
    border-top:1px solid #e7eeff;
}
.level-1{
    color: #7a8599;
    font-size: 14px;
    border-bottom: 1px solid #e7eeff;
    &.open{
        background:#f0f5fd;
        color: #4276fe;
        .submenu{
            border-top:1px solid #e7eeff;
        }
    }
    .submenu{
        background: #FFF;
        padding: 10px 0;
    }
}
.level-2{
    height: 30px;
    line-height: 30px;
    text-align: center;
    a{
        color: #7a8599;
        font-size: 12px;
        &.router-link-active{
            color: #3694f2;
         }
    }
}
.accordion .link {
    position: relative;
    display: block;
    height: 50px;
    text-align: center;
    cursor: pointer;
    font-size: 14px;
    line-height: 50px;
    background: no-repeat 30px center;
    -webkit-transition: all .4s ease;
    -o-transition: all .4s ease;
    transition: all .4s ease
}

.accordion .link,.accordion .link i {
    color: #7a8599;
    font-size: 14px;
    -webkit-transition: all .4s ease;
    transition: all .4s ease
}
.accordion li.open i {
    color: #3694f2;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    -o-transform: rotate(45deg);
    transform: rotate(45deg)
}
.accordion li .link:hover,.accordion li.open .link{
    color: #3694f2;
    background-color: #f0f5fd;
}

.accordion .link i {
    position: absolute;
    top: 18px;
    right: 10px
}
#m1 {
    background-image: url(../../assets/imgs/icon-user.png)
}

.accordion li #m1:hover,.accordion li.open #m1 {
    background-image: url(../../assets/imgs/icon-user-p.png)
}
#m4 {
    background-image: url(../../assets/imgs/icon-date.png)
}

.accordion li #m4:hover,.accordion li.open #m4 {
    background-image: url(../../assets/imgs/icon-date-p.png)
}
#m8 {
    background-image: url(../../assets/imgs/icon-system.png)
}

.accordion li #m8:hover,.accordion li.open #m8 {
    background-image: url(../../assets/imgs/icon-system-p.png)
}
#m9{
    background-image: url(../../assets/imgs/icon-data2.png);
}
.accordion li #m9:hover, .accordion li.open #m9{
    background-image: url(../../assets/imgs/icon-data2-p.png);
}
#m12{
    background-image: url(../../assets/imgs/icon-device.png);
}
.accordion li #m12:hover, .accordion li.open #m12{
    background-image: url(../../assets/imgs/icon-device-p.png);
}
#m15{
    background-image: url(../../assets/imgs/icon-port.png);
}
.accordion li #m15:hover, .accordion li.open #m15{
    background-image: url(../../assets/imgs/icon-port-p.png);
}
</style>
<script type="text/ecmascript-6">
export default{
    data(){
        return {
            navList:[],
            state: 0,
        }
    },
    mounted(){
        this.$http.get('/main').then((res)=>{
            this.navList = res.data.children;
            for(let i =0;i<this.navList.length;i++){
                let res = this.navList[i].resouce.substring(1,this.navList[i].resouce.length)
                if(res==this.$store.getters.getpathtorefresh){
                    this.state = i;
                }
            }
        }).catch(res=>{
            this.navList =  [
                {
                    "checked": false,
                    "children": [
                        {
                            "checked": false,
                            "children": [],
                            "depth": "",
                            "id": 2,
                            "name": "用户列表",
                            "parent": false,
                            "parentId": "1",
                            "resouce": "/usersShow"
                        },
                        {
                            "checked": false,
                            "children": [],
                            "depth": "",
                            "id": 3,
                            "name": "权限列表",
                            "parent": false,
                            "parentId": "1",
                            "resouce": "/rolesShow"
                        }
                    ],
                    "depth": "",
                    "id": 1,
                    "name": "用户管理",
                    "parent": true,
                    "parentId": "0",
                    "resouce": "/user"
                },
                {
                    "checked": false,
                    "children": [
                        {
                            "checked": false,
                            "children": [],
                            "depth": "",
                            "id": 5,
                            "name": "历史数据",
                            "parent": false,
                            "parentId": "4",
                            "resouce": "/adminHistoryData"
                        },
                        {
                            "checked": false,
                            "children": [],
                            "depth": "",
                            "id": 6,
                            "name": "自定义查询",
                            "parent": false,
                            "parentId": "4",
                            "resouce": "/customQueryList"
                        },
                        {
                            "checked": false,
                            "children": [],
                            "depth": "",
                            "id": 10,
                            "name": "数据发布",
                            "parent": false,
                            "parentId": "4",
                            "resouce": "/dataPublish"
                        }
                    ],
                    "depth": "",
                    "id": 4,
                    "name": "业务数据管理",
                    "parent": true,
                    "parentId": "0",
                    "resouce": "/export"
                },
                {
                    "checked": false,
                    "children": [
                        {
                            "checked": false,
                            "children": [],
                            "depth": "",
                            "id": 8,
                            "name": "日志管理",
                            "parent": false,
                            "parentId": "7",
                            "resouce": "/showLogList"
                        }
                    ],
                    "depth": "",
                    "id": 7,
                    "name": "系统管理",
                    "parent": true,
                    "parentId": "0",
                    "resouce": "/operateLog"
                },
                {
                    "checked": false,
                    "children": [
                        {
                            "checked": false,
                            "children": [],
                            "depth": "",
                            "id": 9,
                            "name": "设备列表",
                            "parent": false,
                            "parentId": "7",
                            "resouce": "/deviceList"
                        }
                    ],
                    "depth": "",
                    "id": 8,
                    "name": "设备管理",
                    "parent": true,
                    "parentId": "0",
                    "resouce": "/device"
                }
            ];
            for(let i =0;i<this.navList.length;i++){
                let res = this.navList[i].resouce.substring(1,this.navList[i].resouce.length)
                if(res==this.$store.getters.getpathtorefresh){
                   this.state = i;
                }
            }
        });

    }
}
</script>
