package com.tencent.ijk.media.player.misc;

public interface IMediaFormat {
  public static final String KEY_HEIGHT = "height";
  
  public static final String KEY_MIME = "mime";
  
  public static final String KEY_WIDTH = "width";
  
  int getInteger(String paramString);
  
  String getString(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\misc\IMediaFormat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */