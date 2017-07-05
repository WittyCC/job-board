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

    get("jobOpenings/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/jobOpening-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/jobOpenings", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("jobOpenings", JobOpening.all());
      model.put("template", "templates/jobOpenings.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/jobOpenings", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      City city = City.find(Integer.parseInt(request.queryParams("cityId")));

      String jobTitle = request.queryParams("jobTitle");
      String description = request.queryParams("description");
      String contactInfo = request.queryParams("contactInfo");
      JobOpening newJobOpening = new JobOpening(jobTitle, description, contactInfo);

      city.addJobOpening(newJobOpening);

      model.put("city", city);
      model.put("template", "templates/city-jobOpenings-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // post("/jobOpenings", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //
    //   ArrayList<JobOpening> jobOpenings = request.session().attribute("jobOpenings");
    //   if (jobOpenings == null) {
    //     jobOpenings = new ArrayList<JobOpening>();
    //     request.session().attribute("jobOpenings", jobOpenings);
    //   }
    //
    //   String jobTitle = request.queryParams("jobTitle");
    //   String description = request.queryParams("description");
    //   String contactInfo = request.queryParams("contactInfo");
    //   JobOpening newJobOpening = new JobOpening(jobTitle, description, contactInfo);
    //   jobOpenings.add(newJobOpening);
    //   request.session().attribute("jobTitle", newJobOpening);
    //   request.session().attribute("description", newJobOpening);
    //   request.session().attribute("contactInfo", newJobOpening);
    //
    //   model.put("template", "templates/success.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    get("/cities/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/city-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      City newCity = new City(name);
      model.put("template", "templates/city-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("cities", City.all());
      model.put("template", "templates/cities.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/cities/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));
      model.put("city", city);
      model.put("template", "templates/city.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("cities/:id/jobOpenings/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.params(":id")));
      model.put("city", city);
      model.put("template", "templates/city-jobOpenings-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
