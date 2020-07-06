package com.imooc.controller;

import com.imooc.pojo.Users;
import com.imooc.pojo.vo.UsersVO;
import com.imooc.service.UsersService;
import com.imooc.utils.IMoocJSONResult;
import com.imooc.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiepanpan
 * @Date: 2020/5/29
 * @Description:
 */
@RestController
@RequestMapping("u")
public class UserController {
    @Autowired
    private UsersService userService;

    /**
     * 用户注册 用户登录
     * @param users
     * @return
     * @throws Exception
     */
    @PostMapping("/registOrLogin")
    public IMoocJSONResult registerOrLogin(@RequestBody Users users) throws Exception {

        if (StringUtils.isBlank(users.getUsername())||StringUtils.isBlank(users.getPassword())) {
            return IMoocJSONResult.errorMsg("用户名或密码不能为空...");
        }
        // 1. 判断用户名是否存在，如果存在就登录，如果不存在则注册
        boolean usernameIsExist = userService.queryUsernameIsExist(users.getUsername());
        Users userResult = null;
        if (usernameIsExist) {
            // 1.1 登录
            userResult = userService.queryUserForLogin(users.getUsername(),
                    MD5Utils.getMD5Str(users.getPassword()));
            if (userResult == null) {
                return IMoocJSONResult.errorMsg("用户名或密码不正确...");
            }
        }else {
            // 1.2 注册
            users.setNickname(users.getUsername());
            users.setFaceImage("");
            users.setFaceImageBig("");
            users.setPassword(MD5Utils.getMD5Str(users.getPassword()));
            userResult = userService.saveUser(users);
        }

        UsersVO usersVO = new UsersVO();
        BeanUtils.copyProperties(userResult,usersVO);

        return IMoocJSONResult.ok(usersVO);
    }

}
