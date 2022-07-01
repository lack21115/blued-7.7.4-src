package com.blued.android.module.player.audio;

public interface IAudioPlayer {
  IAudioPlayer a();
  
  IAudioPlayer a(String paramString);
  
  IAudioPlayer a(boolean paramBoolean);
  
  void b();
  
  void c();
  
  public static interface OnCompletionListener {
    void a(IAudioPlayer param1IAudioPlayer);
  }
  
  public static interface OnErrorListener {
    boolean a(IAudioPlayer param1IAudioPlayer, int param1Int1, int param1Int2);
  }
  
  public static interface OnPreparedListener {
    void a(IAudioPlayer param1IAudioPlayer);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\audio\IAudioPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */