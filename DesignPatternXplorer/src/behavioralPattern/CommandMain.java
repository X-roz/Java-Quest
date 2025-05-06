package behavioralPattern;

public class CommandMain {
}

interface Command{
    void execute();
    void undo();
}

// Receiver
class TextEditor {
    String text = "";

    public void addText(String input){
        System.out.println("Adding text");
        this.text = this.text +" "+ input;
    }

    public void undoLast(int length){
        System.out.println("Undoing last action");
        int end = text.length() - length;
        if (end>=0){
            text = text.substring(0, end+1);
        }
    }

    public String getText() {
        return text;
    }
}

// Concrete Command Method
class CommandImpl implements Command{

    private final TextEditor textEditor = new TextEditor();
    private final String textToAdd;

    CommandImpl(String text) {
        this.textToAdd = text;
    }

    @Override
    public void execute() {
        textEditor.addText(textToAdd);
    }

    @Override
    public void undo() {
        textEditor.undoLast(textToAdd.length());
    }
}
