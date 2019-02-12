public class PlutoRover {

    public int[][] grid;
    public Direction direction;
    public int x;
    public int y;

    public PlutoRover(int[][] grid) {
        this.grid = grid;
        this.x = 0;
        this.y = 0;
        this.direction = Direction.NORTH;
    }

}
