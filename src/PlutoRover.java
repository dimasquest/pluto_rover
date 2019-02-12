public class PlutoRover {

    public Integer[] grid;
    public Direction direction;
    public int x;
    public int y;

    public PlutoRover(Integer[] grid) {
        this.grid = grid;
        this.x = 0;
        this.y = 0;
        this.direction = Direction.NORTH;
    }

}
