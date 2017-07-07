package com.gsk.mj.repository;

import com.gsk.mj.domain.Standings;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface StandingRepository extends JpaRepository<Standings , Integer>{
}
