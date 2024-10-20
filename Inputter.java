import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputter implements IInputter {
    private Scanner sc = new Scanner(System.in);
    
            
    @Override
    public int getItemIndex(Order menu) {
    int x = -1; boolean valid = false; 
    while (!valid){
        try{
            System.out.println("Enter the item you want to add [use index]: ");x = sc.nextInt();valid = true;     
        }catch(InputMismatchException e){
            System.out.println("Invalid input! Please enter a number!"); sc.nextLine();}
        }return x;
}

    @Override
    public int getRemovalIndex(){
        int x = -1; boolean valid = false;
        while(!valid){
            try{
                System.out.println("Enter the index of the item you want to remove: ");return sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Invalid Input! Please enter a number");sc.nextLine();
            }}return x;}
    @Override
    public int getUpdateIndex(){
        int x = -1; boolean valid = false;
        while(!valid){
            try{
                System.out.println("Enter the index of the item that will update/change quantity: ");return sc.nextInt();
            }catch(InputMismatchException e){ System.out.println("Invalid Input! Please enter a number");sc.nextLine();
            }} return x;}

    @Override
    public int getNewQuantity(){int x = -1; boolean valid = false;
        while(!valid){
            try{
                System.out.println("Type new quantity: ");return sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Invalid Input! Please enter a number");sc.nextLine();
            }}return x;}
    @Override
    public double getPayment(){System.out.println("Enter your money: "); return sc.nextDouble();}
    
    @Override
    public int getChoice(){
        int x = -1; boolean valid = false;
        while(!valid){
            try{
                System.out.println("[1] order again]\n[2] exit now: ");return sc.nextInt();
            }catch(InputMismatchException e){ System.out.println("Invalid Input! Please enter a number");sc.nextLine();
            }} return x;}
    
    public void clear(){if (sc.hasNextLine()) {sc.nextLine();}}

    public Contact inputContactInfo() {
        sc.nextLine();
        System.out.println("\n[Enter your Delivery Information to successfully order]");
        System.out.println("Enter your name: ");
        String Username = sc.nextLine();
        
        System.out.println("Enter your contact number: ");
        String contactNumber = sc.nextLine(); 
        
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        
        System.out.println("Enter your delivery address: ");
        String deliveryAddress = sc.nextLine();

        return new Contact(Username, contactNumber, email, deliveryAddress);
    }
}
    
