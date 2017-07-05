import org.junit.*;
import static org.junit.Assert.*;

public class JobOpeningTest {

  @Test
  public void JobOpening_instantiatesCorrectly_true() {
    JobOpening newJobOpening = new JobOpening("Developer", "Develop software", "employer@email.com");
    assertEquals(true, newJobOpening instanceof JobOpening);
  }

  @Test
  public void JobOpening_instantiatesWithJobTitle_String() {
    JobOpening newJobOpening = new JobOpening("Developer", "Develop software", "employer@email.com");
    assertEquals("Developer", newJobOpening.getJobTitle());
  }

}
