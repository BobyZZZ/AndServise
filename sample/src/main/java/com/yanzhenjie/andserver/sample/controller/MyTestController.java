package com.yanzhenjie.andserver.sample.controller;

import com.alibaba.fastjson.JSON;
import com.yanzhenjie.andserver.annotation.Controller;
import com.yanzhenjie.andserver.annotation.GetMapping;
import com.yanzhenjie.andserver.annotation.RequestParam;
import com.yanzhenjie.andserver.annotation.ResponseBody;
import com.yanzhenjie.andserver.annotation.RestController;
import com.yanzhenjie.andserver.framework.body.StringBody;

/**
 * Created by Boby on 2019/5/24.
 */

@Controller
public class MyTestController {

    @ResponseBody
    @GetMapping("/boby/mytest")
    String myTest() {
        return "ddd";
    }
}
