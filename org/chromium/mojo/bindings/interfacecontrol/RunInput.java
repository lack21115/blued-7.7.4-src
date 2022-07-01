package org.chromium.mojo.bindings.interfacecontrol;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Union;

public final class RunInput extends Union {
  private FlushForTesting mFlushForTesting;
  
  private QueryVersion mQueryVersion;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static final RunInput decode(Decoder paramDecoder, int paramInt) {
    DataHeader dataHeader = paramDecoder.readDataHeaderForUnion(paramInt);
    if (dataHeader.size == 0)
      return null; 
    RunInput runInput = new RunInput();
    switch (dataHeader.elementsOrVersion) {
      default:
        return runInput;
      case 1:
        runInput.mFlushForTesting = FlushForTesting.decode(paramDecoder.readPointer(paramInt + 8, false));
        runInput.mTag = 1;
        return runInput;
      case 0:
        break;
    } 
    runInput.mQueryVersion = QueryVersion.decode(paramDecoder.readPointer(paramInt + 8, false));
    runInput.mTag = 0;
    return runInput;
  }
  
  protected final void encode(Encoder paramEncoder, int paramInt) {
    paramEncoder.encode(16, paramInt);
    paramEncoder.encode(this.mTag, paramInt + 4);
    switch (this.mTag) {
      default:
        return;
      case 1:
        paramEncoder.encode(this.mFlushForTesting, paramInt + 8, false);
        return;
      case 0:
        break;
    } 
    paramEncoder.encode(this.mQueryVersion, paramInt + 8, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\interfacecontrol\RunInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */