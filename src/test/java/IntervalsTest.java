import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntervalsTest {

    @Test
    void testIntervalConstruction0(){
        String expected  = "G";
        String[] args = {"M2", "F", "asc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction1(){
        String expected  = "D";
        String[] args = {"M2", "C", "asc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void testIntervalConstruction2(){
        String expected  = "C";
        String[] args = {"M2", "D", "dsc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction3(){
        String expected  = "F#";
        String[] args = {"P5", "B", "asc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction4(){
        String expected  = "A";
        String[] args = {"m2", "Bb", "dsc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction5(){
        String expected  = "Abb";
        String[] args = {"M3", "Cb", "dsc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction6(){
        String expected  = "D#";
        String[] args = {"P4", "G#", "dsc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction7(){
        String expected  = "Gbb";
        String[] args = {"m2", "Fb", "asc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction8(){
        String expected  = "D#";
        String[] args = {"M2", "E#", "dsc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction9(){
        String expected  = "B";
        String[] args = {"P4", "E", "dsc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction10(){
        String expected  = "E";
        String[] args = {"m2", "D#", "asc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction11(){
        String expected  = "F#";
        String[] args = {"M7", "G", "asc"};
        String actual = Intervals.intervalConstruction(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction12(){
        String expected  = "M2";
        String[] args = {"C", "D"};
        String actual = Intervals.intervalIdentification(args);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testIntervalConstruction13(){
        String expected  = "P5";
        String[] args = {"B", "F#", "asc"};
        String actual = Intervals.intervalIdentification(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction14(){
        String expected  = "m2";
        String[] args = {"Fb", "Gbb", "asc"};
        String actual = Intervals.intervalIdentification(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction16(){
        String expected  = "M3";
        String[] args = {"Cb", "Abb", "dsc"};
        String actual = Intervals.intervalIdentification(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction17(){
        String expected  = "P4";
        String[] args = {"G#", "D#", "dsc"};
        String actual = Intervals.intervalIdentification(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction18(){
        String expected  = "P4";
        String[] args = {"E", "B", "dsc"};
        String actual = Intervals.intervalIdentification(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction19(){
        String expected  = "M2";
        String[] args = {"E#", "D#", "dsc"};
        String actual = Intervals.intervalIdentification(args);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testIntervalConstruction20(){
        String expected  = "m3";
        String[] args = {"B", "G#", "dsc"};
        String actual = Intervals.intervalIdentification(args);
        Assertions.assertEquals(expected, actual);
    }

}
