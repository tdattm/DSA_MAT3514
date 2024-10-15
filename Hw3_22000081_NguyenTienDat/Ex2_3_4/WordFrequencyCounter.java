package Hw3_22000081_NguyenTienDat.Ex2_3_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chọn cách nhập dữ liệu (nhập \"1\" nếu từ bàn phím, nhập \"2\" nếu từ file): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng mới

        SimpleArrayList<WordCount> wordList = new SimpleArrayList<>();

        if (choice == 1) {
            // Nhập văn bản từ bàn phím
            System.out.println("Nhập văn bản (gõ 'exit' để dừng):");
            StringBuilder text = new StringBuilder();
            String line;

            while (!(line = scanner.nextLine()).equals("exit")) {
                text.append(line).append(" ");
            }

            countWordFrequency(text.toString(), wordList);
        } else if (choice == 2) {
            // Nhập tên file
            System.out.println("Nhập tên file: ");
            String filename = scanner.nextLine();

            try {
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                StringBuilder text = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    text.append(line).append(" ");
                }
                reader.close();
                countWordFrequency(text.toString(), wordList);
            } catch (IOException e) {
                System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
            }
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
        }

        // In ra số lần xuất hiện của các từ
        System.out.println("Số lần xuất hiện của các từ:");
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println(wordList.get(i).toString());
        }

        scanner.close();
    }

    private static void countWordFrequency(String text, SimpleArrayList<WordCount> wordList) {
        // Chuyển văn bản thành chữ thường và tách thành các từ
        String[] words = text.toLowerCase().split("\\W+");

        for (String word : words) {
            if (!word.isEmpty()) { // Kiểm tra từ không rỗng
                WordCount wordCount = new WordCount(word);
                int index = wordList.indexOf(wordCount);

                if (index != -1) {
                    // Nếu từ đã tồn tại, tăng số lần xuất hiện
                    wordList.get(index).incrementCount();
                } else {
                    // Nếu từ chưa tồn tại, thêm mới
                    wordList.add(wordCount);
                }
            }
        }
    }
}