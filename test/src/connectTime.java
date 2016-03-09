import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class connectTime {


    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        String filename = "input_1.txt";
        if (args.length > 0) {
            filename = args[0];
        }

        String answer = parseFile(filename);
        System.out.println(answer);
    }

    static String parseFile(String filename)
            throws FileNotFoundException, IOException {
        /*
         *  Don't modify this function
         */
        BufferedReader input = new BufferedReader(new FileReader(filename));
        List<String> allLines = new ArrayList<String>();
        String line;
        while ((line = input.readLine()) != null) {
            allLines.add(line);
        }
        input.close();

        return parseLines(allLines.toArray(new String[allLines.size()]));
    }

    static String parseLines(String[] lines) {
        List<Date> time = new ArrayList<>();
        List<String> status =  new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("(MM/dd/yyyy-HH:mm:ss)");
        Date n =null;
        double sum = 0;
        for(int i = 0; i < lines.length; i++){
            String[] node = lines[i].split("::");
            String t = node[0].trim();
            String s = node[1].trim();
            try {
            Date d1 = format.parse(t);

                time.add(d1);
                status.add(s);
                if(s.equals("CONNECTED")){
                    n = d1;
                }else if(s.equals("DISCONNECTED") || s.equals("SHUTDOWN")){
                    if(n == null) continue;

                    sum += d1.getTime() - n.getTime();
                    n = null;
                }

            }catch (ParseException e) {
                e.printStackTrace();
            }
        }
        long d = time.get(time.size()-1).getTime() - time.get(0).getTime();

        double res = sum/d * 100;
        String r = String.valueOf(res).substring(0,2);

        return r+"%";
    }


}
