package AppointmentScheduling;
import management.Administrator;
import java.time.LocalDate;
import java.util.Scanner;
public class AppointmentManager extends Appointment{
    Scanner scanner = new Scanner(System.in);
        // private final ArrayList<Doctor> Doctor_list=User.getListOfDoctors();
        //private final ArrayList<Patient> Patient_list=User.getListOfPatients();

    public AppointmentManager(){}

    public static void getAllAppointmentID_list() {
        if (appointmentID_list.isEmpty()) 
            System.out.println("No Appointment Available.");
       System.out.println(appointmentID_list);
    }
    public static void getAllAppointment_list() {
        if (appointment_list.isEmpty()) 
            System.out.println("No Appointment Available.");
        System.out.println(appointment_list);
    }
    public static Appointment getAppointmentByID(String appointmentID) {
        for (Appointment appointment : appointment_list) {
            if(appointment.getAppointment_id().equals(appointmentID))
                return appointment;
        }
        return null;
    }

    public static void getAppointmentDetailsByID(String appointmentID){
        if (appointment_list.isEmpty())
            System.out.println("No Appointment With Id "+appointmentID);
        else{
            Appointment app = getAppointmentByID(appointmentID);
                    System.out.println("\nAppointment ID: " + app.getAppointment_id());
                    System.out.println("Appointment Date: " + app.getAppointmentDate());
                    System.out.println("Doctor : " + (app.doctor != null ? "Dr."+app.doctor.getName() : "Not Assigned"));
                    System.out.println("Patient: " + (app.patient != null ? app.patient.getName() : "Not Assigned"));
                    System.out.println("Status : " + app.getStatus() + "\n");         
        }
    }


    public void requestAppointment(String doctorID,String patientID){
        LocalDate app_date ;    
            if(Administrator.getDoctorById(doctorID)==null) {
                System.out.println("No Doctor Found With ID "+ doctorID);
                return ;
            }
            else if(Administrator.getPatientById(patientID) == null ){
                System.out.println("No Patient Found With ID "+ patientID);
                return ;
            }
            else{
                System.out.println("Appointment of "+Administrator.getPatientById(patientID).getName()+" in process with Dr."+ Administrator.getDoctorById(doctorID).getName());
                System.out.println("Enter Appointment Date In Format (YYYY-MM-DD) :");
                app_date =selectDate();
                appointment_list.add(new Appointment("Pending",Administrator.getDoctorById(doctorID),Administrator.getPatientById(patientID),app_date));
                appointmentID_list.add(appointment_list.get(appointment_list.size()-1).getAppointment_id());
                System.out.println("Appointment Requested ");

            }            
    }

    public void approveAppointment() {
        System.out.println("Enter Appointment id for Approval : ");
        String appointmentID = scanner.nextLine();
        Appointment app=getAppointmentByID(appointmentID);
        if(app!=null){
            if (app.getStatus().equalsIgnoreCase("pending")) {
            app.setStatus("Approved");
            System.out.println("Appointment with \"id="+appointmentID+"\" approved successfully!");
            return;
            }
            System.out.println("No Pending Appointment Found with id --> "+appointmentID);
            return;
        }
        System.out.println("No appointment found with id --> "+appointmentID);
    }


    public void CancelAppointment(){
        System.out.println("Enter Appointment id to Cancle : ");
        String appointment_ID = scanner.nextLine();
        Appointment app= getAppointmentByID(appointment_ID);
            if(app!=null){
                appointmentID_list.remove(app.getAppointment_id());
                appointment_list.remove(app);
                System.out.println("Appointment with \"id="+appointment_ID+"\" is Cancled");
            }
            System.out.println( "No Appointment Found with id --> " + appointment_ID);
    }


    private LocalDate selectDate(){
            return LocalDate.parse(scanner.nextLine());
        }


    
    @Override
    public String toString(){
        return   super.toString();
    }

}