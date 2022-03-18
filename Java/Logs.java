package Java;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;



public class Logs {
    static String realTime = LocalTime.now().toString();
    static String realDate = LocalDate.now().toString();
    static String date = null;
    static String time = null;
    String ProgramLanguage = "java";
    Properties configLoad = new Properties();
    private String config(String property) throws IOException{
        FileInputStream configFile = new FileInputStream("Config.config");
        configLoad.load(configFile);
        String reply = configLoad.getProperty(property).toString();
        return reply;        
    };
    private void updateTime(){
        date = realDate;
        time = realTime;
    }
    private FileWriter selfLogInit() throws IOException {
            updateTime();
            File programLog = new File("logs/"+ date + "/" +time +".log");
            Path programLogPath = programLog.toPath();
            programLog.createNewFile();
            FileWriter programlogwriter = new FileWriter(programLog);
            return programlogwriter;

            
    }
    private void selfLog( String message){
        
    }
}
