package com.ngconsulting.cqrs.axon.controller;

import com.ngconsulting.cqrs.axon.entity.AccountQueryEntity;
import com.ngconsulting.cqrs.axon.service.AccountQueryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/bank-accounts")
@Api(value = "Account Queries", description = "Account Query Events Endpoint", tags = "Account Queries")
public class AccountQueryController {

    private final AccountQueryService accountQueryService;

    public AccountQueryController(AccountQueryService accountQueryService) {
        this.accountQueryService = accountQueryService;
    }

    @GetMapping("/{accountNumber}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "accountNumber") String accountNumber){
        return accountQueryService.listEventsForAccount(accountNumber);
    }

    @GetMapping("/{accountNumber}")
    public AccountQueryEntity getAccount(@PathVariable(value = "accountNumber") String accountNumber){
        return accountQueryService.getAccount(accountNumber);
    }
}
