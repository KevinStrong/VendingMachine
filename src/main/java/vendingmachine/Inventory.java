package vendingmachine;

import java.text.DecimalFormat;

/**
 * @author Kevin
 */
class Inventory {
   private Product[] inventory;
   private static int SIZE;
   private int numofitems;
   private DecimalFormat decFor = new DecimalFormat("$0.00");


   @SuppressWarnings("WeakerAccess")
   protected Inventory(int size) {
      inventory = new Product[size];
      numofitems = 0;
      SIZE = size;
   }

   //Only prints out items that are instock.
   protected void showInventory() {
      for(int i = 0;i < SIZE;i++) {
         if(inventory[i] != null && inventory[i].inStock()) {
            double price = inventory[i].getPrice();
            System.out.println(
                  inventory[i].getName() + " costs " + decFor.format(price / 100) + " and there are " + inventory[i].getQuantity() +
                        " of them.");
         }
      }
   }

   //Returns -1 if no empty slot.  Always find lowest numbered slot
   //returns the position of the item, returns -1 if it does not exist
   protected int itemLoc(String name) {
      Product itor;
      for(int i = 0;i < SIZE;i++) {
         itor = inventory[i];
         if(itor != null && itor.getName().equals(name)) {
            return i;
         }
      }
      return -1;
   }

   //returns false if item does not exist
   protected boolean buy(int loc) {
      if(loc < 0 || loc >= SIZE || inventory[loc] == null) {
         return false;
      }
      if(emptyLocation(loc)) {
         System.out.println("Sorry item is out of stock");
         return false;
      }
      inventory[loc].buy();
      System.out.println(inventory[loc].getName() + " has been bought!");
      return true;
   }

   //does not check for valid location.
   protected int getPrice(int loc) {
      if(inventory[loc] != null) {
         return inventory[loc].getPrice();
      }
      return 30000;
   }

   protected boolean emptyLocation(int loc) {
      return inventory[loc] == null || !inventory[loc].inStock();
   }

   //Employee methods
   protected boolean addItem(String name,int price,int quantity) {
      //Find an empty slot
      int slot = emptySlot();
      if(slot == -1) {
         System.out.println("Sorry machine is full");
         return false;
      }else {
         Product newproduct = new Product(name.toLowerCase(),price,quantity);
         inventory[slot] = newproduct;
         numofitems++;
         return true;
      }
   }

   private int emptySlot() {
      for(int i = 0;i < SIZE;i++) {
         if(inventory[i] == null) {
            return i;
         }
      }
      return -1;
   }

   protected void restock(String name,int quantity) {
      int loc = itemLoc(name);
      if(loc != -1) {
         inventory[loc].restock(quantity);
      }else {
         System.out.println("That item does not exist!");
      }
   }

   protected void removeItem(String name) {
      int loc = itemLoc(name.toLowerCase());
      if(loc != -1) {
         inventory[loc] = null;
      }else {
         System.out.println("That item could not be removed because it does not exist");
      }
   }
}
