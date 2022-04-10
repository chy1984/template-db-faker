package com.chy.template.db.faker.service;

import com.chy.template.db.faker.mapper.DbFakerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
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
     * @return
     */
    protected abstract DbFakerMapper<T> getMapper();

    @Override
    public void batchInsertFaker(int totalCount) {
        //校验入参
        Assert.isTrue(totalCount > 0, "需要插入的数据量需要>0");

        long startTime = System.currentTimeMillis();
        log.info("开始插入");

        //已插入记录数
        int generatedCount = 0;
        //每批次插入的记录数
        int countOfEachBatch = getCountOfEachBatch();

        while (generatedCount < totalCount) {
            //计算当前批次待插入记录数
            countOfEachBatch = Math.min(countOfEachBatch, totalCount - generatedCount);

            //组装数据
            ArrayList<T> list = new ArrayList<>();
            for (int i = 0; i < countOfEachBatch; i++) {
                list.add(generateFaker());
            }

            //批量插入，唯一索引字段值重复时进行重试，其它异常直接终止执行
            try {
                int i = getMapper().batchInsert(list);
                generatedCount += i;
                log.info("已插入{}条记录", generatedCount);
            } catch (DuplicateKeyException e) {
                log.info("当前批次存在唯一索引的字段值重复，已放弃当前批次数据");
            } catch (Exception e) {
                log.error("请手动修复此异常");
                throw e;
            }
        }

        long endTime = System.currentTimeMillis();
        log.info("插入完毕，耗时{}s", (endTime - startTime) / 1000);
    }

    @Override
    public void cleanAllFaker() {
        getMapper().truncateTable();
        log.info("已清空表中的历史记录");
    }

}
