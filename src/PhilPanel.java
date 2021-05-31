import javax.swing.*;  
import java.awt.*; 
/**
 * Write a description of class PhilPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhilPanel extends JPanel
{
    private boolean [] _eats_status_array;
    private int _panel_num;
    /**
     * a constructor for the panel that contain a philosopher
     *
     * @param    panel_num, boolean [] eats_status_array
     */
    public PhilPanel(int panel_num, boolean [] eats_status_array)
    {
        _eats_status_array = eats_status_array;
        _panel_num = panel_num;
    }

    /**
     * a synchronized paint paintComponent override
     * this method draw the philosopher on the panel
     *
     * @param    g
     */
    protected synchronized void paintComponent (Graphics g)
    {
        super.paintComponent(g);        
        JPanel Phil = new JPanel(); 
        int width = getWidth();
        int height = getHeight();
        double x;
        double y;
        int phil_length;
        int phil_height;
        if(_panel_num==1)
        {
            phil_length = width/10;
            phil_height = height/3;
            x = width/3*1.35;
            y = height/3*1.2;
            if(_eats_status_array[0]==true)
                g.fillOval((int)x,(int)y,phil_length,phil_height);
            else
                g.fillRect((int)x,(int)y,phil_length,phil_height);
        }
        else if(_panel_num==2)
        {
            phil_length = width/3;
            phil_height = height/10;
            x = width/3;
            y = height/3*1.2;
            if(_eats_status_array[1]==true)
                g.fillOval((int)x,(int)y,phil_length,phil_height);
            else
                g.fillRect((int)x,(int)y,phil_length,phil_height);
        }
        else if(_panel_num==3)
        {
            phil_length = width/10;
            phil_height = height/3;
            x = width/6*3.42;
            y = height/4;
            if(_eats_status_array[2]==true)
                g.fillOval((int)x,(int)y,phil_length,phil_height);
            else
                g.fillRect((int)x,(int)y,phil_length,phil_height);            
            x = width/6*1.92;
            y = height/4;
            if(_eats_status_array[3]==true)
                g.fillOval((int)x,(int)y,phil_length,phil_height);
            else
                g.fillRect((int)x,(int)y,phil_length,phil_height);
        }
        else 
        {
            phil_length = width/3;
            phil_height = height/10;
            x = width/3;
            y = height/3*1.2;
            if(_eats_status_array[4]==true)
                g.fillOval((int)x,(int)y,phil_length,phil_height);
            else
                g.fillRect((int)x,(int)y,phil_length,phil_height);
        }        
    }

}
