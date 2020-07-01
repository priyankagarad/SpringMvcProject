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
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class EmployeeController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home() {
        return "login";
    }

    @RequestMapping("/Login")
    public String display(HttpServletRequest req, Model m) throws SQLException {
        EmployeeDetail employeeDetail = new EmployeeDetail();
        String name = req.getParameter("UserName");
        String password = req.getParameter("Password");
        ResultSet loginDetail = employeeDetail.checkLogin(name, password);
        if (loginDetail != null) {
            String msg = "Hello " + loginDetail.getString("username");
            String msg1 = "email "+":" + loginDetail.getString("email");
            String msg2 = "registration date "+":" + loginDetail.getString("registrationDate");
            m.addAttribute("message", msg);
            m.addAttribute("message1", msg1);
            m.addAttribute("message2", msg2);
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