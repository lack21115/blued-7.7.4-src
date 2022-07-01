package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.HttpUriLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Glide implements ComponentCallbacks2 {
  private static volatile Glide a;
  
  private static volatile boolean b;
  
  private final Engine c;
  
  private final BitmapPool d;
  
  private final MemoryCache e;
  
  private final GlideContext f;
  
  private final Registry g;
  
  private final ArrayPool h;
  
  private final RequestManagerRetriever i;
  
  private final ConnectivityMonitorFactory j;
  
  private final List<RequestManager> k;
  
  private final RequestOptionsFactory l;
  
  private MemoryCategory m;
  
  Glide(Context paramContext, Engine paramEngine, MemoryCache paramMemoryCache, BitmapPool paramBitmapPool, ArrayPool paramArrayPool, RequestManagerRetriever paramRequestManagerRetriever, ConnectivityMonitorFactory paramConnectivityMonitorFactory, int paramInt, RequestOptionsFactory paramRequestOptionsFactory, Map<Class<?>, TransitionOptions<?, ?>> paramMap, List<RequestListener<Object>> paramList, boolean paramBoolean1, boolean paramBoolean2) {
    StreamBitmapDecoder streamBitmapDecoder;
    ByteBufferBitmapDecoder byteBufferBitmapDecoder;
    this.k = new ArrayList<RequestManager>();
    this.m = MemoryCategory.b;
    this.c = paramEngine;
    this.d = paramBitmapPool;
    this.h = paramArrayPool;
    this.e = paramMemoryCache;
    this.i = paramRequestManagerRetriever;
    this.j = paramConnectivityMonitorFactory;
    this.l = paramRequestOptionsFactory;
    Resources resources = paramContext.getResources();
    this.g = new Registry();
    this.g.a((ImageHeaderParser)new DefaultImageHeaderParser());
    if (Build.VERSION.SDK_INT >= 27)
      this.g.a((ImageHeaderParser)new ExifInterfaceImageHeaderParser()); 
    List<ImageHeaderParser> list = this.g.a();
    ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(paramContext, list, paramBitmapPool, paramArrayPool);
    ResourceDecoder<ParcelFileDescriptor, Bitmap> resourceDecoder = VideoDecoder.b(paramBitmapPool);
    Downsampler downsampler = new Downsampler(this.g.a(), resources.getDisplayMetrics(), paramBitmapPool, paramArrayPool);
    if (paramBoolean2 && Build.VERSION.SDK_INT >= 28) {
      InputStreamBitmapImageDecoderResourceDecoder inputStreamBitmapImageDecoderResourceDecoder = new InputStreamBitmapImageDecoderResourceDecoder();
      ByteBufferBitmapImageDecoderResourceDecoder byteBufferBitmapImageDecoderResourceDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
    } else {
      byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
      streamBitmapDecoder = new StreamBitmapDecoder(downsampler, paramArrayPool);
    } 
    ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(paramContext);
    ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
    ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
    ResourceLoader.FileDescriptorFactory fileDescriptorFactory = new ResourceLoader.FileDescriptorFactory(resources);
    ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
    BitmapEncoder bitmapEncoder = new BitmapEncoder(paramArrayPool);
    BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
    GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
    ContentResolver contentResolver = paramContext.getContentResolver();
    this.g.<ByteBuffer>a(ByteBuffer.class, (Encoder<ByteBuffer>)new ByteBufferEncoder()).<InputStream>a(InputStream.class, (Encoder<InputStream>)new StreamEncoder(paramArrayPool)).<ByteBuffer, Bitmap>a("Bitmap", ByteBuffer.class, Bitmap.class, (ResourceDecoder<ByteBuffer, Bitmap>)byteBufferBitmapDecoder).a("Bitmap", InputStream.class, Bitmap.class, (ResourceDecoder<InputStream, Bitmap>)streamBitmapDecoder);
    if (ParcelFileDescriptorRewinder.c())
      this.g.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, (ResourceDecoder<ParcelFileDescriptor, Bitmap>)new ParcelFileDescriptorBitmapDecoder(downsampler)); 
    this.g.<ParcelFileDescriptor, Bitmap>a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, resourceDecoder).<AssetFileDescriptor, Bitmap>a("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.a(paramBitmapPool)).<Bitmap, Bitmap>a(Bitmap.class, Bitmap.class, (ModelLoaderFactory<Bitmap, Bitmap>)UnitModelLoader.Factory.b()).<Bitmap, Bitmap>a("Bitmap", Bitmap.class, Bitmap.class, (ResourceDecoder<Bitmap, Bitmap>)new UnitBitmapDecoder()).<Bitmap>a(Bitmap.class, (ResourceEncoder<Bitmap>)bitmapEncoder).<ByteBuffer, BitmapDrawable>a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, (ResourceDecoder<ByteBuffer, BitmapDrawable>)new BitmapDrawableDecoder(resources, (ResourceDecoder)byteBufferBitmapDecoder)).<InputStream, BitmapDrawable>a("BitmapDrawable", InputStream.class, BitmapDrawable.class, (ResourceDecoder<InputStream, BitmapDrawable>)new BitmapDrawableDecoder(resources, (ResourceDecoder)streamBitmapDecoder)).<ParcelFileDescriptor, BitmapDrawable>a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, (ResourceDecoder<ParcelFileDescriptor, BitmapDrawable>)new BitmapDrawableDecoder(resources, resourceDecoder)).<BitmapDrawable>a(BitmapDrawable.class, (ResourceEncoder<BitmapDrawable>)new BitmapDrawableEncoder(paramBitmapPool, (ResourceEncoder)bitmapEncoder)).<InputStream, GifDrawable>a("Gif", InputStream.class, GifDrawable.class, (ResourceDecoder<InputStream, GifDrawable>)new StreamGifDecoder(list, (ResourceDecoder)byteBufferGifDecoder, paramArrayPool)).<ByteBuffer, GifDrawable>a("Gif", ByteBuffer.class, GifDrawable.class, (ResourceDecoder<ByteBuffer, GifDrawable>)byteBufferGifDecoder).<GifDrawable>a(GifDrawable.class, (ResourceEncoder<GifDrawable>)new GifDrawableEncoder()).<GifDecoder, GifDecoder>a(GifDecoder.class, GifDecoder.class, (ModelLoaderFactory<GifDecoder, GifDecoder>)UnitModelLoader.Factory.b()).<GifDecoder, Bitmap>a("Bitmap", GifDecoder.class, Bitmap.class, (ResourceDecoder<GifDecoder, Bitmap>)new GifFrameResourceDecoder(paramBitmapPool)).<Uri, Drawable>a(Uri.class, Drawable.class, (ResourceDecoder<Uri, Drawable>)resourceDrawableDecoder).<Uri, Bitmap>a(Uri.class, Bitmap.class, (ResourceDecoder<Uri, Bitmap>)new ResourceBitmapDecoder(resourceDrawableDecoder, paramBitmapPool)).a((DataRewinder.Factory<?>)new ByteBufferRewinder.Factory()).<File, ByteBuffer>a(File.class, ByteBuffer.class, (ModelLoaderFactory<File, ByteBuffer>)new ByteBufferFileLoader.Factory()).<File, InputStream>a(File.class, InputStream.class, (ModelLoaderFactory<File, InputStream>)new FileLoader.StreamFactory()).<File, File>a(File.class, File.class, (ResourceDecoder<File, File>)new FileDecoder()).<File, ParcelFileDescriptor>a(File.class, ParcelFileDescriptor.class, (ModelLoaderFactory<File, ParcelFileDescriptor>)new FileLoader.FileDescriptorFactory()).<File, File>a(File.class, File.class, (ModelLoaderFactory<File, File>)UnitModelLoader.Factory.b()).a((DataRewinder.Factory<?>)new InputStreamRewinder.Factory(paramArrayPool));
    if (ParcelFileDescriptorRewinder.c())
      this.g.a((DataRewinder.Factory<?>)new ParcelFileDescriptorRewinder.Factory()); 
    this.g.<int, InputStream>a(int.class, InputStream.class, (ModelLoaderFactory<int, InputStream>)streamFactory).<int, ParcelFileDescriptor>a(int.class, ParcelFileDescriptor.class, (ModelLoaderFactory<int, ParcelFileDescriptor>)fileDescriptorFactory).<Integer, InputStream>a(Integer.class, InputStream.class, (ModelLoaderFactory<Integer, InputStream>)streamFactory).<Integer, ParcelFileDescriptor>a(Integer.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Integer, ParcelFileDescriptor>)fileDescriptorFactory).<Integer, Uri>a(Integer.class, Uri.class, (ModelLoaderFactory<Integer, Uri>)uriFactory).<int, AssetFileDescriptor>a(int.class, AssetFileDescriptor.class, (ModelLoaderFactory<int, AssetFileDescriptor>)assetFileDescriptorFactory).<Integer, AssetFileDescriptor>a(Integer.class, AssetFileDescriptor.class, (ModelLoaderFactory<Integer, AssetFileDescriptor>)assetFileDescriptorFactory).<int, Uri>a(int.class, Uri.class, (ModelLoaderFactory<int, Uri>)uriFactory).<String, InputStream>a(String.class, InputStream.class, (ModelLoaderFactory<String, InputStream>)new DataUrlLoader.StreamFactory()).<Uri, InputStream>a(Uri.class, InputStream.class, (ModelLoaderFactory<Uri, InputStream>)new DataUrlLoader.StreamFactory()).<String, InputStream>a(String.class, InputStream.class, (ModelLoaderFactory<String, InputStream>)new StringLoader.StreamFactory()).<String, ParcelFileDescriptor>a(String.class, ParcelFileDescriptor.class, (ModelLoaderFactory<String, ParcelFileDescriptor>)new StringLoader.FileDescriptorFactory()).<String, AssetFileDescriptor>a(String.class, AssetFileDescriptor.class, (ModelLoaderFactory<String, AssetFileDescriptor>)new StringLoader.AssetFileDescriptorFactory()).<Uri, InputStream>a(Uri.class, InputStream.class, (ModelLoaderFactory<Uri, InputStream>)new HttpUriLoader.Factory()).<Uri, InputStream>a(Uri.class, InputStream.class, (ModelLoaderFactory<Uri, InputStream>)new AssetUriLoader.StreamFactory(paramContext.getAssets())).<Uri, ParcelFileDescriptor>a(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Uri, ParcelFileDescriptor>)new AssetUriLoader.FileDescriptorFactory(paramContext.getAssets())).<Uri, InputStream>a(Uri.class, InputStream.class, (ModelLoaderFactory<Uri, InputStream>)new MediaStoreImageThumbLoader.Factory(paramContext)).a(Uri.class, InputStream.class, (ModelLoaderFactory<Uri, InputStream>)new MediaStoreVideoThumbLoader.Factory(paramContext));
    if (Build.VERSION.SDK_INT >= 29) {
      this.g.a(Uri.class, InputStream.class, (ModelLoaderFactory<Uri, InputStream>)new QMediaStoreUriLoader.InputStreamFactory(paramContext));
      this.g.a(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Uri, ParcelFileDescriptor>)new QMediaStoreUriLoader.FileDescriptorFactory(paramContext));
    } 
    this.g.<Uri, InputStream>a(Uri.class, InputStream.class, (ModelLoaderFactory<Uri, InputStream>)new UriLoader.StreamFactory(contentResolver)).<Uri, ParcelFileDescriptor>a(Uri.class, ParcelFileDescriptor.class, (ModelLoaderFactory<Uri, ParcelFileDescriptor>)new UriLoader.FileDescriptorFactory(contentResolver)).<Uri, AssetFileDescriptor>a(Uri.class, AssetFileDescriptor.class, (ModelLoaderFactory<Uri, AssetFileDescriptor>)new UriLoader.AssetFileDescriptorFactory(contentResolver)).<Uri, InputStream>a(Uri.class, InputStream.class, (ModelLoaderFactory<Uri, InputStream>)new UrlUriLoader.StreamFactory()).<URL, InputStream>a(URL.class, InputStream.class, (ModelLoaderFactory<URL, InputStream>)new UrlLoader.StreamFactory()).<Uri, File>a(Uri.class, File.class, (ModelLoaderFactory<Uri, File>)new MediaStoreFileLoader.Factory(paramContext)).<GlideUrl, InputStream>a(GlideUrl.class, InputStream.class, (ModelLoaderFactory<GlideUrl, InputStream>)new HttpGlideUrlLoader.Factory()).<byte[], ByteBuffer>a((Class)byte[].class, ByteBuffer.class, (ModelLoaderFactory<byte, ByteBuffer>)new ByteArrayLoader.ByteBufferFactory()).<byte[], InputStream>a((Class)byte[].class, InputStream.class, (ModelLoaderFactory<byte, InputStream>)new ByteArrayLoader.StreamFactory()).<Uri, Uri>a(Uri.class, Uri.class, (ModelLoaderFactory<Uri, Uri>)UnitModelLoader.Factory.b()).<Drawable, Drawable>a(Drawable.class, Drawable.class, (ModelLoaderFactory<Drawable, Drawable>)UnitModelLoader.Factory.b()).<Drawable, Drawable>a(Drawable.class, Drawable.class, (ResourceDecoder<Drawable, Drawable>)new UnitDrawableDecoder()).<Bitmap, BitmapDrawable>a(Bitmap.class, BitmapDrawable.class, (ResourceTranscoder<Bitmap, BitmapDrawable>)new BitmapDrawableTranscoder(resources)).<Bitmap, byte[]>a(Bitmap.class, (Class)byte[].class, (ResourceTranscoder<Bitmap, byte>)bitmapBytesTranscoder).<Drawable, byte[]>a(Drawable.class, (Class)byte[].class, (ResourceTranscoder<Drawable, byte>)new DrawableBytesTranscoder(paramBitmapPool, (ResourceTranscoder)bitmapBytesTranscoder, (ResourceTranscoder)gifDrawableBytesTranscoder)).a(GifDrawable.class, (Class)byte[].class, (ResourceTranscoder<GifDrawable, byte>)gifDrawableBytesTranscoder);
    if (Build.VERSION.SDK_INT >= 23) {
      ResourceDecoder<ByteBuffer, Bitmap> resourceDecoder1 = VideoDecoder.c(paramBitmapPool);
      this.g.a(ByteBuffer.class, Bitmap.class, resourceDecoder1);
      this.g.a(ByteBuffer.class, BitmapDrawable.class, (ResourceDecoder<ByteBuffer, BitmapDrawable>)new BitmapDrawableDecoder(resources, resourceDecoder1));
    } 
    ImageViewTargetFactory imageViewTargetFactory = new ImageViewTargetFactory();
    this.f = new GlideContext(paramContext, paramArrayPool, this.g, imageViewTargetFactory, paramRequestOptionsFactory, paramMap, paramList, paramEngine, paramBoolean1, paramInt);
  }
  
  public static Glide a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bumptech/glide/Glide.a : Lcom/bumptech/glide/Glide;
    //   3: ifnonnull -> 40
    //   6: aload_0
    //   7: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   10: invokestatic c : (Landroid/content/Context;)Lcom/bumptech/glide/GeneratedAppGlideModule;
    //   13: astore_1
    //   14: ldc com/bumptech/glide/Glide
    //   16: monitorenter
    //   17: getstatic com/bumptech/glide/Glide.a : Lcom/bumptech/glide/Glide;
    //   20: ifnonnull -> 28
    //   23: aload_0
    //   24: aload_1
    //   25: invokestatic a : (Landroid/content/Context;Lcom/bumptech/glide/GeneratedAppGlideModule;)V
    //   28: ldc com/bumptech/glide/Glide
    //   30: monitorexit
    //   31: goto -> 40
    //   34: astore_0
    //   35: ldc com/bumptech/glide/Glide
    //   37: monitorexit
    //   38: aload_0
    //   39: athrow
    //   40: getstatic com/bumptech/glide/Glide.a : Lcom/bumptech/glide/Glide;
    //   43: areturn
    // Exception table:
    //   from	to	target	type
    //   17	28	34	finally
    //   28	31	34	finally
    //   35	38	34	finally
  }
  
  public static RequestManager a(Activity paramActivity) {
    return d((Context)paramActivity).a(paramActivity);
  }
  
  public static RequestManager a(Fragment paramFragment) {
    return d(paramFragment.getContext()).a(paramFragment);
  }
  
  public static RequestManager a(FragmentActivity paramFragmentActivity) {
    return d((Context)paramFragmentActivity).a(paramFragmentActivity);
  }
  
  private static void a(Context paramContext, GeneratedAppGlideModule paramGeneratedAppGlideModule) {
    if (!b) {
      b = true;
      b(paramContext, paramGeneratedAppGlideModule);
      b = false;
      return;
    } 
    throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
  }
  
  private static void a(Context paramContext, GlideBuilder paramGlideBuilder, GeneratedAppGlideModule paramGeneratedAppGlideModule) {
    StringBuilder stringBuilder;
    RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
    Context context = paramContext.getApplicationContext();
    List<?> list = Collections.emptyList();
    if (paramGeneratedAppGlideModule == null || paramGeneratedAppGlideModule.c())
      list = (new ManifestParser(context)).a(); 
    if (paramGeneratedAppGlideModule != null && !paramGeneratedAppGlideModule.a().isEmpty()) {
      requestManagerFactory = (RequestManagerRetriever.RequestManagerFactory)paramGeneratedAppGlideModule.a();
      Iterator<?> iterator = list.iterator();
      while (iterator.hasNext()) {
        GlideModule glideModule = (GlideModule)iterator.next();
        if (!requestManagerFactory.contains(glideModule.getClass()))
          continue; 
        if (Log.isLoggable("Glide", 3)) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("AppGlideModule excludes manifest GlideModule: ");
          stringBuilder1.append(glideModule);
          Log.d("Glide", stringBuilder1.toString());
        } 
        iterator.remove();
      } 
    } 
    if (Log.isLoggable("Glide", 3))
      for (GlideModule glideModule : list) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Discovered GlideModule from manifest: ");
        stringBuilder1.append(glideModule.getClass());
        Log.d("Glide", stringBuilder1.toString());
      }  
    if (paramGeneratedAppGlideModule != null) {
      requestManagerFactory = paramGeneratedAppGlideModule.b();
    } else {
      requestManagerFactory = null;
    } 
    paramGlideBuilder.a(requestManagerFactory);
    null = list.iterator();
    while (null.hasNext())
      ((GlideModule)null.next()).a(context, paramGlideBuilder); 
    if (paramGeneratedAppGlideModule != null)
      paramGeneratedAppGlideModule.a(context, paramGlideBuilder); 
    Glide glide = paramGlideBuilder.a(context);
    for (GlideModule glideModule : list) {
      try {
        glideModule.a(context, glide, glide.g);
      } catch (AbstractMethodError abstractMethodError) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
        stringBuilder.append(glideModule.getClass().getName());
        throw new IllegalStateException(stringBuilder.toString(), abstractMethodError);
      } 
    } 
    if (stringBuilder != null)
      stringBuilder.a(context, (Glide)abstractMethodError, ((Glide)abstractMethodError).g); 
    context.registerComponentCallbacks((ComponentCallbacks)abstractMethodError);
    a = (Glide)abstractMethodError;
  }
  
  private static void a(Exception paramException) {
    throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", paramException);
  }
  
  public static RequestManager b(Context paramContext) {
    return d(paramContext).a(paramContext);
  }
  
  private static void b(Context paramContext, GeneratedAppGlideModule paramGeneratedAppGlideModule) {
    a(paramContext, new GlideBuilder(), paramGeneratedAppGlideModule);
  }
  
  private static GeneratedAppGlideModule c(Context paramContext) {
    try {
      return Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext.getApplicationContext() });
    } catch (ClassNotFoundException classNotFoundException) {
      if (Log.isLoggable("Glide", 5))
        Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored"); 
    } catch (InstantiationException instantiationException) {
      a(instantiationException);
    } catch (IllegalAccessException illegalAccessException) {
      a(illegalAccessException);
    } catch (NoSuchMethodException noSuchMethodException) {
      a(noSuchMethodException);
    } catch (InvocationTargetException invocationTargetException) {
      a(invocationTargetException);
    } 
    return null;
  }
  
  private static RequestManagerRetriever d(Context paramContext) {
    Preconditions.a(paramContext, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
    return a(paramContext).h();
  }
  
  public BitmapPool a() {
    return this.d;
  }
  
  public void a(int paramInt) {
    Util.a();
    Iterator<RequestManager> iterator = this.k.iterator();
    while (iterator.hasNext())
      ((RequestManager)iterator.next()).onTrimMemory(paramInt); 
    this.e.a(paramInt);
    this.d.a(paramInt);
    this.h.a(paramInt);
  }
  
  void a(RequestManager paramRequestManager) {
    synchronized (this.k) {
      if (!this.k.contains(paramRequestManager)) {
        this.k.add(paramRequestManager);
        return;
      } 
      throw new IllegalStateException("Cannot register already registered manager");
    } 
  }
  
  boolean a(Target<?> paramTarget) {
    synchronized (this.k) {
      Iterator<RequestManager> iterator = this.k.iterator();
      while (iterator.hasNext()) {
        if (((RequestManager)iterator.next()).b(paramTarget))
          return true; 
      } 
      return false;
    } 
  }
  
  public ArrayPool b() {
    return this.h;
  }
  
  void b(RequestManager paramRequestManager) {
    synchronized (this.k) {
      if (this.k.contains(paramRequestManager)) {
        this.k.remove(paramRequestManager);
        return;
      } 
      throw new IllegalStateException("Cannot unregister not yet registered manager");
    } 
  }
  
  public Context c() {
    return this.f.getBaseContext();
  }
  
  ConnectivityMonitorFactory d() {
    return this.j;
  }
  
  GlideContext e() {
    return this.f;
  }
  
  public void f() {
    Util.a();
    this.e.c();
    this.d.a();
    this.h.a();
  }
  
  public void g() {
    Util.b();
    this.c.a();
  }
  
  public RequestManagerRetriever h() {
    return this.i;
  }
  
  public Registry i() {
    return this.g;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {
    f();
  }
  
  public void onTrimMemory(int paramInt) {
    a(paramInt);
  }
  
  public static interface RequestOptionsFactory {
    RequestOptions a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\Glide.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */