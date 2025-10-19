import lombok.*;
import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="empdata")
class Emp{
	@Id
	private Integer empno;
	private String ename;
	private Integer sal;
	private Integer deptno;
	private String job;
}