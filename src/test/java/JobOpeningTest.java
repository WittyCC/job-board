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

  @Test
  public void all_returnsAllInstancesOfJobOpening_true() {
    JobOpening firstJobOpening = new JobOpening("Developer", "Develop software", "employer@email.com");
    JobOpening secondJobOpening = new JobOpening("Cashier", "Handle cash", "employer2@email.com");
    assertEquals(true, JobOpening.all().contains(firstJobOpening));
    assertEquals(true, JobOpening.all().contains(secondJobOpening));
  }

  @Test
  public void clear_emptiesAllJobOpeningsFromArrayList_0() {
    JobOpening newJobOpening = new JobOpening("Developer", "Develop software", "employer@email.com");
    JobOpening.clear();
    assertEquals(0, JobOpening.all().size());
  }

  @Test
  public void getId_jobOpeningsInstantiateWithAnId_1() {
    JobOpening.clear();  // Remember, the test will fail without this line! We need to empty leftover Tasks from previous tests!
    JobOpening newJobOpening = new JobOpening("Developer", "Develop software", "employer@email.com");
    assertEquals(1, newJobOpening.getId());
  }

  @Test
  public void find_returnsJobOpeningWithSameId_secondJobOpening() {
    JobOpening firstJobOpening = new JobOpening("Developer", "Develop software", "employer@email.com");
    JobOpening secondJobOpening = new JobOpening("Cashier", "Handle cash", "employer2@email.com");    assertEquals(JobOpening.find(secondJobOpening.getId()), secondJobOpening);
  }
}
