package com.example.protobuf;

import com.example.models.Credential;
import com.example.models.Credentials;
import com.example.models.EmailCredentials;
import com.example.models.PhoneOTP;

public class OneOfDemo {
    public static void main(String[] args) {
        EmailCredentials emailCredentials = EmailCredentials
                .newBuilder()
                .setEmail("test@test.com")
                .setPassword("test1234")
                .build();

        PhoneOTP phoneOTP = PhoneOTP
                .newBuilder()
                .setNumber(1933211232)
                .setCode(123456)
                .build();

        Credential credential = Credential
                .newBuilder()
                .setEmailMode(emailCredentials)
                .build();

        Credential phoneCredential = Credential
                .newBuilder()
                .setPhoneMode(phoneOTP)
                .build();

        login(credential);
        login(phoneCredential);

    }

    public static void login(Credential credentials){

        switch(credentials.getModeCase()){
            case EMAILMODE:
                System.out.println("EmailMode -> " + credentials.getEmailMode());
                break;
            case PHONEMODE:
                System.out.println("PhoneMode -> " + credentials.getPhoneMode());
                break;
            case MODE_NOT_SET:
                System.out.println("No mode set!");
        }
        System.out.println("Last -> " + credentials);
    }
}
