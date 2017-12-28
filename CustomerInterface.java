package vendingmachine;

import java.util.Scanner;

/**
 *
 * @author Kevin
 */
public class CustomerInterface {
    
     
    public static void main(String[] args) 
    {
    VendingMachine MyVendingMachine = new VendingMachine();
    //Stocking the vending machine
    MyVendingMachine.addItem("Potato", 100, 2);
    MyVendingMachine.addItem("Liver", 200,6);
    MyVendingMachine.addItem("Steak",250,5);
    MyVendingMachine.addItem("M&Ms",300,10);    
    showCommands();
    
    //Keyboard input
    String input = "";
    while(!input.equals("exit"))
    {    
    MyVendingMachine.showCustomerMoney();
    input = getinput("Please enter a command");

           if(input.substring(0,3).equals("buy"))//Handles the special buy case.
           {
               input = input.substring(4);//Removes buy from the string
               MyVendingMachine.buyItem(input);//buys the item
           }
           else
           {
               switch (input)
               {
               case "exit":
                   break;
               case "show inventory":
                   MyVendingMachine.showInventory();
                   break;
               case "show commands":
                   showCommands();
                   break;
               case "returnchange":
                   MyVendingMachine.returnChange();
                   break;
               case "quarter":
                   MyVendingMachine.putInMoney(input);                
                   break;
               case "dime":
                   MyVendingMachine.putInMoney(input);
                   break;
               case "nickel":
                   MyVendingMachine.putInMoney(input);
                   break;
               case "onedollar":
                   MyVendingMachine.putInMoney(input);
                   break;
               case "fivedollar":
                   MyVendingMachine.putInMoney(input);
                   break;
               case "tendollar":
                   MyVendingMachine.putInMoney(input);
                   break;
               case "twentydollar":
                   MyVendingMachine.putInMoney(input);
                   break;
               case "employeemode":
                   if(MyVendingMachine.getPassword(getinput("Please enter password (abc)")))
                   {
                       while(!input.equals("leave"))
                       {
                       int price, quantity;
                       String name;
                       switch(getinput("Enter an employeemode command"))
                       {
                           case "show commands":
                               showEmplyeeCommands();
                               break;
                           case "get profits":
                               MyVendingMachine.removeProfits();
                               break;
                           case "remove item":
                               name = getinput("Remove which item");
                               MyVendingMachine.removeItem(name);
                               break;
                           case "add item":
                               name = getinput("Enter item name");
                               price = Integer.parseInt(getinput("Enter item price in CENTS"));
                               quantity = Integer.parseInt(getinput("Enter quantity"));
                               MyVendingMachine.addItem(name, price,quantity);
                                break;
                           case "restockmoney":
                               name = getinput("Enter denomination");
                               price = Integer.parseInt(getinput("Enter number added"));
                               MyVendingMachine.restockMoney(name, price);
                               break;
                           case "restockitem":
                               name = getinput("Enter item name");
                               price = Integer.parseInt(getinput("Enter amount added"));
                               MyVendingMachine.restockItem(name, price);
                               break;
                           case "viewmachinemoney":
                               MyVendingMachine.viewMachineMoney();
                               break;
                           case "exit":
                               input = "leave";
                               break;
                       }
                       }
                   }
               else
                   {
                       System.out.println("Sorry that was the wrong password");
                   }
            }
           }
    }
    }

    private static String getinput(String context) 
    {
        System.out.println(context);
        Scanner inputscanner = new Scanner (System.in);
        return inputscanner.nextLine().toLowerCase();       
    }

    private static void showEmplyeeCommands() 
    {
        System.out.println("Available Employee commands are:");
        System.out.println("Show Commands : Shows this message");
        System.out.println("get profits: Shows available items");
        System.out.println("remove item: removes an item from inventory");
        System.out.println("add item: Adds a new item to inventory");
        System.out.println("restock item: Increases amout of avaliable items");
        System.out.println("restock money: Adds more money to machine");
        System.out.println("view machine money: view money in machine");
        System.out.println("Exit: Exit Vending Machine");
    }

    private static void showCommands() 
    {
        System.out.println("Available commands are:");
        System.out.println("Show Commands : Shows this message");
        System.out.println("Show inventory : Shows available items");
        System.out.println("Exit: Exit Vending Machine");
        System.out.println("nickel, dime, quarter, onedollar, fivedollar, tendollar, twentydollar: Adds listed amout to machine");
        System.out.println("Buy \"item\" (No quotes): buys listed item");
        System.out.println("ReturnChange: returns money");
    }
}
