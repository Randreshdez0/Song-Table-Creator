import java.io.FileNotFoundException;

public class MusicWordCountMain {
		
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		String[] i = new String[] {"0"};
		MusicWordCount m = new MusicWordCount();
		m.addMultipleWords(i);

		System.out.println(m);
		System.out.println("total words : " + m.totalWordCount);
		System.out.println("unique words : " + m.uniqueWordCount);
		m.FrequentWord();
	}
	public static void GetSong() {
		
	}
}
