package class10.bookshelf;

public class BookShelf extends Shelf implements Queue {
	public void enQueue(String title) {
		shelf.add(title);
	}

	public String deQueue() {
		return shelf.remove(0);
	}

	public int getSize() {
		return getCount();
	}

}
