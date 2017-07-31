import java.io.*;

/**
 * The program takes the path of the input file(Seats Reservation) as the parameter, return output file after finishing assignments
 */
public class Main {

//    static final int seat_length = 20;

    public static void main(String[] args) throws IOException {

        String text_path = args[0];
        String line = null;
        Theater t = new Theater();
        //int[] seatsArray = new int[10];
        t.arrayInitial();
        //arrayInitial(seatsArray);
        StringBuilder sb = new StringBuilder();

        try {
            FileReader file_reader = new FileReader(text_path);
            BufferedReader buffered_reader = new BufferedReader(file_reader);
            while ((line = buffered_reader.readLine()) != null) {

                if (!checkLine(line)) {
                    continue;
                }

                Reserve r = new Reserve(line.substring(0, 4), Integer.parseInt(line.substring(5)), 0, 0);
                t.setSeats(r);
                sb.append(r.printReserve());
                sb.append("\n");
            }

        } catch (FileNotFoundException e) {
            // FileReader can't find the file
            System.out.println("can't find file: " + text_path);
            e.printStackTrace();
        } catch (IOException e) {
            // BufferedReader can't get line
            System.out.println("can't read line");
            e.printStackTrace();
        }
        creatOutputFile(sb);

    }

    /**
     * Create the output file
     *
     * @param sb - The stringBuilder contains all the assignment
     * @throws IOException
     */
    public static void creatOutputFile(StringBuilder sb) throws IOException {
        File file = new File("src/OutputFiles/output.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) writer.close();
        }
        String absolutePath = file.getAbsolutePath();
        System.out.println("File path : " + absolutePath);
    }


    /**
     * Check whether the input file is following the format.
     *
     * @param line - The line from the input file
     * @return
     */
    public static boolean checkLine(String line) {

        if ((line.charAt(0)) != 'R') {
            return false;
        }
        if (!line.substring(1, 3).matches("-?\\d+(\\.\\d+)?")) {
            return false;
        }
        if (!line.substring(5, line.length()).matches("-?\\d+(\\.\\d+)?")) {
            // If there is empty space in the end, this will fail.
            return false;
        }
        return true;
    }
}
