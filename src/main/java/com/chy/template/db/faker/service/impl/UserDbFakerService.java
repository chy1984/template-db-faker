package com.chy.template.db.faker.service.impl;

import com.apifan.common.random.source.AreaSource;
import com.apifan.common.random.source.DateTimeSource;
import com.apifan.common.random.source.PersonInfoSource;
import com.chy.template.db.faker.entity.User;
import com.chy.template.db.faker.mapper.DbFakerMapper;
import com.chy.template.db.faker.mapper.UserMapper;
import com.chy.template.db.faker.service.AbstractDbFakerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;

/**
 * db假数据-用户表的service实现
 *
 * @author chy
 */
@Slf4j
@Service
public class UserDbFakerService extends AbstractDbFakerService<User> {

    @Resource
    private UserMapper userMapper;

    @Override
    protected DbFakerMapper<User> getMapper() {
        return userMapper;
    }

    @Override
    public int getBatchCount() {
        return 2000;
    }

    @Override
    public User generateFaker() {
        //随机中文用户名，最大长度8个汉字
        String username = PersonInfoSource.getInstance().randomChineseNickName(8);
        String tel = PersonInfoSource.getInstance().randomChineseMobile();
        String address = AreaSource.getInstance().randomAddress();
        //2000年往前30年内的一个随机日期
        Date birthday = DateTimeSource.getInstance().randomPastDate(LocalDate.of(2000, 1, 1), 365 * 30L);

        return User.builder()
                .username(username)
                .tel(tel)
                .address(address)
                .birthday(birthday)
                .build();
    }

}
