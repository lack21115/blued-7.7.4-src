package org.chromium.android_webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import org.chromium.base.AsyncTask;
import org.chromium.base.ContentUriUtils;

final class AwWebContentsDelegateAdapter$GetDisplayNameTask extends AsyncTask {
  @SuppressLint({"StaticFieldLeak"})
  private Context mContext;
  
  private String[] mFilePaths;
  
  private int mModeFlags;
  
  private int mProcessId;
  
  private int mRenderId;
  
  public AwWebContentsDelegateAdapter$GetDisplayNameTask(Context paramContext, int paramInt1, int paramInt2, int paramInt3, String[] paramArrayOfString) {
    this.mProcessId = paramInt1;
    this.mRenderId = paramInt2;
    this.mModeFlags = paramInt3;
    this.mFilePaths = paramArrayOfString;
    this.mContext = paramContext;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwWebContentsDelegateAdapter$GetDisplayNameTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */