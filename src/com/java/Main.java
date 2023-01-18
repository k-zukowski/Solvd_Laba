import buildings.Hotel;
import buildings.SkyScraper;
import buildings.Warehouse;
import buildings.abstracts.Building;
import buildings.enums.SkyScraperType;
import buildings.interfaces.IBuildingTypeFunctionality;
import commons.Constants;
import java.io.File;
import java.nio.file.NotDirectoryException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import orders.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Architect;
import people.Builder;
import people.ClientRepresentative;
import people.abstracts.Person;
import people.enums.Degree;
import people.exceptions.ValidateEmailException;
import people.exceptions.WrongYearsOfExperienceException;
import services.BuildingService;
import utils.MyFileUtils;

public class Main {

  final static Logger logger = LogManager.getLogger(Main.class.getName());

  public static void main(String... args) {
    /*
     * Setup
     *
     * */
    Constants constants = new Constants();
    constants.setFileName("FileName.txt");
    try {
      if (args[0].isEmpty() || args[0].isBlank() || !new File(args[0]).isDirectory()) {
        throw new NotDirectoryException(args[0]);
      }
      constants.setFilePath(args[0]);
    } catch (NotDirectoryException e) {

      logger.error("Provided directory isn't valid");
      throw new RuntimeException(e);
    }

    MyFileUtils myFileUtils = new MyFileUtils();
    myFileUtils.createFile(constants.getFilePath(), constants.getFileName());

    BuildingService buildingService = new BuildingService();
    double estimatedConcreteUsed = buildingService.calculateEstimatedConcrete(new Hotel());
    double calculateDiagonal = buildingService.calculateDiagonal(new Hotel());

    Person builder = null;
    try {
      builder = new Builder("name", "surname", LocalDate.now(), 3900f, 10);
    } catch (WrongYearsOfExperienceException e) {
      throw new RuntimeException(e);
    } finally {
      assert builder != null;
      logger.warn(String.format(
          "Pearson of class %s got assigned wrong valuer for field years of experience, should be positive",
          builder.getClass().getName()));
    }
    Person clientRepresentative = null;
    try {
      clientRepresentative = new ClientRepresentative("name", "surname", LocalDate.of(2000, 1, 31),
          "example@gmail.com");
    } catch (ValidateEmailException ignored) {

    } finally {
      logger.warn(String.format("Pearson of class %s got assigned wrong email value",
          builder.getClass().getName()));
    }

    ArrayList<IBuildingTypeFunctionality> buildings = new ArrayList<>();
    buildings.add(new SkyScraper(SkyScraperType.BASIC,3));
    buildings.add(new Warehouse());

    ArrayList<Builder> builders = new ArrayList<>();
    builders.add(new Builder());
    try {
      builders.add(new Builder("a","b", LocalDate.now(),23f,23));
    } catch (WrongYearsOfExperienceException e) {
      throw new RuntimeException(e);
    }

    ArrayList<Architect> architects = new ArrayList<>();
    architects.add(new Architect());
    architects.add(new Architect("a", "b", LocalDate.now(),20f, Degree.MID));

    Order order = new Order(buildings, "desc", LocalDateTime.now());
    order.setProjectResources(new SkyScraper(SkyScraperType.BASIC,3),builders,architects);
    order.getProjects().forEach(x-> System.out.println(x.getDays()));
  }
}
