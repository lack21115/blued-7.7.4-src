package com.soft.blued.customview.emoji.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spannable;
import android.util.AttributeSet;
import com.soft.blued.R;
import com.soft.blued.customview.SelectionEditText;
import com.soft.blued.customview.emoji.manager.EmojiHandler;
import com.soft.blued.customview.emoji.manager.EmojiManager;

public class EmojiEditText extends SelectionEditText {
  private int a;
  
  private int b;
  
  private int c;
  
  private boolean d = false;
  
  public EmojiEditText(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public EmojiEditText(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmojiEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 > 0)
      return; 
    EmojiHandler.a().a(getContext(), (Spannable)getText(), paramInt1, paramInt3, this.a, this.b, this.c, this.d);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    if (!isInEditMode())
      EmojiManager.a().b(); 
    TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.Emojicon);
    this.a = (int)typedArray.getDimension(1, getTextSize() * 1.2F);
    this.b = typedArray.getInt(0, 1);
    this.d = typedArray.getBoolean(4, false);
    typedArray.recycle();
    this.c = (int)getTextSize();
    setText((CharSequence)getText());
  }
  
  public void g() {}
  
  public void onSelectionChanged(int paramInt1, int paramInt2) {
    super.onSelectionChanged(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {
    a(paramInt1, paramInt2, paramInt3);
  }
  
  public void setEmojiSize(int paramInt) {
    this.a = paramInt;
    a(0, 0, getText().length());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\view\EmojiEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */