
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Exercise3 {

	private final List<Recording> recordings = new ArrayList<>();

	public void exportRecordings(String fileName) {

	}

	public void importRecordings(String fileName) throws IOException {

	FileReader fileReader = new FileReader(fileName);
	BufferedReader reader = new BufferedReader(fileReader); // Osäker på hur BufferedReader funkar, snodde dessa två rader från genomgången av lektionen

	String line = reader.readLine(); // Läser in första siffran som ska representera antalet skivor som en sträng då
	int totalRecordings = Integer.parseInt(line.trim()); // Förvandlar strängen till en Int
			for( int i = 0; i < totalRecordings;i++) { // Kör en foor loop för hela filen ex 6 recs kör vi loopen 6 gånger
				line = reader.readLine(); // läser vi andra rader i dokumentet
				String[] parts = line.split(";"); // delar upp inlästa raden i delar, separerade med semicolon
				String artist = parts[0];
				String title = parts[1];
				int year = Integer.parseInt(parts[2]);

				Set<String> genres = new HashSet<>(); // Spara genres tillfälligt
				line = reader.readLine(); // Hämta antalet genres i sträng format
				int numberOfGenres = Integer.parseInt(line); // Sträng till int format
				for(int j = 0; j < numberOfGenres; j++) { // Iterera över antalet genres och lägg in i Set
					line = reader.readLine();
					genres.add(line);
				}

				Recording recording = new Recording(artist, title, year, genres); // Skapar ett nytt Recroding objekt
				recordings.add(recording); // Sparar nya objektet i recordings listan

	}
			fileReader.close();
			reader.close();
}






	public Map<Integer, Double> importSales(String fileName) {
		return null;
	}

	public List<Recording> getRecordings() {
		return Collections.unmodifiableList(recordings);
	}

	public void setRecordings(List<Recording> recordings) {
		this.recordings.clear();
		this.recordings.addAll(recordings);
	}
}

