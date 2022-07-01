package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.qq.e.comm.pi.ACTD;

public class ADActivity extends Activity {
  private ACTD a;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ACTD aCTD = this.a;
    if (aCTD != null)
      aCTD.onActivityResult(paramInt1, paramInt2, paramIntent); 
  }
  
  public void onBackPressed() {
    ACTD aCTD = this.a;
    if (aCTD != null)
      aCTD.onBackPressed(); 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    ACTD aCTD = this.a;
    if (aCTD != null)
      aCTD.onConfigurationChanged(paramConfiguration); 
  }
  
  protected void onCreate(Bundle paramBundle) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getIntent : ()Landroid/content/Intent;
    //   4: invokevirtual getExtras : ()Landroid/os/Bundle;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnull -> 146
    //   12: aload_2
    //   13: ldc 'gdt_activity_delegate_name'
    //   15: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_3
    //   19: aload_2
    //   20: ldc 'appid'
    //   22: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   25: astore_2
    //   26: aload_3
    //   27: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   30: ifne -> 146
    //   33: aload_2
    //   34: invokestatic isEmpty : (Ljava/lang/String;)Z
    //   37: ifeq -> 43
    //   40: goto -> 146
    //   43: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   46: aload_0
    //   47: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   50: aload_2
    //   51: invokevirtual initWith : (Landroid/content/Context;Ljava/lang/String;)Z
    //   54: ifeq -> 112
    //   57: aload_0
    //   58: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   61: invokevirtual getPM : ()Lcom/qq/e/comm/managers/plugin/PM;
    //   64: invokevirtual getPOFactory : ()Lcom/qq/e/comm/pi/POFactory;
    //   67: aload_3
    //   68: aload_0
    //   69: invokeinterface getActivityDelegate : (Ljava/lang/String;Landroid/app/Activity;)Lcom/qq/e/comm/pi/ACTD;
    //   74: putfield a : Lcom/qq/e/comm/pi/ACTD;
    //   77: aload_0
    //   78: getfield a : Lcom/qq/e/comm/pi/ACTD;
    //   81: ifnonnull -> 146
    //   84: new java/lang/StringBuilder
    //   87: dup
    //   88: ldc 'Init ADActivity Delegate return null,delegateName'
    //   90: invokespecial <init> : (Ljava/lang/String;)V
    //   93: astore_2
    //   94: aload_2
    //   95: aload_3
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_2
    //   101: invokevirtual toString : ()Ljava/lang/String;
    //   104: astore_2
    //   105: aload_2
    //   106: invokestatic e : (Ljava/lang/String;)V
    //   109: goto -> 146
    //   112: ldc 'Init GDTADManager fail in AdActivity'
    //   114: astore_2
    //   115: goto -> 105
    //   118: astore_2
    //   119: new java/lang/StringBuilder
    //   122: dup
    //   123: ldc 'Init ADActivity Delegate Faile,DelegateName:'
    //   125: invokespecial <init> : (Ljava/lang/String;)V
    //   128: astore #4
    //   130: aload #4
    //   132: aload_3
    //   133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload #4
    //   139: invokevirtual toString : ()Ljava/lang/String;
    //   142: aload_2
    //   143: invokestatic e : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   146: aload_0
    //   147: getfield a : Lcom/qq/e/comm/pi/ACTD;
    //   150: astore_2
    //   151: aload_2
    //   152: ifnull -> 165
    //   155: aload_2
    //   156: aload_1
    //   157: invokeinterface onBeforeCreate : (Landroid/os/Bundle;)V
    //   162: goto -> 169
    //   165: aload_0
    //   166: invokevirtual finish : ()V
    //   169: aload_0
    //   170: aload_1
    //   171: invokespecial onCreate : (Landroid/os/Bundle;)V
    //   174: aload_0
    //   175: getfield a : Lcom/qq/e/comm/pi/ACTD;
    //   178: astore_2
    //   179: aload_2
    //   180: ifnull -> 190
    //   183: aload_2
    //   184: aload_1
    //   185: invokeinterface onAfterCreate : (Landroid/os/Bundle;)V
    //   190: return
    // Exception table:
    //   from	to	target	type
    //   43	105	118	finally
    //   105	109	118	finally
  }
  
  protected void onDestroy() {
    super.onDestroy();
    ACTD aCTD = this.a;
    if (aCTD != null)
      aCTD.onDestroy(); 
  }
  
  public void onPause() {
    ACTD aCTD = this.a;
    if (aCTD != null)
      aCTD.onPause(); 
    super.onPause();
  }
  
  protected void onResume() {
    super.onResume();
    ACTD aCTD = this.a;
    if (aCTD != null)
      aCTD.onResume(); 
  }
  
  protected void onStop() {
    ACTD aCTD = this.a;
    if (aCTD != null)
      aCTD.onStop(); 
    super.onStop();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\ADActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */