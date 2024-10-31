import java.util.Arrays;

interface Filter {
    Object apply(Object o);
}

public class Main {
    public static Object[] filter(Object[] arr, Filter f) {
        Object[] result=new Object[arr.length];
        for (int i=0; i<arr.length; i++) {
            result[i]=f.apply(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Object[] ints={1, 2, 3, 4, 5};

        Filter filter=new Filter() {
            @Override
            public Object apply(Object o) {
                if (o instanceof Integer)
                    return ((int)o)*2;
                return o;
            }
        };

        Object[] ints2=filter(ints, filter);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
    }
}
