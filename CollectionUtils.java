import java.util.*;
interface ListMapper<E,K> {
	public K map(E element);
}
interface ListFilter<E>{
	public boolean check(E element);
}
public class CollectionUtils{
	public static <E,K> List<K> map(List<E> list, ListMapper<E,K> mapper){
		List<K> newlist = new ArrayList<K>();
		for(E l :list){
			K element = mapper.map(l);
			newlist.add(element);
		} 
		return newlist;
	}
	public static <E> List<E> filter(List<E>list , ListFilter<E> predicate){
		List<E> newlist = new ArrayList<E>();
		for(E l :list){
			if(predicate.check(l)){
				newlist.add(l);
			}
		} 
		return newlist;
	}
}