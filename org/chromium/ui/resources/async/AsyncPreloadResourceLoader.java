package org.chromium.ui.resources.async;

import android.util.SparseArray;
import java.util.concurrent.ExecutionException;
import org.chromium.base.AsyncTask;
import org.chromium.base.TraceEvent;
import org.chromium.ui.resources.Resource;
import org.chromium.ui.resources.ResourceLoader;

public class AsyncPreloadResourceLoader extends ResourceLoader {
  private final AsyncPreloadResourceLoader$ResourceCreator mCreator;
  
  final SparseArray mOutstandingLoads = new SparseArray();
  
  public AsyncPreloadResourceLoader(int paramInt, ResourceLoader.ResourceLoaderCallback paramResourceLoaderCallback, AsyncPreloadResourceLoader$ResourceCreator paramAsyncPreloadResourceLoader$ResourceCreator) {
    super(paramInt, paramResourceLoaderCallback);
    this.mCreator = paramAsyncPreloadResourceLoader$ResourceCreator;
  }
  
  final Resource createResource(int paramInt) {
    try {
      TraceEvent.begin("AsyncPreloadResourceLoader.createResource");
      return this.mCreator.create(paramInt);
    } finally {
      TraceEvent.end("AsyncPreloadResourceLoader.createResource");
    } 
  }
  
  public final void loadResource(int paramInt) {
    AsyncPreloadResourceLoader$AsyncLoadTask asyncPreloadResourceLoader$AsyncLoadTask = (AsyncPreloadResourceLoader$AsyncLoadTask)this.mOutstandingLoads.get(paramInt);
    if (asyncPreloadResourceLoader$AsyncLoadTask != null && !asyncPreloadResourceLoader$AsyncLoadTask.cancel(false))
      try {
        registerResource(asyncPreloadResourceLoader$AsyncLoadTask.mFuture.get(), paramInt);
        return;
      } catch (InterruptedException interruptedException) {
        notifyLoadFinished(paramInt, null);
        return;
      } catch (ExecutionException executionException) {
        notifyLoadFinished(paramInt, null);
        return;
      }  
    registerResource(createResource(paramInt), paramInt);
  }
  
  public final void preloadResource(int paramInt) {
    if (this.mOutstandingLoads.get(paramInt) != null)
      return; 
    AsyncPreloadResourceLoader$AsyncLoadTask asyncPreloadResourceLoader$AsyncLoadTask = new AsyncPreloadResourceLoader$AsyncLoadTask(this, paramInt);
    asyncPreloadResourceLoader$AsyncLoadTask.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, null);
    this.mOutstandingLoads.put(paramInt, asyncPreloadResourceLoader$AsyncLoadTask);
  }
  
  final void registerResource(Resource paramResource, int paramInt) {
    notifyLoadFinished(paramInt, paramResource);
    if (paramResource != null)
      paramResource.getBitmap().recycle(); 
    this.mOutstandingLoads.remove(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\resources\async\AsyncPreloadResourceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */