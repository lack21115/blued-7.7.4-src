package com.facebook.stetho.inspector.console;

import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.protocol.module.Console;

public class CLog {
  private static final String TAG = "CLog";
  
  public static void writeToConsole(ChromePeerManager paramChromePeerManager, Console.MessageLevel paramMessageLevel, Console.MessageSource paramMessageSource, String paramString) {
    LogRedirector.d("CLog", paramString);
    Console.ConsoleMessage consoleMessage = new Console.ConsoleMessage();
    consoleMessage.source = paramMessageSource;
    consoleMessage.level = paramMessageLevel;
    consoleMessage.text = paramString;
    Console.MessageAddedRequest messageAddedRequest = new Console.MessageAddedRequest();
    messageAddedRequest.message = consoleMessage;
    paramChromePeerManager.sendNotificationToPeers("Console.messageAdded", messageAddedRequest);
  }
  
  public static void writeToConsole(Console.MessageLevel paramMessageLevel, Console.MessageSource paramMessageSource, String paramString) {
    ConsolePeerManager consolePeerManager = ConsolePeerManager.getInstanceOrNull();
    if (consolePeerManager == null)
      return; 
    writeToConsole(consolePeerManager, paramMessageLevel, paramMessageSource, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\console\CLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */