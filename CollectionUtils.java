import java.util.*;
interface ListMapper<E> {
	public E map(E element);
}
interface ListFilter<E>{
	public boolean filter(E element);
}
public class CollectionUtils{
	public static <E> List<E> map(List<E> list, ListMapper<E> mapper){
		List<E> newlist = new ArrayList<E>();
		for(E l :list){
			E element = mapper.map(l);
			newlist.add(element);
		} 
		return newlist;
	}
	public static <E> List<E> filter(List<E>list , ListFilter<E> predicate){
		List<E> newlist = new ArrayList<E>();
		for(E l :list){
			if(predicate.filter(l)){
				newlist.add(l);
			}
		} 
		return newlist;
	}
}