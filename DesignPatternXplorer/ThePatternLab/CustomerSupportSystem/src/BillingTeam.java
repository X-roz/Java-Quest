public class BillingTeam extends TicketHandler {

    private final String teamName = "BILLING_TEAM";

    BillingTeam(TicketHandler nextHandler) {
        super(nextHandler);
    }

    public TicketResponse handleTicketRequest(String inputTicketDetails) {
        TicketResponse techTeamResponse = new TicketResponse();
        techTeamResponse.teamName = teamName;
        techTeamResponse.response = "Billing team Validated the request : "+ inputTicketDetails;
        return techTeamResponse;
    }

}
