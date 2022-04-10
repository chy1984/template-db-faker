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
import java.text.DateFormat;
import java.text.ParseException;
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
    protected DbFakerMapper getMapper() {
        return userMapper;
    }

/*
    @Override
    public int getCountOfEachBatch(){
        return 1000;
    }
*/

    @Override
    public User generateFaker() {
        //随机中文用户名，最大长度8个汉字
        String username = PersonInfoSource.getInstance().randomChineseNickName(8);
        String tel = PersonInfoSource.getInstance().randomChineseMobile();
        String address = AreaSource.getInstance().randomAddress();

        //生日，1950~2000的随机时间
        LocalDate beginDate = LocalDate.of(1950, 1, 1);
        LocalDate endDate = LocalDate.of(2000, 1, 1);
        String randomDateStr = DateTimeSource.getInstance().randomDate(beginDate, endDate, "yyyy-MM-dd");
        //允许此字段为null
        Date birthday = null;
        try {
            birthday = DateFormat.getDateInstance().parse(randomDateStr);
        } catch (ParseException e) {
            log.error("String类型的时间转换为Date对象出错，randomDateStr={}", randomDateStr, e);
        }

        return User.builder()
                .username(username)
                .tel(tel)
                .address(address)
                .birthday(birthday)
                .createTime(new Date())
                .build();
    }

}
