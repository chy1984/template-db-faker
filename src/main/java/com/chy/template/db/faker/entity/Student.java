package com.chy.template.db.faker.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chy
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = -6345368530170632920L;

    private Long studentId;

    private String name;

    private String tel;

    private String address;

    private Date birthday;

    private Date createTime;

    private Date updateTime;

}
