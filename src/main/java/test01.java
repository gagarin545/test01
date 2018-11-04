
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
        int record = 0;
        boolean status =true;
        Integer[] line = {0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11};

        t.add(line);

        while(status) {
            Integer[] line_add = get_max_value(t.get(record++));
            for(int n = 0; n < t.size(); n++ ) {
                if (Arrays.equals(t.get(n), line_add)) {
                    for(int line_old: line_add)
                        System.out.print( " " + line_old);
                    System.out.print( " " + (record - n) + " " + record);
                    status = false;
                    break;
                }
            }
            t.add(line_add);
        }
    }

    private static Integer[] get_max_value(Integer[] k) {
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