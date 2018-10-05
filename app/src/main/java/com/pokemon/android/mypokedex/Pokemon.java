package com.pokemon.android.mypokedex;

import java.util.UUID;

public class Pokemon {
    private String mNumber;
    private String mName;
    private String mHeight;
    private String mWeight;
    private String mCategory;
    private String mHP;
    private String mAttack;
    private String mDefense;
    private String mSpecialAttack;
    private String mSpecialDefense;
    private String mSpeed;
    private UUID uniqueID;

    public Pokemon (String number, String name, String height, String weight, String category, String hp, String attack, String defense, String specialAttack, String specialDefense, String speed ) {
        mNumber = number;
        mName = name;
        mHeight = height;
        mWeight = weight;
        mCategory = category;
        mHP = hp;
        mAttack = attack;
        mDefense = defense;
        mSpecialAttack = specialAttack;
        mSpecialDefense = specialDefense;
        mSpeed = speed;
        uniqueID = UUID.randomUUID();
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        mNumber = number;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getHeight() {
        return mHeight;
    }

    public void setHeight(String height) {
        mHeight = height;
    }

    public String getWeight() {
        return mWeight;
    }

    public void setWeight(String weight) {
        mWeight = weight;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public String getHP() {
        return mHP;
    }

    public void setHP(String HP) {
        mHP = HP;
    }

    public String getAttack() {
        return mAttack;
    }

    public void setAttack(String attack) {
        mAttack = attack;
    }

    public String getDefense() {
        return mDefense;
    }

    public void setDefense(String defense) {
        mDefense = defense;
    }

    public String getSpecialAttack() {
        return mSpecialAttack;
    }

    public void setSpecialAttack(String specialAttack) {
        mSpecialAttack = specialAttack;
    }

    public String getSpecialDefense() {
        return mSpecialDefense;
    }

    public void setSpecialDefense(String specialDefense) {
        mSpecialDefense = specialDefense;
    }

    public UUID getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(UUID uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getSpeed() {
        return mSpeed;
    }

    public void setSpeed(String speed) {
        mSpeed = speed;
    }
}