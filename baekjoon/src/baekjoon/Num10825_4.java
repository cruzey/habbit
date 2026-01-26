package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Num10825_4 {

    static class StudentInfo{
        String name;
        int mathScore;
        int koreanScore;
        int englishScore;
        
        public StudentInfo() {
        }
        
        public StudentInfo(String name, int mathScore, int koreanScore, int englishScore) {
            this.name = name;
            this.mathScore = mathScore;
            this.koreanScore = koreanScore;
            this.englishScore = englishScore;
        }

        public String getName() {
            return name;
        }
        public int getMathScore() {
            return mathScore;
        }
        public int getKoreanScore() {
            return koreanScore;
        }
        public int getEnglishScore() {
            return englishScore;
        } 
    }

    public static void main(String[] args) throws IOException{

        List<StudentInfo> sList = new ArrayList<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            StudentInfo student = new StudentInfo(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sList.add(student);
        }

        StringBuilder sb = new StringBuilder();
        
        sList.stream()
             .sorted(
                Comparator.comparing(StudentInfo::getKoreanScore, Comparator.reverseOrder()) // 1순위: 국어 내림차순
                    .thenComparing(StudentInfo::getEnglishScore)                             // 2순위: 영어 오름차순 (기본)
                    .thenComparing(StudentInfo::getMathScore, Comparator.reverseOrder())     // 3순위: 수학 내림차순
                    .thenComparing(StudentInfo::getName)                                     // 4순위: 이름 사전순 (기본)
             )
             .forEach(student -> sb.append(student.getName()).append("\n")); // 출력

        System.out.println(sb);
        
    }

}
