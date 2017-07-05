import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("jobOpenings", request.session().attribute("jobOpenings"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/jobOpenings", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<JobOpening> jobOpenings = request.session().attribute("jobOpenings");
      if (jobOpenings == null) {
        jobOpenings = new ArrayList<JobOpening>();
        request.session().attribute("jobOpenings", jobOpenings);
      }

      String jobTitle = request.queryParams("jobTitle");
      String description = request.queryParams("description");
      String contactInfo = request.queryParams("contactInfo");
      JobOpening newJobOpening = new JobOpening(jobTitle, description, contactInfo);
      jobOpenings.add(newJobOpening);
      request.session().attribute("jobTitle", newJobOpening);
      request.session().attribute("description", newJobOpening);
      request.session().attribute("contactInfo", newJobOpening);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
