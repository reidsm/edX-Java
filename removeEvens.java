import java.util.*;
public class removeEvens {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("moo");
        list.add("honk");
        list.add("ribbit");
        list.add("bark");
        list.add("yip");
        System.out.println(list);
        removeEvenLength(list);
    }
    public static ArrayList<String> removeEvenLength(ArrayList<String> list) {
        ArrayList<String> newList = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i).length() % 2 != 0){
                newList.add(list.get(i));
            } else {
                //System.out.println(list.get(i));
            }
        }
        Collections.reverse(newList);
        System.out.println(newList);
        return(newList);
    }
}