import java.util.*;
public class comparison 
{
    public static void main(String[] args) 
    {
        int nums[] = new int[1000000];
        Random rand = new Random();

        for (int i = 0; i < nums.length; i++) 
        {
            nums[i] = rand.nextInt(1000000);
        }
        int randIndex = rand.nextInt(1000000);
        int randSearchNum = nums[randIndex];

        long startRandSearch = System.nanoTime();
        boolean foundRand = randomSearch(nums, randSearchNum);
        long endRandSearch = System.nanoTime();
        long durRandSearch = endRandSearch - startRandSearch;

        System.out.println("Random Search:");
        System.out.println("   - Time: " + durRandSearch + " ns");
        System.out.println("   - Found: " + foundRand);

        Arrays.sort(nums);

        long startBinarySearch = System.nanoTime();
        boolean foundBinary = binarySearch(nums, randSearchNum);
        long endBinarySearch = System.nanoTime();
        long durBinarySearch = endBinarySearch - startBinarySearch;

        System.out.println("\nBinary Search:");
        System.out.println("   - Time: " + durBinarySearch + " ns");
        System.out.println("   -Found: " + foundBinary);

        long timeDiff = durRandSearch - durBinarySearch;
        System.out.println("\nTime Difference: " + timeDiff + " ns");
    }

    private static boolean randomSearch(int[] nums, int target) 
    {
        for (int i = 0; i < nums.length; i++) 
        {
            if (nums[i] == target) 
            {
                return true;
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] nums, int target) 
    {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) 
        {
            int mid = low + (high - low) / 2;
            int midValue = nums[mid];

            if (midValue == target) 
            {
                return true;
            } 
            else if (midValue < target) 
            {
                low = mid + 1;
            } 
            else 
            {
                high = mid - 1;
            }
        }

        return false;
    }
}