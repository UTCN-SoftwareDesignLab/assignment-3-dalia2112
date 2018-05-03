package clinic.controller;

import clinic.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {

        this.userService = userService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister() {
        return "register";
    }

    //CREATE
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addNewUser(Model model, @RequestParam String username, @RequestParam String password, @RequestParam String role) {
        System.out.println(username + " " + password + " " + password);
        if (userService.registerUser(username, password, role).hasErrors()) {
            model.addAttribute("registerErr", true);
            model.addAttribute("errMsg2", userService.registerUser(username, password, role).getFormattedErrors());
        }
        return "register";
    }


    //LOGIN

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginw() {
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showLogin(Model model,@RequestParam String username, @RequestParam String password) {
//        HttpSession session = request.getSession(true);
//        if (session.getAttribute("errorMessage") != null) {
//            model.addAttribute("loginErr", true);
//            model.addAttribute("errMsg", (String) session.getAttribute("errorMessage"));
//        }
        if(userService.login(username,password).getResult())
            return "redirect:/user";
        return "login";
    }

    //LOGOUT
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
        return "redirect:/login";
    }
}
