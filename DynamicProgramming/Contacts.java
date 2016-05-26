import java.io.*;
import java.util.*;

public class Contacts {
    static class Node {        
        HashMap<Character, Node> children;
        boolean isWord;
        public Node() {
            children = new HashMap<>();
            isWord = false;
        }
    }
    
    static Node head;
    
    public static void add(String s) {
        Node curr = head;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //if (curr == null) curr = new Node();
            if (!curr.children.containsKey(c)) {
                Node newNode = new Node();
                curr.children.put(c, newNode);
            }
            // if (i == s.length() - 1) curr.isWord = true;
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    public static int find(String prefix) {
        Queue<Node> queue = new LinkedList<Node>();
        Node curr = head;
        char start;
        for (char c: prefix.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
            } else {
                return 0;
            }
        }
        
        int words = 0;
        queue.add(curr);
        
        while (!queue.isEmpty()) {
            curr = queue.remove();

            if (curr.isWord) words++;
            for (char c : curr.children.keySet()) {
                Node toAdd = curr.children.get(c);
                queue.add(toAdd);
            }
        }
        return words;
    }
    
    public static void main(String[] args) {
        head = new Node();
        Scanner scan = new Scanner(System.in);
        int operations = scan.nextInt();
        ArrayList<Integer> found = new ArrayList<>();
        for (int i = 0; i < operations; i++) {
            String instruction = scan.next();
            String word = scan.next();
            if (instruction.equals("add")) {
                add(word);
            } else {
                int numWords = find(word);
                found.add(numWords);
            }
        }

        for (int num: found) {
            System.out.println(num);
        }
    }
}