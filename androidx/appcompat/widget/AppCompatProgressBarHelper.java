package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.WrappedDrawable;

class AppCompatProgressBarHelper {
  private static final int[] a = new int[] { 16843067, 16843068 };
  
  private final ProgressBar b;
  
  private Bitmap c;
  
  AppCompatProgressBarHelper(ProgressBar paramProgressBar) {
    this.b = paramProgressBar;
  }
  
  private Drawable a(Drawable paramDrawable) {
    AnimationDrawable animationDrawable;
    Drawable drawable = paramDrawable;
    if (paramDrawable instanceof AnimationDrawable) {
      AnimationDrawable animationDrawable1 = (AnimationDrawable)paramDrawable;
      int j = animationDrawable1.getNumberOfFrames();
      animationDrawable = new AnimationDrawable();
      animationDrawable.setOneShot(animationDrawable1.isOneShot());
      for (int i = 0; i < j; i++) {
        Drawable drawable1 = a(animationDrawable1.getFrame(i), true);
        drawable1.setLevel(10000);
        animationDrawable.addFrame(drawable1, animationDrawable1.getDuration(i));
      } 
      animationDrawable.setLevel(10000);
    } 
    return (Drawable)animationDrawable;
  }
  
  private Drawable a(Drawable paramDrawable, boolean paramBoolean) {
    ShapeDrawable shapeDrawable;
    if (paramDrawable instanceof WrappedDrawable) {
      WrappedDrawable wrappedDrawable = (WrappedDrawable)paramDrawable;
      Drawable drawable2 = wrappedDrawable.getWrappedDrawable();
      Drawable drawable1 = paramDrawable;
      if (drawable2 != null) {
        wrappedDrawable.setWrappedDrawable(a(drawable2, paramBoolean));
        return paramDrawable;
      } 
    } else {
      LayerDrawable layerDrawable1;
      if (paramDrawable instanceof LayerDrawable) {
        layerDrawable1 = (LayerDrawable)paramDrawable;
        int j = layerDrawable1.getNumberOfLayers();
        Drawable[] arrayOfDrawable = new Drawable[j];
        boolean bool = false;
        int i;
        for (i = 0; i < j; i++) {
          int k = layerDrawable1.getId(i);
          Drawable drawable = layerDrawable1.getDrawable(i);
          if (k == 16908301 || k == 16908303) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          } 
          arrayOfDrawable[i] = a(drawable, paramBoolean);
        } 
        LayerDrawable layerDrawable = new LayerDrawable(arrayOfDrawable);
        for (i = bool; i < j; i++)
          layerDrawable.setId(i, layerDrawable1.getId(i)); 
        return (Drawable)layerDrawable;
      } 
      LayerDrawable layerDrawable2 = layerDrawable1;
      if (layerDrawable1 instanceof BitmapDrawable) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable)layerDrawable1;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (this.c == null)
          this.c = bitmap; 
        shapeDrawable = new ShapeDrawable(b());
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
        shapeDrawable.getPaint().setShader((Shader)bitmapShader);
        shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
        if (paramBoolean)
          return (Drawable)new ClipDrawable((Drawable)shapeDrawable, 3, 1); 
      } 
    } 
    return (Drawable)shapeDrawable;
  }
  
  private Shape b() {
    return (Shape)new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null);
  }
  
  Bitmap a() {
    return this.c;
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt) {
    TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes(this.b.getContext(), paramAttributeSet, a, paramInt, 0);
    Drawable drawable = tintTypedArray.getDrawableIfKnown(0);
    if (drawable != null)
      this.b.setIndeterminateDrawable(a(drawable)); 
    drawable = tintTypedArray.getDrawableIfKnown(1);
    if (drawable != null)
      this.b.setProgressDrawable(a(drawable, false)); 
    tintTypedArray.recycle();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatProgressBarHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */