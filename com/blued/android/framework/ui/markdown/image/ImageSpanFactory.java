package com.blued.android.framework.ui.markdown.image;

import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.image.ImageProps;
import io.noties.markwon.image.ImageSize;

public class ImageSpanFactory implements SpanFactory {
  public Object a(MarkwonConfiguration paramMarkwonConfiguration, RenderProps paramRenderProps) {
    return new AsyncDrawableSpan(paramMarkwonConfiguration.a(), new AsyncDrawable((String)ImageProps.a.b(paramRenderProps), paramMarkwonConfiguration.b(), paramMarkwonConfiguration.f(), (ImageSize)ImageProps.c.a(paramRenderProps)), 2, ((Boolean)ImageProps.b.a(paramRenderProps, Boolean.valueOf(false))).booleanValue());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\markdown\image\ImageSpanFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */