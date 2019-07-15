import java.util.*;
public class maxLength {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("tacos");
        list.add("hamburgers");
        list.add("pizza");
        list.add("almonds");
        System.out.println(list);
        System.out.println(maxLength(list));
    }
    public static int maxLength(ArrayList<String> list) {
        ArrayList<Integer> listLength = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(list.size() == 0){
                return 0;
            } else {
                listLength.add(list.get(i).length());
                Collections.sort(listLength, Collections.reverseOrder());
            }
        }
        return(listLength.get(0));
    }
}


/*
int [][] numbers = new int [3][4];
            for (int r = 0; r < numbers.length; r++){
                for (int c = 0; c < numbers[0].length; c++){
                    numbers [r][c] = r + c;
 */