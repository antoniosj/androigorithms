package com.antoniosj.clientservice;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    Messenger myService = null;
    Messenger myService2 = null;
    boolean isBound;



    private TextView textViewRandomNumber;
    class RecieveRandomNumberHandler extends Handler{


        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 0:
                    Toast.makeText(MainActivity.this, msg.getData().getString("KEY_MESSAGE"), Toast.LENGTH_SHORT).show();
                    Log.d("asjr", msg.arg1 + " 2");
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent("com.example.RemoteService");
        intent.setComponent(new ComponentName("com.antoniosj.linked", "com.antoniosj.linked.service.EmailService"));


        findViewById(R.id.invoke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bindService(intent, myConnection, Context.BIND_AUTO_CREATE);
                if (!isBound) {
                    Toast.makeText(MainActivity.this, "FODA-SE", Toast.LENGTH_SHORT).show();
                    return;
                }
                Message msg = Message.obtain(null, 0);
                msg.replyTo = myService2;


                Bundle bundle = new Bundle();
                bundle.putString("KEY_MESSAGE", "Message Received!!!!");
                msg.setData(bundle);

                try {
                    myService.send(msg);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });




        findViewById(R.id.unbind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(myConnection);
                isBound = false;
                Toast.makeText(MainActivity.this, "PAROU", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ServiceConnection myConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {

            myService = new Messenger(service);
            myService2 = new Messenger(new RecieveRandomNumberHandler());
            isBound = true;
        }

        public void onServiceDisconnected(ComponentName className) {
            myService = null;

            isBound = false;
        }
    };

}
