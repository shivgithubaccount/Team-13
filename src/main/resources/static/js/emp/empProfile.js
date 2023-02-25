var email=localStorage.getItem('email');
if(email == null){
    location.href="http://localhost:8080/emp/login";
}
else
{
    var status=document.getElementById('status');
    fetch('http://localhost:8080/emp/getprofile',{
        method: 'POST',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email : email
        })
        }).then(response =>{
            if(response.status !=200){
                data.status="Failed to fetch data, Please try again !";
            }
            return response.json();
        }).then(data =>{
            var profile=document.getElementById('profile');
            profile.innerHTML=`
            <b>Id</b>:&nbsp; ${data.id} <br/>
            <b>Name</b>:&nbsp; ${data.name} <br/>
            <b>Email</b>:&nbsp; ${data.email} <br/>
            <b>Salary</b>:&nbsp; ${data.salary}
            `;
        }).catch((err)=>{
            data.status="Failed to fetch data, Please try again !";
        })
}