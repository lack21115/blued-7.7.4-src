package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class PopupWindowCompat$PopupWindowCompatApi21Impl extends PopupWindowCompat$PopupWindowCompatApi19Impl {
  private static Field sOverlapAnchorField;
  
  static {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (NoSuchFieldException noSuchFieldException) {
      Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", noSuchFieldException);
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean) {
    if (sOverlapAnchorField != null)
      try {
        sOverlapAnchorField.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
        return;
      } catch (IllegalAccessException illegalAccessException) {
        Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", illegalAccessException);
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\widget\PopupWindowCompat$PopupWindowCompatApi21Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */