package org.chromium.shape_detection.mojom;

import org.chromium.mojo.bindings.DeserializationException;
import org.chromium.mojo.bindings.Interface;
import org.chromium.mojo.bindings.InterfaceControlMessagesHelper;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.bindings.MessageReceiver;
import org.chromium.mojo.bindings.ServiceMessage;
import org.chromium.mojo.system.Core;

final class TextDetection_Internal$Stub extends Interface.Stub {
  TextDetection_Internal$Stub(Core paramCore, TextDetection paramTextDetection) {
    super(paramCore, paramTextDetection);
  }
  
  public final boolean accept(Message paramMessage) {
    try {
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      return !messageHeader.validateHeader(0) ? false : ((messageHeader.mType != -2) ? false : InterfaceControlMessagesHelper.handleRunOrClosePipe(TextDetection_Internal.MANAGER, serviceMessage));
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
  }
  
  public final boolean acceptWithResponder(Message paramMessage, MessageReceiver paramMessageReceiver) {
    try {
      TextDetection_Internal$TextDetectionDetectParams textDetection_Internal$TextDetectionDetectParams;
      ServiceMessage serviceMessage = paramMessage.asServiceMessage();
      MessageHeader messageHeader = serviceMessage.mHeader;
      if (!messageHeader.validateHeader(1))
        return false; 
      switch (messageHeader.mType) {
        case 0:
          textDetection_Internal$TextDetectionDetectParams = TextDetection_Internal$TextDetectionDetectParams.deserialize(serviceMessage.getPayload());
          ((TextDetection)this.mImpl).detect(textDetection_Internal$TextDetectionDetectParams.bitmapData, new TextDetection_Internal$TextDetectionDetectResponseParamsProxyToResponder(this.mCore, paramMessageReceiver, messageHeader.getRequestId()));
          return true;
        case -1:
          return InterfaceControlMessagesHelper.handleRun(this.mCore, TextDetection_Internal.MANAGER, (ServiceMessage)textDetection_Internal$TextDetectionDetectParams, paramMessageReceiver);
      } 
    } catch (DeserializationException deserializationException) {
      System.err.println(deserializationException.toString());
      return false;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\mojom\TextDetection_Internal$Stub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */