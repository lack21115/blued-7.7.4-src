package org.chromium.content.browser;

import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.browser.input.ImeAdapterImpl;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content.browser.webcontents.WebContentsUserData;
import org.chromium.content_public.browser.ViewEventSink;
import org.chromium.content_public.browser.WebContents;
import org.chromium.device.gamepad.GamepadList;
import org.chromium.ui.display.DisplayAndroid;

public class ContentUiEventHandler {
  ViewEventSink.InternalAccessDelegate mEventDelegate;
  
  private long mNativeContentUiEventHandler;
  
  private final WebContentsImpl mWebContents;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ContentUiEventHandler(WebContents paramWebContents) {
    this.mWebContents = (WebContentsImpl)paramWebContents;
    this.mNativeContentUiEventHandler = nativeInit(paramWebContents);
  }
  
  @CalledByNative
  private boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    boolean bool;
    if (GamepadList.dispatchKeyEvent(paramKeyEvent))
      return true; 
    int i = paramKeyEvent.getKeyCode();
    if (i == 82 || i == 3 || i == 4 || i == 5 || i == 6 || i == 26 || i == 79 || i == 27 || i == 80 || i == 25 || i == 164 || i == 24) {
      i = 0;
    } else {
      i = 1;
    } 
    if (i == 0)
      return this.mEventDelegate.super_dispatchKeyEvent(paramKeyEvent); 
    ImeAdapterImpl imeAdapterImpl = ImeAdapterImpl.fromWebContents((WebContents)this.mWebContents);
    if (imeAdapterImpl.mInputConnection != null) {
      bool = imeAdapterImpl.mInputConnection.sendKeyEventOnUiThread(paramKeyEvent);
    } else {
      bool = imeAdapterImpl.sendKeyEvent(paramKeyEvent);
    } 
    return bool ? true : this.mEventDelegate.super_dispatchKeyEvent(paramKeyEvent);
  }
  
  public static ContentUiEventHandler fromWebContents(WebContents paramWebContents) {
    return (ContentUiEventHandler)WebContentsUserData.fromWebContents(paramWebContents, ContentUiEventHandler.class, ContentUiEventHandler$UserDataFactoryLazyHolder.access$000());
  }
  
  private float getEventSourceScaling() {
    DisplayAndroid displayAndroid = (this.mWebContents.getTopLevelNativeWindow()).mDisplayAndroid;
    return DisplayAndroid.getAndroidUIScaling();
  }
  
  private native void nativeCancelFling(long paramLong1, long paramLong2);
  
  private native long nativeInit(WebContents paramWebContents);
  
  private native void nativeSendMouseEvent(long paramLong1, long paramLong2, int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, float paramFloat3, float paramFloat4, float paramFloat5, int paramInt3, int paramInt4, int paramInt5, int paramInt6);
  
  private native void nativeSendMouseWheelEvent(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  private native void nativeSendScrollEvent(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2);
  
  @CalledByNative
  private boolean onGenericMotionEvent(MotionEvent paramMotionEvent) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic onGenericMotionEvent : (Landroid/view/MotionEvent;)Z
    //   4: ifeq -> 9
    //   7: iconst_1
    //   8: ireturn
    //   9: aload_0
    //   10: getfield mWebContents : Lorg/chromium/content/browser/webcontents/WebContentsImpl;
    //   13: invokestatic fromWebContents : (Lorg/chromium/content_public/browser/WebContents;)Lorg/chromium/content/browser/JoystickHandler;
    //   16: astore #5
    //   18: aload #5
    //   20: getfield mScrollEnabled : Z
    //   23: ifeq -> 88
    //   26: aload_1
    //   27: invokevirtual getSource : ()I
    //   30: bipush #16
    //   32: iand
    //   33: ifne -> 39
    //   36: goto -> 88
    //   39: aload_1
    //   40: iconst_0
    //   41: invokestatic getVelocityFromJoystickAxis : (Landroid/view/MotionEvent;I)F
    //   44: fstore_2
    //   45: aload_1
    //   46: iconst_1
    //   47: invokestatic getVelocityFromJoystickAxis : (Landroid/view/MotionEvent;I)F
    //   50: fstore_3
    //   51: fload_2
    //   52: fconst_0
    //   53: fcmpl
    //   54: ifne -> 66
    //   57: fload_3
    //   58: fconst_0
    //   59: fcmpl
    //   60: ifne -> 66
    //   63: goto -> 88
    //   66: aload #5
    //   68: getfield mEventForwarder : Lorg/chromium/ui/base/EventForwarder;
    //   71: aload_1
    //   72: invokevirtual getEventTime : ()J
    //   75: fload_2
    //   76: fload_3
    //   77: iconst_1
    //   78: iconst_1
    //   79: invokevirtual startFling : (JFFZZ)V
    //   82: iconst_1
    //   83: istore #4
    //   85: goto -> 91
    //   88: iconst_0
    //   89: istore #4
    //   91: iload #4
    //   93: ifeq -> 98
    //   96: iconst_1
    //   97: ireturn
    //   98: aload_1
    //   99: invokevirtual getSource : ()I
    //   102: iconst_2
    //   103: iand
    //   104: ifeq -> 368
    //   107: aload_1
    //   108: invokevirtual getActionMasked : ()I
    //   111: istore #4
    //   113: iload #4
    //   115: bipush #8
    //   117: if_icmpeq -> 299
    //   120: iload #4
    //   122: tableswitch default -> 144, 11 -> 147, 12 -> 147
    //   144: goto -> 368
    //   147: aload_1
    //   148: iconst_0
    //   149: invokevirtual getToolType : (I)I
    //   152: iconst_3
    //   153: if_icmpne -> 296
    //   156: getstatic org/chromium/content/browser/ContentUiEventHandler.$assertionsDisabled : Z
    //   159: ifne -> 182
    //   162: aload_0
    //   163: getfield mNativeContentUiEventHandler : J
    //   166: lconst_0
    //   167: lcmp
    //   168: ifeq -> 174
    //   171: goto -> 182
    //   174: new java/lang/AssertionError
    //   177: dup
    //   178: invokespecial <init> : ()V
    //   181: athrow
    //   182: aload_0
    //   183: getfield mWebContents : Lorg/chromium/content/browser/webcontents/WebContentsImpl;
    //   186: invokevirtual getEventForwarder : ()Lorg/chromium/ui/base/EventForwarder;
    //   189: aload_1
    //   190: invokevirtual createOffsetMotionEventIfNeeded : (Landroid/view/MotionEvent;)Landroid/view/MotionEvent;
    //   193: astore #5
    //   195: aload #5
    //   197: aload_1
    //   198: if_acmpeq -> 210
    //   201: aload #5
    //   203: astore_1
    //   204: iconst_1
    //   205: istore #4
    //   207: goto -> 213
    //   210: iconst_0
    //   211: istore #4
    //   213: aload_0
    //   214: invokespecial getEventSourceScaling : ()F
    //   217: fstore_2
    //   218: aload_0
    //   219: aload_0
    //   220: getfield mNativeContentUiEventHandler : J
    //   223: aload_1
    //   224: invokevirtual getEventTime : ()J
    //   227: aload_1
    //   228: invokevirtual getActionMasked : ()I
    //   231: aload_1
    //   232: invokevirtual getX : ()F
    //   235: fload_2
    //   236: fdiv
    //   237: aload_1
    //   238: invokevirtual getY : ()F
    //   241: fload_2
    //   242: fdiv
    //   243: aload_1
    //   244: iconst_0
    //   245: invokevirtual getPointerId : (I)I
    //   248: aload_1
    //   249: iconst_0
    //   250: invokevirtual getPressure : (I)F
    //   253: aload_1
    //   254: iconst_0
    //   255: invokevirtual getOrientation : (I)F
    //   258: aload_1
    //   259: bipush #25
    //   261: iconst_0
    //   262: invokevirtual getAxisValue : (II)F
    //   265: aload_1
    //   266: invokestatic getMouseEventActionButton : (Landroid/view/MotionEvent;)I
    //   269: aload_1
    //   270: invokevirtual getButtonState : ()I
    //   273: aload_1
    //   274: invokevirtual getMetaState : ()I
    //   277: aload_1
    //   278: iconst_0
    //   279: invokevirtual getToolType : (I)I
    //   282: invokespecial nativeSendMouseEvent : (JJIFFIFFFIIII)V
    //   285: iload #4
    //   287: ifeq -> 294
    //   290: aload_1
    //   291: invokevirtual recycle : ()V
    //   294: iconst_1
    //   295: ireturn
    //   296: goto -> 368
    //   299: getstatic org/chromium/content/browser/ContentUiEventHandler.$assertionsDisabled : Z
    //   302: ifne -> 325
    //   305: aload_0
    //   306: getfield mNativeContentUiEventHandler : J
    //   309: lconst_0
    //   310: lcmp
    //   311: ifeq -> 317
    //   314: goto -> 325
    //   317: new java/lang/AssertionError
    //   320: dup
    //   321: invokespecial <init> : ()V
    //   324: athrow
    //   325: aload_0
    //   326: invokespecial getEventSourceScaling : ()F
    //   329: fstore_2
    //   330: aload_0
    //   331: aload_0
    //   332: getfield mNativeContentUiEventHandler : J
    //   335: aload_1
    //   336: invokevirtual getEventTime : ()J
    //   339: aload_1
    //   340: invokevirtual getX : ()F
    //   343: fload_2
    //   344: fdiv
    //   345: aload_1
    //   346: invokevirtual getY : ()F
    //   349: fload_2
    //   350: fdiv
    //   351: aload_1
    //   352: bipush #10
    //   354: invokevirtual getAxisValue : (I)F
    //   357: aload_1
    //   358: bipush #9
    //   360: invokevirtual getAxisValue : (I)F
    //   363: invokespecial nativeSendMouseWheelEvent : (JJFFFF)V
    //   366: iconst_1
    //   367: ireturn
    //   368: aload_0
    //   369: getfield mEventDelegate : Lorg/chromium/content_public/browser/ViewEventSink$InternalAccessDelegate;
    //   372: aload_1
    //   373: invokeinterface super_onGenericMotionEvent : (Landroid/view/MotionEvent;)Z
    //   378: ireturn
  }
  
  @CalledByNative
  private boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    PopupZoomer popupZoomer;
    TapDisambiguator tapDisambiguator = TapDisambiguator.fromWebContents((WebContents)this.mWebContents);
    if (tapDisambiguator.mPopupView.isShowing() && paramInt == 4) {
      popupZoomer = tapDisambiguator.mPopupView;
      if (popupZoomer.mShowing) {
        PopupZoomer.recordHistogram(1);
        popupZoomer.startAnimation(false);
      } 
      return true;
    } 
    return this.mEventDelegate.super_onKeyUp(paramInt, (KeyEvent)popupZoomer);
  }
  
  @CalledByNative
  private void scrollBy(float paramFloat1, float paramFloat2) {
    if (paramFloat1 == 0.0F && paramFloat2 == 0.0F)
      return; 
    long l = SystemClock.uptimeMillis();
    if ((GestureListenerManagerImpl.fromWebContents((WebContents)this.mWebContents)).mHasActiveFlingScroll)
      nativeCancelFling(this.mNativeContentUiEventHandler, l); 
    nativeSendScrollEvent(this.mNativeContentUiEventHandler, l, paramFloat1, paramFloat2);
  }
  
  @CalledByNative
  private void scrollTo(float paramFloat1, float paramFloat2) {
    scrollBy(paramFloat1 - this.mWebContents.mRenderCoordinates.getScrollXPix(), paramFloat2 - this.mWebContents.mRenderCoordinates.getScrollYPix());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ContentUiEventHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */