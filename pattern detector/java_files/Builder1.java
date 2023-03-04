public class Builder1 {
    private final String name;
    private final int age;
    private final String city;
    private Builder1(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.city = builder.city;
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
        public Builder1 build() {
            return new Builder1(this);
        }
    }
}
