import java.io.Serializable;

public class Achat implements Serializable,Comparable {
    public Article article;
    public int quantite;
    @Override
    public int compareTo(Object other) {
            Achat o = (Achat) other;
            return this.article.Designation.compareTo(o.article.Designation);

    }
}
