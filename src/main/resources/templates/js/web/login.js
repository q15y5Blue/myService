//request 之前
var loginObj = new Vue({
    el: "#login_box",
    data: {
        username:'',
        password:'',
        url:"/login/getUser"
    }, mounted: function () {

    },
    methods: {
        parserDate:function(data) {

        },

        checkUser:function(){
            axios.get(this.url,{
                params:{
                    username:this.username,
                    password:this.password
                }
            }).then(res=>{
                console.log("登录成功了");
            }).catch(error=>{
                console.error(error);
            });
        }
    }
});