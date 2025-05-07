import java.util.List;

public class CustomerSupportSystem {

    public static void main(String[] args) {

        TicketHandler ticketHandler = new TechnicalTeam(new BillingTeam(null));

        // User's request
        ticketHandler.handleTicketRequest("problem statement");

        List<TicketResponse> responses = ticketHandler.getTicketResponseFromEachTeam();
        responses.forEach(System.out::println);
    }
}