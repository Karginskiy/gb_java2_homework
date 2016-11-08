package lessons.lesson3;

public class MainClass {

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.addRecord("Kargin", "+7-955-215-92-22", "hei@spark-mail.ru");
        book.addRecord("Kargin", "+7-955-215-92-25", "hei@spark-mail.ru");
        book.addRecord("Zinoviev", "+3-955-125-22-11", "zinoviev@mail.ru");
        book.addRecord("Osvald", "+1-255-900-20-20", "leeharvey@killer.com");
        book.addRecord("Osvald", "+1-555-901-21-21", "harvey@deadboy.com");
        book.addRecord("Osvald", "+1-222-911-51-91", "shot@president.org");

        System.out.println(book);
    }

}
