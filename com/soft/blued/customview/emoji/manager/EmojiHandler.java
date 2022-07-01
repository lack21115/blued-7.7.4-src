package com.soft.blued.customview.emoji.manager;

import android.content.Context;
import android.text.Spannable;
import java.util.ArrayList;
import java.util.List;

public final class EmojiHandler {
  private static EmojiHandler a;
  
  public static EmojiHandler a() {
    if (a == null)
      a = new EmojiHandler(); 
    return a;
  }
  
  public void a(Context paramContext, Spannable paramSpannable, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
    if (paramBoolean)
      return; 
    SpanRangeList spanRangeList = new SpanRangeList(paramSpannable);
    EmojiManager emojiManager = EmojiManager.a();
    for (int i = paramInt1; i < paramInt1 + paramInt2; i += j) {
      int j = spanRangeList.a(i);
      if (j == -1) {
        int k = spanRangeList.b(i);
        j = k;
        if (k == -1)
          j = paramSpannable.length(); 
        Emoji emoji = emojiManager.a(paramSpannable.subSequence(i, j));
        if (emoji != null) {
          paramSpannable.setSpan(new EmojiconSpan(paramContext, emoji.b(), paramInt3, paramInt4, paramInt5), i, emoji.d() + i, 33);
          j = emoji.d();
        } else {
          i++;
          continue;
        } 
      } else {
        j -= i;
      } 
    } 
  }
  
  public void a(Context paramContext, Spannable paramSpannable, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    a(paramContext, paramSpannable, 0, paramSpannable.length(), paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  static final class Range {
    final int a;
    
    final int b;
    
    Range(int param1Int1, int param1Int2) {
      this.a = param1Int1;
      this.b = param1Int2;
    }
  }
  
  static final class SpanRangeList {
    private final List<EmojiHandler.Range> a = new ArrayList<EmojiHandler.Range>();
    
    SpanRangeList(Spannable param1Spannable) {
      int j = param1Spannable.length();
      int i = 0;
      EmojiSpan[] arrayOfEmojiSpan = (EmojiSpan[])param1Spannable.getSpans(0, j, EmojiSpan.class);
      j = arrayOfEmojiSpan.length;
      while (i < j) {
        EmojiSpan emojiSpan = arrayOfEmojiSpan[i];
        this.a.add(new EmojiHandler.Range(param1Spannable.getSpanStart(emojiSpan), param1Spannable.getSpanEnd(emojiSpan)));
        i++;
      } 
    }
    
    int a(int param1Int) {
      for (EmojiHandler.Range range : this.a) {
        if (range.a == param1Int)
          return range.b; 
      } 
      return -1;
    }
    
    int b(int param1Int) {
      for (EmojiHandler.Range range : this.a) {
        if (range.a > param1Int)
          return range.a; 
      } 
      return -1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\manager\EmojiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */