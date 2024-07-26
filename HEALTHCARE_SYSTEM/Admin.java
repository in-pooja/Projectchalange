import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class Admin {

    String name="pooja pawar";
    String pass="pooja123";
    public void loginAmin()throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("enter admin name");
        String nameA=sc.nextLine();
        System.out.println("enter admin password");
        String passA=sc.nextLine();
        if(name.equals(nameA)&&pass.equals(passA)){
            entryd();
        }
    }
    public void add_doctor()throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("enter doctor uniqueId");
        String uniqueId=sc.nextLine();
        System.out.println("enter the name");
        String named=sc.nextLine();
        System.out.println("enter the email");
        String emaild=sc.nextLine();
        System.out.println("enter the password");
        String passd=sc.nextLine();
        System.out.println("enter the specilization");
        String Specilization=sc.nextLine();
        System.out.println("enter the contact");
        String contactd=sc.nextLine();
        System.out.println("enter the timing");
        String timingd=sc.nextLine();
        System.out.println("enter the fees");
        String feesd=sc.nextLine();
       
        System.out.println("Connected Successfully");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
       PreparedStatement ps=con.prepareStatement("insert into doctorr values(?,?,?,?,?,?,?,?)");
       ps.setString(1, uniqueId);
       ps.setString(2, named);
       ps.setString(3, emaild);
       ps.setString(4, passd);
       ps.setString(5,Specilization);
       ps.setString(6, contactd);
       ps.setString(7, timingd);
       ps.setString(8, feesd);
       int i=ps.executeUpdate();
       if(i>0){
        System.out.println("successfull");
       }
       else{
        System.out.println("faild");
       }

    }
    public void entryd()throws Exception{
        System.out.println("1 add doctor");
        System.out.println("--------------");
        System.out.println("2 view doctor list");
        System.out.println("--------------");
        System.out.println("3 remove doctor");
        System.out.println("--------------");
        System.out.println("4 view report");
        System.out.println("--------------");
        System.out.println("5 view patient list");
        System.out.println("--------------");
        System.out.println("6 feedback");
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your choice");
        int n1=sc.nextInt();
        switch (n1) {
            case 1:add_doctor();
                    break;
                
            case 2:doctor_list();
                   break;
            case 3 : remove_doctor();
                    break;
            case 4 : view_report();
                      break;
            case 5 : view_patientList();
                     break;
            case 6 : view_feedback();
                     break;
        
        }

    }
    
    public void doctor_list()throws Exception{
        // Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
        PreparedStatement ps=con.prepareStatement("Select* from doctorr");
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {
        String uniqueId=rs.getString("uniqueId");
        System.out.println("unique id :"+uniqueId);
        String named=rs.getString("name");
        System.out.println("name : "+named);
        String emaild=rs.getString("email");
        System.out.println("email: "+emaild);
        String Specilization=rs.getString("Specilization");
        System.out.println("Specilization: "+Specilization);
        String contactd=rs.getString("contact");
        System.out.println("contact :"+contactd);
        String timingd=rs.getString("timing");
        System.out.println("timing "+timingd);
        String feesd=rs.getString("Fees");
        System.out.println("Fees: "+feesd);
        }
        con.close();
    }
    public void remove_doctor()throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your email id");
        String emaild=sc.nextLine();
        // Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
        PreparedStatement ps=con.prepareStatement("delete from doctorr where email=?");
        ps.setString(1, emaild);
       int i=ps.executeUpdate();
       if(i>0){
        System.out.println("delete successfully");
       }
       else{
        System.out.println("try again");
       }
    }
    public void view_report()throws Exception{
        Scanner sc=new Scanner(System.in);
        // Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
        PreparedStatement ps=con.prepareStatement("Select*from Attend_patient");
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {
            String patient_name=rs.getString("patient name");
            System.out.println("patinet name  "+patient_name);
            String Dr_name=rs.getString("Doctor_name");
            System.out.println("Dr.name :"+Dr_name);
            String Dr_id=rs.getString("Doctor_id");
            System.out.println("Doctor id: "+Dr_id);
            String healthissu=rs.getString("healthissu");
             System.out.println("healthissu  :"+healthissu);   
        }

    }
    public void view_patientList()throws Exception{
        //public void  patientlist()throws Exception{
        
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
            Scanner sc=new Scanner(System.in);
            PreparedStatement ps=con.prepareStatement("Select* from patient");
            ResultSet rs=ps.executeQuery();
              while (rs.next()) {
               String a=rs.getString("name");
               System.out.println("name "+a);
               String email1=rs.getString("email");
               System.out.println("email "+email1);
               String gender1=rs.getString("gender");
               System.out.println("gender "+gender1);
               String contact1=rs.getString("contact");
               System.out.println("contact "+contact1);
              }
              con.close();
       
           }

    public void view_feedback()throws Exception{

        // Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
        PreparedStatement ps=con.prepareStatement("Select* from Feedback");
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {
            String a=rs.getString("patient_name");
            System.out.println("patient name :"+a);
            String b=rs.getString("feedback");
            System.out.println("feedback :"+b);
            String c=rs.getString("feedbackdate");
            System.out.println("feedbackdate "+c);
            String d=rs.getString("time");
            System.out.println("feedback timing :"+d);
            
        }

    }
    public static void main(String[] args) throws Exception{
//        try{
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         System.out.println("Successfull");
//        }
//        catch(Exception e){
//   System.out.println(e);
//        }
try {
Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("Driver loaded successfully");
} catch (ClassNotFoundException e) {
    System.out.println("Failed to load MySQL driver: " + e.getMessage());
    e.printStackTrace();
}
    }
}
