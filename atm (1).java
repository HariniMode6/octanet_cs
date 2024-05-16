import java.util.*;

class atm {
  float balance;
  int pin = 1234;

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
    System.out.println("4.exit");
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();
    if (choice == 1) {
      checkbalance();
    } else if (choice == 2) {
      withdraw();
    } else if (choice == 3) {
      deposit();
    } else if (choice == 4) {
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
    menu();
  }

  public static void main(String[] args) {
    atm obj = new atm();
    obj.balance = 1000;
    obj.checkpin();
  }
}