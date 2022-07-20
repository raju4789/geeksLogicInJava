package com.buildingLogic.arraySpecial;

/**
 * Given a collection of intervals, merge all overlapping intervals.

Have you met this question in a real interview?  
Example
Given intervals => merged intervals:

[                     [
  (1, 3),               (1, 6),
  (2, 6),      =>       (8, 10),
  (8, 10),              (15, 18)
  (15, 18)            ]
]
Challenge
O(n log n) time and O(1) extra space.

Algorithm:
---------
1) Sort all intervals in decreasing order of start time.
2) Traverse sorted intervals starting from first interval, 
   do following for every interval.
      a) If current interval is not first interval and it 
         overlaps with previous interval, then merge it with
         previous interval. Keep doing it while the interval
         overlaps with the previous one.         
      b) Else add current interval to output list of intervals.
Note that if intervals are sorted by decreasing order of start times, we can quickly check if intervals overlap or not by comparing start time of previous interval with end time of current interval.


 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

}

public class MergeIntervals {

	public static void main(String[] args) {
		ArrayList<Interval> input = new ArrayList<Interval>() {
			{
				add(new Interval(2, 3));
				add(new Interval(4, 5));
				add(new Interval(6, 7));
				add(new Interval(8, 9));
				add(new Interval(1, 10));
			}
		};
		
		/*ArrayList<Interval> input = new ArrayList<Interval>() {
			{
				add(new Interval(1, 3));
				add(new Interval(2, 6));
				add(new Interval(8, 10));
				add(new Interval(15, 18));
			}
		};*/

		
		  /*ArrayList<Interval> input = new ArrayList<Interval>() {{ add(new Interval(1,
		  4)); add(new Interval(1, 4)); }};*/
		 

		List<Interval> mergedIntervals = merge(input);

		for (int i = 0; i < mergedIntervals.size(); i++) {
			System.out.println(mergedIntervals.get(i));
		}

	}

	
	    public static void mergeInterval(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval> () {
            @Override
            public int compare(Interval v1, Interval v2) {
                return v1.start - v2.start;
            }  
        }) ; //n log(n)
        
        // for(Interval interval : intervals) {
        //     System.out.println(interval.toString());
        // }
        
        // List<Interval> mergedIntervals = new ArrayList<>();
        
        // int start= intervals.get(0).start;
        // int end = intervals.get(0).end; 
        // Interval currentInterval = intervals.get(0);
        int currentIntervalIndex = 0;
        for(int i=1; i < intervals.size();i++) { //(4, 5) // O(n)
            if(intervals.get(currentIntervalIndex).end >= intervals.get(i).start) {
                intervals.get(currentIntervalIndex).end = Math.max(intervals.get(currentIntervalIndex).end,intervals.get(i).end);
                intervals.remove(i);
                i --;
            } else {
                // mergedIntervals.add(new Interval(start,end));
                // mergedIntervals.add(currentInterval);
                // start = intervals.get(i).start;
                // end = intervals.get(i).end;
                // currentInterval = intervals.get(i);
                currentIntervalIndex =i;
            }
        }
        // mergedIntervals.add(new Interval(start,end));
        // mergedIntervals.add(currentInterval);
        
        // return mergedIntervals;
    }
	/**
	 * @param intervals: interval list.
	 * @return: A new interval list.
	 */
	public static List<Interval> merge(List<Interval> intervals) {
		int intervalsLength = intervals.size();

		if (intervalsLength == 0 || intervalsLength == 1) {
			return intervals;
		}

		// Sort Intervals in increasing order of
		// start time
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});

		int index = 0;
		for (int i = 0; i < intervalsLength; ++i) {
			if(index != 0 && intervals.get(index -1).end >= intervals.get(i).start) {
				while(index != 0 && intervals.get(index -1).end >= intervals.get(i).start) {
					intervals.get(index-1).start = Math.min(intervals.get(index-1).start, intervals.get(i).start);
					intervals.get(index-1).end = Math.max(intervals.get(index-1).end, intervals.get(i).end);
					--index;
				}
			}else {
				intervals.set(index, intervals.get(i));
			}
			++index;
		}
		
		return intervals.subList(0, index);

	}

}
