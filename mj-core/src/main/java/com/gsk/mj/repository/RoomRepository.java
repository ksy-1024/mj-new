package com.gsk.mj.repository;

import com.gsk.mj.domain.RoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface RoomRepository extends JpaRepository<RoomInfo , Integer> {
}
