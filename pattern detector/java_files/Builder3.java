public class Builder3 {
    private final String name;
    private final int age;
    private final String city;

    private Builder3(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private int age;
        private String city;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder3 build() {
            return new Builder3(name, age, city);
        }
    }
}
