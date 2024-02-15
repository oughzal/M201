
public class ArticleEnSolde extends Article {
    public double remise;
    
    ArticleEnSolde(String designation,double prix,String categorie,double remise){
        super(designation, prix, categorie);
        this.remise=remise;
    }
    ArticleEnSolde(){
        super();
        this.remise=0;
    }
    public double getPrix(){
        return this.prix*(1-this.remise);
    }
    
}