package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileRead {

    protected Scanner fileReader;
    protected File file;

    /**
     * This class reads files from the disk
     * @param filePath the file path of the file to be read from (with file extension)
     */
    public FileRead(String filePath){
        try{
            this.file = new File(filePath);
            this.fileReader = new Scanner(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            // TODO: Add implementation - make new file if the file is not found.
        }
    }

    public boolean isEmpty(){
        return !this.fileReader.hasNext();
    }

    public void printContents(){
        while (this.fileReader.hasNext()){
            System.out.println(this.fileReader.nextLine());
        }
    }

    public String readLine(){
        return this.fileReader.nextLine();
    }

    public String[] readLines(int numberOfLines){
        String[] lines = new String[numberOfLines];
        try {
            for (int i = 0; i < numberOfLines; i++) {
                lines[i] = this.fileReader.nextLine();
            }
        }catch (NoSuchElementException e){
            System.out.println("Error: Index out of range.");
        }

        return lines;
    }

    public void close(){
        this.fileReader.close();
    }

}