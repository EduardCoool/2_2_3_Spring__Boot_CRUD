package spring.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spring.model.User;
import spring.service.UserServiceImp;


@Controller
public class UserContoller {

    @Autowired
    private UserServiceImp userServiceImp;

    @GetMapping(value = "/users")
    public String viewUsers(Model model) {
        model.addAttribute("usersAll", userServiceImp.getUsers());
        return "users";
    }

    @GetMapping("/addNew")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("newUser", user);
        return "addNewUser";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("newUser") User user) {
        userServiceImp.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        User user = userServiceImp.getById(id);
        model.addAttribute("newUser", user);
        return "update";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        userServiceImp.deleteUserById(id);
        return "redirect:/users";

    }
}

