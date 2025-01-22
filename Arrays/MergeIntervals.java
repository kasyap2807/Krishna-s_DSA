import java.util.ArrayList;

public class MergeIntervals {
    Solution s = new Solution();

}

// 8. Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104

// 14/171
class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> NEWlist = new ArrayList<int[]>();
        int[] TempArray = new int[2];
        for (int i = 0; i < intervals.length; i++) {
            if (i != intervals.length - 1) {
                if (intervals[i][1] >= intervals[i + 1][0]) {
                    if (intervals[i + 1][0] <= intervals[i][0]) {
                        TempArray[0] = intervals[i + 1][0];
                        TempArray[1] = intervals[i + 1][1] > intervals[i][1] ? intervals[i + 1][1] : intervals[i][1];
                    } else {
                        TempArray[0] = intervals[i][0];
                        TempArray[1] = intervals[i + 1][1];
                    }
                    ++i;
                } else {
                    TempArray[0] = intervals[i][0];
                    TempArray[1] = intervals[i][1];
                }
                System.out.println(TempArray[0] + "" + TempArray[1]);
            } else {
                TempArray[0] = intervals[i][0];
                TempArray[1] = intervals[i][1];
                System.out.println(TempArray[0] + "" + TempArray[1]);

            }

            int x = TempArray[0];
            int y = TempArray[1];

            NEWlist.add(new int[] { x, y });
        }

        int[][] returnarray = new int[NEWlist.size()][2];

        for (int i = 0; i < returnarray.length; i++) {
            returnarray[i] = NEWlist.get(i);
        }

        return returnarray;

    }
}

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
