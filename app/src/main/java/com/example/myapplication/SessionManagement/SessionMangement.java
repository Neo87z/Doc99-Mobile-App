package com.example.myapplication.SessionManagement;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myapplication.Models.User;

public class SessionMangement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String Session_LoginID="Session";
    String ViewKey="1";


    public SessionMangement(Context context){
        sharedPreferences=context.getSharedPreferences(Session_LoginID,Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void SaveSession(User user){
        String Username=user.getNIC();
        editor.putString(Session_LoginID,Username).commit();

    }

    public String GetUserID(){
        return sharedPreferences.getString(Session_LoginID,"null");
    }

}
