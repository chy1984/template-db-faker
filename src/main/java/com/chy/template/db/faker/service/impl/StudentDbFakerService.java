package com.chy.template.db.faker.service.impl;

import com.apifan.common.random.source.AreaSource;
import com.apifan.common.random.source.DateTimeSource;
import com.apifan.common.random.source.PersonInfoSource;
import com.chy.template.db.faker.entity.Student;
import com.chy.template.db.faker.mapper.DbFakerMapper;
import com.chy.template.db.faker.mapper.StudentMapper;
import com.chy.template.db.faker.service.AbstractDbFakerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;

/**
 * db假数据-学生表的service实现
 *
 * @author chy
 */
@Slf4j
@Service
public class StudentDbFakerService extends AbstractDbFakerService<Student> {

    @Resource
    private StudentMapper studentMapper;

    @Override
    protected DbFakerMapper<Student> getMapper() {
        return studentMapper;
    }

    @Override
    public Student generateFaker() {
        String name = PersonInfoSource.getInstance().randomChineseName();
        String tel = PersonInfoSource.getInstance().randomChineseMobile();
        String address = AreaSource.getInstance().randomAddress();
        //2010年往前5年范围内的一个随机日期
        Date birthday = DateTimeSource.getInstance().randomPastDate(LocalDate.of(2010, 1, 1), 365 * 5L);

        return Student.builder()
                .name(name)
                .tel(tel)
                .address(address)
                .birthday(birthday)
                .createTime(new Date())
                .build();
    }

}
