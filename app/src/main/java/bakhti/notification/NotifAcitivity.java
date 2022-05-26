package bakhti.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import androidx.core.app.NotificationCompat;

public class NotifAcitivity extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // prepare intent which is triggered if the
// notification is selected

        Intent intent = new Intent(this, NotifAcitivity.class);
// use System.currentTimeMillis() to have a unique ID for the pending intent
        PendingIntent pIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(), intent, 0);

// build notification
// the addAction re-use the same intent to keep the example short
        Notification n  = new Notification.Builder(this)
                .setContentTitle("New mail from " + "test@gmail.com")
                .setContentText("Subject")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .addAction(R.drawable.ic_launcher_background, "Call", pIntent)
                .addAction(R.drawable.ic_launcher_background, "More", pIntent)
                .addAction(R.drawable.ic_launcher_background, "And more", pIntent).build();


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);
    }
}
