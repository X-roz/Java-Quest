import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SL6 {

    @Data
    public static class Courses {
        private final String courseName;
        private final String authorName;
        private final Integer reviewScore;
        private final int students;

        Courses(String courseName, String authorName, Integer reviewScore, int students){
            this.reviewScore = reviewScore;
            this.courseName = courseName;
            this.authorName = authorName;
            this.students = students;
        }

        public String display() {
            return courseName + " " + authorName + " " + reviewScore;
        }
    }

    public static void main(String[] args){

        List<Courses> courseList = List.of(
                new Courses("AWS","Eren",97, 1200),
                new Courses("JPA","Erwin",91,650),
                new Courses("API","Eren",92,730),
                new Courses("Docker","Erwin",93,730),
                new Courses("GO","Eren",96,2000),
                new Courses("JAVA","Levi",99, 4800));

        System.out.println(" Course names with more than 95 scores : "
                + courseList.stream().filter(c -> c.getReviewScore() > 95).map(Courses::getCourseName).toList());

        /// Stream Matches --> allMatch, noneMatch, anyMatch

        Predicate<Courses> moreThan90 = c -> c.getReviewScore() > 90;
        Predicate<Courses> moreThan95 = c -> c.getReviewScore() > 95;
        Predicate<Courses> lessThan90 = c-> c.getReviewScore()<90;
        System.out.println("does all courses scores more than 90 : " + courseList.stream().anyMatch(moreThan90));
        System.out.println("does none of the courses scores are more than 95 : " + courseList.stream().noneMatch(moreThan95));
        System.out.println("does any courses scores less than 90 : " + courseList.stream().anyMatch(lessThan90));

        ///  Stream Storing and Comparison
        Comparator<Courses> increasingScores =  Comparator.comparing(Courses::getReviewScore);
        System.out.println("Scores ASC Sorted : "+ courseList.stream().sorted(increasingScores).map(Courses::getCourseName).toList());

        Comparator<Courses> decreasingScores = Comparator.comparing(Courses::getReviewScore).reversed();
        System.out.println("Scores DESC Sorted : "+ courseList.stream().sorted(decreasingScores).map(Courses::getCourseName).toList());

        // Greater no of Students and if equal compare scores
        Comparator<Courses> comparingStudentsAndScores = Comparator.comparingInt(Courses::getStudents).thenComparing(Courses::getReviewScore).reversed();
        System.out.println("Sorted by students and scores : "+ courseList.stream().sorted(comparingStudentsAndScores).map(Courses::getCourseName).toList());
        // [JAVA, GO, AWS, Docker, API, JPA]

        // Skip - skips the given amount of values
        System.out.println("Skipping 3 courses : "+
                courseList.stream().sorted(comparingStudentsAndScores).skip(2).map(Courses::getCourseName).toList());
        // [AWS, Docker, API, JPA]

        // Limit - takes/consider the given amount of values to next step
        System.out.println("Taking only top 2 courses : "+
                courseList.stream().sorted(comparingStudentsAndScores).limit(2).map(Courses::getCourseName).toList());
        // [JAVA, GO]

        // TakeWhile - takes the values util the given condition fails
        Predicate<Courses> takeUntil= c ->  c.getReviewScore() >= 93;
        System.out.println("Take While : "+
                courseList.stream().sorted(comparingStudentsAndScores).takeWhile(takeUntil).map(Courses::getCourseName).toList());
        // [JAVA, GO, AWS, Docker]

        // DropWhile - drops the values util the given condition fails and returns the remaining
        Predicate<Courses> dropUntil= c ->  c.getReviewScore() >= 96 ;
        System.out.println("Drop While : "+
                courseList.stream().sorted(comparingStudentsAndScores).dropWhile(dropUntil).map(Courses::getCourseName).toList());
        // [Docker, API, JPA]

        // Max - returns the last element based on the comparator (return datatype Optional)
        System.out.println("Max (returning last element) : "+
                courseList.stream().max(comparingStudentsAndScores).map(Courses::getCourseName).stream().toList());

        // Min - returns the first element based on the comparator (return datatype Optional)
        System.out.println("Min (returning first element) : "+
                courseList.stream().min(comparingStudentsAndScores).map(Courses::getCourseName).stream().toList());

        // if nothing found while doing comparator we can add a default value
        Comparator<Courses> lessThan90Comp = Comparator.comparing (c-> c.getReviewScore()<90);
        System.out.println("Default : "+courseList.stream().min(lessThan90Comp).orElse(new Courses("Spring", "floki",95, 300)));

        // FindFirst
        System.out.println("Find First course with more than 1200 students :" +
                courseList.stream().filter(c->c.getStudents()> 1200).findFirst());

        // FindAny
        System.out.println("Find Any course with Scores more than 95 :" +
                courseList.stream().filter(c->c.getReviewScore() > 95).findFirst());

        // SUM
        System.out.println("Sum of students with courses below 95 review scores :" +
                courseList.stream().filter(c->c.getReviewScore() < 95).mapToInt(Courses::getStudents).sum());

        // Average
        System.out.println("Avg no of students with courses below 95 review scores :" +
                courseList.stream().filter(c->c.getReviewScore() < 95).mapToInt(Courses::getStudents).average());

        // Count
        System.out.println("No of course with below 95 review scores :" +
                courseList.stream().filter(c->c.getReviewScore() < 95).mapToInt(Courses::getStudents).count());

        // GroupingBy Map
        System.out.println("Authors with their courses :" +
                courseList.stream()
                        .collect(Collectors.groupingBy(Courses::getAuthorName,
                                Collectors.mapping(Courses::getCourseName, Collectors.toList())))
        );

        // Counting Authors courses
        System.out.println("Counting Authors courses :" +
                courseList.stream().collect(Collectors
                        .groupingBy(Courses::getAuthorName, Collectors.counting()))
        );

        // Taking Authors courses with maximum review scores
        Map<String, Optional<Courses>> authorsTopCourses= courseList.stream().collect(Collectors
                .groupingBy(Courses::getAuthorName, Collectors.maxBy(Comparator.comparing(Courses::getReviewScore))));

        authorsTopCourses.forEach((a, c) -> {
            c.ifPresent(courses -> System.out.println("Author : " + a + " Best Course : " + courses.getCourseName()));
        });
    }

}
