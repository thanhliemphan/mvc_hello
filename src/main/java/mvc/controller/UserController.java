package mvc.controller;

import mvc.entity.Gender;
import mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private static final String[] countries = {"VietNam","USA","Germany"};
    @RequestMapping(value = "/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("countries",countries);

        return "userForm";
    }
    @RequestMapping(value = "/result")
    public String processUser(User user, HttpSession session){
        session.setAttribute("username", user.getName());
        return "userResult";
    }
    @RequestMapping(value = "/session-test")
    public String showSessionUser(HttpServletRequest request,Model model){
        String username = (String)request.getSession().getAttribute("username");
        model.addAttribute("username",username);
        return "session";
    }
    @RequestMapping(value = "/remove-sisson")
    public String removeSessionUser(HttpServletRequest request,Model model){
        //remove session
        request.getSession().removeAttribute("username");
//        model.addAttribute("username","No name found");

        return "redirect:/sisson-test";
    }
}
