

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Laxman
 */

import java.util.*;
public interface ATM1 {
    abstract void customerinfo(String id,String name);
    abstract float deposit(float a);
    abstract float withdrawal(float b);
    abstract void checkbal();
    public static void main(String args[]){
        int ch;
        float a;
        float b;
        Customer1 cust=new Customer1();
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                           Hello user!!! 
                           Welcome to ATM services""");
        System.out.println("Enter Customer Id:");
        String id=sc.nextLine();
        System.out.println("Enter Customer Name:");
        String name=sc.nextLine();
        do{
            System.out.println("""
                               
                               !!! Menu !!!
                           1. Cash Deposit.
                           2. Cash Withdrawal.
                           3. Check Balance.
                           4. Customer Details.
                           5. Exit.
                           """);
        
            System.out.println("Enter your Choice:");
            ch=sc.nextInt();
            switch(ch){
                case 1 -> { 
                    System.out.println("Enter amount you want to deposit:");
                    a=sc.nextInt();
                    cust.deposit(a);
                }
                case 2 -> {
                    System.out.println("Enter amount you want to withdraw:");
                    b=sc.nextInt();
                    cust.withdrawal(b);
                }
                case 3 -> cust.checkbal();
                case 4 -> cust.customerinfo(id,name);
                case 5 -> System.out.println("""
                                       Exit!!!!
                                       Thank You.
                                       If you face any problem,please contact to our Helpline no.""");
                default -> System.out.println("Entered choice is Invalid!!!");
                
            }
        } 
        while(ch!=5);
    }
}
 class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
 }
class Customer1 implements ATM1{
    String id,name;
    float c=0;
    Scanner sc=new Scanner(System.in);
    @Override
    public void customerinfo(String id,String name){
        this.id=id;
        this.name=name;
        System.out.println("Customer Id:"+ id);
        System.out.println("Customer Name:"+ name);

    }
    

    @Override
    public float deposit(float a){
        if(a<0){
            System.out.println("Amount should be enter in positive number.");
        }
        else{
        System.out.println("Amount deposit:" + a);
        c+=a;
        }
        return 0;
    }
    @Override
    public float withdrawal(float b){
        
        try{
            if (b>c){
               throw new InsufficientBalanceException("Insufficient Balance!!!"); 
        }else{
                System.out.println("Amount withdraw:" + b);
                c-=b;
            }
            
        } catch(InsufficientBalanceException e){
            System.out.println("Insufficient Balance!!!");
        }
        return 0;
    }
    @Override
    public void checkbal(){
        System.out.println("Current Balance:" +c);
    }     
}
    





