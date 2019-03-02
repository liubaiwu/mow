package me.look.service.impl;

import me.look.entity.Account;
import me.look.mapping.AccountMapper;
import me.look.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getAccountById(long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(Account record) {
        return accountMapper.insert(record);
    }
}
