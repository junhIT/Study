package class12;

import class7.array.Student;

public class GenericTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericTest gt = new GenericTest();
		gt.genericPrinterClass();
	}
	
	public void generic() {
		ThreeDPrinter printer = new ThreeDPrinter();
		
		Student st = new Student(0, null);
		printer.setMaterial(st); // 자동 형 변환됨
		
		Student st2 = (Student) printer.getMaterial(); // 직접 형 변환 필요
	}
	
	public void genericPrinterClass() {
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
		
		powderPrinter.setMaterial(new Powder());
		Powder powder = powderPrinter.getMaterial();
		System.out.println(powderPrinter);
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
		
		plasticPrinter.setMaterial(new Plastic());
		Plastic plastic = plasticPrinter.getMaterial();
		System.out.println(plasticPrinter);
	}
}
