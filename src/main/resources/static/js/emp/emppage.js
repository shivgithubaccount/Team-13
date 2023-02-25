if(localStorage.getItem('email')!=null){
    localStorage.removeItem('email');
}

var form=document.getElementById('form');
form.addEventListener('submit',(event)=>{
    event.preventDefault();
    console.log("Got it");
    var email=document.getElementById("email").value;
    var password=document.getElementById("password").value;
    var status=document.getElementById("status");

    document.getElementById("email").value="";
    document.getElementById("password").value="";
    fetch('http://localhost:8080/emp/login',{
    method: 'POST',
    headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        email : email,
        password: password
    })
    }).then(response =>{
        console.log(response.status);
        if(response.status == 200){
        location.href="http://localhost:8080/emp/profile";
        localStorage.setItem("email",email);
        }
        else
        {
            return response.json();
        }
    }).then(data =>{
        status.innerHTML=data.status;
        console.log(data);
    }).catch((err)=>{
        console.log(err);
    })
})