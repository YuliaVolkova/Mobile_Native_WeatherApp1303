package configuration;

public enum Devices {
    PIXEL4Native("PixelNative");
    public String getName() {
        return name;
    }

    String name;

    Devices(String name) {
        this.name = name;
    }
}
