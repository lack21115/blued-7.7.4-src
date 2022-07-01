package com.blued.android.framework.ui.markdown.image;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.UiUtils;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonConfiguration;
import io.noties.markwon.MarkwonSpansFactory;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.RenderProps;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.AsyncDrawableScheduler;
import io.noties.markwon.image.ImageProps;
import io.noties.markwon.image.ImageSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.Image;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

public class MarkdownGlideImagesPlugin extends AbstractMarkwonPlugin {
  private static final Pattern b = Pattern.compile("^[\\s\\S]*\\D+(\\d+)x(\\d+)\\s*$");
  
  private static final Pattern c = Pattern.compile("^\\s*(\\d+)x(\\d+)\\s*$");
  
  List<DrawableTargetModel> a = new ArrayList<DrawableTargetModel>();
  
  private HashMap<ClickableSpan, Integer> d;
  
  private ArrayList<String> e;
  
  private GlideAsyncDrawableLoader f;
  
  private IRequestHost g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private String m;
  
  private OnClickImageListener n;
  
  private int o = 0;
  
  public MarkdownGlideImagesPlugin(IRequestHost paramIRequestHost, int paramInt) {
    this.g = paramIRequestHost;
    this.h = paramInt;
    this.f = new GlideAsyncDrawableLoader();
    this.d = new HashMap<ClickableSpan, Integer>();
    this.e = new ArrayList<String>();
  }
  
  private ImageSize a(Pattern paramPattern, String paramString) {
    Matcher matcher = paramPattern.matcher(paramString);
    if (AppInfo.m()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("configureImageVistor -- ");
      stringBuilder.append(paramPattern);
      stringBuilder.append(", ");
      stringBuilder.append(matcher.matches());
      Log.i("Markdown", stringBuilder.toString());
    } 
    if (matcher.matches()) {
      int i;
      if (AppInfo.m()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("configureImageVistor:");
        stringBuilder.append(matcher.group());
        stringBuilder.append(", [");
        stringBuilder.append(matcher.group(1));
        stringBuilder.append("x");
        stringBuilder.append(matcher.group(2));
        stringBuilder.append("]");
        Log.e("Markdown", stringBuilder.toString());
      } 
      String str1 = matcher.group(1);
      String str2 = matcher.group(2);
      boolean bool = TextUtils.isEmpty(str1);
      int j = 0;
      if (!bool) {
        i = Integer.parseInt(str1);
      } else {
        i = 0;
      } 
      if (!TextUtils.isEmpty(str2))
        j = Integer.parseInt(str2); 
      if (i && j > 0) {
        int k = this.h;
        i = j * k / i;
        return new ImageSize(new ImageSize.Dimension(k, "px"), new ImageSize.Dimension(i, "px"));
      } 
    } 
    return null;
  }
  
  private ImageSize a(Image paramImage) {
    ImageSize imageSize3 = null;
    ImageSize imageSize2 = null;
    ImageSize imageSize1 = imageSize3;
    try {
      Node node = paramImage.j();
      ImageSize imageSize = imageSize2;
      if (node != null) {
        imageSize = imageSize2;
        imageSize1 = imageSize3;
        if (node instanceof Text) {
          imageSize1 = imageSize3;
          Text text = (Text)paramImage.j();
          imageSize = imageSize2;
          if (text != null) {
            imageSize1 = imageSize3;
            String str = text.a();
            imageSize = imageSize2;
            imageSize1 = imageSize3;
            if (!TextUtils.isEmpty(str)) {
              imageSize1 = imageSize3;
              ImageSize imageSize4 = a(b, str);
              imageSize = imageSize4;
              if (imageSize4 == null) {
                imageSize1 = imageSize4;
                imageSize = a(c, str);
              } 
            } 
          } 
        } 
      } 
      return imageSize;
    } catch (Exception exception) {
      return imageSize1;
    } 
  }
  
  private void a(MarkwonVisitor paramMarkwonVisitor, Image paramImage) {
    SpanFactory spanFactory = paramMarkwonVisitor.a().g().a(Image.class);
    if (spanFactory == null) {
      paramMarkwonVisitor.a((Node)paramImage);
      return;
    } 
    int i = paramMarkwonVisitor.f();
    paramMarkwonVisitor.a((Node)paramImage);
    if (i == paramMarkwonVisitor.f())
      paramMarkwonVisitor.c().a('￼'); 
    MarkwonConfiguration markwonConfiguration = paramMarkwonVisitor.a();
    boolean bool = paramImage.b() instanceof org.commonmark.node.Link;
    ImageSize imageSize = a(paramImage);
    String str = markwonConfiguration.e().a(paramImage.a());
    RenderProps renderProps = paramMarkwonVisitor.b();
    ImageProps.a.b(renderProps, str);
    ImageProps.b.b(renderProps, Boolean.valueOf(bool));
    ImageProps.c.b(renderProps, imageSize);
    paramMarkwonVisitor.a(i, spanFactory.a(markwonConfiguration, renderProps));
    ClickableSpan clickableSpan = new ClickableSpan(this) {
        public void onClick(View param1View) {
          if (MarkdownGlideImagesPlugin.b(this.a) != null && MarkdownGlideImagesPlugin.c(this.a) != null && MarkdownGlideImagesPlugin.d(this.a) != null)
            MarkdownGlideImagesPlugin.b(this.a).a((String[])MarkdownGlideImagesPlugin.c(this.a).toArray((Object[])new String[MarkdownGlideImagesPlugin.c(this.a).size()]), ((Integer)MarkdownGlideImagesPlugin.d(this.a).get(this)).intValue()); 
        }
      };
    this.e.add(str);
    this.o = this.e.size();
    if (AppInfo.m()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("configureImageVistor: ");
      stringBuilder.append(str);
      stringBuilder.append(", mImageArraySize: ");
      stringBuilder.append(this.o);
      Log.i("Markdown", stringBuilder.toString());
    } 
    this.d.put(clickableSpan, Integer.valueOf(this.e.size() - 1));
    paramMarkwonVisitor.c().a(clickableSpan, i);
  }
  
  private static int f(int paramInt) {
    int i = paramInt;
    if (AppInfo.d() != null)
      i = UiUtils.a(AppInfo.d(), paramInt); 
    return i;
  }
  
  public String a(String paramString) {
    this.d = new HashMap<ClickableSpan, Integer>();
    this.e = new ArrayList<String>();
    this.a.clear();
    return paramString;
  }
  
  public void a() {
    List<DrawableTargetModel> list = this.a;
    if (list != null) {
      if (list.size() == 0)
        return; 
      for (int i = 0; i < this.a.size(); i++) {
        if (((DrawableTargetModel)this.a.get(i)).b != null)
          ImageLoader.a(this.g, (Target)((DrawableTargetModel)this.a.get(i)).b); 
        if (((DrawableTargetModel)this.a.get(i)).a != null)
          ((DrawableTargetModel)this.a.get(i)).a.h(); 
      } 
    } 
  }
  
  public void a(int paramInt) {
    this.j = paramInt;
  }
  
  public void a(TextView paramTextView) {
    AsyncDrawableScheduler.a(paramTextView);
  }
  
  public void a(TextView paramTextView, Spanned paramSpanned) {
    AsyncDrawableScheduler.b(paramTextView);
  }
  
  public void a(OnClickImageListener paramOnClickImageListener) {
    this.n = paramOnClickImageListener;
  }
  
  public void a(MarkwonConfiguration.Builder paramBuilder) {
    paramBuilder.a(this.f);
  }
  
  public void a(MarkwonSpansFactory.Builder paramBuilder) {
    paramBuilder.a(Image.class, new ImageSpanFactory());
    paramBuilder.b(Image.class, new SpanFactory(this) {
          public Object a(MarkwonConfiguration param1MarkwonConfiguration, RenderProps param1RenderProps) {
            return new ImageLineSpacingSpan(MarkdownGlideImagesPlugin.e(MarkdownGlideImagesPlugin.a(this.a)));
          }
        });
  }
  
  public void a(MarkwonVisitor.Builder paramBuilder) {
    paramBuilder.a(Image.class, new MarkwonVisitor.NodeVisitor<Image>(this) {
          public void a(MarkwonVisitor param1MarkwonVisitor, Image param1Image) {
            MarkdownGlideImagesPlugin.a(this.a, param1MarkwonVisitor, param1Image);
          }
        });
  }
  
  public void b(int paramInt) {
    this.k = paramInt;
  }
  
  public void b(String paramString) {
    this.m = paramString;
    if (this.m == null)
      this.m = ""; 
  }
  
  public void c(int paramInt) {
    this.i = paramInt;
  }
  
  public void d(int paramInt) {
    this.l = paramInt;
  }
  
  class DrawableTargetModel {
    public AsyncDrawable a;
    
    public MarkdownGlideImagesPlugin.GlideAsyncDrawableLoader.AsyncDrawableTarget b;
    
    DrawableTargetModel(MarkdownGlideImagesPlugin this$0, AsyncDrawable param1AsyncDrawable) {
      this.a = param1AsyncDrawable;
    }
  }
  
  class GlideAsyncDrawableLoader extends AsyncDrawableLoader {
    private GlideAsyncDrawableLoader(MarkdownGlideImagesPlugin this$0) {}
    
    private void b() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   4: invokestatic f : (Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;)Lcom/blued/android/core/net/IRequestHost;
      //   7: ifnull -> 26
      //   10: aload_0
      //   11: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   14: invokestatic f : (Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;)Lcom/blued/android/core/net/IRequestHost;
      //   17: invokeinterface isActive : ()Z
      //   22: ifne -> 26
      //   25: return
      //   26: aload_0
      //   27: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   30: getfield a : Ljava/util/List;
      //   33: astore_2
      //   34: aload_2
      //   35: monitorenter
      //   36: iconst_0
      //   37: istore_1
      //   38: iload_1
      //   39: aload_0
      //   40: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   43: getfield a : Ljava/util/List;
      //   46: invokeinterface size : ()I
      //   51: if_icmpge -> 331
      //   54: aload_0
      //   55: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   58: getfield a : Ljava/util/List;
      //   61: iload_1
      //   62: invokeinterface get : (I)Ljava/lang/Object;
      //   67: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
      //   70: getfield a : Lio/noties/markwon/image/AsyncDrawable;
      //   73: ifnull -> 339
      //   76: aload_0
      //   77: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   80: getfield a : Ljava/util/List;
      //   83: iload_1
      //   84: invokeinterface get : (I)Ljava/lang/Object;
      //   89: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
      //   92: getfield b : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader$AsyncDrawableTarget;
      //   95: ifnonnull -> 339
      //   98: aload_0
      //   99: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   102: getfield a : Ljava/util/List;
      //   105: iload_1
      //   106: invokeinterface get : (I)Ljava/lang/Object;
      //   111: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
      //   114: new com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader$AsyncDrawableTarget
      //   117: dup
      //   118: aload_0
      //   119: aload_0
      //   120: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   123: getfield a : Ljava/util/List;
      //   126: iload_1
      //   127: invokeinterface get : (I)Ljava/lang/Object;
      //   132: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
      //   135: getfield a : Lio/noties/markwon/image/AsyncDrawable;
      //   138: invokespecial <init> : (Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;Lio/noties/markwon/image/AsyncDrawable;)V
      //   141: putfield b : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader$AsyncDrawableTarget;
      //   144: new java/lang/StringBuilder
      //   147: dup
      //   148: invokespecial <init> : ()V
      //   151: astore_3
      //   152: aload_3
      //   153: aload_0
      //   154: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   157: getfield a : Ljava/util/List;
      //   160: iload_1
      //   161: invokeinterface get : (I)Ljava/lang/Object;
      //   166: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
      //   169: getfield a : Lio/noties/markwon/image/AsyncDrawable;
      //   172: invokevirtual a : ()Ljava/lang/String;
      //   175: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   178: pop
      //   179: aload_3
      //   180: aload_0
      //   181: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   184: invokestatic g : (Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;)Ljava/lang/String;
      //   187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   190: pop
      //   191: aload_3
      //   192: invokevirtual toString : ()Ljava/lang/String;
      //   195: astore_3
      //   196: aload_0
      //   197: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   200: invokestatic f : (Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;)Lcom/blued/android/core/net/IRequestHost;
      //   203: ifnull -> 224
      //   206: aload_0
      //   207: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   210: invokestatic f : (Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;)Lcom/blued/android/core/net/IRequestHost;
      //   213: invokeinterface isActive : ()Z
      //   218: ifne -> 224
      //   221: aload_2
      //   222: monitorexit
      //   223: return
      //   224: invokestatic m : ()Z
      //   227: ifeq -> 265
      //   230: new java/lang/StringBuilder
      //   233: dup
      //   234: invokespecial <init> : ()V
      //   237: astore #4
      //   239: aload #4
      //   241: ldc 'ImageLoader.load '
      //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   246: pop
      //   247: aload #4
      //   249: aload_3
      //   250: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   253: pop
      //   254: ldc 'Markdown'
      //   256: aload #4
      //   258: invokevirtual toString : ()Ljava/lang/String;
      //   261: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   264: pop
      //   265: aload_0
      //   266: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   269: invokestatic f : (Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;)Lcom/blued/android/core/net/IRequestHost;
      //   272: aload_3
      //   273: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
      //   276: aload_0
      //   277: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   280: invokestatic h : (Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;)I
      //   283: i2f
      //   284: invokevirtual a : (F)Lcom/blued/android/core/image/ImageWrapper;
      //   287: new com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader$1
      //   290: dup
      //   291: aload_0
      //   292: aload_0
      //   293: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   296: invokestatic f : (Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;)Lcom/blued/android/core/net/IRequestHost;
      //   299: aload_3
      //   300: invokespecial <init> : (Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)V
      //   303: invokevirtual a : (Lcom/blued/android/core/image/ImageLoadResult;)Lcom/blued/android/core/image/ImageWrapper;
      //   306: aload_0
      //   307: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   310: getfield a : Ljava/util/List;
      //   313: iload_1
      //   314: invokeinterface get : (I)Ljava/lang/Object;
      //   319: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
      //   322: getfield b : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader$AsyncDrawableTarget;
      //   325: invokevirtual a : (Lcom/bumptech/glide/request/target/Target;)V
      //   328: goto -> 331
      //   331: aload_2
      //   332: monitorexit
      //   333: return
      //   334: astore_3
      //   335: aload_2
      //   336: monitorexit
      //   337: aload_3
      //   338: athrow
      //   339: iload_1
      //   340: iconst_1
      //   341: iadd
      //   342: istore_1
      //   343: goto -> 38
      // Exception table:
      //   from	to	target	type
      //   38	223	334	finally
      //   224	265	334	finally
      //   265	328	334	finally
      //   331	333	334	finally
      //   335	337	334	finally
    }
    
    public void a(AsyncDrawable param1AsyncDrawable) {
      if (param1AsyncDrawable != null)
        synchronized (this.a.a) {
          this.a.a.add(0, new MarkdownGlideImagesPlugin.DrawableTargetModel(this.a, param1AsyncDrawable));
          int i = this.a.a.size();
          if (AppInfo.m()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GlideAsyncDrawableLoader.load ");
            stringBuilder.append(param1AsyncDrawable.a());
            stringBuilder.append(",  listSize:");
            stringBuilder.append(i);
            stringBuilder.append(", imageArraySize:");
            stringBuilder.append(MarkdownGlideImagesPlugin.e(this.a));
            Log.i("Markdown", stringBuilder.toString());
          } 
          if (i == MarkdownGlideImagesPlugin.e(this.a))
            b(); 
          return;
        }  
    }
    
    public void b(AsyncDrawable param1AsyncDrawable) {
      // Byte code:
      //   0: invokestatic m : ()Z
      //   3: ifeq -> 40
      //   6: new java/lang/StringBuilder
      //   9: dup
      //   10: invokespecial <init> : ()V
      //   13: astore_3
      //   14: aload_3
      //   15: ldc 'cancel drawable='
      //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   20: pop
      //   21: aload_3
      //   22: aload_1
      //   23: invokevirtual a : ()Ljava/lang/String;
      //   26: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   29: pop
      //   30: ldc 'Markdown'
      //   32: aload_3
      //   33: invokevirtual toString : ()Ljava/lang/String;
      //   36: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   39: pop
      //   40: aload_0
      //   41: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   44: getfield a : Ljava/util/List;
      //   47: astore_3
      //   48: aload_3
      //   49: monitorenter
      //   50: iconst_0
      //   51: istore_2
      //   52: iload_2
      //   53: aload_0
      //   54: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   57: getfield a : Ljava/util/List;
      //   60: invokeinterface size : ()I
      //   65: if_icmpge -> 173
      //   68: aload_0
      //   69: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   72: getfield a : Ljava/util/List;
      //   75: iload_2
      //   76: invokeinterface get : (I)Ljava/lang/Object;
      //   81: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
      //   84: getfield a : Lio/noties/markwon/image/AsyncDrawable;
      //   87: aload_1
      //   88: if_acmpne -> 181
      //   91: aload_0
      //   92: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   95: getfield a : Ljava/util/List;
      //   98: iload_2
      //   99: invokeinterface get : (I)Ljava/lang/Object;
      //   104: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
      //   107: getfield b : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader$AsyncDrawableTarget;
      //   110: astore #4
      //   112: aload #4
      //   114: ifnull -> 173
      //   117: invokestatic m : ()Z
      //   120: ifeq -> 158
      //   123: new java/lang/StringBuilder
      //   126: dup
      //   127: invokespecial <init> : ()V
      //   130: astore #5
      //   132: aload #5
      //   134: ldc 'cancel target='
      //   136: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   139: pop
      //   140: aload #5
      //   142: aload_1
      //   143: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   146: pop
      //   147: ldc 'Markdown'
      //   149: aload #5
      //   151: invokevirtual toString : ()Ljava/lang/String;
      //   154: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   157: pop
      //   158: aload_0
      //   159: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   162: invokestatic f : (Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;)Lcom/blued/android/core/net/IRequestHost;
      //   165: aload #4
      //   167: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Lcom/bumptech/glide/request/target/Target;)V
      //   170: goto -> 173
      //   173: aload_3
      //   174: monitorexit
      //   175: return
      //   176: astore_1
      //   177: aload_3
      //   178: monitorexit
      //   179: aload_1
      //   180: athrow
      //   181: iload_2
      //   182: iconst_1
      //   183: iadd
      //   184: istore_2
      //   185: goto -> 52
      // Exception table:
      //   from	to	target	type
      //   52	112	176	finally
      //   117	158	176	finally
      //   158	170	176	finally
      //   173	175	176	finally
      //   177	179	176	finally
    }
    
    public Drawable c(AsyncDrawable param1AsyncDrawable) {
      GradientDrawable gradientDrawable;
      if (AppInfo.m()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("placeholder() >>");
        stringBuilder.append(param1AsyncDrawable.a());
        Log.v("Markdown", stringBuilder.toString());
      } 
      Resources resources = null;
      Drawable drawable = null;
      if (AppInfo.d() != null) {
        GradientDrawable gradientDrawable1;
        if (MarkdownGlideImagesPlugin.i(this.a) != 0) {
          Drawable drawable1 = drawable;
          if (AppInfo.d() != null) {
            resources = AppInfo.d().getResources();
            drawable1 = drawable;
            if (resources != null)
              drawable1 = resources.getDrawable(MarkdownGlideImagesPlugin.i(this.a)); 
          } 
        } else {
          Drawable drawable1 = drawable;
          if (MarkdownGlideImagesPlugin.j(this.a) != 0) {
            gradientDrawable1 = new GradientDrawable();
            gradientDrawable1.setCornerRadius(MarkdownGlideImagesPlugin.e(MarkdownGlideImagesPlugin.h(this.a)));
            gradientDrawable1.setColor(MarkdownGlideImagesPlugin.j(this.a));
          } 
        } 
        gradientDrawable = gradientDrawable1;
        if (gradientDrawable1 != null) {
          Rect rect;
          ImageSize imageSize = param1AsyncDrawable.b();
          if (imageSize == null) {
            rect = new Rect(0, 0, MarkdownGlideImagesPlugin.k(this.a), MarkdownGlideImagesPlugin.k(this.a));
          } else {
            rect = new Rect(0, 0, (int)((ImageSize)rect).a.a, (int)((ImageSize)rect).b.a);
          } 
          gradientDrawable1.setBounds(rect);
          gradientDrawable = gradientDrawable1;
        } 
      } 
      if (AppInfo.m()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<< placeholder() ");
        stringBuilder.append(param1AsyncDrawable.a());
        Log.v("Markdown", stringBuilder.toString());
      } 
      return (Drawable)gradientDrawable;
    }
    
    class AsyncDrawableTarget extends CustomTarget<Drawable> {
      private final AsyncDrawable b;
      
      AsyncDrawableTarget(MarkdownGlideImagesPlugin.GlideAsyncDrawableLoader this$0, AsyncDrawable param2AsyncDrawable) {
        this.b = param2AsyncDrawable;
      }
      
      public void a(Drawable param2Drawable) {
        if (AppInfo.m()) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("onLoadStarted: ");
          stringBuilder.append(this.b.a());
          Log.i("Markdown", stringBuilder.toString());
        } 
        if (param2Drawable != null)
          this.b.g(); 
      }
      
      public void a(Drawable param2Drawable, Transition<? super Drawable> param2Transition) {
        // Byte code:
        //   0: aload_0
        //   1: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
        //   4: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
        //   7: getfield a : Ljava/util/List;
        //   10: astore_2
        //   11: aload_2
        //   12: monitorenter
        //   13: iconst_0
        //   14: istore_3
        //   15: iload_3
        //   16: aload_0
        //   17: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
        //   20: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
        //   23: getfield a : Ljava/util/List;
        //   26: invokeinterface size : ()I
        //   31: if_icmpge -> 135
        //   34: aload_0
        //   35: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
        //   38: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
        //   41: getfield a : Ljava/util/List;
        //   44: iload_3
        //   45: invokeinterface get : (I)Ljava/lang/Object;
        //   50: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
        //   53: getfield a : Lio/noties/markwon/image/AsyncDrawable;
        //   56: aload_0
        //   57: getfield b : Lio/noties/markwon/image/AsyncDrawable;
        //   60: if_acmpne -> 143
        //   63: aload_0
        //   64: getfield b : Lio/noties/markwon/image/AsyncDrawable;
        //   67: invokevirtual g : ()Z
        //   70: ifeq -> 135
        //   73: aload_1
        //   74: invokestatic b : (Landroid/graphics/drawable/Drawable;)V
        //   77: invokestatic m : ()Z
        //   80: ifeq -> 124
        //   83: new java/lang/StringBuilder
        //   86: dup
        //   87: invokespecial <init> : ()V
        //   90: astore #4
        //   92: aload #4
        //   94: ldc 'onResourceReady: ['
        //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   99: pop
        //   100: aload #4
        //   102: aload_0
        //   103: getfield b : Lio/noties/markwon/image/AsyncDrawable;
        //   106: invokevirtual a : ()Ljava/lang/String;
        //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   112: pop
        //   113: ldc 'Markdown'
        //   115: aload #4
        //   117: invokevirtual toString : ()Ljava/lang/String;
        //   120: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
        //   123: pop
        //   124: aload_0
        //   125: getfield b : Lio/noties/markwon/image/AsyncDrawable;
        //   128: aload_1
        //   129: invokevirtual b : (Landroid/graphics/drawable/Drawable;)V
        //   132: goto -> 135
        //   135: aload_2
        //   136: monitorexit
        //   137: return
        //   138: astore_1
        //   139: aload_2
        //   140: monitorexit
        //   141: aload_1
        //   142: athrow
        //   143: iload_3
        //   144: iconst_1
        //   145: iadd
        //   146: istore_3
        //   147: goto -> 15
        // Exception table:
        //   from	to	target	type
        //   15	124	138	finally
        //   124	132	138	finally
        //   135	137	138	finally
        //   139	141	138	finally
      }
      
      public void b(Drawable param2Drawable) {
        // Byte code:
        //   0: invokestatic m : ()Z
        //   3: ifeq -> 43
        //   6: new java/lang/StringBuilder
        //   9: dup
        //   10: invokespecial <init> : ()V
        //   13: astore_3
        //   14: aload_3
        //   15: ldc 'onLoadFailed: '
        //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   20: pop
        //   21: aload_3
        //   22: aload_0
        //   23: getfield b : Lio/noties/markwon/image/AsyncDrawable;
        //   26: invokevirtual a : ()Ljava/lang/String;
        //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   32: pop
        //   33: ldc 'Markdown'
        //   35: aload_3
        //   36: invokevirtual toString : ()Ljava/lang/String;
        //   39: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
        //   42: pop
        //   43: aload_0
        //   44: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
        //   47: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
        //   50: getfield a : Ljava/util/List;
        //   53: astore_3
        //   54: aload_3
        //   55: monitorenter
        //   56: iconst_0
        //   57: istore_2
        //   58: iload_2
        //   59: aload_0
        //   60: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
        //   63: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
        //   66: getfield a : Ljava/util/List;
        //   69: invokeinterface size : ()I
        //   74: if_icmpge -> 121
        //   77: aload_0
        //   78: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
        //   81: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
        //   84: getfield a : Ljava/util/List;
        //   87: iload_2
        //   88: invokeinterface get : (I)Ljava/lang/Object;
        //   93: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
        //   96: getfield a : Lio/noties/markwon/image/AsyncDrawable;
        //   99: aload_0
        //   100: getfield b : Lio/noties/markwon/image/AsyncDrawable;
        //   103: if_acmpne -> 129
        //   106: aload_1
        //   107: ifnull -> 121
        //   110: aload_0
        //   111: getfield b : Lio/noties/markwon/image/AsyncDrawable;
        //   114: invokevirtual g : ()Z
        //   117: pop
        //   118: goto -> 121
        //   121: aload_3
        //   122: monitorexit
        //   123: return
        //   124: astore_1
        //   125: aload_3
        //   126: monitorexit
        //   127: aload_1
        //   128: athrow
        //   129: iload_2
        //   130: iconst_1
        //   131: iadd
        //   132: istore_2
        //   133: goto -> 58
        // Exception table:
        //   from	to	target	type
        //   58	106	124	finally
        //   110	118	124	finally
        //   121	123	124	finally
        //   125	127	124	finally
      }
      
      public void c(Drawable param2Drawable) {
        if (this.b.g()) {
          if (AppInfo.m())
            Log.i("Markdown", "onLoadCleared"); 
          this.b.h();
        } 
      }
    }
  }
  
  class null extends ImageLoadResult {
    null(MarkdownGlideImagesPlugin this$0, IRequestHost param1IRequestHost, String param1String) {
      super(param1IRequestHost);
    }
    
    public void b() {
      super.b();
      if (AppInfo.m()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImageLoader.loadFinish ");
        stringBuilder.append(this.a);
        Log.i("Markdown", stringBuilder.toString());
      } 
      MarkdownGlideImagesPlugin.GlideAsyncDrawableLoader.a(this.b);
    }
  }
  
  class AsyncDrawableTarget extends CustomTarget<Drawable> {
    private final AsyncDrawable b;
    
    AsyncDrawableTarget(MarkdownGlideImagesPlugin this$0, AsyncDrawable param1AsyncDrawable) {
      this.b = param1AsyncDrawable;
    }
    
    public void a(Drawable param1Drawable) {
      if (AppInfo.m()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onLoadStarted: ");
        stringBuilder.append(this.b.a());
        Log.i("Markdown", stringBuilder.toString());
      } 
      if (param1Drawable != null)
        this.b.g(); 
    }
    
    public void a(Drawable param1Drawable, Transition<? super Drawable> param1Transition) {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
      //   4: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   7: getfield a : Ljava/util/List;
      //   10: astore_2
      //   11: aload_2
      //   12: monitorenter
      //   13: iconst_0
      //   14: istore_3
      //   15: iload_3
      //   16: aload_0
      //   17: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
      //   20: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   23: getfield a : Ljava/util/List;
      //   26: invokeinterface size : ()I
      //   31: if_icmpge -> 135
      //   34: aload_0
      //   35: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
      //   38: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   41: getfield a : Ljava/util/List;
      //   44: iload_3
      //   45: invokeinterface get : (I)Ljava/lang/Object;
      //   50: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
      //   53: getfield a : Lio/noties/markwon/image/AsyncDrawable;
      //   56: aload_0
      //   57: getfield b : Lio/noties/markwon/image/AsyncDrawable;
      //   60: if_acmpne -> 143
      //   63: aload_0
      //   64: getfield b : Lio/noties/markwon/image/AsyncDrawable;
      //   67: invokevirtual g : ()Z
      //   70: ifeq -> 135
      //   73: aload_1
      //   74: invokestatic b : (Landroid/graphics/drawable/Drawable;)V
      //   77: invokestatic m : ()Z
      //   80: ifeq -> 124
      //   83: new java/lang/StringBuilder
      //   86: dup
      //   87: invokespecial <init> : ()V
      //   90: astore #4
      //   92: aload #4
      //   94: ldc 'onResourceReady: ['
      //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   99: pop
      //   100: aload #4
      //   102: aload_0
      //   103: getfield b : Lio/noties/markwon/image/AsyncDrawable;
      //   106: invokevirtual a : ()Ljava/lang/String;
      //   109: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   112: pop
      //   113: ldc 'Markdown'
      //   115: aload #4
      //   117: invokevirtual toString : ()Ljava/lang/String;
      //   120: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   123: pop
      //   124: aload_0
      //   125: getfield b : Lio/noties/markwon/image/AsyncDrawable;
      //   128: aload_1
      //   129: invokevirtual b : (Landroid/graphics/drawable/Drawable;)V
      //   132: goto -> 135
      //   135: aload_2
      //   136: monitorexit
      //   137: return
      //   138: astore_1
      //   139: aload_2
      //   140: monitorexit
      //   141: aload_1
      //   142: athrow
      //   143: iload_3
      //   144: iconst_1
      //   145: iadd
      //   146: istore_3
      //   147: goto -> 15
      // Exception table:
      //   from	to	target	type
      //   15	124	138	finally
      //   124	132	138	finally
      //   135	137	138	finally
      //   139	141	138	finally
    }
    
    public void b(Drawable param1Drawable) {
      // Byte code:
      //   0: invokestatic m : ()Z
      //   3: ifeq -> 43
      //   6: new java/lang/StringBuilder
      //   9: dup
      //   10: invokespecial <init> : ()V
      //   13: astore_3
      //   14: aload_3
      //   15: ldc 'onLoadFailed: '
      //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   20: pop
      //   21: aload_3
      //   22: aload_0
      //   23: getfield b : Lio/noties/markwon/image/AsyncDrawable;
      //   26: invokevirtual a : ()Ljava/lang/String;
      //   29: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   32: pop
      //   33: ldc 'Markdown'
      //   35: aload_3
      //   36: invokevirtual toString : ()Ljava/lang/String;
      //   39: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
      //   42: pop
      //   43: aload_0
      //   44: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
      //   47: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   50: getfield a : Ljava/util/List;
      //   53: astore_3
      //   54: aload_3
      //   55: monitorenter
      //   56: iconst_0
      //   57: istore_2
      //   58: iload_2
      //   59: aload_0
      //   60: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
      //   63: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   66: getfield a : Ljava/util/List;
      //   69: invokeinterface size : ()I
      //   74: if_icmpge -> 121
      //   77: aload_0
      //   78: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$GlideAsyncDrawableLoader;
      //   81: getfield a : Lcom/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin;
      //   84: getfield a : Ljava/util/List;
      //   87: iload_2
      //   88: invokeinterface get : (I)Ljava/lang/Object;
      //   93: checkcast com/blued/android/framework/ui/markdown/image/MarkdownGlideImagesPlugin$DrawableTargetModel
      //   96: getfield a : Lio/noties/markwon/image/AsyncDrawable;
      //   99: aload_0
      //   100: getfield b : Lio/noties/markwon/image/AsyncDrawable;
      //   103: if_acmpne -> 129
      //   106: aload_1
      //   107: ifnull -> 121
      //   110: aload_0
      //   111: getfield b : Lio/noties/markwon/image/AsyncDrawable;
      //   114: invokevirtual g : ()Z
      //   117: pop
      //   118: goto -> 121
      //   121: aload_3
      //   122: monitorexit
      //   123: return
      //   124: astore_1
      //   125: aload_3
      //   126: monitorexit
      //   127: aload_1
      //   128: athrow
      //   129: iload_2
      //   130: iconst_1
      //   131: iadd
      //   132: istore_2
      //   133: goto -> 58
      // Exception table:
      //   from	to	target	type
      //   58	106	124	finally
      //   110	118	124	finally
      //   121	123	124	finally
      //   125	127	124	finally
    }
    
    public void c(Drawable param1Drawable) {
      if (this.b.g()) {
        if (AppInfo.m())
          Log.i("Markdown", "onLoadCleared"); 
        this.b.h();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framewor\\ui\markdown\image\MarkdownGlideImagesPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */