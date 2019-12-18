package hw_streams;

/**
 * Created by Bilous M. 18.12.2019
 */
public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.processUser();
    }
}
