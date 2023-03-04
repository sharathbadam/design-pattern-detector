public class Builder2 {
    private final String name;
    private final int age;
    private final String city;
    private Builder2(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
    public static class Builder {
        private String name;
        private int age;
        private String city;
        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public Builder setCity(String city) {
            this.city = city;
            return this;
        }
        public Builder2 build() {
            return new Builder2(name, age, city);
        }
    }
}
