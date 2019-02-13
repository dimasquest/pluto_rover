public class PlutoRover {

    Direction direction;
    int x;
    int y;
    int gridSize;

    public PlutoRover(int size) {
        this.x = 0;
        this.y = 0;
        this.direction = Direction.NORTH;
        this.gridSize = size;
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
        if (y == gridSize) {
            this.y = 0;
        }
        else if (y < 0) {
            this.y = gridSize - 1;
        }
        else if (x == gridSize) {
            this.x = 0;
        }
        else if (x < 0) {
            this.x = gridSize - 1;
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
