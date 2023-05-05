package com.PlanKueue.springbootPlanKueue.repositoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.PlanKueue.springbootPlanKueue.models.Account;
import com.PlanKueue.springbootPlanKueue.repository.AccountRepository;

@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    private Account testAccount;

    @BeforeEach
    void setUp() {
        testAccount = new Account();
        testAccount.setUsername("testUser");
        testAccount.setPassword("testPassword");
    }

    @Test
    void saveTest() {
        Account savedAccount = accountRepository.save(testAccount);
        assertNotNull(savedAccount.getAccountId());
    }

    @Test
    void findByIdTest() {
        Account savedAccount = accountRepository.save(testAccount);
        Optional<Account> foundAccount = accountRepository.findById(savedAccount.getAccountId());
        assertEquals(savedAccount, foundAccount.get());
    }

    @Test
    void findAllTest() {
        accountRepository.save(testAccount);
        List<Account> accounts = (List<Account>) accountRepository.findAll();
        assertEquals(1, accounts.size());
    }

    @Test
    void deleteByIdTest() {
        Account savedAccount = accountRepository.save(testAccount);
        accountRepository.deleteById(savedAccount.getAccountId());
        Optional<Account> foundAccount = accountRepository.findById(savedAccount.getAccountId());
        assertEquals(false, foundAccount.isPresent());
    }
}
