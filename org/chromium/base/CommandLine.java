package org.chromium.base;

import android.util.Log;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public abstract class CommandLine {
  private static final AtomicReference sCommandLine;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private CommandLine() {}
  
  public static void enableNativeProxy() {
    AtomicReference<CommandLine$NativeCommandLine> atomicReference = sCommandLine;
    CommandLine commandLine = sCommandLine.get();
    if (commandLine != null) {
      String[] arrayOfString = commandLine.getCommandLineArguments();
    } else {
      commandLine = null;
    } 
    atomicReference.set(new CommandLine$NativeCommandLine((String[])commandLine));
  }
  
  public static CommandLine getInstance() {
    CommandLine commandLine = sCommandLine.get();
    assert false;
    return commandLine;
  }
  
  public static void init(String[] paramArrayOfString) {
    CommandLine$JavaCommandLine commandLine$JavaCommandLine = new CommandLine$JavaCommandLine(paramArrayOfString);
    CommandLine commandLine = sCommandLine.getAndSet(commandLine$JavaCommandLine);
    if (commandLine != null)
      commandLine.destroy(); 
  }
  
  public static void initFromFile(String paramString) {
    StringBuilder stringBuilder;
    char[] arrayOfChar = readFileAsUtf8(paramString);
    paramString = null;
    if (arrayOfChar != null)
      if (arrayOfChar.length <= 65536) {
        StringBuilder stringBuilder1;
        ArrayList<String> arrayList = new ArrayList();
        int j = arrayOfChar.length;
        paramString = null;
        int i = 0;
        char c = Character.MIN_VALUE;
        while (i < j) {
          char c2;
          StringBuilder stringBuilder2;
          char c1 = arrayOfChar[i];
          if ((!c && (c1 == '\'' || c1 == '"')) || c1 == c) {
            if (paramString != null && paramString.length() > 0 && paramString.charAt(paramString.length() - 1) == '\\') {
              paramString.setCharAt(paramString.length() - 1, c1);
              c2 = c;
              String str = paramString;
            } else {
              if (c == '\000') {
                c = c1;
              } else {
                c = Character.MIN_VALUE;
              } 
              c2 = c;
              String str = paramString;
            } 
          } else if (c == '\000' && Character.isWhitespace(c1)) {
            c2 = c;
            String str = paramString;
            if (paramString != null) {
              arrayList.add(paramString.toString());
              str = null;
              c2 = c;
            } 
          } else {
            String str = paramString;
            if (paramString == null)
              stringBuilder2 = new StringBuilder(); 
            stringBuilder2.append(c1);
            c2 = c;
          } 
          i++;
          c = c2;
          stringBuilder1 = stringBuilder2;
        } 
        if (stringBuilder1 != null) {
          if (c != '\000') {
            StringBuilder stringBuilder2 = new StringBuilder("Unterminated quoted string: ");
            stringBuilder2.append(stringBuilder1);
            Log.w("CommandLine", stringBuilder2.toString());
          } 
          arrayList.add(stringBuilder1.toString());
        } 
        String[] arrayOfString = arrayList.<String>toArray(new String[arrayList.size()]);
      } else {
        stringBuilder = new StringBuilder("Flags file too big: ");
        stringBuilder.append(arrayOfChar.length);
        throw new RuntimeException(stringBuilder.toString());
      }  
    init((String[])stringBuilder);
  }
  
  public static boolean isInitialized() {
    return (sCommandLine.get() != null);
  }
  
  static native void nativeAppendSwitch(String paramString);
  
  private static native void nativeAppendSwitchWithValue(String paramString1, String paramString2);
  
  private static native void nativeAppendSwitchesAndArguments(String[] paramArrayOfString);
  
  static native String nativeGetSwitchValue(String paramString);
  
  static native boolean nativeHasSwitch(String paramString);
  
  static native void nativeInit(String[] paramArrayOfString);
  
  private static char[] readFileAsUtf8(String paramString) {
    File file = new File(paramString);
    try {
      Throwable throwable1;
      FileReader fileReader = new FileReader(file);
      try {
        char[] arrayOfChar = new char[(int)file.length()];
        arrayOfChar = Arrays.copyOfRange(arrayOfChar, 0, fileReader.read(arrayOfChar));
        return arrayOfChar;
      } catch (Throwable null) {
        try {
          throw throwable1;
        } finally {}
      } finally {
        file = null;
      } 
      if (throwable1 != null) {
        try {
          fileReader.close();
        } catch (Throwable throwable2) {
          ThrowableExtension.addSuppressed(throwable1, throwable2);
        } 
      } else {
        throwable2.close();
      } 
      throw file;
    } catch (IOException iOException) {
      return null;
    } 
  }
  
  public abstract void appendSwitch(String paramString);
  
  protected void destroy() {}
  
  protected abstract String[] getCommandLineArguments();
  
  public abstract String getSwitchValue(String paramString);
  
  public abstract boolean hasSwitch(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\CommandLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */