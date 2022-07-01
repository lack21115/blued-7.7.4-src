package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

class MediaBrowserCompat$CustomActionResultReceiver extends ResultReceiver {
  private final MediaBrowserCompat$CustomActionCallback mCallback;
  
  private final Bundle mExtras;
  
  protected final void onReceiveResult(int paramInt, Bundle paramBundle) {
    StringBuilder stringBuilder;
    if (this.mCallback == null)
      return; 
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder("Unknown result code: ");
        stringBuilder.append(paramInt);
        stringBuilder.append(" (extras=");
        stringBuilder.append(this.mExtras);
        stringBuilder.append(", resultData=");
        stringBuilder.append(paramBundle);
        stringBuilder.append(")");
        Log.w("MediaBrowserCompat", stringBuilder.toString());
        return;
      case 1:
        return;
      case 0:
        return;
      case -1:
        break;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\MediaBrowserCompat$CustomActionResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */