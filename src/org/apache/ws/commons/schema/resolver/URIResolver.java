package org.apache.ws.commons.schema.resolver;

import org.xml.sax.InputSource;

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

public interface URIResolver {
    /**
     * Resolves an interface
     * @param targetNamespace
     * @param schemaLocation
     * @param baseUri
     * @return
     */
     InputSource resolveEntity(String targetNamespace,
                                     String schemaLocation,
                                     String baseUri
                                     );

}
