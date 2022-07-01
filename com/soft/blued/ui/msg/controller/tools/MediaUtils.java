package com.soft.blued.ui.msg.controller.tools;

import android.content.Context;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.provider.Settings;
import com.blued.android.core.AppInfo;
import java.lang.ref.SoftReference;

public class MediaUtils implements SoundPool.OnLoadCompleteListener {
  private static MediaUtils a;
  
  private Vibrator b = (Vibrator)AppInfo.d().getSystemService("vibrator");
  
  private MediaPlayer c = new MediaPlayer();
  
  private SoundPool d = new SoundPool(1, 3, 0);
  
  private final Handler e = new MyHandler(this);
  
  public MediaUtils() {
    this.d.setOnLoadCompleteListener(this);
  }
  
  public static MediaUtils a() {
    if (a == null)
      a = new MediaUtils(); 
    return a;
  }
  
  public static String a(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString) {
    try {
      Cursor cursor = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, paramString, paramArrayOfString, null);
      return null;
    } finally {
      paramContext = null;
      if (paramContext != null)
        paramContext.close(); 
    } 
  }
  
  private int c() {
    return (((AudioManager)AppInfo.d().getSystemService("audio")).getRingerMode() == 2) ? 2 : ((((AudioManager)AppInfo.d().getSystemService("audio")).getRingerMode() == 0) ? 0 : ((((AudioManager)AppInfo.d().getSystemService("audio")).getRingerMode() == 1) ? 1 : 2));
  }
  
  public String a(String paramString) {
    Uri uri = Uri.parse(paramString);
    if ("content".equalsIgnoreCase(uri.getScheme()))
      paramString = a(AppInfo.d(), uri, null, null); 
    String str = paramString;
    if (!paramString.toLowerCase().startsWith("file://")) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("file://");
      stringBuilder.append(paramString);
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  public void a(int paramInt) {
    if (c() != 0) {
      if (c() == 1)
        return; 
      SoundPool soundPool = this.d;
      if (soundPool != null) {
        if (paramInt != 1) {
          if (paramInt != 2)
            return; 
          soundPool.load(AppInfo.d(), 2131689475, 1);
          return;
        } 
        soundPool.load(AppInfo.d(), 2131689476, 1);
      } 
    } 
  }
  
  public void a(long paramLong) {
    this.b.vibrate(paramLong);
  }
  
  public void b() {
    try {
      this.c.reset();
      this.c.setLooping(false);
      String str = a(Settings.System.getString(AppInfo.d().getContentResolver(), "notification_sound"));
      this.c.setDataSource(str);
      this.c.setAudioStreamType(2);
      this.c.prepare();
      this.c.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this) {
            public void onPrepared(MediaPlayer param1MediaPlayer) {
              MediaUtils.a(this.a).start();
            }
          });
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void onLoadComplete(SoundPool paramSoundPool, int paramInt1, int paramInt2) {
    Message message = this.e.obtainMessage(10);
    message.arg1 = paramInt1;
    this.e.sendMessage(message);
  }
  
  static class MyHandler extends Handler {
    private SoftReference<MediaUtils> a;
    
    public MyHandler(MediaUtils param1MediaUtils) {
      this.a = new SoftReference<MediaUtils>(param1MediaUtils);
    }
    
    public void handleMessage(Message param1Message) {
      if (param1Message.what != 10)
        return; 
      MediaUtils mediaUtils = this.a.get();
      if (mediaUtils != null && MediaUtils.b(mediaUtils) != null)
        MediaUtils.b(mediaUtils).play(param1Message.arg1, 1.0F, 1.0F, 0, 0, 1.0F); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\controller\tools\MediaUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */