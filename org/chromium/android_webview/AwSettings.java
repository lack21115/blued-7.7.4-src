package org.chromium.android_webview;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import org.chromium.base.BuildInfo;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.WebContents;

public class AwSettings {
  public static final String LOGTAG;
  
  public static boolean sAppCachePathIsSet;
  
  public static final Object sGlobalContentSettingsLock;
  
  public boolean mAcceptThirdPartyCookies;
  
  public boolean mAllowContentUrlAccess;
  
  private final boolean mAllowEmptyDocumentPersistence;
  
  public boolean mAllowFileAccessFromFileURLs;
  
  public boolean mAllowFileUrlAccess;
  
  private final boolean mAllowGeolocationOnInsecureOrigins;
  
  public boolean mAllowUniversalAccessFromFileURLs;
  
  public boolean mAppCacheEnabled;
  
  public boolean mAutoCompleteEnabled;
  
  public final Object mAwSettingsLock;
  
  public boolean mBlockNetworkLoads;
  
  public boolean mBuiltInZoomControls;
  
  public boolean mCSSHexAlphaColorEnabled;
  
  public int mCacheMode;
  
  public String mCursiveFontFamily;
  
  double mDIPScale;
  
  public boolean mDatabaseEnabled;
  
  public int mDefaultFixedFontSize;
  
  public int mDefaultFontSize;
  
  public String mDefaultTextEncoding;
  
  String mDefaultVideoPosterURL;
  
  private int mDisabledMenuItems;
  
  public boolean mDisplayZoomControls;
  
  private final boolean mDoNotUpdateSelectionOnMutatingSelectionRange;
  
  public boolean mDomStorageEnabled;
  
  boolean mEnableSupportedHardwareAcceleratedFeatures;
  
  public final AwSettings$EventHandler mEventHandler;
  
  public String mFantasyFontFamily;
  
  public String mFixedFontFamily;
  
  boolean mForceZeroLayoutHeight;
  
  public boolean mFullscreenSupported;
  
  public boolean mGeolocationEnabled;
  
  public final boolean mHasInternetPermission;
  
  public boolean mImagesEnabled;
  
  public float mInitialPageScalePercent;
  
  public boolean mJavaScriptCanOpenWindowsAutomatically;
  
  public boolean mJavaScriptEnabled;
  
  private int mLayoutAlgorithm;
  
  public boolean mLoadWithOverviewMode;
  
  public boolean mLoadsImagesAutomatically;
  
  public boolean mMediaPlaybackRequiresUserGesture;
  
  public int mMinimumFontSize;
  
  public int mMinimumLogicalFontSize;
  
  public int mMixedContentMode;
  
  long mNativeAwSettings;
  
  private boolean mOffscreenPreRaster;
  
  private final boolean mPasswordEchoEnabled;
  
  private Boolean mSafeBrowsingEnabled;
  
  public String mSansSerifFontFamily;
  
  public boolean mScrollTopLeftInteropEnabled;
  
  public String mSerifFontFamily;
  
  public boolean mShouldFocusFirstNode;
  
  private boolean mSpatialNavigationEnabled;
  
  public String mStandardFontFamily;
  
  private final boolean mSupportLegacyQuirks;
  
  public boolean mSupportMultipleWindows;
  
  public boolean mSupportZoom;
  
  public int mTextSizePercent;
  
  public boolean mUseWideViewport;
  
  private String mUserAgent;
  
  public boolean mZeroLayoutHeightDisablesViewportQuirk;
  
  AwSettings$ZoomSupportChangeListener mZoomChangeListener;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public AwSettings(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {
    boolean bool1;
    this.mDIPScale = 1.0D;
    this.mAwSettingsLock = new Object();
    this.mLayoutAlgorithm = 2;
    this.mTextSizePercent = 100;
    this.mStandardFontFamily = "sans-serif";
    this.mFixedFontFamily = "monospace";
    this.mSansSerifFontFamily = "sans-serif";
    this.mSerifFontFamily = "serif";
    this.mCursiveFontFamily = "cursive";
    this.mFantasyFontFamily = "fantasy";
    this.mDefaultTextEncoding = "UTF-8";
    this.mMinimumFontSize = 8;
    this.mMinimumLogicalFontSize = 8;
    this.mDefaultFontSize = 16;
    this.mDefaultFixedFontSize = 13;
    boolean bool2 = true;
    this.mLoadsImagesAutomatically = true;
    this.mImagesEnabled = true;
    this.mMediaPlaybackRequiresUserGesture = true;
    this.mMixedContentMode = 1;
    this.mCSSHexAlphaColorEnabled = false;
    this.mScrollTopLeftInteropEnabled = false;
    this.mDisabledMenuItems = 0;
    this.mAllowContentUrlAccess = true;
    this.mAllowFileUrlAccess = true;
    this.mCacheMode = -1;
    this.mShouldFocusFirstNode = true;
    this.mGeolocationEnabled = true;
    if (Build.VERSION.SDK_INT < 26) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.mAutoCompleteEnabled = bool1;
    this.mSupportZoom = true;
    this.mDisplayZoomControls = true;
    if (paramContext.checkPermission("android.permission.INTERNET", Process.myPid(), Process.myUid()) == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    synchronized (this.mAwSettingsLock) {
      this.mHasInternetPermission = bool1;
      this.mBlockNetworkLoads = bool1 ^ true;
      this.mEventHandler = new AwSettings$EventHandler(this);
      if (paramBoolean1) {
        this.mAllowUniversalAccessFromFileURLs = true;
        this.mAllowFileAccessFromFileURLs = true;
      } 
      this.mUserAgent = AwSettings$LazyDefaultUserAgent.access$500();
      this.mSpatialNavigationEnabled = paramContext.getPackageManager().hasSystemFeature("android.hardware.touchscreen") ^ true;
      if (Settings.System.getInt(paramContext.getContentResolver(), "show_password", 1) == 1) {
        paramBoolean1 = bool2;
      } else {
        paramBoolean1 = false;
      } 
      this.mPasswordEchoEnabled = paramBoolean1;
      this.mTextSizePercent = (int)(this.mTextSizePercent * (paramContext.getResources().getConfiguration()).fontScale);
      this.mSupportLegacyQuirks = paramBoolean2;
      this.mAllowEmptyDocumentPersistence = paramBoolean3;
      this.mAllowGeolocationOnInsecureOrigins = paramBoolean4;
      this.mDoNotUpdateSelectionOnMutatingSelectionRange = paramBoolean5;
      return;
    } 
  }
  
  public static int clipFontSize(int paramInt) {
    return (paramInt <= 0) ? 1 : ((paramInt > 72) ? 72 : paramInt);
  }
  
  @CalledByNative
  private boolean getAllowEmptyDocumentPersistenceLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getAllowFileAccessFromFileURLsLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getAllowGeolocationOnInsecureOrigins() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getAllowRunningInsecureContentLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private static boolean getAllowSniffingFileUrls() {
    return !BuildInfo.targetsAtLeastP();
  }
  
  @CalledByNative
  private boolean getAllowUniversalAccessFromFileURLsLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getAppCacheEnabledLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getCSSHexAlphaColorEnabledLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private String getCursiveFontFamilyLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private double getDIPScaleLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getDatabaseEnabledLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private int getDefaultFixedFontSizeLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private int getDefaultFontSizeLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private String getDefaultTextEncodingLocked() {
    assert false;
    throw new AssertionError();
  }
  
  public static String getDefaultUserAgent() {
    return AwSettings$LazyDefaultUserAgent.access$500();
  }
  
  @CalledByNative
  private String getDefaultVideoPosterURLLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getDoNotUpdateSelectionOnMutatingSelectionRange() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getDomStorageEnabledLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getEnableSupportedHardwareAcceleratedFeaturesLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private String getFantasyFontFamilyLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private String getFixedFontFamilyLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getForceZeroLayoutHeightLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getFullscreenSupportedLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getImagesEnabledLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private float getInitialPageScalePercentLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getJavaScriptCanOpenWindowsAutomaticallyLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getJavaScriptEnabledLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getLoadWithOverviewModeLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getLoadsImagesAutomaticallyLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getMediaPlaybackRequiresUserGestureLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private int getMinimumFontSizeLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private int getMinimumLogicalFontSizeLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getOffscreenPreRasterLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getPasswordEchoEnabledLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getRecordFullDocument() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private String getSansSerifFontFamilyLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getSaveFormDataLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getScrollTopLeftInteropEnabledLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private String getSerifFontFamilyLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getSpatialNavigationLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private String getStandardFontFamilyLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getSupportLegacyQuirksLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getSupportMultipleWindowsLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getTextAutosizingEnabledLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private int getTextSizePercentLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getUseStricMixedContentCheckingLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getUseWideViewportLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private String getUserAgentLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private boolean getZeroLayoutHeightDisablesViewportQuirkLocked() {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void nativeAwSettingsGone(long paramLong) {
    assert false;
    throw new AssertionError();
  }
  
  private static native String nativeGetDefaultUserAgent();
  
  private native void nativePopulateWebPreferencesLocked(long paramLong1, long paramLong2);
  
  private native void nativeUpdateEverythingLocked(long paramLong);
  
  private native void nativeUpdateWebkitPreferencesLocked(long paramLong);
  
  @CalledByNative
  private void populateWebPreferences(long paramLong) {
    synchronized (this.mAwSettingsLock) {
      assert false;
      throw new AssertionError();
    } 
  }
  
  @CalledByNative
  private void updateEverything() {
    synchronized (this.mAwSettingsLock) {
      updateEverythingLocked();
      return;
    } 
  }
  
  public final boolean getAcceptThirdPartyCookies() {
    synchronized (this.mAwSettingsLock) {
      return this.mAcceptThirdPartyCookies;
    } 
  }
  
  public final boolean getAllowContentAccess() {
    synchronized (this.mAwSettingsLock) {
      return this.mAllowContentUrlAccess;
    } 
  }
  
  public final boolean getAllowFileAccess() {
    synchronized (this.mAwSettingsLock) {
      return this.mAllowFileUrlAccess;
    } 
  }
  
  public final boolean getAllowFileAccessFromFileURLs() {
    synchronized (this.mAwSettingsLock) {
      return getAllowFileAccessFromFileURLsLocked();
    } 
  }
  
  public final boolean getAllowUniversalAccessFromFileURLs() {
    synchronized (this.mAwSettingsLock) {
      return getAllowUniversalAccessFromFileURLsLocked();
    } 
  }
  
  public final boolean getBlockNetworkLoads() {
    synchronized (this.mAwSettingsLock) {
      return this.mBlockNetworkLoads;
    } 
  }
  
  public final boolean getBuiltInZoomControls() {
    synchronized (this.mAwSettingsLock) {
      return this.mBuiltInZoomControls;
    } 
  }
  
  public final int getCacheMode() {
    synchronized (this.mAwSettingsLock) {
      return this.mCacheMode;
    } 
  }
  
  public final String getCursiveFontFamily() {
    synchronized (this.mAwSettingsLock) {
      return getCursiveFontFamilyLocked();
    } 
  }
  
  public final boolean getDatabaseEnabled() {
    synchronized (this.mAwSettingsLock) {
      return this.mDatabaseEnabled;
    } 
  }
  
  public final int getDefaultFixedFontSize() {
    synchronized (this.mAwSettingsLock) {
      return getDefaultFixedFontSizeLocked();
    } 
  }
  
  public final int getDefaultFontSize() {
    synchronized (this.mAwSettingsLock) {
      return getDefaultFontSizeLocked();
    } 
  }
  
  public final String getDefaultTextEncodingName() {
    synchronized (this.mAwSettingsLock) {
      return getDefaultTextEncodingLocked();
    } 
  }
  
  public final int getDisabledActionModeMenuItems() {
    synchronized (this.mAwSettingsLock) {
      return this.mDisabledMenuItems;
    } 
  }
  
  public final boolean getDisplayZoomControls() {
    synchronized (this.mAwSettingsLock) {
      return this.mDisplayZoomControls;
    } 
  }
  
  public final boolean getDomStorageEnabled() {
    synchronized (this.mAwSettingsLock) {
      return this.mDomStorageEnabled;
    } 
  }
  
  public final String getFantasyFontFamily() {
    synchronized (this.mAwSettingsLock) {
      return getFantasyFontFamilyLocked();
    } 
  }
  
  public final String getFixedFontFamily() {
    synchronized (this.mAwSettingsLock) {
      return getFixedFontFamilyLocked();
    } 
  }
  
  final boolean getGeolocationEnabled() {
    synchronized (this.mAwSettingsLock) {
      return this.mGeolocationEnabled;
    } 
  }
  
  public final boolean getImagesEnabled() {
    synchronized (this.mAwSettingsLock) {
      return this.mImagesEnabled;
    } 
  }
  
  public final boolean getJavaScriptCanOpenWindowsAutomatically() {
    synchronized (this.mAwSettingsLock) {
      return getJavaScriptCanOpenWindowsAutomaticallyLocked();
    } 
  }
  
  public final boolean getJavaScriptEnabled() {
    synchronized (this.mAwSettingsLock) {
      return this.mJavaScriptEnabled;
    } 
  }
  
  public final int getLayoutAlgorithm() {
    synchronized (this.mAwSettingsLock) {
      return this.mLayoutAlgorithm;
    } 
  }
  
  public final boolean getLoadWithOverviewMode() {
    synchronized (this.mAwSettingsLock) {
      return getLoadWithOverviewModeLocked();
    } 
  }
  
  public final boolean getLoadsImagesAutomatically() {
    synchronized (this.mAwSettingsLock) {
      return getLoadsImagesAutomaticallyLocked();
    } 
  }
  
  public final boolean getMediaPlaybackRequiresUserGesture() {
    synchronized (this.mAwSettingsLock) {
      return getMediaPlaybackRequiresUserGestureLocked();
    } 
  }
  
  public final int getMinimumFontSize() {
    synchronized (this.mAwSettingsLock) {
      return getMinimumFontSizeLocked();
    } 
  }
  
  public final int getMinimumLogicalFontSize() {
    synchronized (this.mAwSettingsLock) {
      return getMinimumLogicalFontSizeLocked();
    } 
  }
  
  public final int getMixedContentMode() {
    synchronized (this.mAwSettingsLock) {
      return this.mMixedContentMode;
    } 
  }
  
  public final boolean getOffscreenPreRaster() {
    synchronized (this.mAwSettingsLock) {
      return getOffscreenPreRasterLocked();
    } 
  }
  
  public final boolean getSafeBrowsingEnabled() {
    synchronized (this.mAwSettingsLock) {
      Boolean bool = AwSafeBrowsingConfigHelper.sSafeBrowsingUserOptIn;
      if (bool != null && !bool.booleanValue())
        return false; 
      if (this.mSafeBrowsingEnabled == null)
        return AwSafeBrowsingConfigHelper.sEnabledByManifest; 
      return this.mSafeBrowsingEnabled.booleanValue();
    } 
  }
  
  public final String getSansSerifFontFamily() {
    synchronized (this.mAwSettingsLock) {
      return getSansSerifFontFamilyLocked();
    } 
  }
  
  public final boolean getSaveFormData() {
    synchronized (this.mAwSettingsLock) {
      return getSaveFormDataLocked();
    } 
  }
  
  public final String getSerifFontFamily() {
    synchronized (this.mAwSettingsLock) {
      return getSerifFontFamilyLocked();
    } 
  }
  
  public final String getStandardFontFamily() {
    synchronized (this.mAwSettingsLock) {
      return getStandardFontFamilyLocked();
    } 
  }
  
  public final int getTextZoom() {
    synchronized (this.mAwSettingsLock) {
      return getTextSizePercentLocked();
    } 
  }
  
  public final boolean getUseWideViewPort() {
    synchronized (this.mAwSettingsLock) {
      return getUseWideViewportLocked();
    } 
  }
  
  public final String getUserAgentString() {
    synchronized (this.mAwSettingsLock) {
      return getUserAgentLocked();
    } 
  }
  
  native void nativeDestroy(long paramLong);
  
  native long nativeInit(WebContents paramWebContents);
  
  native void nativeResetScrollAndScaleState(long paramLong);
  
  native void nativeUpdateFormDataPreferencesLocked(long paramLong);
  
  native void nativeUpdateInitialPageScaleLocked(long paramLong);
  
  native void nativeUpdateOffscreenPreRasterLocked(long paramLong);
  
  native void nativeUpdateRendererPreferencesLocked(long paramLong);
  
  native void nativeUpdateUserAgentLocked(long paramLong);
  
  public final void onGestureZoomSupportChanged(boolean paramBoolean1, boolean paramBoolean2) {
    AwSettings$EventHandler awSettings$EventHandler = this.mEventHandler;
    AwSettings$$Lambda$4 awSettings$$Lambda$4 = new AwSettings$$Lambda$4(this, paramBoolean1, paramBoolean2);
    if (awSettings$EventHandler.mHandler != null)
      awSettings$EventHandler.mHandler.post(awSettings$$Lambda$4); 
  }
  
  public final void setDisabledActionModeMenuItems(int paramInt) {
    synchronized (this.mAwSettingsLock) {
      this.mDisabledMenuItems = paramInt;
      return;
    } 
  }
  
  public final void setLayoutAlgorithm(int paramInt) {
    synchronized (this.mAwSettingsLock) {
      if (this.mLayoutAlgorithm != paramInt) {
        this.mLayoutAlgorithm = paramInt;
        this.mEventHandler.updateWebkitPreferencesLocked();
      } 
      return;
    } 
  }
  
  public final void setOffscreenPreRaster(boolean paramBoolean) {
    synchronized (this.mAwSettingsLock) {
      if (paramBoolean != this.mOffscreenPreRaster) {
        this.mOffscreenPreRaster = paramBoolean;
        this.mEventHandler.runOnUiThreadBlockingAndLocked(new AwSettings$$Lambda$5(this));
      } 
      return;
    } 
  }
  
  public final void setSafeBrowsingEnabled(boolean paramBoolean) {
    synchronized (this.mAwSettingsLock) {
      this.mSafeBrowsingEnabled = Boolean.valueOf(paramBoolean);
      return;
    } 
  }
  
  final void setSpatialNavigationEnabled(boolean paramBoolean) {
    synchronized (this.mAwSettingsLock) {
      if (this.mSpatialNavigationEnabled != paramBoolean) {
        this.mSpatialNavigationEnabled = paramBoolean;
        this.mEventHandler.updateWebkitPreferencesLocked();
      } 
      return;
    } 
  }
  
  public final void setUserAgentString(String paramString) {
    synchronized (this.mAwSettingsLock) {
      String str = this.mUserAgent;
      if (paramString == null || paramString.length() == 0) {
        this.mUserAgent = AwSettings$LazyDefaultUserAgent.access$500();
      } else {
        this.mUserAgent = paramString;
      } 
      if (!str.equals(this.mUserAgent))
        this.mEventHandler.runOnUiThreadBlockingAndLocked(new AwSettings$$Lambda$2(this)); 
      return;
    } 
  }
  
  final boolean shouldDisplayZoomControls() {
    synchronized (this.mAwSettingsLock) {
      if (supportsMultiTouchZoomLocked() && this.mDisplayZoomControls)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  public final boolean shouldFocusFirstNode() {
    synchronized (this.mAwSettingsLock) {
      return this.mShouldFocusFirstNode;
    } 
  }
  
  public final boolean supportMultipleWindows() {
    synchronized (this.mAwSettingsLock) {
      return this.mSupportMultipleWindows;
    } 
  }
  
  public final boolean supportZoom() {
    synchronized (this.mAwSettingsLock) {
      return this.mSupportZoom;
    } 
  }
  
  @CalledByNative
  public boolean supportsDoubleTapZoomLocked() {
    assert false;
    throw new AssertionError();
  }
  
  public final boolean supportsMultiTouchZoomLocked() {
    assert false;
    throw new AssertionError();
  }
  
  public final void updateAcceptLanguages() {
    synchronized (this.mAwSettingsLock) {
      this.mEventHandler.runOnUiThreadBlockingAndLocked(new AwSettings$$Lambda$6(this));
      return;
    } 
  }
  
  final void updateEverythingLocked() {
    assert false;
    throw new AssertionError();
  }
  
  final void updateWebkitPreferencesOnUiThreadLocked() {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */