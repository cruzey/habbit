package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num10825 {

    static class Student implements Comparable<Student>{
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

        public static int[] stringToAscii(String str) {
            int[] asciiValues = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                asciiValues[i] = (int) str.charAt(i);
            }
            return asciiValues;
        }

        @Override
        public int compareTo(Student o) {
            if(this.getScoreKor() == o.getScoreKor()){
                if(this.getScoreEng() == o.getScoreEng()){
                    if(this.getScoreMath() == o.getScoreMath()){
                        return this.getName().compareTo(o.getName());
                    }else{
                        return o.getScoreMath() - this.getScoreMath();
                    }
                }else{
                    return this.getScoreEng() - o.getScoreEng();
                }
            }else{
                return o.getScoreKor() - this.getScoreKor();
            }
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

        sort(listOfStudent);

        for (Student student : listOfStudent) {
            System.out.println(student.getName());
        }

    }

    private static void sort(ArrayList<Student> listOfStudent) {

        if(listOfStudent.size() < 1) return;

        Student pivot = listOfStudent.get(0);

        ArrayList<Student> left = new ArrayList<>();
        ArrayList<Student> right = new ArrayList<>();

        for (int i = 1; i < listOfStudent.size(); i++) {
            if(pivot.compareTo(listOfStudent.get(i)) > 0){
                left.add(listOfStudent.get(i));
            }else{
                right.add(listOfStudent.get(i));
            }
        }

        listOfStudent.clear();
        listOfStudent.addAll(left);
        listOfStudent.add(pivot);
        listOfStudent.addAll(right);

        left.clear();
        right.clear();
    }
}
