/**
 * @作者 WeLong
 * @博客 $ https://towelong.cn
 * @开源项目 $ https://github.com/ToWeLong
 * @创建时间 2019/10/30 12:27
 */
package com.welong.tpl.controller.v1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.welong.tpl.Dao.UserMapper;
import com.welong.tpl.model.User;
import com.welong.tpl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@ResponseBody
@RestController
@Validated
public class TestController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/test")
    public String test(@RequestBody Map<String, Object> map) {
        String code = map.get("code").toString();
        String type = map.get("type").toString();
        int t = Integer.parseInt(type);
        return "code:" + code + ",type:" + t;
    }

    @GetMapping("/t")
    public String tests() {

        return "code:";
    }
    @GetMapping("/ts")
    public Map ts(long start,long count) {
        Map<String,Object> map = new HashMap<>();
        Page<User> pages = new Page<>();
        pages.setCurrent(start);
        pages.setSize(count);
        Page<User> userPage = (Page<User>)userMapper.selectPage(pages,null);
        map.put("data",userPage);
        return map;

    }
}
