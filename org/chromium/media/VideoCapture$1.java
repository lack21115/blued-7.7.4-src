package org.chromium.media;

import java.util.Comparator;

final class VideoCapture$1 implements Comparator {
  private int diff(VideoCapture$FramerateRange paramVideoCapture$FramerateRange) {
    return progressivePenalty(paramVideoCapture$FramerateRange.min, 8000, 1, 4) + progressivePenalty(Math.abs(targetFramerate - paramVideoCapture$FramerateRange.max), 5000, 1, 3);
  }
  
  private static int progressivePenalty(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramInt1 < paramInt2) ? (paramInt1 * paramInt3) : (paramInt3 * paramInt2 + (paramInt1 - paramInt2) * paramInt4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCapture$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */