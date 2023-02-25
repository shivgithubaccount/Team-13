package com.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {
    @GetMapping("")
    public String viewHomePage() {
        return "HomePage";
    }
    @GetMapping("/hr/login")
    public String viewHrLoginPage() {
        return "/hr/HRPage";
    }
    @GetMapping("/emp/login")
    public String viewEmpLoginPage() {
        return "/emp/EmpPage";
    }

    @GetMapping("/hr/addemp")
    public String addEmpPage() {
        return "/hr/AddEmp";
    }

    @GetMapping("/hr/removeemp")
    public String removeEmpPage() {
        return "/hr/RemoveEmp";
    }

    @GetMapping("/hr/empdetails")
    public String empDetail() {
        return "/hr/GetEmpDetails";
    }

    @GetMapping("/emp/profile")
    public String empProfile() {
        return "/emp/empProfile";
    }

    @GetMapping("/emp/allocation")
    public String empAllocation() {
        return "/emp/empAllocation";
    }
}