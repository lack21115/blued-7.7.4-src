package com.soft.blued.customview.emoji.manager;

import android.util.LruCache;
import androidx.collection.SparseArrayCompat;
import java.util.Iterator;

public final class EmojiTree {
  private EmojiNode a = new EmojiNode(null);
  
  private LruCache<CharSequence, Emoji> b = new LruCache<CharSequence, Emoji>(this, 200) {
      protected int a(CharSequence param1CharSequence, Emoji param1Emoji) {
        return 1;
      }
      
      protected void a(boolean param1Boolean, CharSequence param1CharSequence, Emoji param1Emoji1, Emoji param1Emoji2) {
        super.entryRemoved(param1Boolean, param1CharSequence, param1Emoji1, param1Emoji2);
      }
    };
  
  public Emoji a(CharSequence paramCharSequence) {
    EmojiNode emojiNode = this.a;
    Emoji emoji = null;
    for (int i = 0; i < paramCharSequence.length(); i++) {
      emojiNode = emojiNode.a(paramCharSequence.charAt(i));
      if (emojiNode == null)
        return emoji; 
      if (emojiNode.a() != null)
        emoji = emojiNode.a(); 
    } 
    return emoji;
  }
  
  public void a() {
    this.a = new EmojiNode(null);
  }
  
  public void a(Emoji paramEmoji) {
    String str = paramEmoji.a();
    EmojiNode emojiNode = this.a;
    for (int i = 0; i < str.length() - 1; i++)
      emojiNode = emojiNode.b(str.charAt(i)); 
    emojiNode.a(str.charAt(str.length() - 1), paramEmoji);
    Iterator<Emoji> iterator = paramEmoji.c().iterator();
    while (iterator.hasNext())
      a(iterator.next()); 
  }
  
  static class EmojiNode {
    final SparseArrayCompat<EmojiNode> a = new SparseArrayCompat();
    
    private Emoji b;
    
    EmojiNode(Emoji param1Emoji) {
      this.b = param1Emoji;
    }
    
    Emoji a() {
      return this.b;
    }
    
    EmojiNode a(char param1Char) {
      return (EmojiNode)this.a.get(param1Char);
    }
    
    void a(char param1Char, Emoji param1Emoji) {
      EmojiNode emojiNode1;
      EmojiNode emojiNode2 = (EmojiNode)this.a.get(param1Char);
      if (emojiNode2 == null) {
        emojiNode1 = new EmojiNode(param1Emoji);
        this.a.put(param1Char, emojiNode1);
        return;
      } 
      emojiNode2.a((Emoji)emojiNode1);
    }
    
    void a(Emoji param1Emoji) {
      this.b = param1Emoji;
    }
    
    EmojiNode b(char param1Char) {
      EmojiNode emojiNode2 = (EmojiNode)this.a.get(param1Char);
      EmojiNode emojiNode1 = emojiNode2;
      if (emojiNode2 == null) {
        emojiNode1 = new EmojiNode(null);
        this.a.put(param1Char, emojiNode1);
      } 
      return emojiNode1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\manager\EmojiTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */