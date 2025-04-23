package NotificationAndRemainder;

public class RemainderService extends EmailNotification{

    private Notifiable emailNotifier;

    public RemainderService (Notifiable emailNotifier) {
        this.emailNotifier = emailNotifier;
    }

    public void sendAppointmentReminder(String patientName, String appointmentDateTime, String email) {
        String message = "📅 Hello " + patientName + ", this is a reminder for your appointment on " + appointmentDateTime + ".";
        emailNotifier.sendMail(message, email,"Appointment Remainder");
    }

    public void sendMedicationReminder(String patientName, String medicationDetails, String email) {
        String message = "💊 Hello " + patientName + ", it's time to take your medication: " + medicationDetails + ".";
        emailNotifier.sendMail(message, email,"Medication Remainder");
    }
}
