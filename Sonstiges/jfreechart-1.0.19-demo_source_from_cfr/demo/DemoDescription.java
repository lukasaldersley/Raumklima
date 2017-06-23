/*
 * Decompiled with CFR 0_122.
 */
package demo;

public class DemoDescription {
    private String className;
    private String description;

    public DemoDescription(String string, String string2) {
        this.className = string;
        this.description = string2;
    }

    public String getClassName() {
        return this.className;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return this.description;
    }
}

