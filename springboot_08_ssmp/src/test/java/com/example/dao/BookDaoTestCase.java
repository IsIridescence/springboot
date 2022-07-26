package com.example.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        Book book = bookDao.selectById(1);
        System.out.println(book);

    }

    @Test
    void testSave() {

        Book book = new Book();
        book.setName("测试数据24");
        book.setType("12");
        book.setDescription("2121");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(13);
        book.setName("测试数据242121");
        book.setType("12");
        book.setDescription("2121");
        bookDao.updateById(book);

    }

    @Test
    void testDelete() {
       bookDao.deleteById(12);

    }

    @Test
    void testGetAll() {

        bookDao.selectList(null);
    }

    @Test
    void testGetPage() {

        Page page = new Page(2,5);
        bookDao.selectPage(page,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy() {
        String name = "spring";

        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.like(name != null,Book::getName,name);
        bookDao.selectList(queryWrapper);
    }

}
