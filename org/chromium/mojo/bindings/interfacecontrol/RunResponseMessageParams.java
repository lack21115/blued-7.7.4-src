package org.chromium.mojo.bindings.interfacecontrol;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class RunResponseMessageParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO = (new DataHeader[1])[0];
  
  public RunOutput output;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private RunResponseMessageParams() {
    super(24);
  }
  
  public RunResponseMessageParams(byte paramByte) {
    this();
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.output, 8, true);
  }
  
  static {
    (new DataHeader[1])[0] = new DataHeader(24, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\interfacecontrol\RunResponseMessageParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */