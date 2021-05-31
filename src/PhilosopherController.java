import java.util.*; 
public class PhilosopherController
{
    private int ammount_of_checked_nums;
    private int _amount_of_sticks;
    private Sticks _sticks;
    private PhilosopherProblemUi _ppu;
    /**
     * A parameters constarctor for PhilosopherController
     *
     * @param   amount_of_sticks,Sticks sticks,PhilosopherProblemUi ppu
     */
    public PhilosopherController(int amount_of_sticks,Sticks sticks,PhilosopherProblemUi ppu)
    {
        _amount_of_sticks = amount_of_sticks;
        _sticks = sticks;
        _ppu = ppu;
    }

    /**
     * A synchronized method that get a philosopher number and change the grab
     * value of the minimal stick in front of him to be true
     *
     * @param   phil_number
     */
    public synchronized void grabMinStick(int phil_number)
    {
        Stick a = _sticks.getStickAt(phil_number-1);
        Stick b = _sticks.getStickAt(phil_number);
        Stick min_stick;
        if(a.isSmallerThen(b))
            min_stick=a;
        else
            min_stick=b;
        while(!min_stick.isFree())
        {            
            try             
            {
                wait();//then wait until one of the thread is done
            }
            catch(InterruptedException e){}//catch an error that can accure
        }
        if(a.isSmallerThen(b))
            _sticks.grabStickAt(phil_number-1);//grab the smaller stick
        else
            _sticks.grabStickAt(phil_number);
        _ppu.repaint();
    }

    /**
     * A synchronized method that get a philosopher number and change the grab
     * value of the non minimal stick in front of him to be true
     *
     * @param   phil_number
     */
    public synchronized void grabOtherStick(int phil_number)
    {
        Stick a = _sticks.getStickAt(phil_number-1);
        Stick b = _sticks.getStickAt(phil_number);
        Stick other_stick;
        if(a.isSmallerThen(b))
            other_stick = b;
        else
            other_stick = a;
        while(!other_stick.isFree())
        {
            try             
            {
                wait();//then wait until one of the thread is done
            }
            catch(InterruptedException e){}//catch an error that can accure                        
        }
        if(a.isSmallerThen(b))
            _sticks.grabStickAt(phil_number);//grab the smaller stick
        else
            _sticks.grabStickAt(phil_number-1);
        _ppu.repaint();
    }

    /**
     * A synchronized method that get a philosopher number and change the grab
     * value of the  minimal stick in front of him to be false
     *
     * @param   phil_number
     */
    public synchronized void ReleaseMinStick(int phil_number)
    {
        Stick a = _sticks.getStickAt(phil_number-1);
        Stick b = _sticks.getStickAt(phil_number);
        if(a.isSmallerThen(b))
            _sticks.releaseStickAt(phil_number-1);//makes stick a to be free
        else
            _sticks.releaseStickAt(phil_number);
        _ppu.repaint();
        notifyAll();
    }

    /**
     * A synchronized method that get a philosopher number and change the grab
     * value of the  non minimal stick in front of him to be false
     *
     * @param   phil_number
     */
    public synchronized void ReleaseOtherStick(int phil_number)
    {
        Stick a = _sticks.getStickAt(phil_number-1);
        Stick b = _sticks.getStickAt(phil_number);        
        if(a.isSmallerThen(b))
            _sticks.releaseStickAt(phil_number);//makes stick a to be free
        else
            _sticks.releaseStickAt(phil_number-1);
        _ppu.repaint();    
        notifyAll();
    }

    /**
     * A synchronized get method for _sticks
     *
     * @return  Sticks _sticks
     */
    public synchronized Sticks getSticks()
    {
        return _sticks;
    }
}

