/*
 * Copyright (c) 2025 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.server.model.objects;

import java.util.Optional;
import org.eclipse.milo.opcua.sdk.core.nodes.VariableNode;
import org.eclipse.milo.opcua.sdk.server.model.variables.PropertyTypeNode;
import org.eclipse.milo.opcua.sdk.server.nodes.UaNodeContext;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.RedundancySupport;
import org.eclipse.milo.opcua.stack.core.types.structured.AccessRestrictionType;
import org.eclipse.milo.opcua.stack.core.types.structured.RedundantServerDataType;
import org.eclipse.milo.opcua.stack.core.types.structured.RolePermissionType;

public class ServerRedundancyTypeNode extends BaseObjectTypeNode implements ServerRedundancyType {
  public ServerRedundancyTypeNode(
      UaNodeContext context,
      NodeId nodeId,
      QualifiedName browseName,
      LocalizedText displayName,
      LocalizedText description,
      UInteger writeMask,
      UInteger userWriteMask,
      RolePermissionType[] rolePermissions,
      RolePermissionType[] userRolePermissions,
      AccessRestrictionType accessRestrictions,
      UByte eventNotifier) {
    super(
        context,
        nodeId,
        browseName,
        displayName,
        description,
        writeMask,
        userWriteMask,
        rolePermissions,
        userRolePermissions,
        accessRestrictions,
        eventNotifier);
  }

  public ServerRedundancyTypeNode(
      UaNodeContext context,
      NodeId nodeId,
      QualifiedName browseName,
      LocalizedText displayName,
      LocalizedText description,
      UInteger writeMask,
      UInteger userWriteMask,
      RolePermissionType[] rolePermissions,
      RolePermissionType[] userRolePermissions,
      AccessRestrictionType accessRestrictions) {
    super(
        context,
        nodeId,
        browseName,
        displayName,
        description,
        writeMask,
        userWriteMask,
        rolePermissions,
        userRolePermissions,
        accessRestrictions);
  }

  @Override
  public PropertyTypeNode getRedundancySupportNode() {
    Optional<VariableNode> propertyNode = getPropertyNode(ServerRedundancyType.REDUNDANCY_SUPPORT);
    return (PropertyTypeNode) propertyNode.orElse(null);
  }

  @Override
  public RedundancySupport getRedundancySupport() {
    return getProperty(ServerRedundancyType.REDUNDANCY_SUPPORT).orElse(null);
  }

  @Override
  public void setRedundancySupport(RedundancySupport value) {
    setProperty(ServerRedundancyType.REDUNDANCY_SUPPORT, value);
  }

  @Override
  public PropertyTypeNode getRedundantServerArrayNode() {
    Optional<VariableNode> propertyNode =
        getPropertyNode(ServerRedundancyType.REDUNDANT_SERVER_ARRAY);
    return (PropertyTypeNode) propertyNode.orElse(null);
  }

  @Override
  public RedundantServerDataType[] getRedundantServerArray() {
    return getProperty(ServerRedundancyType.REDUNDANT_SERVER_ARRAY).orElse(null);
  }

  @Override
  public void setRedundantServerArray(RedundantServerDataType[] value) {
    setProperty(ServerRedundancyType.REDUNDANT_SERVER_ARRAY, value);
  }
}
