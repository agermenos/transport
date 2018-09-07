new Vue({
    el:'#app',
    data: {
        title:'Mutha-Foca',
        link:"http://google.com",
        finishedLink:'<a href="http://google.com">Google</a>'
    },
    methods:{
        changeTitle: function(event){
            this.title = event.target.value;
        },
        sayHello:function(){
            return "Hello, " + this.title + "!";
        }
    }
});