package org.chromium.mojo.bindings;

import org.chromium.mojo.bindings.interfacecontrol.QueryVersionResult;
import org.chromium.mojo.bindings.interfacecontrol.RunMessageParams;
import org.chromium.mojo.bindings.interfacecontrol.RunOrClosePipeInput;
import org.chromium.mojo.bindings.interfacecontrol.RunOrClosePipeMessageParams;
import org.chromium.mojo.bindings.interfacecontrol.RunOutput;
import org.chromium.mojo.bindings.interfacecontrol.RunResponseMessageParams;
import org.chromium.mojo.system.Core;

public final class InterfaceControlMessagesHelper {
  public static boolean handleRun(Core paramCore, Interface$Manager paramInterface$Manager, ServiceMessage paramServiceMessage, MessageReceiver paramMessageReceiver) {
    RunMessageParams runMessageParams = RunMessageParams.deserialize(paramServiceMessage.getPayload());
    RunResponseMessageParams runResponseMessageParams = new RunResponseMessageParams((byte)0);
    runResponseMessageParams.output = new RunOutput();
    if (((Union)runMessageParams.input).mTag == 0) {
      RunOutput runOutput = runResponseMessageParams.output;
      QueryVersionResult queryVersionResult = new QueryVersionResult((byte)0);
      runOutput.mTag = 0;
      runOutput.mQueryVersionResult = queryVersionResult;
      runOutput = runResponseMessageParams.output;
      if (RunOutput.$assertionsDisabled || runOutput.mTag == 0) {
        runOutput.mQueryVersionResult.version = paramInterface$Manager.getVersion();
        return paramMessageReceiver.accept(runResponseMessageParams.serializeWithHeader(paramCore, new MessageHeader(-1, 2, paramServiceMessage.mHeader.getRequestId())));
      } 
      throw new AssertionError();
    } 
    runResponseMessageParams.output = null;
    return paramMessageReceiver.accept(runResponseMessageParams.serializeWithHeader(paramCore, new MessageHeader(-1, 2, paramServiceMessage.mHeader.getRequestId())));
  }
  
  public static boolean handleRunOrClosePipe(Interface$Manager paramInterface$Manager, ServiceMessage paramServiceMessage) {
    RunOrClosePipeMessageParams runOrClosePipeMessageParams = RunOrClosePipeMessageParams.deserialize(paramServiceMessage.getPayload());
    if (((Union)runOrClosePipeMessageParams.input).mTag == 0) {
      RunOrClosePipeInput runOrClosePipeInput = runOrClosePipeMessageParams.input;
      if (RunOrClosePipeInput.$assertionsDisabled || runOrClosePipeInput.mTag == 0)
        return (runOrClosePipeInput.mRequireVersion.version <= paramInterface$Manager.getVersion()); 
      throw new AssertionError();
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\InterfaceControlMessagesHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */