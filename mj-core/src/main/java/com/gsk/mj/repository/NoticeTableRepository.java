package com.gsk.mj.repository;

import com.gsk.mj.domain.NoticeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface NoticeTableRepository extends JpaRepository<NoticeTable, Integer>{

    @Query(value = "select * from t_yw_notice ORDER BY id DESC LIMIT 1" , nativeQuery= true)
    NoticeTable findLast();
}
