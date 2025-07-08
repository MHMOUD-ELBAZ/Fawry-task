import APIs.BookAPI;
import Models.*;


public class Main {
    public static void main(String[] args) {
        //testing
        BookAPI bookAPI = new BookAPI();
        bookAPI.add(new PaperBook("0x235", "فن الطبخ", 50, 2010, 10));
        bookAPI.add(new PaperBook("0x245", "ترامب والشرق الاوسط", 50, 2025, 10));
        bookAPI.add(new EBook("0x234", "كيف سقطت الاندلس", 60,1850 , FileType.PDF));
        bookAPI.add(new DemoBook("0x233", "How the ai will replace you", 70, 2025));

        bookAPI.buy("0x245", 2, "elbaz8536@gmail.com", "trouble");
        bookAPI.buy("0x234", 2, "elbaz8536@gmail.com", "trouble");

        System.out.println(bookAPI.removeOutdated(2015));
        bookAPI.buy("0x235", 2, "elbaz8536@gmail.com", "trouble");
    }

}