package com.gsk.mj.repository;

import com.gsk.mj.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface AccountRepository extends JpaRepository<Account , Integer> {
    Account findByOpenid(String openid);

    Account findByUuid(int uuid);
}
