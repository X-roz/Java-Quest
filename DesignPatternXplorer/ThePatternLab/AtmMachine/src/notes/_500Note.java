package notes;

public class _500Note extends AbsNote{


    public _500Note(AbsNote note) {
        super(note);
    }

    @Override
    public void count(int amt) {

        int n = 500;
        int notesCount = Math.floorDiv(amt,n);
        System.out.println("500  Notes : " + notesCount);
        super.count(amt - (notesCount*n));
    }
}
