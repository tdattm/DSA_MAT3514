package Hw3_22000081_NguyenTienDat.Ex2_3_4;

public class WordCount {
    private String word;
    private int count;

    public WordCount(String word) {
        this.word = word;
        this.count = 1; // Khởi tạo số lần xuất hiện là 1
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordCount)) return false;
        WordCount that = (WordCount) o;
        return word.equals(that.word);
    }

    @Override
    public String toString() {
        return word + ": " + count;
    }
}
