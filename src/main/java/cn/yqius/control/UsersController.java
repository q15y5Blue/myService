package cn.yqius.control;

import cn.yqius.entity.Users;
import cn.yqius.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * /login/getUser
 */
@Controller
@RequestMapping(path = "/login")
public class UsersController {

    //	yqius.xyz:6379
    private final UserRepository userRepository;

    @Autowired
    public UsersController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping(path="/getUser")
    public @ResponseBody
    Users getUser(@RequestParam("username")String username,
                          @RequestParam("password")String password,
                          @ModelAttribute("user") Users user){
        System.out.println(username);
        System.out.println(password);
        user = userRepository.getUsersByUsernameAndPassword(username,password);
        if(user!=null){
            return user;
        }
        else{
            return null;
        }
    }
}
