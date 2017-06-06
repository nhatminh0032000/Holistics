package com.lqp.automation.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh Chuong on 13/2/17.
 */
public class Consumer {
    private String email;
    private String password;
    private String dialingCode;
    private String dialingCountryCode;
    private String number;
    private String deviceId;
    private String deviceUID;
    private String deviceModel;
    private String deviceOS;
    private String firstName;
    private String lastName;
    private String newFirstName;
    private String newLastName;
    private String newPassword;
    private String gmailPassword;
    private String idNo;
    private String gender;
    private String birthDate;
    private List<Card> cards;
    private List<Purse> purses;

    public Consumer(){
        this.deviceId = "dd4bc551c59cd9d2f10d205c4c38e5be2e7982534c0c8dd4f820ebaf84cffeb7";
        this.deviceUID = "9860C321-A5BA-4AD9-AA36-98D6BBF15BD7";
        this.deviceModel = "iPhone7";
        this.deviceOS = "iOS 10.2";
        this.gender = "M";
        this.birthDate = "1988-01-05";
    }

    public String getGender() {
        return gender;
    }

    public Consumer setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Consumer setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public void addPurse(Purse purse){
        if(purses==null){
            this.purses = new ArrayList<>();
        }
        purses.add(purse);
    }

    public List<Purse> getPurses() {
        return purses;
    }

    //return the first purse in the list
    public Purse getPurse(){
        return purses.get(0);
    }

    public Consumer setPurses(List<Purse> purses) {
        this.purses = purses;
        return this;
    }

    //return the first card in the list
    public Card getCard(){
        return cards.get(0);
    }

    public void addCard(Card card){
        if(cards==null){
            cards = new ArrayList<>();
        }
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public Consumer setCards(List<Card> cards) {
        this.cards = cards;
        return this;
    }

    public Consumer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Consumer setPassword(String password) {
        this.password = password;
        return this;
    }

    public Consumer setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceUID() {
        return deviceUID;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public String getDeviceOS() {
        return deviceOS;
    }

    public String getFirstName() {
        return firstName;
    }

    public Consumer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Consumer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public Consumer setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
        return this;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public Consumer setNewLastName(String newLastName) {
        this.newLastName = newLastName;
        return this;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public Consumer setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }

    public String getDialingCode() {
        return dialingCode;
    }

    public Consumer setDialingCode(String dialingCode) {
        this.dialingCode = dialingCode;
        return this;
    }

    public String getDialingCountryCode() {
        return dialingCountryCode;
    }

    public Consumer setDialingCountryCode(String dialingCountryCode) {
        this.dialingCountryCode = dialingCountryCode;
        return this;
    }

    public String getGmailPassword() {
        return gmailPassword;
    }

    public Consumer setGmailPassword(String gmailPassword) {
        this.gmailPassword = gmailPassword;
        return this;
    }

    public String getIdNo() {
        return idNo;
    }

    public Consumer setIdNo(String idNo) {
        this.idNo = idNo;
        return this;
    }

    @Override
    public String toString(){
        return this.email;
    }

}
