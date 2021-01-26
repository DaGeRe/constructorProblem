package de.peass;

class C0_0 {
	public void method0() {
		C1_0 object = new C1_0();
		object.method0();
		object.method1();
	}

	public void method1() {
		C1_1 object = new C1_1();
		object.method0();
		object.method1();
	}
	
	public static void main(String[] args) {
		new C0_0().method0();
		new C0_0().method1();
	}
}