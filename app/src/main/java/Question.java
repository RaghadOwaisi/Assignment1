public class Question {
    private String question;
    private String[] choices;
    private int answerIndex; // index of the correct answer in the choices array

    public Question(String question, String[] choices, int answerIndex) {
        this.question = question;
        this.choices = choices;
        this.answerIndex = answerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choices;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }
}
