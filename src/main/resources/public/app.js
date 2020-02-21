document.addEventListener("DOMContentLoaded", function(){

    const Users = new Vue({
         el: ".app",
        data: {
            users: [],
            fullname: "",
            codewarsusername: ""
        },

        mounted() {
                const me = this;
                axios
                    .get("api/v1/users/")
                    .then(function(results){

                        let data = results.data;
                        data.map(current => me.users.push(current));
                    })

                    .catch((error)=>{
                    console.log(error)})
        }

//        mounted(user) {
//                let vm = this;
//                axios
//                    .get(`api/v1/users/username/${user}`)
//                    .then((results) =>{
//                        let data = results;
//                        console.log(data)
//                    })
//
//        }
    })

})