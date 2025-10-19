import lombok.*;
import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="studentt")
class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sid")
    private Integer id;
    @Column(name = "sname", unique = true, length = 10)
    private String name;
    @Column(name = "saddress", length = 200)
    private String address;
    @Column(name = "smobile", unique = true, length = 10)
    private Integer mobile;

    public Student(String name, String address, Integer mobile){
        this.name=name;
        this.address=address;
        this.mobile=mobile;
    }
}