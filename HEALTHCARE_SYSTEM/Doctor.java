import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
/*view profile, viewAppointments,
 Attend Patients and logout. */ 
public class Doctor {
    String a=null;
    String b=null;
    String namep=null;

public void login_Doctor()throws Exception{
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
Scanner sc=new Scanner(System.in);

System.out.println("entre username");
 namep=sc.nextLine();
System.out.println("enter the password");
String pass=sc.nextLine();
PreparedStatement ps=con.prepareStatement("Select* from doctorr");
 ResultSet rs=ps.executeQuery();
 while (rs.next()) {
    a=rs.getString("name");
    b=rs.getString("password");
    if(namep.equals(a)&& pass.equals(b)){
        entryp();
    }
    
 }
 con.close();
}
public void entryp()throws Exception{
    Scanner sc=new Scanner(System.in);
    System.out.println("1 view profile");
    System.out.println("--------------");
    System.out.println("2 View Appointment");
    System.out.println("--------------");
    System.out.println("3 Attend patient");
    System.out.println("--------------");
    System.out.println("enter your choice");
    int n=sc.nextInt();
    switch (n) {
        case 1:view_doctorr();
              break;
       case 2:  viewdoctor_appointment();
                 break;
       case 3:Attend_patient();
              break;
            
        default:
            break;
    }

}
public void view_doctorr()throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("successful");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
    Scanner sc=new Scanner(System.in);
    PreparedStatement ps=con.prepareStatement("Select* from Doctorr");
     ResultSet rs=ps.executeQuery();
     while (rs.next()) {
         String a=rs.getString("name");
       
        if(namep.equals(a)){
      
        System.out.println("name: "+a);
       String email1= rs.getString("email");
       System.out.println("email  "+email1);
       String gender1= rs.getString("gender");
       System.out.println("gender "+gender1);
       String contact1= rs.getString("contact");
       System.out.println("contact  "+contact1);
        }
}
 con.close();

 }
 public void viewdoctor_appointment()throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
    Scanner sc=new Scanner(System.in);
    PreparedStatement ps=con.prepareStatement("Select* from Appointment");
     ResultSet rs=ps.executeQuery();
     while (rs.next()) {
        String a=rs.getString("Doctorname");
        if(namep.equals(a)){
            System.out.println("name "+a);
            String drname=rs.getString("patient_name");
            System.out.println("Patient name:  "+drname);
            String dId=rs.getString("DoctorId");
            System.out.println("Doctor id    "+dId);
            String pissue=rs.getString("healthIssue");
            System.out.println("patient health issue   "+pissue);
             String appointment_date=rs.getString("appointmenet_date");
             System.out.println("Appointment date    "+appointment_date);
                


        }
        
     }
    
}
public void Attend_patient()throws Exception{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
    Scanner sc=new Scanner(System.in);
    PreparedStatement ps=con.prepareStatement("Select* from Appointment");
     ResultSet rs=ps.executeQuery();
     while (rs.next()) {

        if(namep.equals(a)){
            System.out.println("name "+a);
            String patient_name=rs.getString("patient_name");
            System.out.println("patient name "+patient_name);
            String DID=rs.getString("DoctorId");
            System.out.println("doctor id "+DID);
            String healthIssue=rs.getString("healthIssue");
            System.out.println("healthIssue "+healthIssue);
           // System.out.println("enter the cure");
            //String cure=sc.nextLine();
            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
            System.out.println("successfull");
            PreparedStatement ps1=con.prepareStatement("insert into Attend_patient (patient_name,Doctor_name,Doctor_id,healthissu) values(?,?,?,?)");
            ps1.setString(1, patient_name);
            ps1.setString(2,a );
            ps1.setString(3, DID);
            ps1.setString(4, healthIssue);
            int i=ps1.executeUpdate();
            if(i>0){
                System.out.println("successfull");
            }
            else{
                System.out.println("failed");
            }
            con1.close();
        }
        
     }
     con.close();


}

}
