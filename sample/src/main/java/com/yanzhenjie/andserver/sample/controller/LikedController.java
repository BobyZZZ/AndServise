package com.yanzhenjie.andserver.sample.controller;

import android.util.Log;

import com.yanzhenjie.andserver.annotation.GetMapping;
import com.yanzhenjie.andserver.annotation.PathVariable;
import com.yanzhenjie.andserver.annotation.PostMapping;
import com.yanzhenjie.andserver.annotation.RequestBody;
import com.yanzhenjie.andserver.annotation.ResponseBody;
import com.yanzhenjie.andserver.annotation.RestController;
import com.yanzhenjie.andserver.sample.model.AppLiked;
import com.yanzhenjie.andserver.sample.util.LoginUtils;

import java.util.ArrayList;

/**
 * Created by Boby on 2019/5/25.
 */

@RestController
public class LikedController {
    LoginUtils mUtils = LoginUtils.getInstance();

    @ResponseBody
    @PostMapping("/user/liked")
    boolean like(@RequestBody AppLiked appLiked) {
        Log.e("RequestBody", "like: " + appLiked);
        long l = mUtils.insertLiked(appLiked);
        return l > -1;
    }

    @ResponseBody
    @GetMapping("/user/unliked/{user_id}/{app_id}")
    boolean unlike(@PathVariable("user_id") String user_id, @PathVariable("app_id") String app_id) {
        Log.e("unlike", "user_id: " + user_id + "---app_id:" + app_id);
        return mUtils.deleteLiked(user_id, app_id) > 0;
    }

    @ResponseBody
    @GetMapping("/user/isLiked/{user_id}/{app_id}")
    boolean isLiked(@PathVariable("user_id") String user_id, @PathVariable("app_id") String app_id) {
        Log.e("isLiked", "user_id: " + user_id + "---app_id:" + app_id);
        return mUtils.findLiked(user_id, app_id);
    }

    @ResponseBody
    @GetMapping("/user/getAllLiked/{user_id}")
    ArrayList<AppLiked> getAllLiked(@PathVariable("user_id") String user_id) {
        Log.e("getAllLiked", "user_id: " + user_id);
        ArrayList<AppLiked> list = mUtils.getAllLikedApp(user_id);
        Log.e("getAllLiked", "result: " + list);
        return list;
    }
}
