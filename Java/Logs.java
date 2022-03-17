package Java;
import java.time.LocalDate;
import java.time.LocalTime;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;



public class Logs {
    static String time = LocalTime.now().toString();
    static String date = LocalDate.now().toString();
    String ProgramLanguage = "java";
    static File programLog = new File("logs/"+ date + "/" +time +".log");
    static Path programLogPath = programLog.toPath();
    private void selfLogInit(String message) throws IOException {
            programLog.createNewFile();
            try (FileWriter programlogwriter = new FileWriter(programLog)) {
            }
    }
}
