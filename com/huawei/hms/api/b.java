package com.huawei.hms.api;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.EnableServiceActivity;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.common.ErrorDialogFragment;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.common.api.HuaweiApiCallable;
import com.huawei.hms.common.internal.ConnectionErrorMessages;
import com.huawei.hms.common.internal.DialogRedirect;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.HMSPublishStateHolder;
import com.huawei.hms.update.manager.UpdateManager;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.Util;

final class b extends HuaweiApiAvailability {
  private static final b a = new b();
  
  protected static int a(Activity paramActivity) {
    return (a((Context)paramActivity) != 0 && Build.VERSION.SDK_INT >= 16) ? 0 : 3;
  }
  
  private static int a(Context paramContext) {
    return (paramContext == null) ? 0 : paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  private static Dialog a(Activity paramActivity, int paramInt, DialogRedirect paramDialogRedirect, DialogInterface.OnCancelListener paramOnCancelListener) {
    if (paramInt == 0)
      return null; 
    AlertDialog.Builder builder = new AlertDialog.Builder((Context)paramActivity, a(paramActivity));
    builder.setMessage(ConnectionErrorMessages.getErrorMessage(paramActivity, paramInt));
    if (paramOnCancelListener != null)
      builder.setOnCancelListener(paramOnCancelListener); 
    builder.setPositiveButton(ConnectionErrorMessages.getErrorDialogButtonMessage(paramActivity, paramInt), (DialogInterface.OnClickListener)paramDialogRedirect);
    String str = ConnectionErrorMessages.getErrorTitle(paramActivity, paramInt);
    if (str != null)
      builder.setTitle(str); 
    return (Dialog)builder.create();
  }
  
  private Intent a(Activity paramActivity, int paramInt) {
    return !Util.isAvailableLibExist(paramActivity.getApplicationContext()) ? null : ((paramInt != 1 && paramInt != 2) ? ((paramInt != 6) ? null : BridgeActivity.getIntentStartBridgeActivity(paramActivity, BindingFailedResolution.class.getName())) : UpdateManager.startUpdateIntent(paramActivity));
  }
  
  private static Intent a(Activity paramActivity, String paramString) {
    return BridgeActivity.getIntentStartBridgeActivity(paramActivity, paramString);
  }
  
  private static Intent a(Context paramContext, String paramString) {
    return BridgeActivity.getIntentStartBridgeActivity(paramContext, paramString);
  }
  
  public static b a() {
    return a;
  }
  
  private static void a(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener) {
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity.getFragmentManager(), paramString);
  }
  
  private void a(Object paramObject) throws AvailabilityException {
    AvailabilityException availabilityException = new AvailabilityException();
    if (paramObject instanceof HuaweiApi) {
      paramObject = availabilityException.getConnectionResult((HuaweiApi)paramObject);
    } else {
      paramObject = availabilityException.getConnectionResult((HuaweiApiCallable)paramObject);
    } 
    if (paramObject.getErrorCode() == 0)
      return; 
    paramObject = new StringBuilder();
    paramObject.append("The service is unavailable: ");
    paramObject.append(availabilityException.getMessage());
    HMSLog.i("HuaweiApiAvailabilityImpl", paramObject.toString());
    throw availabilityException;
  }
  
  public PendingIntent a(Context paramContext, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter getResolveErrorPendingIntent, errorCode: ");
    stringBuilder.append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
    Intent intent = b(paramContext, paramInt);
    return (intent != null) ? PendingIntent.getActivity(paramContext, 0, intent, 134217728) : null;
  }
  
  public Intent b(Context paramContext, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter getResolveErrorIntent, errorCode: ");
    stringBuilder.append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
    if (paramInt != 1 && paramInt != 2)
      return (paramInt != 6) ? null : a(paramContext, BindingFailedResolution.class.getName()); 
    UpdateBean updateBean = new UpdateBean();
    updateBean.setHmsOrApkUpgrade(true);
    if (HMSPublishStateHolder.getPublishState() == 0) {
      updateBean.setClientPackageName(HMSPackageManager.getInstance(paramContext.getApplicationContext()).getHMSPackageName());
    } else if (HMSPublishStateHolder.getPublishState() == 1) {
      updateBean.setClientPackageName("com.huawei.hms");
    } else {
      updateBean.setClientPackageName("com.huawei.hwid");
    } 
    updateBean.setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
    updateBean.setClientAppId("C10132067");
    if (ResourceLoaderUtil.getmContext() == null)
      ResourceLoaderUtil.setmContext(paramContext.getApplicationContext()); 
    updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
    return UpdateManager.getStartUpdateIntent(paramContext, updateBean);
  }
  
  public Task<Void> checkApiAccessible(HuaweiApi<?> paramHuaweiApi, HuaweiApi<?>... paramVarArgs) {
    // Byte code:
    //   0: new com/huawei/hmf/tasks/TaskCompletionSource
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: invokevirtual a : ()Lcom/huawei/hmf/tasks/Task;
    //   10: astore #5
    //   12: aload_1
    //   13: ifnull -> 24
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial a : (Ljava/lang/Object;)V
    //   21: goto -> 24
    //   24: aload_2
    //   25: ifnull -> 88
    //   28: aload_2
    //   29: arraylength
    //   30: istore #4
    //   32: iconst_0
    //   33: istore_3
    //   34: iload_3
    //   35: iload #4
    //   37: if_icmpge -> 88
    //   40: aload_0
    //   41: aload_2
    //   42: iload_3
    //   43: aaload
    //   44: invokespecial a : (Ljava/lang/Object;)V
    //   47: iload_3
    //   48: iconst_1
    //   49: iadd
    //   50: istore_3
    //   51: goto -> 34
    //   54: new java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial <init> : ()V
    //   61: astore_1
    //   62: aload_1
    //   63: ldc_w 'checkApi has AvailabilityException '
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: aload_2
    //   72: invokevirtual getMessage : ()Ljava/lang/String;
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: ldc 'HuaweiApiAvailabilityImpl'
    //   81: aload_1
    //   82: invokevirtual toString : ()Ljava/lang/String;
    //   85: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload #5
    //   90: areturn
    //   91: astore_2
    //   92: goto -> 54
    // Exception table:
    //   from	to	target	type
    //   16	21	91	com/huawei/hms/common/api/AvailabilityException
    //   28	32	91	com/huawei/hms/common/api/AvailabilityException
    //   40	47	91	com/huawei/hms/common/api/AvailabilityException
  }
  
  public Task<Void> checkApiAccessible(HuaweiApiCallable paramHuaweiApiCallable, HuaweiApiCallable... paramVarArgs) {
    // Byte code:
    //   0: new com/huawei/hmf/tasks/TaskCompletionSource
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: invokevirtual a : ()Lcom/huawei/hmf/tasks/Task;
    //   10: astore #5
    //   12: aload_1
    //   13: ifnull -> 24
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial a : (Ljava/lang/Object;)V
    //   21: goto -> 24
    //   24: aload_2
    //   25: ifnull -> 88
    //   28: aload_2
    //   29: arraylength
    //   30: istore #4
    //   32: iconst_0
    //   33: istore_3
    //   34: iload_3
    //   35: iload #4
    //   37: if_icmpge -> 88
    //   40: aload_0
    //   41: aload_2
    //   42: iload_3
    //   43: aaload
    //   44: invokespecial a : (Ljava/lang/Object;)V
    //   47: iload_3
    //   48: iconst_1
    //   49: iadd
    //   50: istore_3
    //   51: goto -> 34
    //   54: new java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial <init> : ()V
    //   61: astore_1
    //   62: aload_1
    //   63: ldc_w 'HuaweiApiCallable checkApi has AvailabilityException '
    //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_1
    //   71: aload_2
    //   72: invokevirtual getMessage : ()Ljava/lang/String;
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: ldc 'HuaweiApiAvailabilityImpl'
    //   81: aload_1
    //   82: invokevirtual toString : ()Ljava/lang/String;
    //   85: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload #5
    //   90: areturn
    //   91: astore_2
    //   92: goto -> 54
    // Exception table:
    //   from	to	target	type
    //   16	21	91	com/huawei/hms/common/api/AvailabilityException
    //   28	32	91	com/huawei/hms/common/api/AvailabilityException
    //   40	47	91	com/huawei/hms/common/api/AvailabilityException
  }
  
  public PendingIntent getErrPendingIntent(Context paramContext, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter getResolveErrorPendingIntent, errorCode: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" requestCode: ");
    stringBuilder.append(paramInt2);
    HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
    Intent intent = b(paramContext, paramInt1);
    return (intent != null) ? PendingIntent.getActivity(paramContext, paramInt2, intent, 134217728) : null;
  }
  
  public PendingIntent getErrPendingIntent(Context paramContext, ConnectionResult paramConnectionResult) {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramConnectionResult);
    return a(paramContext, paramConnectionResult.getErrorCode());
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2) {
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter getErrorDialog, errorCode: ");
    stringBuilder.append(paramInt1);
    HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
    return getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter getErrorDialog, errorCode: ");
    stringBuilder.append(paramInt1);
    HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
    return a(paramActivity, paramInt1, DialogRedirect.getInstance(paramActivity, a(paramActivity, paramInt1), paramInt2), paramOnCancelListener);
  }
  
  public String getErrorString(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter getErrorString, errorCode: ");
    stringBuilder.append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
    return ConnectionResult.a(paramInt);
  }
  
  public Task<Void> getHuaweiServicesReady(Activity paramActivity) {
    Bundle bundle;
    Preconditions.checkNotNull(paramActivity);
    TaskCompletionSource[] arrayOfTaskCompletionSource = new TaskCompletionSource[1];
    arrayOfTaskCompletionSource[0] = new TaskCompletionSource();
    Task<Void> task = arrayOfTaskCompletionSource[0].a();
    int i = isHuaweiMobileServicesAvailable(paramActivity.getApplicationContext(), 30000000);
    Intent intent1 = getResolveErrorIntent(paramActivity, i);
    Intent intent2 = BridgeActivity.getIntentStartBridgeActivity(paramActivity, ResolutionDelegate.class.getName());
    if (intent1 != null) {
      ForegroundIntentBuilder.registerResponseCallback("CALLBACK_METHOD", new BusResponseCallback(this, arrayOfTaskCompletionSource) {
            public BusResponseResult innerError(Activity param1Activity, int param1Int, String param1String) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Test foreground bus error: resultCode ");
              stringBuilder.append(param1Int);
              stringBuilder.append(", errMessage");
              stringBuilder.append(param1String);
              HMSLog.e("HuaweiApiAvailabilityImpl", stringBuilder.toString());
              this.a[0].a((Exception)new AvailabilityException());
              return null;
            }
            
            public BusResponseResult succeedReturn(Activity param1Activity, int param1Int, Intent param1Intent) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Test foreground bus success: resultCode ");
              stringBuilder.append(param1Int);
              stringBuilder.append(", data");
              stringBuilder.append(param1Intent);
              HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
              return null;
            }
          });
      bundle = new Bundle();
      bundle.putParcelable("resolution", (Parcelable)intent1);
      intent2.putExtras(bundle);
      paramActivity.startActivity(intent2);
      return task;
    } 
    if (i == 3) {
      intent1 = new Intent();
      intent1.setClass((Context)paramActivity, EnableServiceActivity.class);
      paramActivity.startActivity(intent1);
      return task;
    } 
    if (i == 0) {
      HMSLog.i("HuaweiApiAvailabilityImpl", "The HMS service is available.");
      return task;
    } 
    HMSLog.e("HuaweiApiAvailabilityImpl", "Framework can not solve the availability problem.");
    bundle[0].a((Exception)new AvailabilityException());
    return task;
  }
  
  public Intent getResolveErrorIntent(Activity paramActivity, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter getResolveErrorIntent, errorCode: ");
    stringBuilder.append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
    if (!Util.isAvailableLibExist(paramActivity.getApplicationContext()))
      return null; 
    if (paramInt != 1 && paramInt != 2)
      return (paramInt != 6) ? null : a(paramActivity, BindingFailedResolution.class.getName()); 
    UpdateBean updateBean = new UpdateBean();
    updateBean.setHmsOrApkUpgrade(true);
    if (HMSPublishStateHolder.getPublishState() == 0) {
      updateBean.setClientPackageName(HMSPackageManager.getInstance(paramActivity.getApplicationContext()).getHMSPackageName());
    } else if (HMSPublishStateHolder.getPublishState() == 1) {
      updateBean.setClientPackageName("com.huawei.hms");
    } else {
      updateBean.setClientPackageName("com.huawei.hwid");
    } 
    updateBean.setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
    updateBean.setClientAppId("C10132067");
    if (ResourceLoaderUtil.getmContext() == null)
      ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext()); 
    updateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
    return UpdateManager.getStartUpdateIntent(paramActivity, updateBean);
  }
  
  public PendingIntent getResolveErrorPendingIntent(Activity paramActivity, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter getResolveErrorPendingIntent, errorCode: ");
    stringBuilder.append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
    Intent intent = getResolveErrorIntent(paramActivity, paramInt);
    return (intent != null) ? PendingIntent.getActivity((Context)paramActivity, 0, intent, 134217728) : null;
  }
  
  public int isHuaweiMobileNoticeAvailable(Context paramContext) {
    Checker.checkNonNull(paramContext, "context must not be null.");
    PackageManagerHelper.PackageStates packageStates = (new PackageManagerHelper(paramContext)).getPackageStates(HMSPackageManager.getInstance(paramContext).getHMSPackageName());
    return PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageStates) ? 1 : (HMSPackageManager.getInstance(paramContext).isApkUpdateNecessary(20600000) ? 2 : 0);
  }
  
  public int isHuaweiMobileServicesAvailable(Context paramContext) {
    Checker.checkNonNull(paramContext, "context must not be null.");
    return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(paramContext, HuaweiApiAvailability.getServicesVersionCode());
  }
  
  public int isHuaweiMobileServicesAvailable(Context paramContext, int paramInt) {
    Checker.checkNonNull(paramContext, "context must not be null.");
    return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(paramContext, paramInt);
  }
  
  public boolean isUserResolvableError(int paramInt) {
    return isUserResolvableError(paramInt, null);
  }
  
  public boolean isUserResolvableError(int paramInt, PendingIntent paramPendingIntent) {
    return (paramInt == 0) ? false : ((paramPendingIntent != null) ? true : (!(paramInt != 1 && paramInt != 2 && paramInt != 6)));
  }
  
  public void popupErrNotification(Context paramContext, ConnectionResult paramConnectionResult) {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramConnectionResult);
    showErrorNotification(paramContext, paramConnectionResult.getErrorCode());
  }
  
  public void resolveError(Activity paramActivity, int paramInt1, int paramInt2) {
    resolveError(paramActivity, paramInt1, paramInt2, null);
  }
  
  public void resolveError(Activity paramActivity, int paramInt1, int paramInt2, PendingIntent paramPendingIntent) {
    PendingIntent pendingIntent;
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    if (paramPendingIntent != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Enter resolveError, param pendingIntent is not null. and.errorCode: ");
      stringBuilder.append(paramInt1);
      HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Enter resolveError, param pendingIntent is  null. get pendingIntent from error code.and.errorCode: ");
      stringBuilder.append(paramInt1);
      HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
      pendingIntent = getResolveErrorPendingIntent(paramActivity, paramInt1);
    } 
    if (pendingIntent != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("In resolveError, start pingding intent.errorCode: ");
      stringBuilder.append(paramInt1);
      HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
      try {
        paramActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), paramInt2, null, 0, 0, 0);
        return;
      } catch (android.content.IntentSender.SendIntentException sendIntentException) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Enter resolveError, start pendingIntent failed.errorCode: ");
        stringBuilder1.append(paramInt1);
        HMSLog.e("HuaweiApiAvailabilityImpl", stringBuilder1.toString());
      } 
    } 
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2) {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    Dialog dialog = getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    if (dialog == null)
      return false; 
    a(paramActivity, dialog, "HuaweiMobileServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener) {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
  }
  
  public void showErrorNotification(Context paramContext, int paramInt) {
    Checker.checkNonNull(paramContext, "context must not be null.");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Enter showErrorNotification, errorCode: ");
    stringBuilder.append(paramInt);
    HMSLog.i("HuaweiApiAvailabilityImpl", stringBuilder.toString());
    Dialog dialog = getErrorDialog((Activity)paramContext, paramInt, 0);
    if (dialog == null) {
      HMSLog.i("HuaweiApiAvailabilityImpl", "showErrorNotification errorDialog can not be null");
      return;
    } 
    dialog.show();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\api\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */