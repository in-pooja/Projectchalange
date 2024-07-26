
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.time.LocalDate;
    import java.util.Scanner;
    public class Login {
        // public void ss(){
          
        // }
    
        
        public static void main(String[] args)throws Exception {
            Patient t=new Patient();
            Doctor d=new Doctor();
            Admin A=new Admin();
        Scanner sc=new Scanner(System.in);
        System.out.println("----------------------Welcome to Our E-Heathcare System----------------------  ");
    
            LocalDate today=LocalDate.now();
        System.out.println("Date:"+today.toString());
    
        System.out.println("enter 1 for Admin");
        System.out.println("-------------------------");
       System.out.println("enter 2 for Doctor");
        System.out.println("-------------------------");
         System.out.println("enter 3 for patient");
        System.out.println(" -------------------------");
       
       
        System.out.println("enter choice");
        int num=sc.nextInt();
        if(num==1){
            A.loginAmin();
        }
        else if(num==2){
         d.login_Doctor();  
        }
        else if(num==3){
            t.enter_patient();
        }
    // finall t=new finall();
    // t.ss();
    
        
    }
    
}

