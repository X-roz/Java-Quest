import java.util.ArrayList;
import java.util.List;

public class CustomerSupportSystem {

    public static void main(String[] args) {

        TicketHandler ticketHandler = new TechnicalTeam(new BillingTeam(null));

        List<TicketResponse> ticketResponseFromEachTeam = new ArrayList<>();

        // User's request
        ticketHandler.handleTicketRequest("problem statement", ticketResponseFromEachTeam);

        ticketResponseFromEachTeam.forEach(r -> System.out.println(r.teamName + " : "+ r.response));
    }
}