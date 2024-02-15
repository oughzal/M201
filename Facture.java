import java.sql.Date;
import java.util.ArrayList;

public class Facture {
    private static int cmp=1;
    public int NumeroFacture;
    public Date dateFacture;
    public ArrayList<Achat> achats;
    
    Facture(Date date){
        this.dateFacture=date;
        this.NumeroFacture=cmp++;
    }
    void ajouter(Achat a){
        achats.add(a);
    }
    double montantFacture(){
        double total=0;
        for(Achat a:achats){
            total+=a.article.prix*a.quantite;
        }
        return total;
    }
    @Override
    public String toString() {
        String s="Numéro facture"+this.NumeroFacture+" date facture "+this.dateFacture.toString();
        s+="Liste des achats";
        s+="Désignation\tremise\tprix(en DH)\tquantité\tprix Total";
        for(Achat a:achats){
            s+=a.article.Designation+"\t";
            if (a.article instanceof ArticleEnSolde) {
                ArticleEnSolde a2 = (ArticleEnSolde) a.article;
                s+=a2.remise+"\t";
            }else{
                s+="0\t";
            }
            s+=a.article.Designation+"\t";
            s+=a.article.prix+"\t";
            s+=a.quantite+"\t";
            s+=a.article.prix*a.quantite+"\t";
        }
        s+="\nMontant de la facture :"+montantFacture();
        return s;
    }
}
