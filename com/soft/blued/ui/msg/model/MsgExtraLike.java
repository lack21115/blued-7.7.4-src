package com.soft.blued.ui.msg.model;

import android.text.TextUtils;
import java.io.Serializable;

public class MsgExtraLike implements Serializable {
  public String content;
  
  public String identical;
  
  public boolean isEmpty() {
    return (TextUtils.isEmpty(this.content) || TextUtils.isEmpty(this.identical));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\MsgExtraLike.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */