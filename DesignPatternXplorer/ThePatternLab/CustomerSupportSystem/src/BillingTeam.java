import java.util.List;

public class BillingTeam extends TicketHandler {

    private final String teamName = "BILLING_TEAM";

    BillingTeam(TicketHandler nextHandler) {
        super(nextHandler);
    }

    public void handleTicketRequest(String inputTicketDetails, List<TicketResponse> responses) {
        TicketResponse billingTeamResponse = new TicketResponse();
        billingTeamResponse.teamName = teamName;
        billingTeamResponse.response = "Billing team Validated the request : "+ inputTicketDetails;
        responses.add(billingTeamResponse);
        super.handleTicketRequest(inputTicketDetails, responses);
    }

}
