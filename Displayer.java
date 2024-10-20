import java.util.LinkedList;
public class Displayer {
    public void printMenu(Order menu) {
    System.out.println("------------------------------------------------------------");
    System.out.println("\tMenu");
        for (int x = 0; x < menu.getTotalItems(); x++){
            System.out.println("["+(x + 1)+ "] " +menu.getItem(x)+" --- P "+menu.getPrice(x));
    }
    System.out.println("------------------------------------------------------------");
    }
    public void printAddedItem(Item item){System.out.println("\nYou added: "+item.getName()+" --- P "+item.getPrice());
    }
    public void printSelectedItems(LinkedList<Item> items){ System.out.println("\nYou selected the following items: ");

                for (int x = 0; x < items.size(); x++)
                {System.out.println("["+(x + 1)  +
                "] " + items.get(x).getName()+
                " --- Quantity: "+items.get(x).getQuantity()+
                " --- Price: "+items.get(x).getTotalPrice());
                }
            }
    public void printReceipt(LinkedList<Item> items, double money, double totalPrice, double change, Contact info){

        System.out.println("----------------------------------------------------");
        System.out.println("     Cyber Grab Ordering Application     ");
        System.out.println("              Receipt:                 ");
        System.out.println("Customer name             : "+ info.getUserName());
        System.out.println("Customer No#              : "+ info.getContactNumber());
        System.out.println("Customer Email            : "+ info.getEmail());
        System.out.println("Customer Delivery Address : "+ info.getDeliveryAddress());
        System.out.println();
        System.out.println("ITEMS:");
        for (int x =0;x<items.size();x++) {
            System.out.println("["+(x+1)+"] "+items.get(x).getName()+
                            " --- Quantity: "+items.get(x).getQuantity()+
                            " --- Price: "+items.get(x).getTotalPrice());
                }
            System.out.println("\nMoney: "+money);
            System.out.println("Total: "+totalPrice);
            System.out.println("Change: "+change);
            System.out.println();

            DeliveryTime dt = new DeliveryTime();
            String deliveryTime = dt.getRandomDeliveryTime();
            System.out.println(deliveryTime);
            System.out.println("Thank you for Ordering at Cyber Grab");
            System.out.println("---------------------------------------------------");

            Receipttxt receiptFileHandler = new Receipttxt();
            receiptFileHandler.saveReceipt(items, money, totalPrice, change, info);
        }
    
    public void printInvalidInput(){System.out.println("Invalid input.");}
    public void printInsufficientFunds(){System.out.println("You don't have enough money. Please try again.");}
    public void printExitingCheckout(){System.out.println("Exiting checkout...");}
    public void printExit(){System.out.println("exit");
}}
