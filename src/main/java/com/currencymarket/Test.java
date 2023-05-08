package com.currencymarket;

public class Test {
    public static void main(String[] args) {
//        String s = "Admin";
//        System.out.println(s.matches("[^\s]{5,30}"));
//        String a = "Admin1";
//        System.out.println(a.matches("[^\\d][a-zA-Z\\d]{5,30}"));
        String b = "123123f123132111";
        System.out.println(b.length());
        System.out.println(b.matches("\\d{16}"));
    }
}
