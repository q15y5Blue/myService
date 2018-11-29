var articleObj = new Vue({
    el : "#blog",
    data:{
        articles:'',
        items:[],
        url : "/article/getPages",
    },
    mounted:function () {
        Vue.set(pageObj,'nowPage',0);
        this.getDate();
    },methods:{
        parserData:function(data){
            this.articles = data.content;
            pageObj.updateBase(data);
        },
        updateUrl:function(pageNo){
            if(pageNo<0||pageNo>pageObj.totalPages-1)
                return
            Vue.set(pageObj,'nowPage',pageNo);
            this.getDate();
        },
        getDate:function () {
            axios.get(this.url, {
                params: {
                    pageNo: pageObj.nowPage,
                }
            }).then(res=>{
                this.parserData(res.data);
            }).catch(error=>{
                console.error(error);
            });
        }
    }
});