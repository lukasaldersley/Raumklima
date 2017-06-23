/*
 * Decompiled with CFR 0_122.
 */
package demo.orsoncharts;

public class DemoDescription {
    private String className;
    private String fileName;
    private String descriptionFileName;

    public DemoDescription(String string, String string2, String string3) {
        this.className = string;
        this.fileName = string2;
        this.descriptionFileName = string3;
    }

    public String getClassName() {
        return this.className;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getDescriptionFileName() {
        return this.descriptionFileName;
    }

    public String toString() {
        return this.fileName;
    }
}

