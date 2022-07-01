package com.tencent.ijk.media.player.misc;

import java.io.IOException;

public interface IMediaDataSource {
  void close() throws IOException;
  
  long getSize() throws IOException;
  
  int readAt(long paramLong, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\misc\IMediaDataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */