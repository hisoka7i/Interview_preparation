class A {
	int a;

	A(int a) {
	 a = a;
	}
}

 class Main {
	
	public static void main(String[] args) 
	{
	 A a = new A(10);
	 System.err.println(a.a);
	}
}