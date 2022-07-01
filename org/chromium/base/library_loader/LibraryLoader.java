package org.chromium.base.library_loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.system.Os;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;
import org.chromium.base.AsyncTask;
import org.chromium.base.BuildConfig;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.TraceEvent;
import org.chromium.base.metrics.CachedMetrics;

public class LibraryLoader {
  public static final boolean PLATFORM_REQUIRES_NATIVE_FALLBACK_EXTRACTION = false;
  
  private static LibraryLoader sInstance;
  
  private static final CachedMetrics.EnumeratedHistogramSample sRelinkerCountHistogram;
  
  private boolean mCommandLineSwitched;
  
  public volatile boolean mInitialized;
  
  public long mLibraryLoadTimeMs;
  
  public NativeLibraryPreloader mLibraryPreloader;
  
  private boolean mLibraryPreloaderCalled;
  
  public int mLibraryPreloaderStatus;
  
  private int mLibraryProcessType;
  
  private boolean mLoaded;
  
  public final Object mLock;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private LibraryLoader() {
    new AtomicBoolean();
    this.mLock = new Object();
    this.mLibraryPreloaderStatus = -1;
  }
  
  @SuppressLint({"SetWorldReadable"})
  private static String extractFileIfStale(Context paramContext, String paramString, File paramFile) {
    assert false;
    throw new AssertionError();
  }
  
  static String getExtractedLibraryPath(Context paramContext, String paramString) {
    assert false;
    throw new AssertionError();
  }
  
  public static LibraryLoader getInstance() {
    return sInstance;
  }
  
  private static File getLibraryDir() {
    return new File(ContextCompat.getCodeCacheDir(ContextUtils.sApplicationContext), "native_libraries");
  }
  
  static void incrementRelinkerCountHitHistogram() {
    sRelinkerCountHistogram.record(1);
  }
  
  static void incrementRelinkerCountNotHitHistogram() {
    sRelinkerCountHistogram.record(0);
  }
  
  @SuppressLint({"DefaultLocale", "NewApi", "UnsafeDynamicallyLoadedCode"})
  private void loadAlreadyLocked(Context paramContext) {
    // Byte code:
    //   0: ldc 'LibraryLoader.loadAlreadyLocked'
    //   2: invokestatic scoped : (Ljava/lang/String;)Lorg/chromium/base/TraceEvent;
    //   5: astore #10
    //   7: aload_0
    //   8: getfield mLoaded : Z
    //   11: ifne -> 642
    //   14: getstatic org/chromium/base/library_loader/LibraryLoader.$assertionsDisabled : Z
    //   17: ifne -> 38
    //   20: aload_0
    //   21: getfield mInitialized : Z
    //   24: ifne -> 30
    //   27: goto -> 38
    //   30: new java/lang/AssertionError
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: athrow
    //   38: invokestatic uptimeMillis : ()J
    //   41: lstore #4
    //   43: invokestatic useCrazyLinker : ()Z
    //   46: ifeq -> 352
    //   49: invokestatic getInstance : ()Lorg/chromium/base/library_loader/Linker;
    //   52: astore #11
    //   54: getstatic org/chromium/base/library_loader/NativeLibraries.sUseLibraryInZipFile : Z
    //   57: ifeq -> 692
    //   60: aload_1
    //   61: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   64: getfield sourceDir : Ljava/lang/String;
    //   67: astore #9
    //   69: goto -> 72
    //   72: aload #11
    //   74: getfield mLock : Ljava/lang/Object;
    //   77: astore #12
    //   79: aload #12
    //   81: monitorenter
    //   82: aload #11
    //   84: invokevirtual ensureInitializedLocked : ()V
    //   87: aload #9
    //   89: ifnull -> 98
    //   92: aload #9
    //   94: invokestatic nativeAddZipArchivePath : (Ljava/lang/String;)Z
    //   97: pop
    //   98: aload #11
    //   100: iconst_1
    //   101: putfield mPrepareLibraryLoadCalled : Z
    //   104: aload #11
    //   106: getfield mInBrowserProcess : Z
    //   109: ifeq -> 117
    //   112: aload #11
    //   114: invokevirtual setupBaseLoadAddressLocked : ()V
    //   117: aload #12
    //   119: monitorexit
    //   120: getstatic org/chromium/base/library_loader/NativeLibraries.LIBRARIES : [Ljava/lang/String;
    //   123: astore #13
    //   125: aload #13
    //   127: arraylength
    //   128: istore_3
    //   129: iconst_0
    //   130: istore_2
    //   131: iload_2
    //   132: iload_3
    //   133: if_icmpge -> 338
    //   136: aload #13
    //   138: iload_2
    //   139: aaload
    //   140: astore #12
    //   142: aload #12
    //   144: invokestatic isChromiumLinkerLibrary : (Ljava/lang/String;)Z
    //   147: ifne -> 698
    //   150: aload #12
    //   152: invokestatic mapLibraryName : (Ljava/lang/String;)Ljava/lang/String;
    //   155: astore #14
    //   157: aload #9
    //   159: ifnull -> 216
    //   162: new java/lang/StringBuilder
    //   165: dup
    //   166: ldc_w ' Loading '
    //   169: invokespecial <init> : (Ljava/lang/String;)V
    //   172: astore #15
    //   174: aload #15
    //   176: aload #12
    //   178: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload #15
    //   184: ldc_w ' from within '
    //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload #15
    //   193: aload #9
    //   195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: ldc 'LibraryLoader'
    //   201: aload #15
    //   203: invokevirtual toString : ()Ljava/lang/String;
    //   206: iconst_0
    //   207: anewarray java/lang/Object
    //   210: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: goto -> 250
    //   216: new java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 'Loading '
    //   223: invokespecial <init> : (Ljava/lang/String;)V
    //   226: astore #15
    //   228: aload #15
    //   230: aload #12
    //   232: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: ldc 'LibraryLoader'
    //   238: aload #15
    //   240: invokevirtual toString : ()Ljava/lang/String;
    //   243: iconst_0
    //   244: anewarray java/lang/Object
    //   247: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   250: aload_0
    //   251: aload #11
    //   253: aload #14
    //   255: invokespecial loadLibraryWithCustomLinkerAlreadyLocked$598239cf : (Lorg/chromium/base/library_loader/Linker;Ljava/lang/String;)V
    //   258: getstatic org/chromium/base/library_loader/LibraryLoader.sRelinkerCountHistogram : Lorg/chromium/base/metrics/CachedMetrics$EnumeratedHistogramSample;
    //   261: iconst_0
    //   262: invokevirtual record : (I)V
    //   265: goto -> 698
    //   268: astore #14
    //   270: getstatic org/chromium/base/library_loader/NativeLibraries.sUseLibraryInZipFile : Z
    //   273: ifne -> 304
    //   276: getstatic org/chromium/base/library_loader/LibraryLoader.PLATFORM_REQUIRES_NATIVE_FALLBACK_EXTRACTION : Z
    //   279: ifeq -> 304
    //   282: aload_0
    //   283: aload #11
    //   285: aload_1
    //   286: aload #12
    //   288: invokestatic getExtractedLibraryPath : (Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   291: invokespecial loadLibraryWithCustomLinkerAlreadyLocked$598239cf : (Lorg/chromium/base/library_loader/Linker;Ljava/lang/String;)V
    //   294: getstatic org/chromium/base/library_loader/LibraryLoader.sRelinkerCountHistogram : Lorg/chromium/base/metrics/CachedMetrics$EnumeratedHistogramSample;
    //   297: iconst_1
    //   298: invokevirtual record : (I)V
    //   301: goto -> 698
    //   304: new java/lang/StringBuilder
    //   307: dup
    //   308: ldc_w 'Unable to load library: '
    //   311: invokespecial <init> : (Ljava/lang/String;)V
    //   314: astore_1
    //   315: aload_1
    //   316: aload #12
    //   318: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: ldc 'LibraryLoader'
    //   324: aload_1
    //   325: invokevirtual toString : ()Ljava/lang/String;
    //   328: iconst_0
    //   329: anewarray java/lang/Object
    //   332: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   335: aload #14
    //   337: athrow
    //   338: aload #11
    //   340: invokevirtual finishLibraryLoad : ()V
    //   343: goto -> 570
    //   346: astore_1
    //   347: aload #12
    //   349: monitorexit
    //   350: aload_1
    //   351: athrow
    //   352: invokestatic setEnvForNative : ()V
    //   355: aload_0
    //   356: invokevirtual preloadAlreadyLocked$faab20d : ()V
    //   359: getstatic org/chromium/base/library_loader/LibraryLoader.$assertionsDisabled : Z
    //   362: ifne -> 390
    //   365: getstatic org/chromium/base/library_loader/NativeLibraries.sUseLibraryInZipFile : Z
    //   368: ifeq -> 390
    //   371: getstatic android/os/Build$VERSION.SDK_INT : I
    //   374: bipush #23
    //   376: if_icmplt -> 382
    //   379: goto -> 390
    //   382: new java/lang/AssertionError
    //   385: dup
    //   386: invokespecial <init> : ()V
    //   389: athrow
    //   390: getstatic org/chromium/base/library_loader/NativeLibraries.LIBRARIES : [Ljava/lang/String;
    //   393: astore #11
    //   395: aload #11
    //   397: arraylength
    //   398: istore_3
    //   399: iconst_0
    //   400: istore_2
    //   401: iload_2
    //   402: iload_3
    //   403: if_icmpge -> 570
    //   406: aload #11
    //   408: iload_2
    //   409: aaload
    //   410: astore #9
    //   412: getstatic org/chromium/base/library_loader/NativeLibraries.sUseLibraryInZipFile : Z
    //   415: ifne -> 426
    //   418: aload #9
    //   420: invokestatic loadLibrary : (Ljava/lang/String;)V
    //   423: goto -> 526
    //   426: invokestatic is64Bit : ()Z
    //   429: istore #8
    //   431: aload_1
    //   432: invokevirtual getApplicationInfo : ()Landroid/content/pm/ApplicationInfo;
    //   435: getfield sourceDir : Ljava/lang/String;
    //   438: astore #12
    //   440: new java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial <init> : ()V
    //   447: astore #13
    //   449: aload #13
    //   451: aload #12
    //   453: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: aload #13
    //   459: ldc_w '!/'
    //   462: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload #13
    //   468: aload #9
    //   470: iconst_1
    //   471: iload #8
    //   473: invokestatic makeLibraryPathInZipFile : (Ljava/lang/String;ZZ)Ljava/lang/String;
    //   476: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload #13
    //   482: invokevirtual toString : ()Ljava/lang/String;
    //   485: astore #12
    //   487: new java/lang/StringBuilder
    //   490: dup
    //   491: ldc_w 'libraryName: '
    //   494: invokespecial <init> : (Ljava/lang/String;)V
    //   497: astore #13
    //   499: aload #13
    //   501: aload #12
    //   503: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: ldc 'LibraryLoader'
    //   509: aload #13
    //   511: invokevirtual toString : ()Ljava/lang/String;
    //   514: iconst_0
    //   515: anewarray java/lang/Object
    //   518: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   521: aload #12
    //   523: invokestatic load : (Ljava/lang/String;)V
    //   526: iload_2
    //   527: iconst_1
    //   528: iadd
    //   529: istore_2
    //   530: goto -> 401
    //   533: astore_1
    //   534: new java/lang/StringBuilder
    //   537: dup
    //   538: ldc_w 'Unable to load library: '
    //   541: invokespecial <init> : (Ljava/lang/String;)V
    //   544: astore #11
    //   546: aload #11
    //   548: aload #9
    //   550: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: ldc 'LibraryLoader'
    //   556: aload #11
    //   558: invokevirtual toString : ()Ljava/lang/String;
    //   561: iconst_0
    //   562: anewarray java/lang/Object
    //   565: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   568: aload_1
    //   569: athrow
    //   570: invokestatic uptimeMillis : ()J
    //   573: lstore #6
    //   575: aload_0
    //   576: lload #6
    //   578: lload #4
    //   580: lsub
    //   581: putfield mLibraryLoadTimeMs : J
    //   584: ldc 'LibraryLoader'
    //   586: ldc_w 'Time to load native libraries: %d ms (timestamps %d-%d)'
    //   589: iconst_3
    //   590: anewarray java/lang/Object
    //   593: dup
    //   594: iconst_0
    //   595: aload_0
    //   596: getfield mLibraryLoadTimeMs : J
    //   599: invokestatic valueOf : (J)Ljava/lang/Long;
    //   602: aastore
    //   603: dup
    //   604: iconst_1
    //   605: lload #4
    //   607: ldc2_w 10000
    //   610: lrem
    //   611: invokestatic valueOf : (J)Ljava/lang/Long;
    //   614: aastore
    //   615: dup
    //   616: iconst_2
    //   617: lload #6
    //   619: ldc2_w 10000
    //   622: lrem
    //   623: invokestatic valueOf : (J)Ljava/lang/Long;
    //   626: aastore
    //   627: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   630: iconst_0
    //   631: anewarray java/lang/Object
    //   634: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   637: aload_0
    //   638: iconst_1
    //   639: putfield mLoaded : Z
    //   642: aload #10
    //   644: ifnull -> 654
    //   647: aconst_null
    //   648: aload #10
    //   650: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/base/TraceEvent;)V
    //   653: return
    //   654: return
    //   655: astore_1
    //   656: aconst_null
    //   657: astore #9
    //   659: goto -> 668
    //   662: astore #9
    //   664: aload #9
    //   666: athrow
    //   667: astore_1
    //   668: aload #10
    //   670: ifnull -> 680
    //   673: aload #9
    //   675: aload #10
    //   677: invokestatic $closeResource : (Ljava/lang/Throwable;Lorg/chromium/base/TraceEvent;)V
    //   680: aload_1
    //   681: athrow
    //   682: astore_1
    //   683: new org/chromium/base/library_loader/ProcessInitException
    //   686: dup
    //   687: aload_1
    //   688: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   691: athrow
    //   692: aconst_null
    //   693: astore #9
    //   695: goto -> 72
    //   698: iload_2
    //   699: iconst_1
    //   700: iadd
    //   701: istore_2
    //   702: goto -> 131
    // Exception table:
    //   from	to	target	type
    //   0	7	682	java/lang/UnsatisfiedLinkError
    //   7	27	662	java/lang/Throwable
    //   7	27	655	finally
    //   30	38	662	java/lang/Throwable
    //   30	38	655	finally
    //   38	69	662	java/lang/Throwable
    //   38	69	655	finally
    //   72	82	662	java/lang/Throwable
    //   72	82	655	finally
    //   82	87	346	finally
    //   92	98	346	finally
    //   98	117	346	finally
    //   117	120	346	finally
    //   120	129	662	java/lang/Throwable
    //   120	129	655	finally
    //   142	157	662	java/lang/Throwable
    //   142	157	655	finally
    //   162	213	662	java/lang/Throwable
    //   162	213	655	finally
    //   216	250	662	java/lang/Throwable
    //   216	250	655	finally
    //   250	265	268	java/lang/UnsatisfiedLinkError
    //   250	265	662	java/lang/Throwable
    //   250	265	655	finally
    //   270	301	662	java/lang/Throwable
    //   270	301	655	finally
    //   304	338	662	java/lang/Throwable
    //   304	338	655	finally
    //   338	343	662	java/lang/Throwable
    //   338	343	655	finally
    //   347	350	346	finally
    //   350	352	662	java/lang/Throwable
    //   350	352	655	finally
    //   352	379	662	java/lang/Throwable
    //   352	379	655	finally
    //   382	390	662	java/lang/Throwable
    //   382	390	655	finally
    //   390	399	662	java/lang/Throwable
    //   390	399	655	finally
    //   412	423	533	java/lang/UnsatisfiedLinkError
    //   412	423	662	java/lang/Throwable
    //   412	423	655	finally
    //   426	526	533	java/lang/UnsatisfiedLinkError
    //   426	526	662	java/lang/Throwable
    //   426	526	655	finally
    //   534	570	662	java/lang/Throwable
    //   534	570	655	finally
    //   570	642	662	java/lang/Throwable
    //   570	642	655	finally
    //   647	653	682	java/lang/UnsatisfiedLinkError
    //   664	667	667	finally
    //   673	680	682	java/lang/UnsatisfiedLinkError
    //   680	682	682	java/lang/UnsatisfiedLinkError
  }
  
  private void loadLibraryWithCustomLinkerAlreadyLocked$598239cf(Linker paramLinker, String paramString) {
    assert false;
    throw new AssertionError();
  }
  
  private static String makeLibraryPathInZipFile(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    String str1;
    String str2;
    switch (NativeLibraries.sCpuFamily) {
      default:
        throw new RuntimeException("Unknown CPU ABI for native libraries");
      case 3:
        if (paramBoolean2) {
          String str = "x86_64";
          break;
        } 
        str1 = "x86";
        break;
      case 2:
        if (paramBoolean2) {
          str1 = "mips64";
          break;
        } 
        str1 = "mips";
        break;
      case 1:
        if (paramBoolean2) {
          str1 = "arm64-v8a";
          break;
        } 
        str1 = "armeabi-v7a";
        break;
    } 
    if (paramBoolean1) {
      str2 = "crazy.";
    } else {
      str2 = "";
    } 
    return String.format("lib/%s/%s%s", new Object[] { str1, str2, System.mapLibraryName(paramString) });
  }
  
  private static native void nativeForkAndPrefetchNativeLibrary();
  
  private native String nativeGetVersionNumber();
  
  private native boolean nativeLibraryLoaded(int paramInt);
  
  private static native int nativePercentageOfResidentNativeLibraryCode();
  
  private static native void nativePeriodicallyCollectResidency();
  
  private native void nativeRecordChromiumAndroidLinkerBrowserHistogram(boolean paramBoolean1, boolean paramBoolean2, int paramInt, long paramLong);
  
  private native void nativeRecordLibraryPreloaderBrowserHistogram(int paramInt);
  
  public static void setEnvForNative() {
    if (BuildConfig.IS_UBSAN && Build.VERSION.SDK_INT >= 21)
      try {
        Os.setenv("UBSAN_OPTIONS", "print_stacktrace=1 stack_trace_format='#%n pc %o %m' handle_segv=0 handle_sigbus=0 handle_sigfpe=0", true);
        return;
      } catch (Exception exception) {
        Log.w("LibraryLoader", "failed to set UBSAN_OPTIONS", new Object[] { exception });
      }  
  }
  
  public static boolean useCrazyLinker() {
    return (Build.VERSION.SDK_INT >= 24) ? false : NativeLibraries.sUseLinker;
  }
  
  public final void ensureCommandLineSwitchedAlreadyLocked() {
    assert false;
    throw new AssertionError();
  }
  
  public final void ensureInitialized(int paramInt) {
    synchronized (this.mLock) {
      if (this.mInitialized)
        return; 
      loadAlreadyLocked(ContextUtils.sApplicationContext);
      initializeAlreadyLocked(paramInt);
      return;
    } 
  }
  
  public final void initializeAlreadyLocked(int paramInt) {
    if (this.mInitialized) {
      if (this.mLibraryProcessType == paramInt)
        return; 
      throw new ProcessInitException();
    } 
    this.mLibraryProcessType = paramInt;
    ensureCommandLineSwitchedAlreadyLocked();
    if (nativeLibraryLoaded(this.mLibraryProcessType)) {
      Log.i("LibraryLoader", String.format("Expected native library version number \"%s\", actual native library version number \"%s\"", new Object[] { NativeLibraries.sVersionNumber, nativeGetVersionNumber() }), new Object[0]);
      if (NativeLibraries.sVersionNumber.equals(nativeGetVersionNumber())) {
        TraceEvent.registerNativeEnabledObserver();
        if (paramInt == 1 && PLATFORM_REQUIRES_NATIVE_FALLBACK_EXTRACTION)
          AsyncTask.THREAD_POOL_EXECUTOR.execute(new LibraryLoader$1()); 
        this.mInitialized = true;
        return;
      } 
      throw new ProcessInitException();
    } 
    Log.e("LibraryLoader", "error calling nativeLibraryLoaded", new Object[0]);
    throw new ProcessInitException();
  }
  
  public final void loadNowOverrideApplicationContext(Context paramContext) {
    synchronized (this.mLock) {
      if (!this.mLoaded || paramContext == ContextUtils.sApplicationContext) {
        loadAlreadyLocked(paramContext);
        return;
      } 
      throw new IllegalStateException("Attempt to load again from alternate context.");
    } 
  }
  
  public native void nativeRegisterChromiumAndroidLinkerRendererHistogram(boolean paramBoolean1, boolean paramBoolean2, long paramLong);
  
  public native void nativeRegisterLibraryPreloaderRendererHistogram(int paramInt);
  
  public final void preloadAlreadyLocked$faab20d() {
    TraceEvent traceEvent = TraceEvent.scoped("LibraryLoader.preloadAlreadyLocked");
    Throwable throwable2 = null;
    Throwable throwable1 = throwable2;
    try {
      assert false;
      throwable1 = throwable2;
      if (this.mLibraryPreloader != null) {
        throwable1 = throwable2;
        if (!this.mLibraryPreloaderCalled) {
          throwable1 = throwable2;
          this.mLibraryPreloaderStatus = this.mLibraryPreloader.loadLibrary$faab21a();
          throwable1 = throwable2;
          this.mLibraryPreloaderCalled = true;
        } 
      } 
      if (traceEvent != null) {
        $closeResource((Throwable)null, traceEvent);
        return;
      } 
      return;
    } catch (Throwable throwable) {
      throwable1 = throwable;
      throw throwable;
    } finally {}
    if (traceEvent != null)
      $closeResource(throwable1, traceEvent); 
    throw throwable2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\library_loader\LibraryLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */