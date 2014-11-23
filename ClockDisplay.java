public class ClockDisplay
{
    //horas
    private NumberDisplay hours;
    //minutos
    private NumberDisplay minutes;
    //dia
    private NumberDisplay day;
    //mes
    private NumberDisplay month;
    //Año
    private NumberDisplay year;
    //hora actual en 5 caracteres
    private String displayString;
    //fecha actual
    private String displayDate;
    /**
     * Constructor fija la fecha por defecto
     */
    public ClockDisplay()
    {
        day = new NumberDisplay(30);
        month = new NumberDisplay(12);
        year = new NumberDisplay(99);
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor que fija por parametros la fecha
     */
    public ClockDisplay(int newHour, int newMinute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        hours.setValue(newHour);
        minutes.setValue(newMinute);
        updateDisplay();
    }

    /**
     * Fija valores a los atributos
     */
    public void setTime(int newHour, int newMinute, int newDay, int newMonth, int newYear)
    {
        day.setValue(newDay);
        month.setValue(newMonth);
        year.setValue(newYear);
        hours.setValue(newHour);
        minutes.setValue(newMinute);
        updateDisplay();
    }

    /**
     * Devuelve la fecha en string
     */
    public String getTime()
    {
        String completeDate;
        displayDate = day.getDisplayValue() + "/" + month.getDisplayValue() + "/" + year.getDisplayValue();
        completeDate = displayString + " " + displayDate;
        return completeDate;
    }

    /**
     * Adelanta el reloj 1 min
     */
    public void timeTick()
    {
        minutes.increment();
        if (minutes.getValue() == 0)
        {
            hours.increment();
            if (hours.getValue() == 0)
            {               
                day.increment();
                if (day.getValue() == 0)
                {
                    day.setValue(1);
                    month.increment();
                    if (month.getValue() == 0)
                    {
                        day.setValue(1);
                        year.increment();
                    }
                }
            }
        }
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public void updateDisplay()
    {
        int actualHour = hours.getValue();
        String displayedHour = "";
        String amPm = "";
        boolean isMorning = true;
        if (actualHour == 0)
        {
            displayedHour = "12";
            isMorning = true;
        }
        else if (actualHour < 10)
        {
            displayedHour = "0" + actualHour;
            isMorning = true;
        }
        else if (actualHour < 12)
        {
            displayedHour = "" + actualHour;
            isMorning = true;
        }
        else if (actualHour == 12)
        {
            displayedHour = "12";
            isMorning = false;
        }
        else if (actualHour < 22)
        {
            displayedHour = "0" + (actualHour - 12);
            isMorning = false;
        }
        else
        {
            displayedHour = "" + (actualHour- 12);
            isMorning = false;
        }

        if (isMorning)
        {
            amPm = "am";
        }
        else
        {
            amPm = "pm";
        }
        displayString = displayedHour + ":" + minutes.getDisplayValue() + amPm;
    }
}
