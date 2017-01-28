package demo1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
 
 
 
public class App {
 
    public static void main(String[] args) throws FileNotFoundException {
         
        File file = new File("test.txt");
         
        FileReader fr = new FileReader(file);
    }
 
}



package demo2;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
 
public class App {
 
    public static void main(String[] args) {
        File file = new File("test.txt");
 
        try {
            FileReader fr = new FileReader(file);
             
            // This will not be executed if an exception is thrown.
            System.out.println("Continuing ....");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.toString());
        }
 
        System.out.println("Finished.");
    }
 
}




package demo3;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
 
public class App {
 
    public static void main(String[] args) {
        try {
            openFile();
        } catch (FileNotFoundException e) {
            // PS. This message is too vague : )
            System.out.println("Could not open file");
        }
    }
 
    public static void openFile() throws FileNotFoundException {
        File file = new File("test.txt");
 
        FileReader fr = new FileReader(file);
 
    }
 
}