package com.blued.android.chat.core.worker.link;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.utils.Log;
import com.qiniu.android.dns.DnsManager;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.SSLSocketFactory;

public class SocketThread extends Thread {
  private static final int CONNECT_TIMEOUT_MS = 30000;
  
  private static final String TAG = "Chat_SocketThread";
  
  private AbstractLinkerImpl _linker;
  
  private Socket _socket = null;
  
  private final String addr;
  
  private final int backupPort;
  
  private int connectRetryCount = 0;
  
  private final DnsManager dnsManager;
  
  private final boolean isDnsManagerPrior;
  
  private final boolean isSSL;
  
  private AtomicBoolean linkExceptionFlag = new AtomicBoolean(false);
  
  private final int port;
  
  private RecvThread recvThread = null;
  
  private final ConnectProgram[] retryPrograms;
  
  private SendThread sendThread = null;
  
  private AtomicBoolean stopFlag = new AtomicBoolean(false);
  
  public SocketThread(String paramString, int paramInt1, int paramInt2, DnsManager paramDnsManager, boolean paramBoolean1, boolean paramBoolean2) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("SocketThread(), addr:");
      stringBuilder.append(paramString);
      stringBuilder.append(", port:");
      stringBuilder.append(paramInt1);
      stringBuilder.append(", backupPort:");
      stringBuilder.append(paramInt2);
      stringBuilder.append(", isDnsManagerPrior:");
      stringBuilder.append(paramBoolean1);
      stringBuilder.append(", isSSL:");
      stringBuilder.append(paramBoolean2);
      Log.v("Chat_SocketThread", stringBuilder.toString());
    } 
    this.addr = paramString;
    this.port = paramInt1;
    this.backupPort = paramInt2;
    this.dnsManager = paramDnsManager;
    this.isDnsManagerPrior = paramBoolean1;
    this.isSSL = paramBoolean2;
    if (paramBoolean1) {
      this.retryPrograms = new ConnectProgram[] { ConnectProgram.DnsManager, ConnectProgram.Normal };
      return;
    } 
    this.retryPrograms = new ConnectProgram[] { ConnectProgram.Normal, ConnectProgram.DnsManager };
  }
  
  private Socket createSocket(String paramString, int paramInt) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
    Socket socket;
    if (this.isSSL) {
      socket = SSLSocketFactory.getDefault().createSocket();
    } else {
      socket = new Socket();
    } 
    socket.connect(new InetSocketAddress(paramString, paramInt), 30000);
    socket.setSoTimeout(0);
    socket.setTcpNoDelay(true);
    return socket;
  }
  
  private BasePackage getNextSendPackage() {
    AbstractLinkerImpl abstractLinkerImpl = getLinker();
    return (abstractLinkerImpl != null) ? abstractLinkerImpl.packageQueue.getNext() : null;
  }
  
  private void notifyPackageReceived(BasePackage paramBasePackage) {
    AbstractLinkerImpl abstractLinkerImpl = getLinker();
    if (abstractLinkerImpl != null)
      abstractLinkerImpl.linkListener.onLinkReceive(paramBasePackage); 
  }
  
  private void notifyPackageSendedFailed(BasePackage paramBasePackage, String paramString) {
    AbstractLinkerImpl abstractLinkerImpl = getLinker();
    if (abstractLinkerImpl != null)
      abstractLinkerImpl.linkListener.onLinkSendFailed(paramBasePackage, paramString); 
  }
  
  private void notifyPackageSendedSuccess(BasePackage paramBasePackage) {
    AbstractLinkerImpl abstractLinkerImpl = getLinker();
    if (abstractLinkerImpl != null)
      abstractLinkerImpl.linkListener.onLinkSendSuccess(paramBasePackage); 
  }
  
  private String queryHttpDns(String paramString) {
    DnsManager dnsManager = this.dnsManager;
    if (dnsManager != null)
      try {
        String[] arrayOfString = dnsManager.query(paramString);
        if (arrayOfString != null && arrayOfString.length > 0)
          return arrayOfString[0]; 
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
    return null;
  }
  
  private static void readFully(BufferedInputStream paramBufferedInputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
    int i = 0;
    while (i < paramInt2) {
      int j = paramBufferedInputStream.read(paramArrayOfbyte, paramInt1 + i, paramInt2 - i);
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+++++++++++  read data:");
        stringBuilder.append(j);
        stringBuilder.append("   +++++++++++++");
        Log.v("Chat_SocketThread", stringBuilder.toString());
      } 
      if (j != -1) {
        i += j;
        continue;
      } 
      throw new EOFException("read to eof");
    } 
  }
  
  private static void safeClose(InputStream paramInputStream) {
    if (paramInputStream != null)
      try {
        paramInputStream.close();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
  }
  
  private static void safeClose(OutputStream paramOutputStream) {
    if (paramOutputStream != null)
      try {
        paramOutputStream.close();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
  }
  
  private static void safeClose(Socket paramSocket) {
    if (paramSocket != null)
      try {
        paramSocket.close();
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      }  
  }
  
  private void setlinkerState(int paramInt) {
    AbstractLinkerImpl abstractLinkerImpl = getLinker();
    if (abstractLinkerImpl != null)
      abstractLinkerImpl.changeState(paramInt); 
  }
  
  private void stopSubThread() {
    SendThread sendThread = this.sendThread;
    if (sendThread != null && sendThread.isAlive()) {
      this.sendThread.notifyStop();
      try {
        this.sendThread.join(3000L);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      this.sendThread = null;
    } 
    RecvThread recvThread = this.recvThread;
    if (recvThread != null && recvThread.isAlive()) {
      this.recvThread.notifyStop();
      try {
        this.recvThread.join(3000L);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      this.recvThread = null;
    } 
  }
  
  public AbstractLinkerImpl getLinker() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield _linker : Lcom/blued/android/chat/core/worker/link/AbstractLinkerImpl;
    //   6: astore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_1
    //   10: areturn
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	11	finally
  }
  
  public void notifyPackage() {
    // Byte code:
    //   0: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   3: ifeq -> 41
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc_w 'notifyPackage(), sendThread:'
    //   18: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_1
    //   23: aload_0
    //   24: getfield sendThread : Lcom/blued/android/chat/core/worker/link/SocketThread$SendThread;
    //   27: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: ldc 'Chat_SocketThread'
    //   33: aload_1
    //   34: invokevirtual toString : ()Ljava/lang/String;
    //   37: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   40: pop
    //   41: aload_0
    //   42: getfield sendThread : Lcom/blued/android/chat/core/worker/link/SocketThread$SendThread;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull -> 64
    //   50: aload_1
    //   51: monitorenter
    //   52: aload_1
    //   53: invokevirtual notify : ()V
    //   56: aload_1
    //   57: monitorexit
    //   58: return
    //   59: astore_2
    //   60: aload_1
    //   61: monitorexit
    //   62: aload_2
    //   63: athrow
    //   64: return
    // Exception table:
    //   from	to	target	type
    //   52	58	59	finally
    //   60	62	59	finally
  }
  
  public void notifyStop() {
    // Byte code:
    //   0: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   3: ifeq -> 15
    //   6: ldc 'Chat_SocketThread'
    //   8: ldc_w 'notifyStop()'
    //   11: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   14: pop
    //   15: aload_0
    //   16: getfield stopFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   19: iconst_1
    //   20: invokevirtual set : (Z)V
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: invokevirtual notify : ()V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: athrow
    // Exception table:
    //   from	to	target	type
    //   25	31	32	finally
    //   33	35	32	finally
  }
  
  public void run() {
    // Byte code:
    //   0: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   3: ifeq -> 15
    //   6: ldc 'Chat_SocketThread'
    //   8: ldc_w 'start running...'
    //   11: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   14: pop
    //   15: aload_0
    //   16: iconst_1
    //   17: invokespecial setlinkerState : (I)V
    //   20: aload_0
    //   21: getfield stopFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: invokevirtual get : ()Z
    //   27: ifne -> 1624
    //   30: aload_0
    //   31: getfield addr : Ljava/lang/String;
    //   34: astore #10
    //   36: aload_0
    //   37: getfield linkExceptionFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   40: iconst_0
    //   41: invokevirtual set : (Z)V
    //   44: aconst_null
    //   45: astore #14
    //   47: iconst_0
    //   48: istore_1
    //   49: iconst_0
    //   50: istore_2
    //   51: aload #14
    //   53: astore #11
    //   55: iload_2
    //   56: istore_3
    //   57: aload_0
    //   58: getfield connectRetryCount : I
    //   61: aload_0
    //   62: getfield retryPrograms : [Lcom/blued/android/chat/core/worker/link/SocketThread$ConnectProgram;
    //   65: arraylength
    //   66: if_icmpge -> 1209
    //   69: aload #14
    //   71: astore #11
    //   73: iload_2
    //   74: istore_3
    //   75: aload_0
    //   76: getfield stopFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   79: invokevirtual get : ()Z
    //   82: ifne -> 1209
    //   85: aload_0
    //   86: iconst_1
    //   87: invokespecial setlinkerState : (I)V
    //   90: aload_0
    //   91: getfield retryPrograms : [Lcom/blued/android/chat/core/worker/link/SocketThread$ConnectProgram;
    //   94: aload_0
    //   95: getfield connectRetryCount : I
    //   98: aaload
    //   99: astore #13
    //   101: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   104: ifeq -> 146
    //   107: new java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial <init> : ()V
    //   114: astore #11
    //   116: aload #11
    //   118: ldc_w 'retry count ++, connectRetryCount:'
    //   121: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload #11
    //   127: aload_0
    //   128: getfield connectRetryCount : I
    //   131: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: ldc 'Chat_SocketThread'
    //   137: aload #11
    //   139: invokevirtual toString : ()Ljava/lang/String;
    //   142: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   145: pop
    //   146: aload_0
    //   147: aload_0
    //   148: getfield connectRetryCount : I
    //   151: iconst_1
    //   152: iadd
    //   153: putfield connectRetryCount : I
    //   156: aload #10
    //   158: astore #11
    //   160: iload_1
    //   161: istore_3
    //   162: aload #10
    //   164: astore #12
    //   166: iload_1
    //   167: istore #4
    //   169: getstatic com/blued/android/chat/core/worker/link/SocketThread$1.$SwitchMap$com$blued$android$chat$core$worker$link$SocketThread$ConnectProgram : [I
    //   172: aload #13
    //   174: invokevirtual ordinal : ()I
    //   177: iaload
    //   178: istore #5
    //   180: iload #5
    //   182: iconst_1
    //   183: if_icmpeq -> 286
    //   186: iload #5
    //   188: iconst_2
    //   189: if_icmpeq -> 195
    //   192: goto -> 568
    //   195: aload #10
    //   197: astore #11
    //   199: iload_1
    //   200: istore_3
    //   201: aload #10
    //   203: astore #12
    //   205: iload_1
    //   206: istore #4
    //   208: aload_0
    //   209: getfield addr : Ljava/lang/String;
    //   212: astore #10
    //   214: aload #10
    //   216: astore #11
    //   218: iload_1
    //   219: istore_3
    //   220: aload #10
    //   222: astore #12
    //   224: iload_1
    //   225: istore #4
    //   227: new java/util/Random
    //   230: dup
    //   231: invokestatic currentTimeMillis : ()J
    //   234: invokespecial <init> : (J)V
    //   237: iconst_2
    //   238: invokevirtual nextInt : (I)I
    //   241: ifne -> 265
    //   244: aload #10
    //   246: astore #11
    //   248: iload_1
    //   249: istore_3
    //   250: aload #10
    //   252: astore #12
    //   254: iload_1
    //   255: istore #4
    //   257: aload_0
    //   258: getfield port : I
    //   261: istore_1
    //   262: goto -> 568
    //   265: aload #10
    //   267: astore #11
    //   269: iload_1
    //   270: istore_3
    //   271: aload #10
    //   273: astore #12
    //   275: iload_1
    //   276: istore #4
    //   278: aload_0
    //   279: getfield backupPort : I
    //   282: istore_1
    //   283: goto -> 568
    //   286: aload #10
    //   288: astore #11
    //   290: iload_1
    //   291: istore_3
    //   292: aload #10
    //   294: astore #12
    //   296: iload_1
    //   297: istore #4
    //   299: aload_0
    //   300: aload_0
    //   301: getfield addr : Ljava/lang/String;
    //   304: invokespecial queryHttpDns : (Ljava/lang/String;)Ljava/lang/String;
    //   307: astore #15
    //   309: aload #10
    //   311: astore #11
    //   313: iload_1
    //   314: istore_3
    //   315: aload #10
    //   317: astore #12
    //   319: iload_1
    //   320: istore #4
    //   322: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   325: ifeq -> 462
    //   328: aload #10
    //   330: astore #11
    //   332: iload_1
    //   333: istore_3
    //   334: aload #10
    //   336: astore #12
    //   338: iload_1
    //   339: istore #4
    //   341: new java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial <init> : ()V
    //   348: astore #13
    //   350: aload #10
    //   352: astore #11
    //   354: iload_1
    //   355: istore_3
    //   356: aload #10
    //   358: astore #12
    //   360: iload_1
    //   361: istore #4
    //   363: aload #13
    //   365: ldc_w 'HttpDns switch, '
    //   368: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload #10
    //   374: astore #11
    //   376: iload_1
    //   377: istore_3
    //   378: aload #10
    //   380: astore #12
    //   382: iload_1
    //   383: istore #4
    //   385: aload #13
    //   387: aload_0
    //   388: getfield addr : Ljava/lang/String;
    //   391: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload #10
    //   397: astore #11
    //   399: iload_1
    //   400: istore_3
    //   401: aload #10
    //   403: astore #12
    //   405: iload_1
    //   406: istore #4
    //   408: aload #13
    //   410: ldc_w ' -> '
    //   413: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload #10
    //   419: astore #11
    //   421: iload_1
    //   422: istore_3
    //   423: aload #10
    //   425: astore #12
    //   427: iload_1
    //   428: istore #4
    //   430: aload #13
    //   432: aload #15
    //   434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload #10
    //   440: astore #11
    //   442: iload_1
    //   443: istore_3
    //   444: aload #10
    //   446: astore #12
    //   448: iload_1
    //   449: istore #4
    //   451: ldc 'Chat_SocketThread'
    //   453: aload #13
    //   455: invokevirtual toString : ()Ljava/lang/String;
    //   458: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   461: pop
    //   462: aload #10
    //   464: astore #13
    //   466: aload #10
    //   468: astore #11
    //   470: iload_1
    //   471: istore_3
    //   472: aload #10
    //   474: astore #12
    //   476: iload_1
    //   477: istore #4
    //   479: aload #15
    //   481: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   484: ifne -> 491
    //   487: aload #15
    //   489: astore #13
    //   491: aload #13
    //   493: astore #11
    //   495: iload_1
    //   496: istore_3
    //   497: aload #13
    //   499: astore #12
    //   501: iload_1
    //   502: istore #4
    //   504: new java/util/Random
    //   507: dup
    //   508: invokestatic currentTimeMillis : ()J
    //   511: invokespecial <init> : (J)V
    //   514: iconst_2
    //   515: invokevirtual nextInt : (I)I
    //   518: ifne -> 546
    //   521: aload #13
    //   523: astore #11
    //   525: iload_1
    //   526: istore_3
    //   527: aload #13
    //   529: astore #12
    //   531: iload_1
    //   532: istore #4
    //   534: aload_0
    //   535: getfield port : I
    //   538: istore_1
    //   539: aload #13
    //   541: astore #10
    //   543: goto -> 568
    //   546: aload #13
    //   548: astore #11
    //   550: iload_1
    //   551: istore_3
    //   552: aload #13
    //   554: astore #12
    //   556: iload_1
    //   557: istore #4
    //   559: aload_0
    //   560: getfield backupPort : I
    //   563: istore_1
    //   564: aload #13
    //   566: astore #10
    //   568: aload #10
    //   570: astore #11
    //   572: iload_1
    //   573: istore_3
    //   574: aload #10
    //   576: astore #12
    //   578: iload_1
    //   579: istore #4
    //   581: aload_0
    //   582: getfield addr : Ljava/lang/String;
    //   585: iload_1
    //   586: aload #10
    //   588: invokestatic setChatRealNetArgs : (Ljava/lang/String;ILjava/lang/String;)V
    //   591: aload #10
    //   593: astore #11
    //   595: iload_1
    //   596: istore_3
    //   597: aload #10
    //   599: astore #12
    //   601: iload_1
    //   602: istore #4
    //   604: aload_0
    //   605: invokespecial stopSubThread : ()V
    //   608: aload #10
    //   610: astore #11
    //   612: iload_1
    //   613: istore_3
    //   614: aload #10
    //   616: astore #12
    //   618: iload_1
    //   619: istore #4
    //   621: aload_0
    //   622: getfield linkExceptionFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   625: iconst_0
    //   626: invokevirtual set : (Z)V
    //   629: aload #10
    //   631: astore #11
    //   633: iload_1
    //   634: istore_3
    //   635: aload #10
    //   637: astore #12
    //   639: iload_1
    //   640: istore #4
    //   642: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   645: ifeq -> 778
    //   648: aload #10
    //   650: astore #11
    //   652: iload_1
    //   653: istore_3
    //   654: aload #10
    //   656: astore #12
    //   658: iload_1
    //   659: istore #4
    //   661: new java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial <init> : ()V
    //   668: astore #13
    //   670: aload #10
    //   672: astore #11
    //   674: iload_1
    //   675: istore_3
    //   676: aload #10
    //   678: astore #12
    //   680: iload_1
    //   681: istore #4
    //   683: aload #13
    //   685: ldc_w 'start connect, addr:'
    //   688: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload #10
    //   694: astore #11
    //   696: iload_1
    //   697: istore_3
    //   698: aload #10
    //   700: astore #12
    //   702: iload_1
    //   703: istore #4
    //   705: aload #13
    //   707: aload #10
    //   709: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: pop
    //   713: aload #10
    //   715: astore #11
    //   717: iload_1
    //   718: istore_3
    //   719: aload #10
    //   721: astore #12
    //   723: iload_1
    //   724: istore #4
    //   726: aload #13
    //   728: ldc ', port:'
    //   730: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: pop
    //   734: aload #10
    //   736: astore #11
    //   738: iload_1
    //   739: istore_3
    //   740: aload #10
    //   742: astore #12
    //   744: iload_1
    //   745: istore #4
    //   747: aload #13
    //   749: iload_1
    //   750: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload #10
    //   756: astore #11
    //   758: iload_1
    //   759: istore_3
    //   760: aload #10
    //   762: astore #12
    //   764: iload_1
    //   765: istore #4
    //   767: ldc 'Chat_SocketThread'
    //   769: aload #13
    //   771: invokevirtual toString : ()Ljava/lang/String;
    //   774: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   777: pop
    //   778: aload #10
    //   780: astore #11
    //   782: iload_1
    //   783: istore_3
    //   784: aload #10
    //   786: astore #12
    //   788: iload_1
    //   789: istore #4
    //   791: invokestatic uptimeMillis : ()J
    //   794: lstore #6
    //   796: aload_0
    //   797: aload_0
    //   798: aload #10
    //   800: iload_1
    //   801: invokespecial createSocket : (Ljava/lang/String;I)Ljava/net/Socket;
    //   804: putfield _socket : Ljava/net/Socket;
    //   807: aload_0
    //   808: new com/blued/android/chat/core/worker/link/SocketThread$SendThread
    //   811: dup
    //   812: aload_0
    //   813: aconst_null
    //   814: invokespecial <init> : (Lcom/blued/android/chat/core/worker/link/SocketThread;Lcom/blued/android/chat/core/worker/link/SocketThread$1;)V
    //   817: putfield sendThread : Lcom/blued/android/chat/core/worker/link/SocketThread$SendThread;
    //   820: aload_0
    //   821: getfield sendThread : Lcom/blued/android/chat/core/worker/link/SocketThread$SendThread;
    //   824: invokevirtual start : ()V
    //   827: aload_0
    //   828: new com/blued/android/chat/core/worker/link/SocketThread$RecvThread
    //   831: dup
    //   832: aload_0
    //   833: aconst_null
    //   834: invokespecial <init> : (Lcom/blued/android/chat/core/worker/link/SocketThread;Lcom/blued/android/chat/core/worker/link/SocketThread$1;)V
    //   837: putfield recvThread : Lcom/blued/android/chat/core/worker/link/SocketThread$RecvThread;
    //   840: aload_0
    //   841: getfield recvThread : Lcom/blued/android/chat/core/worker/link/SocketThread$RecvThread;
    //   844: invokevirtual start : ()V
    //   847: invokestatic uptimeMillis : ()J
    //   850: lstore #8
    //   852: ldc_w 'socket created'
    //   855: invokestatic setSocketStatus : (Ljava/lang/String;)V
    //   858: invokestatic b : ()Lcom/blued/android/statistics/biz/Apm;
    //   861: aload_0
    //   862: getfield addr : Ljava/lang/String;
    //   865: iload_1
    //   866: aload #10
    //   868: lload #8
    //   870: lload #6
    //   872: lsub
    //   873: invokevirtual a : (Ljava/lang/String;ILjava/lang/String;J)V
    //   876: iconst_1
    //   877: istore_3
    //   878: aload #14
    //   880: astore #11
    //   882: goto -> 1209
    //   885: astore #11
    //   887: iconst_1
    //   888: istore #4
    //   890: aload #10
    //   892: astore #13
    //   894: goto -> 951
    //   897: astore #11
    //   899: iconst_1
    //   900: istore #5
    //   902: aload #10
    //   904: astore #13
    //   906: goto -> 1025
    //   909: astore #11
    //   911: aload #10
    //   913: astore #13
    //   915: iload_2
    //   916: istore #4
    //   918: goto -> 951
    //   921: astore #11
    //   923: aload #10
    //   925: astore #13
    //   927: iload_2
    //   928: istore #5
    //   930: goto -> 1025
    //   933: astore #10
    //   935: lconst_0
    //   936: lstore #6
    //   938: iload_2
    //   939: istore #4
    //   941: iload_3
    //   942: istore_1
    //   943: aload #11
    //   945: astore #13
    //   947: aload #10
    //   949: astore #11
    //   951: aload #11
    //   953: invokevirtual printStackTrace : ()V
    //   956: aload #11
    //   958: astore #10
    //   960: aload #13
    //   962: astore #12
    //   964: iload_1
    //   965: istore_3
    //   966: iload #4
    //   968: istore_2
    //   969: lload #6
    //   971: lstore #8
    //   973: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   976: ifeq -> 1007
    //   979: ldc 'Chat_SocketThread'
    //   981: ldc_w 'socket exception'
    //   984: aload #11
    //   986: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   989: pop
    //   990: lload #6
    //   992: lstore #8
    //   994: iload #4
    //   996: istore_2
    //   997: iload_1
    //   998: istore_3
    //   999: aload #13
    //   1001: astore #12
    //   1003: aload #11
    //   1005: astore #10
    //   1007: goto -> 1084
    //   1010: astore #11
    //   1012: lconst_0
    //   1013: lstore #6
    //   1015: iload_2
    //   1016: istore #5
    //   1018: iload #4
    //   1020: istore_1
    //   1021: aload #12
    //   1023: astore #13
    //   1025: aload #11
    //   1027: invokevirtual printStackTrace : ()V
    //   1030: aload #11
    //   1032: astore #10
    //   1034: aload #13
    //   1036: astore #12
    //   1038: iload_1
    //   1039: istore_3
    //   1040: iload #5
    //   1042: istore_2
    //   1043: lload #6
    //   1045: lstore #8
    //   1047: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1050: ifeq -> 1007
    //   1053: ldc 'Chat_SocketThread'
    //   1055: ldc_w 'socket ioexception'
    //   1058: aload #11
    //   1060: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1063: pop
    //   1064: aload #11
    //   1066: astore #10
    //   1068: aload #13
    //   1070: astore #12
    //   1072: iload_1
    //   1073: istore_3
    //   1074: iload #5
    //   1076: istore_2
    //   1077: lload #6
    //   1079: lstore #8
    //   1081: goto -> 1007
    //   1084: iload_2
    //   1085: ifne -> 1167
    //   1088: invokestatic uptimeMillis : ()J
    //   1091: lstore #6
    //   1093: new java/lang/StringBuilder
    //   1096: dup
    //   1097: invokespecial <init> : ()V
    //   1100: astore #11
    //   1102: aload #11
    //   1104: ldc_w 'socket create failed, '
    //   1107: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: pop
    //   1111: aload #11
    //   1113: aload #10
    //   1115: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1118: pop
    //   1119: aload #11
    //   1121: invokevirtual toString : ()Ljava/lang/String;
    //   1124: ifnonnull -> 1135
    //   1127: ldc_w ''
    //   1130: astore #11
    //   1132: goto -> 1142
    //   1135: aload #10
    //   1137: invokevirtual getMessage : ()Ljava/lang/String;
    //   1140: astore #11
    //   1142: aload #11
    //   1144: invokestatic setSocketStatus : (Ljava/lang/String;)V
    //   1147: invokestatic b : ()Lcom/blued/android/statistics/biz/Apm;
    //   1150: aload_0
    //   1151: getfield addr : Ljava/lang/String;
    //   1154: iload_3
    //   1155: aload #12
    //   1157: aload #10
    //   1159: lload #6
    //   1161: lload #8
    //   1163: lsub
    //   1164: invokevirtual a : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;J)V
    //   1167: aload_0
    //   1168: getfield stopFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1171: invokevirtual get : ()Z
    //   1174: ifne -> 1183
    //   1177: ldc2_w 1000
    //   1180: invokestatic sleep : (J)V
    //   1183: aload #10
    //   1185: astore #14
    //   1187: aload #12
    //   1189: astore #10
    //   1191: iload_3
    //   1192: istore_1
    //   1193: goto -> 51
    //   1196: astore #11
    //   1198: aload #11
    //   1200: invokevirtual printStackTrace : ()V
    //   1203: iload_2
    //   1204: istore_3
    //   1205: aload #10
    //   1207: astore #11
    //   1209: iload_3
    //   1210: ifne -> 1300
    //   1213: aload #11
    //   1215: ifnull -> 1279
    //   1218: aload_0
    //   1219: getfield stopFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1222: invokevirtual get : ()Z
    //   1225: ifne -> 1279
    //   1228: invokestatic getInstance : ()Lcom/blued/android/chat/ChatManager;
    //   1231: invokevirtual getTipsListener : ()Lcom/blued/android/chat/listener/ChatTipsListener;
    //   1234: astore #10
    //   1236: aload #10
    //   1238: ifnull -> 1279
    //   1241: new java/lang/StringBuilder
    //   1244: dup
    //   1245: invokespecial <init> : ()V
    //   1248: astore #12
    //   1250: aload #12
    //   1252: ldc_w 'socket exception, exception:'
    //   1255: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: pop
    //   1259: aload #12
    //   1261: aload #11
    //   1263: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1266: pop
    //   1267: aload #10
    //   1269: aload #12
    //   1271: invokevirtual toString : ()Ljava/lang/String;
    //   1274: invokeinterface onConnectException : (Ljava/lang/String;)V
    //   1279: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1282: ifeq -> 1294
    //   1285: ldc 'Chat_SocketThread'
    //   1287: ldc_w 'connect failed, change state to unlink'
    //   1290: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1293: pop
    //   1294: aload_0
    //   1295: iconst_0
    //   1296: invokespecial setlinkerState : (I)V
    //   1299: return
    //   1300: aload_0
    //   1301: getfield connectRetryCount : I
    //   1304: istore_1
    //   1305: aload_0
    //   1306: iconst_0
    //   1307: putfield connectRetryCount : I
    //   1310: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1313: ifeq -> 1325
    //   1316: ldc 'Chat_SocketThread'
    //   1318: ldc_w 'connect success, change state to LINKED'
    //   1321: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1324: pop
    //   1325: aload_0
    //   1326: iconst_2
    //   1327: invokespecial setlinkerState : (I)V
    //   1330: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1333: ifeq -> 1345
    //   1336: ldc 'Chat_SocketThread'
    //   1338: ldc_w 'wait...'
    //   1341: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1344: pop
    //   1345: aload_0
    //   1346: monitorenter
    //   1347: aload_0
    //   1348: getfield linkExceptionFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1351: invokevirtual get : ()Z
    //   1354: ifeq -> 1367
    //   1357: aload_0
    //   1358: getfield stopFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1361: invokevirtual get : ()Z
    //   1364: ifne -> 1371
    //   1367: aload_0
    //   1368: invokevirtual wait : ()V
    //   1371: aload_0
    //   1372: monitorexit
    //   1373: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1376: ifeq -> 1388
    //   1379: ldc 'Chat_SocketThread'
    //   1381: ldc_w 'waken'
    //   1384: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1387: pop
    //   1388: aload_0
    //   1389: getfield linkExceptionFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1392: invokevirtual get : ()Z
    //   1395: ifeq -> 1498
    //   1398: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1401: ifeq -> 1413
    //   1404: ldc 'Chat_SocketThread'
    //   1406: ldc_w 'link exception, will close socket'
    //   1409: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1412: pop
    //   1413: aload_0
    //   1414: invokevirtual getLinker : ()Lcom/blued/android/chat/core/worker/link/AbstractLinkerImpl;
    //   1417: astore #10
    //   1419: aload #10
    //   1421: ifnull -> 1482
    //   1424: aload #10
    //   1426: invokevirtual isLinkFinished : ()Z
    //   1429: ifne -> 1482
    //   1432: aload_0
    //   1433: iload_1
    //   1434: putfield connectRetryCount : I
    //   1437: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1440: ifeq -> 1482
    //   1443: new java/lang/StringBuilder
    //   1446: dup
    //   1447: invokespecial <init> : ()V
    //   1450: astore #10
    //   1452: aload #10
    //   1454: ldc_w 'link is not finish, change connectRetryCount to '
    //   1457: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1460: pop
    //   1461: aload #10
    //   1463: aload_0
    //   1464: getfield connectRetryCount : I
    //   1467: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   1470: pop
    //   1471: ldc 'Chat_SocketThread'
    //   1473: aload #10
    //   1475: invokevirtual toString : ()Ljava/lang/String;
    //   1478: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1481: pop
    //   1482: aload_0
    //   1483: getfield stopFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1486: invokevirtual get : ()Z
    //   1489: ifne -> 1498
    //   1492: ldc2_w 1000
    //   1495: invokestatic sleep : (J)V
    //   1498: aload_0
    //   1499: getfield _socket : Ljava/net/Socket;
    //   1502: invokestatic safeClose : (Ljava/net/Socket;)V
    //   1505: aload_0
    //   1506: aconst_null
    //   1507: putfield _socket : Ljava/net/Socket;
    //   1510: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1513: ifeq -> 1525
    //   1516: ldc 'Chat_SocketThread'
    //   1518: ldc_w 'notify sendThread and recvThread to stop'
    //   1521: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1524: pop
    //   1525: aload_0
    //   1526: invokespecial stopSubThread : ()V
    //   1529: goto -> 1551
    //   1532: astore #10
    //   1534: aload_0
    //   1535: monitorexit
    //   1536: aload #10
    //   1538: athrow
    //   1539: astore #10
    //   1541: goto -> 1609
    //   1544: astore #10
    //   1546: aload #10
    //   1548: invokevirtual printStackTrace : ()V
    //   1551: aload_0
    //   1552: getfield _socket : Ljava/net/Socket;
    //   1555: invokestatic safeClose : (Ljava/net/Socket;)V
    //   1558: aload_0
    //   1559: aconst_null
    //   1560: putfield _socket : Ljava/net/Socket;
    //   1563: aload_0
    //   1564: getfield stopFlag : Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1567: invokevirtual get : ()Z
    //   1570: ifeq -> 1591
    //   1573: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1576: ifeq -> 1624
    //   1579: ldc 'Chat_SocketThread'
    //   1581: ldc_w 'stop flag, so exit it'
    //   1584: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1587: pop
    //   1588: goto -> 1624
    //   1591: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   1594: ifeq -> 20
    //   1597: ldc 'Chat_SocketThread'
    //   1599: ldc_w 'try connect again'
    //   1602: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   1605: pop
    //   1606: goto -> 20
    //   1609: aload_0
    //   1610: getfield _socket : Ljava/net/Socket;
    //   1613: invokestatic safeClose : (Ljava/net/Socket;)V
    //   1616: aload_0
    //   1617: aconst_null
    //   1618: putfield _socket : Ljava/net/Socket;
    //   1621: aload #10
    //   1623: athrow
    //   1624: aload_0
    //   1625: iconst_0
    //   1626: invokespecial setlinkerState : (I)V
    //   1629: return
    // Exception table:
    //   from	to	target	type
    //   169	180	1010	java/io/IOException
    //   169	180	933	java/lang/Exception
    //   208	214	1010	java/io/IOException
    //   208	214	933	java/lang/Exception
    //   227	244	1010	java/io/IOException
    //   227	244	933	java/lang/Exception
    //   257	262	1010	java/io/IOException
    //   257	262	933	java/lang/Exception
    //   278	283	1010	java/io/IOException
    //   278	283	933	java/lang/Exception
    //   299	309	1010	java/io/IOException
    //   299	309	933	java/lang/Exception
    //   322	328	1010	java/io/IOException
    //   322	328	933	java/lang/Exception
    //   341	350	1010	java/io/IOException
    //   341	350	933	java/lang/Exception
    //   363	372	1010	java/io/IOException
    //   363	372	933	java/lang/Exception
    //   385	395	1010	java/io/IOException
    //   385	395	933	java/lang/Exception
    //   408	417	1010	java/io/IOException
    //   408	417	933	java/lang/Exception
    //   430	438	1010	java/io/IOException
    //   430	438	933	java/lang/Exception
    //   451	462	1010	java/io/IOException
    //   451	462	933	java/lang/Exception
    //   479	487	1010	java/io/IOException
    //   479	487	933	java/lang/Exception
    //   504	521	1010	java/io/IOException
    //   504	521	933	java/lang/Exception
    //   534	539	1010	java/io/IOException
    //   534	539	933	java/lang/Exception
    //   559	564	1010	java/io/IOException
    //   559	564	933	java/lang/Exception
    //   581	591	1010	java/io/IOException
    //   581	591	933	java/lang/Exception
    //   604	608	1010	java/io/IOException
    //   604	608	933	java/lang/Exception
    //   621	629	1010	java/io/IOException
    //   621	629	933	java/lang/Exception
    //   642	648	1010	java/io/IOException
    //   642	648	933	java/lang/Exception
    //   661	670	1010	java/io/IOException
    //   661	670	933	java/lang/Exception
    //   683	692	1010	java/io/IOException
    //   683	692	933	java/lang/Exception
    //   705	713	1010	java/io/IOException
    //   705	713	933	java/lang/Exception
    //   726	734	1010	java/io/IOException
    //   726	734	933	java/lang/Exception
    //   747	754	1010	java/io/IOException
    //   747	754	933	java/lang/Exception
    //   767	778	1010	java/io/IOException
    //   767	778	933	java/lang/Exception
    //   791	796	1010	java/io/IOException
    //   791	796	933	java/lang/Exception
    //   796	847	921	java/io/IOException
    //   796	847	909	java/lang/Exception
    //   847	876	897	java/io/IOException
    //   847	876	885	java/lang/Exception
    //   1167	1183	1196	java/lang/InterruptedException
    //   1330	1345	1544	java/lang/InterruptedException
    //   1330	1345	1539	finally
    //   1345	1347	1544	java/lang/InterruptedException
    //   1345	1347	1539	finally
    //   1347	1367	1532	finally
    //   1367	1371	1532	finally
    //   1371	1373	1532	finally
    //   1373	1388	1544	java/lang/InterruptedException
    //   1373	1388	1539	finally
    //   1388	1413	1544	java/lang/InterruptedException
    //   1388	1413	1539	finally
    //   1413	1419	1544	java/lang/InterruptedException
    //   1413	1419	1539	finally
    //   1424	1482	1544	java/lang/InterruptedException
    //   1424	1482	1539	finally
    //   1482	1498	1544	java/lang/InterruptedException
    //   1482	1498	1539	finally
    //   1498	1525	1544	java/lang/InterruptedException
    //   1498	1525	1539	finally
    //   1525	1529	1544	java/lang/InterruptedException
    //   1525	1529	1539	finally
    //   1534	1536	1532	finally
    //   1536	1539	1544	java/lang/InterruptedException
    //   1536	1539	1539	finally
    //   1546	1551	1539	finally
  }
  
  public void setLinker(AbstractLinkerImpl paramAbstractLinkerImpl) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic com/blued/android/chat/ChatManager.debug : Z
    //   5: ifeq -> 40
    //   8: new java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial <init> : ()V
    //   15: astore_2
    //   16: aload_2
    //   17: ldc_w 'setLinker(), linker:'
    //   20: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 'Chat_SocketThread'
    //   32: aload_2
    //   33: invokevirtual toString : ()Ljava/lang/String;
    //   36: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   39: pop
    //   40: aload_0
    //   41: aload_1
    //   42: putfield _linker : Lcom/blued/android/chat/core/worker/link/AbstractLinkerImpl;
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Exception table:
    //   from	to	target	type
    //   2	40	48	finally
    //   40	45	48	finally
  }
  
  enum ConnectProgram {
    DnsManager, Normal;
    
    static {
    
    }
  }
  
  class RecvThread extends Thread {
    private boolean stop = false;
    
    private RecvThread() {}
    
    public void notifyStop() {
      // Byte code:
      //   0: aload_0
      //   1: iconst_1
      //   2: putfield stop : Z
      //   5: aload_0
      //   6: monitorenter
      //   7: aload_0
      //   8: invokevirtual notify : ()V
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: astore_1
      //   15: aload_0
      //   16: monitorexit
      //   17: aload_1
      //   18: athrow
      // Exception table:
      //   from	to	target	type
      //   7	13	14	finally
      //   15	17	14	finally
    }
    
    public void run() {
      if (ChatManager.debug)
        Log.v("Chat_SocketThread", "RecvThread running..."); 
      byte[] arrayOfByte = new byte[6];
      BasePackage basePackage = BasePackage.createEmptyHeader();
      try {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(SocketThread.this._socket.getInputStream());
        while (true) {
          BufferedInputStream bufferedInputStream1 = bufferedInputStream;
          try {
            BasePackage basePackage1;
            return;
          } catch (IOException iOException) {
            break;
          } finally {
            arrayOfByte = null;
          } 
        } 
      } catch (IOException iOException) {
      
      } finally {
        arrayOfByte = null;
        null = null;
        InputStream inputStream = null;
      } 
      null = SYNTHETIC_LOCAL_VARIABLE_1;
      if (ChatManager.debug) {
        null = SYNTHETIC_LOCAL_VARIABLE_1;
        Log.e("Chat_SocketThread", "RecvThread ioexception", (Throwable)null);
      } 
      null = SYNTHETIC_LOCAL_VARIABLE_1;
      SocketThread.this.linkExceptionFlag.set(true);
      null = SYNTHETIC_LOCAL_VARIABLE_1;
      SocketThread socketThread = SocketThread.this;
      synchronized (SYNTHETIC_LOCAL_VARIABLE_1) {
        SocketThread.this.notify();
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{com/blued/android/chat/core/worker/link/SocketThread}, name=null} */
        null = SYNTHETIC_LOCAL_VARIABLE_1;
        null.printStackTrace();
        null = SYNTHETIC_LOCAL_VARIABLE_1;
        SocketThread.safeClose((InputStream)null);
        return;
      } 
    }
  }
  
  class SendThread extends Thread {
    private boolean stop = false;
    
    private SendThread() {}
    
    public void notifyStop() {
      // Byte code:
      //   0: aload_0
      //   1: iconst_1
      //   2: putfield stop : Z
      //   5: aload_0
      //   6: monitorenter
      //   7: aload_0
      //   8: invokevirtual notify : ()V
      //   11: aload_0
      //   12: monitorexit
      //   13: return
      //   14: astore_1
      //   15: aload_0
      //   16: monitorexit
      //   17: aload_1
      //   18: athrow
      // Exception table:
      //   from	to	target	type
      //   7	13	14	finally
      //   15	17	14	finally
    }
    
    public void run() {
      if (ChatManager.debug)
        Log.v("Chat_SocketThread", "SendThread running..."); 
      try {
      
      } catch (IOException iOException) {
      
      } finally {
        Exception exception = null;
        null = null;
        OutputStream outputStream = null;
      } 
      null = SYNTHETIC_LOCAL_VARIABLE_1;
      socketThread.printStackTrace();
      null = SYNTHETIC_LOCAL_VARIABLE_1;
      if (ChatManager.debug) {
        null = SYNTHETIC_LOCAL_VARIABLE_1;
        Log.e("Chat_SocketThread", "sendThread ioexception", (Throwable)socketThread);
      } 
      null = SYNTHETIC_LOCAL_VARIABLE_1;
      SocketThread.this.linkExceptionFlag.set(true);
      null = SYNTHETIC_LOCAL_VARIABLE_1;
      SocketThread socketThread = SocketThread.this;
      synchronized (SYNTHETIC_LOCAL_VARIABLE_1) {
        SocketThread.this.notify();
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{com/blued/android/chat/core/worker/link/SocketThread}, name=null} */
        SocketThread.safeClose((OutputStream)SYNTHETIC_LOCAL_VARIABLE_1);
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\link\SocketThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */