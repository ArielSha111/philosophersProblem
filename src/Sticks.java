public class Sticks
{
    private Stick [] _stick_arr; 
    private int _amount_of_sticks;
    /**
     * An example of a method - replace this comment with your own
     *
     * @param   amount_of_sticks
     */
    public Sticks(int amount_of_sticks)
    {
        _amount_of_sticks = amount_of_sticks;
        _stick_arr = new Stick[_amount_of_sticks]; 
        for(int i = 0;i<_amount_of_sticks;i++)
        {
            _stick_arr[i] = new Stick(true,i+1);
        }
    }

    /**
     * A get method for sticks
     *
     * @return  Stick[]
     */
    public Stick[] getSticks()
    {
        return _stick_arr;
    }

    /**
     * A get method for certin stick from the stick arr
     *
     * @param     stick_num
     * @return  Stick
     */
    public Stick getStickAt(int stick_num) 
    {
        if(stick_num==_amount_of_sticks)
            return _stick_arr[0];
        else if(stick_num<_amount_of_sticks)
            return _stick_arr[stick_num];
        return null;
    }

    /**
     * A set method for certin stick from the stick arr
     *
     * @param     i, boolean status
     */
    private void setStickStatusAt(int stick_num, boolean status)
    {
        if(stick_num<_amount_of_sticks)
        {
            _stick_arr[stick_num].setStatus(status);
        }
        else if(stick_num==_amount_of_sticks)
        {
            _stick_arr[0].setStatus(status);
        }
    }

    /**
     * A method that change stick boolean val to true since its grabbed
     *
     * @param     i
     */
    public void grabStickAt(int i)
    {
        setStickStatusAt(i, false);
    }

    /**
     * A method that change stick boolean val to true since its relesed
     *
     * @param     i
     */
    public void releaseStickAt(int i)
    {
        setStickStatusAt(i, true);
    }

    public String toString()
    {
        String s="";
        for(int i = 0;i<_amount_of_sticks;i++)
        {
            if(_stick_arr[i].isFree())
                s+="stick "+(i+1)+" is free\n";
            else
                s+="stick "+(i+1)+" is not free\n";
        }
        return s;
    }

}
