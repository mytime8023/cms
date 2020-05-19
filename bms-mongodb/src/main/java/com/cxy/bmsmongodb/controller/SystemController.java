package com.cxy.bmsmongodb.controller;

import com.cxy.bmsmongodb.pojo.dto.PageResult;
import com.cxy.bmsmongodb.pojo.entity.Book;
import com.cxy.bmsmongodb.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chenxy
 * @date 2020/5/14 17:20
 * @desc this is description
 */
@RestController
public class SystemController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/query_all")
    public List<Book> queryAll(){

        return bookService.findAll();
    }

    @PostMapping("/insert")
    public String insert(@RequestBody Book book){
        bookService.saveObj(book);
        return "success";
    }

    @GetMapping("/query_by_id")
    public Book queryById(@RequestParam String id){
        Book book = bookService.queryById(id);
        return book;
    }

    @PostMapping("/update")
    public String update(@RequestBody Book book){
        bookService.updateById(book);
        return "success";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String id){
        bookService.deleteById(id);
        return "success";
    }

    @GetMapping("/query_by_page")
    public PageResult<Book> queryByPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){

        PageResult page = PageResult.builder().pageNum(pageNum).pageSize(pageSize).build();

        bookService.queryByPage(page);

        return page;
    }
}
