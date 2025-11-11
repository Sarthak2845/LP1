import java.util.HashMap;
import java.util.Iterator;
import java.util.HashSet;

class LRU{
    static int pageFaults(int[] pages,int n,int capacity){
        HashSet<Integer>s=new HashSet<>(capacity);
        HashMap<Integer,Integer>indexes=new HashMap<>();
        int page_faults=0;
        for(int i=0;i<n;i++){
            if(s.size()<capacity){
                if(!s.contains(pages[i])){
                    s.add(pages[i]);
                    page_faults++;
                }
                indexes.put(pages[i],i);
            }
            else{
                if(!s.contains(pages[i])){
                    int lru=Integer.MAX_VALUE,val=Integer.MIN_VALUE;
                    Iterator<Integer>itr=s.iterator();
                    while(itr.hasNext()){
                        int temp=itr.next();
                        if(indexes.get(temp)<lru){
                            lru=indexes.get(temp);
                            val=temp;
                        }
                    }
                    s.remove(val);
                    indexes.remove(val);
                    s.add(pages[i]);
                    page_faults++;
                }
                indexes.put(pages[i],i);
            }
        }
        return page_faults;
    }
    public static void main(String[] args){
        int pages[]={ 2,3,2,1,5,2,4,5,3,2,5,2 };
        int capacity=3;
        int n=pages.length;
        int pageF=pageFaults(pages,n,capacity);
        System.out.println("Page Fault: "+pageF);
        System.out.println("Page Hits:"+(n-pageF));
    }
}