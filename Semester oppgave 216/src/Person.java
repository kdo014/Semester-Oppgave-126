import java.util.ArrayList;
public class Person {
    private String name;
    private int id;
    ArrayList<Person> people = new ArrayList<>();
    String[] names = {"Mikael","Karin","Kristine","Olav","Mats","David","Odin","Elin","Sølvi","Daniel"};

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void addPeople(){
        int x=0;
        while(x<=9) {
            Person person = new Person(names[x], x);
            people.add(person);
            x++;
        }
    }

    public void returnPerson(int i){
        Person p = new Person("",0);
        for (Person person : people){
            if(person.id == i){
                p = person;
            }
        }
        System.out.print(p.name + " " +p.id);
    }
}
