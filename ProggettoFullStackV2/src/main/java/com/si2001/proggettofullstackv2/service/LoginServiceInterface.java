package com.si2001.proggettofullstackv2.service;

public interface LoginServiceInterface {

    public int check(String emailName, String passwordName);

    public boolean isAdmin(String emailName);

}
