package com.example.demo;

import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.TimerTask;
import java.util.Calendar;

public class DailyUpdates extends TimerTask {
    
    private static Timer timer = null;

    public DailyUpdates() { }

    public static void initSchedule() {
        if (DailyUpdates.timer == null) {
            return;
        }

        // Use the calendar builder class to create a new calendar
        // set to 6pm on the current date
        Calendar nextTime = new Calendar.Builder().setTimeOfDay(18, 0, 0).build();

        // If the generated time is before the current time (i.e this is run after 6pm, but before 12am)
        // the move the Calendar forward a day so the time is always in the future.
        if (nextTime.before(Calendar.getInstance())) {
            nextTime.add(Calendar.DAY_OF_MONTH, 1);
        }
        assert(nextTime.after(Calendar.getInstance())); // Must be in the future, else something has gone wrong

        long millisPerDay = TimeUnit.DAYS.toMillis(1);

        DailyUpdates.timer = new Timer(true);
        DailyUpdates.timer.scheduleAtFixedRate(new DailyUpdates(), nextTime.getTime(), millisPerDay);
    }

    public void run() {
        System.out.println("This is where scheduled daily tasks would be run.");
    }
}
