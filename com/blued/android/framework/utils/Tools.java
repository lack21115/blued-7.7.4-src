package com.blued.android.framework.utils;

import android.app.Activity;
import android.os.Environment;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class Tools {
  public static String a() {
    File file;
    if (b()) {
      file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    } else {
      file = AppInfo.d().getFilesDir();
    } 
    if (file != null) {
      file = new File(file.getAbsolutePath(), "blued");
      if (!file.exists())
        file.mkdirs(); 
      return file.getAbsolutePath();
    } 
    return "";
  }
  
  public static void a(OutputStream paramOutputStream) {
    if (paramOutputStream != null)
      try {
        paramOutputStream.close();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
  }
  
  public static boolean a(Activity paramActivity) {
    return (paramActivity == null) ? false : ((paramActivity != null) ? (!paramActivity.isFinishing()) : false);
  }
  
  public static boolean a(Fragment paramFragment) {
    return (paramFragment == null || !paramFragment.isAdded()) ? false : a((Activity)paramFragment.getActivity());
  }
  
  public static boolean b() {
    return Environment.getExternalStorageState().equals("mounted");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\Tools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */