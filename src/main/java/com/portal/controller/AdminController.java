package com.portal.controller;

import com.portal.modal.User;
import com.portal.repo.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    UserRepository userRepo;


    @PostMapping("/addEmp")
    public ResponseEntity<Object> addUser(@RequestBody User userObj)
    {
        JSONObject jsonObject=new JSONObject();
        System.out.println("Addedd USER");
        if(userObj.getRole() > 1)
        {
            jsonObject.put("status","Enter valid role !");
            return  new ResponseEntity<Object>(jsonObject.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try{
            jsonObject.put("status","User Added !");
            userRepo.save(userObj);
            return new ResponseEntity<Object>(jsonObject.toString(),HttpStatus.OK);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            jsonObject.put("status","User adding failed, Please try again");
            return  new ResponseEntity<Object>(jsonObject.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/admin/login")
    public ResponseEntity<Object> login(@RequestBody User obj)
    {
        JSONObject jsonObject=new JSONObject();
        System.out.println("obj"+obj);
        User u=userRepo.getUserByMail(obj.getEmail());
        System.out.println("user"+u);
        if(u == null)
        {
            jsonObject.put("status","User Not Registered");
            return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }
        else if(!u.getRole().equals(1))
        {
            jsonObject.put("status","You don't have admin access");
            return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }
        else if(obj.getPassword().equals(u.getPassword()))
        {
            jsonObject.put("status","Successfully validated");
            return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.OK);
        }
        else {
            jsonObject.put("status","Wrong details !");
            return new ResponseEntity<Object>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/admin/removeEmployees")
    public ResponseEntity<Object> removeAllEmployee()
    {
        JSONObject jsonObject=new JSONObject();
        try{
            jsonObject.put("status","Successfully removed all employees");
            userRepo.deleteAllEmployees();
            return new ResponseEntity<Object>(jsonObject.toString(),HttpStatus.OK);
        }
        catch (Exception e){
            jsonObject.put("status","Unable to process the request, Please try again !");
            System.out.println(e.getMessage());
            return new ResponseEntity<Object>(jsonObject.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeedetails")
    public ResponseEntity<Object> getEmployeeDetails(){
        try{
            List<User> obj=new ArrayList<>();
            obj=userRepo.getEmployeeDetails();
            System.out.println(obj);
            return new ResponseEntity<Object>(obj,HttpStatus.OK);
        }
        catch(Exception e){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("status","Unable to retrieve Details, Please try again !");
            return new ResponseEntity<Object>(jsonObject,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}