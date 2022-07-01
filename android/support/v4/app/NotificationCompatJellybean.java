package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class NotificationCompatJellybean {
  private static Field sExtrasField;
  
  private static boolean sExtrasFieldAccessFailed;
  
  private static final Object sExtrasLock = new Object();
  
  static {
    new Object();
    throw new VerifyError("bad dex opcode");
  }
  
  public static SparseArray buildActionExtrasMap(List<Bundle> paramList) {
    int j = paramList.size();
    SparseArray sparseArray = null;
    int i = 0;
    while (i < j) {
      Bundle bundle = paramList.get(i);
      SparseArray sparseArray1 = sparseArray;
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
  
  public static Bundle getExtras(Notification paramNotification) {
    synchronized (sExtrasLock) {
      if (sExtrasFieldAccessFailed)
        return null; 
      try {
        if (sExtrasField == null) {
          Field field = Notification.class.getDeclaredField("extras");
          if (!Bundle.class.isAssignableFrom(field.getType())) {
            Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
            sExtrasFieldAccessFailed = true;
            return null;
          } 
          field.setAccessible(true);
          sExtrasField = field;
        } 
        Bundle bundle2 = (Bundle)sExtrasField.get(paramNotification);
        Bundle bundle1 = bundle2;
        if (bundle2 == null) {
          bundle1 = new Bundle();
          sExtrasField.set(paramNotification, bundle1);
        } 
        return bundle1;
      } catch (IllegalAccessException illegalAccessException) {
        Log.e("NotificationCompat", "Unable to access notification extras", illegalAccessException);
      } catch (NoSuchFieldException noSuchFieldException) {
        Log.e("NotificationCompat", "Unable to access notification extras", noSuchFieldException);
      } 
      sExtrasFieldAccessFailed = true;
      return null;
    } 
  }
  
  private static Bundle[] toBundleArray(RemoteInput[] paramArrayOfRemoteInput) {
    if (paramArrayOfRemoteInput == null)
      return null; 
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfRemoteInput.length];
    for (int i = 0; i < paramArrayOfRemoteInput.length; i++) {
      RemoteInput remoteInput = paramArrayOfRemoteInput[i];
      Bundle bundle = new Bundle();
      bundle.putString("resultKey", remoteInput.mResultKey);
      bundle.putCharSequence("label", remoteInput.mLabel);
      bundle.putCharSequenceArray("choices", remoteInput.mChoices);
      bundle.putBoolean("allowFreeFormInput", remoteInput.mAllowFreeFormTextInput);
      bundle.putBundle("extras", remoteInput.mExtras);
      Set set = remoteInput.mAllowedDataTypes;
      if (set != null && !set.isEmpty()) {
        ArrayList<String> arrayList = new ArrayList(set.size());
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext())
          arrayList.add(iterator.next()); 
        bundle.putStringArrayList("allowedDataTypes", arrayList);
      } 
      arrayOfBundle[i] = bundle;
    } 
    return arrayOfBundle;
  }
  
  public static Bundle writeActionAndGetExtras(Notification.Builder paramBuilder, NotificationCompat$Action paramNotificationCompat$Action) {
    paramBuilder.addAction(paramNotificationCompat$Action.icon, paramNotificationCompat$Action.title, paramNotificationCompat$Action.actionIntent);
    Bundle bundle = new Bundle(paramNotificationCompat$Action.mExtras);
    if (paramNotificationCompat$Action.mRemoteInputs != null)
      bundle.putParcelableArray("android.support.remoteInputs", (Parcelable[])toBundleArray(paramNotificationCompat$Action.mRemoteInputs)); 
    if (paramNotificationCompat$Action.mDataOnlyRemoteInputs != null)
      bundle.putParcelableArray("android.support.dataRemoteInputs", (Parcelable[])toBundleArray(paramNotificationCompat$Action.mDataOnlyRemoteInputs)); 
    bundle.putBoolean("android.support.allowGeneratedReplies", paramNotificationCompat$Action.mAllowGeneratedReplies);
    return bundle;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\NotificationCompatJellybean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */