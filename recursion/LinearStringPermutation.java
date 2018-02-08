import java.util.Deque;
import java.util.ArrayDeque;

public class LinearStringPermutation {

    public static void main(String [] args){
        LinearStringPermutation lsp = new LinearStringPermutation();
        lsp.generatePermutation("ab",2);
    }

    private void generatePermutation(String s, int k){
        String delimiter = "*";
        Deque<String> deque = new ArrayDeque<String>(0);
        deque.push(delimiter);
        int i=0;
        for(i =  0; i < s.length(); i++){
            deque.push(s.charAt(i)+"");
        }

        while(k >1){
            while(!deque.peek().equals(delimiter) ){
                String value = deque.pop();
                i=0;
                while(i < s.length()){
                    deque.add(value+s.charAt(i));
                    i++;
                }
            }
            deque.add(deque.pop());
            k--;            
        }
        deque.removeLast();
        print(deque);
    }
    private void print(Deque<String> deque){        
        for(String value : deque){
            System.out.println(value);
        }
        System.out.println();
    }

}