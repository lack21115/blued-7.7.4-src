package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.zad;

public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
  public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
  
  @Deprecated
  public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
  
  @Deprecated
  public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
  
  public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2) {
    return getErrorDialog(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static Dialog getErrorDialog(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    int i = paramInt1;
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating((Context)paramActivity, paramInt1))
      i = 18; 
    return GoogleApiAvailability.getInstance().getErrorDialog(paramActivity, i, paramInt2, paramOnCancelListener);
  }
  
  @Deprecated
  public static PendingIntent getErrorPendingIntent(int paramInt1, Context paramContext, int paramInt2) {
    return GooglePlayServicesUtilLight.getErrorPendingIntent(paramInt1, paramContext, paramInt2);
  }
  
  @Deprecated
  public static String getErrorString(int paramInt) {
    return GooglePlayServicesUtilLight.getErrorString(paramInt);
  }
  
  public static Context getRemoteContext(Context paramContext) {
    return GooglePlayServicesUtilLight.getRemoteContext(paramContext);
  }
  
  public static Resources getRemoteResource(Context paramContext) {
    return GooglePlayServicesUtilLight.getRemoteResource(paramContext);
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext) {
    return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(paramContext);
  }
  
  @Deprecated
  public static int isGooglePlayServicesAvailable(Context paramContext, int paramInt) {
    return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(paramContext, paramInt);
  }
  
  @Deprecated
  public static boolean isUserRecoverableError(int paramInt) {
    return GooglePlayServicesUtilLight.isUserRecoverableError(paramInt);
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2) {
    return showErrorDialogFragment(paramInt1, paramActivity, paramInt2, null);
  }
  
  @Deprecated
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    return showErrorDialogFragment(paramInt1, paramActivity, null, paramInt2, paramOnCancelListener);
  }
  
  public static boolean showErrorDialogFragment(int paramInt1, Activity paramActivity, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    int i = paramInt1;
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating((Context)paramActivity, paramInt1))
      i = 18; 
    GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
    if (paramFragment == null)
      return googleApiAvailability.showErrorDialogFragment(paramActivity, i, paramInt2, paramOnCancelListener); 
    Dialog dialog = GoogleApiAvailability.zaa((Context)paramActivity, i, zad.zaa(paramFragment, GoogleApiAvailability.getInstance().getErrorResolutionIntent((Context)paramActivity, i, "d"), paramInt2), paramOnCancelListener);
    if (dialog == null)
      return false; 
    GoogleApiAvailability.zaa(paramActivity, dialog, "GooglePlayServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  @Deprecated
  public static void showErrorNotification(int paramInt, Context paramContext) {
    GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
    if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(paramContext, paramInt) || GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(paramContext, paramInt)) {
      googleApiAvailability.zaa(paramContext);
      return;
    } 
    googleApiAvailability.showErrorNotification(paramContext, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\GooglePlayServicesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */