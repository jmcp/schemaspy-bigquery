/*
 * Copyright (C) 2023 Samuel Dussault
 *
 * This file is part of SchemaSpy.
 *
 * SchemaSpy is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SchemaSpy is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with SchemaSpy. If not, see <http://www.gnu.org/licenses/>.
 */
package org.schemaspy.util.markup;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;

/**
 * Created by samdus on 2023-06-05
 *
 * @author Samuel Dussault
 */
public class Asciidoc extends MarkupProcessor {

    @Override
    protected String parseToHtml(String markupText) {
        try(Asciidoctor asciidoctor = Asciidoctor.Factory.create()) {
            return asciidoctor.convert(markupText, Options.builder().build());
        }
    }

    protected String formatLink(String pageName, String pagePath) {
        return String.format("link:%s[%s]", pagePath, pageName);
    }
}
