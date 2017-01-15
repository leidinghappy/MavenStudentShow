package yun.yi;

/**
 * Created by dinglei on 2016/11/10.
 */
public class Student {

    private String id;

    private String name;
    public Student(){}
    public Student (String id,String name){
        this.id=id;
        this.name=name;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
