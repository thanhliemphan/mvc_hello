package mvc.repository;

import mvc.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookRepository")
public interface BookRepository extends CrudRepository<BookEntity, Integer> {
    List<BookEntity> findByAuthor(String author);
    List<BookEntity> findByNameContainingOrAuthorContaining(String name,String author);
    @Query(value= "select * from book",nativeQuery = true)
    List<BookEntity> getAllBook();
}