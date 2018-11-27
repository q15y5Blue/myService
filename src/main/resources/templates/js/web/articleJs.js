var articleObj = new Vue({
    el : "#blog",
    data:{
        articles:[],
        items:[],
        pageNo : typeof(pageObj.nowPage)=='undefined'?0:pageObj.nowPage,
        url : "/article/getPages",
    },
    mounted:function () {
        this.url = this.url+'?pageNo='+this.pageNo;
        this.$http.get(this.url).then(response=>{
            this.parserData(response.data);
        },failRes =>{
            console.error("连接错误");
        });
    },methods:{
        parserData:function(data){
            pageObj.initDate(data,this.url);
            this.articles = data.content;
        }
    }
});