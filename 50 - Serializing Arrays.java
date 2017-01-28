import java.io.Serializable;
 
public class Person implements Serializable {
     
    private static final long serialVersionUID = 4801633306273802062L;
     
    private int id;
    private String name;
     
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
 
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + "]";
    }
}
 
// www.caveofprogramming.com




readofobjects
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class ReadObjects {
 
    public static void main(String[] args) {
        System.out.println("Reading objects...");
         
        try (FileInputStream fi = new FileInputStream("test.ser"); ObjectInputStream os = new ObjectInputStream(fi)) {
 
            // Read entire array
            Person[] people = (Person[])os.readObject();
             
            // Read entire arraylist
            @SuppressWarnings("unchecked")
            ArrayList<Person> peopleList = (ArrayList<Person>)os.readObject();
             
            for(Person person: people) {
                System.out.println(person);
            }
             
            for(Person person: peopleList) {
                System.out.println(person);
            }
             
            // Read objects one by one.
            int num = os.readInt();
             
            for(int i=0; i<num; i++) {
                Person person = (Person)os.readObject();
                System.out.println(person);
            }
             
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
 
}



writeofobjects
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public class WriteObjects {
 
    public static void main(String[] args) {
        System.out.println("Writing objects...");
         
        Person[] people = {new Person(1, "Sue"), new Person(99, "Mike"), new Person(7, "Bob")};
         
        ArrayList<Person> peopleList = new ArrayList<Person>(Arrays.asList(people));
 
        try (FileOutputStream fs = new FileOutputStream("test.ser"); ObjectOutputStream os = new ObjectOutputStream(fs)) {
 
            // Write entire array
            os.writeObject(people);
             
            // Write arraylist
            os.writeObject(peopleList);
             
            // Write objects one by one
            os.writeInt(peopleList.size());
             
            for(Person person: peopleList) {
                os.writeObject(person);
            }
             
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
 
}