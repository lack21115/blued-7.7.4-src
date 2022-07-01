package org.chromium.base;

final class CommandLine$NativeCommandLine extends CommandLine {
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public CommandLine$NativeCommandLine(String[] paramArrayOfString) {
    super((byte)0);
    CommandLine.nativeInit(paramArrayOfString);
  }
  
  public final void appendSwitch(String paramString) {
    CommandLine.nativeAppendSwitch(paramString);
  }
  
  protected final void destroy() {
    throw new IllegalStateException("Can't destroy native command line after startup");
  }
  
  protected final String[] getCommandLineArguments() {
    assert false;
    throw new AssertionError();
  }
  
  public final String getSwitchValue(String paramString) {
    return CommandLine.nativeGetSwitchValue(paramString);
  }
  
  public final boolean hasSwitch(String paramString) {
    return CommandLine.nativeHasSwitch(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\CommandLine$NativeCommandLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */