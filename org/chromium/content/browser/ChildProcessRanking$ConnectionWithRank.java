package org.chromium.content.browser;

import org.chromium.base.process_launcher.ChildProcessConnection;

final class ChildProcessRanking$ConnectionWithRank {
  public final ChildProcessConnection connection;
  
  public long frameDepth;
  
  public int importance;
  
  public boolean visible;
  
  public ChildProcessRanking$ConnectionWithRank(ChildProcessConnection paramChildProcessConnection, boolean paramBoolean, long paramLong, int paramInt) {
    this.connection = paramChildProcessConnection;
    this.visible = paramBoolean;
    this.frameDepth = paramLong;
    this.importance = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ChildProcessRanking$ConnectionWithRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */