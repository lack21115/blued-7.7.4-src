package org.chromium.content.browser;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.os.Build;
import android.view.KeyEvent;
import android.view.ViewGroup;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content_public.browser.ImeEventObserver;
import org.chromium.content_public.browser.WebContents;

public class TapDisambiguator implements PopupController$HideablePopup, ImeEventObserver {
  private boolean mInitialized;
  
  private long mNativeTapDisambiguator;
  
  PopupZoomer mPopupView;
  
  private final WebContents mWebContents;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public TapDisambiguator(WebContents paramWebContents) {
    this.mWebContents = paramWebContents;
  }
  
  public static TapDisambiguator create(Context paramContext, WebContents paramWebContents, ViewGroup paramViewGroup) {
    TapDisambiguator tapDisambiguator = (TapDisambiguator)paramWebContents.getOrSetUserData(TapDisambiguator.class, TapDisambiguator$UserDataFactoryLazyHolder.access$000());
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private static Rect createRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @CalledByNative
  private void destroy() {
    this.mNativeTapDisambiguator = 0L;
  }
  
  public static TapDisambiguator fromWebContents(WebContents paramWebContents) {
    return (TapDisambiguator)paramWebContents.getOrSetUserData(TapDisambiguator.class, null);
  }
  
  @CalledByNative
  private void hidePopup() {
    hidePopup(false);
  }
  
  private native long nativeInit(WebContents paramWebContents);
  
  private native void nativeResolveTapDisambiguation(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  @CalledByNative
  private void showPopup(Rect paramRect, Bitmap paramBitmap) {
    PopupZoomer popupZoomer2 = this.mPopupView;
    if (popupZoomer2.mZoomedBitmap != null) {
      popupZoomer2.mZoomedBitmap.recycle();
      popupZoomer2.mZoomedBitmap = null;
    } 
    popupZoomer2.mZoomedBitmap = paramBitmap;
    Canvas canvas = new Canvas(popupZoomer2.mZoomedBitmap);
    Path path = new Path();
    RectF rectF = new RectF(0.0F, 0.0F, canvas.getWidth(), canvas.getHeight());
    float f = PopupZoomer.getOverlayCornerRadius(popupZoomer2.getContext());
    path.addRoundRect(rectF, f, f, Path.Direction.CCW);
    if (Build.VERSION.SDK_INT >= 26) {
      canvas.clipOutPath(path);
    } else {
      canvas.clipPath(path, Region.Op.DIFFERENCE);
    } 
    Paint paint = new Paint();
    paint.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.SRC));
    paint.setColor(0);
    canvas.drawPaint(paint);
    PopupZoomer popupZoomer1 = this.mPopupView;
    if (popupZoomer1.mShowing || popupZoomer1.mZoomedBitmap == null)
      throw new VerifyError("bad dex opcode"); 
    popupZoomer1.mTargetBounds = paramRect;
    popupZoomer1.startAnimation(true);
    throw new VerifyError("bad dex opcode");
  }
  
  public final void hide() {
    hidePopup(false);
  }
  
  public final void hidePopup(boolean paramBoolean) {
    PopupZoomer popupZoomer = this.mPopupView;
    if (popupZoomer.mShowing) {
      PopupZoomer.recordHistogram(0);
      if (paramBoolean) {
        popupZoomer.startAnimation(false);
        return;
      } 
      popupZoomer.hideImmediately();
    } 
  }
  
  public final void onBeforeSendKeyEvent(KeyEvent paramKeyEvent) {}
  
  public final void onImeEvent() {
    hidePopup(true);
  }
  
  public final void onNodeAttributeUpdated(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\TapDisambiguator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */