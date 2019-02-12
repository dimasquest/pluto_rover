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

    }

    @Test
    void movesBackGivenB() {

    }

    @Test
    void noRotationGivenRAndL() {

    }

    @Test
    void parsesStringFRFAndMoves(String frf) {

    }

    @Test
    void coordinatesWrapHorizontally() {

    }

    @Test
    void coordinatesWrapVertically() {
        
    }

}