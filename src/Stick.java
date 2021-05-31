public class Stick
{
    private boolean _free_status;
    private int _stick_num;
    /**
     * An empty constructor for Stick
     *
     */
    public  Stick()
    {
        _free_status = true;
        _stick_num = 0;
    }

    /**
     * a parameter constructor for Stick
     *
     * @param   free_status,int stick_num
     */
    public  Stick(boolean free_status,int stick_num)
    {
        _free_status = free_status;
        _stick_num = stick_num;
    }

    /**
     * a get method for _free_status
     *
     * @return  boolean _free_status
     */
    public boolean getStatus()
    {
        return _free_status;
    }

    /**
     * a set method for _free_status
     *
     * @param   status
     */
    public void setStatus(boolean status)
    {
        _free_status = status;
    }

    /**
     * a get method for _stick_num
     *
     * @return  int _stick_num 
     */
    public int getNum()
    {
        return _stick_num;
    }

    /**
     * a set method for stick_num
     *
     * @param   stick_num
     */
    public void setNum(int stick_num)
    {
        _stick_num = stick_num;
    }

    /**
     * a method to check if a stick is free
     *
     * @return   boolean _free_status
     */
    public boolean isFree()
    {
        return _free_status;
    }

    /**
     * a method that gets another stick and return true if this stick num is smaller then the new one
     *
     * @return   boolean if this is smaller then other
     */
    public boolean isSmallerThen(Stick other)
    {
        if(_stick_num<other.getNum())
            return true;
        else 
            return false;
    }

    public String toString()
    {
        if (_free_status)
            return "stick number "+_stick_num+" is free";
        return "stick number "+_stick_num+" the stick is not free";
    }
}
