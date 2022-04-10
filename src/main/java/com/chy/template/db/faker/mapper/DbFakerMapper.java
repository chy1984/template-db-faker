package com.chy.template.db.faker.mapper;

import java.util.List;

/**
 * db假数据的公共mapper接口
 *
 * @author chy
 */
public interface DbFakerMapper<T> {

    /**
     * 批量插入
     *
     * @param list
     * @return
     */
    int batchInsert(List<T> list);

    /**
     * 清空表数据
     *
     * @return
     */
    void truncateTable();

}
