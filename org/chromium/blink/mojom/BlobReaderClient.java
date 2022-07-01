package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.Interface;

public interface BlobReaderClient extends Interface {
  public static final Interface.Manager MANAGER = BlobReaderClient_Internal.MANAGER;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  void onCalculatedSize(long paramLong1, long paramLong2);
  
  void onComplete(int paramInt, long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\BlobReaderClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */