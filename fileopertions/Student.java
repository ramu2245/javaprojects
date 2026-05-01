package codegnan.exam;

import java.io.Serializable;

public class Student implements Serializable {
		 int id;
		 String name;
		 double marks;
		 transient String password;
		
		public Student(int id, String name,double marks, String password) {
			this.id=id;
			this.marks = marks;
			this.name= name;
			this.password= password;
		}

		@Override
		public String toString() {
			return "student [id=" + id + ", name=" + name + ", marks=" + marks + ", password=" + password + "]";
		}
		
		public String toFileString() {
			return id+ ", "+ name + ", " + marks;
		}
		
		
		

	}


}
