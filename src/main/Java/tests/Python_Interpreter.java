package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Python_Interpreter {

        public static void main(String[] args) throws IOException {
            System.out.println(System.getProperty("user.dir"));
            Process p = Runtime.getRuntime().exec("python -m GrafanaTest.PythonController.Mysql_timer");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
   }
}
