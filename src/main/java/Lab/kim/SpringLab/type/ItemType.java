package Lab.kim.SpringLab.type;

public enum ItemType {
    Book("도서"),FOOD("음식"),ETC("기타");
    private final String description;
    ItemType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}