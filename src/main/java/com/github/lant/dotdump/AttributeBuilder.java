package com.github.lant.dotdump;

import java.util.Map;

class AttributeBuilder {

    String build(final Map<String, String> attributes) {
        if (!attributes.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" [");
            int attIdx = 0;
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                stringBuilder.append(stringifyAttribute(entry));
                attIdx++;
                if (attIdx < attributes.size()) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        } else {
            return "";
        }
    }

    private String stringifyAttribute(Map.Entry<String, String> entry) {
        return entry.getKey()+"="+"\""+entry.getValue()+"\"";
    }

}
