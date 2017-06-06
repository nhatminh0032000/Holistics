package com.lqp.automation.model;


/**
 * Created by Thanh Chuong on 14/3/17.
 */
public class Card {
    private String cardGUID;
    private String name;
    private String cardNo;
    private String expiry;
    private String cvv;
    private String currency;
    private String cardType;
    private String cardBrand;
    private String defaultCard;
    private String issueBank;
    private String color;
    private String cardCategory;

    public Card(){
        this.color="OrangeDawn";
    }

    public String getName() {
        return name;
    }

    public String getCardGUID() {
        return cardGUID;
    }

    public Card setCardGUID(String cardGUID) {
        this.cardGUID = cardGUID;
        return this;
    }

    public Card setName(String name) {
        this.name = name;
        return this;
    }

    public String getCardNo() {
        return cardNo;
    }

    public Card setCardNo(String cardNo) {
        this.cardNo = cardNo;
        return this;
    }

    public String getExpiry() {
        return expiry;
    }

    public Card setExpiry(String expiry) {
        this.expiry = expiry;
        return this;
    }

    public String getCvv() {
        return cvv;
    }

    public Card setCvv(String cvv) {
        this.cvv = cvv;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Card setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCardType() {
        return cardType;
    }

    public Card setCardType(String cardType) {
        this.cardType = cardType;
        return this;
    }

    public String getCardBrand() {
        return cardBrand;
    }

    public Card setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
        return this;
    }

    public String getDefaultCard() {
        return defaultCard;
    }

    public Card setDefaultCard(String defaultCard) {
        this.defaultCard = defaultCard;
        return this;
    }

    public String getIssueBank() {
        return issueBank;
    }

    public Card setIssueBank(String issueBank) {
        this.issueBank = issueBank;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Card setColor(String color) {
        this.color = color;
        return this;
    }

    public String getCardCategory() {
        return cardCategory;
    }

    public Card setCardCategory(String cardCategory) {
        this.cardCategory = cardCategory;
        return this;
    }

    @Override
    public String toString(){
        return cardNo;
    }
}
