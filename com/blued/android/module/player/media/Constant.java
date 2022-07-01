package com.blued.android.module.player.media;

import android.os.Environment;

public class Constant {
  public static class ALBUM_DEFAULT_CONFIG_DATA {}
  
  public static interface COVRE_DATA {}
  
  public static class INTENT_DATA_KEY {}
  
  public static class MEDIA_TYPE {}
  
  public static interface PATH {
    public static final String a;
    
    public static final String b;
    
    public static final String c;
    
    static {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(Environment.getExternalStorageDirectory());
      stringBuilder.append("/ShortVideo/");
      a = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(Environment.getExternalStorageDirectory());
      stringBuilder.append("/ShortVideo/img/");
      b = stringBuilder.toString();
      stringBuilder = new StringBuilder();
      stringBuilder.append(Environment.getExternalStorageDirectory());
      stringBuilder.append("/AutnVideo/");
      c = stringBuilder.toString();
    }
  }
  
  public static class PHOTO_SIZE {}
  
  public static class RESULT_CODE {}
  
  public static class SHOW_TYPE {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\Constant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */