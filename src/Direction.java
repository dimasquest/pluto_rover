public enum Direction {

    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction next() {
        return values()[ordinal() + 1];
    }

    public Direction previous() {
        return values()[ordinal() - 1];
    }
}
