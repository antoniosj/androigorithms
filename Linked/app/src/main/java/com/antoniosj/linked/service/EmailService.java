package com.antoniosj.linked.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class EmailService extends Service {
    private static final String TAG = "ASJR";


//
//    @Override
//    public IBinder onBind(Intent intent) {
//        Log.d(TAG, "on bindddd");
//        return null;
//    }

//    @Override
//    protected void onHandleIntent(@Nullable Intent intent) {
//        if (intent != null) {
//            Log.d(TAG, "handleintent");
//            Intent it = new Intent("sync");
//            it.setAction("sync");
//            it.putExtra("teste", "testeAlfa");
//            sendBroadcast(it);
//        }
//    }

//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.d(TAG, "Received start id " + startId + ": " + intent);
//        // We want this service to continue running until it is explicitly
//        // stopped, so return sticky.
//        return START_STICKY;
//    }
//    public void onDestroy() {
//
//        Log.d(TAG, "onDestroy");
//    }



    public Messenger mMessenger = new Messenger(new MessageHandler(this));

    public static final String KEY_MESSAGE = "KEY_MESSAGE";

    public EmailService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "RUNABLE");
            }
        }).start();
        return START_NOT_STICKY;
    }

    public static class MessageHandler extends Handler {

        WeakReference<Context> contextReference;

        public MessageHandler(Context context) {
            contextReference = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {
            if (contextReference.get() != null) {
                Log.d(TAG, "bom dia");
                Message message = Message.obtain(null, 0);
                Toast.makeText(contextReference.get(), msg.getData().getString(KEY_MESSAGE), Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("KEY_MESSAGE", "OLARR");
                msg.setData(bundle);
                message.setData(bundle);
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
            super.handleMessage(msg);
        }
    }

}
