/*
 * Copyright (c) 2025 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.types.enumerated;

import org.eclipse.milo.opcua.stack.core.types.UaEnumeratedType;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.structured.EnumDefinition;
import org.eclipse.milo.opcua.stack.core.types.structured.EnumField;
import org.jspecify.annotations.Nullable;

/**
 * @see <a
 *     href="https://reference.opcfoundation.org/v105/Core/docs/Part22/5.3.1/#5.3.1.5">https://reference.opcfoundation.org/v105/Core/docs/Part22/5.3.1/#5.3.1.5</a>
 */
public enum TsnFailureCode implements UaEnumeratedType {
  /** No failure */
  NoFailure(0),

  /** Insufficient bandwidth */
  InsufficientBandwidth(1),

  /** Insufficient bridge resources */
  InsufficientResources(2),

  /** Insufficient bandwidth for Traffic Class */
  InsufficientTrafficClassBandwidth(3),

  /** StreamID in use by another Talker */
  StreamIdInUse(4),

  /** Stream destination address already in use */
  StreamDestinationAddressInUse(5),

  /** Stream pre-empted by higher rank */
  StreamPreemptedByHigherRank(6),

  /** Reported latency has changed */
  LatencyHasChanged(7),

  /** Egress port is not AVBCapable */
  EgressPortNotAvbCapable(8),

  /** Use a different destination address */
  UseDifferentDestinationAddress(9),

  /** Out of MSRP resources */
  OutOfMsrpResources(10),

  /** Out of MMRP resources */
  OutOfMmrpResources(11),

  /** Cannot store destination address */
  CannotStoreDestinationAddress(12),

  /** Requested priority is not an SR Class priority */
  PriorityIsNotAnSrcClass(13),

  /** MaxFrameSize is too large for media */
  MaxFrameSizeTooLarge(14),

  /** MaxFanInPorts limit has been reached */
  MaxFanInPortsLimitReached(15),

  /** Changes in FirstValue for a registered StreamID */
  FirstValueChangedForStreamId(16),

  /** VLAN is blocked on this egress port (Registration Forbidden) */
  VlanBlockedOnEgress(17),

  /** VLAN tagging is disabled on this egress port (untagged set) */
  VlanTaggingDisabledOnEgress(18),

  /** SR class priority mismatch */
  SrClassPriorityMismatch(19),

  /** Enhanced feature cannot be propagated to original Port */
  FeatureNotPropagated(20),

  /** MaxLatency exceeded */
  MaxLatencyExceeded(21),

  /** Nearest Bridge cannot provide network identification for stream transformation */
  BridgeDoesNotProvideNetworkId(22),

  /** Stream transformation not supported */
  StreamTransformNotSupported(23),

  /** Stream identification type not supported for stream transformation */
  StreamIdTypeNotSupported(24),

  /** Enhanced feature cannot be supported without a CNC */
  FeatureNotSupported(25);

  private final int value;

  TsnFailureCode(int value) {
    this.value = value;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public ExpandedNodeId getTypeId() {
    return TypeInfo.TYPE_ID;
  }

  public static @Nullable TsnFailureCode from(int value) {
    return switch (value) {
      case 0 -> NoFailure;
      case 1 -> InsufficientBandwidth;
      case 2 -> InsufficientResources;
      case 3 -> InsufficientTrafficClassBandwidth;
      case 4 -> StreamIdInUse;
      case 5 -> StreamDestinationAddressInUse;
      case 6 -> StreamPreemptedByHigherRank;
      case 7 -> LatencyHasChanged;
      case 8 -> EgressPortNotAvbCapable;
      case 9 -> UseDifferentDestinationAddress;
      case 10 -> OutOfMsrpResources;
      case 11 -> OutOfMmrpResources;
      case 12 -> CannotStoreDestinationAddress;
      case 13 -> PriorityIsNotAnSrcClass;
      case 14 -> MaxFrameSizeTooLarge;
      case 15 -> MaxFanInPortsLimitReached;
      case 16 -> FirstValueChangedForStreamId;
      case 17 -> VlanBlockedOnEgress;
      case 18 -> VlanTaggingDisabledOnEgress;
      case 19 -> SrClassPriorityMismatch;
      case 20 -> FeatureNotPropagated;
      case 21 -> MaxLatencyExceeded;
      case 22 -> BridgeDoesNotProvideNetworkId;
      case 23 -> StreamTransformNotSupported;
      case 24 -> StreamIdTypeNotSupported;
      case 25 -> FeatureNotSupported;
      default -> null;
    };
  }

  public static EnumDefinition definition() {
    return new EnumDefinition(
        new EnumField[] {
          new EnumField(
              0L, LocalizedText.NULL_VALUE, new LocalizedText("", "No failure"), "NoFailure"),
          new EnumField(
              1L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Insufficient bandwidth"),
              "InsufficientBandwidth"),
          new EnumField(
              2L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Insufficient bridge resources"),
              "InsufficientResources"),
          new EnumField(
              3L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Insufficient bandwidth for Traffic Class"),
              "InsufficientTrafficClassBandwidth"),
          new EnumField(
              4L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "StreamID in use by another Talker"),
              "StreamIdInUse"),
          new EnumField(
              5L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Stream destination address already in use"),
              "StreamDestinationAddressInUse"),
          new EnumField(
              6L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Stream pre-empted by higher rank"),
              "StreamPreemptedByHigherRank"),
          new EnumField(
              7L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Reported latency has changed"),
              "LatencyHasChanged"),
          new EnumField(
              8L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Egress port is not AVBCapable"),
              "EgressPortNotAvbCapable"),
          new EnumField(
              9L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Use a different destination address"),
              "UseDifferentDestinationAddress"),
          new EnumField(
              10L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Out of MSRP resources"),
              "OutOfMsrpResources"),
          new EnumField(
              11L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Out of MMRP resources"),
              "OutOfMmrpResources"),
          new EnumField(
              12L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Cannot store destination address"),
              "CannotStoreDestinationAddress"),
          new EnumField(
              13L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Requested priority is not an SR Class priority"),
              "PriorityIsNotAnSrcClass"),
          new EnumField(
              14L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "MaxFrameSize is too large for media"),
              "MaxFrameSizeTooLarge"),
          new EnumField(
              15L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "MaxFanInPorts limit has been reached"),
              "MaxFanInPortsLimitReached"),
          new EnumField(
              16L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Changes in FirstValue for a registered StreamID"),
              "FirstValueChangedForStreamId"),
          new EnumField(
              17L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "VLAN is blocked on this egress port (Registration Forbidden)"),
              "VlanBlockedOnEgress"),
          new EnumField(
              18L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "VLAN tagging is disabled on this egress port (untagged set)"),
              "VlanTaggingDisabledOnEgress"),
          new EnumField(
              19L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "SR class priority mismatch"),
              "SrClassPriorityMismatch"),
          new EnumField(
              20L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Enhanced feature cannot be propagated to original Port"),
              "FeatureNotPropagated"),
          new EnumField(
              21L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "MaxLatency exceeded"),
              "MaxLatencyExceeded"),
          new EnumField(
              22L,
              LocalizedText.NULL_VALUE,
              new LocalizedText(
                  "",
                  "Nearest Bridge cannot provide network identification for stream transformation"),
              "BridgeDoesNotProvideNetworkId"),
          new EnumField(
              23L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Stream transformation not supported"),
              "StreamTransformNotSupported"),
          new EnumField(
              24L,
              LocalizedText.NULL_VALUE,
              new LocalizedText(
                  "", "Stream identification type not supported for stream transformation"),
              "StreamIdTypeNotSupported"),
          new EnumField(
              25L,
              LocalizedText.NULL_VALUE,
              new LocalizedText("", "Enhanced feature cannot be supported without a CNC"),
              "FeatureNotSupported")
        });
  }

  public static final class TypeInfo {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("i=24218");
  }
}
