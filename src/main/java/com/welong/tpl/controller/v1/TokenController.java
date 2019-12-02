/**
 * @作者 WeLong
 * @博客 $ https://towelong.cn
 * @开源项目 $ https://github.com/ToWeLong
 * @创建时间 2019/10/28 22:32
 */
package com.welong.tpl.controller.v1;

import com.welong.tpl.exception.Forbidden;
import com.welong.tpl.model.User;
import com.welong.tpl.service.UserService;
import com.welong.tpl.utils.TokenUtils;
import com.welong.tpl.utils.WxManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
@Validated
public class TokenController {

    @Autowired
    UserService userService;

    @PostMapping("/token")
    public Map getToken(@RequestBody User user){
        Map<String,Object> map = new HashMap();
        int type =user.getType();
        if(type != 200){
            throw new Forbidden("类型不存在");
        }
        String account = user.getAccount();
        String openId = WxManager.getOpenId(account);
        long uid = userService.createMiniUser(openId);
        TokenUtils tokenUtils = new TokenUtils();
        String token = tokenUtils.CreateToken(uid,16);
        map.put("token",token);
        return map;
    }
    @PostMapping("/token/verify")
    public Map verifyToken(@RequestBody User user){
        TokenUtils tokenUtils = new TokenUtils();
        Map<String,Object> map = new HashMap<>();
        map.put("result",tokenUtils.VerifyToken(user.getToken()));
        return map;
    }

}
