import java.sql.*;
import java.util.Scanner;  
public class MysqlCon 
{
	public static void main(String args[])

	{  
		try
		{
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();
		Scanner k = new Scanner(System.in);
		System.out.println("enter your choice");
		System.out.println("1.insert\n2.name of employee starting from p\n3.name of employee working in dept 2\n4.retrieve female emp details\n5.show sal if every emp working in dept 1 given 10% raise\n");
		
		int s=k.nextInt();
		switch(s)
		{
		case 1:
		 
		System.out.println("enter SSN"); 
		String ssn = k.next(); 
		System.out.println("enter Name"); 
		String name = k.next(); 
		System.out.println("enter Address"); 
		String address = k.next();
		System.out.println("enter Sex"); 
		String sex = k.next();
		System.out.println("enter Salary"); 
		int salary = k.nextInt();
		System.out.println("enter SuperSSn"); 
		String superssn = k.next();
		System.out.println("enter Dno"); 
		int dno = k.nextInt();

		//Inserting data using SQL query 
		String sql = "insert into employee values('"+ssn+"','"+name+"','"+address+"','"+sex+"',"+salary+",'"+superssn+"',"+dno+")"; 

		try
		{ 
			
			//Reference to connection interface 
			Statement st = con.createStatement(); 
			int m = st.executeUpdate(sql); 
			if (m == 1) 
				System.out.println("inserted successfully : "+sql); 
			else
				System.out.println("insertion failed"); 
		} 
		catch(Exception ex) 
		{ 
			System.err.println(ex); 
		}
		ResultSet rs=stmt.executeQuery("select * from employee");
		while(rs.next())  
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getString(7));
			 
		break;
		case 2:
		
		ResultSet is=stmt.executeQuery("select name from employee where name like 'p%'");
		while(is.next())  
			System.out.println(is.getString(1));//+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getString(7));
		break;
		
		case 3:
		ResultSet a=stmt.executeQuery("select name from employee where dno=2");
		while(a.next())  
			System.out.println(a.getString(1));//+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getString(6)+" "+rs.getString(7));
			
		break;
		
		case 4:
		ResultSet b=stmt.executeQuery("select * from employee where sex='f'");
		while(b.next())  
			System.out.println(b.getString(1)+"  "+b.getString(2)+"  "+b.getString(3)+" "+b.getString(4)+" "+b.getInt(5)+" "+b.getString(6)+" "+b.getString(7));
		break;	
		
		case 5:
		ResultSet c=stmt.executeQuery("select salary + (salary * 10/100) as newsalary from employee where dno=1");
		while(c.next())  
		System.out.println(c.getString(1));//+"  "+c.getString(2)+"  "+c.getString(3)+" "+c.getString(4)+" "+c.getInt(5)+" "+c.getString(6)+" "+c.getString(7));
		break;
		
		}
		con.close();
		}
		catch(Exception e){ System.out.println(e);}  
		}  
}
