package notes;

public class _2000Note extends AbsNote {

    public _2000Note(AbsNote note) {
        super(note);
    }

    @Override
    public void count(int amt) {

        int n = 2000;
        int notesCount = Math.floorDiv(amt,n);
        System.out.println("2000  Notes : " + notesCount);
        super.count(amt - (notesCount*n));
    }
}
