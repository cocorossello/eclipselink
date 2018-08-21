/*
 * Copyright (c) 2011, 2018 Oracle and/or its affiliates. All rights reserved.
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
//  - rbarkhouse - 27 February - 2.3.3 - Initial implementation
package org.eclipse.persistence.testing.jaxb.idresolver;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.persistence.oxm.annotations.XmlKey;

@XmlRootElement
class Melon {

    @XmlID
    @XmlAttribute
    String id;

    @XmlElement
    String type;

    @XmlTransient
    boolean processed = false;

    @Override
    public String toString() {
        return "M(" + id + ")" + type + "|" + (processed ? "Ok" : "XX");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Melon)) {
            return false;
        }
        Melon a = (Melon) obj;

        if (!this.id.equals(a.id)) {
            return false;
        }
        if (!this.type.equals(a.type)) {
            return false;
        }
        if (this.processed != a.processed) {
            return false;
        }

        return true;
    }

}
