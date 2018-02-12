package com.test.service.impl;

import com.test.service.AbstractSubjectPull;

/**
 * 具体主题角色
 */
public class ConcreteAbstractSubjectPull extends AbstractSubjectPull {
    private String title;
    private String author;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void change(String title, String author) {
        this.title = title;
        this.author = author;
        this.notifyObservers();
    }
}
