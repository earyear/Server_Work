package com.busanit501.demo.lunch.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MenuDTO {
    private long no;
    private String name;
    private LocalDate dueDate;

//    public long getNo() {
//        return no;
//    }
//    public void setNo(long no) {
//        this.no = no;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public LocalDate getDueDate() {
//        return dueDate;
//    }
//    public void setDueDate(LocalDate dueDate) {
//        this.dueDate = dueDate;
//    }
//
//    @Override
//    public String toString() {
//        return "MenuDTO{" +
//                "no=" + no +
//                ", name='" + name + '\'' +
//                ", dueDate=" + dueDate +
//                '}';
//    }
}
