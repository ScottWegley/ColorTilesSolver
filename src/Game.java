package src;

public class Game {
    private int WIDTH = 23;
    private int HEIGHT = 15;

    private ColorTile[][] board;

    public Game() {
        board = new ColorTile[WIDTH][HEIGHT];
    }

    public Game(int _W, int _H){
        WIDTH = _W;
        HEIGHT = _H;
        board = new ColorTile[WIDTH][HEIGHT];
    }

    /**
     * This stores the possible values of any filled tile.
     */
    public enum ColorTile {
        RED(264350825),
        BROWN(211919874),
        TIEL(109262031),
        GREEN(4403202),
        PINK(267527422),
        WHITE(195225786),
        PURPLE(212964554),
        ORANGE(262306816),
        NINTH_ONE(213068906),
        BG_W(259251447),
        BG_G(249805038);

        /** A unique key corresponding to the RGB values of any tile. */
        private final int rgbKey;

        private ColorTile(int _key){
            this.rgbKey = _key;
        }

        /**
         * @return The unique key corresponding to a tiles RGB values.
         */
        public int getKey(){
            return rgbKey;
        }
    }

    /**
     * Function to combine RGB values into one unique number.
     * Inspired by https://stackoverflow.com/a/16697893.
     * @param _r The R value of our color.
     * @param _g The G value of our color.
     * @param _b The B value of our color.
     * @return A unique number with an R, G, & B encode inside.
     * Use {@link #rgbDecode(int _key)} to get the R, G, & B values from the key.
     */
    public static int rgbEncode(int _r, int _g, int _b) {
        return (_r << 20) | (_g << 10) | _b;
    }

    /**
     * Function to retrieve RGB values from a unique key.
     * @param _key The combined RGB values, unique for every combination.
     * @return An array of integers in the order R,G,B.
     */
    public static int[] rgbDecode(int _key){
        return new int[]{_key >> 20, (_key >> 10) & 0x3FF, _key & 0x3FF};
    }

    public static void main(String[] args) {
        
    }
}
