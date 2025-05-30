/*
 * Copyright (c) 2025 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.types.structured;

import java.util.StringJoiner;
import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.encoding.EncodingContext;
import org.eclipse.milo.opcua.stack.core.encoding.GenericDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.encoding.UaDecoder;
import org.eclipse.milo.opcua.stack.core.encoding.UaEncoder;
import org.eclipse.milo.opcua.stack.core.types.UaStructuredType;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;
import org.eclipse.milo.opcua.stack.core.util.codegen.EqualsBuilder;
import org.eclipse.milo.opcua.stack.core.util.codegen.HashCodeBuilder;
import org.jspecify.annotations.Nullable;

/**
 * @see <a
 *     href="https://reference.opcfoundation.org/v105/Core/docs/Part11/6.5.5/#6.5.5.1">https://reference.opcfoundation.org/v105/Core/docs/Part11/6.5.5/#6.5.5.1</a>
 */
public class ReadAtTimeDetails extends HistoryReadDetails implements UaStructuredType {
  public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("i=653");

  public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=655");

  public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=654");

  public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15269");

  private final DateTime @Nullable [] reqTimes;

  private final Boolean useSimpleBounds;

  public ReadAtTimeDetails(DateTime @Nullable [] reqTimes, Boolean useSimpleBounds) {
    this.reqTimes = reqTimes;
    this.useSimpleBounds = useSimpleBounds;
  }

  @Override
  public ExpandedNodeId getTypeId() {
    return TYPE_ID;
  }

  @Override
  public ExpandedNodeId getBinaryEncodingId() {
    return BINARY_ENCODING_ID;
  }

  @Override
  public ExpandedNodeId getXmlEncodingId() {
    return XML_ENCODING_ID;
  }

  @Override
  public ExpandedNodeId getJsonEncodingId() {
    return JSON_ENCODING_ID;
  }

  public DateTime @Nullable [] getReqTimes() {
    return reqTimes;
  }

  public Boolean getUseSimpleBounds() {
    return useSimpleBounds;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    } else if (object == null || getClass() != object.getClass()) {
      return false;
    }
    ReadAtTimeDetails that = (ReadAtTimeDetails) object;
    var eqb = new EqualsBuilder();
    eqb.append(getReqTimes(), that.getReqTimes());
    eqb.append(getUseSimpleBounds(), that.getUseSimpleBounds());
    return eqb.build();
  }

  @Override
  public int hashCode() {
    var hcb = new HashCodeBuilder();
    hcb.append(getReqTimes());
    hcb.append(getUseSimpleBounds());
    return hcb.build();
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(", ", ReadAtTimeDetails.class.getSimpleName() + "[", "]");
    joiner.add("reqTimes=" + java.util.Arrays.toString(getReqTimes()));
    joiner.add("useSimpleBounds=" + getUseSimpleBounds());
    return joiner.toString();
  }

  public static StructureDefinition definition(NamespaceTable namespaceTable) {
    return new StructureDefinition(
        new NodeId(0, 655),
        new NodeId(0, 641),
        StructureType.Structure,
        new StructureField[] {
          new StructureField(
              "ReqTimes",
              LocalizedText.NULL_VALUE,
              new NodeId(0, 294),
              1,
              null,
              UInteger.valueOf(0),
              false),
          new StructureField(
              "UseSimpleBounds",
              LocalizedText.NULL_VALUE,
              new NodeId(0, 1),
              -1,
              null,
              UInteger.valueOf(0),
              false)
        });
  }

  public static final class Codec extends GenericDataTypeCodec<ReadAtTimeDetails> {
    @Override
    public Class<ReadAtTimeDetails> getType() {
      return ReadAtTimeDetails.class;
    }

    @Override
    public ReadAtTimeDetails decodeType(EncodingContext context, UaDecoder decoder) {
      final DateTime[] reqTimes;
      final Boolean useSimpleBounds;
      reqTimes = decoder.decodeDateTimeArray("ReqTimes");
      useSimpleBounds = decoder.decodeBoolean("UseSimpleBounds");
      return new ReadAtTimeDetails(reqTimes, useSimpleBounds);
    }

    @Override
    public void encodeType(EncodingContext context, UaEncoder encoder, ReadAtTimeDetails value) {
      encoder.encodeDateTimeArray("ReqTimes", value.getReqTimes());
      encoder.encodeBoolean("UseSimpleBounds", value.getUseSimpleBounds());
    }
  }
}
