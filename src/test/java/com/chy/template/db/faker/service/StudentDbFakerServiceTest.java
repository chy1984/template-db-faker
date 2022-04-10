package com.chy.template.db.faker.service;

import com.chy.template.db.faker.service.impl.StudentDbFakerService;
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
public class StudentDbFakerServiceTest {

    @Resource
    private StudentDbFakerService studentDbFakerService;

    @Test
    public void test() {
        //清空已有数据
        studentDbFakerService.cleanAllFaker();
        //插入新数据
        studentDbFakerService.batchInsertFaker(1000000);
    }

}
