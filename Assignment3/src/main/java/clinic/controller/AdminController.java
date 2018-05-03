package clinic.controller;

import clinic.model.User;
import clinic.model.validation.Notification;
import clinic.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

//    /***************************USER *************************************/
//
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUser() {
        return "user";
    }

    //READ/LIST USER
    @RequestMapping(value = "/userView", params = "viewUsers", method = RequestMethod.GET)
    public String readUsers(Model model) {
        List<User> items = userService.findAll();
        model.addAttribute("users", items);
        return "user";
    }

    //UPDATE USER
    @RequestMapping(value = "/user", params = "update", method = RequestMethod.POST)
    public String updateUser(Model model, @RequestParam long id, @RequestParam String username, @RequestParam String password, @RequestParam String role) {

        Notification<Boolean> notification = userService.updateUser(id, username, password, role);
        if (!notification.getResult()) {
            model.addAttribute("updUErr", true);
            model.addAttribute("updMessage", notification.getFormattedErrors());
            return "user";
        }

        model.addAttribute("updUSucc", true);
        model.addAttribute("updMessage2", "User updated successfully!");
        return "user";

    }


//    //DELETE USER

    @RequestMapping(value = "/delUser", params = "delete", method = RequestMethod.GET)
    public String deleteUser(Model model, @RequestParam("UserID") long id) {

        Notification<Boolean> notification = userService.deleteUser(id);
        if (!notification.getResult()) {
            model.addAttribute("delUErr", true);
            model.addAttribute("delMessage", notification.getFormattedErrors());
            return "user";
        }
        model.addAttribute("delSucc", true);
        return "user";
    }


    @RequestMapping(value = "/logout", params = "logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/login";
    }



}
