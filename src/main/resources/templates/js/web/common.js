//分页 Common
var pageObj = new Vue({
    el : "#pageObj",
    data:{
        firstPage :1,
        lastPage : 1000,
        nowPage : 0,
        totalPages : 0,
        showMaxPage:3,//长度
        left:0,
        right:0,
        url :'',
        showList :[]
    },methods:{
        updateShowList:function(leftData){
            Vue.set(this,'left',leftData>0?leftData:0);
            Vue.set(this,'right',this.totalPages<this.left+this.showMaxPage?this.totalPages:this.left+this.showMaxPage);
            var list = new Array();
            for (var i=this.left,j=0;i <this.right;i++,j++){
                list[j]= i+1 ;
            }
            Vue.set(this,'showList',list);
        },updateBase:function(data){
            Vue.set(pageObj,'url',this.url);
            Vue.set(pageObj,'nowPage',data.number);
            Vue.set(pageObj,'showMaxPage',4);
            Vue.set(pageObj,'totalPages',data.totalPages);
            var lefPage = pageObj.nowPage-1>0?pageObj.nowPage-1:0;//当前页保持非第一项
            lefPage = this.totalPages-pageObj.nowPage<this.showMaxPage?this.totalPages-this.showMaxPage:lefPage;
            pageObj.updateShowList(lefPage);
        }
    }
});
