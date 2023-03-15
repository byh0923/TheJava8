package com.yhbae.practice;

import java.util.Optional;

public class OnlineClass {

    private Integer id;

    private String title;

    private boolean closed;

    private Progress progress;

    public Optional<Progress> getProgress() {
        // 에러를 던지던가..
        // checked exception을 던지면 에러 처리를 강제하게 되는 문제점
        // 에러가 발생하면 stack trace를 찍는데 그 찍을때 리소를 찍게 됨.
        /*if(this.progress == null) {
            throw new IllegalStateException();
        }*/

        // 두번째 옵션은 null을 리턴하는 방법..
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

}
