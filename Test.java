public class Test {
    public static void main(String[] args) {
        Article a1= new Article();
        Article a2 = new Article();
        
        try {
            a1.setCategorie("Dev");
        }
        catch(Exception e){

        } 
        catch (CategorieInvalideException e) {
            System.out.println("categorie invalide");
        }
        finally{
            
        }
    }
}
