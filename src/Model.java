import java.util.ArrayList;
import java.util.Random;

public class Model {
    private Random rd;
    private int magicNumber;
    private ArrayList<Integer> enteredNumbers;

    public Model() {
        rd = new Random();
        magicNumber = rd.nextInt(100);
        enteredNumbers = new ArrayList<>();
    }

    public int getMagicNumber(){
        return this.magicNumber;
    }

    public void saveNumber(int number){
        this.enteredNumbers.add(number);
    }

    public int getLastSavedNumber(){
        return this.enteredNumbers.get(enteredNumbers.size()-1);
    }
    public String getAllSavedNumbers(){
        return this.enteredNumbers.toString();
    }
}
