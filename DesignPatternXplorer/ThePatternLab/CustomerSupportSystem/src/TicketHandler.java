import java.util.ArrayList;
import java.util.List;

public abstract class TicketHandler {

    private final TicketHandler nextHandler;

    TicketHandler(TicketHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleTicketRequest(String inputTicketDetails, List<TicketResponse> responses ) {
        if (nextHandler != null){
            nextHandler.handleTicketRequest(inputTicketDetails, responses);
        }
    }
}
