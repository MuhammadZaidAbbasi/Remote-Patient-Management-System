package management;
import java.util.Scanner;
@SuppressWarnings("unused")
public class Doctor extends User {
    private String roomNumber,specialization,experience;
    public Doctor(){super("D-");
    total_docters+=1;}
    public Doctor(String name,String spcl,String exp,String roomNo){
        this();
        super.Name=name;
        specialization=spcl;
        experience=exp;
        roomNumber=roomNo;
    }

    public void setRoomNumber(String RN) {roomNumber =RN;}
    public void setSpecialization(String spcl){specialization=spcl;}
    public void setExperience(String exp){experience=exp;}


    public String getRoomNumber() {return this.roomNumber;}
    public String getSpecialization() {return this.specialization;}
    public String getExperience() {return this.experience;}
    

    public void seePatientsData() {

        System.out.println("\nTotal Patients: " + total_patients + "\n");

        for (int i = 0; i < total_patients; i++) {
            System.out.println(listOfPatients.get(i));        
            listOfPatients.get(i).displayVitals();
        }
    }

    public void giveFeedbackToPatient(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter ID of patient to whom you want to give feedback: ");
        String patientID = scanner.nextLine();
        boolean validID = isValidPatientID(patientID);
        Patient pat=Administrator.getPatientById(patientID);
        if (validID) {
            System.out.println("Please enter feedback: ");
            String notes = scanner.nextLine();
            pat.doctorFeedback.setNote(notes);
            pat.doctorFeedback.setPatientID(patientID);
            pat.doctorFeedback.setDoctorID(this.user_id);
            
            pat.doctorFeedback.storeFeedback();
        }else {
            System.out.println("You have entered incorrect Patient ID. Plz enter correct one");
        }
    }

    public void giveFeedbackToPatient(String patID){
        Scanner scanner = new Scanner(System.in);
        boolean validID = isValidPatientID(patID);
        Patient pat=Administrator.getPatientById(patID);
        if (validID) {
            System.out.println("Please enter feedback for "+ pat.getName() + " : ");
            String notes = scanner.nextLine();
            pat.doctorFeedback.setNote(notes);
            pat.doctorFeedback.setPatientID(patID);
            pat.doctorFeedback.setDoctorID(this.user_id);
            
            pat.doctorFeedback.storeFeedback();
        }else {
            System.out.println("You have entered incorrect Patient ID. Plz enter correct one");
        }
    }

    public boolean isValidPatientID(String patientID) {
        Patient patients = Administrator.getPatientById(patientID);
            return (patients != null);
    }


    @Override
    public String toString(){
        return"\n\t-------Doctors Detail ------"+
              super.toString()+
              "\nRoom       : "+getRoomNumber()+
              "\tExperience : "+getExperience()+
              "\nExpert in  : "+getSpecialization() ;
    }
    
    public void clone(Doctor doc){
        this.Name=doc.Name;
        this.user_id=doc.user_id;
        this.specialization=doc.specialization;
        this.experience=doc.experience;
        this.roomNumber=doc.roomNumber;
     }

   
}
