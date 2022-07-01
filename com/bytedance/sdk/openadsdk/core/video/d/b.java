package com.bytedance.sdk.openadsdk.core.video.d;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.HashMap;

public class b {
  public static void a(long paramLong, String paramString, b paramb) {
    (new a(paramb, paramLong)).execute((Object[])new String[] { paramString });
  }
  
  public static class a extends AsyncTask<String, Integer, Bitmap> {
    private b.b a;
    
    private long b = 0L;
    
    public a(b.b param1b, long param1Long) {
      this.a = param1b;
      this.b = param1Long;
    }
    
    protected Bitmap a(String... param1VarArgs) {
      Bitmap bitmap2 = null;
      Bitmap bitmap1 = bitmap2;
      try {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        String str = param1VarArgs[0];
        bitmap1 = bitmap2;
        if (str.startsWith("http")) {
          bitmap1 = bitmap2;
          mediaMetadataRetriever.setDataSource(str, new HashMap<Object, Object>());
        } else {
          bitmap1 = bitmap2;
          mediaMetadataRetriever.setDataSource(str);
        } 
        bitmap1 = bitmap2;
        Bitmap bitmap = mediaMetadataRetriever.getFrameAtTime(this.b * 1000L, 3);
        return bitmap;
      } finally {
        param1VarArgs = null;
        t.c("MediaUtils", "MediaUtils doInBackground : ", (Throwable)param1VarArgs);
      } 
    }
    
    protected void a(Bitmap param1Bitmap) {
      super.onPostExecute(param1Bitmap);
      b.b b1 = this.a;
      if (b1 != null)
        b1.a(param1Bitmap); 
    }
  }
  
  public static interface b {
    void a(Bitmap param1Bitmap);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\video\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */