import java.util.List;
import java.util.ArrayList;

public class JobOpening {
  private String mJobTitle;
  private String mDescription;
  private String mContactInfo;
  private static List<JobOpening> instances = new ArrayList<JobOpening>();
  private int mId;

  public JobOpening(String jobTitle, String description, String contactInfo) {
    mJobTitle = jobTitle;
    mDescription = description;
    mContactInfo = contactInfo;
    instances.add(this);
    mId = instances.size();
  }

  public String getJobTitle() {
    return mJobTitle;
  }

  public String getDescription() {
    return mDescription;
  }

  public String getContactInfo() {
    return mContactInfo;
  }

  public static List<JobOpening> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static JobOpening find(int id) {
    return instances.get(id - 1);
  }
}
