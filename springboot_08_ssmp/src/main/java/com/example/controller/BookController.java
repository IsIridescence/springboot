package com.example.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.controller.util.R;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    @Autowired
    private IBookService iBookService;



    @GetMapping
    public R getAll(){
        return new R(true,iBookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book){

        boolean flag = iBookService.save(book);

        return  new R(flag,flag ? "~~添加成功~~" : "！添加失败！");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(iBookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(iBookService.delete(id));
    }

    @GetMapping("{id}")
    public R GetById(@PathVariable Integer id){
        return new R(true,iBookService.getById(id) );
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize,Book book){

        IPage<Book> page = iBookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于了总页码值， 那么会重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage > page.getPages()){
            page = iBookService.getPage((int)page.getPages(), pageSize,book);
        }

        return new R(true,page);
    }

}
