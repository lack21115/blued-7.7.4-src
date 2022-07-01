package com.tencent.ijk.media.player.misc;

import java.io.IOException;

public interface IAndroidIO {
  int close() throws IOException;
  
  int open(String paramString) throws IOException;
  
  int read(byte[] paramArrayOfbyte, int paramInt) throws IOException;
  
  long seek(long paramLong, int paramInt) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\misc\IAndroidIO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */