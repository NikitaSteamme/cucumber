package me.otus.habr.service;

import me.otus.habr.page.MainPage;
import me.otus.habr.page.MainPageMobile;
import me.otus.habr.page.MainPageWeb;
import org.springframework.beans.factory.annotation.Autowired;

public class MainPageService {

    @Autowired
    private MainPage page;

    public void openPage(){
        page.open();
    }

    public String openPost(int i){
        return page.openPost(i);
    }

    public void verify(String postTitle){
        page.verify(postTitle);
    }
}
