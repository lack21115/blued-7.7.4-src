package com.huawei.hms.ui;

import android.content.Context;
import com.huawei.hms.utils.ResourceLoaderUtil;

public abstract class AbstractPromptDialog extends AbstractDialog {
  protected String onGetNegativeButtonString(Context paramContext) {
    return null;
  }
  
  protected String onGetTitleString(Context paramContext) {
    if (ResourceLoaderUtil.getmContext() == null)
      ResourceLoaderUtil.setmContext(paramContext); 
    return ResourceLoaderUtil.getString("hms_bindfaildlg_title");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\ui\AbstractPromptDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */