package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Num10825_2 {

    static class Student{
        String name;
        int scoreKor;
        int scoreEng;
        int scoreMath;
        
        public Student() {
        }
        
        public Student(String name, int scoreKor, int scoreEng, int scoreMath) {
            this.name = name;
            this.scoreKor = scoreKor;
            this.scoreEng = scoreEng;
            this.scoreMath = scoreMath;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getScoreKor() {
            return scoreKor;
        }
        public void setScoreKor(int scoreKor) {
            this.scoreKor = scoreKor;
        }
        public int getScoreEng() {
            return scoreEng;
        }
        public void setScoreEng(int scoreEng) {
            this.scoreEng = scoreEng;
        }
        public int getScoreMath() {
            return scoreMath;
        } 
        public void setScoreMath(int scoreMath) {
            this.scoreMath = scoreMath;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int numberOfStudent = Integer.parseInt(br.readLine());
        ArrayList<Student> listOfStudent = new ArrayList<>();
        
        StringTokenizer st;

        //make list
        for (int i = 0; i < numberOfStudent; i++) {
            st = new StringTokenizer(br.readLine());

            Student student = new Student();
            student.setName(st.nextToken());
            student.setScoreKor(Integer.parseInt(st.nextToken()));    
            student.setScoreEng(Integer.parseInt(st.nextToken()));    
            student.setScoreMath(Integer.parseInt(st.nextToken()));
            
            listOfStudent.add(student);
        }

        Collections.sort(listOfStudent, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                if (o1.getScoreKor() == o2.getScoreKor()) {
                    if (o1.getScoreEng() == o2.getScoreEng()) {
                        if (o1.getScoreMath() == o2.getScoreMath()) {
                            return o1.getName().compareTo(o2.getName());
                        }
                        return o2.getScoreMath() - o1.getScoreMath();
                    }
                    return o1.getScoreEng() - o2.getScoreEng();
                }
                return o2.getScoreKor() - o1.getScoreKor();
            }
        });

        for (Student student : listOfStudent) {
            System.out.println(student.getName());
        }

    }

}
