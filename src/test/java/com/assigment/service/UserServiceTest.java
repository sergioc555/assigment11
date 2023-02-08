package com.assigment.service;

import java.util.List;

import com.assigment.model.Account;
import com.assigment.model.Transaction;
import com.assigment.model.User;
import com.assigment.repository.AccountRepository;
import com.assigment.repository.TransactionRepository;
import com.assigment.repository.UserRepository;
import com.assigment.request.NewAccountRequest;
import com.assigment.request.NewTransactionRequest;
import com.assigment.response.GetUserResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    UserService userService;

    @Test
    public void getAccountDetailed() {

        Mockito.when(userRepository.getById(Mockito.anyLong()))
                .thenReturn(User.builder()
                                .id(1)
                                .name("Sergio")
                                .surname("Casta00")
                                .build());

        Mockito.when(accountRepository.getByCustomerId(Mockito.anyLong()))
                .thenReturn(List.of(Account.builder().id(1L).customerId(1L).build()));
        Mockito.when(transactionRepository.getAllByCustomerId(Mockito.anyLong()))
                .thenReturn(List.of(Transaction.builder().id(1L).accountId(1L).amount(100.0).build()));

        GetUserResponse resp = userService.getAccountDetailed(1L);

        Assert.assertEquals(resp.getName(),"Sergio");
        Assert.assertEquals(resp.getSurname(),"Casta00");
        Assert.assertEquals(resp.getAccounts().get(0).getAccountId(),1L);
        Assert.assertEquals(resp.getAccounts().get(0).getBalance(),100.0,0.001);
        Assert.assertEquals(resp.getAccounts().get(0).getTransactions().get(0).getAmount(),100.0, 0.001);
    }

}
