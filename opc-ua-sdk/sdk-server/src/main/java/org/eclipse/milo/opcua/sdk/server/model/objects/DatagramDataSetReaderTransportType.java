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
import org.eclipse.milo.opcua.stack.core.types.structured.ReceiveQosDataType;

/**
 * @see <a
 *     href="https://reference.opcfoundation.org/v105/Core/docs/Part14/9.3.1/#9.3.1.4">https://reference.opcfoundation.org/v105/Core/docs/Part14/9.3.1/#9.3.1.4</a>
 */
public interface DatagramDataSetReaderTransportType extends DataSetReaderTransportType {
  QualifiedProperty<String> QOS_CATEGORY =
      new QualifiedProperty<>(
          "http://opcfoundation.org/UA/",
          "QosCategory",
          ExpandedNodeId.parse("nsu=http://opcfoundation.org/UA/;i=12"),
          -1,
          String.class);

  QualifiedProperty<ReceiveQosDataType[]> DATAGRAM_QOS =
      new QualifiedProperty<>(
          "http://opcfoundation.org/UA/",
          "DatagramQos",
          ExpandedNodeId.parse("nsu=http://opcfoundation.org/UA/;i=23608"),
          1,
          ReceiveQosDataType[].class);

  QualifiedProperty<String> TOPIC =
      new QualifiedProperty<>(
          "http://opcfoundation.org/UA/",
          "Topic",
          ExpandedNodeId.parse("nsu=http://opcfoundation.org/UA/;i=12"),
          -1,
          String.class);

  String getQosCategory();

  void setQosCategory(String value);

  PropertyType getQosCategoryNode();

  ReceiveQosDataType[] getDatagramQos();

  void setDatagramQos(ReceiveQosDataType[] value);

  PropertyType getDatagramQosNode();

  String getTopic();

  void setTopic(String value);

  PropertyType getTopicNode();

  NetworkAddressType getAddressNode();
}
