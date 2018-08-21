/*
 * Copyright (c) 1998, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
// mmacivor - December 15/2009 - 2.0.1 - Initial implementation
package org.eclipse.persistence.testing.jaxb.typemappinginfo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class StringToListAdapter extends XmlAdapter<List<String>, String> {

    public List<String> marshal(String v) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        list.add("string1");
        list.add("string2");
        return list;
    }

    public String unmarshal(List<String> v) throws Exception {
        return "unmarshalled string";
    }


}
