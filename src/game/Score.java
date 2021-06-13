package game;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Klasa zapisujaca wynik gracza do pliku i odczytywanie ich
 */
public class Score {

    public static ArrayList<Integer> points = new ArrayList<>();

    /**
     * Metoda zapisujaca wynik grazca do pliku
     * @param score wynik gracza
     * @throws IOException
     */
    public static void Write(int score) throws IOException
    {
        String s = String.valueOf(score);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/top.txt", true));
        bufferedWriter.write(s);
        bufferedWriter.write("\r\n");
        bufferedWriter.close();
        Read();
    }

    /**
     * Metoda odczytujaca poprzednie wyniki gracza z pliku
     * @throws IOException
     */
    public static void Read() throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./src/top.txt"));
        String line;
        points.clear();
        while ((line = bufferedReader.readLine()) != null) {
            int amount = Integer.parseInt(line);
            points.add(amount);
        }
        bufferedReader.close();
        Collections.sort(points, Collections.reverseOrder());
    }
}
