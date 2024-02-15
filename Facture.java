import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Facture {
    private static int cmp=1;
    public int NumeroFacture;
    public Date dateFacture;
    public ArrayList<Achat> achats = new ArrayList();
    
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

        String s="Numero facture"+this.NumeroFacture+" date facture "+this.dateFacture.toString()+"\n";
        s+="Liste des achats\n";
        s+="Désignation\tremise\tprix(en DH)\tquantité\tprix Total\n";
        for(Achat a:achats){
            s+=a.article.Designation+"\t";
            if (a.article instanceof ArticleEnSolde) {
                ArticleEnSolde a2 = (ArticleEnSolde) a.article;
                s+=a2.remise+"\t";
            }else{
                s+="0\t";
            }
            s+=a.article.prix+"\t";
            s+=a.quantite+"\t";
            s+=a.article.prix*a.quantite+"\n";

        }
        s+="Montant de la facture :"+montantFacture();
        return s;
    }

    void EnregisterAchat(String fileName){
        achats.sort(null);
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(fileName);
            try {
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(achats);
            } catch (IOException e) {
        
            }
        } catch (FileNotFoundException e) {
            
        }
        
    }

}
