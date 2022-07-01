package com.soft.blued.customview.emoji.manager;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public final class RecentEmojiManager implements RecentEmoji {
  private final Context a;
  
  private EmojiList b = new EmojiList(0);
  
  public RecentEmojiManager(Context paramContext) {
    this.a = paramContext.getApplicationContext();
  }
  
  private SharedPreferences c() {
    return this.a.getSharedPreferences("emoji-recent-manager", 0);
  }
  
  public Collection<Emoji> a() {
    if (this.b.b() == 0) {
      String str = c().getString("recent-emojis", "");
      if (str.length() > 0) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "~");
        while (stringTokenizer.hasMoreTokens()) {
          String[] arrayOfString = stringTokenizer.nextToken().split(";");
          if (arrayOfString.length == 2) {
            Emoji emoji = EmojiManager.a().a(arrayOfString[0]);
            if (emoji != null && emoji.d() == arrayOfString[0].length()) {
              long l = Long.parseLong(arrayOfString[1]);
              this.b.a(emoji, l);
            } 
          } 
        } 
      } 
    } 
    return this.b.a();
  }
  
  public void a(Emoji paramEmoji) {
    this.b.a(paramEmoji);
  }
  
  public void b() {
    if (this.b.b() > 0) {
      StringBuilder stringBuilder = new StringBuilder(this.b.b() * 5);
      for (Data data : this.b) {
        stringBuilder.append(data.a.a());
        stringBuilder.append(";");
        stringBuilder.append(data.b);
        stringBuilder.append("~");
      } 
      stringBuilder.setLength(stringBuilder.length() - 1);
      c().edit().putString("recent-emojis", stringBuilder.toString()).apply();
    } 
  }
  
  static class Data {
    final Emoji a;
    
    final long b;
    
    Data(Emoji param1Emoji, long param1Long) {
      this.a = param1Emoji;
      this.b = param1Long;
    }
  }
  
  static class EmojiList implements Iterable<Data> {
    static final Comparator<RecentEmojiManager.Data> a = new Comparator<RecentEmojiManager.Data>() {
        public int a(RecentEmojiManager.Data param2Data1, RecentEmojiManager.Data param2Data2) {
          return Long.valueOf(param2Data2.b).compareTo(Long.valueOf(param2Data1.b));
        }
      };
    
    final List<RecentEmojiManager.Data> b;
    
    EmojiList(int param1Int) {
      this.b = new ArrayList<RecentEmojiManager.Data>(param1Int);
    }
    
    Collection<Emoji> a() {
      Collections.sort(this.b, a);
      ArrayList<Emoji> arrayList = new ArrayList(this.b.size());
      Iterator<RecentEmojiManager.Data> iterator = this.b.iterator();
      while (iterator.hasNext())
        arrayList.add(((RecentEmojiManager.Data)iterator.next()).a); 
      return arrayList;
    }
    
    void a(Emoji param1Emoji) {
      a(param1Emoji, System.currentTimeMillis());
    }
    
    void a(Emoji param1Emoji, long param1Long) {
      Iterator<RecentEmojiManager.Data> iterator = this.b.iterator();
      while (iterator.hasNext()) {
        if (((RecentEmojiManager.Data)iterator.next()).a.equals(param1Emoji))
          iterator.remove(); 
      } 
      this.b.add(0, new RecentEmojiManager.Data(param1Emoji, param1Long));
      if (this.b.size() > 35)
        this.b.remove(35); 
    }
    
    int b() {
      return this.b.size();
    }
    
    public Iterator<RecentEmojiManager.Data> iterator() {
      return this.b.iterator();
    }
  }
  
  static final class null implements Comparator<Data> {
    public int a(RecentEmojiManager.Data param1Data1, RecentEmojiManager.Data param1Data2) {
      return Long.valueOf(param1Data2.b).compareTo(Long.valueOf(param1Data1.b));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\manager\RecentEmojiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */