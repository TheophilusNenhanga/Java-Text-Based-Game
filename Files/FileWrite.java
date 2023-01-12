package Files;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileWrite {
    // TODO: Add Implementation - write to files, write to binary file so that players cannot edit the file.

    FileWriter writer;

    public FileWrite(String filePath){
        try{
        this.writer = new FileWriter(filePath);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void fileWrite(String data){
        try{
        this.writer.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void fileClose(){
        try{
        this.writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
// This implementation writes text files that can ebe edited by the user. Need to make files that cannot be edited by a user.
