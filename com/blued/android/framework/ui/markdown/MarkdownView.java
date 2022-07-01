package com.blued.android.framework.ui.markdown;

import android.content.Context;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.markdown.atuser.AtUserPlugin;
import com.blued.android.framework.ui.markdown.atuser.AtUserProcessor;
import com.blued.android.framework.ui.markdown.atuser.OnClickAtUserListener;
import com.blued.android.framework.ui.markdown.image.MarkdownGlideImagesPlugin;
import com.blued.android.framework.ui.markdown.image.OnClickImageListener;
import com.blued.android.framework.ui.markdown.link.BluedLinkPlugin;
import com.blued.android.framework.ui.markdown.link.OnClickLinkListener;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.Markwon;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.inlineparser.BangInlineProcessor;
import io.noties.markwon.inlineparser.CloseBracketInlineProcessor;
import io.noties.markwon.inlineparser.InlineProcessor;
import io.noties.markwon.inlineparser.MarkwonInlineParser;
import io.noties.markwon.inlineparser.OpenBracketInlineProcessor;
import java.util.Collections;
import java.util.regex.Pattern;
import org.commonmark.parser.InlineParserFactory;
import org.commonmark.parser.Parser;

public class MarkdownView extends AppCompatTextView {
  private static final Pattern b = Pattern.compile("\n *\n");
  
  private static final Pattern c = Pattern.compile("([^ \n]) *(\\!\\[[^\\]]*\\]\\([^\\)]*)");
  
  public OnShowTextListener a;
  
  private Builder d;
  
  private Markwon e;
  
  private int f = 0;
  
  private int g = 0;
  
  private int h = 0;
  
  public MarkdownView(Context paramContext) {
    super(paramContext);
  }
  
  public MarkdownView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public MarkdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a() {
    if (this.e == null) {
      MarkdownGlideImagesPlugin markdownGlideImagesPlugin = new MarkdownGlideImagesPlugin(this.d.a, this.h);
      markdownGlideImagesPlugin.a(this.d.d);
      markdownGlideImagesPlugin.b(this.d.c);
      markdownGlideImagesPlugin.c(this.d.b);
      markdownGlideImagesPlugin.d(this.d.e);
      markdownGlideImagesPlugin.a(this.d.k);
      markdownGlideImagesPlugin.b(this.d.h);
      AtUserPlugin atUserPlugin = new AtUserPlugin();
      atUserPlugin.a(this.d.i);
      atUserPlugin.a(this.d.f);
      BluedLinkPlugin bluedLinkPlugin = new BluedLinkPlugin();
      bluedLinkPlugin.a(this.d.j);
      bluedLinkPlugin.a(this.d.g);
      InlineParserFactory inlineParserFactory = MarkwonInlineParser.a().a((InlineProcessor)new OpenBracketInlineProcessor()).a((InlineProcessor)new CloseBracketInlineProcessor()).a((InlineProcessor)new BangInlineProcessor()).a();
      this.e = Markwon.a(getContext()).a((MarkwonPlugin)markdownGlideImagesPlugin).a((MarkwonPlugin)atUserPlugin).a((MarkwonPlugin)bluedLinkPlugin).a((MarkwonPlugin)new AbstractMarkwonPlugin(this, inlineParserFactory) {
            public void a(Parser.Builder param1Builder) {
              param1Builder.a(Collections.emptySet());
              param1Builder.a(this.a);
            }
          }).a();
    } 
    this.g = this.f;
  }
  
  private void a(String paramString) {
    Spanned spanned;
    a();
    paramString = b(paramString);
    OnShowTextListener onShowTextListener = this.a;
    if (onShowTextListener != null) {
      spanned = onShowTextListener.a((CharSequence)this.e.a(paramString));
      this.e.a((TextView)this, spanned);
      return;
    } 
    this.e.a((TextView)this, (String)spanned);
  }
  
  private String b(String paramString) {
    paramString = b.matcher(paramString).replaceAll("\n　\n");
    paramString = c.matcher(paramString).replaceAll("$1\n$2");
    return AtUserProcessor.a.matcher(paramString).replaceAll(" $0");
  }
  
  public void a(Builder paramBuilder, String paramString) {
    Builder builder = paramBuilder;
    if (paramBuilder == null)
      builder = new Builder(); 
    this.d = builder;
    if (!TextUtils.isEmpty(paramString)) {
      if (this.h > 0) {
        a(paramString);
        return;
      } 
      getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, paramString) {
            public void onGlobalLayout() {
              this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
              MarkdownView markdownView = this.b;
              MarkdownView.a(markdownView, markdownView.getWidth() - this.b.getPaddingLeft() - this.b.getPaddingRight());
              MarkdownView.a(this.b, this.a);
            }
          });
    } 
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (AppInfo.m())
      Log.v("Markdown", "onAttachedToWindow "); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    if (AppInfo.m()) {
      Log.v("Markdown", "onDetachedFromWindow ");
      Markwon markwon = this.e;
      if (markwon != null) {
        MarkdownGlideImagesPlugin markdownGlideImagesPlugin = (MarkdownGlideImagesPlugin)markwon.a(MarkdownGlideImagesPlugin.class);
        if (markdownGlideImagesPlugin != null)
          markdownGlideImagesPlugin.a(); 
      } 
    } 
  }
  
  public void setOnShowTextListener(OnShowTextListener paramOnShowTextListener) {
    this.a = paramOnShowTextListener;
  }
  
  public static final class Builder {
    IRequestHost a;
    
    int b = 6;
    
    int c;
    
    int d;
    
    int e = 5;
    
    int f = -14718229;
    
    int g = -14718229;
    
    String h = "";
    
    OnClickAtUserListener i;
    
    OnClickLinkListener j;
    
    OnClickImageListener k;
    
    public Builder a(int param1Int) {
      this.d = param1Int;
      return this;
    }
    
    public Builder a(IRequestHost param1IRequestHost) {
      this.a = param1IRequestHost;
      return this;
    }
    
    public Builder a(OnClickAtUserListener param1OnClickAtUserListener) {
      this.i = param1OnClickAtUserListener;
      return this;
    }
    
    public Builder a(OnClickImageListener param1OnClickImageListener) {
      this.k = param1OnClickImageListener;
      return this;
    }
    
    public Builder a(OnClickLinkListener param1OnClickLinkListener) {
      this.j = param1OnClickLinkListener;
      return this;
    }
    
    public Builder a(String param1String) {
      this.h = param1String;
      return this;
    }
    
    public Builder b(int param1Int) {
      this.e = param1Int;
      return this;
    }
  }
  
  public static interface OnShowTextListener {
    Spanned a(CharSequence param1CharSequence);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\markdown\MarkdownView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */