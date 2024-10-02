package data.structure;

import data.structure.list.ArrayList;
import data.structure.list.LinkedList;
import data.structure.list.Stack;

import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(5);
        list.add("Hello");
        list.add("Surya");
        list.add("Singh");
        list.add("We");
        list.add("Are");
        list.add("Calling");
        list.add("From");
        list.add("HDFC");
        list.add("Bank");
        list.add("Here");
        list.add("Is");
        list.add("Loan");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            //iterator.remove();
        }
        list.remove("Bank");
        list.set(9, "Aja");
        System.out.println(list);

        LinkedList<String> list1 = new LinkedList<>();
        //list1.removeFirst();
        list1.add("Hello");
        list1.add("Surya");
        list1.add("Singh");
        list1.add("We");
        list1.add("Are");
        list1.add("Calling");
        list1.add("From");
        list1.add("HDFC");
        list1.add("Bank");
        list1.add("Here");
        list1.add("Is");
        list1.add("Loan");
        list1.addFirst("Le Bro");
        Iterator<String> iterator1 = list1.iterator();
        while (iterator1.hasNext()) {
            String value = iterator1.next();
            //iterator.remove();
        }
        list1.remove("Bank");
        list1.set(9, "Aja");
        list1.remove(3);
        list1.removeLast();
        list1.removeFirst();
        System.out.println(list1);
        System.out.println(list1.size());
        System.out.println(list1.indexOf("Bank"));


        Stack<String> stack = new Stack<>();
        stack.push("apple");
        stack.push("banana");
        stack.push("cherry");
        stack.push("date");
        stack.push("elderberry");
        stack.push("fig");
        stack.push("grape");
        stack.push("honeydew");
        stack.push("kiwi");
        stack.push("lemon");
        System.out.println(stack.contains("grape"));
        System.out.println(stack);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.indexOf("lemon"));
        System.out.println(stack);



    }
}