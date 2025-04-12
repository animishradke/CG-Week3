public class selectionsort {
    public static void main(String[] args){
        int[] arr={7,8,3,1,2};
        
        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
        

            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }

            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
