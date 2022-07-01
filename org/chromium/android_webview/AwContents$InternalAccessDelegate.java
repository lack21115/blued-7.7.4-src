package org.chromium.android_webview;

import android.content.Intent;
import org.chromium.content_public.browser.ViewEventSink;

public interface AwContents$InternalAccessDelegate extends ViewEventSink.InternalAccessDelegate {
  void overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean);
  
  void setMeasuredDimension(int paramInt1, int paramInt2);
  
  int super_getScrollBarStyle();
  
  void super_scrollTo(int paramInt1, int paramInt2);
  
  void super_startActivityForResult(Intent paramIntent, int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwContents$InternalAccessDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */