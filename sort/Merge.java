public class Merge {
    private static  Comparable[] aux;
    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int mid = lo + (hi -lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo; 
        int j = mid + 1;

        for(int k = i; k < a.length; k++){
            aux[k] = a[k];
        }

        for(int k = lo; k <= hi; k++) {
            // 左半边用尽（取右半边元素）
            if (i > mid)                    a[k] = aux[j++];
            // 右半边用尽（取左半边元素）
            else if (j > hi)                a[k] = aux[i++];
            // 右半边当前元素小于左半边元素（取右半边元素）
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            // 右半边当前元素大于左半边元素（取左半边元素）
            else                            a[k] = aux[i++];   
        }
    }
}

