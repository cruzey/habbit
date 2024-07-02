package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num10814 {

    static class Person implements Comparable<Person> {
        int age;
        String name;
        
        public Person() {
        }
        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return age + " " + name;
        }
        @Override
        public int compareTo(Person o) {
            return this.getAge() - o.getAge();
        }
        
    }

    static void sort(ArrayList<Person> people){

        if (people.size() < 1) {
            return;
        }

        Person pivot = people.get(0);
        ArrayList<Person> left = new ArrayList<>();
        ArrayList<Person> right = new ArrayList<>();

        for (int i = 1; i < people.size(); i++) {
            if (pivot.getAge() > people.get(i).getAge()) {
                left.add(people.get(i));
            }else{
                right.add(people.get(i));
            }
        }

        sort(left);
        sort(right);

        people.clear();
        people.addAll(left);
        people.add(pivot);
        people.addAll(right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> people = new ArrayList<>();
        StringTokenizer st;

        //사람 배열 목록
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            people.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));    
        }

        sort(people);

        for (Person person : people) {
            System.out.println(person.toString());
        }

    }
}