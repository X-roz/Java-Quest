package notes;

public abstract class AbsNote {

    private final AbsNote next;

    AbsNote(AbsNote note) {
        this.next = note;
    }

    public void count(int amt){
        if (next!=null){
            next.count(amt);
        }
    }
}
