package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.content.Intent;

public class h extends a {
  public h(Context paramContext, String paramString) {
    super(paramContext, paramString);
  }
  
  public Intent b() {
    Intent intent = new Intent("com.android.filemanager.FILE_OPEN");
    intent.putExtra("FilePathToBeOpenAfterScan", this.b);
    intent.putExtra("com.iqoo.secure", true);
    intent.putExtra("OpenParentAndLocationDestFile", true);
    intent.addFlags(268435456);
    intent.addFlags(32768);
    intent.addFlags(1073741824);
    return intent;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */