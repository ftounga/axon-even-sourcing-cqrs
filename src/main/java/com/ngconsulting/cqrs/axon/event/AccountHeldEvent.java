package com.ngconsulting.cqrs.axon.event;

import com.ngconsulting.cqrs.axon.enumeration.Status;

public class AccountHeldEvent extends BaseEvent<String> {

    public final Status status;

    public AccountHeldEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
