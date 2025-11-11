import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
class FIFO{
      static int pageFaults(int pages[],int n, int capacity){
        HashSet<Integer>s= new HashSet<>(capacity);
        Queue<Integer> indexes = new LinkedList<>();
        int pageFaults=0;
        for(int i=0;i<n;i++){
            if(s.size()<capacity){
                if(!s.contains(pages[i])){
                    s.add(pages[i]);
                    pageFaults++;
                    indexes.add(pages[i]);
                }
            }
            else{
                if(!s.contains(pages[i])){
                    int val=indexes.peek();
                    indexes.poll();
                    s.remove(val);
                    s.add(pages[i]);
                    indexes.add(pages[i]);
                    pageFaults++;
                }
            }
        }
        return pageFaults;
      }
    public static void main(String args[]){
        int pages[]={ 2,3,2,1,5,2,4,5,3,2,5,2 };
        int capacity=3;
        int n=pages.length;
        int pageF=pageFaults(pages,n,capacity);
        System.out.println("Page Fault: "+pageF);
        System.out.println("Page Hits:"+(n-pageF));
    }
}
