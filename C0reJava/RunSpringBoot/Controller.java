import java.awt.*;
import java.io.IOException;
import java.net.*;
public class Controller {
    static void main() throws URISyntaxException, IOException{
        Desktop desktop = Desktop.getDesktop();
        // IO.print(desktop);
        // URI uri = new URI("http://www.sony.co.uk");
        // URI uri = null;
        // desktop.browse(uri);
        // IO.println("Redirected to SONY UK");
        String website = "http://localhost:8080/api";
        switch (Integer.parseInt(IO.readln("enter choice 1 for sum 2 for concat: "))) {
            case 1:
                String n1=IO.readln("enter 1st no. ");
                String n2=IO.readln("enter 2nd no. ");
                website = website+"/sum/"+n1+"/"+n2;
                desktop.browse(new URI(website));
                break;

            case 2:
                String n=IO.readln("enter 1st name. ");
                String nn=IO.readln("enter 2nd name. ");
                website = website+"/strlist/"+n+"/"+nn;
                desktop.browse(new URI(website));
                break;

            default:
                desktop.browse(new URI("http://www.google.com"));
                break;
        }
        IO.println("Exit...");
    }
}
