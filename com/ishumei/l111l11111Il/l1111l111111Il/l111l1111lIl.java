package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Parcel;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;

public final class l111l1111lIl extends l111l1111lI1l {
  private Context l1111l111111Il;
  
  private ServiceConnection l111l11111I1l = new ServiceConnection(this) {
      public final void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
        try {
          return;
        } finally {
          param1ComponentName = null;
        } 
      }
      
      public final void onServiceDisconnected(ComponentName param1ComponentName) {}
    };
  
  private final LinkedBlockingQueue<IBinder> l111l11111lIl = new LinkedBlockingQueue<IBinder>(1);
  
  l111l1111lIl(Context paramContext) {
    this.l1111l111111Il = paramContext;
  }
  
  private static String l1111l111111Il(Context paramContext, String paramString) {
    try {
      Signature[] arrayOfSignature = (paramContext.getPackageManager().getPackageInfo(paramString, 64)).signatures;
      if (arrayOfSignature != null && arrayOfSignature.length > 0) {
        int i = 0;
        byte[] arrayOfByte = arrayOfSignature[0].toByteArray();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        if (messageDigest != null) {
          arrayOfByte = messageDigest.digest(arrayOfByte);
          StringBuilder stringBuilder = new StringBuilder();
          int j = arrayOfByte.length;
          while (i < j) {
            stringBuilder.append(Integer.toHexString(arrayOfByte[i] & 0xFF | 0x100).substring(1, 3));
            i++;
          } 
          return stringBuilder.toString();
        } 
      } 
    } catch (Exception exception) {}
    return "";
  }
  
  private String l1111l111111Il(IBinder paramIBinder) {
    String str1 = this.l1111l111111Il.getPackageName();
    String str2 = l1111l111111Il(this.l1111l111111Il, str1);
    try {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken("com.heytap.openid.IOpenID");
        parcel1.writeString(str1);
        parcel1.writeString(str2);
        parcel1.writeString("OUID");
        paramIBinder.transact(1, parcel1, parcel2, 0);
        parcel2.readException();
      } finally {
        exception.recycle();
        parcel2.recycle();
      } 
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public final String l1111l111111Il() {
    Intent intent = new Intent();
    intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
    intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
    boolean bool = this.l1111l111111Il.bindService(intent, this.l111l11111I1l, 1);
    String str1 = "";
    String str2 = str1;
    if (bool)
      try {
        str2 = l1111l111111Il(this.l111l11111lIl.take());
        str1 = str2;
        return str2;
      } finally {
        str2 = null;
      }  
    return str2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il\l111l1111lIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */