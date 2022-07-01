package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.util.SystemUtil;
import java.io.File;

final class b {
  private static String a = SystemUtil.buildNewPathByProcessName("e_qq_com_plugin");
  
  static {
    SystemUtil.buildNewPathByProcessName("e_qq_com_dex");
  }
  
  static File a(Context paramContext) {
    return new File(paramContext.getDir(a, 0), "update_lc");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\managers\plugin\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */