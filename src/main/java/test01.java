
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

class test01 {
    private static Function<Integer[], Integer> r = (n) -> {
        int m = 0;
        for (int i = 0; i < n.length; i++) {
            if (n[m] < n[i]) m = i;
        }
        return m;
    };
    private static ArrayList<Integer[]> t = new ArrayList<>();

    public static void main(String[] args) {
        int cic = 0;
        boolean mm =true;
        Integer[] s = {0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11};

        t.add(s);

        while(mm) {
            Integer[] s_add = addt(t.get(cic++));
            for(int ii=0; ii < t.size(); ii++ ) {
                if (Arrays.equals(t.get(ii), s_add)) {
                    for(int iii: s_add)
                        System.out.print( " " + iii);
                    System.out.print( " " + (cic -ii) + " " +cic);
                    mm = false;
                    break;
                }
            }
            t.add(s_add);
        }
    }

    private static Integer[] addt(Integer[] k) {
        int i, n;
        Integer[] s = new Integer[k.length];
        for( i = 0; i < s.length; i++) s[i] = k[i];
        for (n = r.apply(s) + 1, i = s[n-1], s[n-1] = 0; i > 0; i--) {
            if (n == s.length) n = 0;
            s[n++]++;
        }
        return s;
    }
}