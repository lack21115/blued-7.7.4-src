package com.blued.android.chat.core.pack;

import com.blued.android.chat.utils.BytesUtils;

public class BytesData {
  public final byte[] data;
  
  public final int length;
  
  public BytesData(int paramInt) {
    this.data = BytesUtils.getReuseByte(paramInt);
    this.length = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\BytesData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */