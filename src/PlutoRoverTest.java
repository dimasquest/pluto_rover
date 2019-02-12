import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlutoRoverTest {
    
    int defaultSize = 4;
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
    void noRotationGivenRAndL() {

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

    }

    @Test
    void coordinatesWrapVertically() {

    }

}