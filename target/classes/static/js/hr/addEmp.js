var email=localStorage.getItem('email');
if(email == null){
    location.href="http://localhost:8080/hr/login";
}

var form=document.getElementById('form');
var email=document.getElementById('email');
var password=document.getElementById('password');
var role=document.getElementById('role');
var salary=document.getElementById('salary');

email.addEventListener('change',()=>{
    var status=document.getElementById('status');
    status.innerHTML="";
})
password.addEventListener('change',()=>{
    var status=document.getElementById('status');
    status.innerHTML="";
})
role.addEventListener('change',()=>{
    var status=document.getElementById('status');
    status.innerHTML="";
})

form.addEventListener('submit',(event)=>{
    event.preventDefault();
    var name=document.getElementById('name');

    var status=document.getElementById('status');
    var emailVal=email.value;
    var passwordVal=password.value;
    var roleVal=role.value;
    var salaryVal=salary.value;
    var nameVal=name.value;
    console.log(nameVal,salaryVal);

    fetch('http://localhost:8080/addEmp',{
    method: 'POST',
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        email : emailVal,
        password: passwordVal,
        role: roleVal,
        salary:salaryVal,
        name:nameVal
    })
    }).then(response =>{
        if(response.status == 200){
            email.value="";
            password.value="";
            role.value="";
            salary.value="";
            name.value="";
        }
        return response.json();
    }).then(data =>{
        status.innerHTML=data.status;
        console.log(data);
    }).catch((err)=>{
        console.log(err);
    })
})

