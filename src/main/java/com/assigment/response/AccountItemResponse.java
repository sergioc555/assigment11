package com.assigment.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountItemResponse {

    private long accountId;
    private double balance;
    private List<TransactionItemResponse> transactions;
}
