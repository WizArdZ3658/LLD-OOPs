package operations;

import model.Person;

public class NotificationHandler {

    public void sendNotification(String message, Person customer) {
        sendEmail(message, customer);
    }

    private void sendEmail(String message, Person customer) {
        System.out.println("Sending email to " + customer.getEmailId() + " with message : " +
            message);
    }
}
