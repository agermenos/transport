new Vue({
    el: '#exercise',
    data: {
        value: ''
    },
    methods: {
        alertMe:function(){
            alert("alert!");
        },
        storeValue:function(event){
            this.value=event.target.value;
        }
    }
});