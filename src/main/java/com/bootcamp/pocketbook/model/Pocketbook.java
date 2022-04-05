package com.bootcamp.pocketbook.model;

import org.springframework.data.annotation.Id;

public class Pocketbook {
    @Id
    private String id;

    private String type_docuemnt;
    private String imei;
    private String email;
    private String number_account;

}
