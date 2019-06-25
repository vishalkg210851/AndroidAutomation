package tests;
import org.python.util.PythonInterpreter;
import org.python.core.*;

public class Python_Interpreter {

    public static void main(String [] args){
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        PythonInterpreter interp = new PythonInterpreter();
        System.out.println("Calling Grafana Module");

    }
}
