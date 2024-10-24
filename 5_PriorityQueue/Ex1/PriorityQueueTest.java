package Hw5_22000081_NguyenTienDat.Ex1;

public class PriorityQueueTest {

    static class Product {
        String name;
        int price;  // Price is the key.

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("Product{name='%s', price=%d}", name, price);
        }
    }

    public static void main(String[] args) {
        // Test 1: Priority Queue with Integers as keys.
        System.out.println("Testing Integer Priority Queue:");
        PriorityQueueInterface<Integer, Integer> intPQ = new UnsortedArrayPriorityQueue<>();
        testIntegerPriorityQueue(intPQ);

        // Test 2: Priority Queue with Products (name, price).
        System.out.println("\nTesting Product Priority Queue:");
        PriorityQueueInterface<Integer, Product> productPQ = new UnsortedArrayPriorityQueue<>();
        testProductPriorityQueue(productPQ);
    }

    // Test method for Integer PriorityQueue.
    private static void testIntegerPriorityQueue(PriorityQueueInterface<Integer, Integer> pq) {
        // Adding elements (key = value).
        pq.insert(5, 5);
        pq.insert(2, 2);
        pq.insert(8, 8);
        pq.insert(1, 1);

        // Removing and printing elements based on priority (min key first).
        while (!pq.isEmpty()) {
            System.out.println("Removed: " + pq.removeMin().getValue());
        }
    }

    // Test method for Product PriorityQueue.
    private static void testProductPriorityQueue(PriorityQueueInterface<Integer, Product> pq) {
        // Adding products with price as the key.
        pq.insert(300, new Product("Laptop", 300));
        pq.insert(100, new Product("Mouse", 100));
        pq.insert(200, new Product("Keyboard", 200));

        // Removing and printing products based on price (min price first).
        while (!pq.isEmpty()) {
            Product p = pq.removeMin().getValue();
            System.out.println("Removed: " + p);
        }
    }
}

