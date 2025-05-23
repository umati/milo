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
import org.eclipse.milo.opcua.stack.core.types.UaRequestMessageType;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MonitoringMode;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;
import org.eclipse.milo.opcua.stack.core.util.codegen.EqualsBuilder;
import org.eclipse.milo.opcua.stack.core.util.codegen.HashCodeBuilder;
import org.jspecify.annotations.Nullable;

/**
 * @see <a
 *     href="https://reference.opcfoundation.org/v105/Core/docs/Part4/5.13.4/#5.13.4.2">https://reference.opcfoundation.org/v105/Core/docs/Part4/5.13.4/#5.13.4.2</a>
 */
public class SetMonitoringModeRequest extends Structure implements UaRequestMessageType {
  public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("i=767");

  public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=769");

  public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=768");

  public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15329");

  private final RequestHeader requestHeader;

  private final UInteger subscriptionId;

  private final MonitoringMode monitoringMode;

  private final UInteger @Nullable [] monitoredItemIds;

  public SetMonitoringModeRequest(
      RequestHeader requestHeader,
      UInteger subscriptionId,
      MonitoringMode monitoringMode,
      UInteger @Nullable [] monitoredItemIds) {
    this.requestHeader = requestHeader;
    this.subscriptionId = subscriptionId;
    this.monitoringMode = monitoringMode;
    this.monitoredItemIds = monitoredItemIds;
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

  public RequestHeader getRequestHeader() {
    return requestHeader;
  }

  public UInteger getSubscriptionId() {
    return subscriptionId;
  }

  public MonitoringMode getMonitoringMode() {
    return monitoringMode;
  }

  public UInteger @Nullable [] getMonitoredItemIds() {
    return monitoredItemIds;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    } else if (object == null || getClass() != object.getClass()) {
      return false;
    }
    SetMonitoringModeRequest that = (SetMonitoringModeRequest) object;
    var eqb = new EqualsBuilder();
    eqb.append(getRequestHeader(), that.getRequestHeader());
    eqb.append(getSubscriptionId(), that.getSubscriptionId());
    eqb.append(getMonitoringMode(), that.getMonitoringMode());
    eqb.append(getMonitoredItemIds(), that.getMonitoredItemIds());
    return eqb.build();
  }

  @Override
  public int hashCode() {
    var hcb = new HashCodeBuilder();
    hcb.append(getRequestHeader());
    hcb.append(getSubscriptionId());
    hcb.append(getMonitoringMode());
    hcb.append(getMonitoredItemIds());
    return hcb.build();
  }

  @Override
  public String toString() {
    var joiner = new StringJoiner(", ", SetMonitoringModeRequest.class.getSimpleName() + "[", "]");
    joiner.add("requestHeader=" + getRequestHeader());
    joiner.add("subscriptionId=" + getSubscriptionId());
    joiner.add("monitoringMode=" + getMonitoringMode());
    joiner.add("monitoredItemIds=" + java.util.Arrays.toString(getMonitoredItemIds()));
    return joiner.toString();
  }

  public static StructureDefinition definition(NamespaceTable namespaceTable) {
    return new StructureDefinition(
        new NodeId(0, 769),
        new NodeId(0, 22),
        StructureType.Structure,
        new StructureField[] {
          new StructureField(
              "RequestHeader",
              LocalizedText.NULL_VALUE,
              new NodeId(0, 389),
              -1,
              null,
              UInteger.valueOf(0),
              false),
          new StructureField(
              "SubscriptionId",
              LocalizedText.NULL_VALUE,
              new NodeId(0, 288),
              -1,
              null,
              UInteger.valueOf(0),
              false),
          new StructureField(
              "MonitoringMode",
              LocalizedText.NULL_VALUE,
              new NodeId(0, 716),
              -1,
              null,
              UInteger.valueOf(0),
              false),
          new StructureField(
              "MonitoredItemIds",
              LocalizedText.NULL_VALUE,
              new NodeId(0, 288),
              1,
              null,
              UInteger.valueOf(0),
              false)
        });
  }

  public static final class Codec extends GenericDataTypeCodec<SetMonitoringModeRequest> {
    @Override
    public Class<SetMonitoringModeRequest> getType() {
      return SetMonitoringModeRequest.class;
    }

    @Override
    public SetMonitoringModeRequest decodeType(EncodingContext context, UaDecoder decoder) {
      final RequestHeader requestHeader;
      final UInteger subscriptionId;
      final MonitoringMode monitoringMode;
      final UInteger[] monitoredItemIds;
      requestHeader = (RequestHeader) decoder.decodeStruct("RequestHeader", RequestHeader.TYPE_ID);
      subscriptionId = decoder.decodeUInt32("SubscriptionId");
      monitoringMode = MonitoringMode.from(decoder.decodeEnum("MonitoringMode"));
      monitoredItemIds = decoder.decodeUInt32Array("MonitoredItemIds");
      return new SetMonitoringModeRequest(
          requestHeader, subscriptionId, monitoringMode, monitoredItemIds);
    }

    @Override
    public void encodeType(
        EncodingContext context, UaEncoder encoder, SetMonitoringModeRequest value) {
      encoder.encodeStruct("RequestHeader", value.getRequestHeader(), RequestHeader.TYPE_ID);
      encoder.encodeUInt32("SubscriptionId", value.getSubscriptionId());
      encoder.encodeEnum("MonitoringMode", value.getMonitoringMode());
      encoder.encodeUInt32Array("MonitoredItemIds", value.getMonitoredItemIds());
    }
  }
}
