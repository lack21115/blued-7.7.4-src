package com.bumptech.glide;

import android.content.Context;
import com.blued.android.core.image.GlideRequests;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.manager.RequestManagerTreeNode;

final class GeneratedRequestManagerFactory implements RequestManagerRetriever.RequestManagerFactory {
  public RequestManager a(Glide paramGlide, Lifecycle paramLifecycle, RequestManagerTreeNode paramRequestManagerTreeNode, Context paramContext) {
    return (RequestManager)new GlideRequests(paramGlide, paramLifecycle, paramRequestManagerTreeNode, paramContext);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\GeneratedRequestManagerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */