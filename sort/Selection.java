public class Selection {
    public static void sort(Comparable[] a)
    {   //将a[]按升序排列
        int N  = a.length;
        for(int i = 0; i < N; i++)
        {   //将a[i]与a[i+1..N]中最小的元素排序
            int min = i;
            for (int j = i; j < N; j++)
                if(less(a[j], a[min]))
                    min = j;
            exch(a, i, min);        
        }
    }
}