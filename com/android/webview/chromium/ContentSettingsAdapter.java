package com.android.webview.chromium;

import android.os.Build;
import android.webkit.WebSettings;
import org.chromium.android_webview.AwSettings;

public class ContentSettingsAdapter extends WebSettings {
  public AwSettings mAwSettings;
  
  private WebSettings.PluginState mPluginState = WebSettings.PluginState.OFF;
  
  public ContentSettingsAdapter(AwSettings paramAwSettings) {
    this.mAwSettings = paramAwSettings;
  }
  
  public boolean enableSmoothTransition() {
    return false;
  }
  
  public boolean getAcceptThirdPartyCookies() {
    return this.mAwSettings.getAcceptThirdPartyCookies();
  }
  
  public boolean getAllowContentAccess() {
    return this.mAwSettings.getAllowContentAccess();
  }
  
  public boolean getAllowFileAccess() {
    return this.mAwSettings.getAllowFileAccess();
  }
  
  public boolean getAllowFileAccessFromFileURLs() {
    return this.mAwSettings.getAllowFileAccessFromFileURLs();
  }
  
  public boolean getAllowUniversalAccessFromFileURLs() {
    return this.mAwSettings.getAllowUniversalAccessFromFileURLs();
  }
  
  public final AwSettings getAwSettings() {
    return this.mAwSettings;
  }
  
  public boolean getBlockNetworkImage() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getImagesEnabled : ()Z
    //   9: istore_1
    //   10: iload_1
    //   11: ifne -> 20
    //   14: iconst_1
    //   15: istore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: iload_1
    //   19: ireturn
    //   20: iconst_0
    //   21: istore_1
    //   22: goto -> 16
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	25	finally
  }
  
  public boolean getBlockNetworkLoads() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getBlockNetworkLoads : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public boolean getBuiltInZoomControls() {
    return this.mAwSettings.getBuiltInZoomControls();
  }
  
  public int getCacheMode() {
    return this.mAwSettings.getCacheMode();
  }
  
  public String getCursiveFontFamily() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getCursiveFontFamily : ()Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public boolean getDatabaseEnabled() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getDatabaseEnabled : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public String getDatabasePath() {
    /* monitor enter ThisExpression{ObjectType{com/android/webview/chromium/ContentSettingsAdapter}} */
    /* monitor exit ThisExpression{ObjectType{com/android/webview/chromium/ContentSettingsAdapter}} */
    return "";
  }
  
  public int getDefaultFixedFontSize() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getDefaultFixedFontSize : ()I
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public int getDefaultFontSize() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getDefaultFontSize : ()I
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public String getDefaultTextEncodingName() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getDefaultTextEncodingName : ()Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public WebSettings.ZoomDensity getDefaultZoom() {
    return WebSettings.ZoomDensity.MEDIUM;
  }
  
  public int getDisabledActionModeMenuItems() {
    return this.mAwSettings.getDisabledActionModeMenuItems();
  }
  
  public boolean getDisplayZoomControls() {
    return this.mAwSettings.getDisplayZoomControls();
  }
  
  public boolean getDomStorageEnabled() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getDomStorageEnabled : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public String getFantasyFontFamily() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getFantasyFontFamily : ()Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public String getFixedFontFamily() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getFixedFontFamily : ()Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public boolean getJavaScriptCanOpenWindowsAutomatically() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getJavaScriptCanOpenWindowsAutomatically : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public boolean getJavaScriptEnabled() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getJavaScriptEnabled : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public WebSettings.LayoutAlgorithm getLayoutAlgorithm() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getLayoutAlgorithm : ()I
    //   9: istore_1
    //   10: iload_1
    //   11: tableswitch default -> 108, 0 -> 67, 1 -> 59, 2 -> 51, 3 -> 43
    //   40: goto -> 75
    //   43: getstatic android/webkit/WebSettings$LayoutAlgorithm.TEXT_AUTOSIZING : Landroid/webkit/WebSettings$LayoutAlgorithm;
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: areturn
    //   51: getstatic android/webkit/WebSettings$LayoutAlgorithm.NARROW_COLUMNS : Landroid/webkit/WebSettings$LayoutAlgorithm;
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: areturn
    //   59: getstatic android/webkit/WebSettings$LayoutAlgorithm.SINGLE_COLUMN : Landroid/webkit/WebSettings$LayoutAlgorithm;
    //   62: astore_2
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_2
    //   66: areturn
    //   67: getstatic android/webkit/WebSettings$LayoutAlgorithm.NORMAL : Landroid/webkit/WebSettings$LayoutAlgorithm;
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: areturn
    //   75: new java/lang/StringBuilder
    //   78: dup
    //   79: ldc 'Unsupported value: '
    //   81: invokespecial <init> : (Ljava/lang/String;)V
    //   84: astore_2
    //   85: aload_2
    //   86: iload_1
    //   87: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: new java/lang/IllegalArgumentException
    //   94: dup
    //   95: aload_2
    //   96: invokevirtual toString : ()Ljava/lang/String;
    //   99: invokespecial <init> : (Ljava/lang/String;)V
    //   102: athrow
    //   103: astore_2
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_2
    //   107: athrow
    //   108: goto -> 40
    // Exception table:
    //   from	to	target	type
    //   2	10	103	finally
    //   43	47	103	finally
    //   51	55	103	finally
    //   59	63	103	finally
    //   67	71	103	finally
    //   75	103	103	finally
  }
  
  public boolean getLightTouchEnabled() {
    return false;
  }
  
  public boolean getLoadWithOverviewMode() {
    return this.mAwSettings.getLoadWithOverviewMode();
  }
  
  public boolean getLoadsImagesAutomatically() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getLoadsImagesAutomatically : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public boolean getMediaPlaybackRequiresUserGesture() {
    return this.mAwSettings.getMediaPlaybackRequiresUserGesture();
  }
  
  public int getMinimumFontSize() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getMinimumFontSize : ()I
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public int getMinimumLogicalFontSize() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getMinimumLogicalFontSize : ()I
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public int getMixedContentMode() {
    return this.mAwSettings.getMixedContentMode();
  }
  
  @Deprecated
  public boolean getNavDump() {
    return false;
  }
  
  public boolean getOffscreenPreRaster() {
    return this.mAwSettings.getOffscreenPreRaster();
  }
  
  public WebSettings.PluginState getPluginState() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPluginState : Landroid/webkit/WebSettings$PluginState;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public boolean getPluginsEnabled() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mPluginState : Landroid/webkit/WebSettings$PluginState;
    //   6: astore_2
    //   7: getstatic android/webkit/WebSettings$PluginState.ON : Landroid/webkit/WebSettings$PluginState;
    //   10: astore_3
    //   11: aload_2
    //   12: aload_3
    //   13: if_acmpne -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	27	finally
  }
  
  public boolean getSafeBrowsingEnabled() {
    return this.mAwSettings.getSafeBrowsingEnabled();
  }
  
  public String getSansSerifFontFamily() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getSansSerifFontFamily : ()Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public boolean getSaveFormData() {
    return (Build.VERSION.SDK_INT >= 26) ? false : this.mAwSettings.getSaveFormData();
  }
  
  public boolean getSavePassword() {
    return false;
  }
  
  public String getSerifFontFamily() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getSerifFontFamily : ()Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public String getStandardFontFamily() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getStandardFontFamily : ()Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public int getTextZoom() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getTextZoom : ()I
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public boolean getUseWebViewBackgroundForOverscrollBackground() {
    return false;
  }
  
  public boolean getUseWideViewPort() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getUseWideViewPort : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public int getUserAgent() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic getDefaultUserAgent : ()Ljava/lang/String;
    //   5: aload_0
    //   6: invokevirtual getUserAgentString : ()Ljava/lang/String;
    //   9: invokevirtual equals : (Ljava/lang/Object;)Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifeq -> 23
    //   17: iconst_0
    //   18: istore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: iconst_m1
    //   24: istore_1
    //   25: goto -> 19
    //   28: astore_3
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	28	finally
  }
  
  public String getUserAgentString() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual getUserAgentString : ()Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: astore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_1
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public boolean getVideoOverlayForEmbeddedEncryptedVideoEnabled() {
    return false;
  }
  
  public void setAcceptThirdPartyCookies(boolean paramBoolean) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      null.mAcceptThirdPartyCookies = paramBoolean;
      return;
    } 
  }
  
  public void setAllowContentAccess(boolean paramBoolean) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      null.mAllowContentUrlAccess = paramBoolean;
      return;
    } 
  }
  
  public void setAllowFileAccess(boolean paramBoolean) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      null.mAllowFileUrlAccess = paramBoolean;
      return;
    } 
  }
  
  public void setAllowFileAccessFromFileURLs(boolean paramBoolean) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      if (null.mAllowFileAccessFromFileURLs != paramBoolean) {
        null.mAllowFileAccessFromFileURLs = paramBoolean;
        null.mEventHandler.updateWebkitPreferencesLocked();
      } 
      return;
    } 
  }
  
  public void setAllowUniversalAccessFromFileURLs(boolean paramBoolean) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      if (null.mAllowUniversalAccessFromFileURLs != paramBoolean) {
        null.mAllowUniversalAccessFromFileURLs = paramBoolean;
        null.mEventHandler.updateWebkitPreferencesLocked();
      } 
      return;
    } 
  }
  
  public void setAppCacheEnabled(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_3
    //   15: getfield mAppCacheEnabled : Z
    //   18: iload_1
    //   19: if_icmpeq -> 34
    //   22: aload_3
    //   23: iload_1
    //   24: putfield mAppCacheEnabled : Z
    //   27: aload_3
    //   28: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   31: invokevirtual updateWebkitPreferencesLocked : ()V
    //   34: aload_2
    //   35: monitorexit
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_3
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   14	34	39	finally
    //   34	36	39	finally
    //   40	42	39	finally
    //   42	44	44	finally
  }
  
  public void setAppCacheMaxSize(long paramLong) {
    /* monitor enter ThisExpression{ObjectType{com/android/webview/chromium/ContentSettingsAdapter}} */
    /* monitor exit ThisExpression{ObjectType{com/android/webview/chromium/ContentSettingsAdapter}} */
  }
  
  public void setAppCachePath(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore #4
    //   8: iconst_0
    //   9: istore_3
    //   10: getstatic org/chromium/android_webview/AwSettings.sGlobalContentSettingsLock : Ljava/lang/Object;
    //   13: astore #5
    //   15: aload #5
    //   17: monitorenter
    //   18: iload_3
    //   19: istore_2
    //   20: getstatic org/chromium/android_webview/AwSettings.sAppCachePathIsSet : Z
    //   23: ifne -> 47
    //   26: iload_3
    //   27: istore_2
    //   28: aload_1
    //   29: ifnull -> 47
    //   32: iload_3
    //   33: istore_2
    //   34: aload_1
    //   35: invokevirtual isEmpty : ()Z
    //   38: ifne -> 47
    //   41: iconst_1
    //   42: putstatic org/chromium/android_webview/AwSettings.sAppCachePathIsSet : Z
    //   45: iconst_1
    //   46: istore_2
    //   47: aload #5
    //   49: monitorexit
    //   50: iload_2
    //   51: ifeq -> 82
    //   54: aload #4
    //   56: getfield mAwSettingsLock : Ljava/lang/Object;
    //   59: astore_1
    //   60: aload_1
    //   61: monitorenter
    //   62: aload #4
    //   64: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   67: invokevirtual updateWebkitPreferencesLocked : ()V
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore #4
    //   77: aload_1
    //   78: monitorexit
    //   79: aload #4
    //   81: athrow
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: astore_1
    //   86: aload #5
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	91	finally
    //   10	18	91	finally
    //   20	26	85	finally
    //   34	45	85	finally
    //   47	50	85	finally
    //   54	62	91	finally
    //   62	72	75	finally
    //   77	79	75	finally
    //   79	82	91	finally
    //   86	89	85	finally
    //   89	91	91	finally
  }
  
  public void setBlockNetworkImage(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: iload_1
    //   8: iconst_1
    //   9: ixor
    //   10: istore_1
    //   11: aload_3
    //   12: getfield mAwSettingsLock : Ljava/lang/Object;
    //   15: astore_2
    //   16: aload_2
    //   17: monitorenter
    //   18: aload_3
    //   19: getfield mImagesEnabled : Z
    //   22: iload_1
    //   23: if_icmpeq -> 38
    //   26: aload_3
    //   27: iload_1
    //   28: putfield mImagesEnabled : Z
    //   31: aload_3
    //   32: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   35: invokevirtual updateWebkitPreferencesLocked : ()V
    //   38: aload_2
    //   39: monitorexit
    //   40: aload_0
    //   41: monitorexit
    //   42: return
    //   43: astore_3
    //   44: aload_2
    //   45: monitorexit
    //   46: aload_3
    //   47: athrow
    //   48: astore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_2
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	48	finally
    //   11	18	48	finally
    //   18	38	43	finally
    //   38	40	43	finally
    //   44	46	43	finally
    //   46	48	48	finally
  }
  
  public void setBlockNetworkLoads(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: iload_1
    //   15: ifne -> 39
    //   18: aload_3
    //   19: getfield mHasInternetPermission : Z
    //   22: ifeq -> 28
    //   25: goto -> 39
    //   28: new java/lang/SecurityException
    //   31: dup
    //   32: ldc_w 'Permission denied - application missing INTERNET permission'
    //   35: invokespecial <init> : (Ljava/lang/String;)V
    //   38: athrow
    //   39: aload_3
    //   40: iload_1
    //   41: putfield mBlockNetworkLoads : Z
    //   44: aload_2
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_2
    //   50: monitorexit
    //   51: aload_3
    //   52: athrow
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    //   58: astore_3
    //   59: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   2	14	53	finally
    //   18	25	58	finally
    //   28	39	58	finally
    //   39	46	58	finally
    //   49	51	58	finally
    //   51	53	53	finally
  }
  
  public void setBuiltInZoomControls(boolean paramBoolean) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      if (null.mBuiltInZoomControls != paramBoolean) {
        null.mBuiltInZoomControls = paramBoolean;
        null.onGestureZoomSupportChanged(null.supportsDoubleTapZoomLocked(), null.supportsMultiTouchZoomLocked());
      } 
      return;
    } 
  }
  
  public void setCacheMode(int paramInt) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      null.mCacheMode = paramInt;
      return;
    } 
  }
  
  public void setCursiveFontFamily(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_1
    //   15: ifnull -> 44
    //   18: aload_3
    //   19: getfield mCursiveFontFamily : Ljava/lang/String;
    //   22: aload_1
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifne -> 44
    //   29: aload_3
    //   30: aload_1
    //   31: putfield mCursiveFontFamily : Ljava/lang/String;
    //   34: aload_3
    //   35: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   38: invokevirtual updateWebkitPreferencesLocked : ()V
    //   41: goto -> 44
    //   44: aload_2
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_2
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   2	14	53	finally
    //   18	41	58	finally
    //   44	46	58	finally
    //   49	51	58	finally
    //   51	53	53	finally
  }
  
  public void setDatabaseEnabled(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_3
    //   15: getfield mDatabaseEnabled : Z
    //   18: iload_1
    //   19: if_icmpeq -> 34
    //   22: aload_3
    //   23: iload_1
    //   24: putfield mDatabaseEnabled : Z
    //   27: aload_3
    //   28: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   31: invokevirtual updateWebkitPreferencesLocked : ()V
    //   34: aload_2
    //   35: monitorexit
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_3
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   14	34	39	finally
    //   34	36	39	finally
    //   40	42	39	finally
    //   42	44	44	finally
  }
  
  public void setDatabasePath(String paramString) {
    /* monitor enter ThisExpression{ObjectType{com/android/webview/chromium/ContentSettingsAdapter}} */
    /* monitor exit ThisExpression{ObjectType{com/android/webview/chromium/ContentSettingsAdapter}} */
  }
  
  public void setDefaultFixedFontSize(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: iload_1
    //   15: invokestatic clipFontSize : (I)I
    //   18: istore_1
    //   19: aload_3
    //   20: getfield mDefaultFixedFontSize : I
    //   23: iload_1
    //   24: if_icmpeq -> 39
    //   27: aload_3
    //   28: iload_1
    //   29: putfield mDefaultFixedFontSize : I
    //   32: aload_3
    //   33: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   36: invokevirtual updateWebkitPreferencesLocked : ()V
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_3
    //   45: aload_2
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	49	finally
    //   14	39	44	finally
    //   39	41	44	finally
    //   45	47	44	finally
    //   47	49	49	finally
  }
  
  public void setDefaultFontSize(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: iload_1
    //   15: invokestatic clipFontSize : (I)I
    //   18: istore_1
    //   19: aload_3
    //   20: getfield mDefaultFontSize : I
    //   23: iload_1
    //   24: if_icmpeq -> 39
    //   27: aload_3
    //   28: iload_1
    //   29: putfield mDefaultFontSize : I
    //   32: aload_3
    //   33: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   36: invokevirtual updateWebkitPreferencesLocked : ()V
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_3
    //   45: aload_2
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	49	finally
    //   14	39	44	finally
    //   39	41	44	finally
    //   45	47	44	finally
    //   47	49	49	finally
  }
  
  public void setDefaultTextEncodingName(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_1
    //   15: ifnull -> 44
    //   18: aload_3
    //   19: getfield mDefaultTextEncoding : Ljava/lang/String;
    //   22: aload_1
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifne -> 44
    //   29: aload_3
    //   30: aload_1
    //   31: putfield mDefaultTextEncoding : Ljava/lang/String;
    //   34: aload_3
    //   35: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   38: invokevirtual updateWebkitPreferencesLocked : ()V
    //   41: goto -> 44
    //   44: aload_2
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_2
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   2	14	53	finally
    //   18	41	58	finally
    //   44	46	58	finally
    //   49	51	58	finally
    //   51	53	53	finally
  }
  
  public void setDefaultZoom(WebSettings.ZoomDensity paramZoomDensity) {}
  
  public void setDisabledActionModeMenuItems(int paramInt) {
    this.mAwSettings.setDisabledActionModeMenuItems(paramInt);
  }
  
  public void setDisplayZoomControls(boolean paramBoolean) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      null.mDisplayZoomControls = paramBoolean;
      return;
    } 
  }
  
  public void setDomStorageEnabled(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_3
    //   15: getfield mDomStorageEnabled : Z
    //   18: iload_1
    //   19: if_icmpeq -> 34
    //   22: aload_3
    //   23: iload_1
    //   24: putfield mDomStorageEnabled : Z
    //   27: aload_3
    //   28: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   31: invokevirtual updateWebkitPreferencesLocked : ()V
    //   34: aload_2
    //   35: monitorexit
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_3
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   14	34	39	finally
    //   34	36	39	finally
    //   40	42	39	finally
    //   42	44	44	finally
  }
  
  public void setEnableSmoothTransition(boolean paramBoolean) {}
  
  public void setFantasyFontFamily(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_1
    //   15: ifnull -> 44
    //   18: aload_3
    //   19: getfield mFantasyFontFamily : Ljava/lang/String;
    //   22: aload_1
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifne -> 44
    //   29: aload_3
    //   30: aload_1
    //   31: putfield mFantasyFontFamily : Ljava/lang/String;
    //   34: aload_3
    //   35: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   38: invokevirtual updateWebkitPreferencesLocked : ()V
    //   41: goto -> 44
    //   44: aload_2
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_2
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   2	14	53	finally
    //   18	41	58	finally
    //   44	46	58	finally
    //   49	51	58	finally
    //   51	53	53	finally
  }
  
  public void setFixedFontFamily(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_1
    //   15: ifnull -> 44
    //   18: aload_3
    //   19: getfield mFixedFontFamily : Ljava/lang/String;
    //   22: aload_1
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifne -> 44
    //   29: aload_3
    //   30: aload_1
    //   31: putfield mFixedFontFamily : Ljava/lang/String;
    //   34: aload_3
    //   35: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   38: invokevirtual updateWebkitPreferencesLocked : ()V
    //   41: goto -> 44
    //   44: aload_2
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_2
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   2	14	53	finally
    //   18	41	58	finally
    //   44	46	58	finally
    //   49	51	58	finally
    //   51	53	53	finally
  }
  
  public void setGeolocationDatabasePath(String paramString) {
    /* monitor enter ThisExpression{ObjectType{com/android/webview/chromium/ContentSettingsAdapter}} */
    /* monitor exit ThisExpression{ObjectType{com/android/webview/chromium/ContentSettingsAdapter}} */
  }
  
  public void setGeolocationEnabled(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_3
    //   15: iload_1
    //   16: putfield mGeolocationEnabled : Z
    //   19: aload_2
    //   20: monitorexit
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: astore_3
    //   25: aload_2
    //   26: monitorexit
    //   27: aload_3
    //   28: athrow
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
    //   14	21	24	finally
    //   25	27	24	finally
    //   27	29	29	finally
  }
  
  public void setJavaScriptCanOpenWindowsAutomatically(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_3
    //   15: getfield mJavaScriptCanOpenWindowsAutomatically : Z
    //   18: iload_1
    //   19: if_icmpeq -> 34
    //   22: aload_3
    //   23: iload_1
    //   24: putfield mJavaScriptCanOpenWindowsAutomatically : Z
    //   27: aload_3
    //   28: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   31: invokevirtual updateWebkitPreferencesLocked : ()V
    //   34: aload_2
    //   35: monitorexit
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_3
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   14	34	39	finally
    //   34	36	39	finally
    //   40	42	39	finally
    //   42	44	44	finally
  }
  
  public void setJavaScriptEnabled(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_3
    //   15: getfield mJavaScriptEnabled : Z
    //   18: iload_1
    //   19: if_icmpeq -> 34
    //   22: aload_3
    //   23: iload_1
    //   24: putfield mJavaScriptEnabled : Z
    //   27: aload_3
    //   28: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   31: invokevirtual updateWebkitPreferencesLocked : ()V
    //   34: aload_2
    //   35: monitorexit
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_3
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   14	34	39	finally
    //   34	36	39	finally
    //   40	42	39	finally
    //   42	44	44	finally
  }
  
  public void setLayoutAlgorithm(WebSettings.LayoutAlgorithm paramLayoutAlgorithm) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/android/webview/chromium/ContentSettingsAdapter$1.$SwitchMap$android$webkit$WebSettings$LayoutAlgorithm : [I
    //   5: aload_1
    //   6: invokevirtual ordinal : ()I
    //   9: iaload
    //   10: tableswitch default -> 120, 1 -> 76, 2 -> 65, 3 -> 54, 4 -> 43
    //   40: goto -> 87
    //   43: aload_0
    //   44: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   47: iconst_3
    //   48: invokevirtual setLayoutAlgorithm : (I)V
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: aload_0
    //   55: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   58: iconst_2
    //   59: invokevirtual setLayoutAlgorithm : (I)V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: aload_0
    //   66: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   69: iconst_1
    //   70: invokevirtual setLayoutAlgorithm : (I)V
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: aload_0
    //   77: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   80: iconst_0
    //   81: invokevirtual setLayoutAlgorithm : (I)V
    //   84: aload_0
    //   85: monitorexit
    //   86: return
    //   87: new java/lang/StringBuilder
    //   90: dup
    //   91: ldc 'Unsupported value: '
    //   93: invokespecial <init> : (Ljava/lang/String;)V
    //   96: astore_2
    //   97: aload_2
    //   98: aload_1
    //   99: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new java/lang/IllegalArgumentException
    //   106: dup
    //   107: aload_2
    //   108: invokevirtual toString : ()Ljava/lang/String;
    //   111: invokespecial <init> : (Ljava/lang/String;)V
    //   114: athrow
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    //   120: goto -> 40
    // Exception table:
    //   from	to	target	type
    //   2	40	115	finally
    //   43	51	115	finally
    //   54	62	115	finally
    //   65	73	115	finally
    //   76	84	115	finally
    //   87	115	115	finally
  }
  
  public void setLightTouchEnabled(boolean paramBoolean) {}
  
  public void setLoadWithOverviewMode(boolean paramBoolean) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      if (null.mLoadWithOverviewMode != paramBoolean) {
        null.mLoadWithOverviewMode = paramBoolean;
        null.mEventHandler.runOnUiThreadBlockingAndLocked((Runnable)new Object(null));
      } 
      return;
    } 
  }
  
  public void setLoadsImagesAutomatically(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_3
    //   15: getfield mLoadsImagesAutomatically : Z
    //   18: iload_1
    //   19: if_icmpeq -> 34
    //   22: aload_3
    //   23: iload_1
    //   24: putfield mLoadsImagesAutomatically : Z
    //   27: aload_3
    //   28: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   31: invokevirtual updateWebkitPreferencesLocked : ()V
    //   34: aload_2
    //   35: monitorexit
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_3
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   14	34	39	finally
    //   34	36	39	finally
    //   40	42	39	finally
    //   42	44	44	finally
  }
  
  public void setMediaPlaybackRequiresUserGesture(boolean paramBoolean) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      if (null.mMediaPlaybackRequiresUserGesture != paramBoolean) {
        null.mMediaPlaybackRequiresUserGesture = paramBoolean;
        null.mEventHandler.updateWebkitPreferencesLocked();
      } 
      return;
    } 
  }
  
  public void setMinimumFontSize(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: iload_1
    //   15: invokestatic clipFontSize : (I)I
    //   18: istore_1
    //   19: aload_3
    //   20: getfield mMinimumFontSize : I
    //   23: iload_1
    //   24: if_icmpeq -> 39
    //   27: aload_3
    //   28: iload_1
    //   29: putfield mMinimumFontSize : I
    //   32: aload_3
    //   33: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   36: invokevirtual updateWebkitPreferencesLocked : ()V
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_3
    //   45: aload_2
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	49	finally
    //   14	39	44	finally
    //   39	41	44	finally
    //   45	47	44	finally
    //   47	49	49	finally
  }
  
  public void setMinimumLogicalFontSize(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: iload_1
    //   15: invokestatic clipFontSize : (I)I
    //   18: istore_1
    //   19: aload_3
    //   20: getfield mMinimumLogicalFontSize : I
    //   23: iload_1
    //   24: if_icmpeq -> 39
    //   27: aload_3
    //   28: iload_1
    //   29: putfield mMinimumLogicalFontSize : I
    //   32: aload_3
    //   33: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   36: invokevirtual updateWebkitPreferencesLocked : ()V
    //   39: aload_2
    //   40: monitorexit
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_3
    //   45: aload_2
    //   46: monitorexit
    //   47: aload_3
    //   48: athrow
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	49	finally
    //   14	39	44	finally
    //   39	41	44	finally
    //   45	47	44	finally
    //   47	49	49	finally
  }
  
  public void setMixedContentMode(int paramInt) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      if (null.mMixedContentMode != paramInt) {
        null.mMixedContentMode = paramInt;
        null.mEventHandler.updateWebkitPreferencesLocked();
      } 
      return;
    } 
  }
  
  @Deprecated
  public void setNavDump(boolean paramBoolean) {}
  
  public void setNeedInitialFocus(boolean paramBoolean) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      null.mShouldFocusFirstNode = paramBoolean;
      return;
    } 
  }
  
  public void setOffscreenPreRaster(boolean paramBoolean) {
    this.mAwSettings.setOffscreenPreRaster(paramBoolean);
  }
  
  public void setPluginState(WebSettings.PluginState paramPluginState) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: putfield mPluginState : Landroid/webkit/WebSettings$PluginState;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public void setPluginsEnabled(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifeq -> 13
    //   6: getstatic android/webkit/WebSettings$PluginState.ON : Landroid/webkit/WebSettings$PluginState;
    //   9: astore_2
    //   10: goto -> 17
    //   13: getstatic android/webkit/WebSettings$PluginState.OFF : Landroid/webkit/WebSettings$PluginState;
    //   16: astore_2
    //   17: aload_0
    //   18: aload_2
    //   19: putfield mPluginState : Landroid/webkit/WebSettings$PluginState;
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: monitorexit
    //   27: aload_2
    //   28: athrow
    //   29: astore_2
    //   30: goto -> 25
    // Exception table:
    //   from	to	target	type
    //   6	10	29	finally
    //   13	17	29	finally
    //   17	22	29	finally
  }
  
  public void setRenderPriority(WebSettings.RenderPriority paramRenderPriority) {
    /* monitor enter ThisExpression{ObjectType{com/android/webview/chromium/ContentSettingsAdapter}} */
    /* monitor exit ThisExpression{ObjectType{com/android/webview/chromium/ContentSettingsAdapter}} */
  }
  
  public void setSafeBrowsingEnabled(boolean paramBoolean) {
    this.mAwSettings.setSafeBrowsingEnabled(paramBoolean);
  }
  
  public void setSansSerifFontFamily(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_1
    //   15: ifnull -> 44
    //   18: aload_3
    //   19: getfield mSansSerifFontFamily : Ljava/lang/String;
    //   22: aload_1
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifne -> 44
    //   29: aload_3
    //   30: aload_1
    //   31: putfield mSansSerifFontFamily : Ljava/lang/String;
    //   34: aload_3
    //   35: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   38: invokevirtual updateWebkitPreferencesLocked : ()V
    //   41: goto -> 44
    //   44: aload_2
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_2
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   2	14	53	finally
    //   18	41	58	finally
    //   44	46	58	finally
    //   49	51	58	finally
    //   51	53	53	finally
  }
  
  public void setSaveFormData(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 26)
      return; 
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      if (null.mAutoCompleteEnabled != paramBoolean) {
        null.mAutoCompleteEnabled = paramBoolean;
        null.mEventHandler.runOnUiThreadBlockingAndLocked((Runnable)new Object(null));
      } 
      return;
    } 
  }
  
  public void setSavePassword(boolean paramBoolean) {}
  
  public void setSerifFontFamily(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_1
    //   15: ifnull -> 44
    //   18: aload_3
    //   19: getfield mSerifFontFamily : Ljava/lang/String;
    //   22: aload_1
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifne -> 44
    //   29: aload_3
    //   30: aload_1
    //   31: putfield mSerifFontFamily : Ljava/lang/String;
    //   34: aload_3
    //   35: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   38: invokevirtual updateWebkitPreferencesLocked : ()V
    //   41: goto -> 44
    //   44: aload_2
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_2
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   2	14	53	finally
    //   18	41	58	finally
    //   44	46	58	finally
    //   49	51	58	finally
    //   51	53	53	finally
  }
  
  public void setStandardFontFamily(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_1
    //   15: ifnull -> 44
    //   18: aload_3
    //   19: getfield mStandardFontFamily : Ljava/lang/String;
    //   22: aload_1
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifne -> 44
    //   29: aload_3
    //   30: aload_1
    //   31: putfield mStandardFontFamily : Ljava/lang/String;
    //   34: aload_3
    //   35: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   38: invokevirtual updateWebkitPreferencesLocked : ()V
    //   41: goto -> 44
    //   44: aload_2
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: aload_2
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: goto -> 49
    // Exception table:
    //   from	to	target	type
    //   2	14	53	finally
    //   18	41	58	finally
    //   44	46	58	finally
    //   49	51	58	finally
    //   51	53	53	finally
  }
  
  public void setSupportMultipleWindows(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_3
    //   15: getfield mSupportMultipleWindows : Z
    //   18: iload_1
    //   19: if_icmpeq -> 34
    //   22: aload_3
    //   23: iload_1
    //   24: putfield mSupportMultipleWindows : Z
    //   27: aload_3
    //   28: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   31: invokevirtual updateWebkitPreferencesLocked : ()V
    //   34: aload_2
    //   35: monitorexit
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_3
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   14	34	39	finally
    //   34	36	39	finally
    //   40	42	39	finally
    //   42	44	44	finally
  }
  
  public void setSupportZoom(boolean paramBoolean) {
    null = this.mAwSettings;
    synchronized (null.mAwSettingsLock) {
      if (null.mSupportZoom != paramBoolean) {
        null.mSupportZoom = paramBoolean;
        null.onGestureZoomSupportChanged(null.supportsDoubleTapZoomLocked(), null.supportsMultiTouchZoomLocked());
      } 
      return;
    } 
  }
  
  public void setTextZoom(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_3
    //   15: getfield mTextSizePercent : I
    //   18: iload_1
    //   19: if_icmpeq -> 34
    //   22: aload_3
    //   23: iload_1
    //   24: putfield mTextSizePercent : I
    //   27: aload_3
    //   28: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   31: invokevirtual updateWebkitPreferencesLocked : ()V
    //   34: aload_2
    //   35: monitorexit
    //   36: aload_0
    //   37: monitorexit
    //   38: return
    //   39: astore_3
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_3
    //   43: athrow
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   14	34	39	finally
    //   34	36	39	finally
    //   40	42	39	finally
    //   42	44	44	finally
  }
  
  public void setUseWebViewBackgroundForOverscrollBackground(boolean paramBoolean) {}
  
  public void setUseWideViewPort(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_3
    //   7: aload_3
    //   8: getfield mAwSettingsLock : Ljava/lang/Object;
    //   11: astore_2
    //   12: aload_2
    //   13: monitorenter
    //   14: aload_3
    //   15: getfield mUseWideViewport : Z
    //   18: iload_1
    //   19: if_icmpeq -> 46
    //   22: aload_3
    //   23: iload_1
    //   24: putfield mUseWideViewport : Z
    //   27: aload_3
    //   28: aload_3
    //   29: invokevirtual supportsDoubleTapZoomLocked : ()Z
    //   32: aload_3
    //   33: invokevirtual supportsMultiTouchZoomLocked : ()Z
    //   36: invokevirtual onGestureZoomSupportChanged : (ZZ)V
    //   39: aload_3
    //   40: getfield mEventHandler : Lorg/chromium/android_webview/AwSettings$EventHandler;
    //   43: invokevirtual updateWebkitPreferencesLocked : ()V
    //   46: aload_2
    //   47: monitorexit
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: astore_3
    //   52: aload_2
    //   53: monitorexit
    //   54: aload_3
    //   55: athrow
    //   56: astore_2
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_2
    //   60: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	56	finally
    //   14	46	51	finally
    //   46	48	51	finally
    //   52	54	51	finally
    //   54	56	56	finally
  }
  
  public void setUserAgent(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: astore_2
    //   7: iload_1
    //   8: ifne -> 19
    //   11: aload_2
    //   12: aconst_null
    //   13: invokevirtual setUserAgentString : (Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: getstatic org/chromium/android_webview/AwSettings.LOGTAG : Ljava/lang/String;
    //   22: astore_2
    //   23: new java/lang/StringBuilder
    //   26: dup
    //   27: ldc_w 'setUserAgent not supported, ua='
    //   30: invokespecial <init> : (Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: iload_1
    //   36: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_2
    //   41: aload_3
    //   42: invokevirtual toString : ()Ljava/lang/String;
    //   45: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   48: pop
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: astore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	52	finally
    //   11	16	52	finally
    //   19	49	52	finally
  }
  
  public void setUserAgentString(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: aload_1
    //   7: invokevirtual setUserAgentString : (Ljava/lang/String;)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public void setVideoOverlayForEmbeddedEncryptedVideoEnabled(boolean paramBoolean) {}
  
  public boolean supportMultipleWindows() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mAwSettings : Lorg/chromium/android_webview/AwSettings;
    //   6: invokevirtual supportMultipleWindows : ()Z
    //   9: istore_1
    //   10: aload_0
    //   11: monitorexit
    //   12: iload_1
    //   13: ireturn
    //   14: astore_2
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_2
    //   18: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	14	finally
  }
  
  public boolean supportZoom() {
    return this.mAwSettings.supportZoom();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\android\webview\chromium\ContentSettingsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */