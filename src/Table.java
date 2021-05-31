import javax.swing.*;
import java.awt.*; 
public class Table extends JPanel
{
    private Color my_color ;//declare global color to be create or get value later
    private Sticks _sticks;
    /**
     * A constructor for te panel of the table it self
     *
     * @param   other_color, Sticks sticks
     */
    public Table(Color other_color, Sticks sticks)
    {
        my_color = other_color;//coppy other_color to my_color
        _sticks = sticks;
    }

    /**
     * A synchronized paintComponent override to draw a table with sticks and plate on the main panel
     *
     * @param   g
     */
    protected synchronized void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.setColor(my_color);
        g.fillOval(0,0,getWidth(),getHeight());
        g.setColor(Color.WHITE);
        int gap_from_edge = getWidth()/35;
        int plate_radius = getWidth()/5-gap_from_edge;
        int plate_height = getHeight()/3-gap_from_edge;

        double plate_x;
        double plate_y;

        plate_x = (getWidth()*2)/5;
        plate_y = gap_from_edge;        
        g.fillOval((int)plate_x,(int)plate_y,plate_radius,plate_height);//plate 1

        plate_x =(getWidth()*4)/5;
        plate_y = (getHeight())/3;
        g.fillOval((int)plate_x,(int)plate_y,plate_radius,plate_height);//plate 2

        plate_x =(getWidth())*3/5 - gap_from_edge;
        plate_y = (getHeight()*2)/3-gap_from_edge;
        g.fillOval((int)plate_x,(int)plate_y,plate_radius,plate_height);//plate 3

        plate_x =(getWidth())/5 + gap_from_edge;
        plate_y = (getHeight()*2)/3-gap_from_edge;
        g.fillOval((int)plate_x,(int)plate_y,plate_radius,plate_height); //plate 4  

        plate_x = gap_from_edge;
        plate_y = (getHeight())/3;
        g.fillOval((int)plate_x,(int)plate_y,plate_radius,plate_height);//plate 5

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(getHeight()/100 + getWidth()/100));
        g2.setColor(Color.BLACK);
        double x1;
        double y1;
        double x2;
        double y2;
        int stick_lingth = getHeight()/25 + getWidth()/25;

        x1 = getWidth()*2/5 + ((gap_from_edge - getWidth()*2/5)/7*3) ;
        y1 =((getHeight())/3 - gap_from_edge)/7*6;
        x2 = x1 + stick_lingth;
        y2 = y1 + stick_lingth;
        if(_sticks.getStickAt(0).isFree())
        {
            g2.drawLine((int)x1,(int)y1,(int)x2,(int)y2);//stick1
        }

        x1 = getWidth()-x1 ;
        y1 = y1;
        x2 = x1 - stick_lingth;
        y2 = y1 + stick_lingth;
        if(_sticks.getStickAt(1).isFree())
        {
            g2.drawLine((int)x1,(int)y1,(int)x2,(int)y2);//stick2
        }

        x1 = getWidth() - ((getWidth())/5 + gap_from_edge*2) ;
        y1 = (getHeight()*2)/3-gap_from_edge*2  ;
        x2 = x1 + stick_lingth;
        y2 = y1 + stick_lingth;
        if(_sticks.getStickAt(2).isFree())
        {
            g2.drawLine((int)x1,(int)y1,(int)x2,(int)y2);//sick 3
        }

        x1 = getWidth()/2-3 ;
        y1 = getHeight()-getHeight()/3;
        x2 = x1;
        y2 = y1 + stick_lingth*3/2;
        if(_sticks.getStickAt(3).isFree())
        {
            g2.drawLine((int)x1,(int)y1,(int)x2,(int)y2);//sick 4
        }

        x1 = (getWidth())/5 + gap_from_edge*2 ;
        y1 = (getHeight()*2)/3-gap_from_edge*2  ;
        x2 = x1 - stick_lingth;
        y2 = y1 + stick_lingth;
        if(_sticks.getStickAt(4).isFree())
        {
            g2.drawLine((int)x1,(int)y1,(int)x2,(int)y2);//sick 5
        }
    }
}

