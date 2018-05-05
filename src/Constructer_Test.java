
public class Constructer_Test {
public static void main(String[] args) {
	Dog dog = new Dog(" .");
	Dog d = new Dog(" ");
	
}

}
class Dog {
	int i = 0;
	String name;
	Dog(String n){
	i++; 
		
		
		System.out.println("dog " + n);
System.out.println(i);
	}
	
	
	
}
