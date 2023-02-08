package com.assigment.service;

import com.assigment.repository.AccountRepository;
import com.assigment.repository.TransactionRepository;
import com.assigment.request.NewAccountRequest;
import com.assigment.request.NewTransactionRequest;
import com.assigment.model.Account;
import com.assigment.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class AccountService {

  private AccountRepository accountRepository;
  private TransactionRepository transactionRepository;

  public void createAccount(NewAccountRequest newAccountRequest){
    Account newAccount = Account.builder()
            .customerId(newAccountRequest.getCustomerId())
            .build();
    newAccount = accountRepository.save(newAccount);

    if(newAccountRequest.getInitialCredit()!=0){
      this.createTransaction(NewTransactionRequest.builder()
              .accountId(newAccount.getId())
              .amount(newAccountRequest.getInitialCredit())
              .build());
    }
  }


  public void createTransaction(NewTransactionRequest newTransactionRequest){
    Transaction newTransaction = Transaction.builder()
                                    .accountId(newTransactionRequest.getAccountId())
                                    .amount(newTransactionRequest.getAmount())
                                    .build();

    transactionRepository.save(newTransaction);
  }

}
