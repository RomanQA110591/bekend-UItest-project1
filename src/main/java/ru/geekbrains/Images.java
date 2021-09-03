package ru.geekbrains;

public enum Images {
    MORE_THAN_10MB_IMAGE(""),
    PIXEL_1X1(""),
    IMAGE_URL("https://i.pinimg.com/236x/f3/fe/1d/f3fe1dd69bf54aa4822e9aab096afc62.jpg");

    private String path;
    Images(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
