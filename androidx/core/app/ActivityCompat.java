package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.DragEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.DragAndDropPermissionsCompat;
import java.util.List;
import java.util.Map;

public class ActivityCompat extends ContextCompat {
  private static PermissionCompatDelegate a;
  
  public static void finishAffinity(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramActivity.finishAffinity();
      return;
    } 
    paramActivity.finish();
  }
  
  public static void finishAfterTransition(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.finishAfterTransition();
      return;
    } 
    paramActivity.finish();
  }
  
  public static PermissionCompatDelegate getPermissionCompatDelegate() {
    return a;
  }
  
  public static Uri getReferrer(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 22)
      return paramActivity.getReferrer(); 
    Intent intent = paramActivity.getIntent();
    Uri uri = (Uri)intent.getParcelableExtra("android.intent.extra.REFERRER");
    if (uri != null)
      return uri; 
    String str = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
    return (str != null) ? Uri.parse(str) : null;
  }
  
  @Deprecated
  public static boolean invalidateOptionsMenu(Activity paramActivity) {
    paramActivity.invalidateOptionsMenu();
    return true;
  }
  
  public static void postponeEnterTransition(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 21)
      paramActivity.postponeEnterTransition(); 
  }
  
  public static void recreate(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 28) {
      paramActivity.recreate();
      return;
    } 
    if (!ActivityRecreator.a(paramActivity))
      paramActivity.recreate(); 
  }
  
  public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity paramActivity, DragEvent paramDragEvent) {
    return DragAndDropPermissionsCompat.request(paramActivity, paramDragEvent);
  }
  
  public static void requestPermissions(Activity paramActivity, String[] paramArrayOfString, int paramInt) {
    PermissionCompatDelegate permissionCompatDelegate = a;
    if (permissionCompatDelegate != null && permissionCompatDelegate.requestPermissions(paramActivity, paramArrayOfString, paramInt))
      return; 
    if (Build.VERSION.SDK_INT >= 23) {
      if (paramActivity instanceof RequestPermissionsRequestCodeValidator)
        ((RequestPermissionsRequestCodeValidator)paramActivity).validateRequestPermissionsRequestCode(paramInt); 
      paramActivity.requestPermissions(paramArrayOfString, paramInt);
      return;
    } 
    if (paramActivity instanceof OnRequestPermissionsResultCallback)
      (new Handler(Looper.getMainLooper())).post(new Runnable(paramArrayOfString, paramActivity, paramInt) {
            public void run() {
              int[] arrayOfInt = new int[this.a.length];
              PackageManager packageManager = this.b.getPackageManager();
              String str = this.b.getPackageName();
              int j = this.a.length;
              for (int i = 0; i < j; i++)
                arrayOfInt[i] = packageManager.checkPermission(this.a[i], str); 
              ((ActivityCompat.OnRequestPermissionsResultCallback)this.b).onRequestPermissionsResult(this.c, this.a, arrayOfInt);
            }
          }); 
  }
  
  public static <T extends View> T requireViewById(Activity paramActivity, int paramInt) {
    if (Build.VERSION.SDK_INT >= 28)
      return (T)paramActivity.requireViewById(paramInt); 
    View view = paramActivity.findViewById(paramInt);
    if (view != null)
      return (T)view; 
    throw new IllegalArgumentException("ID does not reference a View inside this Activity");
  }
  
  public static void setEnterSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback) {
    if (Build.VERSION.SDK_INT >= 21) {
      if (paramSharedElementCallback != null) {
        SharedElementCallback21Impl sharedElementCallback21Impl = new SharedElementCallback21Impl(paramSharedElementCallback);
      } else {
        paramSharedElementCallback = null;
      } 
      paramActivity.setEnterSharedElementCallback((SharedElementCallback)paramSharedElementCallback);
    } 
  }
  
  public static void setExitSharedElementCallback(Activity paramActivity, SharedElementCallback paramSharedElementCallback) {
    if (Build.VERSION.SDK_INT >= 21) {
      if (paramSharedElementCallback != null) {
        SharedElementCallback21Impl sharedElementCallback21Impl = new SharedElementCallback21Impl(paramSharedElementCallback);
      } else {
        paramSharedElementCallback = null;
      } 
      paramActivity.setExitSharedElementCallback((SharedElementCallback)paramSharedElementCallback);
    } 
  }
  
  public static void setPermissionCompatDelegate(PermissionCompatDelegate paramPermissionCompatDelegate) {
    a = paramPermissionCompatDelegate;
  }
  
  public static boolean shouldShowRequestPermissionRationale(Activity paramActivity, String paramString) {
    return (Build.VERSION.SDK_INT >= 23) ? paramActivity.shouldShowRequestPermissionRationale(paramString) : false;
  }
  
  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle) {
    if (Build.VERSION.SDK_INT >= 16) {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    } 
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void startIntentSenderForResult(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle) throws IntentSender.SendIntentException {
    if (Build.VERSION.SDK_INT >= 16) {
      paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    } 
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public static void startPostponedEnterTransition(Activity paramActivity) {
    if (Build.VERSION.SDK_INT >= 21)
      paramActivity.startPostponedEnterTransition(); 
  }
  
  public static interface OnRequestPermissionsResultCallback {
    void onRequestPermissionsResult(int param1Int, String[] param1ArrayOfString, int[] param1ArrayOfint);
  }
  
  public static interface PermissionCompatDelegate {
    boolean onActivityResult(Activity param1Activity, int param1Int1, int param1Int2, Intent param1Intent);
    
    boolean requestPermissions(Activity param1Activity, String[] param1ArrayOfString, int param1Int);
  }
  
  public static interface RequestPermissionsRequestCodeValidator {
    void validateRequestPermissionsRequestCode(int param1Int);
  }
  
  static class SharedElementCallback21Impl extends SharedElementCallback {
    private final SharedElementCallback a;
    
    SharedElementCallback21Impl(SharedElementCallback param1SharedElementCallback) {
      this.a = param1SharedElementCallback;
    }
    
    public Parcelable onCaptureSharedElementSnapshot(View param1View, Matrix param1Matrix, RectF param1RectF) {
      return this.a.onCaptureSharedElementSnapshot(param1View, param1Matrix, param1RectF);
    }
    
    public View onCreateSnapshotView(Context param1Context, Parcelable param1Parcelable) {
      return this.a.onCreateSnapshotView(param1Context, param1Parcelable);
    }
    
    public void onMapSharedElements(List<String> param1List, Map<String, View> param1Map) {
      this.a.onMapSharedElements(param1List, param1Map);
    }
    
    public void onRejectSharedElements(List<View> param1List) {
      this.a.onRejectSharedElements(param1List);
    }
    
    public void onSharedElementEnd(List<String> param1List, List<View> param1List1, List<View> param1List2) {
      this.a.onSharedElementEnd(param1List, param1List1, param1List2);
    }
    
    public void onSharedElementStart(List<String> param1List, List<View> param1List1, List<View> param1List2) {
      this.a.onSharedElementStart(param1List, param1List1, param1List2);
    }
    
    public void onSharedElementsArrived(List<String> param1List, List<View> param1List1, SharedElementCallback.OnSharedElementsReadyListener param1OnSharedElementsReadyListener) {
      this.a.onSharedElementsArrived(param1List, param1List1, new SharedElementCallback.OnSharedElementsReadyListener(this, param1OnSharedElementsReadyListener) {
            public void onSharedElementsReady() {
              this.a.onSharedElementsReady();
            }
          });
    }
  }
  
  class null implements SharedElementCallback.OnSharedElementsReadyListener {
    null(ActivityCompat this$0, SharedElementCallback.OnSharedElementsReadyListener param1OnSharedElementsReadyListener) {}
    
    public void onSharedElementsReady() {
      this.a.onSharedElementsReady();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\app\ActivityCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */