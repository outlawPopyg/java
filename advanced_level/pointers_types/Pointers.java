public class Pointers {
	public static void main(String[] args) {
		try {
			Person tom = new Person("Tom", 23);
			Person bob = tom.clone();
			bob.setName("Bob");
			tom.display(); // => Person Name: Tom
		}
		catch(CloneNotSupportedException ex) {
			System.out.println("CloneNotSupportedException");
		}
	}
}

class Person implements Cloneable {
    private String name;
    private int age;
     
    Person(String name, int age){
        this.name=name;
        this.age=age;
    }

    void setName(String name){
        this.name = name;
    }

    void setAge(int age){
        this.age = age;
    }

    void display(){
        System.out.printf("Person Name: %s \n", name);
    }

    public Person clone() throws CloneNotSupportedException {
    	return (Person) super.clone();
    }
}

class Book implements Cloneable {
	private String name;
    private Author author;
     
    public void setName(String n){ name=n;}
    public String getName(){ return name;}
     
    public void setAuthor(String n){ author.setName(n);}
    public String getAuthor(){ return author.getName();}
 
    Book(String name, String author){
         
        this.name = name;
        this.author = new Author(author);
    }
     
    public String toString(){
         
        return "Книга '" + name + "' (автор " +  author + ")";
    }
     
    public Book clone() throws CloneNotSupportedException{
     
        Book newBook = (Book) super.clone();
    	newBook.author=(Author) author.clone();
    	return newBook;
    }
}

class Author implements Cloneable{
 
    private String name;
     
    public void setName(String n){ name=n;}
    public String getName(){ return name;}
     
    public Author(String name){
     
        this.name=name;
    }

    public Author clone() throws CloneNotSupportedException{
     
        return (Author) super.clone();
    }
}