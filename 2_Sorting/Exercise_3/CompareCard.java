package Hw2_22000081_NguyenTienDat.Exercise_3;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

class CompareCard implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        String[] ranksOrder = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        List<String> rankList = Arrays.asList(ranksOrder);

        int rankComparison = Integer.compare(rankList.indexOf(c1.getRank()), rankList.indexOf(c2.getRank()));
        if (rankComparison != 0) {
            return rankComparison;
        }

        return c1.getSuit().compareTo(c2.getSuit());
    }
}