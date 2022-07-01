package org.chromium.mojo.bindings.interfacecontrol;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Union;

public final class RunOrClosePipeInput extends Union {
  public RequireVersion mRequireVersion;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static final RunOrClosePipeInput decode(Decoder paramDecoder, int paramInt) {
    DataHeader dataHeader = paramDecoder.readDataHeaderForUnion(paramInt);
    if (dataHeader.size == 0)
      return null; 
    RunOrClosePipeInput runOrClosePipeInput = new RunOrClosePipeInput();
    if (dataHeader.elementsOrVersion != 0)
      return runOrClosePipeInput; 
    runOrClosePipeInput.mRequireVersion = RequireVersion.decode(paramDecoder.readPointer(paramInt + 8, false));
    runOrClosePipeInput.mTag = 0;
    return runOrClosePipeInput;
  }
  
  protected final void encode(Encoder paramEncoder, int paramInt) {
    paramEncoder.encode(16, paramInt);
    paramEncoder.encode(this.mTag, paramInt + 4);
    if (this.mTag != 0)
      return; 
    paramEncoder.encode(this.mRequireVersion, paramInt + 8, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\interfacecontrol\RunOrClosePipeInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */