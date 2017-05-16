// This code will compile with warnings about unchecked exceptions
import java.util.ArrayList;
public class SortsClass {

    // public static Comparable[] selectionSort(Comparable[] theArray, int n) {
        // // ---------------------------------------------------
        // // Sorts the items in an array into ascending order.
        // // Precondition: theArray is an array of n items.
        // // Postcondition: theArray is sorted into
        // // ascending order.
        // // Calls: indexOfLargest.
        // // ---------------------------------------------------
        // // last = index of the last item in the subarray of
        // // items yet to be sorted
        // // largest = index of the largest item found
        // for (int last = n-1; last >= 1; lqast--) {
            // // Invariant: theArray[last+1..n-1] is sorted
            // // and > theArray[0..last]
            // // select largest item in theArray[0..last]
            // int largest = indexOfLargest(theArray, last+1);
            // // swap largest item theArray[largest] with
            // // theArray[last]
            // Comparable temp = theArray[largest];
            // theArray[largest] = theArray[last];
            // theArray[last] = temp;
        // } // end for
        // return theArray;
    // } // end selectionSort
    
    
    public static ArrayList selectionSort(ArrayList <Account> theArray, int n) {
        Account temp = null;
        for(int last = n-1; last > 0; last--) {
            if(theArray.get(last).getID().compareTo(theArray.get(last-1).getID()) == -1) {
                temp = theArray.get(last);
                theArray.set(last, theArray.get(last-1));
                theArray.set(last-1, temp);
            }
        }
        
        return theArray;
    }

    private static int indexOfLargest(Comparable[] theArray, int size) {
        // ---------------------------------------------------
        // Finds the largest item in an array.
        // Precondition: theArray is an array of size items;
        // size >= 1.
        // Postcondition: Returns the index of the largest
        // item in the array.
        // ---------------------------------------------------
        int indexSoFar = 0; // index of largest item found so far
        // Invariant: theArray[indexSoFar]>=theArray[0..currIndex-1]
        for (int currIndex = 1; currIndex < size; ++currIndex) {
            if (theArray[currIndex].compareTo(theArray[indexSoFar])>0) {
                indexSoFar = currIndex;
            } // end if
        } // end for
        return indexSoFar; // index of largest item
    } // end indexOfLargest

    public static Comparable[] bubbleSort(Comparable[] theArray, int n) {
        // ---------------------------------------------------
        // Sorts the items in an array into ascending order.
        // Precondition: theArray is an array of n items.
        // Postcondition: theArray is sorted into ascending
        // order.
        // ---------------------------------------------------
        boolean sorted = false; // false when swaps occur
        for (int pass = 1; (pass < n) && !sorted; ++pass) {
            // Invariant: theArray[n+1-pass..n-1] is sorted
            // and > theArray[0..n-pass]
            sorted = true; // assume sorted
            for (int index = 0; index < n-pass; ++index) {
                // Invariant: theArray[0..index-1] <= theArray[index]
                int nextIndex = index + 1;
                if (theArray[index].compareTo(theArray[nextIndex]) > 0) {
                    // exchange items
                    Comparable temp = theArray[index];
                    theArray[index] = theArray[nextIndex];
                    theArray[nextIndex] = temp;
                    sorted = false; // signal exchange
                } // end if
            } // end for
            // Assertion: theArray[0..n-pass-1] < theArray[n-pass]
        } // end for
        return theArray;
    } // end bubbleSort

    public static void insertionSort(Comparable[] theArray, int n) {
        // ---------------------------------------------------
        // Sorts the items in an array into ascending order.
        // Precondition: theArray is an array of n items.
        // Postcondition: theArray is sorted into ascending
        // order.
        // ---------------------------------------------------
        // unsorted = first index of the unsorted region,
        // loc = index of insertion in the sorted region,
        // nextItem = next item in the unsorted region
        // initially, sorted region is theArray[0],
        // unsorted region is theArray[1..n-1];
        for (int unsorted = 1; unsorted < n; ++unsorted) {
            // Invariant: theArray[0..unsorted-1] is sorted
            // find the right position (loc) in
            // theArray[0..unsorted] for theArray[unsorted],
            // which is the first item in the unsorted
            // region; shift, if necessary, to make room
            Comparable nextItem = theArray[unsorted];
            int loc = unsorted;
            while ((loc > 0) &&
            (theArray[loc-1].compareTo(nextItem) > 0)) {
                // shift theArray[loc-1] to the right
                theArray[loc] = theArray[loc-1];
                loc--;
            } // end while
            // insert nextItem into sorted region
            theArray[loc] = nextItem;
        } // end for
    } // end insertionSort

    private static void merge(Comparable[] theArray, int first, int mid, int last) {
        // ---------------------------------------------------------
        // Merges two sorted array segments theArray[first..mid] and
        // theArray[mid+1..last] into one sorted array.
        // Precondition: first <= mid <= last. The subarrays
        // theArray[first..mid] and theArray[mid+1..last] are
        // each sorted in increasing order.
        // Postcondition: theArray[first..last] is sorted.
        // Implementation note: This method merges the two
        // subarrays into a temporary array and copies the result
        // into the original array anArray.
        // ---------------------------------------------------------
        int maxSize = theArray.length;
        // temporary array
        Comparable[] tempArray = new Comparable[maxSize];
        // initialize the local indexes to indicate the subarrays
        int first1 = first; // beginning of first subarray
        int last1 = mid; // end of first subarray
        int first2 = mid + 1; // beginning of second subarray
        int last2 = last; // end of second subarray
        // while both subarrays are not empty, copy the
        // smaller item into the temporary array
        int index = first1; // next available location in
        // tempArray
        while ((first1 <= last1) && (first2 <= last2)) {
            // Invariant: tempArray[first1..index-1] is in order
            if (theArray[first1].compareTo(theArray[first2])<0) {
                tempArray[index] = theArray[first1];
                first1++;
            }
            else {
                tempArray[index] = theArray[first2];
                first2++;
            } // end if
            index++;
        } // end while
        // finish off the nonempty subarray
        // finish off the first subarray, if necessary
        while (first1 <= last1) {
            // Invariant: tempArray[first1..index-1] is in order
            tempArray[index] = theArray[first1];
            first1++;
            index++;
        } // end while
        // finish off the second subarray, if necessary
        while (first2 <= last2) {
            // Invariant: tempArray[first1..index-1] is in order
            tempArray[index] = theArray[first2];
            first2++;
            index++;
        } // end while
        // copy the result back into the original array
        for (index = first; index <= last; ++index) {
            theArray[index] = tempArray[index];
        } // end for
    } // end merge

    public static void mergesort(Comparable[] theArray, int first, int last) {
        // ---------------------------------------------------------
        // Sorts the items in an array into ascending order.
        // Precondition: theArray[first..last] is an array.
        // Postcondition: theArray[first..last] is sorted in
        // ascending order.
        // Calls: merge.
        // ---------------------------------------------------------
        if (first < last) {
            // sort each half
            int mid = (first + last)/2; // index of midpoint
            // sort left half theArray[first..mid]
            mergesort(theArray, first, mid);
            // sort right half theArray[mid+1..last]
            mergesort(theArray, mid+1, last);
            // merge the two halves
            merge(theArray, first, mid, last);
        } // end if
    } // end mergesort

    private static void choosePivot(Comparable[] theArray, int first, int last) {
        // ---------------------------------------------------------
        // Chooses a pivot for quicksort's partition algorithm and
        // swaps it with the first item in an array.
        // Precondition: theArray[first..last] is an array;
        // first <= last.
        // Postcondition: theArray[first] is the pivot.
        // ---------------------------------------------------------
        // Implementation left as an exercise.
    } // end choosePivot

    private static int partition(Comparable[] theArray, int first, int last) {
        // ---------------------------------------------------------
        // Partitions an array for quicksort.
        // Precondition: theArray[first..last] is an array;
        // first <= last.
        // Postcondition: Returns the index of the pivot element of
        // theArray[first..last]. Upon completion of the method,
        // this will be the index value lastS1 such that
        // S1 = theArray[first..lastS1-1] < pivot
        // theArray[lastS1] == pivot
        // S2 = theArray[lastS1+1..last] >= pivot
        // Calls: choosePivot.
        // ---------------------------------------------------------
        // tempItem is used to swap elements in the array
        Comparable tempItem;
        // place pivot in theArray[first]
        choosePivot(theArray, first, last);
        Comparable pivot = theArray[first]; // reference pivot
        // initially, everything but pivot is in unknown
        int lastS1 = first; // index of last item in S1
        // move one item at a time until unknown region is empty
        for (int firstUnknown = first + 1; firstUnknown <= last;
        ++firstUnknown) {
            // Invariant: theArray[first+1..lastS1] < pivot
            // move item from unknown to proper region
            if (theArray[firstUnknown].compareTo(pivot) < 0) {
                // item from unknown belongs in S1
                ++lastS1;
                tempItem = theArray[firstUnknown];
                theArray[firstUnknown] = theArray[lastS1];
                theArray[lastS1] = tempItem;
            } // end if
            // else item from unknown belongs in S2
        } // end for
        // place pivot in proper position and mark its location
        tempItem = theArray[first];
        theArray[first] = theArray[lastS1];
        theArray[lastS1] = tempItem;
        return lastS1;
    } // end partition

    public static void quickSort(Comparable[] theArray, int first, int last) {
        // ---------------------------------------------------------
        // Sorts the items in an array into ascending order.
        // Precondition: theArray[first..last] is an array.
        // Postcondition: theArray[first..last] is sorted.
        // Calls: partition.
        // ---------------------------------------------------------
        int pivotIndex;
        if (first < last) {
            // create the partition: S1, Pivot, S2
            pivotIndex = partition(theArray, first, last);
            // sort regions S1 and S2
            quickSort(theArray, first, pivotIndex-1);
            quickSort(theArray, pivotIndex+1, last);
        } // end if
    } // end quickSort

} // end SortsClass