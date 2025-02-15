import java.util.Arrays;
import java.util.*;

public class difference_of_lists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
        System.out.println("list1:"+list1);
        System.out.println("list2:"+list2);
        List<Integer> result = diff(list1, list2);
        System.out.println("difference of lsts : "+result);
    }
    static List<Integer> diff(List<Integer> l1, List<Integer> l2) {
        List<Integer> ans = new ArrayList<>();
        int i=0,j=0;
        while(i<l1.size() && j<l2.size()){
            if(l1.get(i)<l2.get(j))ans.add(l1.get(i++));
            else if(l1.get(i)>l2.get(j))j++;
            else {
                i++;
                j++;
        }
    }
    return ans;
}
}
