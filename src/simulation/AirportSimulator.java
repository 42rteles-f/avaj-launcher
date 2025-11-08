import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AirportSimulator {
    private String  fileName;
    private int     numberOfWeatherChanges;

    public AirportSimulator(String file) {
        this.fileName = file;
        this.getFileInfo(this.fileName);
    }

    private void getFileInfo(String fileName) {
        Path path = Path.of(fileName);
        String[][] text;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            
        }


    }
}