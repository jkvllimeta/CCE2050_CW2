/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw2;

/**
 *
 * @author M00607647
 */
public class BankAccount {
    
    private long accountNo;
    private double accountBalance;
    
    public BankAccount(long accountNo, double accountBalance){
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }
    
    public long getAccountNo(){
        return this.accountNo;
    }
    
    public double getAccountBalance(){
        return this.accountBalance;
    }
    
    public void deposit (double value, User u){
        System.out.println(u + " is depositing £" + value);
        this.accountBalance = this.accountBalance + value;
        System.out.println("Deposit successful.");
        System.out.println("The current account balance is " + this.accountBalance);
    }
    
    public void withdraw(double value, User u){
        System.out.println(u + " is withdrawing £" + value);
        if (this.accountBalance >= value){
            this.accountBalance = this.accountBalance - value;
            System.out.println(value + " withdrawn from the account");
            System.out.println("The current account balance is " + this.accountBalance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    
}
