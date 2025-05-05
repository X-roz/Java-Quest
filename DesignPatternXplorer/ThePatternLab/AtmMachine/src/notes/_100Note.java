package notes;

public class _100Note extends AbsNote {

    public _100Note(AbsNote note) {
        super(note);
    }

    @Override
    public void count(int amt) {

        int n = 100;
        int notesCount = Math.floorDiv(amt,n);
        System.out.println("100  Notes : " + notesCount);
        super.count(amt - (notesCount*n));
    }
}
