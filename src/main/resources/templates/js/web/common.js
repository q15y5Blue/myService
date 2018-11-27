var pageObj = new Vue({
    el : "#pageObj",
    data:{
        firstPage :1,
        lastPage : 1000,
        nowPage : 0,
        totalPages : 0,
        pageSize : 0,
        showMaxPage:3,//长度
        showList :'',
        left:this.nowPage-1>=0?this.nowPage:0,
        right:this.left+this.showMaxPage,
        url :''
    },methods:{
        initDate:function(data,url){
            console.log(url);
            this.nowPage = data.number;
            this.leftIndex = this.nowPage>1?this.nowPage-1:this.nowPage;
            this.totalPages = data.totalPages;
            this.showMaxPage = data.totalPages<=this.showMaxPage?data.totalPages:this.showMaxPage;
            var list=new Array();
            //第二个问题
            console.log(this.left);
            for(var i=0,j=this.left;i<this.showMaxPage;j++,i++){
                list[i]=j;
            }
            console.log(list);
            },
        //第一个问题，url的传递
        getArticlePage:function(pageNo){
            this.nowPage = pageNo;
            this.url =this.url+'?pageNo='+this.nowPage;
            console.log("this log"+this.url);
            this.$http.get(this.url).then(response=>{
                articleObj.parserData(response.data);
            },failRes =>{
                console.error("连接错误");
            });
        }
    }
});
