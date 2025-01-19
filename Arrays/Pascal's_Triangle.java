// 118. Pascal's Triangle

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

class Pascal's_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> nelist = new ArrayList();
        List<Integer> Row = new ArrayList();
        
        for(int i = 0 ;i < numRows ; i++){
            if(i==0){
                Row.add(1);
            }
            else{
                Row.add(1);
                Row.add(1);
            }
            Row.add(1);
            nelist.add(Row);
            Row.clear();
        }


        for(List<Integer> i : nelist ){
            for(Integer j:i){
                System.out.println(j);
            }
        }
        return nelist;
    }
}