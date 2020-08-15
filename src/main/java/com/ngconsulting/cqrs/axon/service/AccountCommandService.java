package com.ngconsulting.cqrs.axon.service;

import com.ngconsulting.cqrs.axon.domain.AccountCreateDTO;
import com.ngconsulting.cqrs.axon.domain.MoneyCreditDTO;
import com.ngconsulting.cqrs.axon.domain.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {

    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}
