import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

class IntUtil implements ListMapper<Integer,String>,ListFilter<Integer>,ListReducer<Integer,String>{
	public String map(Integer element){
		return ""+(element *2);
	}
	public boolean check(Integer element){
		return element%2==0;
	}
	public String compare(String previousVal,Integer currentVal){
		return previousVal+currentVal;
	};


}
public class CollectionUtilsTest{
	@Test
	public void map_retuns_listOf_maped_element(){
		IntUtil iu= new IntUtil();
		String expected [] ={"2","4","6","8","10"};
		List<Integer> list =new  ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		List<String> mapList =CollectionUtils.<Integer,String>map(list,iu);
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
	@Test
	
	public void reduce_retuns_one_element(){
		IntUtil iu= new IntUtil();
		String expected ="012345";
		List<Integer> list =new  ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);

		String l =CollectionUtils.<Integer,String>reduce(list,iu,"0");
		assertEquals(l,expected);
	}
}