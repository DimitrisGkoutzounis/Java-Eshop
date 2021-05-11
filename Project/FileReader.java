package Project;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {
    
    private FileInputStream inputStream;
    private  BufferedReader buffer;


    public FileReader(){
        try{
            inputStream = new FileInputStream("Project/products.txt");
            buffer = new BufferedReader(new InputStreamReader(inputStream));

            int counter = 1;
            
            while(true){
                String line = buffer.readLine();

                if(line == null) break;

                String[] stringArr = line.split("\t");
                System.out.println("Stoixeia gia to "+counter+" proion");
                System.out.println("ID "+ stringArr[0]);
                System.out.println("Description "+stringArr[1]);
                System.out.println("Price "+stringArr[3]);
                System.out.println("");
                counter++;
                

            }


        }
        catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


}