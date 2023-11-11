package com.yanisdib.nintendostore.user;

import com.yanisdib.nintendostore.aggregates.Birthdate;
import com.yanisdib.nintendostore.aggregates.Email;
import com.yanisdib.nintendostore.aggregates.FullName;
import org.springframework.data.mongodb.core.mapping.MongoId;

public class User {

    @MongoId private String id;

    private FullName fullname;
    private Email email;
    private Birthdate birthdate;

}
