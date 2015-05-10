package time;

import java.util.Calendar;

public class Time {

    private int hour, minute, second, date, month, year;

    public Time(int hour, int minute, int second, int date, int month, int year) throws IllegalArgumentException {
        super();
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        setDate(date);
        setMonth(month);
        setYear(year);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) throws IllegalArgumentException {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException();
        }
        this.hour = hour;
    }

    public int getMinute() {

        return minute;
    }

    public void setMinute(int minute) throws IllegalArgumentException {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException();
        }
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) throws IllegalArgumentException {
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException();
        }
        this.second = second;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) throws IllegalArgumentException {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException();
        }
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) throws IllegalArgumentException {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException();
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws IllegalArgumentException {
        if (year < 0 || year > 9999) {
            throw new IllegalArgumentException();
        }
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d %02d.%02d.%02d ", hour, minute, second, date, month, year);
    }

    public Time now() {

        Calendar cal = Calendar.getInstance();
        Time currentTime = new Time(0, 0, 0, 0, 0, 0);

        currentTime.hour = cal.get(Calendar.HOUR_OF_DAY);
        currentTime.minute = cal.get(Calendar.MINUTE);
        currentTime.second = cal.get(Calendar.SECOND);

        currentTime.date = cal.get(Calendar.DAY_OF_MONTH);
        currentTime.month = cal.get(Calendar.MONTH);
        currentTime.year = cal.get(Calendar.YEAR);

        return currentTime;

    }

}
