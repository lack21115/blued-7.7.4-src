package org.chromium.components.embedder_support.delegate;

import android.content.Context;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.ui.base.WindowAndroid;

public class ColorChooserAndroid {
  private final ColorPickerDialog mDialog;
  
  private final long mNativeColorChooserAndroid;
  
  private ColorChooserAndroid(long paramLong, Context paramContext, int paramInt, ColorSuggestion[] paramArrayOfColorSuggestion) {
    ColorChooserAndroid$1 colorChooserAndroid$1 = new ColorChooserAndroid$1(this);
    this.mNativeColorChooserAndroid = paramLong;
    this.mDialog = new ColorPickerDialog(paramContext, colorChooserAndroid$1, paramInt, paramArrayOfColorSuggestion);
  }
  
  @CalledByNative
  private static void addToColorSuggestionArray(ColorSuggestion[] paramArrayOfColorSuggestion, int paramInt1, int paramInt2, String paramString) {
    paramArrayOfColorSuggestion[paramInt1] = new ColorSuggestion(paramInt2, paramString);
  }
  
  @CalledByNative
  public static ColorChooserAndroid createColorChooserAndroid(long paramLong, WindowAndroid paramWindowAndroid, int paramInt, ColorSuggestion[] paramArrayOfColorSuggestion) {
    if (paramWindowAndroid == null)
      return null; 
    Context context = paramWindowAndroid.getContext().get();
    if (WindowAndroid.activityFromContext(context) == null)
      return null; 
    ColorChooserAndroid colorChooserAndroid = new ColorChooserAndroid(paramLong, context, paramInt, paramArrayOfColorSuggestion);
    colorChooserAndroid.mDialog.show();
    return colorChooserAndroid;
  }
  
  @CalledByNative
  private static ColorSuggestion[] createColorSuggestionArray(int paramInt) {
    return new ColorSuggestion[paramInt];
  }
  
  private native void nativeOnColorChosen(long paramLong, int paramInt);
  
  @CalledByNative
  public void closeColorChooser() {
    this.mDialog.dismiss();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\embedder_support\delegate\ColorChooserAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */