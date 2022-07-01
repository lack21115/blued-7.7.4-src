package com.soft.blued.customview.emoji.manager;

import com.soft.blued.customview.emoji.category.ActivityCategory;
import com.soft.blued.customview.emoji.category.FlagsCategory;
import com.soft.blued.customview.emoji.category.FoodsCategory;
import com.soft.blued.customview.emoji.category.NatureCategory;
import com.soft.blued.customview.emoji.category.ObjectsCategory;
import com.soft.blued.customview.emoji.category.PeopleCategory;
import com.soft.blued.customview.emoji.category.PlacesCategory;
import com.soft.blued.customview.emoji.category.SymbolsCategory;

public final class IosEmojiProvider implements EmojiProvider {
  public EmojiCategory[] a() {
    return new EmojiCategory[] { (EmojiCategory)new PeopleCategory(), (EmojiCategory)new NatureCategory(), (EmojiCategory)new FoodsCategory(), (EmojiCategory)new ActivityCategory(), (EmojiCategory)new PlacesCategory(), (EmojiCategory)new ObjectsCategory(), (EmojiCategory)new SymbolsCategory(), (EmojiCategory)new FlagsCategory() };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\manager\IosEmojiProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */