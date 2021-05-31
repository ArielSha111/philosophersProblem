import javax.swing.*;  
import java.awt.*; 
public class PhilosopherProblemUi extends JPanel
{
    private int _num_of_phils;
    private Color myBrown = new Color(222,184,135); // Color brown
    private Sticks _sticks;
    private boolean [] _eats_status_array;
    private final int WIDTH_OF_BORDER = 100, LENGTH_OF_BORDER = 100;

    /**
     * creatin a new panel that contain all the needed data for the philosopher table
     *
     * @param   sticks, int num_of_phils
     */
    public PhilosopherProblemUi(Sticks sticks, int num_of_phils)
    {               
        _num_of_phils = num_of_phils;
        _eats_status_array= new boolean[num_of_phils];
        _sticks = sticks;

        JPanel tabel_panel = new JPanel();
        tabel_panel.setLayout(new BorderLayout());
        Table table = new Table(myBrown,_sticks);                      
        tabel_panel.add(table, BorderLayout.CENTER);

        PhilPanel phil_panel1 = new PhilPanel(1, _eats_status_array);
        PhilPanel phil_panel2 = new PhilPanel(2, _eats_status_array);
        PhilPanel phil_panel3 = new PhilPanel(3, _eats_status_array);
        PhilPanel phil_panel4 = new PhilPanel(4, _eats_status_array);

        phil_panel1.setPreferredSize(new Dimension(WIDTH_OF_BORDER,LENGTH_OF_BORDER));
        phil_panel2.setPreferredSize(new Dimension(WIDTH_OF_BORDER,LENGTH_OF_BORDER)); 
        phil_panel3.setPreferredSize(new Dimension(WIDTH_OF_BORDER,LENGTH_OF_BORDER)); 
        phil_panel4.setPreferredSize(new Dimension(WIDTH_OF_BORDER,LENGTH_OF_BORDER));

        tabel_panel.add(phil_panel1, BorderLayout.NORTH);
        tabel_panel.add(phil_panel2 , BorderLayout.EAST);
        tabel_panel.add(phil_panel3, BorderLayout.SOUTH);
        tabel_panel.add(phil_panel4, BorderLayout.WEST);

        setLayout(new BorderLayout());
        add(tabel_panel, BorderLayout.CENTER);
    }

    /**
     * a synchronized notify method that makes sure to repaint the
     * philosopher tabel according to the parameters it recive 
     *
     * @param   eating_status,int phil_num
     */
    public synchronized void eatsNotify(boolean eating_status,int phil_num)
    {
        _eats_status_array[phil_num-1] = eating_status;
        repaint();
    }
}

