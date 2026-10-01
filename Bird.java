abstract public class Bird {
    private static int count = 0;
    private int x;
    private int y;

    public Bird(){
        count++;
        //System.out.println("Я птица." + " Всего птиц: " + count + ".");

        x = (int)(Math.random() * 800);
        y = (int)(Math.random() * 600);
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("Я птица.");
    }

    public void fly(){
        System.out.println("Я лечу!");
    }

    public static void printCount(){
        System.out.println("Всего птиц: " + count + ".");
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
}
