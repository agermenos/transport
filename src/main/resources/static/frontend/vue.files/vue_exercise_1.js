new Vue({
  el:'#exercise',
  data: {
    name:'Alejandro',
    age:43,
    imageLink:'https://www.sony.com/image/1919e31ab59d309efa6ec81ae5d44c83?fmt=png-alpha&wid=580'
  },
  computed:{
    ageTimes: function(){
      return this.age*3;
    }
}
});