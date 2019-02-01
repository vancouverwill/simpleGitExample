import java.util.ArrayList;

public class SubSetsInSets{
    
    public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) { ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>(); 
        int max = 1 << set.size();
        for (int i = 0; i < max; i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>(); int k = i;
            int index = 0;
            while (k > 0) {
            if ((k & 1) > 0) {
            subset.add(set.get(index)); 
                
            }
            k >>= 1;
            index++; }
            allsubsets.add(subset); 
            
        }
        return allsubsets; 
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>()); // Empty set
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset); //
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

     public static void main(String []args){
        System.out.println("Hello World");
        
        ArrayList<Integer> mySet = new ArrayList<Integer>();
        mySet.add(3);
        mySet.add(7);
        mySet.add(11);
        for (int number : mySet) {
            System.out.println(number);
        }
        System.out.println(mySet);
        // ArrayList<ArrayList<Integer>> result = getSubsets2(mySet);
        ArrayList<ArrayList<Integer>> result = getSubsets(mySet, 0);
        System.out.println(result);
        // int k = 1;
        // k <<= 2;
        // System.out.println(k);
        // int j = 2;
        // j >>= 1;
        // System.out.println(j);
     }
}