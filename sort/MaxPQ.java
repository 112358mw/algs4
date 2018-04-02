public class MaxPQ<Key extends Comparable<key>> {
    private Key[] pq;   //基于堆的完全二叉树
    private int N = 0;  //存储pq[1..N]，p[0] 没有使用

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert (Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private void swim(int K) {
        // 上浮
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        // 下沉
        while(2*k <= N) {
            int j = 2*k;
            if(j < N && less(j, j++)) j++;
            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
} 