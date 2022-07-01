package org.chromium.content.browser.framehost;

import android.graphics.Bitmap;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.LoadUrlParams;
import org.chromium.content_public.browser.NavigationController;
import org.chromium.content_public.browser.NavigationEntry;
import org.chromium.content_public.browser.NavigationHistory;
import org.chromium.content_public.common.ResourceRequestBody;

class NavigationControllerImpl implements NavigationController {
  private long mNativeNavigationControllerAndroid;
  
  private NavigationControllerImpl(long paramLong) {
    this.mNativeNavigationControllerAndroid = paramLong;
  }
  
  @CalledByNative
  private static void addToNavigationHistory(Object paramObject1, Object paramObject2) {
    paramObject1 = paramObject1;
    paramObject2 = paramObject2;
    ((NavigationHistory)paramObject1).mEntries.add(paramObject2);
  }
  
  @CalledByNative
  private static NavigationControllerImpl create(long paramLong) {
    return new NavigationControllerImpl(paramLong);
  }
  
  @CalledByNative
  private static NavigationEntry createNavigationEntry(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap, int paramInt2) {
    return new NavigationEntry(paramString1, paramString3, paramString4, paramBitmap);
  }
  
  @CalledByNative
  private void destroy() {
    this.mNativeNavigationControllerAndroid = 0L;
  }
  
  private native boolean nativeCanCopyStateOver(long paramLong);
  
  private native boolean nativeCanGoBack(long paramLong);
  
  private native boolean nativeCanGoForward(long paramLong);
  
  private native boolean nativeCanGoToOffset(long paramLong, int paramInt);
  
  private native boolean nativeCanPruneAllButLastCommitted(long paramLong);
  
  private native void nativeCancelPendingReload(long paramLong);
  
  private native void nativeClearHistory(long paramLong);
  
  private native void nativeClearSslPreferences(long paramLong);
  
  private native void nativeContinuePendingReload(long paramLong);
  
  private native void nativeCopyStateFrom(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private native void nativeCopyStateFromAndPrune(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private native void nativeGetDirectedNavigationHistory(long paramLong, NavigationHistory paramNavigationHistory, boolean paramBoolean, int paramInt);
  
  private native NavigationEntry nativeGetEntryAtIndex(long paramLong, int paramInt);
  
  private native String nativeGetEntryExtraData(long paramLong, int paramInt, String paramString);
  
  private native int nativeGetLastCommittedEntryIndex(long paramLong);
  
  private native int nativeGetNavigationHistory(long paramLong, Object paramObject);
  
  private native String nativeGetOriginalUrlForVisibleNavigationEntry(long paramLong);
  
  private native NavigationEntry nativeGetPendingEntry(long paramLong);
  
  private native boolean nativeGetUseDesktopUserAgent(long paramLong);
  
  private native void nativeGoBack(long paramLong);
  
  private native void nativeGoForward(long paramLong);
  
  private native void nativeGoToNavigationIndex(long paramLong, int paramInt);
  
  private native void nativeGoToOffset(long paramLong, int paramInt);
  
  private native boolean nativeIsInitialNavigation(long paramLong);
  
  private native void nativeLoadIfNecessary(long paramLong);
  
  private native void nativeLoadUrl(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, int paramInt4, String paramString3, ResourceRequestBody paramResourceRequestBody, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  private native boolean nativeNeedsReload(long paramLong);
  
  private native void nativeReload(long paramLong, boolean paramBoolean);
  
  private native void nativeReloadBypassingCache(long paramLong, boolean paramBoolean);
  
  private native boolean nativeRemoveEntryAtIndex(long paramLong, int paramInt);
  
  private native void nativeSetEntryExtraData(long paramLong, int paramInt, String paramString1, String paramString2);
  
  private native void nativeSetNeedsReload(long paramLong);
  
  private native void nativeSetUseDesktopUserAgent(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  public final boolean canGoBack() {
    return (this.mNativeNavigationControllerAndroid != 0L && nativeCanGoBack(this.mNativeNavigationControllerAndroid));
  }
  
  public final boolean canGoForward() {
    return (this.mNativeNavigationControllerAndroid != 0L && nativeCanGoForward(this.mNativeNavigationControllerAndroid));
  }
  
  public final boolean canGoToOffset(int paramInt) {
    return (this.mNativeNavigationControllerAndroid != 0L && nativeCanGoToOffset(this.mNativeNavigationControllerAndroid, paramInt));
  }
  
  public final void cancelPendingReload() {
    if (this.mNativeNavigationControllerAndroid != 0L)
      nativeCancelPendingReload(this.mNativeNavigationControllerAndroid); 
  }
  
  public final void clearHistory() {
    if (this.mNativeNavigationControllerAndroid != 0L)
      nativeClearHistory(this.mNativeNavigationControllerAndroid); 
  }
  
  public final void clearSslPreferences() {
    if (this.mNativeNavigationControllerAndroid != 0L)
      nativeClearSslPreferences(this.mNativeNavigationControllerAndroid); 
  }
  
  public final void continuePendingReload() {
    if (this.mNativeNavigationControllerAndroid != 0L)
      nativeContinuePendingReload(this.mNativeNavigationControllerAndroid); 
  }
  
  public final NavigationHistory getNavigationHistory() {
    if (this.mNativeNavigationControllerAndroid == 0L)
      return null; 
    NavigationHistory navigationHistory = new NavigationHistory();
    navigationHistory.mCurrentEntryIndex = nativeGetNavigationHistory(this.mNativeNavigationControllerAndroid, navigationHistory);
    return navigationHistory;
  }
  
  public final void goBack() {
    if (this.mNativeNavigationControllerAndroid != 0L)
      nativeGoBack(this.mNativeNavigationControllerAndroid); 
  }
  
  public final void goForward() {
    if (this.mNativeNavigationControllerAndroid != 0L)
      nativeGoForward(this.mNativeNavigationControllerAndroid); 
  }
  
  public final void goToOffset(int paramInt) {
    if (this.mNativeNavigationControllerAndroid != 0L)
      nativeGoToOffset(this.mNativeNavigationControllerAndroid, paramInt); 
  }
  
  public final void loadUrl(LoadUrlParams paramLoadUrlParams) {
    if (this.mNativeNavigationControllerAndroid != 0L) {
      boolean bool;
      String str1;
      long l = this.mNativeNavigationControllerAndroid;
      String str2 = paramLoadUrlParams.mUrl;
      int i = paramLoadUrlParams.mLoadUrlType;
      int j = paramLoadUrlParams.mTransitionType;
      if (paramLoadUrlParams.mReferrer != null) {
        str1 = paramLoadUrlParams.mReferrer.mUrl;
      } else {
        str1 = null;
      } 
      if (paramLoadUrlParams.mReferrer != null) {
        bool = paramLoadUrlParams.mReferrer.mPolicy;
      } else {
        bool = false;
      } 
      nativeLoadUrl(l, str2, i, j, str1, bool, paramLoadUrlParams.mUaOverrideOption, paramLoadUrlParams.getExtraHeadersString("\n", false), paramLoadUrlParams.mPostData, paramLoadUrlParams.mBaseUrlForDataUrl, paramLoadUrlParams.mVirtualUrlForDataUrl, paramLoadUrlParams.mDataUrlAsString, paramLoadUrlParams.mCanLoadLocalResources, paramLoadUrlParams.mIsRendererInitiated, paramLoadUrlParams.mShouldReplaceCurrentEntry);
    } 
  }
  
  public final void reload(boolean paramBoolean) {
    if (this.mNativeNavigationControllerAndroid != 0L)
      nativeReload(this.mNativeNavigationControllerAndroid, paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\framehost\NavigationControllerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */