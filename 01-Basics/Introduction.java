public class Introduction {
    String name;
    String favoriteLanguage;


    public Introduction(String name, String favoriteLanguage) {
        this.name = name;
        this.favoriteLanguage = favoriteLanguage;
    }


    public void print() {
        System.out.println("My name is " + name + " and my favorite language is " + favoriteLanguage);
    }


    public static void main(String[] args) {
        Introduction person = new Introduction("Ahmet Alptug Dirik", "C#");

        person.print();
        
    }
}