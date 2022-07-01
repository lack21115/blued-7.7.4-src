package com.huawei.hms.framework.common;

import android.text.TextUtils;

public class ExceptionCode {
  public static final int CANCEL = 1104;
  
  private static final String CONNECT = "connect";
  
  public static final int CONNECTION_ABORT = 110205;
  
  public static final int CONNECTION_REFUSED = 110209;
  
  public static final int CONNECTION_RESET = 110204;
  
  public static final int CONNECT_FAILED = 110206;
  
  public static final int CRASH_EXCEPTION = 1103;
  
  public static final int INTERRUPT_CONNECT_CLOSE = 110214;
  
  public static final int INTERRUPT_EXCEPTION = 110213;
  
  public static final int NETWORK_CHANGED = 110216;
  
  public static final int NETWORK_IO_EXCEPTION = 1102;
  
  public static final int NETWORK_UNREACHABLE = 110208;
  
  public static final int PROTOCOL_ERROR = 110217;
  
  private static final String READ = "read";
  
  public static final int READ_ERROR = 110203;
  
  public static final int ROUTE_FAILED = 110207;
  
  public static final int SHUTDOWN_EXCEPTION = 110218;
  
  public static final int SOCKET_CLOSE = 110215;
  
  public static final int SOCKET_CONNECT_TIMEOUT = 110221;
  
  public static final int SOCKET_READ_TIMEOUT = 110223;
  
  public static final int SOCKET_TIMEOUT = 110200;
  
  public static final int SOCKET_WRITE_TIMEOUT = 110225;
  
  public static final int SSL_HANDSHAKE_EXCEPTION = 110211;
  
  public static final int SSL_PEERUNVERIFIED_EXCEPTION = 110212;
  
  public static final int SSL_PROTOCOL_EXCEPTION = 110210;
  
  public static final int UNABLE_TO_RESOLVE_HOST = 110202;
  
  public static final int UNEXPECTED_EOF = 110201;
  
  private static final String WRITE = "write";
  
  private static String checkExceptionContainsKey(Exception paramException, String... paramVarArgs) {
    String str2 = checkStrContainsKey(StringUtils.toLowerCase(paramException.getMessage()), paramVarArgs);
    if (!TextUtils.isEmpty(str2))
      return str2; 
    StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    String str1 = str2;
    while (i < j) {
      str1 = checkStrContainsKey(StringUtils.toLowerCase(arrayOfStackTraceElement[i].toString()), paramVarArgs);
      if (!TextUtils.isEmpty(str1))
        return str1; 
      i++;
    } 
    return str1;
  }
  
  private static String checkStrContainsKey(String paramString, String... paramVarArgs) {
    if (TextUtils.isEmpty(paramString))
      return ""; 
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      String str = paramVarArgs[i];
      if (paramString.contains(str))
        return str; 
    } 
    return "";
  }
  
  public static int getErrorCodeFromException(Exception paramException) {
    if (paramException == null)
      return 1102; 
    if (!(paramException instanceof java.io.IOException))
      return 1103; 
    String str = paramException.getMessage();
    if (str == null)
      return 1102; 
    str = StringUtils.toLowerCase(str);
    int i = getErrorCodeFromMsg(str);
    return (i != 1102) ? i : ((paramException instanceof java.net.SocketTimeoutException) ? getErrorCodeSocketTimeout(paramException) : ((paramException instanceof java.net.ConnectException) ? 110206 : ((paramException instanceof java.net.NoRouteToHostException) ? 110207 : ((paramException instanceof javax.net.ssl.SSLProtocolException) ? 110210 : ((paramException instanceof javax.net.ssl.SSLHandshakeException) ? 110211 : ((paramException instanceof javax.net.ssl.SSLPeerUnverifiedException) ? 110212 : ((paramException instanceof java.net.UnknownHostException) ? 110202 : ((paramException instanceof java.io.InterruptedIOException) ? (str.contains("connection has been shut down") ? 110214 : 110213) : i))))))));
  }
  
  private static int getErrorCodeFromMsg(String paramString) {
    return paramString.contains("unexpected end of stream") ? 110201 : (paramString.contains("unable to resolve host") ? 110202 : (paramString.contains("read error") ? 110203 : (paramString.contains("connection reset") ? 110204 : (paramString.contains("software caused connection abort") ? 110205 : (paramString.contains("failed to connect to") ? 110206 : (paramString.contains("connection refused") ? 110209 : (paramString.contains("connection timed out") ? 110221 : (paramString.contains("no route to host") ? 110207 : (paramString.contains("network is unreachable") ? 110208 : (paramString.contains("socket closed") ? 110215 : 1102))))))))));
  }
  
  private static int getErrorCodeSocketTimeout(Exception paramException) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_3
    //   2: anewarray java/lang/String
    //   5: dup
    //   6: iconst_0
    //   7: ldc 'connect'
    //   9: aastore
    //   10: dup
    //   11: iconst_1
    //   12: ldc 'read'
    //   14: aastore
    //   15: dup
    //   16: iconst_2
    //   17: ldc 'write'
    //   19: aastore
    //   20: invokestatic checkExceptionContainsKey : (Ljava/lang/Exception;[Ljava/lang/String;)Ljava/lang/String;
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual hashCode : ()I
    //   28: istore_1
    //   29: iload_1
    //   30: ldc 3496342
    //   32: if_icmpeq -> 78
    //   35: iload_1
    //   36: ldc 113399775
    //   38: if_icmpeq -> 64
    //   41: iload_1
    //   42: ldc 951351530
    //   44: if_icmpeq -> 50
    //   47: goto -> 92
    //   50: aload_0
    //   51: ldc 'connect'
    //   53: invokevirtual equals : (Ljava/lang/Object;)Z
    //   56: ifeq -> 92
    //   59: iconst_0
    //   60: istore_1
    //   61: goto -> 94
    //   64: aload_0
    //   65: ldc 'write'
    //   67: invokevirtual equals : (Ljava/lang/Object;)Z
    //   70: ifeq -> 92
    //   73: iconst_2
    //   74: istore_1
    //   75: goto -> 94
    //   78: aload_0
    //   79: ldc 'read'
    //   81: invokevirtual equals : (Ljava/lang/Object;)Z
    //   84: ifeq -> 92
    //   87: iconst_1
    //   88: istore_1
    //   89: goto -> 94
    //   92: iconst_m1
    //   93: istore_1
    //   94: iload_1
    //   95: ifeq -> 117
    //   98: iload_1
    //   99: iconst_1
    //   100: if_icmpeq -> 114
    //   103: iload_1
    //   104: iconst_2
    //   105: if_icmpeq -> 111
    //   108: ldc 110200
    //   110: ireturn
    //   111: ldc 110225
    //   113: ireturn
    //   114: ldc 110223
    //   116: ireturn
    //   117: ldc 110221
    //   119: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\ExceptionCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */