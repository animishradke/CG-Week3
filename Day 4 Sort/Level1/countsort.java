public class countsort {
    public static void countingsort(int[] arr){
        if(arr.length==0){
            return;
        }

        int max=arr[0];
        for(int num:arr){
              if(num>max){
                max=num;
              }
        }
  
        int[] count=new int[max+1];
        for(int num:arr){
            count[num]++;
        }


        int index=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[index++]=i;
                count[i]--;
            }
        }
    }
        public static void main(String[] args){
            int[] arr = {4, 2, 2, 8, 3, 3, 1};

            System.out.println("Before Sorting:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
    
            countingsort(arr);
    
            System.out.println("\nAfter Sorting:");
            for (int num : arr) {
                System.out.print(num + " ");
            }
        
        }
    }

