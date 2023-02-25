var email=localStorage.getItem('email');
if(email == null){
    location.href="http://localhost:8080/emp/login";
}

function getEmpDetails(){
    var status=document.getElementById("status");
    var table=document.getElementById("table");
    fetch('http://localhost:8080/employeedetails',{
        method: 'GET',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json'
        }
        }).then(response =>{
            if(response.status == 200){
              return response.json();
            }
            else
            {
                status.innerHTML=response.json().status;
            }
        }).then(data =>{
            console.log(data);
            var res=data;
            data.map(obj=>{
            console.log(obj);
            table.innerHTML+=`
            <tr>
                <td>${obj.id}</td>
                <td>${obj.name}</td>
                <td>${obj.email}</td>
                <td>${obj.salary}</td>
            </tr>
            `
            });
        }).catch((err)=>{
            status.innerHTML="Something failed, Please try again !";
            console.log(err);
        })
}
getEmpDetails();