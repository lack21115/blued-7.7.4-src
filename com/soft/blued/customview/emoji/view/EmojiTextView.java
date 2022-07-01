package com.soft.blued.customview.emoji.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import com.soft.blued.R;
import com.soft.blued.customview.emoji.manager.EmojiHandler;
import com.soft.blued.customview.emoji.manager.EmojiManager;
import skin.support.widget.SkinCompatTextView;

public class EmojiTextView extends SkinCompatTextView {
  private int a;
  
  private int b;
  
  private int c;
  
  private int d = 0;
  
  private int e = -1;
  
  private boolean f = false;
  
  public EmojiTextView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public EmojiTextView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EmojiTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet) {
    if (!isInEditMode())
      EmojiManager.a().b(); 
    this.c = (int)getTextSize();
    if (paramAttributeSet == null) {
      this.a = (int)(getTextSize() * 1.2F);
    } else {
      TypedArray typedArray = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.Emojicon);
      this.a = (int)typedArray.getDimension(1, getTextSize() * 1.2F);
      this.b = typedArray.getInt(0, 1);
      this.d = typedArray.getInteger(3, 0);
      this.e = typedArray.getInteger(2, -1);
      this.f = typedArray.getBoolean(4, this.f);
      typedArray.recycle();
    } 
    setText(getText());
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType) {
    CharSequence charSequence = paramCharSequence;
    if (paramCharSequence == null)
      charSequence = ""; 
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
    EmojiHandler.a().a(getContext(), (Spannable)spannableStringBuilder, this.a, this.b, this.c, this.f);
    super.setText((CharSequence)spannableStringBuilder, paramBufferType);
  }
  
  public void setUseSystemDefault(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public void setmEmojiSize(int paramInt) {
    this.a = paramInt;
    setText(getText());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\view\EmojiTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */