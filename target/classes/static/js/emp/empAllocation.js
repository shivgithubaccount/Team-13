var email=localStorage.getItem('email');
if(email == null){
    location.href="http://localhost:8080/emp/login";
}

var allocationDetails=document.getElementById('allocation');
allocationDetails.innerHTML=`
    <b> Project Name</b>: &nbsp; Employee Management Portal <br/>
    <b> Technologies used</b>: &nbsp; Spring Boot, Spring Web <br/>
    <b> Database used</b>: MySQL
`;