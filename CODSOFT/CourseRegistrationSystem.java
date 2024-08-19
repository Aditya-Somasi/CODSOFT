import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;

    public Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return code + ": " + title + " (" + capacity + " slots available)";
    }
}

class Student {
    String id;
    String name;
    ArrayList<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course.capacity > 0) {
            registeredCourses.add(course);
            course.capacity--;
            System.out.println("Registered for course: " + course.title);
        } else {
            System.out.println("Course is full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.remove(course)) {
            course.capacity++;
            System.out.println("Dropped course: " + course.title);
        } else {
            System.out.println("You are not registered for this course.");
        }
    }

    public void viewCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
        } else {
            System.out.println("Registered Courses:");
            for (Course course : registeredCourses) {
                System.out.println(course);
            }
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Course course1 = new Course("CS101", "Introduction to Programming", "Basic programming concepts", 30);
        Course course2 = new Course("CS102", "Data Structures", "Learn about data structures", 25);
        Course course3 = new Course("CS103", "Database Systems", "Introduction to databases", 20);

        Course[] courses = {course1, course2, course3};

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentId, studentName);

        while (true) {
            System.out.println("\nCourse Registration Menu:");
            System.out.println("1. View all courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. View registered courses");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Courses:");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    break;
                case 2:
                    System.out.print("Enter course code to register: ");
                    String registerCode = scanner.nextLine();
                    for (Course course : courses) {
                        if (course.code.equalsIgnoreCase(registerCode)) {
                            student.registerCourse(course);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter course code to drop: ");
                    String dropCode = scanner.nextLine();
                    for (Course course : courses) {
                        if (course.code.equalsIgnoreCase(dropCode)) {
                            student.dropCourse(course);
                            break;
                        }
                    }
                    break;
                case 4:
                    student.viewCourses();
                    break;
                case 5:
                    System.out.println("Exiting system. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
