var faqObj = new Vue({
    el: "#faqObj",
    data: {
        newContent:'',
        question: {time:'',content:'',type:''},
        questionsList: []
    }, mounted: function () {

    },
    methods: {
        parseResponse:function(data) {
            var content = "查询结果如下";
            if(data.size!=0){
                data.forEach(item=>{
                    console.log(item);
                    content += item[1] ;
                });
                this.question.type = "ans";
                this.question.content = content;
                this.questionsList.push(this.question);

            }
        },
        addNewQuestion:function(){
            if(this.newContent=="")
                return;
            this.question.time = new Date();
            this.question.type = "quest";
            this.question.content = this.newContent;
            this.questionsList.push(this.question);
            this.getAnswer();
            this.newContent = '';
        },
        getAnswer:function(){
            var form = $('#main-contact-form');
            var form_status = $('<div class="form_status"></div>');
            //request 之前
            axios.interceptors.request.use(function (config) {
                form.prepend(form_status.html('<p><i class="fa fa-spinner fa-spin"></i>正在查询...</p>').fadeIn());
                return config;
            }, function (error) {
                return Promise.reject(error);
            });

            axios.get("/faq/getAnswers",{
                params:{
                    quest:this.newContent
                }
            }).then(res=>{
                form_status.html('<p class="text-success">查询成功</p>').delay(2000).fadeOut();
                this.parseResponse(res.data);
            }).catch(error=>{
                console.error(error);
            });


        }
    }
});