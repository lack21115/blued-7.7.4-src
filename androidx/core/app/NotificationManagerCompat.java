package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class NotificationManagerCompat {
  public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
  
  public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
  
  public static final int IMPORTANCE_DEFAULT = 3;
  
  public static final int IMPORTANCE_HIGH = 4;
  
  public static final int IMPORTANCE_LOW = 2;
  
  public static final int IMPORTANCE_MAX = 5;
  
  public static final int IMPORTANCE_MIN = 1;
  
  public static final int IMPORTANCE_NONE = 0;
  
  public static final int IMPORTANCE_UNSPECIFIED = -1000;
  
  private static final Object a = new Object();
  
  private static String b;
  
  private static Set<String> c = new HashSet<String>();
  
  private static final Object f = new Object();
  
  private static SideChannelManager g;
  
  private final Context d;
  
  private final NotificationManager e;
  
  private NotificationManagerCompat(Context paramContext) {
    this.d = paramContext;
    this.e = (NotificationManager)this.d.getSystemService("notification");
  }
  
  private void a(Task paramTask) {
    synchronized (f) {
      if (g == null)
        g = new SideChannelManager(this.d.getApplicationContext()); 
      g.queueTask(paramTask);
      return;
    } 
  }
  
  private static boolean a(Notification paramNotification) {
    Bundle bundle = NotificationCompat.getExtras(paramNotification);
    return (bundle != null && bundle.getBoolean("android.support.useSideChannel"));
  }
  
  public static NotificationManagerCompat from(Context paramContext) {
    return new NotificationManagerCompat(paramContext);
  }
  
  public static Set<String> getEnabledListenerPackages(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   4: ldc 'enabled_notification_listeners'
    //   6: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_3
    //   10: getstatic androidx/core/app/NotificationManagerCompat.a : Ljava/lang/Object;
    //   13: astore_0
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_3
    //   17: ifnull -> 101
    //   20: aload_3
    //   21: getstatic androidx/core/app/NotificationManagerCompat.b : Ljava/lang/String;
    //   24: invokevirtual equals : (Ljava/lang/Object;)Z
    //   27: ifne -> 101
    //   30: aload_3
    //   31: ldc ':'
    //   33: iconst_m1
    //   34: invokevirtual split : (Ljava/lang/String;I)[Ljava/lang/String;
    //   37: astore #4
    //   39: new java/util/HashSet
    //   42: dup
    //   43: aload #4
    //   45: arraylength
    //   46: invokespecial <init> : (I)V
    //   49: astore #5
    //   51: aload #4
    //   53: arraylength
    //   54: istore_2
    //   55: iconst_0
    //   56: istore_1
    //   57: iload_1
    //   58: iload_2
    //   59: if_icmpge -> 92
    //   62: aload #4
    //   64: iload_1
    //   65: aaload
    //   66: invokestatic unflattenFromString : (Ljava/lang/String;)Landroid/content/ComponentName;
    //   69: astore #6
    //   71: aload #6
    //   73: ifnull -> 114
    //   76: aload #5
    //   78: aload #6
    //   80: invokevirtual getPackageName : ()Ljava/lang/String;
    //   83: invokeinterface add : (Ljava/lang/Object;)Z
    //   88: pop
    //   89: goto -> 114
    //   92: aload #5
    //   94: putstatic androidx/core/app/NotificationManagerCompat.c : Ljava/util/Set;
    //   97: aload_3
    //   98: putstatic androidx/core/app/NotificationManagerCompat.b : Ljava/lang/String;
    //   101: getstatic androidx/core/app/NotificationManagerCompat.c : Ljava/util/Set;
    //   104: astore_3
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_3
    //   108: areturn
    //   109: astore_3
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_3
    //   113: athrow
    //   114: iload_1
    //   115: iconst_1
    //   116: iadd
    //   117: istore_1
    //   118: goto -> 57
    // Exception table:
    //   from	to	target	type
    //   20	55	109	finally
    //   62	71	109	finally
    //   76	89	109	finally
    //   92	101	109	finally
    //   101	107	109	finally
    //   110	112	109	finally
  }
  
  public boolean areNotificationsEnabled() {
    if (Build.VERSION.SDK_INT >= 24)
      return this.e.areNotificationsEnabled(); 
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i >= 19) {
      AppOpsManager appOpsManager = (AppOpsManager)this.d.getSystemService("appops");
      ApplicationInfo applicationInfo = this.d.getApplicationInfo();
      String str = this.d.getApplicationContext().getPackageName();
      i = applicationInfo.uid;
      try {
        Class<?> clazz = Class.forName(AppOpsManager.class.getName());
        i = ((Integer)clazz.getMethod("checkOpNoThrow", new Class[] { int.class, int.class, String.class }).invoke(appOpsManager, new Object[] { Integer.valueOf(((Integer)clazz.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), str })).intValue();
        return (i == 0);
      } catch (ClassNotFoundException|NoSuchMethodException|NoSuchFieldException|java.lang.reflect.InvocationTargetException|IllegalAccessException|RuntimeException classNotFoundException) {
        return true;
      } 
    } 
    return bool;
  }
  
  public void cancel(int paramInt) {
    cancel(null, paramInt);
  }
  
  public void cancel(String paramString, int paramInt) {
    this.e.cancel(paramString, paramInt);
    if (Build.VERSION.SDK_INT <= 19)
      a(new CancelTask(this.d.getPackageName(), paramInt, paramString)); 
  }
  
  public void cancelAll() {
    this.e.cancelAll();
    if (Build.VERSION.SDK_INT <= 19)
      a(new CancelTask(this.d.getPackageName())); 
  }
  
  public void createNotificationChannel(NotificationChannel paramNotificationChannel) {
    if (Build.VERSION.SDK_INT >= 26)
      this.e.createNotificationChannel(paramNotificationChannel); 
  }
  
  public void createNotificationChannelGroup(NotificationChannelGroup paramNotificationChannelGroup) {
    if (Build.VERSION.SDK_INT >= 26)
      this.e.createNotificationChannelGroup(paramNotificationChannelGroup); 
  }
  
  public void createNotificationChannelGroups(List<NotificationChannelGroup> paramList) {
    if (Build.VERSION.SDK_INT >= 26)
      this.e.createNotificationChannelGroups(paramList); 
  }
  
  public void createNotificationChannels(List<NotificationChannel> paramList) {
    if (Build.VERSION.SDK_INT >= 26)
      this.e.createNotificationChannels(paramList); 
  }
  
  public void deleteNotificationChannel(String paramString) {
    if (Build.VERSION.SDK_INT >= 26)
      this.e.deleteNotificationChannel(paramString); 
  }
  
  public void deleteNotificationChannelGroup(String paramString) {
    if (Build.VERSION.SDK_INT >= 26)
      this.e.deleteNotificationChannelGroup(paramString); 
  }
  
  public int getImportance() {
    return (Build.VERSION.SDK_INT >= 24) ? this.e.getImportance() : -1000;
  }
  
  public NotificationChannel getNotificationChannel(String paramString) {
    return (Build.VERSION.SDK_INT >= 26) ? this.e.getNotificationChannel(paramString) : null;
  }
  
  public NotificationChannelGroup getNotificationChannelGroup(String paramString) {
    if (Build.VERSION.SDK_INT >= 28)
      return this.e.getNotificationChannelGroup(paramString); 
    if (Build.VERSION.SDK_INT >= 26)
      for (NotificationChannelGroup notificationChannelGroup : getNotificationChannelGroups()) {
        if (notificationChannelGroup.getId().equals(paramString))
          return notificationChannelGroup; 
      }  
    return null;
  }
  
  public List<NotificationChannelGroup> getNotificationChannelGroups() {
    return (Build.VERSION.SDK_INT >= 26) ? this.e.getNotificationChannelGroups() : Collections.emptyList();
  }
  
  public List<NotificationChannel> getNotificationChannels() {
    return (Build.VERSION.SDK_INT >= 26) ? this.e.getNotificationChannels() : Collections.emptyList();
  }
  
  public void notify(int paramInt, Notification paramNotification) {
    notify(null, paramInt, paramNotification);
  }
  
  public void notify(String paramString, int paramInt, Notification paramNotification) {
    if (a(paramNotification)) {
      a(new NotifyTask(this.d.getPackageName(), paramInt, paramString, paramNotification));
      this.e.cancel(paramString, paramInt);
      return;
    } 
    this.e.notify(paramString, paramInt, paramNotification);
  }
  
  static class CancelTask implements Task {
    final String a;
    
    final int b;
    
    final String c;
    
    final boolean d;
    
    CancelTask(String param1String) {
      this.a = param1String;
      this.b = 0;
      this.c = null;
      this.d = true;
    }
    
    CancelTask(String param1String1, int param1Int, String param1String2) {
      this.a = param1String1;
      this.b = param1Int;
      this.c = param1String2;
      this.d = false;
    }
    
    public void send(INotificationSideChannel param1INotificationSideChannel) throws RemoteException {
      if (this.d) {
        param1INotificationSideChannel.cancelAll(this.a);
        return;
      } 
      param1INotificationSideChannel.cancel(this.a, this.b, this.c);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("CancelTask[");
      stringBuilder.append("packageName:");
      stringBuilder.append(this.a);
      stringBuilder.append(", id:");
      stringBuilder.append(this.b);
      stringBuilder.append(", tag:");
      stringBuilder.append(this.c);
      stringBuilder.append(", all:");
      stringBuilder.append(this.d);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  static class NotifyTask implements Task {
    final String a;
    
    final int b;
    
    final String c;
    
    final Notification d;
    
    NotifyTask(String param1String1, int param1Int, String param1String2, Notification param1Notification) {
      this.a = param1String1;
      this.b = param1Int;
      this.c = param1String2;
      this.d = param1Notification;
    }
    
    public void send(INotificationSideChannel param1INotificationSideChannel) throws RemoteException {
      param1INotificationSideChannel.notify(this.a, this.b, this.c, this.d);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("NotifyTask[");
      stringBuilder.append("packageName:");
      stringBuilder.append(this.a);
      stringBuilder.append(", id:");
      stringBuilder.append(this.b);
      stringBuilder.append(", tag:");
      stringBuilder.append(this.c);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
  
  static class ServiceConnectedEvent {
    final ComponentName a;
    
    final IBinder b;
    
    ServiceConnectedEvent(ComponentName param1ComponentName, IBinder param1IBinder) {
      this.a = param1ComponentName;
      this.b = param1IBinder;
    }
  }
  
  static class SideChannelManager implements ServiceConnection, Handler.Callback {
    private final Context a;
    
    private final HandlerThread b;
    
    private final Handler c;
    
    private final Map<ComponentName, ListenerRecord> d = new HashMap<ComponentName, ListenerRecord>();
    
    private Set<String> e = new HashSet<String>();
    
    SideChannelManager(Context param1Context) {
      this.a = param1Context;
      this.b = new HandlerThread("NotificationManagerCompat");
      this.b.start();
      this.c = new Handler(this.b.getLooper(), this);
    }
    
    private void a() {
      Set<String> set = NotificationManagerCompat.getEnabledListenerPackages(this.a);
      if (set.equals(this.e))
        return; 
      this.e = set;
      List list = this.a.getPackageManager().queryIntentServices((new Intent()).setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
      HashSet<ComponentName> hashSet = new HashSet();
      for (ResolveInfo resolveInfo : list) {
        if (!set.contains(resolveInfo.serviceInfo.packageName))
          continue; 
        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        if (resolveInfo.serviceInfo.permission != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Permission present on component ");
          stringBuilder.append(componentName);
          stringBuilder.append(", not adding listener record.");
          Log.w("NotifManCompat", stringBuilder.toString());
          continue;
        } 
        hashSet.add(componentName);
      } 
      for (ComponentName componentName : hashSet) {
        if (!this.d.containsKey(componentName)) {
          if (Log.isLoggable("NotifManCompat", 3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Adding listener record for ");
            stringBuilder.append(componentName);
            Log.d("NotifManCompat", stringBuilder.toString());
          } 
          this.d.put(componentName, new ListenerRecord(componentName));
        } 
      } 
      Iterator<Map.Entry> iterator = this.d.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry entry = iterator.next();
        if (!hashSet.contains(entry.getKey())) {
          if (Log.isLoggable("NotifManCompat", 3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Removing listener record for ");
            stringBuilder.append(entry.getKey());
            Log.d("NotifManCompat", stringBuilder.toString());
          } 
          b((ListenerRecord)entry.getValue());
          iterator.remove();
        } 
      } 
    }
    
    private void a(ComponentName param1ComponentName) {
      ListenerRecord listenerRecord = this.d.get(param1ComponentName);
      if (listenerRecord != null)
        b(listenerRecord); 
    }
    
    private void a(ComponentName param1ComponentName, IBinder param1IBinder) {
      ListenerRecord listenerRecord = this.d.get(param1ComponentName);
      if (listenerRecord != null) {
        listenerRecord.c = INotificationSideChannel.Stub.asInterface(param1IBinder);
        listenerRecord.e = 0;
        d(listenerRecord);
      } 
    }
    
    private void a(NotificationManagerCompat.Task param1Task) {
      a();
      for (ListenerRecord listenerRecord : this.d.values()) {
        listenerRecord.d.add(param1Task);
        d(listenerRecord);
      } 
    }
    
    private boolean a(ListenerRecord param1ListenerRecord) {
      if (param1ListenerRecord.b)
        return true; 
      Intent intent = (new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL")).setComponent(param1ListenerRecord.a);
      param1ListenerRecord.b = this.a.bindService(intent, this, 33);
      if (param1ListenerRecord.b) {
        param1ListenerRecord.e = 0;
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to bind to listener ");
        stringBuilder.append(param1ListenerRecord.a);
        Log.w("NotifManCompat", stringBuilder.toString());
        this.a.unbindService(this);
      } 
      return param1ListenerRecord.b;
    }
    
    private void b(ComponentName param1ComponentName) {
      ListenerRecord listenerRecord = this.d.get(param1ComponentName);
      if (listenerRecord != null)
        d(listenerRecord); 
    }
    
    private void b(ListenerRecord param1ListenerRecord) {
      if (param1ListenerRecord.b) {
        this.a.unbindService(this);
        param1ListenerRecord.b = false;
      } 
      param1ListenerRecord.c = null;
    }
    
    private void c(ListenerRecord param1ListenerRecord) {
      if (this.c.hasMessages(3, param1ListenerRecord.a))
        return; 
      param1ListenerRecord.e++;
      if (param1ListenerRecord.e > 6) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Giving up on delivering ");
        stringBuilder.append(param1ListenerRecord.d.size());
        stringBuilder.append(" tasks to ");
        stringBuilder.append(param1ListenerRecord.a);
        stringBuilder.append(" after ");
        stringBuilder.append(param1ListenerRecord.e);
        stringBuilder.append(" retries");
        Log.w("NotifManCompat", stringBuilder.toString());
        param1ListenerRecord.d.clear();
        return;
      } 
      int i = (1 << param1ListenerRecord.e - 1) * 1000;
      if (Log.isLoggable("NotifManCompat", 3)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Scheduling retry for ");
        stringBuilder.append(i);
        stringBuilder.append(" ms");
        Log.d("NotifManCompat", stringBuilder.toString());
      } 
      Message message = this.c.obtainMessage(3, param1ListenerRecord.a);
      this.c.sendMessageDelayed(message, i);
    }
    
    private void d(ListenerRecord param1ListenerRecord) {
      if (Log.isLoggable("NotifManCompat", 3)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Processing component ");
        stringBuilder.append(param1ListenerRecord.a);
        stringBuilder.append(", ");
        stringBuilder.append(param1ListenerRecord.d.size());
        stringBuilder.append(" queued tasks");
        Log.d("NotifManCompat", stringBuilder.toString());
      } 
      if (param1ListenerRecord.d.isEmpty())
        return; 
      if (!a(param1ListenerRecord) || param1ListenerRecord.c == null) {
        c(param1ListenerRecord);
        return;
      } 
      while (true) {
        NotificationManagerCompat.Task task = param1ListenerRecord.d.peek();
        if (task != null)
          try {
            if (Log.isLoggable("NotifManCompat", 3)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Sending task ");
              stringBuilder.append(task);
              Log.d("NotifManCompat", stringBuilder.toString());
            } 
            task.send(param1ListenerRecord.c);
            param1ListenerRecord.d.remove();
            continue;
          } catch (DeadObjectException deadObjectException) {
            if (Log.isLoggable("NotifManCompat", 3)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Remote service has died: ");
              stringBuilder.append(param1ListenerRecord.a);
              Log.d("NotifManCompat", stringBuilder.toString());
            } 
          } catch (RemoteException remoteException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RemoteException communicating with ");
            stringBuilder.append(param1ListenerRecord.a);
            Log.w("NotifManCompat", stringBuilder.toString(), (Throwable)remoteException);
          }  
        if (!param1ListenerRecord.d.isEmpty())
          c(param1ListenerRecord); 
        return;
      } 
    }
    
    public boolean handleMessage(Message param1Message) {
      NotificationManagerCompat.ServiceConnectedEvent serviceConnectedEvent;
      int i = param1Message.what;
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3)
              return false; 
            b((ComponentName)param1Message.obj);
            return true;
          } 
          a((ComponentName)param1Message.obj);
          return true;
        } 
        serviceConnectedEvent = (NotificationManagerCompat.ServiceConnectedEvent)param1Message.obj;
        a(serviceConnectedEvent.a, serviceConnectedEvent.b);
        return true;
      } 
      a((NotificationManagerCompat.Task)((Message)serviceConnectedEvent).obj);
      return true;
    }
    
    public void onServiceConnected(ComponentName param1ComponentName, IBinder param1IBinder) {
      if (Log.isLoggable("NotifManCompat", 3)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Connected to service ");
        stringBuilder.append(param1ComponentName);
        Log.d("NotifManCompat", stringBuilder.toString());
      } 
      this.c.obtainMessage(1, new NotificationManagerCompat.ServiceConnectedEvent(param1ComponentName, param1IBinder)).sendToTarget();
    }
    
    public void onServiceDisconnected(ComponentName param1ComponentName) {
      if (Log.isLoggable("NotifManCompat", 3)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Disconnected from service ");
        stringBuilder.append(param1ComponentName);
        Log.d("NotifManCompat", stringBuilder.toString());
      } 
      this.c.obtainMessage(2, param1ComponentName).sendToTarget();
    }
    
    public void queueTask(NotificationManagerCompat.Task param1Task) {
      this.c.obtainMessage(0, param1Task).sendToTarget();
    }
    
    static class ListenerRecord {
      final ComponentName a;
      
      boolean b = false;
      
      INotificationSideChannel c;
      
      ArrayDeque<NotificationManagerCompat.Task> d = new ArrayDeque<NotificationManagerCompat.Task>();
      
      int e = 0;
      
      ListenerRecord(ComponentName param2ComponentName) {
        this.a = param2ComponentName;
      }
    }
  }
  
  static class ListenerRecord {
    final ComponentName a;
    
    boolean b = false;
    
    INotificationSideChannel c;
    
    ArrayDeque<NotificationManagerCompat.Task> d = new ArrayDeque<NotificationManagerCompat.Task>();
    
    int e = 0;
    
    ListenerRecord(ComponentName param1ComponentName) {
      this.a = param1ComponentName;
    }
  }
  
  static interface Task {
    void send(INotificationSideChannel param1INotificationSideChannel) throws RemoteException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\NotificationManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */