package com.facebook.stetho.dumpapp;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

public class Dumper {
  private final Map<String, DumperPlugin> mDumperPlugins;
  
  private final GlobalOptions mGlobalOptions;
  
  private final CommandLineParser mParser;
  
  public Dumper(Iterable<DumperPlugin> paramIterable) {
    this(paramIterable, (CommandLineParser)new GnuParser());
  }
  
  public Dumper(Iterable<DumperPlugin> paramIterable, CommandLineParser paramCommandLineParser) {
    this.mDumperPlugins = generatePluginMap(paramIterable);
    this.mParser = paramCommandLineParser;
    this.mGlobalOptions = new GlobalOptions();
  }
  
  private int doDump(InputStream paramInputStream, PrintStream paramPrintStream1, PrintStream paramPrintStream2, String[] paramArrayOfString) throws ParseException, DumpException {
    CommandLine commandLine = this.mParser.parse(this.mGlobalOptions.options, paramArrayOfString, true);
    if (commandLine.hasOption(this.mGlobalOptions.optionHelp.getOpt())) {
      dumpUsage(paramPrintStream1);
      return 0;
    } 
    if (commandLine.hasOption(this.mGlobalOptions.optionListPlugins.getOpt())) {
      dumpAvailablePlugins(paramPrintStream1);
      return 0;
    } 
    if (!commandLine.getArgList().isEmpty()) {
      dumpPluginOutput(paramInputStream, paramPrintStream1, paramPrintStream2, commandLine);
      return 0;
    } 
    dumpUsage(paramPrintStream2);
    return 1;
  }
  
  private void dumpAvailablePlugins(PrintStream paramPrintStream) {
    ArrayList<String> arrayList = new ArrayList();
    Iterator<DumperPlugin> iterator1 = this.mDumperPlugins.values().iterator();
    while (iterator1.hasNext())
      arrayList.add(((DumperPlugin)iterator1.next()).getName()); 
    Collections.sort(arrayList);
    Iterator<String> iterator = arrayList.iterator();
    while (iterator.hasNext())
      paramPrintStream.println(iterator.next()); 
  }
  
  private void dumpPluginOutput(InputStream paramInputStream, PrintStream paramPrintStream1, PrintStream paramPrintStream2, CommandLine paramCommandLine) throws DumpException {
    ArrayList<String> arrayList = new ArrayList(paramCommandLine.getArgList());
    if (arrayList.size() >= 1) {
      String str = arrayList.remove(0);
      DumperPlugin dumperPlugin = this.mDumperPlugins.get(str);
      if (dumperPlugin != null) {
        dumperPlugin.dump(new DumperContext(paramInputStream, paramPrintStream1, paramPrintStream2, this.mParser, arrayList));
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("No plugin named '");
      stringBuilder.append(str);
      stringBuilder.append("'");
      throw new DumpException(stringBuilder.toString());
    } 
    throw new DumpException("Expected plugin argument");
  }
  
  private void dumpUsage(PrintStream paramPrintStream) {
    null = new HelpFormatter();
    paramPrintStream.println("Usage: dumpapp [options] <plugin> [plugin-options]");
    PrintWriter printWriter = new PrintWriter(paramPrintStream);
    try {
      null.printOptions(printWriter, null.getWidth(), this.mGlobalOptions.options, null.getLeftPadding(), null.getDescPadding());
      return;
    } finally {
      printWriter.flush();
    } 
  }
  
  private static Map<String, DumperPlugin> generatePluginMap(Iterable<DumperPlugin> paramIterable) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (DumperPlugin dumperPlugin : paramIterable)
      hashMap.put(dumperPlugin.getName(), dumperPlugin); 
    return (Map)Collections.unmodifiableMap(hashMap);
  }
  
  public int dump(InputStream paramInputStream, PrintStream paramPrintStream1, PrintStream paramPrintStream2, String[] paramArrayOfString) {
    try {
      return doDump(paramInputStream, paramPrintStream1, paramPrintStream2, paramArrayOfString);
    } catch (ParseException parseException) {
      paramPrintStream2.println(parseException.getMessage());
      dumpUsage(paramPrintStream2);
      return 1;
    } catch (DumpException dumpException) {
      paramPrintStream2.println(dumpException.getMessage());
      return 1;
    } catch (DumpappOutputBrokenException dumpappOutputBrokenException) {
      throw dumpappOutputBrokenException;
    } catch (RuntimeException runtimeException) {
      runtimeException.printStackTrace(paramPrintStream2);
      return 1;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\dumpapp\Dumper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */