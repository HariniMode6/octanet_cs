import java.util.*;

class atm_interface {
  float balance;
  int pin = 1234;
  ArrayList<String> transactions = new ArrayList<>();

  public void checkpin() {
    System.out.println("enter your pin");
    Scanner sc = new Scanner(System.in);
    int enterpin = sc.nextInt();
    if (enterpin == pin) {
      menu();
    } else {
      System.out.println("enter a valid pin!!!");
      checkpin();
    }
  }

  public void menu() {
    System.out.println("enter your choice:");
    System.out.println("1.check balance");
    System.out.println("2.withdraw");
    System.out.println("3.deposit");
    System.out.println("4.transaction history");
    System.out.println("5.exit");
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();
    if (choice == 1) {
      checkbalance();
    } else if (choice == 2) {
      withdraw();
    } else if (choice == 3) {
      deposit();
    } else if (choice == 4) {
      checkTransactions();
    } else if (choice == 5) {
      return;
    } else {
      System.out.println("enter a valid choice:");
    }
  }

  public void checkbalance() {
    System.out.println("your balance is:" + balance);
    menu();
  }

  public void withdraw() {
    System.out.println("enter the amount to withdraw:");
    Scanner sc = new Scanner(System.in);
    float amount = sc.nextFloat();
    if (amount < balance) {
      balance = balance - amount;
      System.out.println("collect your cash");
      transactions.add("Withdrawal: Rs " + amount);
      menu();
    } else {
      System.out.println("insufficient balance");
      menu();
    }
  }

  public void deposit() {
    System.out.println("enter the amount to deposit:");
    Scanner sc = new Scanner(System.in);
    float amount = sc.nextFloat();
    balance = balance + amount;
    System.out.println("your deposit is successful");
    transactions.add("Deposit: Rs " + amount);
    menu();
  }

  public void checkTransactions() {
    System.out.println("Transaction History:");
    for (String transaction : transactions) {
      System.out.println(transaction);
    }
    menu();
  }

  public static void main(String[] args) {
    atm_interface obj = new atm_interface();
    obj.balance = 1000;
    obj.checkpin();
  }
}
