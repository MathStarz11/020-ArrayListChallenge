package com.christodd;

import java.util.ArrayList;


public class Contacts {
    //Declared Member Variables;
    private  ArrayList<String> name = new ArrayList<String>();
    private  ArrayList<Integer> number = new ArrayList<Integer>();

    //Methods

    //Store Name and Number
    public void addNameNumber(String name, int number) {
        this.name.add(name);
        this.number.add(number);
    }

    public void printContactList() {
        System.out.println("You have " + name.size() + " contacts in your phone.");
        for(int i = 0; i < name.size(); i++) {
            System.out.println("Contact " + (i+1) + ": " + name.get(i) + " " + number.get(i));
        }
    }

    public int getNumberOfName(String name) {
        int position = findName(name);
        return number.get(position);
    }

    public void modifyName(String currentName, String newName) {
        int position = findName(currentName);
        if(position >= 0)
            modifyName(position, newName);

    }

    private void modifyName(int position, String newName) {
        name.set(position, newName);
        System.out.println("Contact name " + (position+1) + " has been modified.");
    }

    public void modifyNumber(int currentNumber, int newNumber) {
        int position = findNumber(currentNumber);
        if(position >= 0)
            modifyNumberNow(position, newNumber);
    }

    private void modifyNumberNow(int position, int newNumber) {
        number.set(position, newNumber);
        System.out.println("Contact number " + (position+1) + " has been modified.");
    }

    private void removeByName(int position) {
//        String theName = name.get(position);
        name.remove(position);
    }

    public void removeByName(String name) {
        int position = findName(name);
        if(position >= 0){
            removeByName(position);
            removeByNumberNow(position);
        }
    }

    private void removeByNumberNow(int position) {
//        int theNumber = number.get(position);
        number.remove(position);
    }

//    public void removeByNumber(int number) {
//        int position = findNumber(number);
//        if(position >= 0){
//            removeByName(position);
//            removeByNumberNow(position);
//        }
//    }

    private int findName(String searchName) {
        return name.indexOf(searchName);
    }

    public boolean findNameFound(String searchName) {
        int position = findName(searchName);

        if(position >= 0) {
            return true;
        }

        return false;
    }

    private int findNumber(int searchNumber) {
        return number.indexOf(searchNumber);
    }

    public boolean findNumberFound(int searchNumber) {
        int position = findNumber(searchNumber);

        if(position >= 0) {
            return true;
        }

        return false;
    }

}
