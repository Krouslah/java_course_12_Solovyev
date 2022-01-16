import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static TreeSet<Student> set = new TreeSet<>(new AgeComparator().thenComparing(new NameComparator()));
    public static void main(String[] args) {
        mainMenu();
        System.out.println("Thx and gl");
    }
    public static void mainMenu(){
        System.out.println("""
                1. Ввести ученика
                2. Вывести всех учеников по возрастанию
                3. Вывести всех учеников по убыванию
                4. Удалить ученика по индексу
                5. Выход
                """);
        int i = Integer.parseInt(stringScanner());
        if (i == 1) addStudent();
        if (i == 2) sortHigh();
        if (i == 3) sortLow();
        if (i == 4) removeStudent();
    }
    public static void addStudent(){
        System.out.println("Введите данные студента");
        studentScanner();
        mainMenu();
    }
    public static void sortHigh(){
        System.out.println(set);
        mainMenu();
    }
    public static void sortLow(){
        System.out.println(set.descendingSet());
        mainMenu();
    }
    public static void removeStudent(){
        System.out.print("Введите ФИО ученика, которого хотите удалить: ");
        String FIO = stringScanner();
        set.removeIf(student -> student.getName().equals(FIO));
        mainMenu();
    }
    public static void studentScanner(){
        System.out.print("Введите Фамилию, Имя, Отчество: ");
        String name = stringScanner();
        System.out.print("Введите класс: ");
        int clas = Integer.parseInt(stringScanner());
        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(stringScanner());
        System.out.println("""
                Введите любимый предмет по маске:\s
                [MATH,
                 LANG,
                 PHYS,
                 BIO]""");
        String lesson = stringScanner();
        Student student = new Student(name, clas, age, FavoriteLesson.MATH);
        switch (lesson) {
            case "MATH": student.setName(name); student.setClas(clas); student.setAge(age); student.setFavoriteLesson(FavoriteLesson.MATH);
            case "LANG": student.setName(name); student.setClas(clas); student.setAge(age); student.setFavoriteLesson(FavoriteLesson.LANG);
            case "PHYS": student.setName(name); student.setClas(clas); student.setAge(age); student.setFavoriteLesson(FavoriteLesson.PHYS);
            case "BIO": student.setName(name); student.setClas(clas); student.setAge(age); student.setFavoriteLesson(FavoriteLesson.BIO);
        }
        if (set.contains(student)){
            System.out.println("Такой студент уже есть в списке");
            mainMenu();
        }
        else set.add(student);
    }
    public static String stringScanner(){
        Scanner src = new Scanner(System.in);
        return src.nextLine();
    }
}
class AgeComparator implements Comparator<Student> {
    public int compare(Student student1, Student student2){
        return student1.getAge() - student2.getAge();
    }
}
class NameComparator implements Comparator<Student>{
    public int compare (Student student1, Student student2){
        return student1.getName().compareTo(student2.getName());
    }
}
