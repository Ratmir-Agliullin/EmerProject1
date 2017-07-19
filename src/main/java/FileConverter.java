import java.io.*;
import java.util.Scanner;

/**
 * Created by Аглиуллины on 19.07.2017.
 */
public class FileConverter {

    public File[] getListFiles(){
        String dirPath = "C:\\Users\\Аглиуллины\\IdeaProjects\\EmerProject1\\files";
        File file = new File(dirPath);
        return file.listFiles();
    }

    public String getStringFromFile(File file){
        String result = null;
        try {
            Scanner in = new Scanner(file);
            while (in.hasNext()) result= in.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            return result;
        }

    }

    public  void writeInFile(String filename, String filevalue){
        String pathToFile="C:\\Users\\Аглиуллины\\IdeaProjects\\EmerProject1\\output\\"+filename;
        File file=new File(pathToFile);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try
        {

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            bw.write(filevalue);

            bw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }


    };

}
