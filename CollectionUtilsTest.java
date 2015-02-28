import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

class IntUtil implements ListMapper<Integer>,ListFilter<Integer>{
	public Integer map(Integer element){
		return element *2;
	}
	public boolean filter(Integer element){
		return element%2==0;
	}

}
public class CollectionUtilsTest{
	@Test
	public void map_retuns_listOf_maped_element(){
		IntUtil iu= new IntUtil();
		Integer expected [] ={2,4,6,8,10};
		List<Integer> list =new  ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		List<Integer> mapList =CollectionUtils.<Integer>map(list,iu);
		assertEquals(mapList.toArray(),expected);
		assertEquals(mapList.size(),list.size());

	}
	@Test
	public void filter_retuns_listOf_filterd_element(){
		IntUtil iu= new IntUtil();
		List<Integer> list =new  ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Integer expected[]={2,4};
		List<Integer> filteredList =CollectionUtils.<Integer>filter(list,iu); 
		assertEquals(2,filteredList.size());
		assertEquals(filteredList.toArray(),expected);

	}
}