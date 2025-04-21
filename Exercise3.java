
import java.io.*;
import java.util.*;

public class Exercise3 {

	private final List<Recording> recordings = new ArrayList<>();

	public void exportRecordings(String fileName) {
		try (FileWriter fileWriter = new FileWriter("recording_output.txt");//väljer fil att skriva i
			 PrintWriter printWriter = new PrintWriter(fileWriter)) { //gör så vi kan skriva i filen
			for (int i = 0; i < recordings.size(); i++) {//for each istället?
				Recording r = recordings.get(i);

				printWriter.println("<recording>");
				printWriter.println("<artist>" + r.getArtist() + "</artist>");
				printWriter.println("<title>" + r.getTitle() + "</title>");
				printWriter.println("<year>" + r.getYear() + "</year>");
				printWriter.println("<genres>");
				for (String genre : r.getGenre()) {
					printWriter.println("<genre>" + genre + "</genre>");
				}
				printWriter.println("</genres>");
				printWriter.println("</recording>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void importRecordings(String fileName) {

	try (FileReader fileReader = new FileReader(fileName);
	BufferedReader reader = new BufferedReader(fileReader)) {// Osäker på hur BufferedReader funkar, snodde dessa två rader från genomgången av lektionen

		String line = reader.readLine(); // Läser in första siffran som ska representera antalet skivor som en sträng då
		int totalRecordings = Integer.parseInt(line.trim()); // Förvandlar strängen till en Int
		for (int i = 0; i < totalRecordings; i++) { // Kör en foor loop för hela filen ex 6 recs kör vi loopen 6 gånger
			line = reader.readLine(); // läser vi andra rader i dokumentet
			String[] parts = line.split(";"); // delar upp inlästa raden i delar, separerade med semicolon
			String artist = parts[0];
			String title = parts[1];
			int year = Integer.parseInt(parts[2]);

			Set<String> genres = new HashSet<>(); // Spara genres tillfälligt
			line = reader.readLine(); // Hämta antalet genres i sträng format
			int numberOfGenres = Integer.parseInt(line); // Sträng till int format
			for (int j = 0; j < numberOfGenres; j++) { // Iterera över antalet genres och lägg in i Set
				line = reader.readLine();
				genres.add(line);
			}

			Recording recording = new Recording(artist, title, year, genres); // Skapar ett nytt Recroding objekt
			recordings.add(recording); // Sparar nya objektet i recordings listan

		}
	} catch (IOException e){
		e.printStackTrace();
	}
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

