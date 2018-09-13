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

import com.antoniosj.linked.linkedlists.EmailThread;
import com.antoniosj.linked.model.Node;
import com.google.gson.Gson;


import java.lang.ref.WeakReference;

public class EmailService extends Service {
    private static final String TAG = "ASJR";

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
        return START_STICKY;
    }

    public static class MessageHandler extends Handler {

        WeakReference<Context> contextReference;

        public MessageHandler(Context context) {
            contextReference = new WeakReference<>(context);
        }

        @Override
        public void handleMessage(Message msg) {

            if (contextReference.get() != null) {

                Message message = Message.obtain(null, 0);

                Bundle bundle = new Bundle();
                String json = msg.getData().getString(KEY_MESSAGE);
                Node email = new Gson().fromJson(json, Node.class);
                EmailThread thread = new EmailThread();

                thread.removeDupEmails(email);

                String jsonToSent = new Gson().toJson(email);
                bundle.putString(KEY_MESSAGE, jsonToSent);

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
