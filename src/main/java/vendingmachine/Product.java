package vendingmachine;

/**
 * @author Kevin
 */
class Product {
   private int price;
   private int quantity;
   private String name;

   Product(String name,int price,int quantity) {
      this.name = name;
      this.price = price;
      this.quantity = quantity;
   }

   protected String getName() {
      return name;
   }

   protected int getQuantity() {
      return quantity;
   }

   protected int getPrice() {
      return price;
   }

   protected boolean inStock() {
      return quantity > 0;
   }

   protected void buy() {
      quantity--;
   }

   //Employee Methods
   protected void setPrice(int newprice) {
      price = newprice;
   }

   protected void restock(int ammount) {
      quantity += ammount;
   }
}
