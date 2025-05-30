/*
 * Copyright (c) 2025 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.types;

import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;

/** Identifies an OPC UA structured type. */
public interface UaStructuredType extends UaDataType {

  ExpandedNodeId getBinaryEncodingId();

  ExpandedNodeId getXmlEncodingId();

  ExpandedNodeId getJsonEncodingId();
}
