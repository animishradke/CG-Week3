import java.util.Stack;
public class sortstack  {
           public static void sort(Stack<Integer> st){
            if(st.isEmpty()){
                return;
            }
             int temp=st.pop();
             sort(st);
             insertAtcorrectpostion(st,temp);
           }

           public static void  insertAtcorrectpostion(Stack<Integer> st,int temp){
            if(st.isEmpty() || st.peek()<=temp){
                st.push(temp);
                return;
            }
            int elem=st.pop();
            insertAtcorrectpostion(st,temp);
            st.push(elem);

           } 

    public static void main(String[] args){
        Stack<Integer> st=new Stack<>();
        st.push(9);
        st.push(1);
        st.push(3);
        st.push(6);
        st.push(4);
        System.out.println("original stack"+st);
        sort(st);
        System.out.println("sorted:"+st);

    }
}
