package com.example.isacclee.firsthello;



/**
 * Created by Pro15 on 17/7/11.
 */



import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.app.*;
import android.app.Activity;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.*;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.provider.MediaStore.Audio;
import android.util.Log;
import android.widget.RemoteViews;


public class NotificationActivity extends Activity {

    public NotificationActivity(String title, String content) {

        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,  new Intent(this, MainActivity.class), 0);

        Notification notify= new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher) // 设置状态栏中的小图片，尺寸一般建议在24×24， 这里也可以设置大图标
                .setTicker(title)// 设置显示的提示文字
                        .setContentTitle(title)// 设置显示的标题
                        .setContentText(content)// 消息的详细内容
                        .setContentIntent(pendingIntent) // 关联PendingIntent
                     //   .setNumber(1) // 在TextView的方显示的数字，可以在外部定义一个变量，点击累加setNumber(count),这时显示的和
                        .getNotification(); // 需要注意build()是在API level16及之后增加的，在API11中可以使用getNotificatin()来代替
        notify.flags |= Notification.FLAG_AUTO_CANCEL;

        manager.notify(0, notify);

    }

}
