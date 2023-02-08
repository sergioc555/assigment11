package com.assigment.service;

import java.util.List;
import java.util.stream.Collectors;

import com.assigment.response.AccountItemResponse;
import com.assigment.response.GetUserResponse;
import com.assigment.response.TransactionItemResponse;
import com.assigment.model.Account;
import com.assigment.model.Transaction;
import com.assigment.model.User;
import com.assigment.repository.AccountRepository;
import com.assigment.repository.TransactionRepository;
import com.assigment.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private UserRepository userRepository;
  private AccountRepository accountRepository;
  private TransactionRepository transactionRepository;

  public GetUserResponse getAccountDetailed(long userId){
    User user = userRepository.getById(userId);
    List<Account> accounts = accountRepository.getByCustomerId(user.getId());
    List<Transaction> transactions = transactionRepository.getAllByCustomerId(userId);

    return GetUserResponse
            .builder()
            .name(user.getName())
            .surname(user.getSurname())
            .accounts(
                    accounts.stream()
                            .map(account-> {
                                Double sum = transactions.stream()
                                        .filter(transaction -> transaction.getAccountId()==account.getId())
                                        .mapToDouble(transaction -> transaction.getAmount())
                                        .sum();

                                return AccountItemResponse.builder()
                                                .accountId(account.getId())
                                                .balance(sum)
                                                .transactions(
                                                        transactions.stream()
                                                                .filter(transaction -> transaction.getAccountId()==account.getId())
                                                                .map(transaction -> TransactionItemResponse
                                                                        .builder()
                                                                        .id(transaction.getId())
                                                                        .amount(transaction.getAmount())
                                                                        .build())
                                                                .collect(Collectors.toList())
                                                ).build();
                                    }
                                )
                            .collect(Collectors.toList())
            )
            .build();
  }
}
