package kattis;

import java.util.ArrayList;
import java.util.Arrays;


public class problem_B {
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
//       int s = 0;
//       for (int x: partial) s += x;
//       String c=Arrays.toString(partial.toArray());
       
       for(int i=0;i<numbers.size();i++) {
             ArrayList<Integer> remaining = new ArrayList<Integer>();
             int n = numbers.get(i);
             for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
             ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
             partial_rec.add(n);
             sum_up_recursive(remaining,target,partial_rec);
       }
    }
    static int sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
		return target;
    }
    
    static int sum(ArrayList<Integer> numbers) {
    	
        int sum = 0;
        for (int j: numbers) {
            sum += j;
        }
        return sum;
    }
    public static void main(String args[]) {
    	
        Integer[] numbers = {529,382,130,462,223,167,235,529};
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(numbers));
    	int target = 1344;
    	ArrayList<Integer>  list2= new ArrayList<Integer>(Arrays.asList(numbers));
    	int total_bag_weight = problem_B.sum(list2);
    	int kattis_bag_weight = problem_B.sum_up(list1,target);
    	
    	int remaining_weight_of_bag=(total_bag_weight)-(kattis_bag_weight);
    	System.out.println(target+" \t\t \t    |  \t\t  "+ remaining_weight_of_bag+"\n");
    	System.out.println("Bag Kattis will carry first"+" | "+ "Remaining weight_of_bag") ;
    	
    	
//      Integer[] numbers = {528,129,376,504,543,363,213,138,206,440,504,418};
//      int target = 2181;
//      
//      kattis_bag_weight=sum_up(list1,target);
    	
        
    }
}