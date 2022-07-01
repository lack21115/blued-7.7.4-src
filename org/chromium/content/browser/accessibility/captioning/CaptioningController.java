package org.chromium.content.browser.accessibility.captioning;

import android.annotation.TargetApi;
import android.os.Build;
import java.util.Objects;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.WebContents;

public class CaptioningController implements SystemCaptioningBridge$SystemCaptioningBridgeListener {
  private long mNativeCaptioningController;
  
  public SystemCaptioningBridge mSystemCaptioningBridge;
  
  public CaptioningController(WebContents paramWebContents) {
    EmptyCaptioningBridge emptyCaptioningBridge;
    if (Build.VERSION.SDK_INT >= 19) {
      if (KitKatCaptioningBridge.sKitKatCaptioningBridge == null)
        KitKatCaptioningBridge.sKitKatCaptioningBridge = new KitKatCaptioningBridge(); 
      KitKatCaptioningBridge kitKatCaptioningBridge = KitKatCaptioningBridge.sKitKatCaptioningBridge;
    } else {
      emptyCaptioningBridge = new EmptyCaptioningBridge();
    } 
    this.mSystemCaptioningBridge = emptyCaptioningBridge;
    this.mNativeCaptioningController = nativeInit(paramWebContents);
  }
  
  private native long nativeInit(WebContents paramWebContents);
  
  private native void nativeSetTextTrackSettings(long paramLong, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  @CalledByNative
  private void onDestroy() {
    this.mNativeCaptioningController = 0L;
  }
  
  @CalledByNative
  private void onRenderProcessChange() {
    this.mSystemCaptioningBridge.syncToListener(this);
  }
  
  @TargetApi(19)
  public final void onSystemCaptioningChanged(TextTrackSettings paramTextTrackSettings) {
    if (this.mNativeCaptioningController == 0L)
      return; 
    nativeSetTextTrackSettings(this.mNativeCaptioningController, paramTextTrackSettings.mTextTracksEnabled, Objects.toString(paramTextTrackSettings.mTextTrackBackgroundColor, ""), Objects.toString(paramTextTrackSettings.mTextTrackFontFamily, ""), Objects.toString(paramTextTrackSettings.mTextTrackFontStyle, ""), Objects.toString(paramTextTrackSettings.mTextTrackFontVariant, ""), Objects.toString(paramTextTrackSettings.mTextTrackTextColor, ""), Objects.toString(paramTextTrackSettings.mTextTrackTextShadow, ""), Objects.toString(paramTextTrackSettings.mTextTrackTextSize, ""));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\accessibility\captioning\CaptioningController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */