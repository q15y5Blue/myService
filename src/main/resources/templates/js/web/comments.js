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
// sudo wget http://kernel.ubuntu.com/~kernel-ppa/mainline/v4.10.6/linux-headers-4.10.6-041006-generic_4.10.6-041006.201703260832_i386.deb
// var replyChild = new Vue({
//     el : '#ReplyChild',
//     data :{
//         children : '',
//         url: "/article/reply/getReplyChild",
//     },
//     mounted:function () {
//         Vue.set(pageObj,'nowPage',0);
//         this.getData();
//     },methods:{
//         parserData:function(data){
//             this.children = data.content;
//             pageObj.updateBase(data);
//         },
//         updateUrl:function(pageNo){
//             if(pageNo<0||pageNo>pageObj.totalPages-1)
//                 return
//             Vue.set(pageObj,'nowPage',pageNo);
//             this.getDate();
//         },
//         getData:function (data) {
//             axios.get(this.url, {
//                 params: {
//                     pageNo: pageObj.nowPage,
//                     replyId:replyId
//                 }
//             }).then(res=>{
//                 this.parserData(res.data);
//             }).catch(error=>{
//                 console.error(error);
//             });
//         }
//     }
// });