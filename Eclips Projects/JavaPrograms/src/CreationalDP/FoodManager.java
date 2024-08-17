// abstract Factory example
package CreationalDP;
interface Food {
	void items ();
}
class Pizza  implements Food {
	public void items () {
		System.out.println("I am pizza");
	}
}
class Burger  implements Food {
	public void items () {
		System.out.println("I am Burger");
	}
}
class Chicken  implements Food {
	public void items () {
		System.out.println("I am Chicken");
	}
}

abstract class Factory {
	abstract Food getObject (int x);
}
class Dominos extends Factory{
	Food getObject (int x) {
		if (x==1)
				return new Pizza ();
		if (x==2)
			return new Burger ();
		else 
			return null;
	}
}
class KFC extends Factory{
	Food getObject (int x) {
		if (x==1)
			return new Chicken ();
		if (x==2)
			return new Burger ();
		else 
			return null;
	}
}
class FoodSelector {
	static Factory getCompany (int x) {
		if (x==1)
			return new Dominos ();
		if (x==2)
			return new KFC ();
		else 
			return null;
	}
}
public class FoodManager {
	public static void main(String[] args) {
		Factory fc;
		Food fd;
		fc = FoodSelector.getCompany(2);
		fd = fc.getObject (1);
		fd.items();
	}
}
