package sql.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sql.data.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
