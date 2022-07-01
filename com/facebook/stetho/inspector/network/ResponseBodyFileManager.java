package com.facebook.stetho.inspector.network;

import android.content.Context;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.LogRedirector;
import com.facebook.stetho.common.Util;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ResponseBodyFileManager {
  private static final String FILENAME_PREFIX = "network-response-body-";
  
  private static final int PRETTY_PRINT_TIMEOUT_SEC = 10;
  
  private static final String TAG = "ResponseBodyFileManager";
  
  private final Context mContext;
  
  private final Map<String, AsyncPrettyPrinter> mRequestIdMap = Collections.synchronizedMap(new HashMap<String, AsyncPrettyPrinter>());
  
  public ResponseBodyFileManager(Context paramContext) {
    this.mContext = paramContext;
  }
  
  private static String getFilename(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("network-response-body-");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  private String prettyPrintContentWithTimeOut(AsyncPrettyPrinter paramAsyncPrettyPrinter, InputStream paramInputStream) throws IOException {
    AsyncPrettyPrintingCallable asyncPrettyPrintingCallable = new AsyncPrettyPrintingCallable(paramInputStream, paramAsyncPrettyPrinter);
    ExecutorService executorService = AsyncPrettyPrinterExecutorHolder.getExecutorService();
    if (executorService == null)
      return null; 
    Future<?> future = executorService.submit(asyncPrettyPrintingCallable);
    try {
      return (String)Util.getUninterruptibly(future, 10L, TimeUnit.SECONDS);
    } catch (TimeoutException timeoutException) {
      future.cancel(true);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Time out after 10 seconds of attempting to pretty print\n");
      stringBuilder.append(Util.readAsUTF8(paramInputStream));
      return stringBuilder.toString();
    } catch (ExecutionException executionException) {
      Throwable throwable = executionException.getCause();
      ExceptionUtil.propagateIfInstanceOf(throwable, IOException.class);
      throw ExceptionUtil.propagate(throwable);
    } 
  }
  
  public void associateAsyncPrettyPrinterWithId(String paramString, AsyncPrettyPrinter paramAsyncPrettyPrinter) {
    if (this.mRequestIdMap.put(paramString, paramAsyncPrettyPrinter) == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("cannot associate different pretty printers with the same request id: ");
    stringBuilder.append(paramString);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public void cleanupFiles() {
    for (File file : this.mContext.getFilesDir().listFiles()) {
      if (file.getName().startsWith("network-response-body-") && !file.delete()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to delete ");
        stringBuilder.append(file.getAbsolutePath());
        LogRedirector.w("ResponseBodyFileManager", stringBuilder.toString());
      } 
    } 
    LogRedirector.i("ResponseBodyFileManager", "Cleaned up temporary network files.");
  }
  
  public OutputStream openResponseBodyFile(String paramString, boolean paramBoolean) throws IOException {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public ResponseBodyData readFile(String paramString) throws IOException {
    FileInputStream fileInputStream = this.mContext.openFileInput(getFilename(paramString));
    try {
      int i = fileInputStream.read();
      if (i != -1) {
        boolean bool;
        ResponseBodyData responseBodyData = new ResponseBodyData();
        if (i != 0) {
          bool = true;
        } else {
          bool = false;
        } 
        responseBodyData.base64Encoded = bool;
        AsyncPrettyPrinter asyncPrettyPrinter = this.mRequestIdMap.get(paramString);
        if (asyncPrettyPrinter != null) {
          responseBodyData.data = prettyPrintContentWithTimeOut(asyncPrettyPrinter, fileInputStream);
        } else {
          responseBodyData.data = Util.readAsUTF8(fileInputStream);
        } 
        return responseBodyData;
      } 
      throw new EOFException("Failed to read base64Encode byte");
    } finally {
      fileInputStream.close();
    } 
  }
  
  class AsyncPrettyPrintingCallable implements Callable<String> {
    private final AsyncPrettyPrinter mAsyncPrettyPrinter;
    
    private final InputStream mInputStream;
    
    public AsyncPrettyPrintingCallable(InputStream param1InputStream, AsyncPrettyPrinter param1AsyncPrettyPrinter) {
      this.mInputStream = param1InputStream;
      this.mAsyncPrettyPrinter = param1AsyncPrettyPrinter;
    }
    
    private String prettyPrintContent(InputStream param1InputStream, AsyncPrettyPrinter param1AsyncPrettyPrinter) throws IOException {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
      param1AsyncPrettyPrinter.printTo(printWriter, param1InputStream);
      printWriter.flush();
      return byteArrayOutputStream.toString("UTF-8");
    }
    
    public String call() throws IOException {
      return prettyPrintContent(this.mInputStream, this.mAsyncPrettyPrinter);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\ResponseBodyFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */