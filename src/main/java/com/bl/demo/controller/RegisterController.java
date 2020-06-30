/***********************************************************************************************************
 * @Purpose:- Controller Class check the action is map or not using handler mapping .
 *            when action is map then method is executed and result send to front controller.
 *            after that front controller display result
 * @Author:- priyanka
 * @Date:- 13/6/2020
 ************************************************************************************************************/
package com.bl.demo.controller;
import com.bl.demo.repository.EmployeeDetail;
import com.bl.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home() {
        return "login";
    }

    @RequestMapping("/Login")
    public String display(HttpServletRequest req, Model m) {
        EmployeeDetail employeeDetail = new EmployeeDetail();
        String name = req.getParameter("UserName");
        String password = req.getParameter("Password");
        String s = employeeDetail.checkLogin(name, password);
        if (s.equals("SUCCESS")) {
            String msg = "Hello" + name;
            m.addAttribute("message", msg);
            return "viewpage";
        } else {
            String msg = "Sorry " + name + ". You entered an incorrect password";
            m.addAttribute("message", msg);
            return "errorpage";
        }
    }

    @RequestMapping("/register")
    public ModelAndView RegPage() {
        return new ModelAndView("register");
    }

    @RequestMapping("/save")
    public String saveRegistration(Model model, Employee registration) {
       EmployeeDetail employeeDetail = new EmployeeDetail();
        Boolean addstatus = employeeDetail.save(registration);
        if (addstatus) {
            String msg = "data save successfully";
            model.addAttribute("message", msg);
            return "login";
        } else {
            String msg = "data not save";
            model.addAttribute("message", msg);
            return "register";
        }
    }
}