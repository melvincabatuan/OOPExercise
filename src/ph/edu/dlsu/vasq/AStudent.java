package ph.edu.dlsu.vasq;

public abstract class AStudent {

  /* #TODO: Implement this Abstract Class with respect to the question  */

    private String name;
    private int id;

    public AStudent(){
    }

    public AStudent(String name){
        this.name = name;
    }

    public AStudent (String name, int id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

}
