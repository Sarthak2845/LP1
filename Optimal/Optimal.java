import java.util.*;
class Optimal{
    static int pageFault(int pages[], int n ,int capacity){
        HashSet<Integer>s=new HashSet<>(capacity);
        int page_fault=0;
        for(int i=0;i<n;i++){
            if(s.size()<capacity){
                if(!s.contains(pages[i])){
                    s.add(pages[i]);
                    page_fault++;
                }
            }
            else{
                if(!s.contains(pages[i])){
                    int pageToReplace=findPageToReplace(s,pages,n,i);
                    s.remove(pageToReplace);
                    s.add(pages[i]);
                    page_fault++;
                }
            }
        }
        return page_fault;
    }
    static int findPageToReplace(HashSet<Integer> s, int[] pages, int n, int currentIndex){
        int farthest = currentIndex;
        int pageToReplace = -1;
        for(int page:s){
            int nextUse=Integer.MAX_VALUE;
            for(int j=currentIndex+1;j<n;j++){
                if(pages[j]==page){
                    nextUse=j;
                    break;
                }
            }
            if(nextUse==Integer.MAX_VALUE){
                return page;
            }
            if(nextUse>farthest){
                farthest=nextUse;
                pageToReplace=page;
            }
        }
        return pageToReplace;
    }
    public static void main(String[] args) {
        int pages[] = {2, 3, 2, 1, 5, 2, 4, 5, 3, 2, 5, 2};
        int capacity = 3;
        int n = pages.length;
        int pageF = pageFault(pages, n, capacity);
        System.out.println("Page Faults: " + pageF);
        System.out.println("Page Hits: " + (n - pageF));
    }
}