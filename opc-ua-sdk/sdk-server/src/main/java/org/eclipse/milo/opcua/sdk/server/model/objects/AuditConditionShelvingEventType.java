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

import org.eclipse.milo.opcua.sdk.core.QualifiedProperty;
import org.eclipse.milo.opcua.sdk.server.model.variables.PropertyType;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;

/**
 * @see <a
 *     href="https://reference.opcfoundation.org/v105/Core/docs/Part9/5.10.8">https://reference.opcfoundation.org/v105/Core/docs/Part9/5.10.8</a>
 */
public interface AuditConditionShelvingEventType extends AuditConditionEventType {
  QualifiedProperty<Double> SHELVING_TIME =
      new QualifiedProperty<>(
          "http://opcfoundation.org/UA/",
          "ShelvingTime",
          ExpandedNodeId.parse("nsu=http://opcfoundation.org/UA/;i=290"),
          -1,
          Double.class);

  Double getShelvingTime();

  void setShelvingTime(Double value);

  PropertyType getShelvingTimeNode();
}
