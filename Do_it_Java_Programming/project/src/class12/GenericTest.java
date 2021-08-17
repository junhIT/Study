package class12;

import class7.array.Student;

public class GenericTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericTest gt = new GenericTest();
//		gt.genericPrinterClass();
		gt.genericMethod();
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
		powder.doPrinting();
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
		
		plasticPrinter.setMaterial(new Plastic());
		Plastic plastic = plasticPrinter.getMaterial();
		plastic.doPrinting();
	}
	
	public static <T, V> double makeRectangle(Point<T, V> p1, Point<T, V> p2) {
		double left = ((Number)p1.getX()).doubleValue();
		double right = ((Number)p2.getX()).doubleValue();
		double top = ((Number)p1.getY()).doubleValue();
		double bottom = ((Number)p2.getY()).doubleValue();
		
		double width = right - left;
		double height = bottom - top;
		
		return width * height;
	}
	
	public void genericMethod() {
		Point<Integer, Double> p1 = new Point<Integer, Double>(0, 0.0);
		Point<Integer, Double> p2 = new Point<>(10, 10.0);
		
		double rect = makeRectangle(p1, p2);
		System.out.println("두 점으로 만들어진 사각형의 넓이는 " + rect + "입니다.");
	}
}
