package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

public abstract class NotificationCompatSideChannelService extends Service {
  void a(int paramInt, String paramString) {
    String[] arrayOfString = getPackageManager().getPackagesForUid(paramInt);
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfString[i].equals(paramString))
        return; 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NotificationSideChannelService: Uid ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" is not authorized for package ");
    stringBuilder.append(paramString);
    throw new SecurityException(stringBuilder.toString());
  }
  
  public abstract void cancel(String paramString1, int paramInt, String paramString2);
  
  public abstract void cancelAll(String paramString);
  
  public abstract void notify(String paramString1, int paramInt, String paramString2, Notification paramNotification);
  
  public IBinder onBind(Intent paramIntent) {
    return (IBinder)(paramIntent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL") ? ((Build.VERSION.SDK_INT > 19) ? null : new NotificationSideChannelStub(this)) : null);
  }
  
  class NotificationSideChannelStub extends INotificationSideChannel.Stub {
    NotificationSideChannelStub(NotificationCompatSideChannelService this$0) {}
    
    public void cancel(String param1String1, int param1Int, String param1String2) throws RemoteException {
      this.a.a(getCallingUid(), param1String1);
      long l = clearCallingIdentity();
      try {
        this.a.cancel(param1String1, param1Int, param1String2);
        return;
      } finally {
        restoreCallingIdentity(l);
      } 
    }
    
    public void cancelAll(String param1String) {
      this.a.a(getCallingUid(), param1String);
      long l = clearCallingIdentity();
      try {
        this.a.cancelAll(param1String);
        return;
      } finally {
        restoreCallingIdentity(l);
      } 
    }
    
    public void notify(String param1String1, int param1Int, String param1String2, Notification param1Notification) throws RemoteException {
      this.a.a(getCallingUid(), param1String1);
      long l = clearCallingIdentity();
      try {
        this.a.notify(param1String1, param1Int, param1String2, param1Notification);
        return;
      } finally {
        restoreCallingIdentity(l);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\NotificationCompatSideChannelService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */