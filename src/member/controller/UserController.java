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
            modelAndView = new ModelAndView("registration");

            if (status == 0) {
                modelAndView.addObject("errorMsg", "User email id is already present in the system. Please choose another email id.");
            } else if (status == -1) {
                modelAndView.addObject("errorMsg", "User mobile is already present in the system. Please choose another mobile number.");
            } else if (status == -2) {
                modelAndView.addObject("errorMsg", "User PAN is already present in the system. Please choose another PAN number.");
            }
        }

        return modelAndView;
    }
}