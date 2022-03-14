package binarysearch;

public class BinarySearchDemo {

    public static void main(String[] args) {

        int[] ints = {1,2,3,4,5,6};
        int index = binarySearch(ints,3);
        System.out.println(index);

    }

    public static int binarySearch(int[] ints,int num){

        int middle = ints.length/2;
        int end;

        while (true){

            if (ints[middle]==num){
                return middle;
            }else if (ints[middle]>num){
                end = 0;
                middle = (middle+end)/2;
            }else {
                end=middle;
                middle = (ints.length-middle)/2;
            }

            if (end == middle){
                return -1;
            }

        }

    }

}
