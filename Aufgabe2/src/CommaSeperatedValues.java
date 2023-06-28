import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CommaSeperatedValues {

	public static void main(String[] args) {
		List<String> = new LinkedList<>();
		zeilen.collect(Collectors.asList());
		
		List<Student> studenten = new LinkedList<>();
		
	}
	
}

// Option A
class Student implements Comparable<Student> {
	String name;
	int age;
	Integer age2;
	
	public void iwas() {
		Integer n = 0;
		Integer b = 1;
		
		n.compareTo(b);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(Student thatStudent){
		int temp;
		temp = this.getName().compareTo(thatStudent.getName());
		
		if(temp == 0 ) {
			return this.getAge() - thatStudent.getAge();
		}
		
		return temp;
	
	}
	
	
}

// Option B 
class StudentenComparator implements Comparator<Student>{
	
	@Override
	public int compare(Student thisStudent, Student thatStudent) {
		int temp;
		temp = thisStudent.getName().compareTo(thatStudent.getName());
		
		if(temp == 0 ) {
			return thisStudent.getAge() - thatStudent.getAge();
		}
		
		return temp;
	}
	
}




























