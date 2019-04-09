package application.quiizzapp.ma.quiizzapplication;

public class Questions {

    public String mQuestion[] = {
            "Qu’est-ce qu’une œuvre a cappella ?",
            "Quel mot correspond à la définition : vitesse d'exécution d'une pièce musicale ?",
            "Quel mot résume le fait que tous les instruments jouent en même temps ?",
            "Quel est le terme que l'on donne au volume sonore ?",
            "Comment appelle-t-on une musique qui raconte une histoire, décrit un personnage ou un paysage ?"
    };

    private String mChoices[][] = {
            {"Une œuvre instrumentale","Une œuvre vocale","Une œuvre religieuse"},
            {"Tempo", "Motif", "Pulsation"},
            {"Solo", "Tutti", "Ostinato"},
            {"Registre", "Tempo", "Nuance"},
            {"Classique", "Descriptive", "Romantique"}
    };

    private String mCorrectAnswers[] = {"Une œuvre vocale", "Tempo", "Tutti", "Nuance", "Descriptive"};

    public String getQuestion(int a){
        String question = mQuestion[a];
        return question;
    }

    public String getChoice1(int a){
        return mChoices[a][0];
    }

    public String getChoice2(int a){
        return mChoices[a][1];
    }

    public String getChoice3(int a){
        return mChoices[a][2];
    }

    public String getCorrectAnswer(int a){
        return mCorrectAnswers[a];
    }




}
