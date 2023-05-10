package noSpringDi;

public class Controller {

    private final Alphabet alphabet;

    public Controller(Alphabet alphabet) {
        this.alphabet = alphabet;
    }
    public void mainClassName (){
        alphabet.className();
    }

    public static void main(String[] args) {
        Config config = new Config();
        Alphabet instance = config.alphabet();
        Controller controller = new Controller(instance);
        controller.mainClassName();
    }
}
