import java.util.Stack;
 class queuetostack{
public static void main(String[] args){
 Stack<Integer> stack=new Stack<>();
 stack.push(5);
 stack.push(2);
 stack.push(3);
 stack.push(18);
 System.out.println(stack);
}
}
class queueusingStack{
    private Stack<Integer> first;
    private Stack<Integer> second;

    public queueusingStack(){
       first=new Stack<>();
       second=new Stack<>();
    }
    public void add(int item){
        first.push(item);
    }
    public int remove(){
        while(!first.isEmpty()){
          second.push(first.pop());
        }
       int removed =second.pop();
       while(!second.isEmpty()){
        first.push(second.pop());
       }
       return removed;
    }
      public int peek() throws Exception{
        while(!first.isEmpty()){
            second.push(first.pop());
          }
         int peeked =second.peek();
         while(!second.isEmpty()){
          first.push(second.pop());
         }
         return peeked;
      }

    public boolean isEmpty(){
        return first.isEmpty();
    }
}






