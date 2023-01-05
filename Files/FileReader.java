package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    Scanner fileReader;
    File file;

    /**
     *
     * @param filePath the file path of the file to be read from (with file extension)
     */
    public FileReader(String filePath){
        try{
            this.file = new File(filePath);
            this.fileReader = new Scanner(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void printContents(){
        while (this.fileReader.hasNext()){
            System.out.println(this.fileReader.nextLine());
        }
    }

}
