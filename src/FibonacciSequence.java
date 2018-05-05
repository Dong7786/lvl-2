
public class FibonacciSequence {
public static void main(String[] args) {
int a = 0;
int b = 1;
int c = 0;
for(int x = 0; x <= 1000000; x ++){
	c = a+ b;
	a = b;
			b =c;
			System.out.println(a);
}

}
}
