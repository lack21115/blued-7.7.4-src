package org.chromium.components.embedder_support.delegate;

final class ColorChooserAndroid$1 implements OnColorChangedListener {
  public final void onColorChanged(int paramInt) {
    ColorChooserAndroid.access$000(ColorChooserAndroid.this).dismiss();
    ColorChooserAndroid.access$200(ColorChooserAndroid.this, ColorChooserAndroid.access$100(ColorChooserAndroid.this), paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\embedder_support\delegate\ColorChooserAndroid$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */