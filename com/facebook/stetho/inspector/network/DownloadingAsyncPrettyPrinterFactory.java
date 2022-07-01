package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

public abstract class DownloadingAsyncPrettyPrinterFactory implements AsyncPrettyPrinterFactory {
  private static void doErrorPrint(PrintWriter paramPrintWriter, InputStream paramInputStream, String paramString) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("\n");
    stringBuilder.append(Util.readAsUTF8(paramInputStream));
    paramPrintWriter.print(stringBuilder.toString());
  }
  
  private static AsyncPrettyPrinter getErrorAsyncPrettyPrinter(final String headerName, final String headerValue) {
    return new AsyncPrettyPrinter() {
        public PrettyPrinterDisplayType getPrettifiedType() {
          return PrettyPrinterDisplayType.TEXT;
        }
        
        public void printTo(PrintWriter param1PrintWriter, InputStream param1InputStream) throws IOException {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("[Failed to parse header: ");
          stringBuilder.append(headerName);
          stringBuilder.append(" : ");
          stringBuilder.append(headerValue);
          stringBuilder.append(" ]");
          DownloadingAsyncPrettyPrinterFactory.doErrorPrint(param1PrintWriter, param1InputStream, stringBuilder.toString());
        }
      };
  }
  
  @Nullable
  private static URL parseURL(String paramString) {
    try {
      return new URL(paramString);
    } catch (MalformedURLException malformedURLException) {
      return null;
    } 
  }
  
  protected abstract void doPrint(PrintWriter paramPrintWriter, InputStream paramInputStream, String paramString) throws IOException;
  
  public AsyncPrettyPrinter getInstance(String paramString1, String paramString2) {
    final MatchResult result = matchAndParseHeader(paramString1, paramString2);
    if (matchResult == null)
      return null; 
    URL uRL = parseURL(matchResult.getSchemaUri());
    if (uRL == null)
      return getErrorAsyncPrettyPrinter(paramString1, paramString2); 
    ExecutorService executorService = AsyncPrettyPrinterExecutorHolder.getExecutorService();
    return (executorService == null) ? null : new AsyncPrettyPrinter() {
        public PrettyPrinterDisplayType getPrettifiedType() {
          return result.getDisplayType();
        }
        
        public void printTo(PrintWriter param1PrintWriter, InputStream param1InputStream) throws IOException {
          try {
            String str = response.get();
            try {
              DownloadingAsyncPrettyPrinterFactory.this.doPrint(param1PrintWriter, param1InputStream, str);
              return;
            } catch (ExecutionException executionException) {
              throw ExceptionUtil.propagate(executionException.getCause());
            } 
          } catch (ExecutionException executionException1) {
            if (IOException.class.isInstance(executionException1.getCause())) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Cannot successfully download schema: ");
              stringBuilder.append(executionException1.getMessage());
              DownloadingAsyncPrettyPrinterFactory.doErrorPrint((PrintWriter)executionException, param1InputStream, stringBuilder.toString());
              return;
            } 
            throw executionException1;
          } catch (InterruptedException interruptedException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Encountered spurious interrupt while downloading schema for pretty printing: ");
            stringBuilder.append(interruptedException.getMessage());
            DownloadingAsyncPrettyPrinterFactory.doErrorPrint((PrintWriter)executionException, param1InputStream, stringBuilder.toString());
            return;
          } 
        }
      };
  }
  
  @Nullable
  protected abstract MatchResult matchAndParseHeader(String paramString1, String paramString2);
  
  public class MatchResult {
    private final PrettyPrinterDisplayType mDisplayType;
    
    private final String mSchemaUri;
    
    public MatchResult(String param1String, PrettyPrinterDisplayType param1PrettyPrinterDisplayType) {
      this.mSchemaUri = param1String;
      this.mDisplayType = param1PrettyPrinterDisplayType;
    }
    
    public PrettyPrinterDisplayType getDisplayType() {
      return this.mDisplayType;
    }
    
    public String getSchemaUri() {
      return this.mSchemaUri;
    }
  }
  
  static class Request implements Callable<String> {
    private URL url;
    
    public Request(URL param1URL) {
      this.url = param1URL;
    }
    
    public String call() throws IOException {
      HttpURLConnection httpURLConnection = (HttpURLConnection)this.url.openConnection();
      int i = httpURLConnection.getResponseCode();
      if (i == 200) {
        InputStream inputStream = httpURLConnection.getInputStream();
        try {
          return Util.readAsUTF8(inputStream);
        } finally {
          inputStream.close();
        } 
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Got status code: ");
      stringBuilder.append(i);
      stringBuilder.append(" while downloading schema with url: ");
      stringBuilder.append(this.url.toString());
      throw new IOException(stringBuilder.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\DownloadingAsyncPrettyPrinterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */