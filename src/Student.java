public class Student{
    private  String name;
    private  int clas;
    private  int age;
    private  FavoriteLesson favoriteLesson;

    public Student(String name,int clas , int age, FavoriteLesson favoriteLesson) {
        this.name = name;
        this.clas = clas;
        this.age = age;
        this.favoriteLesson = favoriteLesson;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClas(int clas) {
        this.clas = clas;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFavoriteLesson(FavoriteLesson favoriteLesson) {
        this.favoriteLesson = favoriteLesson;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clas=" + clas +
                ", age=" + age +
                ", favoriteLesson=" + favoriteLesson +
                '}';
    }
}
