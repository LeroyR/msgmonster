/*
 * Copyright 2021 msgmonster project
 * 
 * Website: https://github.com/pinorobotics/msgmonster
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pinorobotics.msgmonster.app;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aeon_flux aeon_flux@eclipso.ch
 */
public class MessageDefinition {

    private List<Field> fields = new ArrayList<>();
    private List<EnumDefinition> enums = new ArrayList<>();
    private String comment;
    private String msgName;

    public MessageDefinition(Path msgName, String comment) {
        this.msgName = msgName.toString().replace(".msg", "");
        this.comment = comment;
    }

    public void addField(String type, String name, String value, String comment) {
        fields.add(new Field(name, type, value, comment));
    }

    public void addEnum(EnumDefinition enumDef) {
        enums.add(enumDef);
    }

    public String getComment() {
        return comment;
    }

    public String toString() {
        var buf = new StringBuilder();
        buf.append(comment + "\n");
        for (int i = 0; i < fields.size(); i++) {
            buf.append(fields.get(i));
        }
        return buf.toString();
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<EnumDefinition> getEnums() {
        return enums;
    }

    public String getName() {
        return msgName;
    }
}
