package com.ngconsulting.cqrs.axon.service.impl;

import com.ngconsulting.cqrs.axon.command.CreateAccountCommand;
import com.ngconsulting.cqrs.axon.command.CreditMoneyCommand;
import com.ngconsulting.cqrs.axon.command.DebitMoneyCommand;
import com.ngconsulting.cqrs.axon.domain.AccountCreateDTO;
import com.ngconsulting.cqrs.axon.domain.MoneyCreditDTO;
import com.ngconsulting.cqrs.axon.domain.MoneyDebitDTO;
import com.ngconsulting.cqrs.axon.service.AccountCommandService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AccountCommandServiceImpl implements AccountCommandService {

    private final CommandGateway commandGateway;

    public AccountCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(new CreateAccountCommand(UUID.randomUUID().toString(), accountCreateDTO.getStartingBalance(), accountCreateDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(new CreditMoneyCommand(accountNumber, moneyCreditDTO.getCreditAmount(), moneyCreditDTO.getCurrency()));
    }

    @Override
    public CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(new DebitMoneyCommand(accountNumber, moneyDebitDTO.getDebitAmount(), moneyDebitDTO.getCurrency()));
    }
}
