package class11;

public class TestObject implements Cloneable {
	private int ID;
	
	TestObject(int ID){
		this.ID = ID;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
//		if(obj instanceof TestObject) {
//			TestObject tObj = (TestObject)obj;
//			System.out.println(this.ID);
//			System.out.println(tObj.ID);
//			if(this.ID == tObj.ID) {
//				return true;
//			}
//			else return false;
//		}
		System.out.println(obj);
		System.out.println(this);
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.ID;
//		return super.hashCode();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	
}
