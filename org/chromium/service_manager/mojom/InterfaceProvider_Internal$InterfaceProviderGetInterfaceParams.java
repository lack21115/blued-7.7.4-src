package org.chromium.service_manager.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;

final class InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public String interfaceName;
  
  public MessagePipeHandle pipe = (MessagePipeHandle)InvalidHandle.INSTANCE;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams() {
    super(24);
  }
  
  public InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams(byte paramByte) {
    this();
  }
  
  private static InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams interfaceProvider_Internal$InterfaceProviderGetInterfaceParams = new InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams();
      interfaceProvider_Internal$InterfaceProviderGetInterfaceParams.interfaceName = paramDecoder.readString(8, false);
      interfaceProvider_Internal$InterfaceProviderGetInterfaceParams.pipe = paramDecoder.readMessagePipeHandle(16, false);
      return interfaceProvider_Internal$InterfaceProviderGetInterfaceParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.interfaceName, 8, false);
    paramEncoder.encode((Handle)this.pipe, 16, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\service_manager\mojom\InterfaceProvider_Internal$InterfaceProviderGetInterfaceParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */