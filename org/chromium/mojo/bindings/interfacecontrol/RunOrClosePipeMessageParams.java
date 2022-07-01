package org.chromium.mojo.bindings.interfacecontrol;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

public final class RunOrClosePipeMessageParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public RunOrClosePipeInput input;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private RunOrClosePipeMessageParams() {
    super(24);
  }
  
  private static RunOrClosePipeMessageParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      RunOrClosePipeMessageParams runOrClosePipeMessageParams = new RunOrClosePipeMessageParams();
      runOrClosePipeMessageParams.input = RunOrClosePipeInput.decode(paramDecoder, 8);
      return runOrClosePipeMessageParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static RunOrClosePipeMessageParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.input, 8, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\interfacecontrol\RunOrClosePipeMessageParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */