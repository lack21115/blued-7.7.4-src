package com.sensetime.stmobile;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class STSoundPlay {
  private static String TAG = "STSoundPlay";
  
  private final String CACHED_FOLDER = "Audio";
  
  AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
      public void onAudioFocusChange(int param1Int) {
        if (param1Int == -2) {
          Log.e(STSoundPlay.TAG, "AUDIOFOCUS_LOSS_TRANSIENT reset");
          if (STSoundPlay.this.mediaPlayer.isPlaying()) {
            STSoundPlay.this.mediaPlayer.pause();
            return;
          } 
        } else if (param1Int == 1) {
          Log.e(STSoundPlay.TAG, "AUDIOFOCUS_GAIN");
          if (STSoundPlay.this.mediaPlayer != null && !STSoundPlay.this.mediaPlayer.isPlaying()) {
            STSoundPlay.this.mediaPlayer.start();
            return;
          } 
        } else if (param1Int == -1) {
          Log.e(STSoundPlay.TAG, "AUDIOFOCUS_LOSS reset");
        } 
      }
    };
  
  private AudioManager mAudioManager;
  
  private String mCachedPath;
  
  private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
      public void onCompletion(MediaPlayer param1MediaPlayer) {
        try {
          STSoundPlay.SoundMetaData soundMetaData = (STSoundPlay.SoundMetaData)STSoundPlay.this.mSoundMetaDataMap.get(STSoundPlay.this.mCurrentPlaying);
          if (soundMetaData != null) {
            int i = soundMetaData.loop - 1;
            soundMetaData.loop = i;
            if (i > 0) {
              String str = STSoundPlay.TAG;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("loop ");
              stringBuilder.append(soundMetaData.loop);
              Log.e(str, stringBuilder.toString());
              STSoundPlay.this.mediaPlayer.start();
              return;
            } 
          } 
          Log.e(STSoundPlay.TAG, "play done");
          STSoundPlay.this.setSoundPlayDone(soundMetaData.name);
          STSoundPlay.this.mediaPlayer.stop();
          STSoundPlay.this.mediaPlayer.reset();
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          return;
        } 
      }
    };
  
  private Context mContext;
  
  private String mCurrentPlaying;
  
  private MediaPlayer.OnErrorListener mErrorListener = new MediaPlayer.OnErrorListener() {
      public boolean onError(MediaPlayer param1MediaPlayer, int param1Int1, int param1Int2) {
        String str = STSoundPlay.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MediaPlayer error: ");
        stringBuilder.append(param1Int1);
        stringBuilder.append(";");
        stringBuilder.append(param1Int2);
        Log.e(str, stringBuilder.toString());
        return true;
      }
    };
  
  private PlayControlListener mPlayControlDefaultListener = new PlayControlListener() {
      public void onSoundLoaded(String param1String, byte[] param1ArrayOfbyte) {
        if (param1String == null)
          return; 
        String str1 = STSoundPlay.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSoundLoaded ");
        stringBuilder.append(param1String);
        Log.e(str1, stringBuilder.toString());
        String str2 = STSoundPlay.this.saveSoundToFile(param1String, param1ArrayOfbyte);
        if (str2 != null) {
          STSoundPlay.SoundMetaData soundMetaData2 = (STSoundPlay.SoundMetaData)STSoundPlay.this.mSoundMetaDataMap.get(param1String);
          STSoundPlay.SoundMetaData soundMetaData1 = soundMetaData2;
          if (soundMetaData2 == null)
            soundMetaData1 = new STSoundPlay.SoundMetaData(); 
          soundMetaData1.cachePath = str2;
          soundMetaData1.name = param1String;
          STSoundPlay.this.mSoundMetaDataMap.put(param1String, soundMetaData1);
          return;
        } 
        Log.e(STSoundPlay.TAG, "SoundFilePath is null");
      }
      
      public void onSoundPause(String param1String) {
        String str = STSoundPlay.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSoundPause ");
        stringBuilder.append(param1String);
        Log.e(str, stringBuilder.toString());
        if (!param1String.equals(STSoundPlay.this.mCurrentPlaying)) {
          Log.e(STSoundPlay.TAG, "No meta-data when stop");
          return;
        } 
        if (STSoundPlay.this.mediaPlayer.isPlaying()) {
          Log.e(STSoundPlay.TAG, "Playing when onStopPlay callback");
          STSoundPlay.this.mediaPlayer.pause();
        } 
      }
      
      public void onSoundResume(String param1String) {
        String str = STSoundPlay.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onStopPlay ");
        stringBuilder.append(param1String);
        Log.e(str, stringBuilder.toString());
        if (param1String.equals(STSoundPlay.this.mCurrentPlaying)) {
          Log.e(STSoundPlay.TAG, "No meta-data when stop");
          STSoundPlay.this.mediaPlayer.start();
        } 
      }
      
      public void onStartPlay(String param1String, int param1Int) {
        STSoundPlay.SoundMetaData soundMetaData = (STSoundPlay.SoundMetaData)STSoundPlay.this.mSoundMetaDataMap.get(param1String);
        if (soundMetaData == null) {
          Log.e(STSoundPlay.TAG, "No meta-data when start");
          return;
        } 
        soundMetaData.loop = param1Int;
        String str = STSoundPlay.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onStartPlay ");
        stringBuilder.append(param1String);
        Log.e(str, stringBuilder.toString());
        if (STSoundPlay.this.mediaPlayer.isPlaying()) {
          Log.e(STSoundPlay.TAG, "Stop it before play");
          STSoundPlay sTSoundPlay = STSoundPlay.this;
          sTSoundPlay.setSoundPlayDone(sTSoundPlay.mCurrentPlaying);
          STSoundPlay.this.mediaPlayer.reset();
        } 
        try {
          MediaPlayer mediaPlayer = STSoundPlay.this.mediaPlayer;
          stringBuilder = new StringBuilder();
          stringBuilder.append(STSoundPlay.this.mCachedPath);
          stringBuilder.append(File.separator);
          stringBuilder.append(param1String);
          mediaPlayer.setDataSource(stringBuilder.toString());
          STSoundPlay.this.mediaPlayer.prepare();
        } catch (IOException iOException) {
          String str1 = STSoundPlay.TAG;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("IOException:");
          stringBuilder1.append(iOException.toString());
          Log.e(str1, stringBuilder1.toString());
          iOException.printStackTrace();
        } catch (IllegalStateException illegalStateException) {
          String str1 = STSoundPlay.TAG;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("IllegalStateException:");
          stringBuilder1.append(illegalStateException.toString());
          Log.e(str1, stringBuilder1.toString());
          illegalStateException.printStackTrace();
        } 
        STSoundPlay.access$002(STSoundPlay.this, param1String);
        if (param1Int == 0)
          STSoundPlay.this.mediaPlayer.setLooping(true); 
        STSoundPlay.this.mediaPlayer.start();
      }
      
      public void onStopPlay(String param1String) {
        String str = STSoundPlay.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onStopPlay ");
        stringBuilder.append(param1String);
        Log.e(str, stringBuilder.toString());
        if ((STSoundPlay.SoundMetaData)STSoundPlay.this.mSoundMetaDataMap.get(param1String) == null || !param1String.equals(STSoundPlay.this.mCurrentPlaying)) {
          Log.e(STSoundPlay.TAG, "No meta-data when stop");
          return;
        } 
        if (STSoundPlay.this.mediaPlayer.isPlaying()) {
          Log.e(STSoundPlay.TAG, "Playing when onStopPlay callback");
          STSoundPlay.this.mediaPlayer.reset();
        } 
      }
    };
  
  private HashMap<String, SoundMetaData> mSoundMetaDataMap = new HashMap<String, SoundMetaData>();
  
  private MediaPlayer mediaPlayer;
  
  private WeakReference<STMobileStickerNative> stickerHandleRef;
  
  public STSoundPlay(Context paramContext) {
    this.mContext = paramContext.getApplicationContext();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mContext.getExternalCacheDir());
    stringBuilder.append(File.separator);
    stringBuilder.append("Audio");
    this.mCachedPath = stringBuilder.toString();
    this.mAudioManager = (AudioManager)this.mContext.getSystemService("audio");
    File file = new File(this.mCachedPath);
    if (!file.exists())
      file.mkdirs(); 
    initMediaPlayer();
  }
  
  private void initMediaPlayer() {
    this.mediaPlayer = new MediaPlayer();
    this.mediaPlayer.setOnCompletionListener(this.mCompletionListener);
    this.mediaPlayer.setOnErrorListener(this.mErrorListener);
    this.mediaPlayer.reset();
  }
  
  private void onSoundLoaded(String paramString, byte[] paramArrayOfbyte) {
    PlayControlListener playControlListener = this.mPlayControlDefaultListener;
    if (playControlListener != null)
      playControlListener.onSoundLoaded(paramString, paramArrayOfbyte); 
  }
  
  private void onSoundPause(String paramString) {
    PlayControlListener playControlListener = this.mPlayControlDefaultListener;
    if (playControlListener != null)
      playControlListener.onSoundPause(paramString); 
  }
  
  private void onSoundResume(String paramString) {
    PlayControlListener playControlListener = this.mPlayControlDefaultListener;
    if (playControlListener != null)
      playControlListener.onSoundResume(paramString); 
  }
  
  private void onStartPlay(String paramString, int paramInt) {
    PlayControlListener playControlListener = this.mPlayControlDefaultListener;
    if (playControlListener != null)
      playControlListener.onStartPlay(paramString, paramInt); 
  }
  
  private void onStopPlay(String paramString) {
    PlayControlListener playControlListener = this.mPlayControlDefaultListener;
    if (playControlListener != null)
      playControlListener.onStopPlay(paramString); 
  }
  
  private boolean requestFocus() {
    return (this.mAudioManager.requestAudioFocus(this.afChangeListener, 3, 2) == 1);
  }
  
  private String saveSoundToFile(String paramString, byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder;
    boolean bool;
    File file = new File(this.mCachedPath);
    if (!file.exists()) {
      bool = file.mkdirs();
    } else {
      bool = true;
    } 
    if (!bool) {
      paramString = TAG;
      stringBuilder = new StringBuilder();
      stringBuilder.append(this.mCachedPath);
      stringBuilder.append(" is not exist");
      Log.e(paramString, stringBuilder.toString());
      return null;
    } 
    try {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(file.getPath());
      stringBuilder1.append(File.separator);
      stringBuilder1.append(paramString);
      File file1 = new File(stringBuilder1.toString());
      FileOutputStream fileOutputStream = new FileOutputStream(file1, false);
      fileOutputStream.write((byte[])stringBuilder);
      fileOutputStream.flush();
      fileOutputStream.close();
    } catch (IOException iOException) {
      String str = TAG;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("write file failed:");
      stringBuilder1.append(iOException.toString());
      Log.e(str, stringBuilder1.toString());
      iOException = null;
    } 
    return (iOException != null) ? iOException.getAbsolutePath() : null;
  }
  
  public void release() {
    MediaPlayer mediaPlayer = this.mediaPlayer;
    if (mediaPlayer != null) {
      mediaPlayer.release();
      this.mediaPlayer = null;
    } 
    AudioManager audioManager = this.mAudioManager;
    if (audioManager != null)
      audioManager.abandonAudioFocus(this.afChangeListener); 
  }
  
  public void setPlayControlListener(PlayControlListener paramPlayControlListener) {
    if (paramPlayControlListener != null)
      this.mPlayControlDefaultListener = paramPlayControlListener; 
  }
  
  public void setSoundPlayDone(String paramString) {
    if (this.stickerHandleRef.get() != null)
      ((STMobileStickerNative)this.stickerHandleRef.get()).setSoundPlayDone(paramString); 
  }
  
  public void setStickHandle(STMobileStickerNative paramSTMobileStickerNative) {
    this.stickerHandleRef = new WeakReference<STMobileStickerNative>(paramSTMobileStickerNative);
  }
  
  public static interface PlayControlListener {
    void onSoundLoaded(String param1String, byte[] param1ArrayOfbyte);
    
    void onSoundPause(String param1String);
    
    void onSoundResume(String param1String);
    
    void onStartPlay(String param1String, int param1Int);
    
    void onStopPlay(String param1String);
  }
  
  static class SoundMetaData {
    String cachePath;
    
    int loop;
    
    String name;
    
    private SoundMetaData() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sensetime\stmobile\STSoundPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */