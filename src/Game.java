package src;

public class Game {
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
}
