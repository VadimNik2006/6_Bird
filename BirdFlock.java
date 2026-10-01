import java.util.ArrayList;

public class BirdFlock extends ArrayList<Bird>  {

    public BirdFlock(){}

    @Override
    public boolean add(Bird b){
        if(indexOf(b) == -1)
            return super.add(b);

        return false;
    }

    public int count(){
        return size();
    }

    public void fly(){
        for(Bird b: this)
            b.fly();
    }

}
