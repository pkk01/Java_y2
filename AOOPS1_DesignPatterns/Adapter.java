interface Employee {
	void show ();
}

class Address {
	int hno;
	String city;
	int pincode;
	Address (int h, String c, int p )
	{
		hno = h;
		city = c;
		pincode = p;
	}
	void show () 
	{
	    System.out.println("House number: "+hno);
	    System.out.println("City: "+city);
	    System.out.println("Pin code: "+pincode);
	}
}

class EmployeeOne implements Employee {
    String name;
    int Empid;
    EmployeeOne (String n, int id)
    {
        name = n;
        Empid = id;
    }
    public void show () {
        System.out.println("Employee Name: "+name);
        System.out.println("Employee ID: "+Empid);
    }
}
class EmployeeTwo implements Employee {
    String name;
    int Empid;
    Address ad;
    EmployeeTwo (String n, int id, Address ad1)
    {
        name = n;
        Empid = id;
        ad = ad1;
    }
    public void show () {
        System.out.println("Employee Name: "+name);
        System.out.println("Employee ID: "+Empid);
        
        ad.show ();
    }
}

public class Adapter {
    public static void main (String[] args) {
        Employee ee;
        Address ads = new Address (111,"Guntur",522007);
        ee = new EmployeeOne ("Sai Prasanth", 1000);
        System.out.println("Employee Details without Adapter");
        ee.show ();
        System.out.println();
        System.out.println("Employee Details With Adapter");
        ee = new EmployeeTwo ("Sachin",9999,ads);
        ee.show();
    }
}

