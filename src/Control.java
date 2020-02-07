import java.util.Scanner;

public class Control {
    // Instance values
    private Model model;
    private View view;
    private boolean found;
    private int lowerRange;
    private int upperRange;

    // Constructor
    public Control(Model model, View view) {
        this.model  = model;
        this.view = view;
        this.found = false;
        this.lowerRange = 0;
        this.upperRange = 100;
    }
    public void setLowerRange(int lower){
        this.lowerRange = lower;
    }
    public void setUpperRange(int upper){
        this.upperRange = upper;
    }
    public int getLowerRange(){
        return this.lowerRange;
    }
    public int getUpperRange(){
        return this.upperRange;
    }
    public void setFound(boolean fnd){
        this.found = fnd;
    }
    public boolean getFound(){
        return this.found;
    }

    // The Work method
    public void runApplication(){
        Scanner sc = new Scanner(System.in);
        model.saveNumber(inputIntValue(sc));
        while(!found){
             if (checkRange(model.getLastSavedNumber())) {
                 if (compareNumbers(model.getLastSavedNumber())) {
                     found = true;
                     view.printMessage(View.rightInputNumber +model.getAllSavedNumbers());
                 } else {
                     view.printMessage(View.enteredNumbers + model.getAllSavedNumbers());
                     model.saveNumber(inputIntValue(sc));
                 }
             }
             else {
                     model.saveNumber(inputIntValue(sc));
             }
        }
    }

    // The Utility methods
    public int inputIntValue(Scanner sc) {
        view.printMessage(View.inputNumber + this.getLowerRange()+" - "+ this.getUpperRange());
        while( ! sc.hasNextInt()) {
            view.printMessage(View.wrongInputNumber + View.inputNumber+ this.getLowerRange()+" - "+ this.getUpperRange());
            sc.next();
        }
        return sc.nextInt();
    }

    public boolean compareNumbers(int number){
        boolean fnd = false;
        if(number == model.getMagicNumber()){
            fnd = true;
        }
        else if(number > model.getMagicNumber()){
            this.setUpperRange(number);
        }
        else if(number < model.getMagicNumber()){
            this.setLowerRange(number);
        }
        return fnd;
    }
    public boolean checkRange(int number){
        boolean inRange = false;
        if(number > this.getLowerRange() && number < this.getUpperRange()){
            inRange = true;
        }
        return inRange;
    }


}
