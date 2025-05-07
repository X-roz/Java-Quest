import java.util.List;

public class TechnicalTeam extends TicketHandler{

    private final String teamName = "TECHNICAL_TEAM";

    TechnicalTeam(TicketHandler nextHandler) {
        super(nextHandler);
    }

    public void handleTicketRequest(String inputTicketDetails, List<TicketResponse> responses) {
        TicketResponse techTeamResponse = new TicketResponse();
        techTeamResponse.teamName = teamName;
        techTeamResponse.response = "Tech Validated the request : " + inputTicketDetails;
        responses.add(techTeamResponse);
        super.handleTicketRequest(inputTicketDetails, responses);
    }
}
