package com.example.sisco.ayomileh.Utilities;

import android.content.Intent;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import com.example.sisco.ayomileh.Activity.MainActivity;
import com.example.sisco.ayomileh.Activity.UrgentActivity;

/**
 * Created by Princhaa on /23Oct/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Intent intent = new Intent(MainActivity.mContext, UrgentActivity.class);
        MainActivity.mContext.startActivity(intent);
    }
}