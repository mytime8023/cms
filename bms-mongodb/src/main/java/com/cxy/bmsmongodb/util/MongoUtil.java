package com.cxy.bmsmongodb.util;

import com.cxy.bmsmongodb.pojo.dto.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chenxy
 * @date 2020/5/19 14:53
 * @desc this is description
 */
@Component
public class MongoUtil {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * MongoDB分页查询公共方法
     * @param clazz 实体类的class对象
     * @param query query是啥不知道赶紧去查下，相当于sql语句
     * @param page 分页对象
     * @param <T>
     */
    public <T> void pagination(Class<T> clazz, Query query, PageResult<T> page) {
        long total = this.mongoTemplate.count(query, clazz);
        Integer pages = (int)Math.ceil(total * 1.0 / page.getPageSize());
        if (page.getPageNum() <= 0 || page.getPageNum() > pages) {
            page.setPageNum(1);
        }
        int skip = page.getPageSize() * (page.getPageNum() - 1);
        query.skip(skip).limit(page.getPageSize());
        List<T> list = mongoTemplate.find(query, clazz);

        page.setTotal(total);
        page.setPages(pages);
        page.setData(list);
    }
}
