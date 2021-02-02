/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thiefproblem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Timothy.Wamalwa
 */
public class ThiefProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

         int[]value = new int[]{10,40,30,50};
        int[]weight=new int[]{5,4,6,4};
        int maxWeight = 10;
       
         if(value.length!=weight.length){
             System.out.println("Array Length mismatch");
         }else{
        List<Integer>lookupTable = new ArrayList<>();
        for(int v : value){
            lookupTable.add(v);
        }
         StringBuilder output = new StringBuilder();
         output.append("Pick Items with the following value/values : ");
        int maxValue=knapSackBruteforce(maxWeight,weight,value,value.length);
        System.out.println("Max Val "+ maxValue);
        for(int v : value){
            int check = maxValue-v;
            if(lookupTable.contains(check)){
                output.append(check+ ",");
            }
        }
       
        System.out.println(output);
         }
        
    }
    
    public static int knapSackBruteforce(int maxWeight,int[]weight,int[]value,int len){
        if(maxWeight==0 || len ==0)
            return 0; // Base case
        if(weight[len-1]>maxWeight){
            knapSackBruteforce(maxWeight, weight, value, len-1);
        }else{
            int val1 = value[len-1]+knapSackBruteforce(maxWeight-weight[len-1], weight, value, len-1);
            int val2 = knapSackBruteforce(maxWeight, weight, value, len-1);
            return Math.max(val1, val2);
        }
        
        return 0;
    }
    
}
