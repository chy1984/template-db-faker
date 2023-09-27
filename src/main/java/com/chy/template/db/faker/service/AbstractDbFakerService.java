package com.chy.template.db.faker.service;

import com.chy.template.db.faker.mapper.DbFakerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.ArrayList;

/**
 * db假数据的service抽象实现
 *
 * @author chy
 */
@Slf4j
public abstract class AbstractDbFakerService<T> implements DbFakerService<T> {

    /**
     * 获取对应的dao层实例
     *
     * @return DbFakerMapper<T>
     */
    protected abstract DbFakerMapper<T> getMapper();

    @Override
    public void batchInsertFaker(int totalCount) {
        //校验入参
        Assert.isTrue(totalCount > 0, "待插入数量需要大于0");

        //已插入记录数
        int insertedCount = 0;
        //每批次插入的记录数
        int batchCount = this.getBatchCount();
        long startTime = System.currentTimeMillis();
        log.info("开始插入");

        while (insertedCount < totalCount) {
            try {
                //计算当前批次需要插入记录数
                batchCount = Math.min(batchCount, totalCount - insertedCount);

                //生成待插入的数据列表
                ArrayList<T> list = new ArrayList<>();
                for (int i = 0; i < batchCount; i++) {
                    list.add(this.generateFaker());
                }

                //批量插入
                int curInsertedCount = this.getMapper().batchInsert(list);
                insertedCount += curInsertedCount;
                log.info("当前批次期待插入{}条，实际插入{}条，总计插入{}条", batchCount, curInsertedCount, insertedCount);
            } catch (Exception e) {
                log.error("当前批次执行异常", e);
            }
        }

        long endTime = System.currentTimeMillis();
        log.info("插入完毕，共计插入{}条，耗时{}s", totalCount, (endTime - startTime) / 1000);
    }

    @Override
    public void cleanAllFaker() {
        this.getMapper().truncateTable();
        log.info("已清空表中的历史数据");
    }

}
