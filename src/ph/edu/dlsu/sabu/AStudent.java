package ph.edu.dlsu.sabu;

public abstract class AStudent {

  /* #TODO: Implement this Abstract Class with respect to the question  */
  String name;
  int id;

  /*public abstract int getId();
  public abstract String getName();
  public abstract void setId(int id);
  public abstract void setName(String name);*/

  public AStudent(){

  }

  public AStudent (String name, int id){
    this.name = name;
    this.id = id;
  }

  public int getId() {
    return id;
  }


  public String getName() {
    return name;
  }


  public void setId(int id) {
    this.id = id;
  }


  public void setName(String name) {
    this.name = name;
  }

}
