public class Main {
    public static void main(String[] args){
        // Initialization
        Model model = new Model();
        View view = new View();
        Control controller = new Control(model, view);
        // Run
        controller.runApplication();
    }

}
