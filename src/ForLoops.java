
public class ForLoops {
	
	
public static void main(String[] args) {
Years();
//System.out.println("In "+x+", I was "+i+" years old.");
}
static void FirstLoops(){
	for(int i = 0; i <= 100; i++){
		for(int x = 100; x >= 0; x--){
		System.out.println(i+" "+x);
		}
	}
	
}
static void Even(){
	
	for(int i = 0; i <=100 ; i++){
		if(i % 2 == 0){
			System.out.println(i);
		}
		
	}
}
static void Odd(){
	for(int x = 0; x <= 100; x++){
		if(x % 2 == 1){
			System.out.println(x);
		}
	}
}
static void Print(){
	for(int i = 0; i <= 500; i++){
		if(i % 2 == 1){
			System.out.println(i+ "Odd");
		}else{
			System.out.println(i+ "Even");
		}
	}
}
static void Seven(){
	for(int i = 0; i <= 777; i++){
		if(i % 7 == 0){
			System.out.println(i); 
		}
	}
}
static void Years(){
	


	for(int x = 0; x <= 17; x++ ){
		int d = x + 2004; 
		System.out.println("In "+ d +", I was "+x+" years old.");
	}
}
}
