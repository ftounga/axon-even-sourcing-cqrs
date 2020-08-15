package com.ngconsulting.cqrs.axon.repository;

import com.ngconsulting.cqrs.axon.entity.AccountQueryEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountQueryEntity, String> {
}
