package com.assigment.controller;

import com.assigment.request.NewAccountRequest;
import com.assigment.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
@AllArgsConstructor
public class AccountController {

  private AccountService accountService;

  @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.OK)
  public void newAccount(@RequestBody NewAccountRequest requestNewAccount) {
    accountService.createAccount(requestNewAccount);
  }
}
