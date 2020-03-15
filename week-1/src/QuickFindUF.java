/**
 * Eager approach but slow, for N union operations it will take O(N*N) i.e., quadratic time
 */
public class QuickFindUF {

    private int[] id;

    public QuickFindUF(int N){
        id = new int[N];
        // O(N)
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public boolean connected(int p, int q){
        // O(1) -> 2 array accesses
        return id[p] == id[q];
    }

    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++){
            // One possible Insidious bug may occur if you use id[p] in the if clause below
            if(id[i] == pid){
                id[i] = qid;
            }
        }
    }
}
