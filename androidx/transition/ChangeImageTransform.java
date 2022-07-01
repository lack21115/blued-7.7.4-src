package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;

public class ChangeImageTransform extends Transition {
  private static final String[] a = new String[] { "android:changeImageTransform:matrix", "android:changeImageTransform:bounds" };
  
  private static final TypeEvaluator<Matrix> i = new TypeEvaluator<Matrix>() {
      public Matrix evaluate(float param1Float, Matrix param1Matrix1, Matrix param1Matrix2) {
        return null;
      }
    };
  
  private static final Property<ImageView, Matrix> j = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") {
      public Matrix get(ImageView param1ImageView) {
        return null;
      }
      
      public void set(ImageView param1ImageView, Matrix param1Matrix) {
        ImageViewUtils.a(param1ImageView, param1Matrix);
      }
    };
  
  public ChangeImageTransform() {}
  
  public ChangeImageTransform(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private ObjectAnimator a(ImageView paramImageView) {
    return ObjectAnimator.ofObject(paramImageView, j, i, (Object[])new Matrix[] { MatrixUtils.a, MatrixUtils.a });
  }
  
  private ObjectAnimator a(ImageView paramImageView, Matrix paramMatrix1, Matrix paramMatrix2) {
    return ObjectAnimator.ofObject(paramImageView, j, new TransitionUtils.MatrixEvaluator(), (Object[])new Matrix[] { paramMatrix1, paramMatrix2 });
  }
  
  private static Matrix b(ImageView paramImageView) {
    Drawable drawable = paramImageView.getDrawable();
    if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
      int i = null.a[paramImageView.getScaleType().ordinal()];
      if (i != 1) {
        if (i == 2)
          return d(paramImageView); 
      } else {
        return c(paramImageView);
      } 
    } 
    return new Matrix(paramImageView.getImageMatrix());
  }
  
  private void b(TransitionValues paramTransitionValues) {
    View view = paramTransitionValues.view;
    if (view instanceof ImageView) {
      if (view.getVisibility() != 0)
        return; 
      ImageView imageView = (ImageView)view;
      if (imageView.getDrawable() == null)
        return; 
      Map<String, Object> map = paramTransitionValues.values;
      map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
      map.put("android:changeImageTransform:matrix", b(imageView));
    } 
  }
  
  private static Matrix c(ImageView paramImageView) {
    Drawable drawable = paramImageView.getDrawable();
    Matrix matrix = new Matrix();
    matrix.postScale(paramImageView.getWidth() / drawable.getIntrinsicWidth(), paramImageView.getHeight() / drawable.getIntrinsicHeight());
    return matrix;
  }
  
  private static Matrix d(ImageView paramImageView) {
    Drawable drawable = paramImageView.getDrawable();
    int i = drawable.getIntrinsicWidth();
    float f1 = paramImageView.getWidth();
    float f2 = i;
    float f5 = f1 / f2;
    i = drawable.getIntrinsicHeight();
    float f3 = paramImageView.getHeight();
    float f4 = i;
    f5 = Math.max(f5, f3 / f4);
    i = Math.round((f1 - f2 * f5) / 2.0F);
    int j = Math.round((f3 - f4 * f5) / 2.0F);
    Matrix matrix = new Matrix();
    matrix.postScale(f5, f5);
    matrix.postTranslate(i, j);
    return matrix;
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    Matrix matrix;
    ViewGroup viewGroup = null;
    paramViewGroup = viewGroup;
    if (paramTransitionValues1 != null) {
      if (paramTransitionValues2 == null)
        return null; 
      Rect rect1 = (Rect)paramTransitionValues1.values.get("android:changeImageTransform:bounds");
      Rect rect2 = (Rect)paramTransitionValues2.values.get("android:changeImageTransform:bounds");
      paramViewGroup = viewGroup;
      if (rect1 != null) {
        if (rect2 == null)
          return null; 
        Matrix matrix1 = (Matrix)paramTransitionValues1.values.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix)paramTransitionValues2.values.get("android:changeImageTransform:matrix");
        if ((matrix1 == null && matrix2 == null) || (matrix1 != null && matrix1.equals(matrix2))) {
          i = 1;
        } else {
          i = 0;
        } 
        if (rect1.equals(rect2) && i)
          return null; 
        ImageView imageView = (ImageView)paramTransitionValues2.view;
        Drawable drawable = imageView.getDrawable();
        int i = drawable.getIntrinsicWidth();
        int j = drawable.getIntrinsicHeight();
        if (i <= 0 || j <= 0)
          return (Animator)a(imageView); 
        matrix = matrix1;
        if (matrix1 == null)
          matrix = MatrixUtils.a; 
        matrix1 = matrix2;
        if (matrix2 == null)
          matrix1 = MatrixUtils.a; 
        j.set(imageView, matrix);
        return (Animator)a(imageView, matrix, matrix1);
      } 
    } 
    return (Animator)matrix;
  }
  
  public String[] getTransitionProperties() {
    return a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ChangeImageTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */