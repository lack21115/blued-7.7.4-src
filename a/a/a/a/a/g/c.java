package a.a.a.a.a.g;

import a.a.a.a.a.e.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;

public final class c {
  public AudioManager a;
  
  public BroadcastReceiver b = new a(this);
  
  public void a(Context paramContext) {
    if (this.a == null)
      this.a = (AudioManager)paramContext.getSystemService("audio"); 
    AudioManager audioManager = this.a;
    if (audioManager != null && audioManager.isBluetoothScoAvailableOffCall()) {
      e.g.c("BluetoothScoManager", "register");
      this.a.stopBluetoothSco();
      try {
        this.a.startBluetoothSco();
        paramContext.registerReceiver(this.b, new IntentFilter("android.media.SCO_AUDIO_STATE_CHANGED"));
        return;
      } catch (Exception exception) {
        e e = e.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception when startBluetoothSco & registerReceiver:");
        stringBuilder.append(exception.getMessage());
        e.e("BluetoothScoManager", stringBuilder.toString());
      } 
    } 
  }
  
  public void b(Context paramContext) {
    AudioManager audioManager = this.a;
    if (audioManager != null && audioManager.isBluetoothScoAvailableOffCall()) {
      e.g.c("BluetoothScoManager", "unregister");
      try {
        paramContext.unregisterReceiver(this.b);
      } catch (Exception exception) {
        exception.printStackTrace();
      } 
      if (this.a.isBluetoothScoOn()) {
        this.a.setBluetoothScoOn(false);
        this.a.stopBluetoothSco();
      } 
    } 
  }
  
  public class a extends BroadcastReceiver {
    public a(c this$0) {}
    
    public void onReceive(Context param1Context, Intent param1Intent) {
      if (c.a(this.a) == null)
        return; 
      if (1 == param1Intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1)) {
        e.g.c("BluetoothScoManager", "setBluetoothScoOn to true");
        c.a(this.a).setBluetoothScoOn(true);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */