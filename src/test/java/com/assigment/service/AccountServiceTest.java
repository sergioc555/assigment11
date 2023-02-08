package com.assigment.service;

import com.assigment.model.Account;
import com.assigment.repository.AccountRepository;
import com.assigment.repository.TransactionRepository;
import com.assigment.request.NewAccountRequest;
import com.assigment.request.NewTransactionRequest;
import com.assigment.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.assigment.model.Transaction;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    AccountService accountService;

    @Test
    public void createTransaction() {

        NewTransactionRequest newTransactionRequest = NewTransactionRequest.builder()
                                                                            .accountId(1000)
                                                                            .amount(100)
                                                                            .build();

        accountService.createTransaction(newTransactionRequest);

        Mockito.verify(transactionRepository).save(Mockito.any());
    }

    @Test
    public void createAccountWithoutInitialCredir() {

        NewAccountRequest newAccountRequest = new NewAccountRequest();
        newAccountRequest.setCustomerId(1);
        newAccountRequest.setInitialCredit(0);

        Account account =  Account.builder().id(1).customerId(1).build();

        Mockito.when(accountRepository.save(Mockito.any())).thenReturn(account);

        accountService.createAccount(newAccountRequest);

        Mockito.verify(accountRepository).save(Mockito.any());
        Mockito.verifyNoInteractions(transactionRepository);
    }

    @Test
    public void createAccountWithInitialCredit() {

        NewAccountRequest newAccountRequest = new NewAccountRequest();
        newAccountRequest.setCustomerId(1);
        newAccountRequest.setInitialCredit(1.0);

        Account account =  Account.builder().id(1).customerId(1).build();

        Mockito.when(accountRepository.save(Mockito.any())).thenReturn(account);

        accountService.createAccount(newAccountRequest);

        Mockito.verify(accountRepository).save(Mockito.any());
        Mockito.verify(transactionRepository).save(Mockito.any());
    }
}
