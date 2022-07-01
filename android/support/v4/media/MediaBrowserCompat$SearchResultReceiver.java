package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;
import java.util.ArrayList;

class MediaBrowserCompat$SearchResultReceiver extends ResultReceiver {
  protected final void onReceiveResult(int paramInt, Bundle paramBundle) {
    if (paramBundle != null)
      paramBundle.setClassLoader(MediaBrowserCompat.class.getClassLoader()); 
    if (paramInt == 0 && paramBundle != null) {
      if (!paramBundle.containsKey("search_results"))
        return; 
      Parcelable[] arrayOfParcelable = paramBundle.getParcelableArray("search_results");
      if (arrayOfParcelable != null) {
        ArrayList<MediaBrowserCompat$MediaItem> arrayList = new ArrayList();
        int i = arrayOfParcelable.length;
        for (paramInt = 0; paramInt < i; paramInt++)
          arrayList.add((MediaBrowserCompat$MediaItem)arrayOfParcelable[paramInt]); 
      } 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\media\MediaBrowserCompat$SearchResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */