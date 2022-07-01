package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class NotificationCompatJellybean {
  public static final String TAG = "NotificationCompat";
  
  private static final Object a = new Object();
  
  private static Field b;
  
  private static boolean c;
  
  private static final Object d = new Object();
  
  private static Field e;
  
  private static Field f;
  
  private static Field g;
  
  private static Field h;
  
  private static boolean i;
  
  static Bundle a(NotificationCompat.Action paramAction) {
    Bundle bundle1;
    Bundle bundle2 = new Bundle();
    bundle2.putInt("icon", paramAction.getIcon());
    bundle2.putCharSequence("title", paramAction.getTitle());
    bundle2.putParcelable("actionIntent", (Parcelable)paramAction.getActionIntent());
    if (paramAction.getExtras() != null) {
      bundle1 = new Bundle(paramAction.getExtras());
    } else {
      bundle1 = new Bundle();
    } 
    bundle1.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
    bundle2.putBundle("extras", bundle1);
    bundle2.putParcelableArray("remoteInputs", (Parcelable[])a(paramAction.getRemoteInputs()));
    bundle2.putBoolean("showsUserInterface", paramAction.getShowsUserInterface());
    bundle2.putInt("semanticAction", paramAction.getSemanticAction());
    return bundle2;
  }
  
  private static Bundle a(RemoteInput paramRemoteInput) {
    Bundle bundle = new Bundle();
    bundle.putString("resultKey", paramRemoteInput.getResultKey());
    bundle.putCharSequence("label", paramRemoteInput.getLabel());
    bundle.putCharSequenceArray("choices", paramRemoteInput.getChoices());
    bundle.putBoolean("allowFreeFormInput", paramRemoteInput.getAllowFreeFormInput());
    bundle.putBundle("extras", paramRemoteInput.getExtras());
    Set<String> set = paramRemoteInput.getAllowedDataTypes();
    if (set != null && !set.isEmpty()) {
      ArrayList<String> arrayList = new ArrayList(set.size());
      Iterator<String> iterator = set.iterator();
      while (iterator.hasNext())
        arrayList.add(iterator.next()); 
      bundle.putStringArrayList("allowedDataTypes", arrayList);
    } 
    return bundle;
  }
  
  static NotificationCompat.Action a(Bundle paramBundle) {
    boolean bool;
    Bundle bundle = paramBundle.getBundle("extras");
    if (bundle != null) {
      bool = bundle.getBoolean("android.support.allowGeneratedReplies", false);
    } else {
      bool = false;
    } 
    return new NotificationCompat.Action(paramBundle.getInt("icon"), paramBundle.getCharSequence("title"), (PendingIntent)paramBundle.getParcelable("actionIntent"), paramBundle.getBundle("extras"), a(a(paramBundle, "remoteInputs")), a(a(paramBundle, "dataOnlyRemoteInputs")), bool, paramBundle.getInt("semanticAction"), paramBundle.getBoolean("showsUserInterface"), false);
  }
  
  private static boolean a() {
    if (i)
      return false; 
    try {
      if (e == null) {
        Class<?> clazz = Class.forName("android.app.Notification$Action");
        f = clazz.getDeclaredField("icon");
        g = clazz.getDeclaredField("title");
        h = clazz.getDeclaredField("actionIntent");
        e = Notification.class.getDeclaredField("actions");
        e.setAccessible(true);
      } 
    } catch (ClassNotFoundException classNotFoundException) {
      Log.e("NotificationCompat", "Unable to access notification actions", classNotFoundException);
      i = true;
    } catch (NoSuchFieldException noSuchFieldException) {
      Log.e("NotificationCompat", "Unable to access notification actions", noSuchFieldException);
      i = true;
    } 
    return i ^ true;
  }
  
  private static Bundle[] a(Bundle paramBundle, String paramString) {
    Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray(paramString);
    if (arrayOfParcelable instanceof Bundle[] || arrayOfParcelable == null)
      return (Bundle[])arrayOfParcelable; 
    Bundle[] arrayOfBundle = Arrays.<Bundle, Parcelable>copyOf(arrayOfParcelable, arrayOfParcelable.length, Bundle[].class);
    paramBundle.putParcelableArray(paramString, (Parcelable[])arrayOfBundle);
    return arrayOfBundle;
  }
  
  private static Bundle[] a(RemoteInput[] paramArrayOfRemoteInput) {
    if (paramArrayOfRemoteInput == null)
      return null; 
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfRemoteInput.length];
    for (int i = 0; i < paramArrayOfRemoteInput.length; i++)
      arrayOfBundle[i] = a(paramArrayOfRemoteInput[i]); 
    return arrayOfBundle;
  }
  
  private static RemoteInput[] a(Bundle[] paramArrayOfBundle) {
    if (paramArrayOfBundle == null)
      return null; 
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfBundle.length];
    for (int i = 0; i < paramArrayOfBundle.length; i++)
      arrayOfRemoteInput[i] = b(paramArrayOfBundle[i]); 
    return arrayOfRemoteInput;
  }
  
  private static Object[] a(Notification paramNotification) {
    synchronized (d) {
      if (!a())
        return null; 
      try {
        return (Object[])e.get(paramNotification);
      } catch (IllegalAccessException illegalAccessException) {
        Log.e("NotificationCompat", "Unable to access notification actions", illegalAccessException);
        i = true;
        return null;
      } 
    } 
  }
  
  private static RemoteInput b(Bundle paramBundle) {
    ArrayList arrayList = paramBundle.getStringArrayList("allowedDataTypes");
    HashSet<String> hashSet = new HashSet();
    if (arrayList != null) {
      Iterator<String> iterator = arrayList.iterator();
      while (iterator.hasNext())
        hashSet.add(iterator.next()); 
    } 
    return new RemoteInput(paramBundle.getString("resultKey"), paramBundle.getCharSequence("label"), paramBundle.getCharSequenceArray("choices"), paramBundle.getBoolean("allowFreeFormInput"), 0, paramBundle.getBundle("extras"), hashSet);
  }
  
  public static SparseArray<Bundle> buildActionExtrasMap(List<Bundle> paramList) {
    int j = paramList.size();
    SparseArray<Bundle> sparseArray = null;
    int i = 0;
    while (i < j) {
      Bundle bundle = paramList.get(i);
      SparseArray<Bundle> sparseArray1 = sparseArray;
      if (bundle != null) {
        sparseArray1 = sparseArray;
        if (sparseArray == null)
          sparseArray1 = new SparseArray(); 
        sparseArray1.put(i, bundle);
      } 
      i++;
      sparseArray = sparseArray1;
    } 
    return sparseArray;
  }
  
  public static NotificationCompat.Action getAction(Notification paramNotification, int paramInt) {
    // Byte code:
    //   0: getstatic androidx/core/app/NotificationCompatJellybean.d : Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: aload_0
    //   7: invokestatic a : (Landroid/app/Notification;)[Ljava/lang/Object;
    //   10: astore_3
    //   11: aload_3
    //   12: ifnull -> 103
    //   15: aload_3
    //   16: iload_1
    //   17: aaload
    //   18: astore_3
    //   19: aload_0
    //   20: invokestatic getExtras : (Landroid/app/Notification;)Landroid/os/Bundle;
    //   23: astore_0
    //   24: aload_0
    //   25: ifnull -> 111
    //   28: aload_0
    //   29: ldc_w 'android.support.actionExtras'
    //   32: invokevirtual getSparseParcelableArray : (Ljava/lang/String;)Landroid/util/SparseArray;
    //   35: astore_0
    //   36: aload_0
    //   37: ifnull -> 111
    //   40: aload_0
    //   41: iload_1
    //   42: invokevirtual get : (I)Ljava/lang/Object;
    //   45: checkcast android/os/Bundle
    //   48: astore_0
    //   49: goto -> 52
    //   52: getstatic androidx/core/app/NotificationCompatJellybean.f : Ljava/lang/reflect/Field;
    //   55: aload_3
    //   56: invokevirtual getInt : (Ljava/lang/Object;)I
    //   59: getstatic androidx/core/app/NotificationCompatJellybean.g : Ljava/lang/reflect/Field;
    //   62: aload_3
    //   63: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   66: checkcast java/lang/CharSequence
    //   69: getstatic androidx/core/app/NotificationCompatJellybean.h : Ljava/lang/reflect/Field;
    //   72: aload_3
    //   73: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   76: checkcast android/app/PendingIntent
    //   79: aload_0
    //   80: invokestatic readAction : (ILjava/lang/CharSequence;Landroid/app/PendingIntent;Landroid/os/Bundle;)Landroidx/core/app/NotificationCompat$Action;
    //   83: astore_0
    //   84: aload_2
    //   85: monitorexit
    //   86: aload_0
    //   87: areturn
    //   88: astore_0
    //   89: ldc 'NotificationCompat'
    //   91: ldc_w 'Unable to access notification actions'
    //   94: aload_0
    //   95: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   98: pop
    //   99: iconst_1
    //   100: putstatic androidx/core/app/NotificationCompatJellybean.i : Z
    //   103: aload_2
    //   104: monitorexit
    //   105: aconst_null
    //   106: areturn
    //   107: aload_2
    //   108: monitorexit
    //   109: aload_0
    //   110: athrow
    //   111: aconst_null
    //   112: astore_0
    //   113: goto -> 52
    //   116: astore_0
    //   117: goto -> 107
    // Exception table:
    //   from	to	target	type
    //   6	11	88	java/lang/IllegalAccessException
    //   6	11	116	finally
    //   19	24	88	java/lang/IllegalAccessException
    //   19	24	116	finally
    //   28	36	88	java/lang/IllegalAccessException
    //   28	36	116	finally
    //   40	49	88	java/lang/IllegalAccessException
    //   40	49	116	finally
    //   52	84	88	java/lang/IllegalAccessException
    //   52	84	116	finally
    //   84	86	116	finally
    //   89	103	116	finally
    //   103	105	116	finally
    //   107	109	116	finally
  }
  
  public static int getActionCount(Notification paramNotification) {
    synchronized (d) {
      Object[] arrayOfObject = a(paramNotification);
      if (arrayOfObject != null)
        return arrayOfObject.length; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public static Bundle getExtras(Notification paramNotification) {
    synchronized (a) {
      if (c)
        return null; 
      try {
        if (b == null) {
          Field field = Notification.class.getDeclaredField("extras");
          if (!Bundle.class.isAssignableFrom(field.getType())) {
            Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
            c = true;
            return null;
          } 
          field.setAccessible(true);
          b = field;
        } 
        Bundle bundle2 = (Bundle)b.get(paramNotification);
        Bundle bundle1 = bundle2;
        if (bundle2 == null) {
          bundle1 = new Bundle();
          b.set(paramNotification, bundle1);
        } 
        return bundle1;
      } catch (IllegalAccessException illegalAccessException) {
        Log.e("NotificationCompat", "Unable to access notification extras", illegalAccessException);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("NotificationCompat", "Unable to access notification extras", noSuchFieldException);
      } 
      c = true;
      return null;
    } 
  }
  
  public static NotificationCompat.Action readAction(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle) {
    boolean bool;
    RemoteInput[] arrayOfRemoteInput1;
    RemoteInput[] arrayOfRemoteInput2;
    if (paramBundle != null) {
      arrayOfRemoteInput1 = a(a(paramBundle, "android.support.remoteInputs"));
      arrayOfRemoteInput2 = a(a(paramBundle, "android.support.dataRemoteInputs"));
      bool = paramBundle.getBoolean("android.support.allowGeneratedReplies");
    } else {
      arrayOfRemoteInput1 = null;
      arrayOfRemoteInput2 = arrayOfRemoteInput1;
      bool = false;
    } 
    return new NotificationCompat.Action(paramInt, paramCharSequence, paramPendingIntent, paramBundle, arrayOfRemoteInput1, arrayOfRemoteInput2, bool, 0, true, false);
  }
  
  public static Bundle writeActionAndGetExtras(Notification.Builder paramBuilder, NotificationCompat.Action paramAction) {
    paramBuilder.addAction(paramAction.getIcon(), paramAction.getTitle(), paramAction.getActionIntent());
    Bundle bundle = new Bundle(paramAction.getExtras());
    if (paramAction.getRemoteInputs() != null)
      bundle.putParcelableArray("android.support.remoteInputs", (Parcelable[])a(paramAction.getRemoteInputs())); 
    if (paramAction.getDataOnlyRemoteInputs() != null)
      bundle.putParcelableArray("android.support.dataRemoteInputs", (Parcelable[])a(paramAction.getDataOnlyRemoteInputs())); 
    bundle.putBoolean("android.support.allowGeneratedReplies", paramAction.getAllowGeneratedReplies());
    return bundle;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\NotificationCompatJellybean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */