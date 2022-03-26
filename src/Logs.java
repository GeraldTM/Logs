package src;

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
    static String logging = null;
    static FileWriter selflog = null;
    String ProgramLanguage = "java";
    static Properties configLoad = new Properties();
    static File programLog;

    public static void main(String[] args) throws IOException {
        //This method is for testing. run test.bat for full results.\
        if (config("Self-Log") == "true") {
                selfLog(realDate + " " + realTime + " " + "Self-Logging Enabled");
                selfLog("java selflog test successful");
        } else {
            System.out.println("Self-Logging Disabled");
            selfLog(realDate + " " + realTime + " " + "Self-Logging Disabled");
        }
        System.out.println("Test Succsesful");
    }

    private static String config(String property) throws IOException{

        FileInputStream configFile = new FileInputStream("Config.config");
        configLoad.load(configFile);
        String reply = configLoad.getProperty(property).toString().toLowerCase();
        return reply;        
    };
    private static void updateTime(){

        date = realDate;
        time = realTime;
    }
    private static FileWriter selfLogInit() throws IOException {

            updateTime();
            if (config("Date_Folder")== "true"){
                programLog = new File("logs/" + date + "/" + time + ".log");
            } else {
                programLog = new File("logs/" + time + ".log");
            }
            programLog.createNewFile();
            FileWriter programlogwriter = new FileWriter(programLog);
            return programlogwriter;
    }
    private static void selfLog( String message) throws IOException{
        if (selflog == null){
            selflog = selfLogInit();
        }
        selflog.write(realTime + ": " + message);
        
    }
}
