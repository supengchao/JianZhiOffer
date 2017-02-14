package com.supengchao.github.jianzhioffer.model;

/**
 * Created by supengchao on 17/2/14.
 */

public class BuilderModel {
    static class Person {
        private String name;
        private int age;

        public Person(PersonBuilder personBuilder) {
            this.name = personBuilder.name;
            this.age = personBuilder.age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            return name.equals(person.name);

        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + age;
            return result;
        }
    }

    static class PersonBuilder {
        private String name;
        private int age;


        private PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        private PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        Person builder = new PersonBuilder().setAge(10).setName("haha").build();

        System.out.print(builder.toString());
    }
}
