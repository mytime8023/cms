package com.cxy.bmsmongodb.service.impl;

import com.cxy.bmsmongodb.pojo.dto.PageResult;
import com.cxy.bmsmongodb.pojo.entity.Book;
import com.cxy.bmsmongodb.service.IBookService;
import com.cxy.bmsmongodb.util.MongoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chenxy
 * @date 2020/5/14 16:59
 * @desc this is description
 */
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoUtil mongoUtil;

    public void saveObj(Book book) {
        mongoTemplate.save(book);
    }

    public List<Book> findAll() {
        return mongoTemplate.findAll(Book.class);
    }

    public Book queryById(String id) {
        Book book = mongoTemplate.findOne(new Query(Criteria.where("id").is(id)), Book.class);
        return book;
    }

    public void updateById(Book book) {
        Query query = new Query(Criteria.where("id").is(book.getId()));
        Update update = new Update().set("name", book.getName()).set("updateTime", new Date());
        mongoTemplate.updateFirst(query, update,Book.class);
    }

    public void deleteById(String id){
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,Book.class);
    }

    public void queryByPage(PageResult<Book> page) {
        Sort sort = Sort.by(Sort.Direction.DESC, "updateTime").and(Sort.by(Sort.Direction.DESC, "price"));
        Query query = new Query().with(sort);
        mongoUtil.pagination(Book.class, query, page);
    }

}
