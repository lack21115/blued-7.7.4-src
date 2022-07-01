package org.chromium.content_public.browser;

import android.content.Context;
import android.os.Handler;
import android.os.Parcelable;
import org.chromium.ui.base.EventForwarder;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

public interface WebContents extends Parcelable {
  void addObserver(WebContentsObserver paramWebContentsObserver);
  
  void evaluateJavaScript(String paramString, JavaScriptCallback paramJavaScriptCallback);
  
  void exitFullscreen();
  
  EventForwarder getEventForwarder();
  
  String getLastCommittedUrl();
  
  NavigationController getNavigationController();
  
  Object getOrSetUserData(Class paramClass, WebContents$UserDataFactory paramWebContents$UserDataFactory);
  
  int getThemeColor();
  
  String getTitle();
  
  WindowAndroid getTopLevelNativeWindow();
  
  String getVisibleUrl();
  
  boolean hasAccessedInitialDocument();
  
  void initialize(Context paramContext, String paramString, ViewAndroidDelegate paramViewAndroidDelegate, ViewEventSink$InternalAccessDelegate paramViewEventSink$InternalAccessDelegate, WindowAndroid paramWindowAndroid);
  
  void onHide();
  
  void onShow();
  
  void postMessageToFrame(String paramString1, String paramString2, String paramString3, String paramString4, MessagePort[] paramArrayOfMessagePort);
  
  void removeObserver(WebContentsObserver paramWebContentsObserver);
  
  void requestSmartClipExtract(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  void setImportance(int paramInt);
  
  void setInternalsHolder(WebContents$InternalsHolder paramWebContents$InternalsHolder);
  
  void setSmartClipResultHandler(Handler paramHandler);
  
  void stop();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\WebContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */