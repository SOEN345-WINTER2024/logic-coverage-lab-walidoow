import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CheckItTest {

    private final PrintStream printStream = System.out;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void init() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void teardown() {
        System.setOut(printStream);
    }

    @Test
    void testPredicateCoverageCheckIt1() {
        CheckIt.checkIt(true, false, true);
        Assertions.assertEquals("P is true", outputStream.toString().trim());
    }

    @Test
    void testPredicateCoverageCheckIt2() {
        CheckIt.checkIt(false, true, false);
        Assertions.assertEquals("P isn't true", outputStream.toString().trim());
    }

    @Test
    void testClauseCoverageCheckIt1() {
        CheckIt.checkIt(true, true, true);
        Assertions.assertEquals("P is true", outputStream.toString().trim());
    }

    @Test
    void testClauseCoverageCheckIt2() {
        CheckIt.checkIt(false, false, true);
        Assertions.assertEquals("P isn't true", outputStream.toString().trim());
    }

    @Test
    void testCACCCoverageCheckIt1() {
        CheckIt.checkIt(true, true, false);
        Assertions.assertEquals("P is true", outputStream.toString().trim());
    }

    @Test
    void testCACCCoverageCheckIt2() {
        CheckIt.checkIt(false, true, false);
        Assertions.assertEquals("P isn't true", outputStream.toString().trim());
    }

    @Test
    void testRACCCoverageCheckIt1() {
        CheckIt.checkIt(true, false, true);
        Assertions.assertEquals("P is true", outputStream.toString().trim());
    }

    @Test
    void testRACCCoverageCheckIt2() {
        CheckIt.checkIt(false, false, true);
        Assertions.assertEquals("P isn't true", outputStream.toString().trim());
    }

}