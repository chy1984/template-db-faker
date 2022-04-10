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
public class User implements Serializable {

    private static final long serialVersionUID = 490327631370074387L;

    private Long userId;

    private String username;

    private String tel;

    private String address;

    private Date birthday;

    private Date createTime;

    private Date updateTime;

}
