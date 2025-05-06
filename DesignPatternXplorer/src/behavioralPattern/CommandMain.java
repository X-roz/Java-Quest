package behavioralPattern;

import java.util.ArrayList;
import java.util.List;

public class CommandMain {
}

interface Command{
    void execute();
    void undo();
    String getData();
}

// Request Receiver
class TextEditor {
    String text = "";

    public void addText(String input){
        System.out.println("Adding text : " + input);
        this.text = this.text +" "+ input;
    }

    public void undoLast(int length){
        int end = text.length() - length;
        if (end>=0){
            text = text.substring(0, end+1);
        }
        System.out.println("undo action : "+ text);
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

    @Override
    public String getData() {
        return textEditor.getText();
    }
}

// Request Sender
class CommandProcessor {

    private final List<Command> commands = new ArrayList<>();

    public void executeCommand(Command command) {
        command.execute();
        commands.add(command);
    }

    public void undoCommand(Command command) {
        if(!commands.isEmpty()) {
            Command lastCommand = commands.get(commands.size()-1);
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo");
        }
    }
}