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

    public int countInCircle(int x, int y, int radius){
        int count = 0;

        for(Bird b: this){
            int dx = b.getX() - x;
            int dy = b.getY() - y;

            if(dx * dx + dy * dy <= radius * radius)
                count++;
        }

        return count;
    }

}
