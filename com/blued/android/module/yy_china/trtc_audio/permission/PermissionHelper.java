package com.blued.android.module.yy_china.trtc_audio.permission;

import com.blued.android.framework.R;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.permission.PermissionManager;
import java.util.HashMap;

public final class PermissionHelper {
  private static void a() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("android.permission.CAMERA", Integer.valueOf(R.string.permission_camera));
    hashMap.put("android.permission.RECORD_AUDIO", Integer.valueOf(R.string.permission_mic));
    hashMap.put("android.permission.READ_PHONE_STATE", Integer.valueOf(R.string.permission_phone));
    hashMap.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(R.string.permission_storage));
    hashMap.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(R.string.permission_storage));
    PermissionManager.a(hashMap);
  }
  
  public static void a(PermissionCallbacks paramPermissionCallbacks) {
    a();
    PermissionManager.a(paramPermissionCallbacks, new String[] { "android.permission.RECORD_AUDIO" });
  }
  
  public static boolean a(String... paramVarArgs) {
    return PermissionManager.a(paramVarArgs);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\trtc_audio\permission\PermissionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */