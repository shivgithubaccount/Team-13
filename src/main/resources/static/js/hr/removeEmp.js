var email=localStorage.getItem('email');
if(email == null){
    location.href="http://localhost:8080/emp/login";
}

var removeEmp=document.getElementById("removeEmp");
console.log("got it");
removeEmp.addEventListener('click',()=>{
    console.log("git it");
    var status=document.getElementById("status");
        fetch('http://localhost:8080/admin/removeEmployees',{
        method: 'DELETE',
        }).then(response =>{
            console.log(response);
            return response.json();
        }).then(data =>{
            console.log(data);
            status.innerHTML=data.status;
            removeEmp.remove();
        }).catch((err)=>{
            console.log(err);
        })
})
