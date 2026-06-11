package Task2;
import java.util.ArrayList;
class Thread1 extends Thread {
    ArrayList<String> words;
    String word;
    Thread1(ArrayList<String> words, String word) {
        this.words = words;
        this.word = word;
    }
    @Override
    public void run() {
        for (String wrd : words) {
            if (wrd.equals(word)) {
                System.out.println("Word found by " + Thread.currentThread().getName());
                // Thread.currentThread().interrupt();
                return; 
            } 
        }
        System.out.println("Word not found!!!!");
    }
}
public class task2 {
    public static void main(String[] args) throws InterruptedException{
        String str = "To find the size or length of a standard array in Java append length directly to the name of your array variable Note that this is a built-in property not a method meaning it does not use parentheses () at the end";
        String[] arr = str.split(" ");
        int n = arr.length;
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        ArrayList<String> arr3 = new ArrayList<>();
        for (int i=0;i<n/3;i++) {
            arr1.add(arr[i]);
        }
        for (int i=n/3;i<2*n/3;i++) {
            arr2.add(arr[i]);
        }
        for (int i=2*n/3;i<n;i++) {
            arr3.add(arr[i]);
        }
        Thread t1 = new Thread1(arr1, "find");
        Thread t2 = new Thread1(arr2, "find");
        Thread t3 = new Thread1(arr3, "find");
        t1.start();
        t2.start();
        t3.start();
    }
}
