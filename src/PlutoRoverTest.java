import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlutoRoverTest {
    
    private int defaultSize = 4;
    PlutoRover p = new PlutoRover(new int[defaultSize][defaultSize]);

    @Test
    void createEmptyGridOfDimensionFour() {
        assert p.grid.length == defaultSize;
    }

    @Test
    void checkInitialCoordinatesAndDirection() {
        assert p.direction == Direction.NORTH
                && p.x == 0
                && p.y == 0;
    }

    @Test
    void movesForwardGivenF() {
        p.x = 0;
        p.y = 0;
        String command = "F";
        p.parseCommands(command);
        assert p.x == 0
                && p.y == 1;
    }

    @Test
    void movesBackGivenBFromOneOne() {
        p.x = 1;
        p.y = 1;
        String command = "B";
        p.parseCommands(command);
        assert p.y == 0
                && p.x == 1;
    }

    @Test
    void rejectWrongCommand() {
        p.x = 0;
        p.y = 0;
        String command = "D";
        p.parseCommands(command);
        assert p.x == p.y;

    }

    @Test
    void rotatesTwicePointsSouth() {
        String commands = "RR";
        p.direction = Direction.NORTH;
        p.parseCommands(commands);
        assert p.direction == Direction.SOUTH;
    }

    @Test
    void noRotationGivenRAndL() {
        String commands = "RL";
        p.x = 0;
        p.y = 0;
        p.direction = Direction.NORTH;
        p.parseCommands(commands);
        assert p.x == 0
                && p.y == 0
                && p.direction == Direction.NORTH;
    }

    @Test
    void parsesStringFRFAndMoves() {
        String commands = "FRF";
        p.x = 0;
        p.y = 0;
        p.parseCommands(commands);
        assert p.x == 1
                && p.y == 1;
    }

    @Test
    void coordinatesWrapHorizontally() {
        String command = "F";
        p.x = 3;
        p.y = 0;
        p.direction = Direction.EAST;
        p.parseCommands(command);
        assert p.x == 0;
    }

    @Test
    void coordinatesWrapVertically() {
        String command = "F";
        p.y = 3;
        p.x = 0;
        p.direction = Direction.NORTH;
        p.parseCommands(command);
        assert p.y == 0;
    }

}