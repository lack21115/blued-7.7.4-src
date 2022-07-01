package com.facebook.stetho.dumpapp.plugins;

import android.os.Process;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.ArgsHelper;
import com.facebook.stetho.dumpapp.DumpException;
import com.facebook.stetho.dumpapp.DumpUsageException;
import com.facebook.stetho.dumpapp.DumperContext;
import com.facebook.stetho.dumpapp.DumperPlugin;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import javax.annotation.Nullable;

public class CrashDumperPlugin implements DumperPlugin {
  private static final String NAME = "crash";
  
  private static final String OPTION_EXIT_DEFAULT = "0";
  
  private static final String OPTION_KILL_DEFAULT = "9";
  
  private static final String OPTION_THROW_DEFAULT = "java.lang.Error";
  
  private void doKill(DumperContext paramDumperContext, Iterator<String> paramIterator) throws DumpException {
    String str = ArgsHelper.nextOptionalArg(paramIterator, "9");
    try {
      ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("-");
      stringBuilder.append(str);
      Process process = processBuilder.command(new String[] { "/system/bin/kill", stringBuilder.toString(), String.valueOf(Process.myPid()) }).redirectErrorStream(true).start();
      try {
        Util.copy(process.getInputStream(), paramDumperContext.getStdout(), new byte[1024]);
        return;
      } finally {
        process.destroy();
      } 
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to invoke kill: ");
      stringBuilder.append(iOException);
      throw new DumpException(stringBuilder.toString());
    } 
  }
  
  private void doSystemExit(Iterator<String> paramIterator) {
    System.exit(Integer.parseInt(ArgsHelper.nextOptionalArg(paramIterator, "0")));
  }
  
  private void doUncaughtException(Iterator<String> paramIterator) throws DumpException {
    String str = ArgsHelper.nextOptionalArg(paramIterator, "java.lang.Error");
    try {
      Throwable throwable;
      Class<?> clazz = Class.forName(str);
      Constructor<?> constructor = tryGetDeclaredConstructor(clazz, new Class[] { String.class });
      if (constructor != null) {
        throwable = (Throwable)constructor.newInstance(new Object[] { "Uncaught exception triggered by Stetho" });
      } else {
        throwable = throwable.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } 
      Thread thread = new Thread(new ThrowRunnable(throwable));
      thread.start();
      Util.joinUninterruptibly(thread);
      return;
    } catch (ClassNotFoundException classNotFoundException) {
    
    } catch (ClassCastException classCastException) {
    
    } catch (NoSuchMethodException noSuchMethodException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InstantiationException instantiationException) {
    
    } catch (InvocationTargetException invocationTargetException) {
      throw ExceptionUtil.propagate(invocationTargetException.getCause());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Invalid supplied Throwable class: ");
    stringBuilder.append(invocationTargetException);
    throw new DumpException(stringBuilder.toString());
  }
  
  private void doUsage(PrintStream paramPrintStream) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Usage: dumpapp crash ");
    stringBuilder.append("<command> [command-options]");
    paramPrintStream.println(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("Usage: dumpapp crash ");
    stringBuilder.append("throw");
    paramPrintStream.println(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("       dumpapp crash ");
    stringBuilder.append("kill");
    paramPrintStream.println(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append("       dumpapp crash ");
    stringBuilder.append("exit");
    paramPrintStream.println(stringBuilder.toString());
    paramPrintStream.println();
    paramPrintStream.println("dumpapp crash throw: Throw an uncaught exception (simulates a program crash)");
    paramPrintStream.println("    <Throwable>: Throwable class to use (default: java.lang.Error)");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp crash kill: Send a signal to this process (simulates the low memory killer)");
    paramPrintStream.println("    <SIGNAL>: Either signal name or number to send (default: 9)");
    paramPrintStream.println("              See `adb shell kill -l` for more information");
    paramPrintStream.println();
    paramPrintStream.println("dumpapp crash exit: Invoke System.exit (simulates an abnormal Android exit strategy)");
    paramPrintStream.println("    <code>: Exit code (default: 0)");
  }
  
  @Nullable
  private static <T> Constructor<? extends T> tryGetDeclaredConstructor(Class<T> paramClass, Class<?>... paramVarArgs) {
    try {
      return paramClass.getDeclaredConstructor(paramVarArgs);
    } catch (NoSuchMethodException noSuchMethodException) {
      return null;
    } 
  }
  
  public void dump(DumperContext paramDumperContext) throws DumpException {
    Iterator<String> iterator = paramDumperContext.getArgsAsList().iterator();
    String str = ArgsHelper.nextOptionalArg(iterator, null);
    if ("throw".equals(str)) {
      doUncaughtException(iterator);
      return;
    } 
    if ("kill".equals(str)) {
      doKill(paramDumperContext, iterator);
      return;
    } 
    if ("exit".equals(str)) {
      doSystemExit(iterator);
      return;
    } 
    doUsage(paramDumperContext.getStdout());
    if (str == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unsupported command: ");
    stringBuilder.append(str);
    throw new DumpUsageException(stringBuilder.toString());
  }
  
  public String getName() {
    return "crash";
  }
  
  static class ThrowRunnable implements Runnable {
    private final Throwable mThrowable;
    
    public ThrowRunnable(Throwable param1Throwable) {
      this.mThrowable = param1Throwable;
    }
    
    public void run() {
      ExceptionUtil.sneakyThrow(this.mThrowable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\dumpapp\plugins\CrashDumperPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */