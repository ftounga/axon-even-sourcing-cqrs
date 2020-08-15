package com.ngconsulting.cqrs.axon.service;

import com.ngconsulting.cqrs.axon.entity.AccountQueryEntity;

import java.util.List;

public interface AccountQueryService {
    public List<Object> listEventsForAccount(String accountNumber);
    public AccountQueryEntity getAccount(String accountNumber);
}
