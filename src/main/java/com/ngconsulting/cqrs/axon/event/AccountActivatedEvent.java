package com.ngconsulting.cqrs.axon.event;

import com.ngconsulting.cqrs.axon.enumeration.Status;

public class AccountActivatedEvent extends BaseEvent<String> {

    public final Status status;

    public AccountActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }
}
