// automatically generated by the FlatBuffers compiler, do not modify

package org.modeldd.flatbufferssamples.couplemodels.generated;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")public final class CoupleModels extends Table {
  public static CoupleModels getRootAsCoupleModels(ByteBuffer _bb) { return getRootAsCoupleModels(_bb, new CoupleModels()); }
  public static CoupleModels getRootAsCoupleModels(ByteBuffer _bb, CoupleModels obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; }
  public CoupleModels __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public CoupleModelsLine lines(int j) { return lines(new CoupleModelsLine(), j); }
  public CoupleModelsLine lines(CoupleModelsLine obj, int j) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int linesLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }

  public static int createCoupleModels(FlatBufferBuilder builder,
      int linesOffset) {
    builder.startObject(1);
    CoupleModels.addLines(builder, linesOffset);
    return CoupleModels.endCoupleModels(builder);
  }

  public static void startCoupleModels(FlatBufferBuilder builder) { builder.startObject(1); }
  public static void addLines(FlatBufferBuilder builder, int linesOffset) { builder.addOffset(0, linesOffset, 0); }
  public static int createLinesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startLinesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endCoupleModels(FlatBufferBuilder builder) {
    int o = builder.endObject();
    return o;
  }
  public static void finishCoupleModelsBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
  public static void finishSizePrefixedCoupleModelsBuffer(FlatBufferBuilder builder, int offset) { builder.finishSizePrefixed(offset); }
}

