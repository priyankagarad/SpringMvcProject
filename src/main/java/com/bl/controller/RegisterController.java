package com.bl.controller;
import com.bl.dao.RegisterDao;
import com.bl.model.RegistrationModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController
{
    @RequestMapping("/")
    public String Home(){
        return "login";
    }

    @RequestMapping("/Login")
    public String display(HttpServletRequest req, Model m)
    {
        /*read the provided form data*/
        String name=req.getParameter("UserName");
        String password=req.getParameter("Password");

        if(password.equals("priya")) {
            String msg="Hello"+ name;

            /*add a message to the model*/
            m.addAttribute("message", msg);
            return "viewpage";

        } else {
            String msg="Sorry "+ name+". You entered an incorrect password";
            m.addAttribute("message", msg);
            return "errorpage";
        }
    }

    @RequestMapping("/register")
    public ModelAndView RegPage() {
        return new ModelAndView("register");
    }

    @RequestMapping("/save")
    public String saveRegistration(HttpServletRequest request,Model m){
        RegisterDao registerDao=new RegisterDao();
         String name=  request.getParameter("Name");
         String email=   request.getParameter("EmailId");
         String password= request.getParameter("Password");
         String registerdate= request.getParameter("RegisteredDate");

         RegistrationModel registration=new RegistrationModel();
         registration.setUsername(name);
         registration.setEmail(email);
         registration.setPassword(password);
         registration.setRegistrationdate(registerdate);
         System.out.println(registration.getEmail());
         Boolean addstatus=registerDao.save(registration);
         if (addstatus) {
            String msg="data save successfully";
            m.addAttribute("message", msg);
            return "login";
         }
         else{
            String msg="data not save";
            m.addAttribute("message", msg);
            return "register";
         }
    }
}

