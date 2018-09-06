new Vue({
    el:'#app',
    data: {
        title:'Mutha-Foca'
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