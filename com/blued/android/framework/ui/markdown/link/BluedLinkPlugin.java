package com.blued.android.framework.ui.markdown.link;

import android.text.TextUtils;
import android.view.View;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.LinkResolver;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.MarkwonTheme;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

public class BluedLinkPlugin extends AbstractMarkwonPlugin {
  private static final Pattern a = Pattern.compile("((http[s]{0,1}|blued)://|www\\.)[A-Za-z0-9\\.\\?\\-_~!@#$%^&/:=]+[A-Za-z0-9/#]");
  
  private OnClickLinkListener b;
  
  private int c;
  
  private void a(MarkwonVisitor paramMarkwonVisitor, String paramString, int paramInt) {
    Matcher matcher = a.matcher(paramString);
    while (matcher.find()) {
      String str = matcher.group();
      int i = matcher.start() + paramInt;
      a(paramMarkwonVisitor, str, i, str.length() + i);
    } 
  }
  
  private void a(MarkwonVisitor paramMarkwonVisitor, String paramString, int paramInt1, int paramInt2) {
    MarkwonConfiguration markwonConfiguration = paramMarkwonVisitor.a();
    RenderProps renderProps = paramMarkwonVisitor.b();
    CoreProps.e.b(renderProps, paramString);
    SpannableBuilder.a(paramMarkwonVisitor.c(), markwonConfiguration.g().b(Link.class).a(markwonConfiguration, renderProps), paramInt1, paramInt2);
  }
  
  public void a(int paramInt) {
    this.c = paramInt;
  }
  
  public void a(OnClickLinkListener paramOnClickLinkListener) {
    this.b = paramOnClickLinkListener;
  }
  
  public void a(MarkwonConfiguration.Builder paramBuilder) {
    paramBuilder.a(new LinkResolver(this) {
          public void a(View param1View, String param1String) {
            if (!TextUtils.isEmpty(param1String) && BluedLinkPlugin.a(this.a) != null)
              BluedLinkPlugin.a(this.a).a(param1String); 
          }
        });
  }
  
  public void a(MarkwonVisitor.Builder paramBuilder) {
    paramBuilder.a(Text.class, new MarkwonVisitor.NodeVisitor<Text>(this) {
          public void a(MarkwonVisitor param1MarkwonVisitor, Text param1Text) {
            String str = param1Text.a();
            param1MarkwonVisitor.c().a(str);
            int i = param1MarkwonVisitor.f();
            int j = str.length();
            BluedLinkPlugin.a(this.a, param1MarkwonVisitor, str, i - j);
          }
        });
  }
  
  public void a(MarkwonTheme.Builder paramBuilder) {
    paramBuilder.a(this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\markdown\link\BluedLinkPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */