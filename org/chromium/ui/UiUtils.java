package org.chromium.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class UiUtils {
  private static final Map sAndroidUiThemeBlacklist;
  
  private static UiUtils$ContactsPickerDelegate sContactsPickerDelegate;
  
  private static UiUtils$KeyboardShowingDelegate sKeyboardShowingDelegate;
  
  private static UiUtils$PhotoPickerDelegate sPhotoPickerDelegate;
  
  static {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    sAndroidUiThemeBlacklist = hashMap;
    hashMap.put("xiaomi", Integer.valueOf(24));
    sAndroidUiThemeBlacklist.put("htc", Integer.valueOf(26));
    throw new VerifyError("bad dex opcode");
  }
  
  public static int computeMaxWidthOfListAdapterItems(ListAdapter paramListAdapter) {
    int i = 0;
    int k = View.MeasureSpec.makeMeasureSpec(0, 0);
    int m = View.MeasureSpec.makeMeasureSpec(0, 0);
    AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-2, -2);
    View[] arrayOfView = new View[paramListAdapter.getViewTypeCount()];
    int j = 0;
    while (i < paramListAdapter.getCount()) {
      View view;
      int n = paramListAdapter.getItemViewType(i);
      if (n < 0) {
        view = paramListAdapter.getView(i, null, null);
      } else {
        arrayOfView[n] = paramListAdapter.getView(i, arrayOfView[n], null);
        view = arrayOfView[n];
      } 
      view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      view.measure(k, m);
      j = Math.max(j, view.getMeasuredWidth());
      i++;
    } 
    return j;
  }
  
  public static File getDirectoryForImageCapture(Context paramContext) {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    try {
      File file;
      if (Build.VERSION.SDK_INT >= 18) {
        File file1 = new File(paramContext.getFilesDir(), "images");
        file = file1;
        if (!file1.exists())
          if (file1.mkdir()) {
            file = file1;
          } else {
            throw new IOException("Folder cannot be created.");
          }  
      } else {
        file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(file.getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append("browser-images");
        File file1 = new File(stringBuilder.toString());
        if (!file1.exists()) {
          boolean bool = file1.mkdirs();
          if (!bool)
            return file; 
        } 
        file = file1;
      } 
      return file;
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  @SuppressLint({"NewApi"})
  public static boolean isKeyboardShowing(Context paramContext, View paramView) {
    boolean bool;
    if (sKeyboardShowingDelegate != null && sKeyboardShowingDelegate.disableKeyboardCheck$4c9d37fd())
      return false; 
    paramView = paramView.getRootView();
    if (paramView == null)
      return false; 
    Rect rect = new Rect();
    paramView.getWindowVisibleDisplayFrame(rect);
    int i = rect.top;
    int j = paramView.getHeight() - rect.height() + i;
    if (j <= 0)
      return false; 
    if (rect.width() != paramView.getWidth()) {
      bool = true;
    } else {
      bool = false;
    } 
    i = j;
    if (!bool)
      if (Build.VERSION.SDK_INT >= 23) {
        i = j - paramView.getRootWindowInsets().getStableInsetBottom();
      } else {
        float f = (paramContext.getResources().getDisplayMetrics()).density;
        i = (int)(j - f * 100.0F);
      }  
    return (i > 0);
  }
  
  public static boolean shouldShowContactsPicker() {
    return (sContactsPickerDelegate != null);
  }
  
  public static boolean shouldShowPhotoPicker() {
    return (sPhotoPickerDelegate != null);
  }
  
  public static boolean showContactsPicker$9c96337() {
    return !(sContactsPickerDelegate == null);
  }
  
  public static boolean showPhotoPicker$7771399e() {
    return !(sPhotoPickerDelegate == null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\UiUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */