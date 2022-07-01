package org.chromium.content.browser;

import java.util.Arrays;
import org.chromium.base.process_launcher.ChildProcessConnection;

public class ChildProcessRanking {
  private static final ChildProcessRanking$RankComparator COMPARATOR;
  
  final ChildProcessRanking$ConnectionWithRank[] mRankings;
  
  int mSize;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public ChildProcessRanking(int paramInt) {
    this.mRankings = new ChildProcessRanking$ConnectionWithRank[paramInt];
  }
  
  final int indexOf(ChildProcessConnection paramChildProcessConnection) {
    for (int i = 0; i < this.mSize; i++) {
      if ((this.mRankings[i]).connection == paramChildProcessConnection)
        return i; 
    } 
    return -1;
  }
  
  final void sort() {
    Arrays.sort(this.mRankings, 0, this.mSize, COMPARATOR);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\ChildProcessRanking.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */