package org.chromium.mojo.bindings.interfacecontrol;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class QueryVersionResult extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO = (new DataHeader[1])[0];
  
  public int version;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private QueryVersionResult() {
    super(16);
  }
  
  public QueryVersionResult(byte paramByte) {
    this();
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.version, 8);
  }
  
  static {
    (new DataHeader[1])[0] = new DataHeader(16, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\interfacecontrol\QueryVersionResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */