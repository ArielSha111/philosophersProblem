import javax.swing.*;  
public class PhilosophersProblemMain extends JPanel
{
    private static final int SIZE_OF_FRAME = 450;
    private static final int NUM_OF_PHILS  = 5;
    private static final int FRAME_START_X = 700, FRAME_START_Y = 200;
    public static void main(String [] args)
    {
        JFrame frame = new JFrame("The Philosopher Problem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(SIZE_OF_FRAME,SIZE_OF_FRAME); 
        frame.setLocation(FRAME_START_X, FRAME_START_Y);
                              
        Sticks sticks = new Sticks(NUM_OF_PHILS);
        PhilosopherProblemUi ppu = new PhilosopherProblemUi(sticks, NUM_OF_PHILS); 
        frame.add(ppu);
        frame.setVisible(true); 

        PhilosopherController controller = new PhilosopherController(NUM_OF_PHILS,sticks,ppu); 
        PhilosopherThread [] philosopher_table = new PhilosopherThread[NUM_OF_PHILS];
        for(int i=0;i<philosopher_table.length;i++)  
        {
            philosopher_table[i] = new PhilosopherThread(controller,i+1, ppu);
            philosopher_table[i].start();
        }
    }
}

