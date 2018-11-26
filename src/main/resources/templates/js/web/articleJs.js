var articleObj = new Vue({
    el : "#blog",
    data:{
        articles:[],
    },
    mounted:function () {
        var url = "getArticles?page=0&size=10";
        this.$http.get(url,{}).then(response=>{
            this.parserData(response.data);
        },failRes =>{
            console.error("连接错误");
        });
    },methods:{
        parserData:function(data){
            this.articles = data._embedded.article;
            console.log(data);
        },
    }
});