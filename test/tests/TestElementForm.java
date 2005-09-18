/*
* Copyright 2004,2005 The Apache Software Foundation.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package tests;

import junit.framework.TestCase;

import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.axis.xsd.xml.schema.XmlSchemaCollection;
import org.apache.axis.xsd.xml.schema.XmlSchemaElement;
import org.apache.axis.xsd.xml.schema.XmlSchemaComplexType;
import org.apache.axis.xsd.xml.schema.XmlSchemaSequence;
import org.apache.axis.xsd.xml.schema.XmlSchemaObjectCollection;

import javax.xml.transform.stream.StreamSource;
import javax.xml.namespace.QName;

/**
 * TestElementForm
 */
public class TestElementForm extends TestCase {
    String NS = "http://unqualified-elements.example.com";
    QName UNQUAL = new QName(NS, "unQualifiedLocals");
    private XmlSchemaCollection schema;

    protected void setUp() throws Exception {
        InputStream is = new FileInputStream("test-resources/elementForm.xsd");
        schema = new XmlSchemaCollection();
        schema.read(new StreamSource(is), null);
    }

    public void testLocalElements() throws Exception {
        XmlSchemaElement element = schema.getElementByQName(UNQUAL);
        assertNotNull("Couldn't find unQualifiedLocals element", element);
        XmlSchemaComplexType type = (XmlSchemaComplexType)element.getSchemaType();
        XmlSchemaSequence seq = (XmlSchemaSequence)type.getParticle();
        XmlSchemaObjectCollection items = seq.getItems();
        XmlSchemaElement subElement;
        subElement = (XmlSchemaElement)items.getItem(0);
        QName qname = subElement.getQName();
        assertEquals("Namespace on unqualified element", "", qname.getNamespaceURI());
        subElement = (XmlSchemaElement)items.getItem(1);
        qname = subElement.getQName();
        assertEquals("Bad namespace on qualified element", NS, qname.getNamespaceURI());
    }
}
