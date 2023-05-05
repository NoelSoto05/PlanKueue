package com.PlanKueue.springbootPlanKueue.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.PlanKueue.springbootPlanKueue.models.Account;
import com.PlanKueue.springbootPlanKueue.repository.AccountRepository;

@DataJpaTest
public class AccountTests {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testCreateAccount() {
        Account account = new Account();
        Account savedAccount = accountRepository.save(account);

        assertNotNull(savedAccount.getAccountId());
        assertEquals(null, savedAccount.getUsername());
        assertEquals(null, savedAccount.getPassword());
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        Account savedAccount = accountRepository.save(account);

        savedAccount.setUsername("gppq");
        savedAccount.setPassword("admin");
        accountRepository.save(savedAccount);

        Account updatedAccount = accountRepository.findById(savedAccount.getAccountId()).orElse(null);
        assertNotNull(updatedAccount);
        assertEquals("gppq", updatedAccount.getUsername());
        assertEquals("admin", updatedAccount.getPassword());
    }

    @Test
    public void testDeleteAccount() {
        Account account = new Account();
        Account savedAccount = accountRepository.save(account);

        accountRepository.delete(savedAccount);

        Account deletedAccount = accountRepository.findById(savedAccount.getAccountId()).orElse(null);
        assertNull(deletedAccount);
    }

    @Test
    public void testFindById() {
        Account account = new Account();
        account.setUsername("gppq");
        Account savedAccount = accountRepository.save(account);

        Account foundAccount = accountRepository.findById(savedAccount.getAccountId()).orElse(null);
        assertNotNull(foundAccount);
        assertEquals("gppq", foundAccount.getUsername());
    }

}
