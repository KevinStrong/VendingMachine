package vendingmachine;

/**
 * @author Kevin
 */
public class VendingMachine {

   private MoneyManager Monies;
   private Inventory MyInventory;
   private static int SIZE = 10;//Number of slots in the vending machine, hardcoded because the machine can't change size.

   @SuppressWarnings("WeakerAccess")
   public VendingMachine() {
      Monies = new MoneyManager();
      MyInventory = new Inventory(SIZE);
   }

   protected void showInventory() {
      MyInventory.showInventory();
   }

   protected void showCustomerMoney() {
      System.out.print("You have: ");
      Monies.printOutMoney();
   }

   protected void returnChange() {
      Monies.returnCustomerMoney();
   }

   protected void buyItem(String item) {
      //convert String to int
      int loc = MyInventory.itemLoc(item);//Check for item existance
      if(loc == -1 || MyInventory.emptyLocation(loc)) {
         System.out.println("Sorry, I don't have that item");
         return;
      }
      //get price
      int price = MyInventory.getPrice(loc);
      int customermoney = Monies.getCustomerMoney();
      //Compare price
      if(price > customermoney) {
         System.out.println("You don't enter enough money!");
      }else {
         MyInventory.buy(loc);
         Monies.buy(price);
         Monies.returnCustomerMoney();
      }
   }

   protected void putInMoney(String money) {
      Monies.addMoney(money);
   }


   //Employee methods.
   protected void addItem(String name,int price,int quantity) {
      MyInventory.addItem(name,price,quantity);
   }

   protected void restockItem(String name,int quantity) {
      MyInventory.restock(name,quantity);
   }

   protected void removeItem(String name) {
      MyInventory.removeItem(name);
   }

   protected void removeProfits() {
      Monies.removeProfits();
   }

   protected void restockMoney(String denomination,int amount) {
      Monies.restock(denomination,amount);
   }

   protected void viewMachineMoney() {
      Monies.viewMachineMoney();
   }

   protected boolean getPassword(String password) {
      return password.equals("abc");//Change this value to change password.
   }
}
