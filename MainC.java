import java.util.Scanner;
public class MainC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carts cart = new Carts();
        Inputter io = new Inputter();
        Displayer display = new Displayer();

        Option opt = new Option(cart, io, display);
        Controller controller = new Controller(sc, opt);
        controller.run();
        sc.close();
    }
}
        /*ordering system management
        
        members: group 5: project 6

        Balondo, Chester P.

        Villena, Chrishien M.

        Mangio Ralph Lui G.

        Ryo Zapanta G.
        */
    
        
       
