package org.chromium.mojo.bindings.interfacecontrol;

import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Union;

public final class RunOutput extends Union {
  public QueryVersionResult mQueryVersionResult;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  protected final void encode(Encoder paramEncoder, int paramInt) {
    paramEncoder.encode(16, paramInt);
    paramEncoder.encode(this.mTag, paramInt + 4);
    if (this.mTag != 0)
      return; 
    paramEncoder.encode(this.mQueryVersionResult, paramInt + 8, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\interfacecontrol\RunOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */