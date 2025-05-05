package behavioralPattern;

public class ChainOfResponsibility {

    public static void main(String[] args) {

        TokenAuthentication auth = new TokenAuthentication("123456-XXX");
        ContentTypeValidation validation =  new ContentTypeValidation("JSON");
        PayloadProcess process = new PayloadProcess("Body : {\"username\" : \"Vicky\"}");

        auth.next = validation;
        validation.next = process;

        System.out.println(auth.addHandlerLayer("Request with Authentication"));

    }

}

///  Chain of Responsibility
interface HandlerChain {
    String addHandlerLayer(String inputMessage);
}

// Token Authentication
class TokenAuthentication implements HandlerChain{

    private final String token;

    public HandlerChain next;

    TokenAuthentication(String token) {
        this.token=token;
    }

    @Override
    public String addHandlerLayer(String inputMessage) {
        String output = inputMessage + "\n Token Authentication : " + token;
        if (next == null){
            return output;
        }
        return next.addHandlerLayer(output);
    }
}

// Content Type Validation
class ContentTypeValidation implements HandlerChain{

    private final String contentType;

    public HandlerChain next;

    ContentTypeValidation(String contentType) {
        this.contentType=contentType;
    }

    @Override
    public String addHandlerLayer(String inputMessage) {
        String output = inputMessage + "\n ContentType Validation : " + contentType;
        if (next == null){
            return output;
        }
        return next.addHandlerLayer(output);
    }
}

// Payload Process
class PayloadProcess implements HandlerChain{

    private final String payload;

    public HandlerChain next;

    PayloadProcess(String payload) {
        this.payload=payload;
    }

    @Override
    public String addHandlerLayer(String inputMessage) {
        String output = inputMessage + "\n Payload Processing : " + payload;
        if (next == null){
            return output;
        }
        return next.addHandlerLayer(output);
    }
}