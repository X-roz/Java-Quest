import java.util.ArrayList;
import java.util.List;

public abstract class TicketHandler {

    private final List<TicketResponse> ticketResponseFromEachTeam = new ArrayList<>();

    private final TicketHandler nextHandler;

    TicketHandler(TicketHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public TicketResponse handleTicketRequest(String inputTicketDetails) {
        if(nextHandler != null){
            this.ticketResponseFromEachTeam.add(nextHandler.handleTicketRequest(inputTicketDetails));
        }
        return null;
    }

    public List<TicketResponse> getTicketResponseFromEachTeam() {
        return ticketResponseFromEachTeam;
    }
}
