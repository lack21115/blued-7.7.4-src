package cn.shuzilm.core;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import java.util.UUID;

public class DUService extends Service {
  public static WakeListener callback;
  
  private Context a;
  
  private o b = new o(this);
  
  private String c;
  
  public IBinder onBind(Intent paramIntent) {
    if (this.a == null)
      this.a = getApplicationContext(); 
    this.c = paramIntent.getStringExtra("apikey");
    if (Looper.myLooper() == null)
      Looper.prepare(); 
    if (Looper.myLooper() != null)
      DUHelper.init(this.a, this.c); 
    return (IBinder)this.b;
  }
  
  public void onCreate() {
    super.onCreate();
    if (this.a == null)
      this.a = getApplicationContext(); 
    if (Looper.myLooper() == null)
      Looper.prepare(); 
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onStart(Intent paramIntent, int paramInt) {
    super.onStart(paramIntent, paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
    try {
      DUHelper.loadLibrary();
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    Exception exception2 = null;
    try {
      String str = paramIntent.getStringExtra("s");
    } catch (Exception exception1) {
      exception1.printStackTrace();
      exception1 = exception2;
    } 
    if (exception1 != null)
      try {
        String str2 = UUID.randomUUID().toString().replace("-", "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)exception1);
        stringBuilder.append(",");
        stringBuilder.append(str2);
        String str1 = stringBuilder.toString();
        DUHelper.onIEvent(getApplicationContext(), str1);
        callback.handleWakeup(str2);
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\DUService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */