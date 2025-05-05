import notes.*;

public class AtmMachine {
    public static void main(String[] args) {
        AbsNote notes =  new _2000Note(new _500Note(new _100Note(null)));
        notes.count(5350);
    }
}