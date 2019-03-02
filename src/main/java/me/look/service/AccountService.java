package me.look.service;

import me.look.entity.Account;
import me.look.entity.AccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountService {

    public Account getAccountById(long id);



    int insert(Account record);


}
