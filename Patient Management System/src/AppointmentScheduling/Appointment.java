package AppointmentScheduling;
import management.*;
import java.time.LocalDate;
import java.util.ArrayList;
public class Appointment{
    protected String appointment_id="A-";
    protected String status;
    protected Doctor doctor;
    protected Patient patient;
    protected LocalDate date;
    protected static ArrayList<Appointment> appointment_list=new ArrayList<>();
    protected static ArrayList<String> appointmentID_list=new ArrayList<>();
    Appointment(){appointment_id=User.generate_id();}
    public Appointment(String status, Doctor doctor, Patient patient, LocalDate date) {
        this();
        this.status = status;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }
    

    public void setStatus(String status) {this.status = status;}
    
    public String getStatus() {return status;}
    public String getAppointment_id() {return appointment_id;}
    public LocalDate getAppointmentDate(){return date;}



    @Override   
    public String toString(){
        return "\n\t------ Appointment Detail ------"+
                "\nAppointment Id      :  "+getAppointment_id()+
                "\t\tAppointment Date  : "+getAppointmentDate()+
                "\nAppointed Doctor    : "+(doctor != null ? "Dr."+doctor.getName() : "Not Assigned")+
                "\nAppopointde Patient : "+(patient != null ? patient.getName() : "Not Assigned")+
                "\nAppointment Status  : "+getStatus();
    }

    
}