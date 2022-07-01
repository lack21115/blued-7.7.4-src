package com.qq.e.ads.nativ;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;

public final class MediaView extends FrameLayout {
  private int a;
  
  private int b;
  
  public MediaView(Context paramContext) {
    super(paramContext);
  }
  
  public MediaView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public MediaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final void onAttachedToWindow() {
    GDTLogger.d("onAttachedToWindow");
    super.onAttachedToWindow();
    if (Build.VERSION.SDK_INT >= 11 && !isHardwareAccelerated())
      GDTLogger.e("Hardware acceleration is off"); 
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: invokestatic getSDKVersionCode : ()I
    //   3: bipush #11
    //   5: if_icmpeq -> 21
    //   8: iload_1
    //   9: istore_3
    //   10: iload_2
    //   11: istore #4
    //   13: invokestatic getSDKVersionCode : ()I
    //   16: bipush #12
    //   18: if_icmpne -> 156
    //   21: iload_1
    //   22: istore_3
    //   23: iload_2
    //   24: istore #4
    //   26: aload_0
    //   27: getfield a : I
    //   30: ifle -> 156
    //   33: iload_1
    //   34: istore_3
    //   35: iload_2
    //   36: istore #4
    //   38: aload_0
    //   39: getfield b : I
    //   42: ifle -> 156
    //   45: iload_1
    //   46: invokestatic getSize : (I)I
    //   49: istore_3
    //   50: iload_2
    //   51: invokestatic getSize : (I)I
    //   54: istore_2
    //   55: aload_0
    //   56: getfield b : I
    //   59: istore_1
    //   60: aload_0
    //   61: getfield a : I
    //   64: istore #4
    //   66: iload_1
    //   67: iload_3
    //   68: imul
    //   69: iload #4
    //   71: iload_2
    //   72: imul
    //   73: if_icmplt -> 129
    //   76: iload_2
    //   77: ifne -> 83
    //   80: goto -> 129
    //   83: iload_1
    //   84: iload_3
    //   85: imul
    //   86: iload #4
    //   88: iload_2
    //   89: imul
    //   90: if_icmpgt -> 99
    //   93: iload_3
    //   94: istore_1
    //   95: iload_3
    //   96: ifne -> 111
    //   99: aload_0
    //   100: getfield a : I
    //   103: iload_2
    //   104: imul
    //   105: aload_0
    //   106: getfield b : I
    //   109: idiv
    //   110: istore_1
    //   111: iload_1
    //   112: ldc 1073741824
    //   114: invokestatic makeMeasureSpec : (II)I
    //   117: istore_3
    //   118: iload_2
    //   119: ldc 1073741824
    //   121: invokestatic makeMeasureSpec : (II)I
    //   124: istore #4
    //   126: goto -> 156
    //   129: iload_3
    //   130: ldc 1073741824
    //   132: invokestatic makeMeasureSpec : (II)I
    //   135: istore_1
    //   136: iload_3
    //   137: aload_0
    //   138: getfield b : I
    //   141: imul
    //   142: aload_0
    //   143: getfield a : I
    //   146: idiv
    //   147: ldc 1073741824
    //   149: invokestatic makeMeasureSpec : (II)I
    //   152: istore #4
    //   154: iload_1
    //   155: istore_3
    //   156: aload_0
    //   157: iload_3
    //   158: iload #4
    //   160: invokespecial onMeasure : (II)V
    //   163: return
  }
  
  public final void setRatio(int paramInt1, int paramInt2) {
    this.a = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\ads\nativ\MediaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */