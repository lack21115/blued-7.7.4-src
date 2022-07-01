package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.util.List;

public class ResourceDrawableDecoder implements ResourceDecoder<Uri, Drawable> {
  private final Context a;
  
  public ResourceDrawableDecoder(Context paramContext) {
    this.a = paramContext.getApplicationContext();
  }
  
  private int a(Context paramContext, Uri paramUri) {
    List list = paramUri.getPathSegments();
    if (list.size() == 2)
      return b(paramContext, paramUri); 
    if (list.size() == 1)
      return a(paramUri); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unrecognized Uri format: ");
    stringBuilder.append(paramUri);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private int a(Uri paramUri) {
    List<String> list = paramUri.getPathSegments();
    try {
      return Integer.parseInt(list.get(0));
    } catch (NumberFormatException numberFormatException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unrecognized Uri format: ");
      stringBuilder.append(paramUri);
      throw new IllegalArgumentException(stringBuilder.toString(), numberFormatException);
    } 
  }
  
  private Context a(Uri paramUri, String paramString) {
    if (paramString.equals(this.a.getPackageName()))
      return this.a; 
    try {
      return this.a.createPackageContext(paramString, 0);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      if (paramString.contains(this.a.getPackageName()))
        return this.a; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Failed to obtain context or unrecognized Uri format for: ");
      stringBuilder.append(paramUri);
      throw new IllegalArgumentException(stringBuilder.toString(), nameNotFoundException);
    } 
  }
  
  private int b(Context paramContext, Uri paramUri) {
    List<String> list = paramUri.getPathSegments();
    String str1 = paramUri.getAuthority();
    String str2 = list.get(0);
    String str3 = list.get(1);
    int j = paramContext.getResources().getIdentifier(str3, str2, str1);
    int i = j;
    if (j == 0)
      i = Resources.getSystem().getIdentifier(str3, str2, "android"); 
    if (i != 0)
      return i; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to find resource id for: ");
    stringBuilder.append(paramUri);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public Resource<Drawable> a(Uri paramUri, int paramInt1, int paramInt2, Options paramOptions) {
    Context context = a(paramUri, paramUri.getAuthority());
    paramInt1 = a(context, paramUri);
    return NonOwnedDrawableResource.a(DrawableDecoderCompat.a(this.a, context, paramInt1));
  }
  
  public boolean a(Uri paramUri, Options paramOptions) {
    return paramUri.getScheme().equals("android.resource");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\resource\drawable\ResourceDrawableDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */