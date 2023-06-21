import java.util.*;

class Question {
    private String question;
    private List<String> options;
    private int correctOption;

    public Question(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class OnlineExam {
    private List<Question> questions;
    private int score;

    public OnlineExam(List<Question> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startExam() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestion());

            List<String> options = question.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Enter your choice (1-" + options.size() + "): ");
            int choice = scanner.nextInt();

            if (choice == question.getCorrectOption()) {
                score++;
            }
        }

        scanner.close();

        System.out.println("Exam completed!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

public class Examination {
    public static void main(String[] args) {
        // Create questions
        List<Question> questions = new ArrayList<>();

        List<String> options1 = Arrays.asList("A. Delhi", "B. Mumbai", "C. Bangalore", "D. Chennai");
        Question question1 = new Question("Question 1: What is the capital of india?", options1, 1);
        questions.add(question1);

        List<String> options2 = Arrays.asList("A. earth", "B. jupiter", "C. venus", "D. neptune");
        Question question2 = new Question("Question 2: What is the largest planet in our solar system?", options2, 2);
        questions.add(question2);

        // Create online exam
        OnlineExam exam = new OnlineExam(questions);

        // Start the exam
        exam.startExam();
    }
}
