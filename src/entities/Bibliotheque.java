package entities;

public class Bibliotheque {

    private int capacite;
    private Document[] documents;
    private int nbDocuments;

    public Bibliotheque(int capacite) {
        this.capacite = capacite;
        this.documents = new Document[capacite];
        this.nbDocuments = 0;
    }

    public void afficherDocuments() {

        if (nbDocuments == 0) {
            System.out.println("La bibliothèque est vide.");
            return;
        }

        System.out.println("Documents de la bibliothèque :");

        for (int i = 0; i < nbDocuments; i++) {
            System.out.println(documents[i]);
        }
    }

    public boolean ajouter(Document doc) {

        if (nbDocuments == capacite) {
            return false;
        }

        documents[nbDocuments] = doc;
        nbDocuments++;

        return true;
    }

    public boolean supprimer(Document doc) {

        for (int i = 0; i < nbDocuments; i++) {

            if (documents[i] == doc) {

                for (int j = i; j < nbDocuments - 1; j++) {
                    documents[j] = documents[j + 1];
                }

                documents[nbDocuments - 1] = null;
                nbDocuments--;

                return true;
            }
        }

        return false;
    }

    public Document document(int numEnreg) {

        for (int i = 0; i < nbDocuments; i++) {

            if (documents[i].getNumEnreg() == numEnreg) {
                return documents[i];
            }
        }

        return null;
    }

    public void afficherAuteurs() {

        System.out.println("Auteurs :");

        for (int i = 0; i < nbDocuments; i++) {

            if (documents[i] instanceof Livre) {

                Livre livre = (Livre) documents[i];

                System.out.println(livre.getAuteur());
            }
        }
    }
}