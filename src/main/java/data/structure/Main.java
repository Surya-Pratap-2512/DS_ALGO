package data.structure;


import data.structure.heap.Heap;
import data.structure.heap.MaxHeap;
import data.structure.heap.MinHeap;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       Heap<String> maxHeap = new MaxHeap<>();
       maxHeap.push("Surya");
       maxHeap.push("Vinayak");
       maxHeap.push("Vaibhav");
       maxHeap.push("Preetish");
       maxHeap.push("Ansh");
       maxHeap.push("Vaibhav");
       System.out.println(maxHeap);
       System.out.println(maxHeap.pushPop("Ajeet"));
       System.out.println(maxHeap.popPush("Saksham"));
       System.out.println(maxHeap);
       System.out.println(maxHeap.contains("Surya"));
       maxHeap.delete("Surya");
       maxHeap.delete("Preetish");
       System.out.println(maxHeap);
       System.out.println(maxHeap.pop());
       System.out.println(maxHeap);

       Heap<String> minHeap = new MinHeap<>(List.of(
               "Surya","Preetish","Vinayak","Ansh","Ajeet","Vaibhav","Saksham","Akshit","Harshit","Vishal"
       ));
       minHeap.delete("Ansh");
       minHeap.push("Rajesh");
       Heap<String> maxHeap1 = new MaxHeap<>(List.of(
               "Surya","Preetish","Vinayak","Ansh","Ajeet","Vaibhav","Saksham","Akshit","Harshit","Vishal"
       ));
       System.out.println(minHeap);
       System.out.println(maxHeap1);

       MaxHeap<Integer> mh = new MaxHeap<>(List.of(10,  9,  8,  5,  6,  7,  4 ), List.of(15,  14,  13,  11,  12,  10,  9));
       System.out.println(mh);
       mh.merge(new MaxHeap<>(List.of(20, 18, 17, 15, 16, 14, 13, 10, 11, 12, 9, 8, 7, 6, 5)));
       System.out.println(mh);

    }
}