package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.chromium.mojo.system.Core;

final class Encoder$EncoderState {
  public ByteBuffer byteBuffer;
  
  public final Core core;
  
  public int dataEnd;
  
  public final List handles = new ArrayList();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private Encoder$EncoderState(Core paramCore, int paramInt) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Encoder$EncoderState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */