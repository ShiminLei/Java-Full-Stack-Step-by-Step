package chapter3.day04;

public class Task {
    public static void main(String[] args) {
        int[] array = {1,3,2,4,5,6};
        System.out.println(find(array, 9));
        System.out.println(findMax(array));
        bubble(array);
        for (int num: array){
            System.out.print(num);
        }
        System.out.println();
        System.out.println(binarySearch(array, 0));
    }

    /**
     * 二分查找
     * @param array
     * @param target
     * @return
     */
    private static boolean binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (array[mid]==target){
                return true;
            }else if (array[mid]<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 冒泡排序
     * @param array
     */
    private static void bubble(int[] array){
        for (int i=0; i<array.length; i++){
            int min = array[i];
            int index = i;
            for (int j=i; j<array.length; j++){
                if (array[j]<min){
                    min = array[j];
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    /**
     * 查找最大值
     * @param array
     * @return
     */
    private static int findMax(int[] array){
        int big = Integer.MIN_VALUE;
        for (int num: array){
            if (num>big){
                big = num;
            }
        }
        return big;
    }

    /**
     * 查找整数
     * @param array
     * @param target
     * @return
     */
    private static boolean find(int[] array, int target){
        for (int num: array){
            if (num==target){
                return true;
            }
        }
        return false;
    }

}
