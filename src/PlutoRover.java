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

    public void parseCommands(String commands) {
        char[] commandsArray = commands.toCharArray();

        for (char aCommandsArray : commandsArray) {
            move(aCommandsArray);
            System.out.println(this.x + " " + this.y);
        }
    }

    public void move(char move) {
        switch (move) {
            case 'F':
                checkDirectionAndMoveForward();
                break;
            case 'B':
                checkDirectionAndMoveBackward();
                break;
            case 'R':
                this.direction = this.direction.next();
                break;
            case 'L':
                this.direction = this.direction.previous();
                break;
            default:
                System.out.println("Invalid command");
        }
    }

    private void checkBoundariesAndWrap(int x, int y) {
        if (y == grid.length) {
            this.y = 0;
        }
        else if (y < 0) {
            this.y = grid.length - 1;
        }
        else if (x == grid.length) {
            this.x = 0;
        }
        else if (x < 0) {
            this.x = grid.length - 1;
        }
        else {
            this.x = x;
            this.y = y;
        }
    }

    private void checkDirectionAndMoveForward() {
        switch (this.direction) {
            case NORTH: checkBoundariesAndWrap(x, y + 1); break;
            case SOUTH: checkBoundariesAndWrap(x, y - 1); break;
            case EAST: checkBoundariesAndWrap(x + 1, y); break;
            case WEST: checkBoundariesAndWrap(x - 1, y); break;
        }
    }

    private void checkDirectionAndMoveBackward() {
        switch (this.direction) {
            case NORTH: checkBoundariesAndWrap(x, y - 1); break;
            case SOUTH: checkBoundariesAndWrap(x, y + 1); break;
            case EAST: checkBoundariesAndWrap(x - 1, y); break;
            case WEST: checkBoundariesAndWrap(x + 1, y); break;
        }
    }
}
