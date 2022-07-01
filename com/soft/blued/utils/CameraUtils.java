package com.soft.blued.utils;

import android.content.Intent;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.soft.blued.app.permission.PermissionHelper;

public class CameraUtils {
  public static String a(Fragment paramFragment) {
    String str = RecyclingUtils.e("photo");
    PermissionHelper.b(new PermissionCallbacks(str, paramFragment) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", (Parcelable)FileUtils.b(this.a));
            intent.addFlags(2);
            intent.addFlags(1);
            if (AppMethods.a(intent)) {
              this.b.startActivityForResult(intent, 0);
              return;
            } 
            AppMethods.d(2131756364);
          }
        });
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\CameraUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */