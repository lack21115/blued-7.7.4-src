package com.blued.android.framework.ui.markdown.atuser;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;

public class AtUserPlugin extends AbstractMarkwonPlugin {
  private StyleSpan a = new StyleSpan(1);
  
  private OnClickAtUserListener b;
  
  private int c;
  
  public void a(int paramInt) {
    this.c = paramInt;
  }
  
  public void a(OnClickAtUserListener paramOnClickAtUserListener) {
    this.b = paramOnClickAtUserListener;
  }
  
  public void a(MarkwonVisitor.Builder paramBuilder) {
    paramBuilder.a(AtUserNode.class, new MarkwonVisitor.NodeVisitor<AtUserNode>(this) {
          public void a(MarkwonVisitor param1MarkwonVisitor, AtUserNode param1AtUserNode) {
            String str1 = param1AtUserNode.a();
            String str2 = param1AtUserNode.u_();
            if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("@");
              stringBuilder.append(param1AtUserNode.a());
              String str = stringBuilder.toString();
              int i = param1MarkwonVisitor.f();
              int j = str.length();
              param1MarkwonVisitor.c().a(str);
              param1MarkwonVisitor.c().a(new ClickableSpan(this, str1, str2) {
                    public void onClick(View param2View) {
                      if (AtUserPlugin.a(this.c.a) != null)
                        AtUserPlugin.a(this.c.a).a(this.a, this.b); 
                    }
                    
                    public void updateDrawState(TextPaint param2TextPaint) {
                      param2TextPaint.setColor(AtUserPlugin.b(this.c.a));
                      param2TextPaint.setAlpha(255);
                      param2TextPaint.setUnderlineText(false);
                      param2TextPaint.clearShadowLayer();
                      param2TextPaint.setTypeface(Typeface.DEFAULT_BOLD);
                    }
                  }i, j + i, 33);
              param1MarkwonVisitor.c().a(' ');
            } 
          }
        });
  }
  
  public void a(Parser.Builder paramBuilder) {
    paramBuilder.a(new AtUserProcessor());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\markdown\atuser\AtUserPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */