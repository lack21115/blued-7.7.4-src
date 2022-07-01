package org.chromium.content.browser.webcontents;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.chromium.base.Callback;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.browser.MediaSessionImpl;
import org.chromium.content.browser.RenderCoordinatesImpl;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl;
import org.chromium.content.browser.framehost.RenderFrameHostDelegate;
import org.chromium.content.browser.framehost.RenderFrameHostImpl;
import org.chromium.content.browser.selection.SelectionPopupControllerImpl;
import org.chromium.content_public.browser.AccessibilitySnapshotCallback;
import org.chromium.content_public.browser.AccessibilitySnapshotNode;
import org.chromium.content_public.browser.ImageDownloadCallback;
import org.chromium.content_public.browser.JavaScriptCallback;
import org.chromium.content_public.browser.MessagePort;
import org.chromium.content_public.browser.NavigationController;
import org.chromium.content_public.browser.RenderFrameHost;
import org.chromium.content_public.browser.ViewEventSink;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsInternals;
import org.chromium.content_public.browser.WebContentsObserver;
import org.chromium.ui.OverscrollRefreshHandler;
import org.chromium.ui.base.EventForwarder;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

public class WebContentsImpl implements WindowEventObserver, RenderFrameHostDelegate, WebContents {
  @SuppressLint({"ParcelClassLoader"})
  public static final Parcelable.Creator CREATOR;
  
  private static UUID sParcelableUUID;
  
  private EventForwarder mEventForwarder;
  
  private final List mFrames = new ArrayList();
  
  private WebContents.InternalsHolder mInternalsHolder;
  
  public long mNativeWebContentsAndroid;
  
  private NavigationController mNavigationController;
  
  private WebContentsObserverProxy mObserverProxy;
  
  public RenderCoordinatesImpl mRenderCoordinates;
  
  private WebContentsImpl$SmartClipCallback mSmartClipCallback;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private WebContentsImpl(long paramLong, NavigationController paramNavigationController) {
    this.mNativeWebContentsAndroid = paramLong;
    this.mNavigationController = paramNavigationController;
    WebContentsImpl$WebContentsInternalsImpl webContentsImpl$WebContentsInternalsImpl = new WebContentsImpl$WebContentsInternalsImpl((byte)0);
    webContentsImpl$WebContentsInternalsImpl.userDataMap = new HashMap<Object, Object>();
    this.mRenderCoordinates = new RenderCoordinatesImpl();
    RenderCoordinatesImpl renderCoordinatesImpl = this.mRenderCoordinates;
    renderCoordinatesImpl.mScrollYCss = 0.0F;
    renderCoordinatesImpl.mScrollXCss = 0.0F;
    renderCoordinatesImpl.mPageScaleFactor = 1.0F;
    this.mInternalsHolder = new WebContentsImpl$DefaultInternalsHolder((byte)0);
    this.mInternalsHolder.set(webContentsImpl$WebContentsInternalsImpl);
  }
  
  @CalledByNative
  private static void addAccessibilityNodeAsChild(AccessibilitySnapshotNode paramAccessibilitySnapshotNode1, AccessibilitySnapshotNode paramAccessibilitySnapshotNode2) {
    paramAccessibilitySnapshotNode1.children.add(paramAccessibilitySnapshotNode2);
  }
  
  @CalledByNative
  private static void addToBitmapList(List<Bitmap> paramList, Bitmap paramBitmap) {
    paramList.add(paramBitmap);
  }
  
  @CalledByNative
  private void clearNativePtr() {
    this.mNativeWebContentsAndroid = 0L;
    this.mNavigationController = null;
    if (this.mObserverProxy != null) {
      this.mObserverProxy.destroy();
      this.mObserverProxy = null;
    } 
  }
  
  @CalledByNative
  private static WebContentsImpl create(long paramLong, NavigationController paramNavigationController) {
    return new WebContentsImpl(paramLong, paramNavigationController);
  }
  
  @CalledByNative
  private static AccessibilitySnapshotNode createAccessibilitySnapshotNode(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, String paramString1, int paramInt5, int paramInt6, float paramFloat, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString2) {
    AccessibilitySnapshotNode accessibilitySnapshotNode = new AccessibilitySnapshotNode(paramString1, paramString2);
    if (paramFloat >= 0.0D) {
      accessibilitySnapshotNode.color = paramInt5;
      accessibilitySnapshotNode.bgcolor = paramInt6;
      accessibilitySnapshotNode.textSize = paramFloat;
      accessibilitySnapshotNode.bold = paramBoolean2;
      accessibilitySnapshotNode.italic = paramBoolean3;
      accessibilitySnapshotNode.underline = paramBoolean4;
      accessibilitySnapshotNode.lineThrough = paramBoolean5;
      accessibilitySnapshotNode.hasStyle = true;
    } 
    accessibilitySnapshotNode.x = paramInt1;
    accessibilitySnapshotNode.y = paramInt2;
    accessibilitySnapshotNode.width = paramInt3;
    accessibilitySnapshotNode.height = paramInt4;
    accessibilitySnapshotNode.isRootNode = paramBoolean1;
    return accessibilitySnapshotNode;
  }
  
  @CalledByNative
  private static List createBitmapList() {
    return new ArrayList();
  }
  
  @CalledByNative
  private static Rect createSize(int paramInt1, int paramInt2) {
    return new Rect(0, 0, paramInt1, paramInt2);
  }
  
  @CalledByNative
  private static void createSizeAndAddToList(List<Rect> paramList, int paramInt1, int paramInt2) {
    paramList.add(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  @CalledByNative
  private static List createSizeList() {
    return new ArrayList();
  }
  
  @CalledByNative
  private long getNativePointer() {
    return this.mNativeWebContentsAndroid;
  }
  
  private native void nativeAddMessageToDevToolsConsole(long paramLong, int paramInt, String paramString);
  
  private native void nativeCopy(long paramLong);
  
  private native void nativeCut(long paramLong);
  
  private static native void nativeDestroyWebContents(long paramLong);
  
  private native void nativeDismissTextHandles(long paramLong);
  
  private native int nativeDownloadImage(long paramLong, String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, ImageDownloadCallback paramImageDownloadCallback);
  
  private native void nativeEvaluateJavaScript(long paramLong, String paramString, JavaScriptCallback paramJavaScriptCallback);
  
  private native void nativeEvaluateJavaScriptForTests(long paramLong, String paramString, JavaScriptCallback paramJavaScriptCallback);
  
  private native void nativeExitFullscreen(long paramLong);
  
  private native boolean nativeFocusLocationBarByDefault(long paramLong);
  
  private static native WebContents nativeFromNativePtr(long paramLong);
  
  private native int nativeGetBackgroundColor(long paramLong);
  
  private native String nativeGetEncoding(long paramLong);
  
  private native Rect nativeGetFullscreenVideoSize(long paramLong);
  
  private native int nativeGetHeight(long paramLong);
  
  private native String nativeGetLastCommittedURL(long paramLong);
  
  private native RenderFrameHost nativeGetMainFrame(long paramLong);
  
  private native EventForwarder nativeGetOrCreateEventForwarder(long paramLong);
  
  private native int nativeGetThemeColor(long paramLong);
  
  private native String nativeGetTitle(long paramLong);
  
  private native int nativeGetTopControlsShrinkBlinkHeightPixForTesting(long paramLong);
  
  private native WindowAndroid nativeGetTopLevelNativeWindow(long paramLong);
  
  private native String nativeGetVisibleURL(long paramLong);
  
  private native int nativeGetWidth(long paramLong);
  
  private native boolean nativeHasAccessedInitialDocument(long paramLong);
  
  private native boolean nativeHasActiveEffectivelyFullscreenVideo(long paramLong);
  
  private native boolean nativeIsBeingDestroyed(long paramLong);
  
  private native boolean nativeIsIncognito(long paramLong);
  
  private native boolean nativeIsLoading(long paramLong);
  
  private native boolean nativeIsLoadingToDifferentDocument(long paramLong);
  
  private native boolean nativeIsPictureInPictureAllowedForFullscreenVideo(long paramLong);
  
  private native boolean nativeIsRenderWidgetHostViewReady(long paramLong);
  
  private native boolean nativeIsShowingInterstitialPage(long paramLong);
  
  private native void nativeOnHide(long paramLong);
  
  private native void nativeOnScaleFactorChanged(long paramLong);
  
  private native void nativeOnShow(long paramLong);
  
  private native void nativePaste(long paramLong);
  
  private native void nativePostMessageToFrame(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, MessagePort[] paramArrayOfMessagePort);
  
  private native void nativeReloadLoFiImages(long paramLong);
  
  private native void nativeRequestSmartClipExtract(long paramLong, WebContentsImpl$SmartClipCallback paramWebContentsImpl$SmartClipCallback, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void nativeResumeLoadingCreatedWebContents(long paramLong);
  
  private native void nativeScrollFocusedEditableNodeIntoView(long paramLong);
  
  private native void nativeSelectAll(long paramLong);
  
  private native void nativeSelectWordAroundCaret(long paramLong);
  
  private native void nativeSendOrientationChangeEvent(long paramLong, int paramInt);
  
  private native void nativeSetAudioMuted(long paramLong, boolean paramBoolean);
  
  private native void nativeSetDisplayCutoutSafeArea(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private native void nativeSetHasPersistentVideo(long paramLong, boolean paramBoolean);
  
  private native void nativeSetImportance(long paramLong, int paramInt);
  
  private native void nativeSetOverscrollRefreshHandler(long paramLong, OverscrollRefreshHandler paramOverscrollRefreshHandler);
  
  private native void nativeSetSize(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSetTopLevelNativeWindow(long paramLong, WindowAndroid paramWindowAndroid);
  
  private native void nativeSetViewAndroidDelegate(long paramLong, ViewAndroidDelegate paramViewAndroidDelegate);
  
  private native void nativeShowContextMenuAtTouchHandle(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeStop(long paramLong);
  
  private native void nativeSuspendAllMediaPlayers(long paramLong);
  
  private native void nativeWriteContentBitmapToDisk(long paramLong, int paramInt1, int paramInt2, String paramString, Callback paramCallback);
  
  @CalledByNative
  private static void onAccessibilitySnapshot(AccessibilitySnapshotNode paramAccessibilitySnapshotNode, AccessibilitySnapshotCallback paramAccessibilitySnapshotCallback) {
    paramAccessibilitySnapshotCallback.onAccessibilitySnapshot(paramAccessibilitySnapshotNode);
  }
  
  @CalledByNative
  private void onDownloadImageFinished(ImageDownloadCallback paramImageDownloadCallback, int paramInt1, int paramInt2, String paramString, List paramList1, List paramList2) {}
  
  @CalledByNative
  private static void onEvaluateJavaScriptResult(String paramString, JavaScriptCallback paramJavaScriptCallback) {
    paramJavaScriptCallback.handleJavaScriptResult(paramString);
  }
  
  @CalledByNative
  private static void onSmartClipDataExtracted(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, WebContentsImpl$SmartClipCallback paramWebContentsImpl$SmartClipCallback) {
    Rect rect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    RenderCoordinatesImpl renderCoordinatesImpl = paramWebContentsImpl$SmartClipCallback.this$0.mRenderCoordinates;
    rect.offset(0, (int)(renderCoordinatesImpl.mTopContentOffsetYPix / renderCoordinatesImpl.mDeviceScaleFactor));
    Bundle bundle = new Bundle();
    bundle.putString("url", paramWebContentsImpl$SmartClipCallback.this$0.getVisibleUrl());
    bundle.putString("title", paramWebContentsImpl$SmartClipCallback.this$0.getTitle());
    bundle.putString("text", paramString1);
    bundle.putString("html", paramString2);
    bundle.putParcelable("rect", (Parcelable)rect);
    Message message = Message.obtain(paramWebContentsImpl$SmartClipCallback.mHandler, 0);
    message.setData(bundle);
    message.sendToTarget();
  }
  
  @CalledByNative
  private static void setAccessibilitySnapshotSelection(AccessibilitySnapshotNode paramAccessibilitySnapshotNode, int paramInt1, int paramInt2) {
    paramAccessibilitySnapshotNode.hasSelection = true;
    paramAccessibilitySnapshotNode.startSelection = paramInt1;
    paramAccessibilitySnapshotNode.endSelection = paramInt2;
  }
  
  @CalledByNative
  private final void setMediaSession(MediaSessionImpl paramMediaSessionImpl) {}
  
  public final void addObserver(WebContentsObserver paramWebContentsObserver) {
    assert false;
    throw new AssertionError();
  }
  
  public final void copy() {
    nativeCopy(this.mNativeWebContentsAndroid);
  }
  
  public final void cut() {
    nativeCut(this.mNativeWebContentsAndroid);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public final void dismissTextHandles() {
    if (isDestroyed())
      return; 
    nativeDismissTextHandles(this.mNativeWebContentsAndroid);
  }
  
  public final void evaluateJavaScript(String paramString, JavaScriptCallback paramJavaScriptCallback) {
    if (!isDestroyed()) {
      if (paramString == null)
        return; 
      nativeEvaluateJavaScript(this.mNativeWebContentsAndroid, paramString, paramJavaScriptCallback);
      return;
    } 
  }
  
  public final void exitFullscreen() {
    nativeExitFullscreen(this.mNativeWebContentsAndroid);
  }
  
  public final EventForwarder getEventForwarder() {
    assert false;
    throw new AssertionError();
  }
  
  public final String getLastCommittedUrl() {
    return nativeGetLastCommittedURL(this.mNativeWebContentsAndroid);
  }
  
  public final NavigationController getNavigationController() {
    return this.mNavigationController;
  }
  
  public final Object getOrSetUserData(Class<?> paramClass, WebContents.UserDataFactory paramUserDataFactory) {
    HashMap<Class<?>, WebContentsUserData> hashMap;
    WebContentsInternals webContentsInternals = this.mInternalsHolder.get();
    if (webContentsInternals == null) {
      webContentsInternals = null;
    } else {
      hashMap = ((WebContentsImpl$WebContentsInternalsImpl)webContentsInternals).userDataMap;
    } 
    if (hashMap == null) {
      Log.e("cr_WebContentsImpl", "UserDataMap can't be found", new Object[0]);
      return null;
    } 
    WebContentsUserData webContentsUserData2 = (WebContentsUserData)hashMap.get(paramClass);
    WebContentsUserData webContentsUserData1 = webContentsUserData2;
    if (webContentsUserData2 == null) {
      webContentsUserData1 = webContentsUserData2;
      if (paramUserDataFactory != null)
        if ($assertionsDisabled || !hashMap.containsKey(paramClass)) {
          Object object = paramUserDataFactory.create(this);
          if ($assertionsDisabled || paramClass.isInstance(object)) {
            hashMap.put(paramClass, new WebContentsUserData(object));
            webContentsUserData1 = hashMap.get(paramClass);
          } else {
            throw new AssertionError();
          } 
        } else {
          throw new AssertionError();
        }  
    } 
    return (webContentsUserData1 != null) ? paramClass.cast(webContentsUserData1.mObject) : null;
  }
  
  public final int getThemeColor() {
    return nativeGetThemeColor(this.mNativeWebContentsAndroid);
  }
  
  public final String getTitle() {
    return nativeGetTitle(this.mNativeWebContentsAndroid);
  }
  
  public final WindowAndroid getTopLevelNativeWindow() {
    return nativeGetTopLevelNativeWindow(this.mNativeWebContentsAndroid);
  }
  
  public final ViewAndroidDelegate getViewAndroidDelegate() {
    WebContentsInternals webContentsInternals = this.mInternalsHolder.get();
    return (webContentsInternals == null) ? null : ((WebContentsImpl$WebContentsInternalsImpl)webContentsInternals).viewAndroidDelegate;
  }
  
  public final String getVisibleUrl() {
    return nativeGetVisibleURL(this.mNativeWebContentsAndroid);
  }
  
  public final boolean hasAccessedInitialDocument() {
    return nativeHasAccessedInitialDocument(this.mNativeWebContentsAndroid);
  }
  
  public final void initialize(Context paramContext, String paramString, ViewAndroidDelegate paramViewAndroidDelegate, ViewEventSink.InternalAccessDelegate paramInternalAccessDelegate, WindowAndroid paramWindowAndroid) {
    assert false;
    throw new AssertionError();
  }
  
  public final boolean isDestroyed() {
    return (this.mNativeWebContentsAndroid == 0L || nativeIsBeingDestroyed(this.mNativeWebContentsAndroid));
  }
  
  public final boolean isIncognito() {
    return nativeIsIncognito(this.mNativeWebContentsAndroid);
  }
  
  public native void nativeAdjustSelectionByCharacterOffset(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public native void nativeCollapseSelection(long paramLong);
  
  public native void nativePasteAsPlainText(long paramLong);
  
  public native void nativeReplace(long paramLong, String paramString);
  
  public native void nativeRequestAccessibilitySnapshot(long paramLong, AccessibilitySnapshotCallback paramAccessibilitySnapshotCallback);
  
  public native void nativeSetFocus(long paramLong, boolean paramBoolean);
  
  public final void onAttachedToWindow() {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onDIPScaleChanged(float paramFloat) {
    if (this.mNativeWebContentsAndroid == 0L)
      return; 
    this.mRenderCoordinates.mDeviceScaleFactor = paramFloat;
    nativeOnScaleFactorChanged(this.mNativeWebContentsAndroid);
  }
  
  public final void onDetachedFromWindow() {}
  
  public final void onHide() {
    SelectionPopupControllerImpl selectionPopupControllerImpl = SelectionPopupControllerImpl.fromWebContents(this);
    if (selectionPopupControllerImpl != null)
      selectionPopupControllerImpl.hidePopupsAndPreserveSelection(); 
    nativeOnHide(this.mNativeWebContentsAndroid);
  }
  
  public final void onRotationChanged(int paramInt) {
    if (this.mNativeWebContentsAndroid == 0L)
      return; 
    switch (paramInt) {
      default:
        throw new IllegalStateException("Display.getRotation() shouldn't return that value");
      case 3:
        paramInt = -90;
        break;
      case 2:
        paramInt = 180;
        break;
      case 1:
        paramInt = 90;
        break;
      case 0:
        paramInt = 0;
        break;
    } 
    nativeSendOrientationChangeEvent(this.mNativeWebContentsAndroid, paramInt);
  }
  
  public final void onShow() {
    WebContentsAccessibilityImpl webContentsAccessibilityImpl = WebContentsAccessibilityImpl.fromWebContents(this);
    if (webContentsAccessibilityImpl != null)
      webContentsAccessibilityImpl.refreshState(); 
    SelectionPopupControllerImpl selectionPopupControllerImpl = SelectionPopupControllerImpl.fromWebContents(this);
    if (selectionPopupControllerImpl != null)
      selectionPopupControllerImpl.restoreSelectionPopupsIfNecessary(); 
    nativeOnShow(this.mNativeWebContentsAndroid);
  }
  
  public final void onViewFocusChanged(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void onWindowAndroidChanged(WindowAndroid paramWindowAndroid) {}
  
  public final void onWindowFocusChanged(boolean paramBoolean) {}
  
  public final void paste() {
    nativePaste(this.mNativeWebContentsAndroid);
  }
  
  public final void postMessageToFrame(String paramString1, String paramString2, String paramString3, String paramString4, MessagePort[] paramArrayOfMessagePort) {
    if (paramArrayOfMessagePort != null) {
      int j = paramArrayOfMessagePort.length;
      int i = 0;
      while (i < j) {
        MessagePort messagePort = paramArrayOfMessagePort[i];
        if (!messagePort.isClosed() && !messagePort.isTransferred()) {
          if (!messagePort.isStarted()) {
            i++;
            continue;
          } 
          throw new IllegalStateException("Port is already started");
        } 
        throw new IllegalStateException("Port is already closed or transferred");
      } 
    } 
    String str = paramString4;
    if (paramString4.equals("*"))
      str = ""; 
    nativePostMessageToFrame(this.mNativeWebContentsAndroid, paramString1, paramString2, paramString3, str, paramArrayOfMessagePort);
  }
  
  public final void removeObserver(WebContentsObserver paramWebContentsObserver) {
    if (this.mObserverProxy == null)
      return; 
    this.mObserverProxy.mObservers.removeObserver(paramWebContentsObserver);
  }
  
  public final void renderFrameCreated(RenderFrameHostImpl paramRenderFrameHostImpl) {
    assert false;
    throw new AssertionError();
  }
  
  public final void renderFrameDeleted(RenderFrameHostImpl paramRenderFrameHostImpl) {
    assert false;
    throw new AssertionError();
  }
  
  public final void requestSmartClipExtract(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (this.mSmartClipCallback == null)
      return; 
    RenderCoordinatesImpl renderCoordinatesImpl = this.mRenderCoordinates;
    float f = renderCoordinatesImpl.mDeviceScaleFactor;
    int i = (int)renderCoordinatesImpl.mTopContentOffsetYPix;
    nativeRequestSmartClipExtract(this.mNativeWebContentsAndroid, this.mSmartClipCallback, (int)(paramInt1 / f), (int)((paramInt2 - i) / f), (int)(paramInt3 / f), (int)(paramInt4 / f));
  }
  
  public final void scrollFocusedEditableNodeIntoView() {
    nativeScrollFocusedEditableNodeIntoView(this.mNativeWebContentsAndroid);
  }
  
  public final void selectAll() {
    nativeSelectAll(this.mNativeWebContentsAndroid);
  }
  
  public final void setImportance(int paramInt) {
    nativeSetImportance(this.mNativeWebContentsAndroid, paramInt);
  }
  
  public final void setInternalsHolder(WebContents.InternalsHolder paramInternalsHolder) {
    assert false;
    throw new AssertionError();
  }
  
  public final void setSmartClipResultHandler(Handler paramHandler) {
    if (paramHandler == null) {
      this.mSmartClipCallback = null;
      return;
    } 
    this.mSmartClipCallback = new WebContentsImpl$SmartClipCallback(this, paramHandler);
  }
  
  public final void showContextMenuAtTouchHandle(int paramInt1, int paramInt2) {
    nativeShowContextMenuAtTouchHandle(this.mNativeWebContentsAndroid, paramInt1, paramInt2);
  }
  
  public final void stop() {
    nativeStop(this.mNativeWebContentsAndroid);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    Bundle bundle = new Bundle();
    bundle.putLong("version", 0L);
    bundle.putParcelable("processguard", (Parcelable)new ParcelUuid(sParcelableUUID));
    bundle.putLong("webcontents", this.mNativeWebContentsAndroid);
    paramParcel.writeBundle(bundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\webcontents\WebContentsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */