public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int N){
        id = new int[N];
        // O(N) -> N array accesses
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    private int root(int p){
        // chase parent pointers until reach root
        // O(depth of p array access)
        while(p != id[p])
            p = id[p];
        return p;
    }

    public boolean connected(int p, int q){
        // check if p and q have the same root
        // O(depth of p and q array accesses)
        return root(p) == root(q);
    }

    public void union(int p, int q){
        // change root of p to point to root of q
        // O(depth of p and q array access)
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}
