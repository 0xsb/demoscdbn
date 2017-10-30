<template>
    <div>
        <div class="module-header">
            <h4>修改报表</h4>
        </div>
        <Form ref="formCustom" :model="formCustom"  :label-width="87">
            <Form-item label="分类 :" prop="classify">
                <p style="background: #2d8cf0;color: white;border-radius: 5px;width: 60px;text-align: center;">全国数据</p>
            </Form-item>
            <Form-item label="标题 :" prop="title">
                <Input type="text" v-model="formCustom.title" style="width: 700px"></Input>
            </Form-item>
            <Form-item label="作者 :" prop="author">
                <Input type="text" v-model="formCustom.author" style="width: 320px"></Input>
            </Form-item>
            <Form-item label="摘要 :" prop="summary">
                <Input type="textarea" v-model="formCustom.summary" style="width: 700px" :autosize="{minRows: 2,maxRows: 2}" placeholder="不超过100字"></Input>
            </Form-item>
            <Form-item label="正文 :" prop="content">
                <div style="width:700px;">
                    <tiny-mce></tiny-mce>
                    <p style="color: #c5c5c5;">请编辑正文内容，标题、作者、分类、摘要、题图等信息，富文本编辑器的具体展示可能因浏览器效果而不同</p>
                </div>
            </Form-item>
            <Form-item>
                <Button type="primary" @click="handleSubmit('formCustom')" >确定修改</Button>
                <Button type="ghost" @click="$router.push('/export/dataPublish')" style="margin-left: 10px ">取消</Button>
                <span style="margin-left:10px;color: #2d8cf0;">保存为草稿</span>
            </Form-item>
        </Form>
    </div>
</template>
<style lang="less">
</style>
<script type="text/ecmascript-6">
    /*import tinyMce from '../common/tinymce.vue'
    import {tinyReolad} from '../../assets/js/tinyMceReload'*/

    export default{
        data () {
            return {
                formCustom: {
                    classify: '',
                    title: '',
                    author: '',
                    summary:'',
                    content:''
                },
            }
        },
        methods: {
            handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$Message.success('提交成功!');
                    } else {
                        this.$Message.error('表单验证失败!');
                    }
                })
            },
        },
        components:{
//            tinyMce
        },
        mounted(){
//            tinyReolad()
        }
    }
</script>
