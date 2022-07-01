package com.blued.android.module.external_sense_library.display;

import android.util.Log;
import com.sensetime.stmobile.STStickerEvent;

public class STStickerEventCallback {
  private static String TAG = "STStickerEventCallback";
  
  private STStickerEvent.StickerEventListener mStickerEventDefaultListener = new STStickerEvent.StickerEventListener() {
      public void onAnimationEvent(String param1String, int param1Int1, int param1Int2, int param1Int3, int param1Int4, long param1Long) {
        if (param1String == null)
          return; 
        String str = STStickerEventCallback.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onAnimationEvent ");
        stringBuilder.append(param1String);
        Log.e(str, stringBuilder.toString());
        if (param1Int2 == 1) {
          Log.e(STStickerEventCallback.TAG, "onAnimationEvent: ST_AS_PAUSED_FIRST_FRAME");
        } else if (param1Int2 == 3) {
          Log.e(STStickerEventCallback.TAG, "onAnimationEvent: ST_AS_PAUSED");
        } 
        if (param1Int2 == 2) {
          Log.e(STStickerEventCallback.TAG, "onAnimationEvent: ST_AS_PLAYING");
          return;
        } 
        if (param1Int2 == 4) {
          Log.e(STStickerEventCallback.TAG, "onAnimationEvent: ST_AS_PAUSED_LAST_FRAME");
          return;
        } 
        if (param1Int2 == 5)
          Log.e(STStickerEventCallback.TAG, "onAnimationEvent: ST_AS_INVISIBLE"); 
      }
      
      public void onKeyFrameEvent(String param1String, int param1Int) {
        if (param1String == null)
          return; 
        String str = STStickerEventCallback.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onKeyFrameEvent materialName:");
        stringBuilder.append(param1String);
        stringBuilder.append(" frame: ");
        stringBuilder.append(param1Int);
        Log.e(str, stringBuilder.toString());
      }
      
      public void onPackageEvent(String param1String, int param1Int1, int param1Int2, int param1Int3) {
        if (param1String == null)
          return; 
        String str = STStickerEventCallback.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onPackageEvent ");
        stringBuilder.append(param1String);
        Log.e(str, stringBuilder.toString());
        if (param1Int2 == 1) {
          Log.e(STStickerEventCallback.TAG, "onPackageEvent: package begin");
          return;
        } 
        if (param1Int2 == 2)
          Log.e(STStickerEventCallback.TAG, "onPackageEvent: package end"); 
      }
    };
  
  public STStickerEventCallback() {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getInstance: ");
    stringBuilder.append(STStickerEvent.getInstance());
    Log.e(str, stringBuilder.toString());
    if (STStickerEvent.getInstance() != null)
      STStickerEvent.getInstance().setStickerEventListener(this.mStickerEventDefaultListener); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\display\STStickerEventCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */