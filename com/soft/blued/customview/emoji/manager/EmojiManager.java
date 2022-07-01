package com.soft.blued.customview.emoji.manager;

public final class EmojiManager {
  private static final EmojiManager a = new EmojiManager();
  
  private final EmojiTree b = new EmojiTree();
  
  private EmojiCategory[] c;
  
  public static EmojiManager a() {
    return a;
  }
  
  public static void a(EmojiProvider paramEmojiProvider) {
    a.c = paramEmojiProvider.a();
    a.b.a();
    int i = 0;
    while (true) {
      EmojiCategory[] arrayOfEmojiCategory = a.c;
      if (i < arrayOfEmojiCategory.length) {
        Emoji[] arrayOfEmoji = arrayOfEmojiCategory[i].a();
        for (int j = 0; j < arrayOfEmoji.length; j++)
          a.b.a(arrayOfEmoji[j]); 
        i++;
        continue;
      } 
      break;
    } 
  }
  
  Emoji a(CharSequence paramCharSequence) {
    b();
    return this.b.a(paramCharSequence);
  }
  
  public void b() {
    if (this.c != null)
      return; 
    a(new IosEmojiProvider());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\manager\EmojiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */