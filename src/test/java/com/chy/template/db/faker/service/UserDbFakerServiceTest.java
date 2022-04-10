package com.chy.template.db.faker.service;

import com.chy.template.db.faker.service.impl.UserDbFakerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author chy
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDbFakerServiceTest {

    @Resource
    private UserDbFakerService userDbFakerService;

    @Test
    public void test() {
        //清空已有数据
        userDbFakerService.cleanAllFaker();
        //插入新数据
        userDbFakerService.batchInsertFaker(1000000);
    }

}
