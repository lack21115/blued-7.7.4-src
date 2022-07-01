package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.base.R;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zabk;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.api.internal.zabo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zab;
import com.google.android.gms.common.internal.zad;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class GoogleApiAvailability extends GoogleApiAvailabilityLight {
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
  
  private static final Object zaa = new Object();
  
  private static final GoogleApiAvailability zab = new GoogleApiAvailability();
  
  private String zac;
  
  static {
    GOOGLE_PLAY_SERVICES_VERSION_CODE = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  }
  
  public static GoogleApiAvailability getInstance() {
    return zab;
  }
  
  public static Dialog zaa(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener) {
    ProgressBar progressBar = new ProgressBar((Context)paramActivity, null, 16842874);
    progressBar.setIndeterminate(true);
    progressBar.setVisibility(0);
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)paramActivity);
    builder.setView((View)progressBar);
    builder.setMessage(zab.zac((Context)paramActivity, 18));
    builder.setPositiveButton("", null);
    AlertDialog alertDialog = builder.create();
    zaa(paramActivity, (Dialog)alertDialog, "GooglePlayServicesUpdatingDialog", paramOnCancelListener);
    return (Dialog)alertDialog;
  }
  
  static Dialog zaa(Context paramContext, int paramInt, zad paramzad, DialogInterface.OnCancelListener paramOnCancelListener) {
    AlertDialog.Builder builder1 = null;
    if (paramInt == 0)
      return null; 
    TypedValue typedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(16843529, typedValue, true);
    if ("Theme.Dialog.Alert".equals(paramContext.getResources().getResourceEntryName(typedValue.resourceId)))
      builder1 = new AlertDialog.Builder(paramContext, 5); 
    AlertDialog.Builder builder2 = builder1;
    if (builder1 == null)
      builder2 = new AlertDialog.Builder(paramContext); 
    builder2.setMessage(zab.zac(paramContext, paramInt));
    if (paramOnCancelListener != null)
      builder2.setOnCancelListener(paramOnCancelListener); 
    String str2 = zab.zae(paramContext, paramInt);
    if (str2 != null)
      builder2.setPositiveButton(str2, (DialogInterface.OnClickListener)paramzad); 
    String str1 = zab.zaa(paramContext, paramInt);
    if (str1 != null)
      builder2.setTitle(str1); 
    return (Dialog)builder2.create();
  }
  
  private static Task<Map<ApiKey<?>, String>> zaa(HasApiKey<?> paramHasApiKey, HasApiKey<?>... paramVarArgs) {
    Preconditions.checkNotNull(paramHasApiKey, "Requested API must not be null.");
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++)
      Preconditions.checkNotNull(paramVarArgs[i], "Requested API must not be null."); 
    ArrayList<HasApiKey<?>> arrayList = new ArrayList(paramVarArgs.length + 1);
    arrayList.add(paramHasApiKey);
    arrayList.addAll(Arrays.asList(paramVarArgs));
    return GoogleApiManager.zaa().zaa(arrayList);
  }
  
  private final String zaa() {
    synchronized (zaa) {
      return this.zac;
    } 
  }
  
  static void zaa(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener) {
    FragmentManager fragmentManager1;
    if (paramActivity instanceof FragmentActivity) {
      fragmentManager1 = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(fragmentManager1, paramString);
      return;
    } 
    FragmentManager fragmentManager = fragmentManager1.getFragmentManager();
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(fragmentManager, paramString);
  }
  
  private final void zaa(Context paramContext, int paramInt, String paramString, PendingIntent paramPendingIntent) {
    Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[] { Integer.valueOf(paramInt), null }), new IllegalArgumentException());
    if (paramInt == 18) {
      zaa(paramContext);
      return;
    } 
    if (paramPendingIntent == null) {
      if (paramInt == 6)
        Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead."); 
      return;
    } 
    String str = zab.zab(paramContext, paramInt);
    paramString = zab.zad(paramContext, paramInt);
    Resources resources = paramContext.getResources();
    NotificationManager notificationManager = (NotificationManager)paramContext.getSystemService("notification");
    NotificationCompat.Builder builder = (new NotificationCompat.Builder(paramContext)).setLocalOnly(true).setAutoCancel(true).setContentTitle(str).setStyle((NotificationCompat.Style)(new NotificationCompat.BigTextStyle()).bigText(paramString));
    if (DeviceProperties.isWearable(paramContext)) {
      Preconditions.checkState(PlatformVersion.isAtLeastKitKatWatch());
      builder.setSmallIcon((paramContext.getApplicationInfo()).icon).setPriority(2);
      if (DeviceProperties.isWearableWithoutPlayStore(paramContext)) {
        builder.addAction(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), paramPendingIntent);
      } else {
        builder.setContentIntent(paramPendingIntent);
      } 
    } else {
      builder.setSmallIcon(17301642).setTicker(resources.getString(R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setContentIntent(paramPendingIntent).setContentText(paramString);
    } 
    if (PlatformVersion.isAtLeastO()) {
      Preconditions.checkState(PlatformVersion.isAtLeastO());
      String str1 = zaa();
      paramString = str1;
      if (str1 == null) {
        str1 = "com.google.android.gms.availability";
        NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
        String str2 = zab.zaa(paramContext);
        if (notificationChannel == null) {
          notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", str2, 4));
          paramString = str1;
        } else {
          paramString = str1;
          if (!str2.contentEquals(notificationChannel.getName())) {
            notificationChannel.setName(str2);
            notificationManager.createNotificationChannel(notificationChannel);
            paramString = str1;
          } 
        } 
      } 
      builder.setChannelId(paramString);
    } 
    Notification notification = builder.build();
    if (paramInt != 1 && paramInt != 2 && paramInt != 3) {
      paramInt = 39789;
    } else {
      paramInt = 10436;
      GooglePlayServicesUtilLight.sCanceledAvailabilityNotification.set(false);
    } 
    notificationManager.notify(paramInt, notification);
  }
  
  public Task<Void> checkApiAvailability(GoogleApi<?> paramGoogleApi, GoogleApi<?>... paramVarArgs) {
    return zaa((HasApiKey<?>)paramGoogleApi, (HasApiKey<?>[])paramVarArgs).onSuccessTask(zaa.zaa);
  }
  
  public Task<Void> checkApiAvailability(HasApiKey<?> paramHasApiKey, HasApiKey<?>... paramVarArgs) {
    return zaa(paramHasApiKey, paramVarArgs).onSuccessTask(zab.zaa);
  }
  
  public int getClientVersion(Context paramContext) {
    return super.getClientVersion(paramContext);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2) {
    return getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    return zaa((Context)paramActivity, paramInt1, zad.zaa(paramActivity, getErrorResolutionIntent((Context)paramActivity, paramInt1, "d"), paramInt2), paramOnCancelListener);
  }
  
  public Intent getErrorResolutionIntent(Context paramContext, int paramInt, String paramString) {
    return super.getErrorResolutionIntent(paramContext, paramInt, paramString);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2) {
    return super.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  public PendingIntent getErrorResolutionPendingIntent(Context paramContext, ConnectionResult paramConnectionResult) {
    return paramConnectionResult.hasResolution() ? paramConnectionResult.getResolution() : getErrorResolutionPendingIntent(paramContext, paramConnectionResult.getErrorCode(), 0);
  }
  
  public final String getErrorString(int paramInt) {
    return super.getErrorString(paramInt);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext) {
    return super.isGooglePlayServicesAvailable(paramContext);
  }
  
  public int isGooglePlayServicesAvailable(Context paramContext, int paramInt) {
    return super.isGooglePlayServicesAvailable(paramContext, paramInt);
  }
  
  public final boolean isUserResolvableError(int paramInt) {
    return super.isUserResolvableError(paramInt);
  }
  
  public Task<Void> makeGooglePlayServicesAvailable(Activity paramActivity) {
    int i = GOOGLE_PLAY_SERVICES_VERSION_CODE;
    Preconditions.checkMainThread("makeGooglePlayServicesAvailable must be called from the main thread");
    i = isGooglePlayServicesAvailable((Context)paramActivity, i);
    if (i == 0)
      return Tasks.forResult(null); 
    zabo zabo = zabo.zaa(paramActivity);
    zabo.zab(new ConnectionResult(i, null), 0);
    return zabo.zac();
  }
  
  public void setDefaultNotificationChannelId(Context paramContext, String paramString) {
    if (PlatformVersion.isAtLeastO())
      Preconditions.checkNotNull(((NotificationManager)paramContext.getSystemService("notification")).getNotificationChannel(paramString)); 
    synchronized (zaa) {
      this.zac = paramString;
      return;
    } 
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2) {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    Dialog dialog = getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    if (dialog == null)
      return false; 
    zaa(paramActivity, dialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public void showErrorNotification(Context paramContext, int paramInt) {
    zaa(paramContext, paramInt, (String)null, getErrorResolutionPendingIntent(paramContext, paramInt, 0, "n"));
  }
  
  public void showErrorNotification(Context paramContext, ConnectionResult paramConnectionResult) {
    PendingIntent pendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    zaa(paramContext, paramConnectionResult.getErrorCode(), (String)null, pendingIntent);
  }
  
  public final zabl zaa(Context paramContext, zabk paramzabk) {
    IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    intentFilter.addDataScheme("package");
    zabl zabl = new zabl(paramzabk);
    paramContext.registerReceiver((BroadcastReceiver)zabl, intentFilter);
    zabl.zaa(paramContext);
    if (!isUninstalledAppPossiblyUpdating(paramContext, "com.google.android.gms")) {
      paramzabk.zaa();
      zabl.zaa();
      return null;
    } 
    return zabl;
  }
  
  final void zaa(Context paramContext) {
    (new zaa(this, paramContext)).sendEmptyMessageDelayed(1, 120000L);
  }
  
  public final boolean zaa(Activity paramActivity, LifecycleFragment paramLifecycleFragment, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    Dialog dialog = zaa((Context)paramActivity, paramInt1, zad.zaa(paramLifecycleFragment, getErrorResolutionIntent((Context)paramActivity, paramInt1, "d"), 2), paramOnCancelListener);
    if (dialog == null)
      return false; 
    zaa(paramActivity, dialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public final boolean zaa(Context paramContext, ConnectionResult paramConnectionResult, int paramInt) {
    PendingIntent pendingIntent = getErrorResolutionPendingIntent(paramContext, paramConnectionResult);
    if (pendingIntent != null) {
      zaa(paramContext, paramConnectionResult.getErrorCode(), (String)null, GoogleApiActivity.zaa(paramContext, pendingIntent, paramInt));
      return true;
    } 
    return false;
  }
  
  final class zaa extends zap {
    private final Context zaa;
    
    public zaa(GoogleApiAvailability this$0, Context param1Context) {
      super(looper);
      Looper looper;
      this.zaa = param1Context.getApplicationContext();
    }
    
    public final void handleMessage(Message param1Message) {
      if (param1Message.what != 1) {
        int j = param1Message.what;
        StringBuilder stringBuilder = new StringBuilder(50);
        stringBuilder.append("Don't know how to handle this message: ");
        stringBuilder.append(j);
        Log.w("GoogleApiAvailability", stringBuilder.toString());
        return;
      } 
      int i = this.zab.isGooglePlayServicesAvailable(this.zaa);
      if (this.zab.isUserResolvableError(i))
        this.zab.showErrorNotification(this.zaa, i); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\GoogleApiAvailability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */