package org.chromium.ui.base;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import java.io.IOException;
import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.AsyncTask;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.ui.R;

final class SelectFileDialog$GetCameraIntentTask extends AsyncTask {
  private WindowAndroid$IntentCallback mCallback;
  
  private Boolean mDirectToCamera;
  
  private WindowAndroid mWindow;
  
  public SelectFileDialog$GetCameraIntentTask(Boolean paramBoolean, WindowAndroid paramWindowAndroid, WindowAndroid$IntentCallback paramWindowAndroid$IntentCallback) {
    this.mDirectToCamera = paramBoolean;
    this.mWindow = paramWindowAndroid;
    this.mCallback = paramWindowAndroid$IntentCallback;
  }
  
  private static Uri doInBackground$34e9db1e() {
    try {
      return ApiCompatibilityUtils.getUriForImageCaptureFile(SelectFileDialog.access$000$3eb43c00(ContextUtils.sApplicationContext));
    } catch (IOException iOException) {
      Log.e("SelectFileDialog", "Cannot retrieve content uri from file", new Object[] { iOException });
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\base\SelectFileDialog$GetCameraIntentTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */