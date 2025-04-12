public class DoublyLinkedLists {
    String MovieTitle;
    String Director;
    int YearofRealease;
    int Rating;
    DoublyLinkedLists next;
    DoublyLinkedLists prev;

public DoublyLinkedLists(String MovieTitle,String Director,int YearofRealease,int Rating){
  this.MovieTitle=MovieTitle;
  this.Director=Director;
  this.YearofRealease=YearofRealease;
  this.Rating=Rating;
  this.next=null;
  this.prev=null;

}
}

class DoublyLinkedlists {
    DoublyLinkedLists head;
    DoublyLinkedLists tail;
    //add node at the end
    public void addNode(String title, String director, int year, int rating){
      DoublyLinkedLists newNode=new DoublyLinkedLists(title,director,year,rating);
      if(head==null){
      head=tail=newNode;
      }
      else{
      tail.next=newNode;
      newNode.prev=tail;
      tail=newNode;  
      }
     System.out.println("Movie added:" +title);
    }
      //node at the start
    public void addNodeatstart(String title, String director, int year, int rating){
      DoublyLinkedLists newNode=new DoublyLinkedLists(title,director,year,rating);
      if(head==null){
      head=tail=newNode;
      }
      else{
      newNode.next=head;
      head.prev=newNode;
      head=newNode;
      }
     System.out.println("Movie added:" +title);
    }

    //node at any specific position
    public void addNodeatanyposition(String title, String director, int year, int rating,int position){
      DoublyLinkedLists newNode=new DoublyLinkedLists(title,director,year,rating);
                if(position<=1 ||head==null){
                  addNodeatstart(title,director,year,rating);
                  return;
                }
                DoublyLinkedLists current=head;                 
                int index=1;  
                while(current!=null && index<position-1 ){
                  current=current.next;
                  index++;
                }    

                if(current==null ||current.next==null){
                  addNodeatstart(title,director,year,rating);
                  return;
                }

                newNode.next=current.next;
                newNode.prev=current;
                current.next.prev=newNode;
                current.next=newNode;
                System.out.println("Movie added at position " + position + ": " + title);
    }
    public void displayForward() {
      if (head == null) {
          System.out.println("No movies in the list.");
          return;
      }
}

//remove a node by title
    public void removenodebytitle(String title){
       if(head==null){
        System.out.println("list is empty");
        return;
       }
       DoublyLinkedLists current=head;
       while(current!=null && !current.nodeTitle.equalsIgnorecase(title));


    }


}