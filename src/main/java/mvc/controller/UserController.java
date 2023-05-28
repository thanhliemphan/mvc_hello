package mvc.controller;

import mvc.entity.Gender;
import mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String processUser(User user){
        return "userResult";
    }
}
