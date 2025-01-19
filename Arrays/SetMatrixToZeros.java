// 1. Set Matrix Zeroes

// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

 

// Example 1:


// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
// Example 2:


// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

// Constraints:

// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
 

// Follow up:

// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?


class SetMatrixToZeros {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] newmar = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n ; j++){
               if(matrix[i][j]==0){
                for(int k = 0; k < m ; k++){
                    newmar[k][j]=1;
                }
                for(int k = 0; k < n ; k++){
                    newmar[i][k]=1;
                }
               }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n ; j++){
                if(newmar[i][j]==0){
                    newmar[i][j]= matrix[i][j];
                }
                else{
                    newmar[i][j]=0;
                }
            }
        }

        System.out.println("Sample InPut");

        System.out.print("[");
        for(int[] x : matrix){
            System.out.print("[");
            for(int y : x){
                System.out.print(y+",");
            }
            System.out.println("]");
        }
        System.out.println("]");

        System.out.println("Sample OutPut");

        System.out.print("[");
        for(int[] x : newmar){
            System.out.print("[");
            for(int y : x){
                System.out.print(y+",");
            }
            System.out.println("]");
        }
        System.out.println("]");
        
       

    }
}


// Sample InPut
// [[1,1,1,]
// [1,0,1,]
// [1,1,1,]
// ]
// Sample OutPut
// [[1,0,1,]
// [0,0,0,]
// [1,0,1,]
// ]

// My Time Complexity

// O(M∗N∗(M+N))