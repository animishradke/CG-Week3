import java.io.FileReader;
import java.io.BufferedReader;

public class ReadWithFileReader {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("largefile.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
           
        }

        br.close();
        fr.close();
    }
}

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class ReadWithInputStreamReader {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("largefile.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
         
        }

        br.close();
        isr.close();
        fis.close();
    }
}

