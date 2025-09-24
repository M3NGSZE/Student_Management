## SCHEMA

### STUDENT TABLE
- STUDENT_ID
- FIRST_NAME
- LAST_NAME
- EMAIL

### COURSE TABLE
- COURSE_ID
- COURSE_NAME
- DESCRIPTION

### ENROLLMENT
- ENROLLMENT_ID
- STUDENT_ID
- COURSE_ID
- ENROLLMENT_DATE



jpa join won't let us custom our own field if we want to add extra field create separate entity

@Entity
@Table(name = "enrollment_tb")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId; // <-- Primary key

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private LocalDate enrolledDate;
    private String grade;

    // getters and setters
}
