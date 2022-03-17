// update the class
class BadRequestException extends Exception {
    String message;

    public BadRequestException(String message) {
        super(message);
    }
}