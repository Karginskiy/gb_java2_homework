package lessons.lesson3;

public class MainClass {

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();
        book.addRecord("Каргин", "+7-955-215-92-22", "hei@spark-mail.ru");
        book.addRecord("Каргин", "+7-955-215-92-25", "hei@spark-mail.ru");
        book.addRecord("Зиновьев", "+3-955-125-22-11", "zinoviev@mail.ru");
        book.addRecord("Освальд", "+1-255-900-20-20", "leeharvey@killer.com");
        book.addRecord("Освальд", "+1-555-901-21-21", "harvey@deadboy.com");
        book.addRecord("Освальд", "+1-222-911-51-91", "shot@president.org");

        System.out.println(book);
    }

}
