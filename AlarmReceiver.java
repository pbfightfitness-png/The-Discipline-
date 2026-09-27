package com.discipline.waroflife;

import android.app.*;
import android.content.*;
import android.os.Build;
import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {
    public static final String CHANNEL="discipline_alarm";

    @Override public void onReceive(Context c, Intent i) {
        NotificationManager nm=(NotificationManager)c.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=26){
            nm.createNotificationChannel(new NotificationChannel(CHANNEL,"Discipline Alarm",NotificationManager.IMPORTANCE_HIGH));
        }
        Notification.Builder b=Build.VERSION.SDK_INT>=26 ? new Notification.Builder(c,CHANNEL) : new Notification.Builder(c);
        b.setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
         .setContentTitle("The Discipline — 04:30 AM")
         .setContentText("Uthho Yoddha. Snan, seva, bhog/nasta aur abhyas ka sankalp yaad rakho.")
         .setAutoCancel(true)
         .setPriority(Notification.PRIORITY_HIGH);
        nm.notify(430, b.build());
        schedule(c);
    }

    public static void schedule(Context c){
        AlarmManager am=(AlarmManager)c.getSystemService(Context.ALARM_SERVICE);
        Intent in=new Intent(c,AlarmReceiver.class);
        PendingIntent pi=PendingIntent.getBroadcast(c,430,in,PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,4); cal.set(Calendar.MINUTE,30); cal.set(Calendar.SECOND,0); cal.set(Calendar.MILLISECOND,0);
        if(cal.getTimeInMillis()<=System.currentTimeMillis()) cal.add(Calendar.DAY_OF_YEAR,1);
        if(Build.VERSION.SDK_INT>=31){
            if(am.canScheduleExactAlarms()) am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi);
        } else am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pi);
    }
}
