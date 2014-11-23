public class NumberDisplay
{
    // limite del display
    private int limit;
    //valor del display
    private int valueDisplay;
    /**
     * Constructor for objects of class NumberDisplay
     * select limit of display
     * fija valor display a 0
     */
    public NumberDisplay(int newLimit )
    {
        valueDisplay = 0;
        limit = newLimit;
    }

    /**
     * fija valor actual del siplay pasado por parametro
     */
    public void setValue(int value)
    {
        if (value < limit)
        {
            valueDisplay = value;
        }
        else
        {
            valueDisplay = limit;
        }
    }

    /**
     * metodo devuelve el valor actual del display en dos digitos
     */
    public String getDisplayValue()
    {
        String curentValue;
        if (valueDisplay < 10)
        {
            curentValue = "0" + valueDisplay;
        }
        else
        {
            curentValue = "" + valueDisplay;
        }
        return curentValue;
    }

    /**
     * metodo que devuelve valor de display como entero
     */
    public int getValue()
    {
        return valueDisplay;
    }

    /**
     * metodo que suma 1 al display si llega al limite lo pone a 0
     */
    public void increment()
    {
        valueDisplay++;
        if(valueDisplay == limit)
        {
            valueDisplay = 0;
        }
    }
}