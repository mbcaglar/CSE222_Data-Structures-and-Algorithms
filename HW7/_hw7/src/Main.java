import java.util.NavigableMap;
import java.util.TreeMap;

// Kitaptan yardım alınmıştır.

public class Main
{
    public static void main(String args[]){

    try {

         final Boolean q1 = Q1Test();
         final Boolean q2 = Q2Test();


        if (q1==q2 ==  Boolean.TRUE) {
            System.out.println("Your tests is done. Make sure that you test all methods of class!! ");
            return;
        }
    }
    catch (IllegalArgumentException e){
        System.out.println();
        System.out.println("Arguman hatası...out of range durumu..!");
    }


    }
    public static Boolean Q1Test(){

        NavigableMap<String,String> turkey = new BinaryNavMap<>();

        turkey.put("uskudar","istanbul");
        turkey.put("kadıkoy","istanbul");
        turkey.put("cekirge","bursa");
        turkey.put("gebze","kocaeli");
        turkey.put("gebze","kocaeli");
        turkey.put("niksar","tokat");
        turkey.put("kecıoren","ankara");
        turkey.put("aksaray","istanbul");
        turkey.put("foca","izmir");
        turkey.put("manavgat","antalya");
        turkey.put("kahta","adıyaman");
        turkey.put("biga","canakkale");

        System.out.println("The original set odds is " + turkey);

         NavigableMap<String,String> m = turkey.subMap("gebze",true,"gebze",true);
        System.out.println("The ordered set m is " + m);
        System.out.println("The first entry is " +turkey.firstEntry());



        return Boolean.TRUE;

    }

    public static Boolean Q2Test(){

        HashMap<String,String> turkey=new HashTableChaining<String,String>();

        turkey.put("edremit","balikesir");
        turkey.put("edremit","van");
        turkey.put("kemalpasa","bursa");
        turkey.put("kemalpasa","izmir");
        turkey.put("ortakoy","istanbul");//we assume a district
        turkey.put("ortakoy","aksaray");
        turkey.put("ortakoy","corum");
        turkey.put("kecıoren","ankara");
        turkey.put("pinarbasi","kastamonu");
        turkey.put("pinarbasi","kayseri");
        turkey.put("eregli","konya");
        turkey.put("eregli","tekirdag");
        turkey.put("eregli","zonguldak");
        turkey.put("golbasi","adıyaman");
        turkey.put("golbasi","ankara");
        turkey.put("biga","canakkale");


        System.out.println("get(pinarbasi)-> "+turkey.get("pinarbasi"));
        System.out.println("size-> "+turkey.size());
        System.out.println("remove(uskudar)->"+turkey.remove("uskudar"));
        System.out.println("remove(ortakoy)->"+turkey.remove("ortakoy"));
        System.out.println("size-> "+turkey.size());


        /* *test all

            V get(Object key);

            V put(K key, V value);

            V remove(Object key);

            int size();

        * */


       return Boolean.TRUE;
    }
}
