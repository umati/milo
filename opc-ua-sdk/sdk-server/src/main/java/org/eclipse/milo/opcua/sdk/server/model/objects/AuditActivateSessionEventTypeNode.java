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
import org.eclipse.milo.opcua.stack.core.types.structured.AccessRestrictionType;
import org.eclipse.milo.opcua.stack.core.types.structured.RolePermissionType;
import org.eclipse.milo.opcua.stack.core.types.structured.SignedSoftwareCertificate;
import org.eclipse.milo.opcua.stack.core.types.structured.UserIdentityToken;

public class AuditActivateSessionEventTypeNode extends AuditSessionEventTypeNode
    implements AuditActivateSessionEventType {
  public AuditActivateSessionEventTypeNode(
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

  public AuditActivateSessionEventTypeNode(
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
  public PropertyTypeNode getClientSoftwareCertificatesNode() {
    Optional<VariableNode> propertyNode =
        getPropertyNode(AuditActivateSessionEventType.CLIENT_SOFTWARE_CERTIFICATES);
    return (PropertyTypeNode) propertyNode.orElse(null);
  }

  @Override
  public SignedSoftwareCertificate[] getClientSoftwareCertificates() {
    return getProperty(AuditActivateSessionEventType.CLIENT_SOFTWARE_CERTIFICATES).orElse(null);
  }

  @Override
  public void setClientSoftwareCertificates(SignedSoftwareCertificate[] value) {
    setProperty(AuditActivateSessionEventType.CLIENT_SOFTWARE_CERTIFICATES, value);
  }

  @Override
  public PropertyTypeNode getUserIdentityTokenNode() {
    Optional<VariableNode> propertyNode =
        getPropertyNode(AuditActivateSessionEventType.USER_IDENTITY_TOKEN);
    return (PropertyTypeNode) propertyNode.orElse(null);
  }

  @Override
  public UserIdentityToken getUserIdentityToken() {
    return getProperty(AuditActivateSessionEventType.USER_IDENTITY_TOKEN).orElse(null);
  }

  @Override
  public void setUserIdentityToken(UserIdentityToken value) {
    setProperty(AuditActivateSessionEventType.USER_IDENTITY_TOKEN, value);
  }

  @Override
  public PropertyTypeNode getSecureChannelIdNode() {
    Optional<VariableNode> propertyNode =
        getPropertyNode(AuditActivateSessionEventType.SECURE_CHANNEL_ID);
    return (PropertyTypeNode) propertyNode.orElse(null);
  }

  @Override
  public String getSecureChannelId() {
    return getProperty(AuditActivateSessionEventType.SECURE_CHANNEL_ID).orElse(null);
  }

  @Override
  public void setSecureChannelId(String value) {
    setProperty(AuditActivateSessionEventType.SECURE_CHANNEL_ID, value);
  }

  @Override
  public PropertyTypeNode getCurrentRoleIdsNode() {
    Optional<VariableNode> propertyNode =
        getPropertyNode(AuditActivateSessionEventType.CURRENT_ROLE_IDS);
    return (PropertyTypeNode) propertyNode.orElse(null);
  }

  @Override
  public NodeId[] getCurrentRoleIds() {
    return getProperty(AuditActivateSessionEventType.CURRENT_ROLE_IDS).orElse(null);
  }

  @Override
  public void setCurrentRoleIds(NodeId[] value) {
    setProperty(AuditActivateSessionEventType.CURRENT_ROLE_IDS, value);
  }
}
