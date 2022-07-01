package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

class TransitionUtils {
  private static final boolean a;
  
  private static final boolean b;
  
  private static final boolean c;
  
  static {
    boolean bool1;
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    if (i >= 19) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    a = bool1;
    if (Build.VERSION.SDK_INT >= 18) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    b = bool1;
    if (Build.VERSION.SDK_INT >= 28) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    c = bool1;
  }
  
  static Animator a(Animator paramAnimator1, Animator paramAnimator2) {
    if (paramAnimator1 == null)
      return paramAnimator2; 
    if (paramAnimator2 == null)
      return paramAnimator1; 
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.playTogether(new Animator[] { paramAnimator1, paramAnimator2 });
    return (Animator)animatorSet;
  }
  
  private static Bitmap a(View paramView, Matrix paramMatrix, RectF paramRectF, ViewGroup paramViewGroup) {
    // Byte code:
    //   0: getstatic androidx/transition/TransitionUtils.a : Z
    //   3: istore #9
    //   5: iconst_0
    //   6: istore #6
    //   8: iload #9
    //   10: ifeq -> 37
    //   13: aload_0
    //   14: invokevirtual isAttachedToWindow : ()Z
    //   17: iconst_1
    //   18: ixor
    //   19: istore #5
    //   21: aload_3
    //   22: ifnonnull -> 28
    //   25: goto -> 40
    //   28: aload_3
    //   29: invokevirtual isAttachedToWindow : ()Z
    //   32: istore #9
    //   34: goto -> 43
    //   37: iconst_0
    //   38: istore #5
    //   40: iconst_0
    //   41: istore #9
    //   43: getstatic androidx/transition/TransitionUtils.b : Z
    //   46: istore #10
    //   48: aconst_null
    //   49: astore #13
    //   51: iload #10
    //   53: ifeq -> 96
    //   56: iload #5
    //   58: ifeq -> 96
    //   61: iload #9
    //   63: ifne -> 68
    //   66: aconst_null
    //   67: areturn
    //   68: aload_0
    //   69: invokevirtual getParent : ()Landroid/view/ViewParent;
    //   72: checkcast android/view/ViewGroup
    //   75: astore #12
    //   77: aload #12
    //   79: aload_0
    //   80: invokevirtual indexOfChild : (Landroid/view/View;)I
    //   83: istore #6
    //   85: aload_3
    //   86: invokevirtual getOverlay : ()Landroid/view/ViewGroupOverlay;
    //   89: aload_0
    //   90: invokevirtual add : (Landroid/view/View;)V
    //   93: goto -> 99
    //   96: aconst_null
    //   97: astore #12
    //   99: aload_2
    //   100: invokevirtual width : ()F
    //   103: invokestatic round : (F)I
    //   106: istore #8
    //   108: aload_2
    //   109: invokevirtual height : ()F
    //   112: invokestatic round : (F)I
    //   115: istore #7
    //   117: aload #13
    //   119: astore #11
    //   121: iload #8
    //   123: ifle -> 277
    //   126: aload #13
    //   128: astore #11
    //   130: iload #7
    //   132: ifle -> 277
    //   135: fconst_1
    //   136: ldc 1048576.0
    //   138: iload #8
    //   140: iload #7
    //   142: imul
    //   143: i2f
    //   144: fdiv
    //   145: invokestatic min : (FF)F
    //   148: fstore #4
    //   150: iload #8
    //   152: i2f
    //   153: fload #4
    //   155: fmul
    //   156: invokestatic round : (F)I
    //   159: istore #8
    //   161: iload #7
    //   163: i2f
    //   164: fload #4
    //   166: fmul
    //   167: invokestatic round : (F)I
    //   170: istore #7
    //   172: aload_1
    //   173: aload_2
    //   174: getfield left : F
    //   177: fneg
    //   178: aload_2
    //   179: getfield top : F
    //   182: fneg
    //   183: invokevirtual postTranslate : (FF)Z
    //   186: pop
    //   187: aload_1
    //   188: fload #4
    //   190: fload #4
    //   192: invokevirtual postScale : (FF)Z
    //   195: pop
    //   196: getstatic androidx/transition/TransitionUtils.c : Z
    //   199: ifeq -> 245
    //   202: new android/graphics/Picture
    //   205: dup
    //   206: invokespecial <init> : ()V
    //   209: astore_2
    //   210: aload_2
    //   211: iload #8
    //   213: iload #7
    //   215: invokevirtual beginRecording : (II)Landroid/graphics/Canvas;
    //   218: astore #11
    //   220: aload #11
    //   222: aload_1
    //   223: invokevirtual concat : (Landroid/graphics/Matrix;)V
    //   226: aload_0
    //   227: aload #11
    //   229: invokevirtual draw : (Landroid/graphics/Canvas;)V
    //   232: aload_2
    //   233: invokevirtual endRecording : ()V
    //   236: aload_2
    //   237: invokestatic createBitmap : (Landroid/graphics/Picture;)Landroid/graphics/Bitmap;
    //   240: astore #11
    //   242: goto -> 277
    //   245: iload #8
    //   247: iload #7
    //   249: getstatic android/graphics/Bitmap$Config.ARGB_8888 : Landroid/graphics/Bitmap$Config;
    //   252: invokestatic createBitmap : (IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   255: astore #11
    //   257: new android/graphics/Canvas
    //   260: dup
    //   261: aload #11
    //   263: invokespecial <init> : (Landroid/graphics/Bitmap;)V
    //   266: astore_2
    //   267: aload_2
    //   268: aload_1
    //   269: invokevirtual concat : (Landroid/graphics/Matrix;)V
    //   272: aload_0
    //   273: aload_2
    //   274: invokevirtual draw : (Landroid/graphics/Canvas;)V
    //   277: getstatic androidx/transition/TransitionUtils.b : Z
    //   280: ifeq -> 304
    //   283: iload #5
    //   285: ifeq -> 304
    //   288: aload_3
    //   289: invokevirtual getOverlay : ()Landroid/view/ViewGroupOverlay;
    //   292: aload_0
    //   293: invokevirtual remove : (Landroid/view/View;)V
    //   296: aload #12
    //   298: aload_0
    //   299: iload #6
    //   301: invokevirtual addView : (Landroid/view/View;I)V
    //   304: aload #11
    //   306: areturn
  }
  
  static View a(ViewGroup paramViewGroup, View paramView1, View paramView2) {
    Matrix matrix = new Matrix();
    matrix.setTranslate(-paramView2.getScrollX(), -paramView2.getScrollY());
    ViewUtils.a(paramView1, matrix);
    ViewUtils.b((View)paramViewGroup, matrix);
    RectF rectF = new RectF(0.0F, 0.0F, paramView1.getWidth(), paramView1.getHeight());
    matrix.mapRect(rectF);
    int i = Math.round(rectF.left);
    int j = Math.round(rectF.top);
    int k = Math.round(rectF.right);
    int m = Math.round(rectF.bottom);
    ImageView imageView = new ImageView(paramView1.getContext());
    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    Bitmap bitmap = a(paramView1, matrix, rectF, paramViewGroup);
    if (bitmap != null)
      imageView.setImageBitmap(bitmap); 
    imageView.measure(View.MeasureSpec.makeMeasureSpec(k - i, 1073741824), View.MeasureSpec.makeMeasureSpec(m - j, 1073741824));
    imageView.layout(i, j, k, m);
    return (View)imageView;
  }
  
  static class MatrixEvaluator implements TypeEvaluator<Matrix> {
    final float[] a = new float[9];
    
    final float[] b = new float[9];
    
    final Matrix c = new Matrix();
    
    public Matrix evaluate(float param1Float, Matrix param1Matrix1, Matrix param1Matrix2) {
      param1Matrix1.getValues(this.a);
      param1Matrix2.getValues(this.b);
      int i;
      for (i = 0; i < 9; i++) {
        float[] arrayOfFloat1 = this.b;
        float f1 = arrayOfFloat1[i];
        float[] arrayOfFloat2 = this.a;
        float f2 = arrayOfFloat2[i];
        arrayOfFloat1[i] = arrayOfFloat2[i] + (f1 - f2) * param1Float;
      } 
      this.c.setValues(this.b);
      return this.c;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\TransitionUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */