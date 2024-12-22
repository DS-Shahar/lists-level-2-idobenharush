package gh;
import java.util.*;
public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    int[] arr1 = {10, 20, 30, 40, 50, 60, 70};
    Node<Integer> L1 = makeList(arr);
    Node<Integer> L2 = makeList(arr1);
    //System.out.println(ex1(L1,L2));
    // System.out.println(ex2(L1));
    //System.out.println(Distances(L1,5));
    System.out.println(ex4(L1));
    }
    	 public static Node<Integer> makeList(int[] arr) {
    	        Node<Integer> head = new Node<>(arr[0]);
    	        Node<Integer> cur = head;
    	        for (int i = 1; i < arr.length; i++) {
    	            Node<Integer> next = new Node<>(arr[i]);
    	            cur.setNext(next);
    	            cur = next;
    	        }
    	        return head;
    	        }
    	 public static Node<Integer> ex1(Node<Integer> l1, Node<Integer> l2) {
    		    Node<Integer> dummy = new Node<>(-1);
    		    Node<Integer> current = dummy;

    		    while (l1 != null && l2 != null) {
    		        if (l1.getValue() <= l2.getValue()) {
    		            current.setNext(l1);
    		            l1 = l1.getNext();
    		        } else {
    		            current.setNext(l2);
    		            l2 = l2.getNext();
    		        }
    		        current = current.getNext();
    		    }

    		    if (l1 != null) {
    		        current.setNext(l1);
    		    } else if (l2 != null) {
    		        current.setNext(l2);
    		    }

    		    return dummy.getNext();
    	 }
    	 public static Node<Integer> ex2(Node<Integer> h) {
    		    if (h == null || h.getNext() == null)
    		        return h;
    		    Node<Integer> c = h;
    		    Node<Integer> i = null;
    		    int t;
    		    while (c != null) {
    		        i = c.getNext();
    		        while (i != null) {
    		            if (c.getValue() > i.getValue()) {
    		                t = c.getValue();
    		                c.setValue(i.getValue());
    		                i.setValue(t);
    		            }
    		            i = i.getNext();
    		        }
    		        c = c.getNext();
    		    }
    		    return h;
    		}
    	 public static int Distances(Node<Integer> L1, int num) {
    		 Node<Integer> current = L1;
    		 int dfs = 0;
    		 int dfe = 0;
    		 while(current.getValue() != num) {
    			 dfs ++;
    			 current = current.getNext();
    		 }
    		 current = current.getNext();
    		 while(current != null) {
    			 if(current.getValue() == num) 
    				 dfe = 0;
    			 else 
    				dfe++; 
    			 current = current.getNext();
    			 }
    		 return dfe + dfs;
    		 }
    	 public static boolean ex4(Node<Integer> L1) {
    		 Node <Integer> current = ex2(L1);
    		 while(current.getNext() != null) {
    			 if(current.getValue()==current.getNext().getValue()) {
    	    		 return false;
    			 }
    			 current = current.getNext();
    		 }
    		 return true;
    	 }
