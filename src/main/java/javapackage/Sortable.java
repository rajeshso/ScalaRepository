package javapackage;
import java.util.List;
import java.util.ArrayList;


public interface Sortable<A extends Comparable> extends Iterable<A> {
	default public List<A> sort() {
		List<A> list = new ArrayList<>();
		this.forEach(element-> list.add(element));
		list.sort((first, second)-> first.compareTo(second));
		return list;
	}
}
