package com.cxy.bmsmongodb.service;

import com.cxy.bmsmongodb.pojo.dto.PageResult;
import com.cxy.bmsmongodb.pojo.entity.Book;

import java.util.List;

/**
 * @author chenxy
 * @date 2020/5/14 16:59
 * @desc this is description
 */
public interface IBookService {

    void saveObj(Book book);
    List<Book> findAll();

    Book queryById(String id);

    void updateById(Book book);

    void deleteById(String id);

    void queryByPage(PageResult<Book> page);
}
