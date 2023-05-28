package mvc.main;

import mvc.configuration.SpringConfig;
import mvc.entity.BookDetailsEntity;
import mvc.entity.BookEntity;
import mvc.entity.CategoryEntity;
import mvc.repository.BookRepository;
import mvc.repository.CategoryRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static BookRepository bookRepository = (BookRepository) context.getBean("bookRepository");
    static CategoryRepository categoryRepository = (CategoryRepository)  context.getBean("categoryRepository");

    public static void main(String[] args) {
//        createNewBook();
//        readAllBook();
//        readBookById(20);
//        updateBookById(5);
//        deleteBookById(3);
//        List<BookEntity> bookEntityList = bookRepository.findByAuthor("John");
//        if (bookEntityList.size()!=0) {
//            System.out.println("Found " + bookEntityList.size() + " book(s) of John");
//            System.out.println("They are:");
//            for (BookEntity book:bookEntityList) {
//                System.out.println(book.toString());
//            }
//        }
        createNewBookEntryWithNewCategory();
//        createNewBookEntry();
    }

    private static BookEntity createNewBook(){
        BookDetailsEntity bookDetailsEntity = new BookDetailsEntity();
        bookDetailsEntity.setIsbn("ISIBF55555");
        bookDetailsEntity.setNumberOfPage(12345);
        bookDetailsEntity.setPrice(30);
        bookDetailsEntity.setPublishDate(LocalDate.parse("2018-08-16"));

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Java A-Z");
        bookEntity.setAuthor("John");
        bookEntity.setBookDetails(bookDetailsEntity);
        BookEntity result = bookRepository.save(bookEntity);
        if (result != null){
            System.out.println("A new book saved successfully,book ID = "+bookEntity.getId());
        }
        return bookEntity;
    }
    private static void readAllBook(){
        List<BookEntity> bookList = (List<BookEntity>) bookRepository.getAllBook();;
        System.out.println("Found " + bookList.size() + " books in the table book");
        System.out.println("They are: ");
        for (BookEntity book:bookList) {
            System.out.println(book.toString());
        }
    }
    private static void readBookById(int bookID){
        if (bookRepository.existsById(bookID) == true){
            BookEntity bookEntity = bookRepository.findById(bookID).get();
            System.out.println("Found a book with book ID = " + bookID);
            System.out.println(bookEntity.toString());
        } else {
            System.out.println("Not found any book with book ID = " + bookID);
        }
    }
    //    private static void updateBookById(int bookID){
//        if (bookRepository.existsById(bookID) == true){
//            BookEntity bookEntity = bookRepository.findById(bookID).get();
//            System.out.println("Book data before updating");
//            System.out.println(bookEntity.toString());
//
//            bookEntity.setAuthor("Phat");
//            bookEntity.setNumberOfPage(99);
//            bookEntity.setPrice(200);
//            bookRepository.save(bookEntity);
//
//            System.out.println("Book data after updating");
//            System.out.println(bookEntity.toString());
//        } else {
//            System.out.println("Invalid any book with book ID = " + bookID);
//        }
//    }
    private static void deleteBookById(int bookID){
        if (bookRepository.existsById(bookID) == true){
            bookRepository.deleteById(bookID);
            System.out.println("book id = " + bookID + " has been deleted");
        } else {
            System.out.println("Invalid any book with book ID = " + bookID);
        }
    }
    private static void createNewBookEntry(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(1);

        BookEntity bookEntity = createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }
    private static void createNewBookEntryWithNewCategory(){
        CategoryEntity categoryEntity = createNewCategory();
        categoryRepository.save(categoryEntity);

        BookEntity bookEntity = createNewBook();
        bookEntity.setCategory(categoryEntity);
        bookRepository.save(bookEntity);
    }
    private static CategoryEntity createNewCategory(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("Math");
        categoryEntity.setDescription("IT book");
        return categoryEntity;
    }
}
