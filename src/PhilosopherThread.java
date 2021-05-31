import java.util.Random; 
public class PhilosopherThread extends Thread
{
    private PhilosopherController _controller;
    public boolean _is_eating;
    private int _phil_number;
    private final int SLEEP_MAX = 10000, SLEEP_MIN = 1000; 
    private Random rand = new Random(); 
    private PhilosopherProblemUi _ppu;

    /**
     * A parameters constructor for Philosopher
     *
     * @param   controller, int phil_number, PhilosopherProblemUi ppu
     */
    public PhilosopherThread(PhilosopherController controller, int phil_number, PhilosopherProblemUi ppu)
    {       
        _controller = controller;
        _is_eating = false;
        _phil_number = phil_number;
        _ppu = ppu;
    }

    /**
     * A run override to be activated when the philosopher thread is activated
     *
     */
    public void run()
    {        
        while(true)
        {
            synchronized (this)
            {                
                System.out.println("philosopher number: "+_phil_number + " is thinking");
                think();                
            }
            synchronized (this)
            {                
                _controller.grabMinStick(_phil_number);
                System.out.println("philosopher number: "+_phil_number + " grabbed min stick");
            }
            synchronized (this)
            {                
                _controller.grabOtherStick(_phil_number);
                System.out.println("philosopher number: "+_phil_number + " grabbed other stick");
            }
            synchronized (this)
            {
                System.out.println("philosopher number: "+_phil_number + " is eating");
                eat();
                System.out.println("philosopher number: "+_phil_number + " is resting");
                rest();                              
            }
            synchronized (this)
            {
                System.out.println("philosopher number: "+_phil_number + " released min stick");
                _controller.ReleaseMinStick(_phil_number);
            }
            synchronized (this)
            {
                System.out.println("philosopher number: "+_phil_number + " released other stick");
                _controller.ReleaseOtherStick(_phil_number);
            }
        }
    }

    /**
     * this method change the global eat status to be true, lets the class
     * know its been change, and then wait for a random time 
     *
     */
    public void eat()
    {        
        _is_eating = true;
        _ppu.eatsNotify(true,_phil_number);
        try
        {
            Thread.sleep(rand.nextInt(SLEEP_MAX - SLEEP_MIN)+SLEEP_MIN);
        }
        catch(InterruptedException e){}   
    }

    /**
     * this method creates a delay which resemble a thinking act fot the philosopher
     *
     */
    public void think()
    {
        try
        {
            Thread.sleep(rand.nextInt(SLEEP_MAX - SLEEP_MIN)+SLEEP_MIN);
        }
        catch(InterruptedException e){}
    }    

    /**
     * this method change the _is_eating value to be false 
     * this basically a resting act for the philosopher
     *
     */
    public synchronized void rest()
    {
        _ppu.eatsNotify(false,_phil_number);
        _is_eating = false;
    }

}
