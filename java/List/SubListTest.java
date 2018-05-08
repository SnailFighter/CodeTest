import java.util.List;
import java.util.ArrayList;
import java.lang.String;
import java.lang.Integer;

public class SubListTest {

	public static void main(String[] args){
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<=6;i++){
			list.add(i);
		}

		System.out.println("size:    "+list.size());

		int segmentNum = list.size()%2==0?list.size()/2:list.size()/2+1;
		System.out.println("list.size()/2 = "+list.size()/2);
		System.out.println("segmentNum:    "+segmentNum);
		System.out.println();


		String str = "";
		for(int i=0;i<(segmentNum-1);i++){
			str="";
			for(int j=0;j<list.subList(i*2,(i+1)*2).size();j++){
				str+=","+list.subList(i*2,(i+1)*2).get(j);
			}
			System.out.println(str);
		}

		//handle last time 
		str="";
 		for(int j=0;j<list.subList((segmentNum-1)*2,list.size()).size();j++){

			str+=","+list.subList((segmentNum-1)*2,list.size()).get(j);
		}
		System.out.println(str);

	}

}