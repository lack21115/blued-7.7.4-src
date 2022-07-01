package com.google.android.gms.common;

import android.annotation.TargetApi;
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
import android.content.IntentFilter;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompatBuilder;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.gms.R;
import com.google.android.gms.common.api.internal.zzbx;
import com.google.android.gms.common.api.internal.zzby;
import com.google.android.gms.common.api.internal.zzcf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.util.zzj;
import com.google.android.gms.common.util.zzs;

public final class GoogleApiAvailability extends zzf {
  private static final Object mLock = new Object();
  
  private static final GoogleApiAvailability zzfqw = new GoogleApiAvailability();
  
  private String zzfqx;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static GoogleApiAvailability getInstance() {
    return zzfqw;
  }
  
  public static Dialog zza(Activity paramActivity, DialogInterface.OnCancelListener paramOnCancelListener) {
    ProgressBar progressBar = new ProgressBar((Context)paramActivity, null, 16842874);
    progressBar.setIndeterminate(true);
    progressBar.setVisibility(0);
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)paramActivity);
    builder.setView((View)progressBar);
    builder.setMessage(zzu.zzh((Context)paramActivity, 18));
    builder.setPositiveButton("", null);
    AlertDialog alertDialog = builder.create();
    zza(paramActivity, (Dialog)alertDialog, "GooglePlayServicesUpdatingDialog", paramOnCancelListener);
    return (Dialog)alertDialog;
  }
  
  public static Dialog zza(Context paramContext, int paramInt, zzv paramzzv, DialogInterface.OnCancelListener paramOnCancelListener) {
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
    builder2.setMessage(zzu.zzh(paramContext, paramInt));
    if (paramOnCancelListener != null)
      builder2.setOnCancelListener(paramOnCancelListener); 
    String str2 = zzu.zzj(paramContext, paramInt);
    if (str2 != null)
      builder2.setPositiveButton(str2, (DialogInterface.OnClickListener)paramzzv); 
    String str1 = zzu.zzf(paramContext, paramInt);
    if (str1 != null)
      builder2.setTitle(str1); 
    return (Dialog)builder2.create();
  }
  
  public static zzbx zza(Context paramContext, zzby paramzzby) {
    IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    intentFilter.addDataScheme("package");
    zzbx zzbx = new zzbx(paramzzby);
    paramContext.registerReceiver((BroadcastReceiver)zzbx, intentFilter);
    zzbx.mContext = paramContext;
    if (!zzs.zzr(paramContext, "com.google.android.gms")) {
      paramzzby.zzaio();
      zzbx.unregister();
      return null;
    } 
    return zzbx;
  }
  
  @TargetApi(26)
  private final String zza(Context paramContext, NotificationManager paramNotificationManager) {
    zzbq.checkState(zzs.isAtLeastO());
    String str2 = zzahe();
    String str1 = str2;
    if (str2 == null) {
      NotificationChannel notificationChannel1;
      str1 = "com.google.android.gms.availability";
      NotificationChannel notificationChannel2 = paramNotificationManager.getNotificationChannel("com.google.android.gms.availability");
      String str = zzu.zzco(paramContext);
      if (notificationChannel2 == null) {
        notificationChannel1 = new NotificationChannel("com.google.android.gms.availability", str, 4);
        paramNotificationManager.createNotificationChannel(notificationChannel1);
        return "com.google.android.gms.availability";
      } 
      if (!notificationChannel1.equals(notificationChannel2.getName())) {
        notificationChannel2.setName((CharSequence)notificationChannel1);
        notificationChannel1 = notificationChannel2;
        paramNotificationManager.createNotificationChannel(notificationChannel1);
        return "com.google.android.gms.availability";
      } 
    } 
    return str1;
  }
  
  public static void zza(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener) {
    FragmentManager fragmentManager1;
    if (paramActivity instanceof FragmentActivity) {
      fragmentManager1 = ((FragmentActivity)paramActivity).getSupportFragmentManager();
      SupportErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(fragmentManager1, paramString);
      return;
    } 
    FragmentManager fragmentManager = fragmentManager1.getFragmentManager();
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(fragmentManager, paramString);
  }
  
  public static boolean zza$454b2131(Activity paramActivity, zzcf paramzzcf, int paramInt, DialogInterface.OnCancelListener paramOnCancelListener) {
    Dialog dialog = zza((Context)paramActivity, paramInt, zzv.zza$5e0d627(paramzzcf, zzf.zza((Context)paramActivity, paramInt, "d")), paramOnCancelListener);
    if (dialog == null)
      return false; 
    zza(paramActivity, dialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  private final String zzahe() {
    synchronized (mLock) {
      return this.zzfqx;
    } 
  }
  
  public final PendingIntent getErrorResolutionPendingIntent(Context paramContext, int paramInt1, int paramInt2) {
    return super.getErrorResolutionPendingIntent(paramContext, paramInt1, paramInt2);
  }
  
  public final String getErrorString(int paramInt) {
    return super.getErrorString(paramInt);
  }
  
  public final int isGooglePlayServicesAvailable(Context paramContext) {
    return super.isGooglePlayServicesAvailable(paramContext);
  }
  
  public final boolean isUserResolvableError(int paramInt) {
    return super.isUserResolvableError(paramInt);
  }
  
  @TargetApi(20)
  public final void zza$53da80fe(Context paramContext, int paramInt, PendingIntent paramPendingIntent) {
    Notification notification;
    Notification.Builder builder;
    if (paramInt == 18) {
      (new GoogleApiAvailability$zza(this, paramContext)).sendEmptyMessageDelayed(1, 120000L);
      throw new VerifyError("bad dex opcode");
    } 
    if (paramPendingIntent == null) {
      if (paramInt == 6)
        Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead."); 
      throw new VerifyError("bad dex opcode");
    } 
    String str2 = zzu.zzg(paramContext, paramInt);
    String str1 = zzu.zzi(paramContext, paramInt);
    Resources resources = paramContext.getResources();
    NotificationManager notificationManager = (NotificationManager)paramContext.getSystemService("notification");
    if (zzj.zzcv(paramContext)) {
      zzbq.checkState(zzs.zzanw());
      builder = (new Notification.Builder(paramContext)).setSmallIcon((paramContext.getApplicationInfo()).icon).setPriority(2).setAutoCancel(true).setContentTitle(str2).setStyle((Notification.Style)(new Notification.BigTextStyle()).bigText(str1)).addAction(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), paramPendingIntent);
      if (zzs.isAtLeastO() && zzs.isAtLeastO())
        builder.setChannelId(zza(paramContext, notificationManager)); 
      notification = builder.build();
    } else {
      NotificationCompat.Builder builder3 = new NotificationCompat.Builder((Context)notification);
      builder3.mNotification.icon = 17301642;
      NotificationCompat.Builder builder2 = builder3.setTicker(resources.getString(R.string.common_google_play_services_notification_ticker));
      long l = System.currentTimeMillis();
      builder2.mNotification.when = l;
      Notification notification1 = builder2.mNotification;
      notification1.flags |= 0x10;
      builder2.mContentIntent = (PendingIntent)builder;
      NotificationCompat.Builder builder1 = builder2.setContentTitle(str2).setContentText(str1);
      builder1.mLocalOnly = true;
      builder1 = builder1.setStyle((NotificationCompat.Style)(new NotificationCompat.BigTextStyle()).bigText(str1));
      if (zzs.isAtLeastO() && zzs.isAtLeastO())
        builder1.mChannelId = zza((Context)notification, notificationManager); 
      notification = (new NotificationCompatBuilder(builder1)).build();
    } 
    switch (paramInt) {
      default:
        paramInt = 39789;
        notificationManager.notify(paramInt, notification);
        throw new VerifyError("bad dex opcode");
      case 1:
      case 2:
      case 3:
        break;
    } 
    paramInt = 10436;
    zzs.zzfrv.set(false);
    notificationManager.notify(paramInt, notification);
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\GoogleApiAvailability.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */