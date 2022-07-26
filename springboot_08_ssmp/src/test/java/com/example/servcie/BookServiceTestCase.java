package com.example.servcie;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import com.example.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private IBookService bookService;

    @Test
    void TestGetById(){
        System.out.println(bookService.getById(4));

    }
    @Test
    void testSave() {

        Book book = new Book();
        book.setName("测试数据24");
        book.setType("12");
        book.setDescription("2121");
        bookService.save(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(11);
        book.setName("测试数据242121111");
        book.setType("12");
        book.setDescription("2121");
        bookService.updateById(book);

    }

    @Test
    void testDelete() {
        bookService.removeById(13);

    }

    @Test
    void testGetAll() {

        bookService.list();
    }

    @Test
    void testGetPage() {

        IPage<Book> page = new Page<Book>(2,5);
       bookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }


}
