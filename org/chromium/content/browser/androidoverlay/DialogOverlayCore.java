package org.chromium.content.browser.androidoverlay;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.view.WindowManager;
import org.chromium.base.Log;
import org.chromium.gfx.mojom.Rect;

final class DialogOverlayCore {
  boolean mAsPanel;
  
  Dialog mDialog;
  
  DialogOverlayCore$Callbacks mDialogCallbacks;
  
  DialogOverlayCore$Host mHost;
  
  WindowManager.LayoutParams mLayoutParams;
  
  final boolean copyRectToLayoutParams(Rect paramRect) {
    if (this.mLayoutParams.x == paramRect.x && this.mLayoutParams.y == paramRect.y && this.mLayoutParams.width == paramRect.width && this.mLayoutParams.height == paramRect.height)
      return false; 
    this.mLayoutParams.x = paramRect.x;
    this.mLayoutParams.y = paramRect.y;
    this.mLayoutParams.width = paramRect.width;
    this.mLayoutParams.height = paramRect.height;
    return true;
  }
  
  @SuppressLint({"RtlHardcoded"})
  final WindowManager.LayoutParams createLayoutParams(boolean paramBoolean) {
    int i;
    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
    layoutParams.gravity = 51;
    if (this.mAsPanel) {
      i = 1000;
    } else {
      i = 1001;
    } 
    layoutParams.type = i;
    layoutParams.flags = 568;
    if (paramBoolean)
      layoutParams.flags |= 0x2000; 
    try {
      i = ((Integer)layoutParams.getClass().getField("privateFlags").get(layoutParams)).intValue();
      layoutParams.getClass().getField("privateFlags").set(layoutParams, Integer.valueOf(i | 0x40));
    } catch (NoSuchFieldException noSuchFieldException) {
    
    } catch (NullPointerException nullPointerException) {
    
    } catch (SecurityException securityException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (IllegalArgumentException illegalArgumentException) {
    
    } catch (ExceptionInInitializerError exceptionInInitializerError) {
      return layoutParams;
    } 
    return layoutParams;
  }
  
  final void dismissDialogQuietly() {
    if (this.mDialog != null && this.mDialog.isShowing())
      try {
        this.mDialog.dismiss();
      } catch (Exception exception) {
        Log.w("DSCore", "Failed to dismiss overlay dialog.  \"WindowLeaked\" is ignorable.", new Object[0]);
      }  
    this.mDialog = null;
    this.mDialogCallbacks = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\androidoverlay\DialogOverlayCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */