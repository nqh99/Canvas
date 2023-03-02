package shape;

public enum ShapeType {
    CANVAS("C"),
    LINE("L"),
    RECTANGLE("R"),
    BUCKET("B");

    private String value;

    ShapeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ShapeType fromValue(String value) {
        for (ShapeType shapeType : ShapeType.values()) {
            if (shapeType.getValue().equals(value)) {
                return shapeType;
            }
        }
        return null;
    }
}
