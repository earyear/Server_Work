package com.busanit501.ngylunchproject.repository;

import com.busanit501.ngylunchproject.domain.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Query("select r from Reply r where r.lunch.bno = :bno")
    Page<Reply> listOfLunch(Long bno, Pageable pageable);
}
