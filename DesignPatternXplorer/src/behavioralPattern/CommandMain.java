package behavioralPattern;

import java.util.ArrayList;
import java.util.List;

public class CommandMain {

    public static void main(String [] args){

        TextEditor receiver = new TextEditor();
        CommandProcessor sender = new CommandProcessor();

        CommandImpl textProcessor = new CommandImpl(receiver,"Hello");
        CommandImpl textProcessor1 = new CommandImpl(receiver,"World!");
        CommandImpl textProcessor2 = new CommandImpl(receiver,"Welcome to the world of game");

        String res = sender.executeCommand(textProcessor)
                .executeCommand(textProcessor1)
                .executeCommand(textProcessor2)
                .undoCommand()
                .getDataCommand(textProcessor);
        System.out.println("EDITOR RESULT : "+ res);
    }
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
        this.text = this.text.isEmpty() ? this.text + input : this.text + " " + input ;
    }

    public void undoLast(int length){
        int end = text.length() - length;
        if (end>=0){
            text = text.substring(0, end);
        }
        System.out.println("undo action : "+ text);
    }

    public String getText() {
        return text;
    }
}

// Concrete Command Method
class CommandImpl implements Command{

    private final TextEditor textEditor ;
    private final String textToAdd;

    CommandImpl(TextEditor editor , String text) {
        this.textEditor =editor;
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

    public CommandProcessor executeCommand(Command command) {
        command.execute();
        commands.add(command);
        return this;
    }

    public CommandProcessor undoCommand() {
        if(!commands.isEmpty()) {
            Command lastCommand = commands.get(commands.size()-1);
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo");
        }
        return this;
    }

    public String getDataCommand(Command command) {
        return command.getData();
    }
}