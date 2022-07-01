package com.sina.weibo.sdk.api.share;

import android.os.Bundle;

public abstract class Base {
  public String transaction;
  
  public abstract void fromBundle(Bundle paramBundle);
  
  public abstract int getType();
  
  public abstract void toBundle(Bundle paramBundle);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\api\share\Base.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */