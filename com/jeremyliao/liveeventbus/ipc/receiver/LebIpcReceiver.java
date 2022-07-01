package com.jeremyliao.liveeventbus.ipc.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.jeremyliao.liveeventbus.ipc.decode.IDecoder;
import com.jeremyliao.liveeventbus.ipc.decode.ValueDecoder;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;

public class LebIpcReceiver extends BroadcastReceiver {
  private IDecoder decoder;
  
  public LebIpcReceiver(JsonConverter paramJsonConverter) {
    this.decoder = (IDecoder)new ValueDecoder(paramJsonConverter);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if ("intent.action.ACTION_LEB_IPC".equals(paramIntent.getAction()))
      try {
        String str = paramIntent.getStringExtra("leb_ipc_key");
        Object object = this.decoder.decode(paramIntent);
        if (str != null) {
          LiveEventBus.get(str).post(object);
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public void setJsonConverter(JsonConverter paramJsonConverter) {
    this.decoder = (IDecoder)new ValueDecoder(paramJsonConverter);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\ipc\receiver\LebIpcReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */