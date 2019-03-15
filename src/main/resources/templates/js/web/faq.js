
//request 之前
var faqObj = new Vue({
    el: "#faqObj",
    data: {
        newContent:'',
        questionsList: []
    }, mounted: function () {
           },
    methods: {
        parseResponse:function(data) {
            console.log(data);
            var content = "查询结果如下";
            if(data.size!=0){
                data.forEach(item=>{
                    console.log(item);
                    content = item.content ;
                    question = {};
                    question.type = "ans";
                    question.content = content;
                    this.questionsList.push(question);
                });
            }
        },
        addNewQuestion:function(){
            if (this.newContent == '')
                return;
            question = {};
            question.time = new Date();
            question.type = "quest";
            question.content = this.newContent;
            this.questionsList.push(question);
            this.getAnswer();
            this.newContent = '';
        },
        getAnswer:function(){
            var selecting = $('#selecting');
            axios.interceptors.request.use(function (config) {
                selecting.show().fadeIn();
                $('#inputArea').attr('disabled','');
                return config;
            }, function (error) {
                return Promise.reject(error);
            });

            axios.get("/faq/getAnswers",{
                params:{
                    quest:this.newContent
                }
            }).then(res=>{
                selecting.hide();
                $('#inputArea').removeAttr('disabled');
                $('#selected').show().delay(2000).fadeOut();
                this.parseResponse(res.data);
            }).catch(error=>{
                console.error(error);
            });


        }
    }
});