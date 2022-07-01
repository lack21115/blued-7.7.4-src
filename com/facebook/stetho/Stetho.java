package com.facebook.stetho;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.dumpapp.DumpappHttpSocketLikeHandler;
import com.facebook.stetho.dumpapp.DumpappSocketLikeHandler;
import com.facebook.stetho.dumpapp.Dumper;
import com.facebook.stetho.dumpapp.DumperPlugin;
import com.facebook.stetho.dumpapp.plugins.CrashDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.FilesDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.HprofDumperPlugin;
import com.facebook.stetho.dumpapp.plugins.SharedPreferencesDumperPlugin;
import com.facebook.stetho.inspector.DevtoolsSocketHandler;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import com.facebook.stetho.inspector.database.DatabaseConnectionProvider;
import com.facebook.stetho.inspector.database.DatabaseDriver2Adapter;
import com.facebook.stetho.inspector.database.DatabaseFilesProvider;
import com.facebook.stetho.inspector.database.DefaultDatabaseConnectionProvider;
import com.facebook.stetho.inspector.database.DefaultDatabaseFilesProvider;
import com.facebook.stetho.inspector.database.SqliteDatabaseDriver;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.DocumentProviderFactory;
import com.facebook.stetho.inspector.elements.android.ActivityTracker;
import com.facebook.stetho.inspector.elements.android.AndroidDocumentProviderFactory;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.module.CSS;
import com.facebook.stetho.inspector.protocol.module.Console;
import com.facebook.stetho.inspector.protocol.module.DOM;
import com.facebook.stetho.inspector.protocol.module.DOMStorage;
import com.facebook.stetho.inspector.protocol.module.Database;
import com.facebook.stetho.inspector.protocol.module.DatabaseDriver2;
import com.facebook.stetho.inspector.protocol.module.Debugger;
import com.facebook.stetho.inspector.protocol.module.HeapProfiler;
import com.facebook.stetho.inspector.protocol.module.Inspector;
import com.facebook.stetho.inspector.protocol.module.Network;
import com.facebook.stetho.inspector.protocol.module.Page;
import com.facebook.stetho.inspector.protocol.module.Profiler;
import com.facebook.stetho.inspector.protocol.module.Runtime;
import com.facebook.stetho.inspector.protocol.module.Worker;
import com.facebook.stetho.inspector.runtime.RhinoDetectingRuntimeReplFactory;
import com.facebook.stetho.server.AddressNameHelper;
import com.facebook.stetho.server.LazySocketHandler;
import com.facebook.stetho.server.LocalSocketServer;
import com.facebook.stetho.server.ProtocolDetectingSocketHandler;
import com.facebook.stetho.server.ServerManager;
import com.facebook.stetho.server.SocketHandler;
import com.facebook.stetho.server.SocketHandlerFactory;
import com.facebook.stetho.server.SocketLikeHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

public class Stetho {
  public static DumperPluginsProvider defaultDumperPluginsProvider(final Context context) {
    return new DumperPluginsProvider() {
        public Iterable<DumperPlugin> get() {
          return (new Stetho.DefaultDumperPluginsBuilder(context)).finish();
        }
      };
  }
  
  public static InspectorModulesProvider defaultInspectorModulesProvider(final Context context) {
    return new InspectorModulesProvider() {
        public Iterable<ChromeDevtoolsDomain> get() {
          return (new Stetho.DefaultInspectorModulesBuilder(context)).finish();
        }
      };
  }
  
  public static void initialize(Initializer paramInitializer) {
    if (!ActivityTracker.get().beginTrackingIfPossible((Application)paramInitializer.mContext.getApplicationContext()))
      LogUtil.w("Automatic activity tracking not available on this API level, caller must invoke ActivityTracker methods manually!"); 
    paramInitializer.start();
  }
  
  public static void initializeWithDefaults(final Context context) {
    initialize(new Initializer(context) {
          protected Iterable<DumperPlugin> getDumperPlugins() {
            return (new Stetho.DefaultDumperPluginsBuilder(context)).finish();
          }
          
          protected Iterable<ChromeDevtoolsDomain> getInspectorModules() {
            return (new Stetho.DefaultInspectorModulesBuilder(context)).finish();
          }
        });
  }
  
  public static InitializerBuilder newInitializerBuilder(Context paramContext) {
    return new InitializerBuilder(paramContext);
  }
  
  static class BuilderBasedInitializer extends Initializer {
    @Nullable
    private final DumperPluginsProvider mDumperPlugins;
    
    @Nullable
    private final InspectorModulesProvider mInspectorModules;
    
    private BuilderBasedInitializer(Stetho.InitializerBuilder param1InitializerBuilder) {
      super(param1InitializerBuilder.mContext);
      this.mDumperPlugins = param1InitializerBuilder.mDumperPlugins;
      this.mInspectorModules = param1InitializerBuilder.mInspectorModules;
    }
    
    @Nullable
    protected Iterable<DumperPlugin> getDumperPlugins() {
      DumperPluginsProvider dumperPluginsProvider = this.mDumperPlugins;
      return (dumperPluginsProvider != null) ? dumperPluginsProvider.get() : null;
    }
    
    @Nullable
    protected Iterable<ChromeDevtoolsDomain> getInspectorModules() {
      InspectorModulesProvider inspectorModulesProvider = this.mInspectorModules;
      return (inspectorModulesProvider != null) ? inspectorModulesProvider.get() : null;
    }
  }
  
  public static final class DefaultDumperPluginsBuilder {
    private final Context mContext;
    
    private final Stetho.PluginBuilder<DumperPlugin> mDelegate = new Stetho.PluginBuilder<DumperPlugin>();
    
    public DefaultDumperPluginsBuilder(Context param1Context) {
      this.mContext = param1Context;
    }
    
    private DefaultDumperPluginsBuilder provideIfDesired(DumperPlugin param1DumperPlugin) {
      this.mDelegate.provideIfDesired(param1DumperPlugin.getName(), param1DumperPlugin);
      return this;
    }
    
    public Iterable<DumperPlugin> finish() {
      provideIfDesired((DumperPlugin)new HprofDumperPlugin(this.mContext));
      provideIfDesired((DumperPlugin)new SharedPreferencesDumperPlugin(this.mContext));
      provideIfDesired((DumperPlugin)new CrashDumperPlugin());
      provideIfDesired((DumperPlugin)new FilesDumperPlugin(this.mContext));
      return this.mDelegate.finish();
    }
    
    public DefaultDumperPluginsBuilder provide(DumperPlugin param1DumperPlugin) {
      this.mDelegate.provide(param1DumperPlugin.getName(), param1DumperPlugin);
      return this;
    }
    
    public DefaultDumperPluginsBuilder remove(String param1String) {
      this.mDelegate.remove(param1String);
      return this;
    }
  }
  
  public static final class DefaultInspectorModulesBuilder {
    private final Application mContext;
    
    @Nullable
    private List<DatabaseDriver2> mDatabaseDrivers;
    
    @Nullable
    private DatabaseFilesProvider mDatabaseFilesProvider;
    
    private final Stetho.PluginBuilder<ChromeDevtoolsDomain> mDelegate = new Stetho.PluginBuilder<ChromeDevtoolsDomain>();
    
    @Nullable
    private DocumentProviderFactory mDocumentProvider;
    
    private boolean mExcludeSqliteDatabaseDriver;
    
    @Nullable
    private RuntimeReplFactory mRuntimeRepl;
    
    public DefaultInspectorModulesBuilder(Context param1Context) {
      this.mContext = (Application)param1Context.getApplicationContext();
    }
    
    private DefaultInspectorModulesBuilder provideIfDesired(ChromeDevtoolsDomain param1ChromeDevtoolsDomain) {
      this.mDelegate.provideIfDesired(param1ChromeDevtoolsDomain.getClass().getName(), param1ChromeDevtoolsDomain);
      return this;
    }
    
    @Nullable
    private DocumentProviderFactory resolveDocumentProvider() {
      DocumentProviderFactory documentProviderFactory = this.mDocumentProvider;
      return (DocumentProviderFactory)((documentProviderFactory != null) ? documentProviderFactory : ((Build.VERSION.SDK_INT >= 14) ? new AndroidDocumentProviderFactory(this.mContext, Collections.emptyList()) : null));
    }
    
    @Deprecated
    public DefaultInspectorModulesBuilder databaseFiles(DatabaseFilesProvider param1DatabaseFilesProvider) {
      this.mDatabaseFilesProvider = param1DatabaseFilesProvider;
      return this;
    }
    
    public DefaultInspectorModulesBuilder documentProvider(DocumentProviderFactory param1DocumentProviderFactory) {
      this.mDocumentProvider = param1DocumentProviderFactory;
      return this;
    }
    
    public DefaultInspectorModulesBuilder excludeSqliteDatabaseDriver(boolean param1Boolean) {
      this.mExcludeSqliteDatabaseDriver = param1Boolean;
      return this;
    }
    
    public Iterable<ChromeDevtoolsDomain> finish() {
      RhinoDetectingRuntimeReplFactory rhinoDetectingRuntimeReplFactory;
      provideIfDesired((ChromeDevtoolsDomain)new Console());
      provideIfDesired((ChromeDevtoolsDomain)new Debugger());
      DocumentProviderFactory documentProviderFactory = resolveDocumentProvider();
      if (documentProviderFactory != null) {
        Document document = new Document(documentProviderFactory);
        provideIfDesired((ChromeDevtoolsDomain)new DOM(document));
        provideIfDesired((ChromeDevtoolsDomain)new CSS(document));
      } 
      provideIfDesired((ChromeDevtoolsDomain)new DOMStorage((Context)this.mContext));
      provideIfDesired((ChromeDevtoolsDomain)new HeapProfiler());
      provideIfDesired((ChromeDevtoolsDomain)new Inspector());
      provideIfDesired((ChromeDevtoolsDomain)new Network((Context)this.mContext));
      provideIfDesired((ChromeDevtoolsDomain)new Page((Context)this.mContext));
      provideIfDesired((ChromeDevtoolsDomain)new Profiler());
      RuntimeReplFactory runtimeReplFactory = this.mRuntimeRepl;
      if (runtimeReplFactory == null)
        rhinoDetectingRuntimeReplFactory = new RhinoDetectingRuntimeReplFactory((Context)this.mContext); 
      provideIfDesired((ChromeDevtoolsDomain)new Runtime((RuntimeReplFactory)rhinoDetectingRuntimeReplFactory));
      provideIfDesired((ChromeDevtoolsDomain)new Worker());
      if (Build.VERSION.SDK_INT >= 11) {
        Database database = new Database();
        boolean bool2 = false;
        boolean bool1 = false;
        List<DatabaseDriver2> list = this.mDatabaseDrivers;
        if (list != null) {
          Iterator<DatabaseDriver2> iterator = list.iterator();
          while (true) {
            bool2 = bool1;
            if (iterator.hasNext()) {
              DatabaseDriver2 databaseDriver2 = iterator.next();
              database.add(databaseDriver2);
              if (databaseDriver2 instanceof SqliteDatabaseDriver)
                bool1 = true; 
              continue;
            } 
            break;
          } 
        } 
        if (!bool2 && !this.mExcludeSqliteDatabaseDriver) {
          DefaultDatabaseFilesProvider defaultDatabaseFilesProvider;
          Application application = this.mContext;
          DatabaseFilesProvider databaseFilesProvider = this.mDatabaseFilesProvider;
          if (databaseFilesProvider == null)
            defaultDatabaseFilesProvider = new DefaultDatabaseFilesProvider((Context)application); 
          database.add((DatabaseDriver2)new SqliteDatabaseDriver((Context)application, (DatabaseFilesProvider)defaultDatabaseFilesProvider, (DatabaseConnectionProvider)new DefaultDatabaseConnectionProvider()));
        } 
        provideIfDesired((ChromeDevtoolsDomain)database);
      } 
      return this.mDelegate.finish();
    }
    
    @Deprecated
    public DefaultInspectorModulesBuilder provide(ChromeDevtoolsDomain param1ChromeDevtoolsDomain) {
      this.mDelegate.provide(param1ChromeDevtoolsDomain.getClass().getName(), param1ChromeDevtoolsDomain);
      return this;
    }
    
    @Deprecated
    public DefaultInspectorModulesBuilder provideDatabaseDriver(Database.DatabaseDriver param1DatabaseDriver) {
      provideDatabaseDriver((DatabaseDriver2)new DatabaseDriver2Adapter(param1DatabaseDriver));
      return this;
    }
    
    public DefaultInspectorModulesBuilder provideDatabaseDriver(DatabaseDriver2 param1DatabaseDriver2) {
      if (this.mDatabaseDrivers == null)
        this.mDatabaseDrivers = new ArrayList<DatabaseDriver2>(); 
      this.mDatabaseDrivers.add(param1DatabaseDriver2);
      return this;
    }
    
    @Deprecated
    public DefaultInspectorModulesBuilder remove(String param1String) {
      this.mDelegate.remove(param1String);
      return this;
    }
    
    public DefaultInspectorModulesBuilder runtimeRepl(RuntimeReplFactory param1RuntimeReplFactory) {
      this.mRuntimeRepl = param1RuntimeReplFactory;
      return this;
    }
  }
  
  public static abstract class Initializer {
    private final Context mContext;
    
    protected Initializer(Context param1Context) {
      this.mContext = param1Context.getApplicationContext();
    }
    
    @Nullable
    protected abstract Iterable<DumperPlugin> getDumperPlugins();
    
    @Nullable
    protected abstract Iterable<ChromeDevtoolsDomain> getInspectorModules();
    
    final void start() {
      (new ServerManager(new LocalSocketServer("main", AddressNameHelper.createCustomAddress("_devtools_remote"), (SocketHandler)new LazySocketHandler(new RealSocketHandlerFactory())))).start();
    }
    
    class RealSocketHandlerFactory implements SocketHandlerFactory {
      private RealSocketHandlerFactory() {}
      
      public SocketHandler create() {
        ProtocolDetectingSocketHandler protocolDetectingSocketHandler = new ProtocolDetectingSocketHandler(Stetho.Initializer.this.mContext);
        Iterable<DumperPlugin> iterable = Stetho.Initializer.this.getDumperPlugins();
        if (iterable != null) {
          Dumper dumper = new Dumper(iterable);
          protocolDetectingSocketHandler.addHandler((ProtocolDetectingSocketHandler.MagicMatcher)new ProtocolDetectingSocketHandler.ExactMagicMatcher(DumpappSocketLikeHandler.PROTOCOL_MAGIC), (SocketLikeHandler)new DumpappSocketLikeHandler(dumper));
          DumpappHttpSocketLikeHandler dumpappHttpSocketLikeHandler = new DumpappHttpSocketLikeHandler(dumper);
          protocolDetectingSocketHandler.addHandler((ProtocolDetectingSocketHandler.MagicMatcher)new ProtocolDetectingSocketHandler.ExactMagicMatcher("GET /dumpapp".getBytes()), (SocketLikeHandler)dumpappHttpSocketLikeHandler);
          protocolDetectingSocketHandler.addHandler((ProtocolDetectingSocketHandler.MagicMatcher)new ProtocolDetectingSocketHandler.ExactMagicMatcher("POST /dumpapp".getBytes()), (SocketLikeHandler)dumpappHttpSocketLikeHandler);
        } 
        iterable = (Iterable)Stetho.Initializer.this.getInspectorModules();
        if (iterable != null)
          protocolDetectingSocketHandler.addHandler((ProtocolDetectingSocketHandler.MagicMatcher)new ProtocolDetectingSocketHandler.AlwaysMatchMatcher(), (SocketLikeHandler)new DevtoolsSocketHandler(Stetho.Initializer.this.mContext, iterable)); 
        return (SocketHandler)protocolDetectingSocketHandler;
      }
    }
  }
  
  class RealSocketHandlerFactory implements SocketHandlerFactory {
    private RealSocketHandlerFactory() {}
    
    public SocketHandler create() {
      ProtocolDetectingSocketHandler protocolDetectingSocketHandler = new ProtocolDetectingSocketHandler(Stetho.Initializer.this.mContext);
      Iterable<DumperPlugin> iterable = Stetho.Initializer.this.getDumperPlugins();
      if (iterable != null) {
        Dumper dumper = new Dumper(iterable);
        protocolDetectingSocketHandler.addHandler((ProtocolDetectingSocketHandler.MagicMatcher)new ProtocolDetectingSocketHandler.ExactMagicMatcher(DumpappSocketLikeHandler.PROTOCOL_MAGIC), (SocketLikeHandler)new DumpappSocketLikeHandler(dumper));
        DumpappHttpSocketLikeHandler dumpappHttpSocketLikeHandler = new DumpappHttpSocketLikeHandler(dumper);
        protocolDetectingSocketHandler.addHandler((ProtocolDetectingSocketHandler.MagicMatcher)new ProtocolDetectingSocketHandler.ExactMagicMatcher("GET /dumpapp".getBytes()), (SocketLikeHandler)dumpappHttpSocketLikeHandler);
        protocolDetectingSocketHandler.addHandler((ProtocolDetectingSocketHandler.MagicMatcher)new ProtocolDetectingSocketHandler.ExactMagicMatcher("POST /dumpapp".getBytes()), (SocketLikeHandler)dumpappHttpSocketLikeHandler);
      } 
      iterable = (Iterable)Stetho.Initializer.this.getInspectorModules();
      if (iterable != null)
        protocolDetectingSocketHandler.addHandler((ProtocolDetectingSocketHandler.MagicMatcher)new ProtocolDetectingSocketHandler.AlwaysMatchMatcher(), (SocketLikeHandler)new DevtoolsSocketHandler(Stetho.Initializer.this.mContext, iterable)); 
      return (SocketHandler)protocolDetectingSocketHandler;
    }
  }
  
  public static class InitializerBuilder {
    final Context mContext;
    
    @Nullable
    DumperPluginsProvider mDumperPlugins;
    
    @Nullable
    InspectorModulesProvider mInspectorModules;
    
    private InitializerBuilder(Context param1Context) {
      this.mContext = param1Context.getApplicationContext();
    }
    
    public Stetho.Initializer build() {
      return new Stetho.BuilderBasedInitializer(this);
    }
    
    public InitializerBuilder enableDumpapp(DumperPluginsProvider param1DumperPluginsProvider) {
      this.mDumperPlugins = (DumperPluginsProvider)Util.throwIfNull(param1DumperPluginsProvider);
      return this;
    }
    
    public InitializerBuilder enableWebKitInspector(InspectorModulesProvider param1InspectorModulesProvider) {
      this.mInspectorModules = param1InspectorModulesProvider;
      return this;
    }
  }
  
  static class PluginBuilder<T> {
    private boolean mFinished;
    
    private final ArrayList<T> mPlugins = new ArrayList<T>();
    
    private final Set<String> mProvidedNames = new HashSet<String>();
    
    private final Set<String> mRemovedNames = new HashSet<String>();
    
    private PluginBuilder() {}
    
    private void throwIfFinished() {
      if (!this.mFinished)
        return; 
      throw new IllegalStateException("Must not continue to build after finish()");
    }
    
    public Iterable<T> finish() {
      this.mFinished = true;
      return this.mPlugins;
    }
    
    public void provide(String param1String, T param1T) {
      throwIfFinished();
      this.mPlugins.add(param1T);
      this.mProvidedNames.add(param1String);
    }
    
    public void provideIfDesired(String param1String, T param1T) {
      throwIfFinished();
      if (!this.mRemovedNames.contains(param1String) && this.mProvidedNames.add(param1String))
        this.mPlugins.add(param1T); 
    }
    
    public void remove(String param1String) {
      throwIfFinished();
      this.mRemovedNames.remove(param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\Stetho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */