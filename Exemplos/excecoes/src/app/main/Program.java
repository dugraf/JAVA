package main;

import input.Input;
import model.entities.Account;
import model.exceptions.WithdrawException;

public class Program
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Enter account data");
            int number = Input.inputInt("Number:");
            String holder = Input.inputString("Holder:");
            double balance = Input.inputDouble("Initial balance:");
            double withdrawLimit = Input.inputDouble("Withdraw limit:");

            Account account = new Account(number, holder, balance, withdrawLimit);
            double withdraw = Input.inputDouble("Enter amount for withdraw:");
            account.withdraw(withdraw);
            System.out.println("New balance: " +account.getBalance());
        }
        catch (WithdrawException e)
        {
            System.out.println("WithdrawException: " +e.getMessage());
        }
    }
}