package com.tencent.liteav.audio;

import com.tencent.liteav.basic.log.TXCLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class a {
  private HashMap<String, HashSet<Integer>> a = new HashMap<String, HashSet<Integer>>();
  
  private a() {}
  
  public static a a() {
    return a.a();
  }
  
  public void a(int paramInt) {
    HashSet<String> hashSet = new HashSet();
    for (Map.Entry<String, HashSet<Integer>> entry : this.a.entrySet()) {
      String str = (String)entry.getKey();
      HashSet hashSet1 = (HashSet)entry.getValue();
      hashSet1.remove(Integer.valueOf(paramInt));
      if (hashSet1.isEmpty()) {
        hashSet.add(str);
        TXCAudioEngine.getInstance().stopRemoteAudio(str);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stopPlay, tinyId:");
        stringBuilder.append(str);
        TXCLog.i("AudioPlayManager", stringBuilder.toString());
      } 
    } 
    for (String str : hashSet)
      this.a.remove(str); 
  }
  
  public void a(String paramString, int paramInt) {
    StringBuilder stringBuilder1;
    HashSet hashSet = this.a.get(paramString);
    if (hashSet == null)
      return; 
    hashSet.remove(Integer.valueOf(paramInt));
    if (hashSet.isEmpty()) {
      this.a.remove(paramString);
      TXCAudioEngine.getInstance().stopRemoteAudio(paramString);
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("stopRemoteAudio. tinyId:");
      stringBuilder1.append(paramString);
      stringBuilder1.append(", sessionId:");
      stringBuilder1.append(paramInt);
      TXCLog.i("AudioPlayManager", stringBuilder1.toString());
      return;
    } 
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("ignore stopRemoteAudio. because the same user is playing in other session. tinyId:");
    stringBuilder2.append(paramString);
    stringBuilder2.append(", cur sessionId:");
    stringBuilder2.append(paramInt);
    stringBuilder2.append(", other sessionId:");
    stringBuilder2.append(((Integer)stringBuilder1.iterator().next()).intValue());
    TXCLog.i("AudioPlayManager", stringBuilder2.toString());
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt) {
    HashSet<Integer> hashSet2 = this.a.get(paramString);
    HashSet<Integer> hashSet1 = hashSet2;
    if (hashSet2 == null) {
      hashSet1 = new HashSet();
      this.a.put(paramString, hashSet1);
    } 
    hashSet1.add(Integer.valueOf(paramInt));
    TXCAudioEngine.getInstance().startRemoteAudio(paramString, paramBoolean);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startRemoteAudio tinyId:");
    stringBuilder.append(paramString);
    stringBuilder.append(", sessionId:");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioPlayManager", stringBuilder.toString());
  }
  
  static class a {
    private static final a a = new a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\audio\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */