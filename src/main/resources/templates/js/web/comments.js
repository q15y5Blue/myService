var articleId =document.getElementById("articleId").textContent;
var commentsJs = new Vue({
    el : "#Comments",
    data:{
        replies:'',
        url : "/article/reply/getReplys",
    },
    mounted:function () {
        Vue.set(pageObj,'nowPage',0);
        this.getDate();
    },methods:{
        parserData:function(data){
            this.replies = data.content;
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
                    articleId:articleId
                }
            }).then(res=>{
                this.parserData(res.data);
            }).catch(error=>{
                console.error(error);
            });
        }
    }
});
