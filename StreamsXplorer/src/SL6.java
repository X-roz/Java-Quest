import lombok.Data;

import java.util.List;
import java.util.function.Predicate;

public class SL6 {

    @Data
    public static class Courses {
        private final String courseName;
        private final String authorName;
        private final Integer reviewScore;

        Courses(String courseName, String authorName, Integer reviewScore){
            this.reviewScore = reviewScore;
            this.courseName = courseName;
            this.authorName = authorName;
        }

        public String display() {
            return courseName + " " + authorName + " " + reviewScore;
        }
    }

    public static void main(String[] args){

        List<Courses> courseList = List.of(
                new Courses("AWS","Tesla",90),
                new Courses("JPA","Erwin",91),
                new Courses("API","Eren",92),
                new Courses("Docker","Arwin",93),
                new Courses("GO","Mike",96),
                new Courses("JAVA","Levi",99));

        System.out.println(" Course names with more than 95 scores : "
                + courseList.stream().filter(c -> c.getReviewScore() > 95).map(Courses::getCourseName).toList());

        /// Stream Matches --> allMatch, noneMatch, anyMatch

        Predicate<Courses> moreThan90 = c -> c.getReviewScore() > 90;
        Predicate<Courses> moreThan95 = c -> c.getReviewScore() > 95;
        Predicate<Courses> lessThan90 = c-> c.getReviewScore()<90;
        System.out.println("does all courses scores more than 90 : " + courseList.stream().anyMatch(moreThan90));
        System.out.println("does none of the courses scores are more than 95 : " + courseList.stream().noneMatch(moreThan95));
        System.out.println("does any courses scores less than 90 : " + courseList.stream().anyMatch(lessThan90));

    }

}
