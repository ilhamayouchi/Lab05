package entities;

import java.util.Scanner;
public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Donner la capacité de la bibliothèque : ");
        int n = sc.nextInt();
        sc.nextLine();

        Bibliotheque bibliotheque = new Bibliotheque(n);

        
        Roman roman = new Roman(
                "Le Petit Prince",
                "Antoine de Saint-Exupéry",
                96,
                50
        );

        Dictionnaire dictionnaire = new Dictionnaire(
                "Dictionnaire Larousse",
                "Français"
        );

        bibliotheque.ajouter(roman);
        bibliotheque.ajouter(dictionnaire);

        int choix = 0;

        while (choix != 7) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Ajouter un document");
            System.out.println("2. Afficher les documents");
            System.out.println("3. Supprimer un document");
            System.out.println("4. Rechercher un document");
            System.out.println("5. Afficher les auteurs");
            System.out.println("6. Ajouter un exemple");
            System.out.println("7. Quitter");
            System.out.print("Votre choix : ");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                case 1:

                    System.out.println("\nQuel type de document ?");
                    System.out.println("1. Roman");
                    System.out.println("2. Manuel");
                    System.out.println("3. Revue");
                    System.out.println("4. Dictionnaire");
                    System.out.print("Choix : ");

                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Titre : ");
                    String titre = sc.nextLine();

                    Document doc = null;

                    if (type == 1) {

                        System.out.print("Auteur : ");
                        String auteur = sc.nextLine();

                        System.out.print("Nombre de pages : ");
                        int pages = sc.nextInt();

                        System.out.print("Prix : ");
                        double prix = sc.nextDouble();
                        sc.nextLine();

                        doc = new Roman(titre, auteur, pages, prix);

                    } else if (type == 2) {

                        System.out.print("Auteur : ");
                        String auteur = sc.nextLine();

                        System.out.print("Nombre de pages : ");
                        int pages = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Niveau : ");
                        String niveau = sc.nextLine();

                        doc = new Manuel(titre, auteur, pages, niveau);

                    } else if (type == 3) {

                        System.out.print("Mois : ");
                        String mois = sc.nextLine();

                        System.out.print("Année : ");
                        int annee = sc.nextInt();
                        sc.nextLine();

                        doc = new Revue(titre, mois, annee);

                    } else if (type == 4) {

                        System.out.print("Langue : ");
                        String langue = sc.nextLine();

                        doc = new Dictionnaire(titre, langue);

                    } else {
                        System.out.println("Type incorrect.");
                    }

                    if (doc != null) {

                        if (bibliotheque.ajouter(doc)) {
                            System.out.println("Document ajouté.");
                        } else {
                            System.out.println("Bibliothèque pleine.");
                        }
                    }

                    break;

                case 2:

                    bibliotheque.afficherDocuments();

                    break;

                case 3:

                    System.out.print("Donner le numéro d'enregistrement : ");
                    int num = sc.nextInt();
                    sc.nextLine();

                    Document document = bibliotheque.document(num);

                    if (document != null) {

                        if (bibliotheque.supprimer(document)) {
                            System.out.println("Document supprimé.");
                        }

                    } else {
                        System.out.println("Document introuvable.");
                    }

                    break;

                case 4:

                    System.out.print("Donner le numéro d'enregistrement : ");
                    int numero = sc.nextInt();
                    sc.nextLine();

                    Document resultat = bibliotheque.document(numero);

                    if (resultat != null) {
                        System.out.println(resultat);
                    } else {
                        System.out.println("Document introuvable.");
                    }

                    break;

                case 5:

                    bibliotheque.afficherAuteurs();

                    break;

                case 6:

                    Manuel manuel = new Manuel(
                            "Java pour débutants",
                            "Jean Dupont",
                            250,
                            "Débutant"
                    );

                    if (bibliotheque.ajouter(manuel)) {
                        System.out.println("Manuel ajouté.");
                    } else {
                        System.out.println("Bibliothèque pleine.");
                    }

                    break;

                case 7:

                    System.out.println("Au revoir !");

                    break;

                default:

                    System.out.println("Choix incorrect.");
            }
        }

        sc.close();
    }
}