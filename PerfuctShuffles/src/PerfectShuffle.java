
/**
 * Lucas Waldrop
 * Perfect Shuffles
 * 8/28/19
 * Programming IV
 */
public class PerfectShuffle {

    private int[] deck;

    //Class constructor initializes int[] deck
    public PerfectShuffle(int size) {
        deck = new int[size];
        for (int x = 0; x < size; x++) {
            deck[x] = x;
        }
    }

    /**
     * inShuffle methods splits deck into top/bottom arrays; pulls bottom card
     * from bottom, then top, repeat; returns shuffled array
     */
    public int[] inShuffle(int[] input) {
        int[] bottom = new int[input.length / 2];
        int[] top = new int[input.length / 2];
        int[] shuffled = new int[input.length];

        //two for loops seperate int[] deck into top/bottom
        for (int x = 0; x < input.length / 2; x++) {

            top[x] = input[x];
            bottom[x] = input[x + (input.length / 2)];

        }

        boolean useTop = false;
        int trackTop = 0;
        int trackBottom = 0;

        for (int x = 0; x < input.length; x++) {

            if (useTop) {

                shuffled[x] = top[trackTop];
                trackTop++;
                useTop = false;

            } else {

                shuffled[x] = bottom[trackBottom];
                trackBottom++;
                useTop = true;

            }

        }

        for (int z = 0; z < shuffled.length; z++) {
            System.out.print(shuffled[z]);
        }

        System.out.print("\n");
        return shuffled;

    }

    /**
     * outShuffle does opposite of inShuffle; pulls bottom card from top, then
     * top, repeat; returns shuffled array
     */
    public int[] outShuffle(int[] input) {

        int[] bottom = new int[input.length / 2];
        int[] top = new int[input.length / 2];
        int[] shuffled = new int[input.length];
        int count = 0;

        //two for loops seperate int[] deck into top/bottom
        for (int x = 0; x < input.length / 2; x++) {
            bottom[x] = x;
        }
        for (int y = input.length; y > input.length / 2; y--) {
            top[count] = y;
            count++;
        }

        //initalizes int[] shuffled
        for (int x = 0; x < top.length; x++) {
            shuffled[x] = top[x];
            shuffled[x + 1] = bottom[x];
        }

        System.out.print("\n");

        return shuffled;
    }

    /**
     * perfectInShuffle returns number of times deck was shuffled to return to
     * it's original state
     */
    public int perfectInShuffle() {
        boolean allEqual = true;
        int count = 1;
        int[] shuffled = this.inShuffle(deck);
        while (allEqual) {
            shuffled = this.inShuffle(shuffled);
            count++;
            for (int z = 0; z < deck.length; z++) {
                if (shuffled[z] == deck[z]) {

                } else {
                    allEqual = false;
                }
            }

        }
        return count;
    }

    /**
     * perfectOutShuffle returns number of times deck was shuffled to return to
     * it's original state
     */
    public int perfectOutShuffle() {
        boolean allEqual = true;
        int count = 1;
        int[] shuffled = this.outShuffle(deck);
        while (allEqual) {
            shuffled = this.outShuffle(shuffled);
            count++;
            for (int z = 0; z < deck.length; z++) {
                if (shuffled[z] == deck[z]) {

                } else {
                    allEqual = false;
                }
            }

        }
        return count;
    }
}
