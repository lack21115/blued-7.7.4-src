package org.chromium.content.browser.input;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.SuggestionSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.browser.WindowEventObserver;
import org.chromium.content.browser.webcontents.WebContentsImpl;
import org.chromium.content_public.browser.ImeAdapter;
import org.chromium.content_public.browser.ImeEventObserver;
import org.chromium.content_public.browser.InputMethodManagerWrapper;
import org.chromium.content_public.browser.WebContents;
import org.chromium.ui.base.ViewAndroidDelegate;
import org.chromium.ui.base.WindowAndroid;

public class ImeAdapterImpl implements WindowEventObserver, ImeAdapter {
  private Configuration mCurrentConfig;
  
  CursorAnchorInfoController mCursorAnchorInfoController;
  
  private final List mEventObservers = new ArrayList();
  
  public final Rect mFocusPreOSKViewportRect = new Rect();
  
  public ChromiumBaseInputConnection mInputConnection;
  
  private ChromiumBaseInputConnection$Factory mInputConnectionFactory;
  
  InputMethodManagerWrapper mInputMethodManagerWrapper;
  
  private boolean mIsConnected;
  
  private int mLastCompositionEnd;
  
  private int mLastCompositionStart;
  
  private int mLastSelectionEnd;
  
  private int mLastSelectionStart;
  
  private String mLastText;
  
  long mNativeImeAdapterAndroid;
  
  private boolean mNodeEditable;
  
  private boolean mNodePassword;
  
  private boolean mRestartInputOnNextStateUpdate;
  
  private ImeAdapterImpl$ShowKeyboardResultReceiver mShowKeyboardResultReceiver;
  
  private int mTextInputFlags;
  
  private int mTextInputMode = 0;
  
  private int mTextInputType = 0;
  
  ViewAndroidDelegate mViewDelegate;
  
  final WebContentsImpl mWebContents;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ImeAdapterImpl(WebContents paramWebContents) {
    this.mWebContents = (WebContentsImpl)paramWebContents;
    this.mViewDelegate = this.mWebContents.getViewAndroidDelegate();
    assert false;
  }
  
  @CalledByNative
  private void cancelComposition() {
    if (this.mInputConnection != null)
      restartInput(); 
  }
  
  public static ImeAdapterImpl create(WebContents paramWebContents, InputMethodManagerWrapper paramInputMethodManagerWrapper) {
    // Byte code:
    //   0: aload_0
    //   1: ldc org/chromium/content/browser/input/ImeAdapterImpl
    //   3: invokestatic access$000 : ()Lorg/chromium/content_public/browser/WebContents$UserDataFactory;
    //   6: invokeinterface getOrSetUserData : (Ljava/lang/Class;Lorg/chromium/content_public/browser/WebContents$UserDataFactory;)Ljava/lang/Object;
    //   11: checkcast org/chromium/content/browser/input/ImeAdapterImpl
    //   14: astore_0
    //   15: getstatic org/chromium/content/browser/input/ImeAdapterImpl.$assertionsDisabled : Z
    //   18: ifne -> 56
    //   21: aload_0
    //   22: ifnull -> 48
    //   25: aload_0
    //   26: getfield mNativeImeAdapterAndroid : J
    //   29: lconst_0
    //   30: lcmp
    //   31: ifeq -> 39
    //   34: iconst_1
    //   35: istore_2
    //   36: goto -> 41
    //   39: iconst_0
    //   40: istore_2
    //   41: iload_2
    //   42: ifne -> 48
    //   45: goto -> 56
    //   48: new java/lang/AssertionError
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: athrow
    //   56: aload_0
    //   57: aload_1
    //   58: putfield mInputMethodManagerWrapper : Lorg/chromium/content_public/browser/InputMethodManagerWrapper;
    //   61: aload_0
    //   62: new android/content/res/Configuration
    //   65: dup
    //   66: aload_0
    //   67: getfield mViewDelegate : Lorg/chromium/ui/base/ViewAndroidDelegate;
    //   70: invokevirtual getContainerView : ()Landroid/view/ViewGroup;
    //   73: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   76: invokevirtual getConfiguration : ()Landroid/content/res/Configuration;
    //   79: invokespecial <init> : (Landroid/content/res/Configuration;)V
    //   82: putfield mCurrentConfig : Landroid/content/res/Configuration;
    //   85: getstatic android/os/Build$VERSION.SDK_INT : I
    //   88: bipush #21
    //   90: if_icmplt -> 123
    //   93: aload_0
    //   94: new org/chromium/content/browser/input/CursorAnchorInfoController
    //   97: dup
    //   98: aload_1
    //   99: new org/chromium/content/browser/input/ImeAdapterImpl$1
    //   102: dup
    //   103: aload_0
    //   104: invokespecial <init> : (Lorg/chromium/content/browser/input/ImeAdapterImpl;)V
    //   107: new org/chromium/content/browser/input/CursorAnchorInfoController$1
    //   110: dup
    //   111: invokespecial <init> : ()V
    //   114: invokespecial <init> : (Lorg/chromium/content_public/browser/InputMethodManagerWrapper;Lorg/chromium/content/browser/input/CursorAnchorInfoController$ComposingTextDelegate;Lorg/chromium/content/browser/input/CursorAnchorInfoController$ViewDelegate;)V
    //   117: putfield mCursorAnchorInfoController : Lorg/chromium/content/browser/input/CursorAnchorInfoController;
    //   120: goto -> 128
    //   123: aload_0
    //   124: aconst_null
    //   125: putfield mCursorAnchorInfoController : Lorg/chromium/content/browser/input/CursorAnchorInfoController;
    //   128: aload_0
    //   129: aload_0
    //   130: aload_0
    //   131: getfield mWebContents : Lorg/chromium/content/browser/webcontents/WebContentsImpl;
    //   134: invokespecial nativeInit : (Lorg/chromium/content_public/browser/WebContents;)J
    //   137: putfield mNativeImeAdapterAndroid : J
    //   140: aload_0
    //   141: getfield mWebContents : Lorg/chromium/content/browser/webcontents/WebContentsImpl;
    //   144: invokestatic from : (Lorg/chromium/content_public/browser/WebContents;)Lorg/chromium/content/browser/WindowEventObserverManager;
    //   147: aload_0
    //   148: invokevirtual addObserver : (Lorg/chromium/content/browser/WindowEventObserver;)V
    //   151: aload_0
    //   152: areturn
  }
  
  public static InputMethodManagerWrapper createDefaultInputMethodManagerWrapper(Context paramContext) {
    return new InputMethodManagerWrapperImpl(paramContext);
  }
  
  @CalledByNative
  private void destroy() {
    resetAndHideKeyboard();
    this.mNativeImeAdapterAndroid = 0L;
    this.mIsConnected = false;
    if (this.mCursorAnchorInfoController != null)
      this.mCursorAnchorInfoController.focusedNodeChanged(false); 
  }
  
  private boolean focusedNodeAllowsSoftKeyboard() {
    return (this.mTextInputType != 0 && this.mTextInputMode != 1);
  }
  
  @CalledByNative
  private void focusedNodeChanged(boolean paramBoolean) {
    if (this.mCursorAnchorInfoController != null)
      this.mCursorAnchorInfoController.focusedNodeChanged(paramBoolean); 
    if (this.mTextInputType != 0 && this.mInputConnection != null && paramBoolean)
      this.mRestartInputOnNextStateUpdate = true; 
  }
  
  private boolean focusedNodeEditable() {
    return (this.mTextInputType != 0);
  }
  
  public static ImeAdapterImpl fromWebContents(WebContents paramWebContents) {
    return (ImeAdapterImpl)paramWebContents.getOrSetUserData(ImeAdapterImpl.class, null);
  }
  
  private static int getUnderlineColorForSuggestionSpan(SuggestionSpan paramSuggestionSpan) {
    try {
      return ((Integer)SuggestionSpan.class.getMethod("getUnderlineColor", new Class[0]).invoke(paramSuggestionSpan, new Object[0])).intValue();
    } catch (IllegalAccessException illegalAccessException) {
      return -2000107320;
    } catch (InvocationTargetException invocationTargetException) {
      return -2000107320;
    } catch (NoSuchMethodException noSuchMethodException) {
      return -2000107320;
    } 
  }
  
  private void hideKeyboard() {
    if (!isValid())
      return; 
    ViewGroup viewGroup = this.mViewDelegate.getContainerView();
    if (this.mInputMethodManagerWrapper.isActive((View)viewGroup))
      this.mInputMethodManagerWrapper.hideSoftInputFromWindow(viewGroup.getWindowToken(), 0, null); 
    if (!focusedNodeEditable() && this.mInputConnection != null) {
      ChromiumBaseInputConnection chromiumBaseInputConnection = this.mInputConnection;
      restartInput();
      chromiumBaseInputConnection.unblockOnUiThread();
    } 
  }
  
  private boolean isHardwareKeyboardAttached() {
    return (this.mCurrentConfig.keyboard != 1);
  }
  
  private native void nativeAdvanceFocusInForm(long paramLong, int paramInt);
  
  private static native void nativeAppendBackgroundColorSpan(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  private static native void nativeAppendSuggestionSpan(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, String[] paramArrayOfString);
  
  private static native void nativeAppendUnderlineSpan(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeCommitText(long paramLong, CharSequence paramCharSequence, String paramString, int paramInt);
  
  private native long nativeInit(WebContents paramWebContents);
  
  private native void nativeSetComposingText(long paramLong, CharSequence paramCharSequence, String paramString, int paramInt);
  
  @CalledByNative
  private void onConnectedToRenderProcess() {
    this.mIsConnected = true;
    if (this.mInputConnectionFactory == null)
      this.mInputConnectionFactory = new ThreadedInputConnectionFactory(this.mInputMethodManagerWrapper); 
    resetAndHideKeyboard();
  }
  
  @CalledByNative
  private void populateImeTextSpansFromJava(CharSequence paramCharSequence, long paramLong) {
    if (!(paramCharSequence instanceof SpannableString))
      return; 
    SpannableString spannableString = (SpannableString)paramCharSequence;
    for (CharacterStyle characterStyle : (CharacterStyle[])spannableString.getSpans(0, paramCharSequence.length(), CharacterStyle.class)) {
      if (characterStyle instanceof BackgroundColorSpan) {
        nativeAppendBackgroundColorSpan(paramLong, spannableString.getSpanStart(characterStyle), spannableString.getSpanEnd(characterStyle), ((BackgroundColorSpan)characterStyle).getBackgroundColor());
      } else if (characterStyle instanceof android.text.style.UnderlineSpan) {
        nativeAppendUnderlineSpan(paramLong, spannableString.getSpanStart(characterStyle), spannableString.getSpanEnd(characterStyle));
      } else if (characterStyle instanceof SuggestionSpan) {
        boolean bool;
        SuggestionSpan suggestionSpan = (SuggestionSpan)characterStyle;
        if ((suggestionSpan.getFlags() & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        if (suggestionSpan.getFlags() == 1 || bool) {
          int i = getUnderlineColorForSuggestionSpan(suggestionSpan);
          int j = (int)(Color.alpha(i) * 0.4F);
          nativeAppendSuggestionSpan(paramLong, spannableString.getSpanStart(suggestionSpan), spannableString.getSpanEnd(suggestionSpan), bool, i, (0xFFFFFF & i) + (j << 24), suggestionSpan.getSuggestions());
        } 
      } 
    } 
  }
  
  private void restartInput() {
    if (!isValid())
      return; 
    this.mInputMethodManagerWrapper.restartInput((View)this.mViewDelegate.getContainerView());
  }
  
  @CalledByNative
  private void setCharacterBounds(float[] paramArrayOffloat) {
    if (this.mCursorAnchorInfoController == null)
      return; 
    CursorAnchorInfoController cursorAnchorInfoController = this.mCursorAnchorInfoController;
    ViewGroup viewGroup = this.mViewDelegate.getContainerView();
    if (cursorAnchorInfoController.mIsEditable && !Arrays.equals(paramArrayOffloat, cursorAnchorInfoController.mCompositionCharacterBounds)) {
      cursorAnchorInfoController.mLastCursorAnchorInfo = null;
      cursorAnchorInfoController.mCompositionCharacterBounds = paramArrayOffloat;
      if (cursorAnchorInfoController.mHasCoordinateInfo)
        cursorAnchorInfoController.updateCursorAnchorInfo((View)viewGroup); 
    } 
  }
  
  private void setInputConnection(ChromiumBaseInputConnection paramChromiumBaseInputConnection) {
    if (this.mInputConnection == paramChromiumBaseInputConnection)
      return; 
    if (this.mInputConnection != null)
      this.mInputConnection.unblockOnUiThread(); 
    this.mInputConnection = paramChromiumBaseInputConnection;
  }
  
  private void showSoftKeyboard() {
    if (!isValid())
      return; 
    ViewGroup viewGroup = this.mViewDelegate.getContainerView();
    InputMethodManagerWrapper inputMethodManagerWrapper = this.mInputMethodManagerWrapper;
    if (this.mShowKeyboardResultReceiver == null)
      this.mShowKeyboardResultReceiver = new ImeAdapterImpl$ShowKeyboardResultReceiver(this, new Handler()); 
    inputMethodManagerWrapper.showSoftInput((View)viewGroup, 0, this.mShowKeyboardResultReceiver);
    if ((viewGroup.getResources().getConfiguration()).keyboard != 1)
      this.mWebContents.scrollFocusedEditableNodeIntoView(); 
  }
  
  @CalledByNative
  private void updateAfterViewSizeChanged() {
    if (!this.mFocusPreOSKViewportRect.isEmpty()) {
      Rect rect = new Rect();
      this.mViewDelegate.getContainerView().getWindowVisibleDisplayFrame(rect);
      if (!rect.equals(this.mFocusPreOSKViewportRect)) {
        if (rect.width() == this.mFocusPreOSKViewportRect.width())
          if ($assertionsDisabled || this.mWebContents != null) {
            this.mWebContents.scrollFocusedEditableNodeIntoView();
          } else {
            throw new AssertionError();
          }  
        this.mFocusPreOSKViewportRect.setEmpty();
      } 
    } 
  }
  
  @CalledByNative
  private void updateFrameInfo(float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, float paramFloat3, float paramFloat4, float paramFloat5) {
    if (this.mCursorAnchorInfoController == null)
      return; 
    CursorAnchorInfoController cursorAnchorInfoController = this.mCursorAnchorInfoController;
    ViewGroup viewGroup = this.mViewDelegate.getContainerView();
    if (cursorAnchorInfoController.mIsEditable) {
      cursorAnchorInfoController.mViewDelegate.getLocationOnScreen((View)viewGroup, cursorAnchorInfoController.mViewOrigin);
      float f = cursorAnchorInfoController.mViewOrigin[0];
      paramFloat2 = cursorAnchorInfoController.mViewOrigin[1] + paramFloat2;
      if (!cursorAnchorInfoController.mHasCoordinateInfo || paramFloat1 != cursorAnchorInfoController.mScale || f != cursorAnchorInfoController.mTranslationX || paramFloat2 != cursorAnchorInfoController.mTranslationY || paramBoolean1 != cursorAnchorInfoController.mHasInsertionMarker || paramBoolean2 != cursorAnchorInfoController.mIsInsertionMarkerVisible || paramFloat3 != cursorAnchorInfoController.mInsertionMarkerHorizontal || paramFloat4 != cursorAnchorInfoController.mInsertionMarkerTop || paramFloat5 != cursorAnchorInfoController.mInsertionMarkerBottom) {
        cursorAnchorInfoController.mLastCursorAnchorInfo = null;
        cursorAnchorInfoController.mHasCoordinateInfo = true;
        cursorAnchorInfoController.mScale = paramFloat1;
        cursorAnchorInfoController.mTranslationX = f;
        cursorAnchorInfoController.mTranslationY = paramFloat2;
        cursorAnchorInfoController.mHasInsertionMarker = paramBoolean1;
        cursorAnchorInfoController.mIsInsertionMarkerVisible = paramBoolean2;
        cursorAnchorInfoController.mInsertionMarkerHorizontal = paramFloat3;
        cursorAnchorInfoController.mInsertionMarkerTop = paramFloat4;
        cursorAnchorInfoController.mInsertionMarkerBottom = paramFloat5;
      } 
      if (cursorAnchorInfoController.mHasPendingImmediateRequest || (cursorAnchorInfoController.mMonitorModeEnabled && cursorAnchorInfoController.mLastCursorAnchorInfo == null))
        cursorAnchorInfoController.updateCursorAnchorInfo((View)viewGroup); 
    } 
  }
  
  @CalledByNative
  private void updateOnTouchDown() {
    this.mFocusPreOSKViewportRect.setEmpty();
  }
  
  @CalledByNative
  private void updateState(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean2) {
    // Byte code:
    //   0: ldc_w 'ImeAdapter.updateState'
    //   3: invokestatic begin : (Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield mRestartInputOnNextStateUpdate : Z
    //   10: ifeq -> 368
    //   13: aload_0
    //   14: iconst_0
    //   15: putfield mRestartInputOnNextStateUpdate : Z
    //   18: iconst_1
    //   19: istore #11
    //   21: goto -> 24
    //   24: aload_0
    //   25: iload_2
    //   26: putfield mTextInputFlags : I
    //   29: aload_0
    //   30: getfield mTextInputMode : I
    //   33: iload_3
    //   34: if_icmpeq -> 382
    //   37: aload_0
    //   38: iload_3
    //   39: putfield mTextInputMode : I
    //   42: iload_3
    //   43: iconst_1
    //   44: if_icmpne -> 374
    //   47: aload_0
    //   48: invokespecial isHardwareKeyboardAttached : ()Z
    //   51: ifne -> 374
    //   54: iconst_1
    //   55: istore_2
    //   56: goto -> 376
    //   59: aload_0
    //   60: getfield mTextInputType : I
    //   63: iload_1
    //   64: if_icmpeq -> 392
    //   67: aload_0
    //   68: iload_1
    //   69: putfield mTextInputType : I
    //   72: iload_1
    //   73: ifne -> 387
    //   76: goto -> 399
    //   79: aload_0
    //   80: invokespecial focusedNodeEditable : ()Z
    //   83: istore #13
    //   85: iload_1
    //   86: iconst_2
    //   87: if_icmpne -> 407
    //   90: iconst_1
    //   91: istore #12
    //   93: goto -> 96
    //   96: aload_0
    //   97: getfield mNodeEditable : Z
    //   100: iload #13
    //   102: if_icmpne -> 114
    //   105: aload_0
    //   106: getfield mNodePassword : Z
    //   109: iload #12
    //   111: if_icmpeq -> 169
    //   114: aload_0
    //   115: getfield mEventObservers : Ljava/util/List;
    //   118: invokeinterface iterator : ()Ljava/util/Iterator;
    //   123: astore #14
    //   125: aload #14
    //   127: invokeinterface hasNext : ()Z
    //   132: ifeq -> 157
    //   135: aload #14
    //   137: invokeinterface next : ()Ljava/lang/Object;
    //   142: checkcast org/chromium/content_public/browser/ImeEventObserver
    //   145: iload #13
    //   147: iload #12
    //   149: invokeinterface onNodeAttributeUpdated : (ZZ)V
    //   154: goto -> 125
    //   157: aload_0
    //   158: iload #13
    //   160: putfield mNodeEditable : Z
    //   163: aload_0
    //   164: iload #12
    //   166: putfield mNodePassword : Z
    //   169: aload_0
    //   170: getfield mCursorAnchorInfoController : Lorg/chromium/content/browser/input/CursorAnchorInfoController;
    //   173: ifnull -> 231
    //   176: aload_0
    //   177: getfield mLastText : Ljava/lang/String;
    //   180: aload #5
    //   182: invokestatic equals : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   185: ifeq -> 224
    //   188: aload_0
    //   189: getfield mLastSelectionStart : I
    //   192: iload #6
    //   194: if_icmpne -> 224
    //   197: aload_0
    //   198: getfield mLastSelectionEnd : I
    //   201: iload #7
    //   203: if_icmpne -> 224
    //   206: aload_0
    //   207: getfield mLastCompositionStart : I
    //   210: iload #8
    //   212: if_icmpne -> 224
    //   215: aload_0
    //   216: getfield mLastCompositionEnd : I
    //   219: iload #9
    //   221: if_icmpeq -> 231
    //   224: aload_0
    //   225: getfield mCursorAnchorInfoController : Lorg/chromium/content/browser/input/CursorAnchorInfoController;
    //   228: invokevirtual invalidateLastCursorAnchorInfo : ()V
    //   231: aload_0
    //   232: aload #5
    //   234: putfield mLastText : Ljava/lang/String;
    //   237: aload_0
    //   238: iload #6
    //   240: putfield mLastSelectionStart : I
    //   243: aload_0
    //   244: iload #7
    //   246: putfield mLastSelectionEnd : I
    //   249: aload_0
    //   250: iload #8
    //   252: putfield mLastCompositionStart : I
    //   255: aload_0
    //   256: iload #9
    //   258: putfield mLastCompositionEnd : I
    //   261: iload_2
    //   262: ifeq -> 272
    //   265: aload_0
    //   266: invokespecial hideKeyboard : ()V
    //   269: goto -> 296
    //   272: iload_3
    //   273: ifeq -> 280
    //   276: aload_0
    //   277: invokespecial restartInput : ()V
    //   280: iload #4
    //   282: ifeq -> 296
    //   285: aload_0
    //   286: invokespecial focusedNodeAllowsSoftKeyboard : ()Z
    //   289: ifeq -> 296
    //   292: aload_0
    //   293: invokespecial showSoftKeyboard : ()V
    //   296: aload_0
    //   297: getfield mInputConnection : Lorg/chromium/content/browser/input/ChromiumBaseInputConnection;
    //   300: ifnull -> 350
    //   303: aload_0
    //   304: getfield mTextInputType : I
    //   307: bipush #14
    //   309: if_icmpeq -> 413
    //   312: aload_0
    //   313: getfield mTextInputType : I
    //   316: bipush #15
    //   318: if_icmpeq -> 413
    //   321: iconst_1
    //   322: istore #4
    //   324: goto -> 327
    //   327: aload_0
    //   328: getfield mInputConnection : Lorg/chromium/content/browser/input/ChromiumBaseInputConnection;
    //   331: aload #5
    //   333: iload #6
    //   335: iload #7
    //   337: iload #8
    //   339: iload #9
    //   341: iload #4
    //   343: iload #10
    //   345: invokeinterface updateStateOnUiThread : (Ljava/lang/String;IIIIZZ)V
    //   350: ldc_w 'ImeAdapter.updateState'
    //   353: invokestatic end : (Ljava/lang/String;)V
    //   356: return
    //   357: astore #5
    //   359: ldc_w 'ImeAdapter.updateState'
    //   362: invokestatic end : (Ljava/lang/String;)V
    //   365: aload #5
    //   367: athrow
    //   368: iconst_0
    //   369: istore #11
    //   371: goto -> 24
    //   374: iconst_0
    //   375: istore_2
    //   376: iconst_1
    //   377: istore #11
    //   379: goto -> 59
    //   382: iconst_0
    //   383: istore_2
    //   384: goto -> 59
    //   387: iconst_1
    //   388: istore_3
    //   389: goto -> 79
    //   392: iload #11
    //   394: istore_3
    //   395: iload_1
    //   396: ifne -> 79
    //   399: iconst_1
    //   400: istore_2
    //   401: iload #11
    //   403: istore_3
    //   404: goto -> 79
    //   407: iconst_0
    //   408: istore #12
    //   410: goto -> 96
    //   413: iconst_0
    //   414: istore #4
    //   416: goto -> 327
    // Exception table:
    //   from	to	target	type
    //   6	18	357	finally
    //   24	42	357	finally
    //   47	54	357	finally
    //   59	72	357	finally
    //   79	85	357	finally
    //   96	114	357	finally
    //   114	125	357	finally
    //   125	154	357	finally
    //   157	169	357	finally
    //   169	224	357	finally
    //   224	231	357	finally
    //   231	261	357	finally
    //   265	269	357	finally
    //   276	280	357	finally
    //   285	296	357	finally
    //   296	321	357	finally
    //   327	350	357	finally
  }
  
  public final void addEventObserver(ImeEventObserver paramImeEventObserver) {
    this.mEventObservers.add(paramImeEventObserver);
  }
  
  final void advanceFocusInForm(int paramInt) {
    if (this.mNativeImeAdapterAndroid == 0L)
      return; 
    nativeAdvanceFocusInForm(this.mNativeImeAdapterAndroid, paramInt);
  }
  
  final boolean isValid() {
    return (this.mNativeImeAdapterAndroid != 0L && this.mIsConnected);
  }
  
  native void nativeDeleteSurroundingText(long paramLong, int paramInt1, int paramInt2);
  
  native void nativeDeleteSurroundingTextInCodePoints(long paramLong, int paramInt1, int paramInt2);
  
  native void nativeFinishComposingText(long paramLong);
  
  native void nativeRequestCursorUpdate(long paramLong, boolean paramBoolean1, boolean paramBoolean2);
  
  native boolean nativeRequestTextInputStateUpdate(long paramLong);
  
  native boolean nativeSendKeyEvent(long paramLong1, KeyEvent paramKeyEvent, int paramInt1, int paramInt2, long paramLong2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5);
  
  native void nativeSetComposingRegion(long paramLong, int paramInt1, int paramInt2);
  
  native void nativeSetEditableSelectionOffsets(long paramLong, int paramInt1, int paramInt2);
  
  public final void onAttachedToWindow() {
    if (this.mInputConnectionFactory != null)
      this.mInputConnectionFactory.onViewAttachedToWindow(); 
  }
  
  public final boolean onCheckIsTextEditor() {
    int i = this.mTextInputType;
    if (i != 0) {
      if (i == 8 || i == 12 || i == 9 || i == 10 || i == 11 || i == 13) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i == 0)
        return true; 
    } 
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {
    if (!isValid())
      return; 
    if (this.mCurrentConfig.keyboard == paramConfiguration.keyboard && this.mCurrentConfig.keyboardHidden == paramConfiguration.keyboardHidden && this.mCurrentConfig.hardKeyboardHidden == paramConfiguration.hardKeyboardHidden)
      return; 
    this.mCurrentConfig = new Configuration(paramConfiguration);
    if (focusedNodeAllowsSoftKeyboard()) {
      restartInput();
    } else if (focusedNodeEditable()) {
      restartInput();
      if (!isHardwareKeyboardAttached()) {
        hideKeyboard();
        return;
      } 
    } else {
      return;
    } 
    showSoftKeyboard();
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    boolean bool;
    if (this.mWebContents != null && !this.mWebContents.isIncognito()) {
      bool = true;
    } else {
      bool = false;
    } 
    paramEditorInfo.imeOptions = 301989888;
    if (!bool)
      paramEditorInfo.imeOptions |= 0x1000000; 
    if (!focusedNodeEditable()) {
      setInputConnection(null);
      return null;
    } 
    if (this.mInputConnectionFactory == null)
      return null; 
    ViewGroup viewGroup = this.mViewDelegate.getContainerView();
    setInputConnection(this.mInputConnectionFactory.initializeAndGet((View)viewGroup, this, this.mTextInputType, this.mTextInputFlags, this.mTextInputMode, this.mLastSelectionStart, this.mLastSelectionEnd, paramEditorInfo));
    if (this.mCursorAnchorInfoController != null)
      this.mCursorAnchorInfoController.onRequestCursorUpdates(false, false, (View)viewGroup); 
    if (isValid())
      nativeRequestCursorUpdate(this.mNativeImeAdapterAndroid, false, false); 
    return this.mInputConnection;
  }
  
  public final void onDIPScaleChanged(float paramFloat) {}
  
  public final void onDetachedFromWindow() {
    resetAndHideKeyboard();
    if (this.mInputConnectionFactory != null)
      this.mInputConnectionFactory.onViewDetachedFromWindow(); 
  }
  
  final void onImeEvent() {
    Iterator<ImeEventObserver> iterator = this.mEventObservers.iterator();
    while (iterator.hasNext())
      ((ImeEventObserver)iterator.next()).onImeEvent(); 
    if (this.mNodeEditable)
      this.mWebContents.dismissTextHandles(); 
  }
  
  public final void onRotationChanged(int paramInt) {}
  
  public final void onViewFocusChanged(boolean paramBoolean1, boolean paramBoolean2) {
    if (!paramBoolean1 && paramBoolean2)
      resetAndHideKeyboard(); 
    if (this.mInputConnectionFactory != null)
      this.mInputConnectionFactory.onViewFocusChanged(paramBoolean1); 
  }
  
  public final void onWindowAndroidChanged(WindowAndroid paramWindowAndroid) {}
  
  public final void onWindowFocusChanged(boolean paramBoolean) {
    if (this.mInputConnectionFactory != null)
      this.mInputConnectionFactory.onWindowFocusChanged(paramBoolean); 
  }
  
  public final void resetAndHideKeyboard() {
    this.mTextInputType = 0;
    this.mTextInputFlags = 0;
    this.mTextInputMode = 0;
    this.mRestartInputOnNextStateUpdate = false;
    hideKeyboard();
  }
  
  final boolean sendCompositionToNative(CharSequence paramCharSequence, int paramInt1, boolean paramBoolean, int paramInt2) {
    if (!isValid())
      return false; 
    onImeEvent();
    long l = SystemClock.uptimeMillis();
    nativeSendKeyEvent(this.mNativeImeAdapterAndroid, null, 7, 0, l, 229, 0, false, paramInt2);
    if (paramBoolean) {
      nativeCommitText(this.mNativeImeAdapterAndroid, paramCharSequence, paramCharSequence.toString(), paramInt1);
    } else {
      nativeSetComposingText(this.mNativeImeAdapterAndroid, paramCharSequence, paramCharSequence.toString(), paramInt1);
    } 
    nativeSendKeyEvent(this.mNativeImeAdapterAndroid, null, 9, 0, l, 229, 0, false, paramInt2);
    return true;
  }
  
  public final boolean sendKeyEvent(KeyEvent paramKeyEvent) {
    byte b;
    boolean bool = isValid();
    int j = 0;
    if (!bool)
      return false; 
    int i = paramKeyEvent.getAction();
    if (i == 0) {
      b = 8;
    } else if (i == 1) {
      b = 9;
    } else {
      return false;
    } 
    Iterator<ImeEventObserver> iterator = this.mEventObservers.iterator();
    while (iterator.hasNext())
      ((ImeEventObserver)iterator.next()).onBeforeSendKeyEvent(paramKeyEvent); 
    onImeEvent();
    long l = this.mNativeImeAdapterAndroid;
    int k = paramKeyEvent.getMetaState();
    if ((k & 0x1) != 0)
      j = 1; 
    i = j;
    if ((k & 0x2) != 0)
      i = j | 0x4; 
    j = i;
    if ((k & 0x1000) != 0)
      j = i | 0x2; 
    i = j;
    if ((0x100000 & k) != 0)
      i = j | 0x200; 
    if ((k & 0x200000) != 0)
      i |= 0x400; 
    return nativeSendKeyEvent(l, paramKeyEvent, b, i, paramKeyEvent.getEventTime(), paramKeyEvent.getKeyCode(), paramKeyEvent.getScanCode(), false, paramKeyEvent.getUnicodeChar());
  }
  
  public final void sendSyntheticKeyPress(int paramInt1, int paramInt2) {
    long l = SystemClock.uptimeMillis();
    sendKeyEvent(new KeyEvent(l, l, 0, paramInt1, 0, 0, -1, 0, paramInt2));
    sendKeyEvent(new KeyEvent(l, l, 1, paramInt1, 0, 0, -1, 0, paramInt2));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\ImeAdapterImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */