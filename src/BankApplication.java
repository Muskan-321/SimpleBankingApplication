import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class BankDetails{
    private String name;
    private String accNum;
    private String accType;
    private long balance;
    Scanner sc = new Scanner(System.in);

  //Method to open a account
    public void openAccount(){
        System.out.println("Enter account number: ");
        accNum = sc.next();
        System.out.println("Enter account type: ");
        accType = sc.next();
        System.out.println("Enter Name: ");
        name = sc.next();
        System.out.println("Enter balance: ");
        balance = sc.nextLong();

    }

    public void showAccount(){
        System.out.println("Name of account holder: "+name);
        System.out.println("Account no. : "+accNum);
        System.out.println("Account type: "+accType);
        System.out.println("Balance: "+balance);

    }
    //method to deposit amount
    public void deposit(){
        long amt;
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance = balance + amt;
    }
    //method to withdraw money
    public void withdraw(){
        long amt;
        System.out.println("Enter the amount you want to withdraw: ");
        amt  = sc.nextLong();
        if(balance >= amt){
            balance = balance-amt;
            System.out.println("Balance after withdraw: "+balance);
        }else{
            System.out.println("Your balance is than "+amt+ "\tTransaction failed...!!");
        }
    }
    //method to search an account number
    public boolean search(String acc_no){
        if(acc_no.equals(accNum)){
            showAccount();
            return true;
        }
        return false;
    }
}
public class BankApplication {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         //create initial accounts
        System.out.println("How many number of customers do you want to input?");
        int n = sc.nextInt();
        BankDetails[] C = new BankDetails[n];
        for(int i=0; i<C.length; i++){
            C[i] = new BankDetails();
            C[i].openAccount();
        }

        int ch;
        do{
            System.out.println("\n ***banking System Application***");
            System.out.println("1. Display all account details\n 2.Search by Account\n 3. Deposit the amount\n 4. Withdraw the amount\n 5.Exit ");
            System.out.println("Enter  your choice: ");
            ch = sc.nextInt();
            switch(ch){
                case 1:
                    for(int i=0; i<C.length; i++){
                        C[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.println("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for(int i=0; i<C.length; i++){
                        found = C[i].search(ac_no);
                        if(found){
                            break;
                        }
                    }
                 if(!found){
                     System.out.println("Search failed! Account doesn't exist..!!");
                 }
                 break;
                case 3:
                    System.out.println("Enter account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for(int i=0; i<C.length; i++){
                        found =C[i].search(ac_no);
                        if(found){
                            C[i].deposit();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed! Account doesn't exist...!!");
                    }
                    break;

                case 4:
                    System.out.println("Enter account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for(int i=0; i<C.length; i++){
                        found = C[i].search(ac_no);
                        if(found){
                            C[i].withdraw();
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;

                case 5:
                    System.out.println("Exit.");
            }
        }
        while(ch!=5);
    }
}