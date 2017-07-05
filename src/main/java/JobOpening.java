public class JobOpening {
  private String mJobTitle;

  private String mDescription;

  private String mContactInfo;

  public JobOpening(String jobTitle, String description, String contactInfo) {
    mJobTitle = jobTitle;
    mDescription = description;
    mContactInfo = contactInfo;
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
}
