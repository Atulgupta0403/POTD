// You are given timings of n meetings in the form of (start[i], end[i]) where start[i] is the start time of meeting i and end[i] is the finish time of meeting i. Return the maximum number of meetings that can be accommodated in a single meeting room, when only one meeting can be held in the meeting room at a particular time. 

// Note: The start time of one chosen meeting can't be equal to the end time of the other chosen meeting.



// Input: n = 6, start[] = [1, 3, 0, 5, 8, 5], end[] =  [2, 4, 6, 7, 9, 9]
// Output: 4
// Explanation: Maximum four meetings can be held with given start and end timings. The meetings are - (1, 2), (3, 4), (5,7) and (8,9)



import java.util.*;

public class MeetingScheduler {

    public static int maxMeetings(int[] start, int[] end, int n) {
        // Create an array of pairs (end, start)
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = end[i];
            meetings[i][1] = start[i];
        }

        // Sort the meetings based on end time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 1;  // At least one meeting can always be held
        int lastEndTime = meetings[0][0];

        // Iterate through the sorted list of meetings
        for (int i = 1; i < n; i++) {
            if (meetings[i][1] > lastEndTime) {
                count++;
                lastEndTime = meetings[i][0];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        System.out.println("Maximum number of meetings: " + maxMeetings(start, end, n));
    }
}
