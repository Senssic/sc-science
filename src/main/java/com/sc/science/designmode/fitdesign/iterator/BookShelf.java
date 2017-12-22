package com.sc.science.designmode.fitdesign.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体集合类,实现集合类的创建迭代器(iterator)方法,指定具体迭代器
 *
 * @qiss
 */
public class BookShelf implements Aggregate {
    private List<Book> books;
    private int last = 0;

    public BookShelf() {
        this.books = new ArrayList<>();
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
