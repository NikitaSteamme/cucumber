package me.otus.habr.page;

public interface MainPage {
    void open();
    String openPost(int i);
    void verify (String postTitle);
}
