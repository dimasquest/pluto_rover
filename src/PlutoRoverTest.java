import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class PlutoRoverTest {
    
    private int defaultSize = 4;
    private List<Pair<Integer, Integer>> knownObstacles = new ArrayList<>();
    private Pair<Integer, Integer> newObstacle = new Pair<>(1, 1);
    PlutoRover p = new PlutoRover(defaultSize, knownObstacles);

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
        String command = "D";
        p.parseCommands(command);
        assert p.x == p.y;

    }

    @Test
    void rotatesTwicePointsSouth() {
        String commands = "RR";
        p.parseCommands(commands);
        assert p.direction == Direction.SOUTH;
    }

    @Test
    void noRotationGivenRAndL() {
        String commands = "RL";
        p.parseCommands(commands);
        assert p.x == 0
                && p.y == 0
                && p.direction == Direction.NORTH;
    }

    @Test
    void parsesStringFRFAndMoves() {
        String commands = "FRF";
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
        p.parseCommands(command);
        assert p.y == 0;
    }

    @Test
    void canAddToTheListOfObstacles() {
        p.knownObstacles.add(newObstacle);
        assert p.knownObstacles.size() == 1;
    }

    @Test
    void detectAnObstacleAndDoesntMoveForward() {
        String commands = "FRF";
        p.knownObstacles.add(newObstacle);
        p.parseCommands(commands);
        assert p.x == 0
                && p.y == 1;
    }
}