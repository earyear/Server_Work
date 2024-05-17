package com.busanit501.demo.todo.dto;

import java.time.LocalDate;

public class TodoDTO {
    //인스턴스 멤버
    private long tno;
    private String title;
    private LocalDate dueDate;
    private boolean cheak;


    public long getTno() {
        return tno;
    }
    public void setTno(long tno) {
        this.tno = tno;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public boolean isCheak() {
        return cheak;
    }
    public void setCheak(boolean cheak) {
        this.cheak = cheak;
    }

    @Override
    public String toString() {
        return "TodoDTO{" +
                "tno=" + tno +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", cheak=" + cheak +
                '}';
    }
}
