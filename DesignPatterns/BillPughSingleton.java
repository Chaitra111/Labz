package com.bridgelabz.DesignPatterns;

public class BillPughSingleton {

private BillPughSingleton(){}
    
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
    public static void main(String[] args) {
    	BillPughSingleton es= getInstance();
    	System.out.println(es);
}
}