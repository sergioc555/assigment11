package com.assigment.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NewAccountRequest {

    private long customerId;
    private double initialCredit;
}
