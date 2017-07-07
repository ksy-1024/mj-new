package com.gsk.mj.repository;

import com.gsk.mj.domain.StandingsRelation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface StandingReRepository extends JpaRepository<StandingsRelation , Integer> {
}
