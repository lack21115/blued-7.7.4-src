package org.chromium.content.browser.picker;

import android.widget.DatePicker;

public final class DateDialogNormalizer {
  public static void normalize(DatePicker paramDatePicker, DatePicker.OnDateChangedListener paramOnDateChangedListener, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2) {
    // Byte code:
    //   0: iload_2
    //   1: iload_3
    //   2: iload #4
    //   4: invokestatic create : (III)Lorg/chromium/content/browser/picker/DateDialogNormalizer$DateAndMillis;
    //   7: astore #18
    //   9: lload #5
    //   11: invokestatic create : (J)Lorg/chromium/content/browser/picker/DateDialogNormalizer$DateAndMillis;
    //   14: astore #17
    //   16: lload #7
    //   18: invokestatic create : (J)Lorg/chromium/content/browser/picker/DateDialogNormalizer$DateAndMillis;
    //   21: astore #16
    //   23: aload #16
    //   25: astore #15
    //   27: aload #16
    //   29: getfield millisForPicker : J
    //   32: aload #17
    //   34: getfield millisForPicker : J
    //   37: lcmp
    //   38: ifge -> 45
    //   41: aload #17
    //   43: astore #15
    //   45: aload #18
    //   47: getfield millisForPicker : J
    //   50: aload #17
    //   52: getfield millisForPicker : J
    //   55: lcmp
    //   56: ifge -> 66
    //   59: aload #17
    //   61: astore #16
    //   63: goto -> 88
    //   66: aload #18
    //   68: astore #16
    //   70: aload #18
    //   72: getfield millisForPicker : J
    //   75: aload #15
    //   77: getfield millisForPicker : J
    //   80: lcmp
    //   81: ifle -> 88
    //   84: aload #15
    //   86: astore #16
    //   88: aload #16
    //   90: getfield millisForPicker : J
    //   93: lstore #13
    //   95: aload #17
    //   97: getfield millisForPicker : J
    //   100: lstore #11
    //   102: aload #15
    //   104: getfield millisForPicker : J
    //   107: lstore #9
    //   109: getstatic android/os/Build$VERSION.SDK_INT : I
    //   112: bipush #21
    //   114: if_icmpeq -> 133
    //   117: lload #9
    //   119: lstore #7
    //   121: lload #11
    //   123: lstore #5
    //   125: getstatic android/os/Build$VERSION.SDK_INT : I
    //   128: bipush #22
    //   130: if_icmpne -> 159
    //   133: lload #11
    //   135: lload #13
    //   137: ldc2_w 157680000000000
    //   140: lsub
    //   141: invokestatic max : (JJ)J
    //   144: lstore #5
    //   146: lload #9
    //   148: lload #13
    //   150: ldc2_w 157680000000000
    //   153: ladd
    //   154: invokestatic min : (JJ)J
    //   157: lstore #7
    //   159: lload #5
    //   161: aload_0
    //   162: invokevirtual getMaxDate : ()J
    //   165: lcmp
    //   166: ifle -> 184
    //   169: aload_0
    //   170: lload #7
    //   172: invokevirtual setMaxDate : (J)V
    //   175: aload_0
    //   176: lload #5
    //   178: invokevirtual setMinDate : (J)V
    //   181: goto -> 196
    //   184: aload_0
    //   185: lload #5
    //   187: invokevirtual setMinDate : (J)V
    //   190: aload_0
    //   191: lload #7
    //   193: invokevirtual setMaxDate : (J)V
    //   196: aload_0
    //   197: aload #16
    //   199: getfield year : I
    //   202: aload #16
    //   204: getfield month : I
    //   207: aload #16
    //   209: getfield day : I
    //   212: aload_1
    //   213: invokevirtual init : (IIILandroid/widget/DatePicker$OnDateChangedListener;)V
    //   216: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\picker\DateDialogNormalizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */