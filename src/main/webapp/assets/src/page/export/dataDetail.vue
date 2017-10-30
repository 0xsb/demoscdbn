<template>
    <div>
        <div class="module-header">
            <h4>查看报表</h4>
        </div>
        <Form ref="formCustom" :model="formCustom"  :label-width="87">
            <Form-item label="链接 :" >
                <a href="#" style="font-size:16px;">http:www.chuangxin.com   <span style="font-size:16px;">复制</span></a>
            </Form-item>
            <Form-item label="分类 :" prop="classify">
                <p style="background: #2d8cf0;color: white;border-radius: 5px;width: 60px;text-align: center;">全国数据</p>
            </Form-item>
            <Form-item label="标题 :" prop="title">
                <span>{{formCustom.title}}</span>
            </Form-item>
            <Form-item label="作者 :" prop="author">
                <span>{{formCustom.author}}</span>
            </Form-item>
            <Form-item label="摘要 :" prop="summary">
                <span>{{formCustom.summary}}</span>
            </Form-item>
            <Form-item label="正文 :" prop="content">

            </Form-item>
            <Form-item>
                <Button type="primary" @click="handleSubmit('formCustom')" >修改</Button>
                <Button type="ghost" style="margin-left: 10px " @click="$router.push('/export/dataPublish')">返回</Button>
            </Form-item>
        </Form>
    </div>
</template>
<style lang="less">

</style>
<script type="text/ecmascript-6">
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
            handleSubmit(name){
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$Message.success('提交成功!');
                    } else {
                        this.$Message.error('表单验证失败!');
                    }
                })
            }
        },

    }
</script>
