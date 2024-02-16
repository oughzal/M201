import java.sql.Date;


public class Test {
    public static void main(String[] args) {
        Facture f1 = new Facture(new Date(0));
        Achat achat  = new Achat();
        Article a = new Article();
        a.Designation = "PC";
        a.prix = 7000;
        achat.article = a;
        achat.quantite = 3;
        f1.ajouter(achat);
        achat  = new Achat();
        a = new Article();
        a.Designation = "Mac";
        a.prix = 17000;
        achat.article = a;
        achat.quantite = 3;
        
        f1.ajouter(achat);
        System.out.println(f1);
    }
}
