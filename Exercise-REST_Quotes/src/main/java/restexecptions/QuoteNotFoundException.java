package restexecptions;

public class QuoteNotFoundException extends Exception {

    public QuoteNotFoundException() {
    }

        public QuoteNotFoundException(String msg) {
            
        super(msg);
    }
}
