
public class matrixbinarysearch {
    public static boolean binary(int[][] matrix,int target){
     if(matrix==null||matrix.length==0||matrix[0].length==0){
        return false;
     }
     int rows=matrix.length;
     int cols=matrix[0].length;

     
        int left=0;
        int right=rows*cols-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            int row=mid/cols;
            int col=mid%cols;
            int midvalue=matrix[row][col];
            if(midvalue==target){
                return true;
            }else if(midvalue<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
         return false;
    }
    public static void main(String[] args){
        int[][] matrix = {
            {1, 3, 5},
            {7, 10, 11},
            {12, 14, 17}
        };

        int target = 10;
        System.out.println("Found: " + binary(matrix, target));  // Output: true
    }
}
