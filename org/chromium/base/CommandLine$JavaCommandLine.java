package org.chromium.base;

import java.util.ArrayList;
import java.util.HashMap;

final class CommandLine$JavaCommandLine extends CommandLine {
  private ArrayList mArgs = new ArrayList();
  
  private int mArgsBegin = 1;
  
  private HashMap mSwitches = new HashMap<Object, Object>();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  CommandLine$JavaCommandLine(String[] paramArrayOfString) {
    super((byte)0);
    if (paramArrayOfString == null || paramArrayOfString.length == 0 || paramArrayOfString[0] == null) {
      this.mArgs.add("");
    } else {
      this.mArgs.add(paramArrayOfString[0]);
      appendSwitchesInternal(paramArrayOfString, 1);
    } 
    assert false;
  }
  
  private void appendSwitchWithValue(String paramString1, String paramString2) {
    String str1;
    String str3;
    HashMap<String, String> hashMap = this.mSwitches;
    if (paramString2 == null) {
      str3 = "";
    } else {
      str3 = paramString2;
    } 
    hashMap.put(paramString1, str3);
    StringBuilder stringBuilder = new StringBuilder("--");
    stringBuilder.append(paramString1);
    String str2 = stringBuilder.toString();
    paramString1 = str2;
    if (paramString2 != null) {
      paramString1 = str2;
      if (!paramString2.isEmpty()) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str2);
        stringBuilder1.append("=");
        stringBuilder1.append(paramString2);
        str1 = stringBuilder1.toString();
      } 
    } 
    ArrayList<String> arrayList = this.mArgs;
    int i = this.mArgsBegin;
    this.mArgsBegin = i + 1;
    arrayList.add(i, str1);
  }
  
  private void appendSwitchesInternal(String[] paramArrayOfString, int paramInt) {
    int k = paramArrayOfString.length;
    int j = paramInt;
    int i = 0;
    paramInt = 1;
    while (i < k) {
      String str = paramArrayOfString[i];
      if (j > 0) {
        j--;
      } else {
        if (str.equals("--"))
          paramInt = 0; 
        if (paramInt != 0 && str.startsWith("--")) {
          String[] arrayOfString = str.split("=", 2);
          if (arrayOfString.length > 1) {
            str = arrayOfString[1];
          } else {
            str = null;
          } 
          appendSwitchWithValue(arrayOfString[0].substring(2), str);
        } else {
          this.mArgs.add(str);
        } 
      } 
      i++;
    } 
  }
  
  public final void appendSwitch(String paramString) {
    appendSwitchWithValue(paramString, null);
  }
  
  protected final String[] getCommandLineArguments() {
    return (String[])this.mArgs.toArray((Object[])new String[this.mArgs.size()]);
  }
  
  public final String getSwitchValue(String paramString) {
    paramString = (String)this.mSwitches.get(paramString);
    return (paramString == null || paramString.isEmpty()) ? null : paramString;
  }
  
  public final boolean hasSwitch(String paramString) {
    return this.mSwitches.containsKey(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\CommandLine$JavaCommandLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */