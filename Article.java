class Article{
    private static int compteur = 0;
    protected int code;
    protected String Designation;
    protected double prix;
    protected String categorie;

    // Constructeur par défaut
    public Article(){
        compteur++;
        //this.code = compteur;
        this.Designation="";
        this.prix =0;
        this.categorie="informatique";
    }
    // constructeur d'initialisation (paramètré)
    public Article(String designation,double prix,String categorie){
        compteur++;
        this.code = compteur;
        this.Designation=designation;
        this.prix =prix;
        this.categorie=categorie;
    }

    public String getCategorie(){
        return this.categorie;
    }

    public void setCategorie(String value) throws CategorieInvalideException{
        if(value.toLowerCase()=="informatique" || value.toLowerCase()=="bureatique"){
           this.categorie = value; 
        }
        else{
            throw new CategorieInvalideException("Message");
        }   
    }   
    //d)
    public double getPrix(){
        return this.prix;
    }
    //e)
    public void setPrix(double value){
       this.prix=value;
    }
    //f)
    public String toString(){
        return "Code : "+this.code +"\n Designation: "+this.Designation +"\n Prix: "+this.prix + "\n categorie: "+this.categorie;
    }
    public String afficher(){
        return "Code : "+this.code +"\n Designation: "+this.Designation +"\n Prix: "+this.prix + "\n categorie: "+this.categorie;
    }
    public void afficher2(){
        System.out.println("Code : "+this.code +"\nDesignation: "+this.Designation +"\nPrix: "+this.prix + "\n categorie: "+this.categorie);
    }
    public boolean equals(Article other ){
        return this.code == other.code && this.Designation == other.Designation;
    }
}