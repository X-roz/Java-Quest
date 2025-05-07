public class TechnicalTeam extends TicketHandler{

    private final String teamName = "TECHNICAL_TEAM";

    TechnicalTeam(TicketHandler nextHandler) {
        super(nextHandler);
    }

    public TicketResponse HandleTicketRequest(String inputTicketDetails) {
        TicketResponse techTeamResponse = new TicketResponse();
        techTeamResponse.teamName = teamName;
        techTeamResponse.response = "Tech Validated the request : " + inputTicketDetails;
        return techTeamResponse;
    }
}
