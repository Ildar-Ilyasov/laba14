import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("comments.txt"));
            BufferedWriter fl = new BufferedWriter(new FileWriter("nocomments.txt"))){
            int s;
            StringBuffer cods = new StringBuffer();
            while((s = br.read())!=-1){
                cods.append((char) s);
            }
            Pattern pattern = Pattern.compile("(/\\*.*?\\*/)|(//[^\n]*)", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(cods.toString());
            StringBuffer nocomments=new StringBuffer(matcher.replaceAll(""));
            fl.write(nocomments.toString());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}