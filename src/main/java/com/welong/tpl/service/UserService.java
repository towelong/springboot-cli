package com.welong.tpl.service;

import com.amdelamar.jhash.exception.InvalidHashException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.welong.tpl.model.User;

/**
 * @Author WeLong
 * @create 2019/10/25 13:31
 */
public interface UserService {
    void createUser(User user);
    User findByNickname(String nickname);
    String verifyUser(User user) throws InvalidHashException;
    long createMiniUser(String openid);

}
