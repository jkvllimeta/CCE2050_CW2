/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050.cw2;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Joseph
 */
public class CCE2050CW2 extends Thread implements Runnable{
    
   public static Scanner s = new Scanner(System.in);
   
   public static double[] userTransactions[] =  {
       {50,10,-20,10,-20,20,10,50,-10,10,-10,50},
       {20,20,-20,50,-20,10,50,50,-20,10,10},
       {50,10,10,-10,-10,50,20,10,20},
       {50,10,-20,20,10,-20}
   };
   
   public static BankAccount simAccount = new BankAccount();
   
   public static ArrayList<transactionRun> transactionThreads = new ArrayList<transactionRun>();
   
   public static transactionRun saulGoodmanThread;
   public static transactionRun walterWhiteThread;
   public static transactionRun jessiePinkmanThread;
   public static transactionRun hankSchraderThread;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        while(true){
        Menu();
        }
        
    }
    
    public static void Menu () {
        
        char choice1;
        
        System.out.println("Enter the number of the action you wish to perform:");
        System.out.println("1. Create Bank Account");
        System.out.println("2. Create User");
        System.out.println("3. Run Simulation");
        System.out.println("4. Exit");
        
        choice1 = s.next().charAt(0);
        System.out.println(choice1);
        
        
        switch(choice1){
            case '1':
                createBankAccount();
                Menu();
                break;
            
            case '2':
                createUser();
                break;
            
            case '3':
                
                //saulGoodmanThread.start();
                //walterWhiteThread.start();
                //jessiePinkmanThread.start();
                //hankSchraderThread.start();
                
                //Menu();
                for (transactionRun tThread : transactionThreads){
                tThread.start();
                }
                
                break;
                
            case '4':
                System.exit(0);
        }   
        
        Menu();
        
    }
    
    public static void createUser(){
        
        char ch2;
        char ch3;
        
        System.out.println("Would you like to create a preset User or make a custom User?");
        System.out.println("1. Create preset User");
        System.out.println("2. Create custom User");
        System.out.println("3. Go back to Main Menu");
        System.out.println("4. Exit Program");
        ch2 = s.next().charAt(0);
        
        switch(ch2){
            case '1':
                System.out.println("Choose the accounts you wish to create");
                System.out.println("1. Create Saul Goodman");
                System.out.println("2. Create Walter White");
                System.out.println("3. Create Jessie Pinkman");
                System.out.println("4. Create Hank Schrader");
                
                ch3 = s.next().charAt(0);
                
                switch(ch3){
                    case '1':
                        User sGoodman = new User("Saul", "Goodman", simAccount, userTransactions[0]);
                        saulGoodmanThread = new transactionRun(sGoodman);
                        System.out.println("User " + sGoodman.getName() + " " + sGoodman.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(saulGoodmanThread);
                        break;
                    
                    
                    
                    case '2':
                        
                        User wWhite = new User("Walter", "White", simAccount, userTransactions[1]);
                        walterWhiteThread = new transactionRun(wWhite);
                        System.out.println("User " + wWhite.getName() + " " + wWhite.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(walterWhiteThread);
                        break;
                        
                    case '3':
                        
                        User jPinkman = new User("Jessie", "Pinkman", simAccount, userTransactions[2]);
                        jessiePinkmanThread = new transactionRun(jPinkman);
                        System.out.println("User " + jPinkman.getName() + " " + jPinkman.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(jessiePinkmanThread);
                        break;
                        
                    case '4':
                        
                        User hSchrader = new User("Hank", "Schrader", simAccount, userTransactions[3]);
                        hankSchraderThread = new transactionRun(hSchrader);
                        System.out.println("User " + hSchrader.getName() + " " + hSchrader.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(hankSchraderThread);
                        break;
                }   
                
                createUser();
        }
    }
    
    public static void createBankAccount(){
        
        long newAcctNo;
        double newAcctBal;
        
        char ch4;
        
        System.out.println("Would you like to create a preset or custom Bank Account?");
        System.out.println("1. Create preset Bank Account");
        System.out.println("2. Create custom Bank Account");
        System.out.println("3. Go back to Main Menu");
        System.out.println("4. Exit Program");
        ch4 = s.next().charAt(0);
        
        switch(ch4){
            
            case '1':
                simAccount.createAccount();
                System.out.println("Bank Account successfully created");
                
                break;
                
                
            case '2':
                System.out.println("Please enter a 9 digit Bank Account Number: ");
                newAcctNo = s.nextLong();
                
                System.out.println("Please enter Bank Account Balance: ");
                newAcctBal = s.nextDouble();
                
                System.out.println("Bank Account with Account No. " + newAcctNo + " containing " + newAcctBal + " created successfully.");
                
                break;
                
            case '3':
                Menu();
                break;
                
            case '4':
                System.exit(0);
                
        }
            
        createBankAccount();
        
    }
    
}
