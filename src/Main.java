import java.io.*;
import java.util.regex.*;
public class Main {
    public static String reader(){
        try(FileReader fr = new FileReader("Comments.txt")){
            StringBuffer strok = new StringBuffer();
            int code = -1;
            while((code=fr.read())!=-1){
                strok.append(Character.toChars(code));
            }
            Pattern p = Pattern.compile("(/\\*.*?\\*/)|(//[^\n]*)", Pattern.DOTALL);
            Matcher m = p.matcher(strok);
            return m.replaceAll("");
        }
        catch (IOException exs){
            exs.printStackTrace(System.out);
            return null;
        }
    }
    public static void main(String[] args){
        String str = reader();
        try(FileWriter fw = new FileWriter("noComments.txt")){
            for(int i=0; i<str.length(); i++){
                fw.write(str.charAt(i));
            }
        }
        catch(IOException ex){
            System.out.println(System.out);
        }
    }
}