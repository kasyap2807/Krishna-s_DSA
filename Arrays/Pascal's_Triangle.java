// 2. Pascal's Triangle

// Given an integer numRows, return the first numRows of Pascal's triangle.

// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

// Example 1:

// Input: numRows = 5
// Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2:

// Input: numRows = 1
// Output: [[1]]
 

// Constraints:

// 1 <= numRows <= 30

import java.util.*;

class Pascals_Triangle {
        public static void main(String[] args) {
            int numRows = 5;

            List<List<Integer>> nelist = new ArrayList();
            
            for(int i = 0 ;i < numRows ; i++){
            List<Integer> Row = new ArrayList();
                if(i==0){
                    Row.add(1);
                }
                else{
                    Row.add(1);
                    for(int h=0; h<i-1; h++){
                        Integer let = nelist.get(i-1).get(h)+(nelist.get(i-1)).get(h+1);
                        Row.add(let);
                    }
                    Row.add(1);
                }
               nelist.add(Row);
            }
    
    
            for(List<Integer> i : nelist ){
                for(int j:i){
                    System.out.print(j);
                }
                System.out.println("");
            }
        }
    
}

// Sample input 

// 5

// sample OutPut

// 1
// 11
// 121
// 1331
// 14641