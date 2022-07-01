package com.tencent.liteav.audio;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.d;
import com.tencent.liteav.basic.util.g;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TXCSoundEffectPlayer implements TXAudioEffectManager.TXMusicPlayObserver {
  private static final String TAG = "AudioCenter:TXCSoundEffectPlayer";
  
  private static WeakReference<c> mWeakSoundEffectListener;
  
  private List<Integer> mShortEffectorIDList = new ArrayList<Integer>();
  
  static {
    g.f();
  }
  
  private String checkIfAssetsFile(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: astore #6
    //   3: aload_1
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: ifne -> 431
    //   10: invokestatic getAppContext : ()Landroid/content/Context;
    //   13: ifnonnull -> 18
    //   16: aload_1
    //   17: areturn
    //   18: aload_1
    //   19: ldc '/assets/'
    //   21: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   24: ifne -> 29
    //   27: aload_1
    //   28: areturn
    //   29: aload_1
    //   30: bipush #8
    //   32: invokevirtual substring : (I)Ljava/lang/String;
    //   35: astore #7
    //   37: invokestatic getAppContext : ()Landroid/content/Context;
    //   40: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   43: aload #7
    //   45: invokevirtual openFd : (Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   48: invokevirtual getLength : ()J
    //   51: lstore_3
    //   52: goto -> 109
    //   55: astore #6
    //   57: aload_1
    //   58: astore #5
    //   60: new java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial <init> : ()V
    //   67: astore #8
    //   69: aload_1
    //   70: astore #5
    //   72: aload #8
    //   74: ldc 'playAudioEffect openFd error '
    //   76: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_1
    //   81: astore #5
    //   83: aload #8
    //   85: aload #6
    //   87: invokevirtual toString : ()Ljava/lang/String;
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_1
    //   95: astore #5
    //   97: ldc 'AudioCenter:TXCSoundEffectPlayer'
    //   99: aload #8
    //   101: invokevirtual toString : ()Ljava/lang/String;
    //   104: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   107: lconst_0
    //   108: lstore_3
    //   109: aload_1
    //   110: astore #5
    //   112: aload_0
    //   113: invokespecial getEffectCachePath : ()Ljava/lang/String;
    //   116: astore #6
    //   118: aload_1
    //   119: astore #5
    //   121: new java/io/File
    //   124: dup
    //   125: aload #6
    //   127: invokespecial <init> : (Ljava/lang/String;)V
    //   130: astore #8
    //   132: aload_1
    //   133: astore #5
    //   135: aload #8
    //   137: invokevirtual exists : ()Z
    //   140: ifne -> 155
    //   143: aload_1
    //   144: astore #5
    //   146: aload #8
    //   148: invokevirtual mkdirs : ()Z
    //   151: pop
    //   152: goto -> 184
    //   155: aload_1
    //   156: astore #5
    //   158: aload #8
    //   160: invokevirtual isFile : ()Z
    //   163: ifeq -> 184
    //   166: aload_1
    //   167: astore #5
    //   169: aload #8
    //   171: invokevirtual delete : ()Z
    //   174: pop
    //   175: aload_1
    //   176: astore #5
    //   178: aload #8
    //   180: invokevirtual mkdirs : ()Z
    //   183: pop
    //   184: aload_1
    //   185: astore #5
    //   187: aload #7
    //   189: getstatic java/io/File.separatorChar : C
    //   192: invokevirtual lastIndexOf : (I)I
    //   195: istore_2
    //   196: iload_2
    //   197: iconst_m1
    //   198: if_icmpeq -> 286
    //   201: aload_1
    //   202: astore #5
    //   204: new java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial <init> : ()V
    //   211: astore #8
    //   213: aload_1
    //   214: astore #5
    //   216: aload #8
    //   218: aload #6
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: astore #5
    //   227: aload #8
    //   229: getstatic java/io/File.separator : Ljava/lang/String;
    //   232: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_1
    //   237: astore #5
    //   239: aload #8
    //   241: lload_3
    //   242: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_1
    //   247: astore #5
    //   249: aload #8
    //   251: ldc '_'
    //   253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_1
    //   258: astore #5
    //   260: aload #8
    //   262: aload #7
    //   264: iload_2
    //   265: iconst_1
    //   266: iadd
    //   267: invokevirtual substring : (I)Ljava/lang/String;
    //   270: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_1
    //   275: astore #5
    //   277: aload #8
    //   279: invokevirtual toString : ()Ljava/lang/String;
    //   282: astore_1
    //   283: goto -> 362
    //   286: aload_1
    //   287: astore #5
    //   289: new java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial <init> : ()V
    //   296: astore #8
    //   298: aload_1
    //   299: astore #5
    //   301: aload #8
    //   303: aload #6
    //   305: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload_1
    //   310: astore #5
    //   312: aload #8
    //   314: getstatic java/io/File.separator : Ljava/lang/String;
    //   317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_1
    //   322: astore #5
    //   324: aload #8
    //   326: lload_3
    //   327: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_1
    //   332: astore #5
    //   334: aload #8
    //   336: ldc '_'
    //   338: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: pop
    //   342: aload_1
    //   343: astore #5
    //   345: aload #8
    //   347: aload #7
    //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_1
    //   354: astore #5
    //   356: aload #8
    //   358: invokevirtual toString : ()Ljava/lang/String;
    //   361: astore_1
    //   362: aload_1
    //   363: astore #5
    //   365: aload_1
    //   366: astore #6
    //   368: aload_1
    //   369: invokestatic a : (Ljava/lang/String;)Z
    //   372: ifne -> 431
    //   375: aload_1
    //   376: astore #5
    //   378: invokestatic getAppContext : ()Landroid/content/Context;
    //   381: aload #7
    //   383: aload_1
    //   384: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload_1
    //   388: areturn
    //   389: astore_1
    //   390: new java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial <init> : ()V
    //   397: astore #6
    //   399: aload #6
    //   401: ldc 'playAudioEffect error '
    //   403: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload #6
    //   409: aload_1
    //   410: invokevirtual toString : ()Ljava/lang/String;
    //   413: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: ldc 'AudioCenter:TXCSoundEffectPlayer'
    //   419: aload #6
    //   421: invokevirtual toString : ()Ljava/lang/String;
    //   424: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   427: aload #5
    //   429: astore #6
    //   431: aload #6
    //   433: areturn
    // Exception table:
    //   from	to	target	type
    //   37	52	55	java/lang/Exception
    //   60	69	389	java/lang/Exception
    //   72	80	389	java/lang/Exception
    //   83	94	389	java/lang/Exception
    //   97	107	389	java/lang/Exception
    //   112	118	389	java/lang/Exception
    //   121	132	389	java/lang/Exception
    //   135	143	389	java/lang/Exception
    //   146	152	389	java/lang/Exception
    //   158	166	389	java/lang/Exception
    //   169	175	389	java/lang/Exception
    //   178	184	389	java/lang/Exception
    //   187	196	389	java/lang/Exception
    //   204	213	389	java/lang/Exception
    //   216	224	389	java/lang/Exception
    //   227	236	389	java/lang/Exception
    //   239	246	389	java/lang/Exception
    //   249	257	389	java/lang/Exception
    //   260	274	389	java/lang/Exception
    //   277	283	389	java/lang/Exception
    //   289	298	389	java/lang/Exception
    //   301	309	389	java/lang/Exception
    //   312	321	389	java/lang/Exception
    //   324	331	389	java/lang/Exception
    //   334	342	389	java/lang/Exception
    //   345	353	389	java/lang/Exception
    //   356	362	389	java/lang/Exception
    //   368	375	389	java/lang/Exception
    //   378	387	389	java/lang/Exception
  }
  
  private String getEffectCachePath() {
    if (TXCCommonUtil.getAppContext() == null)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(TXCCommonUtil.getAppContext().getCacheDir());
    stringBuilder.append(File.separator);
    stringBuilder.append("liteav_effect");
    return stringBuilder.toString();
  }
  
  public static TXCSoundEffectPlayer getInstance() {
    return a.a();
  }
  
  public void clearCache() {
    if (TXCCommonUtil.getAppContext() == null)
      return; 
    try {
      File file = new File(getEffectCachePath());
      if (file.exists() && file.isDirectory() && d.a(file) > 52428800L) {
        File[] arrayOfFile = file.listFiles();
        int j = arrayOfFile.length;
        for (int i = 0; i < j; i++)
          arrayOfFile[i].delete(); 
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("clearCache error ");
      stringBuilder.append(exception.toString());
      TXCLog.w("AudioCenter:TXCSoundEffectPlayer", stringBuilder.toString());
    } 
  }
  
  public void onComplete(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onMusicPlayFinish -> effect id = ");
    stringBuilder.append(paramInt1);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", stringBuilder.toString());
    WeakReference<c> weakReference = mWeakSoundEffectListener;
    if (weakReference != null && weakReference.get() != null)
      ((c)mWeakSoundEffectListener.get()).onEffectPlayFinish(paramInt1); 
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2) {}
  
  public void onStart(int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onStart -> effect id = ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", errCode = ");
    stringBuilder.append(paramInt2);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", stringBuilder.toString());
    WeakReference<c> weakReference = mWeakSoundEffectListener;
    if (weakReference != null && weakReference.get() != null)
      ((c)mWeakSoundEffectListener.get()).onEffectPlayStart(paramInt1, paramInt2); 
  }
  
  public void pauseEffectWithId(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pauseEffectWithId -> effect id = ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", stringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().pausePlayMusic(paramInt);
  }
  
  public boolean playEffectWithId(int paramInt1, String paramString, boolean paramBoolean, int paramInt2) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("playEffectWithId -> effect id = ");
    stringBuilder2.append(paramInt1);
    stringBuilder2.append(", path = ");
    stringBuilder2.append(paramString);
    stringBuilder2.append(", loop = ");
    stringBuilder2.append(paramInt2);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", stringBuilder2.toString());
    TXAudioEffectManager.AudioMusicParam audioMusicParam = new TXAudioEffectManager.AudioMusicParam(paramInt1, checkIfAssetsFile(paramString));
    audioMusicParam.publish = paramBoolean;
    audioMusicParam.loopCount = paramInt2;
    audioMusicParam.isShortFile = true;
    paramBoolean = TXAudioEffectManagerImpl.getCacheInstance().startPlayMusic(audioMusicParam);
    TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(paramInt1, this);
    this.mShortEffectorIDList.add(Integer.valueOf(paramInt1));
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("playEffectWithId ->effect id = ");
    stringBuilder1.append(paramInt1);
    stringBuilder1.append(", startPlayMusic result = ");
    stringBuilder1.append(paramBoolean);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", stringBuilder1.toString());
    return paramBoolean;
  }
  
  public void resumeEffectWithId(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("resumeEffectWithId -> effect id = ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", stringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().resumePlayMusic(paramInt);
  }
  
  public void setEffectsVolume(float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setEffectsVolume -> volume = ");
    stringBuilder.append(paramFloat);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", stringBuilder.toString());
    Iterator<Integer> iterator = this.mShortEffectorIDList.iterator();
    while (iterator.hasNext()) {
      int i = ((Integer)iterator.next()).intValue();
      TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(i, (int)(100.0F * paramFloat));
    } 
  }
  
  public void setSoundEffectListener(c paramc) {
    if (paramc == null) {
      mWeakSoundEffectListener = null;
      return;
    } 
    mWeakSoundEffectListener = new WeakReference<c>(paramc);
  }
  
  public void setVolumeOfEffect(int paramInt, float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setVolumeOfEffect -> effect id = ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", volume = ");
    stringBuilder.append(paramFloat);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", stringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(paramInt, (int)(paramFloat * 100.0F));
  }
  
  public void stopAllEffect() {
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "stopAllEffect -> start");
    Iterator<Integer> iterator = this.mShortEffectorIDList.iterator();
    while (iterator.hasNext()) {
      int i = ((Integer)iterator.next()).intValue();
      TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(i);
    } 
    this.mShortEffectorIDList.clear();
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", "stopAllEffect -> finish");
  }
  
  public void stopEffectWithId(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("stopEffectWithId -> effect id = ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCSoundEffectPlayer", stringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(paramInt, null);
    TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(paramInt);
    paramInt = this.mShortEffectorIDList.indexOf(Integer.valueOf(paramInt));
    if (paramInt >= 0)
      this.mShortEffectorIDList.remove(paramInt); 
  }
  
  static class a {
    private static final TXCSoundEffectPlayer a = new TXCSoundEffectPlayer();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\audio\TXCSoundEffectPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */