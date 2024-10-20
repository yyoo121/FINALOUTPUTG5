import java.util.InputMismatchException;

public class Option implements IOption{
    private Carts cart;
    private Inputter io;
    private Displayer display;

    public Option(Carts cart, Inputter io,Displayer display){
        this.cart = cart;
        this.io = io;
        this.display = display;
    }
    @Override
    public void itemAdder(Order menu){
        display.printMenu(menu);
        int n = io.getItemIndex(menu);
        if (n > 0 && n <= menu.getTotalItems()) {
            Item item = new Item(menu.getItem(n - 1), menu.getPrice(n - 1), 1);
            cart.addItem(item);
            display.printAddedItem(item);
            display.printSelectedItems(cart.getItemList());
        } else {display.printInvalidInput();}}

    @Override
    public void itemRemover() {
        int x = io.getRemovalIndex();
        if (x > 0 && x <= cart.getItemList().size()) {
            cart.removeItem(x - 1);
            System.out.println("Item is removed.");
        } else {display.printInvalidInput();}}

    @Override
    public void itemUpdater() {
        int x = io.getUpdateIndex();
        if (x > 0 && x <= cart.getItemList().size()) {
            cart.updateItem(x - 1, io.getNewQuantity());
            System.out.println("Item is updated successfully.");
        } else {display.printInvalidInput();}}

    @Override
    public void createNewCart(){cart = new Carts(); System.out.println("You created a new cart.");}

    @Override
    public void checkout(){
        System.out.println("Your cart:");
        display.printSelectedItems(cart.getItemList());
        double totalPrice = cart.getTotalPrice();
        System.out.println("Your total bill is: " + totalPrice);
        processPayment(totalPrice);
    }
    private void processPayment(double totalPrice) {
    while (true) {
        try {
            double money = io.getPayment();
            if (money < 0) {display.printExitingCheckout();return;}
            if (money < totalPrice) {display.printInsufficientFunds();}
            else{
                Contact info = io.inputContactInfo();
                display.printReceipt(cart.getItemList(), money, totalPrice, money - totalPrice, info);
                handlePostCheckout();break;
            }
        } catch (InputMismatchException e) {System.out.println("Invalid input"); io.clear();
        }}}
    private void handlePostCheckout(){
        int choice = io.getChoice();
        if (choice == 1) orderAgain();
        else if (choice == 2) System.exit(0);
        else display.printInvalidInput();}
         
    @Override
    public void orderAgain(){cart = new Carts();}}
