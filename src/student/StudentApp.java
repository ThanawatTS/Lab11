package student;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * @author you
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> filter, Consumer<Student> action, Comparator<Student> sortor ) {
		students.stream().filter(filter).sorted(sortor).forEach( action );
	}
	
	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		
		Predicate<Student> Birthday = (s) -> s.getBirthdate().getMonthValue() == LocalDate.now().getMonthValue();
		Consumer<Student> namebirth = (s) -> System.out.printf("%s %s will have birth on %d %s\n",s.getFirstname(),s.getLastname(),s.getBirthdate().getDayOfMonth(),s.getBirthdate().getMonth());
		
		Comparator<Student> Name = (a,b) -> a.getFirstname().charAt(0) - b.getLastname().charAt(0);
		Comparator<Student> byBirthday = (a,b) -> a.getBirthdate().getDayOfMonth() - b.getBirthdate().getDayOfMonth();
		
		Predicate<Student> birthdatenext2week = (s) -> s.getBirthdate().getDayOfYear() - LocalDate.now().getDayOfYear() < 15 && s.getBirthdate().getDayOfYear() - LocalDate.now().getDayOfYear() > 0 ;
		
		StudentApp studentapp = new StudentApp();
		studentapp.filterAndPrint(students,Birthday,namebirth,Name);
	
	}
}
