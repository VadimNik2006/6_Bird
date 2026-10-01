import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Scene extends JPanel {
    private BirdFlock flock;
    private int circleX;
    private int circleY;
    private int radius;

    public Scene(BirdFlock flock, int circleX, int circleY, int radius){
        this.flock = flock;
        this.circleX = circleX;
        this.circleY = circleY;
        this.radius = radius;

        setPreferredSize(new Dimension(800, 600));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.GRAY);
        g.drawOval(circleX - radius, circleY - radius,
                radius * 2, radius * 2);

        g.setColor(Color.BLACK);
        for(Bird b: flock)
            g.fillOval(b.getX() - 5, b.getY() - 5, 10, 10);

        drawRectangle(g, 1, Color.RED);
        drawRectangle(g, 2, Color.BLUE);
        drawRectangle(g, 3, Color.GREEN);
        drawRectangle(g, 0, Color.BLACK);
    }

    private void drawRectangle(Graphics g, int type, Color color){
        boolean first = true;
        int minX = 0;
        int maxX = 0;
        int minY = 0;
        int maxY = 0;

        for(Bird b: flock){
            boolean needed = type == 0 ||
                    type == 1 && b instanceof Parrot ||
                    type == 2 && b instanceof Penguin ||
                    type == 3 && b instanceof Sparrow;

            if(needed){
                if(first){
                    minX = maxX = b.getX();
                    minY = maxY = b.getY();
                    first = false;
                }
                else{
                    if(b.getX() < minX) minX = b.getX();
                    if(b.getX() > maxX) maxX = b.getX();
                    if(b.getY() < minY) minY = b.getY();
                    if(b.getY() > maxY) maxY = b.getY();
                }
            }
        }

        if(!first){
            g.setColor(color);
            g.drawRect(minX, minY, maxX - minX, maxY - minY);
        }
    }
}
