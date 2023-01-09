import buildings.Hotel;
import commons.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import people.Builder;
import people.ClientRepresentative;
import people.abstracts.Person;
import people.exceptions.ValidateEmailException;
import people.exceptions.WrongYearsOfExperienceException;
import services.BuildingService;
import utils.MyFileUtils;
import utils.exceptions.FileIsEmptyException;

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.time.LocalDate;

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
            if (args[0].isEmpty() || args[0].isBlank() || !new File(args[0]).isDirectory()){
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
            logger.warn(String.format("Pearson of class %s got assigned wrong valuer for field years of experience, should be positive", builder.getClass().getName()));
        }
        Person clientRepresentative = null;
        try {
            clientRepresentative = new ClientRepresentative("name", "surname", LocalDate.of(2000, 1, 31), "example@gmail.com");
        } catch (ValidateEmailException ignored) {

        } finally {
            logger.warn(String.format("Pearson of class %s got assigned wrong email value", builder.getClass().getName()));
        }


    }
}
