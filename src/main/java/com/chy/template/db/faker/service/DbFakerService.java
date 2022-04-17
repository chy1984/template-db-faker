package com.chy.template.db.faker.service;

/**
 * db假数据的service接口
 *
 * @author chy
 */
public interface DbFakerService<T> {

    /**
     * 生成一条假数据
     *
     * @return
     */
     T generateFaker();

    /**
     * 批量插入假数据
     *
     * @param totalCount 要插入的数据量
     */
    void batchInsertFaker(int totalCount);

    /**
     * 指定每批次插入的记录数，默认2000
     *
     * @return
     */
    default int getCountOfEachBatch() {
        return 2000;
    }

    /**
     * 清除所有假数据
     */
    void cleanAllFaker();

}
