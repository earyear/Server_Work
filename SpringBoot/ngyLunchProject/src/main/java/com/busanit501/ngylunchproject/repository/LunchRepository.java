package com.busanit501.ngylunchproject.repository;

import com.busanit501.ngylunchproject.repository.search.LunchSearch;
import com.busanit501.ngylunchproject.domain.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LunchRepository extends JpaRepository<Lunch,Long>, LunchSearch {
    @Query(value = "select now()", nativeQuery = true)
    String getTime();
}
