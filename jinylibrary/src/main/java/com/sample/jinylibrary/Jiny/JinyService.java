package com.sample.jinylibrary.Jiny;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Anukool Srivastav on 6/21/2017.
 */

public class JinyService {

    private static JinyService jinyService = new JinyService();

    private JinyService(){}

    public static JinyService getInstance(){
        return jinyService;
    }


    private Intent uiServiceIntent;

    public void startPointerService(Context context){
        // Start the Ui Service
        uiServiceIntent = new Intent(context, PointerService.class);
        context.startService(uiServiceIntent);
    }

    public void stopPointerService(Context context){
        // hide when the view changed
        PointerService.bus.post(new BusEvents.RemoveEvent());

        if (uiServiceIntent != null)
            context.stopService(uiServiceIntent);
    }

    public void hidePointer(){
        PointerService.bus.post(new BusEvents.HideEvent());
    }

}
