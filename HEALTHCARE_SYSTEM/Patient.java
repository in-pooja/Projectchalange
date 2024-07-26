/*E-HealthCare-Management-System is a console based application which is built using java.This application helps in management of Patients,
 doctors, admin in a easy and comfortable way.using this Application patients can quickly Sign up, Login, view his/her profile, view doctors,
  book Appointment, view Report, choose doctor, view Appointments, give feedback, pay online and logout. Admin can add Doctors,view patients
   list, view Doctors list,remove doctors, see feedback given by patients,view reports,logout.Doctor can login, view profile, viewAppointments,
 Attend Patients and logout. */
 import java.util.Scanner;
 import java.sql.*;
 import java.sql.PreparedStatement;
 
 public class Patient {
     String a=null;
     String b=null;
     String namep=null;
     String dbook=null;
     String drname=null;
     public void enter_patient () throws Exception{
         Scanner sc=new Scanner(System.in);
         System.out.println("enter 1 to signup");
         System.out.println("enter 2 loginpage");
         int num=sc.nextInt();
         if(num==1){
             Signup_patient();
         }
         else if(num==2){
             login_patient();
         }
 
     }
 public void Signup_patient()throws Exception{
     Scanner sc=new Scanner(System.in);
     System.out.println("enter your name");
     String namep=sc.nextLine();
     System.out.println("enter your email");
     String emailp=sc.nextLine();
     System.out.println("enter your password");
     String passp=sc.nextLine();
     // System.out.println("enter your age");
     // String agep=sc.nextLine();
     System.out.println("enter your mobile number");
     String contactp=sc.nextLine();
     System.out.println("enter gender");
     String genderp=sc.nextLine();
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
     PreparedStatement ps=con.prepareStatement("insert into patient values(?,?,?,?,?)");
     ps.setString(1, namep);
     ps.setString(2, passp);
     ps.setString(3, emailp);
     ps.setString(4, genderp);
     ps.setString(5, contactp);
     System.out.println("sucessful");
   
     int i=ps.executeUpdate();
     if(i>0){
         System.out.println("successful");
     }
     else{
         System.out.println("not successfull");
     }
    con. close();
    System.out.println("enter yes/no for main patient page");
    String Str=sc.nextLine();
    if(Str.equals("yes")){
     enter_patient();
    }
    else if(Str.equals("no")){
     System.out.println("thankyou");
    }
    else{
     System.out.println("enter valid info");
    }
 }
 
 
 
 
 
 
 public void login_patient()throws Exception{
  Class.forName("com.mysql.cj.jdbc.Driver");
  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");  
 Scanner sc=new Scanner(System.in);
 System.out.println("entre username");
  namep=sc.nextLine();
 System.out.println("enter the password");
 String pass=sc.nextLine();
 PreparedStatement ps=con.prepareStatement("Select* from patient");
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
     System.out.println(" 1 - view profile ");
     System.out.println("--------------");
     System.out.println(" 2 -book appointment");
     System.out.println("--------------");
     System.out.println(" 3  - choose doctor  ");
     System.out.println("--------------");
     System.out.println(" 4 -  view appoinment");
     System.out.println("--------------");
     System.out.println(" 5 - view Doctors");
     System.out.println("--------------");
     System.out.println(" 6 - view report");
     System.out.println("--------------");
     System.out.println(" 7 - give feedback");
     System.out.println("--------------");
     System.out.println(" 8 - pay online ");
     System.out.println("--------------");
     System.out.println(" 9 -payment");
     System.out.println("--------------");
    System.out.println( "10 -logout");
    int n1=sc.nextInt();
    switch (n1) {
     case 1:view_profilep();
         
         break;
     case 2:  bookappoinmentp();
                  break; 
     case 3:  choose_doctors();
              break;
     case 4:  view_Appoinment();
              break;
     case 5:  view_doctorr();
              break;
     case 6: view_report();
              break;
     case 7:Give_Feedback();
            break;
     case 8: payment1();
            break;
     case 9:payment();
             break;
     case 10: logout();
              break;  
 
     default:
         break;
    }
     
 }
 public void view_profilep()throws Exception{
     Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
     Scanner sc=new Scanner(System.in);
     PreparedStatement ps=con.prepareStatement("Select* from patient");
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
 public void bookappoinmentp()throws Exception{
     choose_doctors();
     Scanner sc=new Scanner(System.in);
     System.out.println("enter Doctor Id book Appointment");
     dbook=sc.nextLine();
     System.out.println("enter name of doctor");
     drname=sc.nextLine();
    Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
     PreparedStatement ps=con.prepareStatement("Select* from Doctorr");
     ResultSet rs=ps.executeQuery();
     while(rs.next()){
         String drid=rs.getString("uniqueId");
         if(drid.equals(dbook)){
             entryy_application();
         }
     }
     con.close();
 
 
 
 
 }
 
 public void choose_doctors()throws Exception{
     System.out.println("choose doctors");
     Class.forName("com.mysql.cj.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
     Scanner sc=new Scanner(System.in);
     PreparedStatement ps=con.prepareStatement("Select* from Doctorr");
     ResultSet rs=ps.executeQuery();
     while (rs.next()) {
         String drid=rs.getString("uniqueId");
         System.out.println("Dr.Id    "+drid);
         String named=rs.getString("name");
         System.out.println("Dr.name   "+named);
     }
     con.close();
 } 
 public void entryy_application()throws Exception{
     Scanner sc=new Scanner(System.in);
     System.out.println("enter your health issue");
     String s=sc.nextLine();
     System.out.println("enter your appoinment day");
     String day=sc.nextLine();
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
     PreparedStatement ps=con.prepareStatement("insert into Appointment values(?,?,?,?,?)");
  ps.setString(1, namep);
  ps.setString(2,drname);
  ps.setString(3,dbook);
  ps.setString(4, s);
  ps.setString(5, day);
  int i=ps.executeUpdate();
  if(i>0){
     System.out.println("successfull");
 
  }
  else{
     System.out.println("faild");
  }  
  con.close();
 }
 public void view_Appoinment()throws Exception{
     Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
     Scanner sc=new Scanner(System.in);
     PreparedStatement ps=con.prepareStatement("Select* from Appointment");
      ResultSet rs=ps.executeQuery();
      while (rs.next()) {
         String a=rs.getString("patient_name");
         if(namep.equals(a)){
             System.out.println("name "+a);
             String drname=rs.getString("Doctorname");
             System.out.println("Doctorname  "+drname);
             String dId=rs.getString("DoctorId");
             System.out.println("Doctor id    "+dId);
             String pissue=rs.getString("healthIssue");
             System.out.println("patient health issue   "+pissue);
              String appointment_date=rs.getString("appointmenet_date");
              System.out.println("Appointment date    "+appointment_date);
 
         }
 
 }
 con.close();
 }
 public void  view_doctorr()throws Exception{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
     PreparedStatement ps=con.prepareStatement("Select* from Doctorr");
     ResultSet rs=ps.executeQuery();
     while (rs.next()) {
       String id=rs.getString("uniqueId");
       System.out.println("Doctor id  "+id);
       String name=rs.getString("name");
       System.out.println("Doctor name  "+name);
       String email=rs.getString("email");
       System.out.println("Doctor email  "+email);
       String pass=rs.getString("password");
       System.out.println("Dr.password  "+pass);
       String Spe=rs.getString("Specilization");
       System.out.println("dr.Specilization "+Spe);
       String conn=rs.getString("contact");
       System.out.println("Dr contact  "+conn);
       String timing=rs.getString("timing");
       System.out.println("Dr.timing  "+timing);
       String fees=rs.getString("Fees");
       System.out.println("Doctor fees  "+fees);
 
     }
     con.close();
    
 }
 public void payment1()throws Exception{
     Scanner sc=new Scanner(System.in);
     System.out.println("enter the card holder");
     String card_holder=sc.nextLine();
     System.out.println("enter the Doctor_id");
     String Doctor_id=sc.nextLine();
     System.out.println(" enter card number");
     String card_no=sc.nextLine();
     System.out.println("enter the cvv number");
     String CVV=sc.nextLine();
     System.out.println("enter the payment");
     String payment=sc.nextLine();
     System.out.println("enter UPI number");
     String UPI_no=sc.nextLine();
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
     PreparedStatement ps=con.prepareStatement( ("insert into payment2 values(?,?,?,?,?,?)"));
     ps.setString(1, card_holder);
     ps.setString(2, Doctor_id);
     ps.setString(3, card_no);
     ps.setString(4, CVV);
     ps.setString(5, payment);
     ps.setString(6, UPI_no);
      int i=ps.executeUpdate();
     if(i>0){
         System.out.println("successful");
     }
     else{
         System.out.println("failed");
     }
     payment();
       con.close();
 }
 public void payment()throws Exception{
     Scanner sc=new Scanner(System.in);
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
         PreparedStatement ps=con.prepareStatement("Select* from payment2");
         System.out.println("enter the doctor id");
         String idd=sc.nextLine();
         ResultSet rs=ps.executeQuery();
         while(rs.next()){
            String id2= rs.getString("Doctor_id");
             if(id2.equals(idd)){
         System.out.println("enter 1 for online payment");
         System.out.println("enter 2 for cash payment");
         int n=sc.nextInt();
         if(n==1){
             System.out.println("online payment successful");
         }
         else if(n==2){
         System.out.println("cash payment ");
         }
         }
     }
 }
     
    
     public void view_report()throws Exception{
         Scanner sc=new Scanner(System.in);
         System.out.println("enter the patient name");
         String name=sc.nextLine();
         Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
         PreparedStatement ps=con.prepareStatement("Select* from Attend_patient");
         ResultSet rs=ps.executeQuery();
         while (rs.next()) {
             if(namep.equals(name)){
                 System.out.println("patient name  "+name);
                String Dr_name=rs.getString("Doctor_name");
                 System.out.println("Dr.name   "+Dr_name);
                 String Dr_id=rs.getString("Doctor_id");
                 System.out.println("Doctor id  "+Dr_id);
                 String healthissu=rs.getString("healthissu");
                 System.out.println("healthissu  "+healthissu);
 
             }
             
         }
 
     }
     public void Give_Feedback()throws Exception{
         Scanner sc=new Scanner(System.in);
         System.out.println("enter the patient name");
         String name=sc.nextLine();
         System.out.println("give the feedback");
         String feed=sc.nextLine();
         System.out.println("enter the feedback date");
         String feeds=sc.nextLine();
         System.out.println("enter the feedback time");
         String time=sc.nextLine();
 
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","root");
         PreparedStatement ps=con.prepareStatement("insert into Feedback values(?,?,?,?)");
             ps.setString(1, name);
             ps.setString(2, feed);
             ps.setString(3, feeds);
             ps.setString(4, time);
             int i=ps.executeUpdate();
             if(i>0){
                 System.out.println("successfull");
             }
             else{
                 System.out.println("failed");
             }
             con.close();
         }
         public void logout(){
             Scanner sc=new Scanner(System.in);
             System.out.println("enter the number");
             int num=sc.nextInt();
              if(num==9){
             System.out.println("logout successfull");
         }
         else{
             System.out.println("try again");
         }
         
     }
         }
 
 
     
 
 
 