
/**
 * Lucas Waldrop
 * Perfect Shuffles
 * Programming IV
 * 8/28/19
 */
public class PerfectShuffleDemo {

    public static void main(String[] args) {

        PerfectShuffle perfectShuffleRun = new PerfectShuffle(8);
        int[] cards = {0, 1, 2, 3, 4, 5, 6, 7};

        perfectShuffleRun.inShuffle(cards);
        perfectShuffleRun.outShuffle(cards);
        perfectShuffleRun.perfectInShuffle();
        perfectShuffleRun.perfectOutShuffle();
    }

}
