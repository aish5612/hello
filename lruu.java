import java.util.ArrayList;
public class Main
{
	public static void main(String[] args) {
		int capacity = 4;
		int arr[] = {2, 0, 1, 2, 0, 3, 0, 8, 2, 1, 7};
		
		ArrayList<Integer> s = new ArrayList<>(capacity);
		
		int c = 0;
		int pf = 0;
		
		for(int i: arr){
		    if(!s.contains(i)){
		        if(s.size() == capacity){
		            s.remove(0);
		            s.add(capacity-1, i);}   
                
		        else{
		            s.add(c, i); }
		        
		        pf ++;
		        ++c;
		        
		    }
		    else{
		        s.remove((Object)i);
		        s.add(s.size(), i);    
		    } 
		}
		System.out.println(pf);
	}
}
