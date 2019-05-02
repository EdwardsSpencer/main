import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNumberGenerator {
    
    static final int size = 300;
    /**
     * Makes a list of random numbers in the form of SSN
     */
    public static void rng()
    {
        try{
        File file = new File("SSnNumbers.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file)); 
        Random rand = new Random();
        String value = "";
        for(int i = 0; i < size; i++)
        {
            value = rand.nextInt(10) + ""+ rand.nextInt(10) + "" + (rand.nextInt(9)+1) +
                    "-" + rand.nextInt(10) + "" + rand.nextInt(10) + "-" + rand.nextInt(10) +
                    "" + rand.nextInt(10) + "" + rand.nextInt(10) + "" + rand.nextInt(10);
            
            writer.write(value + String.format("%n"));
           // System.out.println(value);
        }
        writer.close();
        }
        catch(Exception e)
        {
            System.out.println("File already exists");
        }
    }
}
