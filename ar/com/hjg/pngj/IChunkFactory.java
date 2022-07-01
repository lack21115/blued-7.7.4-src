package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.ChunkRaw;
import ar.com.hjg.pngj.chunks.PngChunk;

public interface IChunkFactory {
  PngChunk a(ChunkRaw paramChunkRaw, ImageInfo paramImageInfo);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\IChunkFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */