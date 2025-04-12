public class peakelement {
    public static int peak(int[] arr){
         int low=0;
         int high=arr.length-1;
         while(low<high){
            int mid=low+(high-low)/2;
             if(arr[mid]>arr[mid+1]){
                high=mid;
             }else{
                low=mid+1;
             }
         }
         return low;
    }
    public static void main(String[] args){
          
        int[] arr = {1, 3, 20, 4, 1};
        int index=peak(arr);
        System.out.println("Peak element found at index: " + index + ", value: " + arr[index]);
    }
}
