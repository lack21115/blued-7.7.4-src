package com.tencent.liteav.audio;

import android.content.SharedPreferences;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;

public class b {
  private final SharedPreferences a = TXCCommonUtil.getAppContext().getSharedPreferences("txc_audio_settings", 0);
  
  private b() {}
  
  public static b a() {
    return a.a();
  }
  
  private void a(String paramString, Object paramObject) {
    SharedPreferences.Editor editor = this.a.edit();
    if (paramObject instanceof Integer) {
      editor.putInt(paramString, ((Integer)paramObject).intValue());
    } else if (paramObject instanceof String) {
      editor.putString(paramString, paramObject.toString());
    } else if (paramObject instanceof Boolean) {
      editor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    } else if (paramObject instanceof Long) {
      editor.putLong(paramString, ((Long)paramObject).longValue());
    } else if (paramObject instanceof Float) {
      editor.putFloat(paramString, ((Float)paramObject).floatValue());
    } else if (paramObject instanceof Double) {
      editor.putLong(paramString, Double.doubleToRawLongBits(((Double)paramObject).doubleValue()));
    } 
    editor.commit();
  }
  
  private Object b(String paramString, Object paramObject) {
    try {
      if (paramObject instanceof String)
        return this.a.getString(paramString, paramObject.toString()); 
      if (paramObject instanceof Integer)
        return Integer.valueOf(this.a.getInt(paramString, ((Integer)paramObject).intValue())); 
      if (paramObject instanceof Boolean)
        return Boolean.valueOf(this.a.getBoolean(paramString, ((Boolean)paramObject).booleanValue())); 
      if (paramObject instanceof Long)
        return Long.valueOf(this.a.getLong(paramString, ((Long)paramObject).longValue())); 
      if (paramObject instanceof Float)
        return Float.valueOf(this.a.getFloat(paramString, ((Float)paramObject).floatValue())); 
      if (paramObject instanceof Double) {
        double d = Double.longBitsToDouble(this.a.getLong(paramString, Double.doubleToLongBits(((Double)paramObject).doubleValue())));
        return Double.valueOf(d);
      } 
      return paramObject;
    } catch (Exception exception) {
      TXCLog.e("TXCAudioSettings", "get value from sharedpreference failed for key: %s", new Object[] { paramString, exception });
      return paramObject;
    } 
  }
  
  public void a(String paramString, long paramLong) {
    a(paramString, Long.valueOf(paramLong));
  }
  
  public long b(String paramString, long paramLong) {
    return ((Long)b(paramString, Long.valueOf(paramLong))).longValue();
  }
  
  static class a {
    private static final b a = new b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\audio\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */