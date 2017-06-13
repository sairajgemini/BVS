package member.controller;

import member.profile.User;
import member.util.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by saikatgupta on 5/29/17.
 */
@Controller
public class UserController {
    @RequestMapping(value = "/registerUser.html", method = RequestMethod.POST)
    public ModelAndView getRegisterUser(@ModelAttribute User user) {

        int status = 0;
        ModelAndView modelAndView = null;

        status = UserUtil.registerUser(user);

        if (status == 1) {
            modelAndView = new ModelAndView("registration");
            modelAndView.addObject("successMsg", "User successfully registered. Userid : " + user.getUserId());
        } else {
            modelAndView = new ModelAndView("error");
            modelAndView.addObject("errorMsg", "User registration failed.");
        }

        return modelAndView;
    }
}