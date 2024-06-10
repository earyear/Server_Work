package com.busanit501.ngylunchproject.repository.search;

import com.busanit501.ngylunchproject.domain.Lunch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LunchSearch {
    Page<Lunch> search(Pageable pageable);

    Page<Lunch> searchAll(String[] types, String keyword ,Pageable pageable);
}
