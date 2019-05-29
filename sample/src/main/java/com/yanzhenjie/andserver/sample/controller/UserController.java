package com.yanzhenjie.andserver.sample.controller;

import com.yanzhenjie.andserver.annotation.Controller;
import com.yanzhenjie.andserver.annotation.GetMapping;
import com.yanzhenjie.andserver.annotation.PathVariable;
import com.yanzhenjie.andserver.annotation.PostMapping;
import com.yanzhenjie.andserver.annotation.RequestParam;
import com.yanzhenjie.andserver.annotation.ResponseBody;
import com.yanzhenjie.andserver.sample.model.User;
import com.yanzhenjie.andserver.sample.util.JsonUtils;
import com.yanzhenjie.andserver.sample.util.LoginUtils;

/**
 * Created by Boby on 2019/5/24.
 */


@Controller
public class UserController {
    private LoginUtils mUtils = LoginUtils.getInstance();

    @ResponseBody
    @PostMapping("/user/login")
    User login(@RequestParam("id") String id,
                 @RequestParam("pwd") String pwd) {
        User user = mUtils.findUser(id, pwd);
//        return JsonUtils.toJsonString(user);
        return user;
    }

    @ResponseBody
    @PostMapping("/user/register")
    String register(@RequestParam("id") String id,
                    @RequestParam("pwd") String pwd,
                    @RequestParam("userName") String userName,
                    @RequestParam("photoPath") String photoPath) {
        boolean result = mUtils.insertUser(id, pwd, userName, photoPath);
        return JsonUtils.toJsonString(result);
    }

    @ResponseBody
    @GetMapping("/user/checkId/{userId}")
    boolean checkId(@PathVariable("userId") String userId) {
        boolean result = mUtils.isPhoneExist(userId);
        return result;
    }

    @ResponseBody
    @GetMapping("/user/checkName/{userName}")
    boolean checkName(@PathVariable("userName") String userName) {
        boolean result = mUtils.isUserNameExist(userName);
        return result;
    }

    @ResponseBody
    @PostMapping("/user/upload")
    boolean upload() {
        //图片上传，未实现
        return true;
    }
}
