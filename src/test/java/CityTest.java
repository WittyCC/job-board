import org.junit.*;
import static org.junit.Assert.*;

public class CityTest {

  @Before
   public void tearDown() {
     City.clear();
   }

  @Test
  public void city_instantiatesCorrectly_true() {
    City testCity = new City("Seattle");
    assertEquals(true, testCity instanceof City);
  }

  @Test
  public void getCityName_cityInstantiatesWithName_Seattle() {
    City testCity = new City("Seattle");
    assertEquals("Seattle", testCity.getCityName());
  }

  @Test
  public void all_returnsAllInstancesOfCity_true() {
    City firstCity = new City("Seattle");
    City secondCity = new City("Moscow");
    assertEquals(true, City.all().contains(firstCity));
    assertEquals(true, City.all().contains(secondCity));
  }

  @Test
  public void clear_emptiesAllCitiesFromList_0() {
    City testCity = new City("Seattle");
    City.clear();
    assertEquals(City.all().size(), 0);
  }

  @Test
  public void getId_citiesInstantiateWithAnId_1() {
    City testCity = new City("Seattle");
    assertEquals(1, testCity.getId());
  }

  @Test
  public void find_returnsCityWithSameId_secondCity() {
    City.clear();
    City firstCity = new City("Seattle");
    City secondCity = new City("Moscow");
    assertEquals(City.find(secondCity.getId()), secondCity);
  }

  @Test
  public void getJobOpenings_initiallyReturnsEmptyList_ArrayList() {
    City.clear();
    City testCity = new City("Seattle");
    assertEquals(0, testCity.getJobOpenings().size());
  }

  @Test
  public void addJobOpening_addsJobOpeningToList_true() {
    City testCity = new City("Seattle");
    JobOpening testJobOpening = new JobOpening("Developer", "Develop software", "employer@email.com");
    testCity.addJobOpening(testJobOpening);
    assertTrue(testCity.getJobOpenings().contains(testJobOpening));
  }
}
