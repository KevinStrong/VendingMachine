package vendingmachine;

/**
 * @author Kevin
 */
class MoneyManager {
   private int moneyin;
   private int quarter, nickel, dime, onedollar, fivedollar, tendollar, twentydollar;
   private static int minquarter, minnickel, mindime, minonedollar, minfivedollar, mintendollar, mintwentydollar;

   @SuppressWarnings("WeakerAccess")
   public MoneyManager() {
      moneyin = 0;
      quarter = nickel = dime = onedollar = 10;
      fivedollar = tendollar = twentydollar = 5;

      minquarter = minnickel = mindime = minonedollar = 10;
      minfivedollar = mintendollar = 5;
      mintwentydollar = 5;
   }

   protected void buy(int price) {
      moneyin -= price;
   }

   protected void addMoney(String money) {
      System.out.println("The machine accepts a" + money);
      changeMoney(money,1);
   }

   private void removeMoney(String money) {
      System.out.println("The machine returns a " + money);
      changeMoney(money,-1);
   }

   //a 1 for sign will be a deposit, a -1 will be a withdraw.
   private void changeMoney(String money,int sign) {
      switch(money.toLowerCase()) {
         case "quarter":
            moneyin += 25 * sign;
            quarter += sign;
            break;
         case "dime":
            moneyin += 10 * sign;
            dime += sign;
            break;
         case "nickel":
            moneyin += 5 * sign;
            nickel += sign;
            break;
         case "onedollar":
            moneyin += 100 * sign;
            onedollar += sign;
            break;
         case "fivedollar":
            moneyin += 500 * sign;
            fivedollar += sign;
            break;
         case "tendollar":
            moneyin += 1000 * sign;
            tendollar += sign;
            break;
         case "twentydollar":
            moneyin += 2000 * sign;
            twentydollar += sign;
            break;
      }
   }

   protected int getCustomerMoney() {
      return moneyin;
   }

   protected void printOutMoney() {
      int cents = moneyin % 100;
      if(cents % 10 == 0)//Makes sure that last 0 is not implied.
      {
         System.out.println("$" + (moneyin - cents) / 100 + "." + cents + "0");
      }else {
         System.out.println("$" + (moneyin - cents) / 100 + "." + cents);
      }
   }

   protected void returnCustomerMoney() {
      //repeatedly return the largest possible bill
      boolean havechange = true;
      while(moneyin > 0 && havechange) {
         if(moneyin >= 2000 && twentydollar > 0) {
            removeMoney("twentydollar");
         }else if(moneyin >= 1000 && tendollar > 0) {
            removeMoney("tendollar");
         }else if(moneyin >= 500 && fivedollar > 0) {
            removeMoney("fivedollar");
         }else if(moneyin >= 100 && onedollar > 0) {
            removeMoney("onedollar");
         }else if(moneyin >= 25 && quarter > 0) {
            removeMoney("quarter");
         }else if(moneyin >= 10 && dime > 0) {
            removeMoney("dime");
         }else if(moneyin >= 5 && nickel > 0) {
            removeMoney("nickel");
         }else {
            System.out.println("Sorry, I do not have the correct change for you, please contact an employee.");
            havechange = false;
         }
      }
   }

   //Employee Methods.
   protected void removeProfits() {
      while(minquarter < quarter) {
         quarter--;
         System.out.println("A quarter is returned");
      }
      while(minnickel < nickel) {
         nickel--;
         System.out.println("A nickel is returned");
      }
      while(mindime < dime) {
         dime--;
         System.out.println("A dime is returned");
      }
      while(minonedollar < onedollar) {
         onedollar--;
         System.out.println("A one dollar bill is returned");
      }
      while(minfivedollar < fivedollar) {
         fivedollar--;
         System.out.println("A five dollar bill is returned");
      }
      while(mintendollar < tendollar) {
         tendollar--;
         System.out.println("A ten dollar bill is returned");
      }
      while(mintwentydollar < twentydollar) {
         twentydollar--;
         System.out.println("A twenty dollar bill is returned");
      }
   }

   //Used if employee wants to add money back into system.
   protected void restock(String denomination,int amount) {
      switch(denomination.toLowerCase()) {
         case "quarter":
            quarter += amount;
            break;
         case "dime":
            dime += amount;
            break;
         case "nickel":
            nickel += amount;
            break;
         case "onedollar":
            onedollar += amount;
            break;
         case "fivedollar":
            fivedollar += amount;
            break;
         case "tendollar":
            tendollar += amount;
            break;
         case "twentydollar":
            twentydollar += amount;
            break;
         default:
            System.out.println("Unrecognized denomination, please try again");
      }
   }

   protected void viewMachineMoney() {
      System.out.println("In the machine there are:");
      System.out.println(nickel + " nickel(s)");
      System.out.println(dime + " dime(s)");
      System.out.println(quarter + " quarter(s)");
      System.out.println(onedollar + " one dollar bill(s)");
      System.out.println(fivedollar + " five dollar bill(s)");
      System.out.println(tendollar + " ten dollar bill(s)");
      System.out.println(twentydollar + " twenty dollar bill(s)");
   }


}
