import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
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
        s+="---------------------------------------------------------------\n";
        s+=String.format("%-14s%-14s%-14s%-10s%-23s","Designation","remise","prix","quantite","prix Total");
        s+="\n";
        s+="---------------------------------------------------------------\n";
        for(Achat a:achats){
            
            s+= String.format("%-14s",a.article.Designation);
            if (a.article instanceof ArticleEnSolde) {
                ArticleEnSolde a2 = (ArticleEnSolde) a.article;
                s+= String.format("%-14s",+a2.remise);
            }else{
                s+= String.format("%-14s","0");
            }
            s+= String.format("%-14.2f",a.article.prix);
            s+= String.format("%-10d",a.quantite);
            double total = a.article.prix*a.quantite;
            s+= String.format("%-20.2f",total);
            s+="\n";
           
        }
        s+="---------------------------------------------------------------\n";
        s+="Montant de la facture :"+montantFacture();
        s+="\n---------------------------------------------------------------\n";
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
