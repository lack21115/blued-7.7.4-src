package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

public class SidePropagation extends VisibilityPropagation {
  private float a = 3.0F;
  
  private int b = 80;
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : I
    //   4: istore #11
    //   6: iconst_1
    //   7: istore #12
    //   9: iconst_1
    //   10: istore #10
    //   12: iload #11
    //   14: ldc 8388611
    //   16: if_icmpne -> 50
    //   19: aload_1
    //   20: invokestatic getLayoutDirection : (Landroid/view/View;)I
    //   23: iconst_1
    //   24: if_icmpne -> 30
    //   27: goto -> 33
    //   30: iconst_0
    //   31: istore #10
    //   33: iload #10
    //   35: ifeq -> 44
    //   38: iconst_5
    //   39: istore #10
    //   41: goto -> 87
    //   44: iconst_3
    //   45: istore #10
    //   47: goto -> 87
    //   50: iload #11
    //   52: istore #10
    //   54: iload #11
    //   56: ldc 8388613
    //   58: if_icmpne -> 87
    //   61: aload_1
    //   62: invokestatic getLayoutDirection : (Landroid/view/View;)I
    //   65: iconst_1
    //   66: if_icmpne -> 76
    //   69: iload #12
    //   71: istore #10
    //   73: goto -> 79
    //   76: iconst_0
    //   77: istore #10
    //   79: iload #10
    //   81: ifeq -> 38
    //   84: goto -> 44
    //   87: iload #10
    //   89: iconst_3
    //   90: if_icmpeq -> 154
    //   93: iload #10
    //   95: iconst_5
    //   96: if_icmpeq -> 141
    //   99: iload #10
    //   101: bipush #48
    //   103: if_icmpeq -> 128
    //   106: iload #10
    //   108: bipush #80
    //   110: if_icmpeq -> 115
    //   113: iconst_0
    //   114: ireturn
    //   115: iload_3
    //   116: iload #7
    //   118: isub
    //   119: iload #4
    //   121: iload_2
    //   122: isub
    //   123: invokestatic abs : (I)I
    //   126: iadd
    //   127: ireturn
    //   128: iload #9
    //   130: iload_3
    //   131: isub
    //   132: iload #4
    //   134: iload_2
    //   135: isub
    //   136: invokestatic abs : (I)I
    //   139: iadd
    //   140: ireturn
    //   141: iload_2
    //   142: iload #6
    //   144: isub
    //   145: iload #5
    //   147: iload_3
    //   148: isub
    //   149: invokestatic abs : (I)I
    //   152: iadd
    //   153: ireturn
    //   154: iload #8
    //   156: iload_2
    //   157: isub
    //   158: iload #5
    //   160: iload_3
    //   161: isub
    //   162: invokestatic abs : (I)I
    //   165: iadd
    //   166: ireturn
  }
  
  private int a(ViewGroup paramViewGroup) {
    int i = this.b;
    return (i != 3 && i != 5 && i != 8388611 && i != 8388613) ? paramViewGroup.getHeight() : paramViewGroup.getWidth();
  }
  
  public long getStartDelay(ViewGroup paramViewGroup, Transition paramTransition, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    boolean bool;
    int i;
    int j;
    if (paramTransitionValues1 == null && paramTransitionValues2 == null)
      return 0L; 
    Rect rect = paramTransition.getEpicenter();
    if (paramTransitionValues2 == null || getViewVisibility(paramTransitionValues1) == 0) {
      bool = true;
    } else {
      bool = true;
      paramTransitionValues1 = paramTransitionValues2;
    } 
    int k = getViewX(paramTransitionValues1);
    int m = getViewY(paramTransitionValues1);
    int[] arrayOfInt = new int[2];
    paramViewGroup.getLocationOnScreen(arrayOfInt);
    int n = arrayOfInt[0] + Math.round(paramViewGroup.getTranslationX());
    int i1 = arrayOfInt[1] + Math.round(paramViewGroup.getTranslationY());
    int i2 = n + paramViewGroup.getWidth();
    int i3 = i1 + paramViewGroup.getHeight();
    if (rect != null) {
      i = rect.centerX();
      j = rect.centerY();
    } else {
      i = (n + i2) / 2;
      j = (i1 + i3) / 2;
    } 
    float f = a((View)paramViewGroup, k, m, i, j, n, i1, i2, i3) / a(paramViewGroup);
    long l2 = paramTransition.getDuration();
    long l1 = l2;
    if (l2 < 0L)
      l1 = 300L; 
    return Math.round((float)(l1 * bool) / this.a * f);
  }
  
  public void setPropagationSpeed(float paramFloat) {
    if (paramFloat != 0.0F) {
      this.a = paramFloat;
      return;
    } 
    throw new IllegalArgumentException("propagationSpeed may not be 0");
  }
  
  public void setSide(int paramInt) {
    this.b = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\SidePropagation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */