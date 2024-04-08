public class Portefeuille {
  private Cryptomonnaie monnaie;
  private double montant; // Soit le nombre de jetons
  private String proprietaire;

  public Portefeuille(Cryptomonnaie monnaie, double montant, String proprietaire){
      this.monnaie      = monnaie;
      this.montant      = montant;
      this.proprietaire = proprietaire;
  }

  /**
   * Cette fonction vous permet de transférer des devises du portefeuille actuel 
   * vers le portefeuille de destination pour le montant indiqué. Le type de devise 
   * (nom du Jeton) doit être le même entre les deux portefeuilles et le montant 
   * du portefeuille actuel doit être supérieur ou égal à celui indiqué.
   * @param destination 
   * @param montantJetons
   * @return Vrai si la transaction a été effectuée, faux sinon.  
   */
  public boolean transfertDevise (Portefeuille destination, double montantJetons)
  {
      
      if(this.monnaie != destination.getMonnaie()){System.out.println("monnaie invalide");return false;}
      if(this.montant < montantJetons){System.out.println("le montant est invalide");return false;} 
      this.montant -= montantJetons;
      
        destination.setMontant(destination.getMontant() + montantJetons);
        System.out.println("Transfert de devise réussi.");
        
      return true;
  }

  public void setMontant(double montant)
  {
    this.montant = montant;
  }
  

  /**
   * Cette fonction vous permet d'acheter des jetons de la 
   * crypto-devise en fonction de leur valeur en euros. 
   * Le résultat est l'augmentation des jetons de la crypto-monnaie.
   * @param montantEuros Valeur d'achat en euros 
   * @return true si le montant en euros est supérieur ou égal à 0 
   */
  public boolean achatDevise (double montantEuros)
  {
    if (montantEuros >= 0) 
    {
        double achat = 0.0;
        achat =  montantEuros / this.monnaie.getValeurDeJeton();
        this.montant += achat;
        System.out.println("Achat de devise réussi.");
        return true;
    } 
    else if(montantEuros < 0)
    {
        System.out.println("Le montant .");
        return false;
    }
    return false;
  }

  /**
   * Valide si le proprietaire passé en parametre est celui
   * qui as le portefeuille
   * @param proprietaire
   * @return true si les nom du propriétaire est correct
   */
  public boolean estProprietaire (String proprietaire)
  {
        return (proprietaire.equals(this.proprietaire))?true:false;
  }

  /**
   * 
   * @return La valeur en euros du Portefeuille. 
   * Autrement dit, le monant de jetons multiplié par la valeur des jetons. 
   */
  public double valeurEnEuros(){
      return this.montant * this.monnaie.getValeurDeJeton();
  }

  public String getProprietaire() {
      return this.proprietaire;
  }

  public Cryptomonnaie getMonnaie() {
      return this.monnaie;
  }

  public double getMontant() {
      return this.montant;
  }

  @Override
  public String toString() {
      return String.format("%10s",proprietaire) + " : "
           + String.format("%10.1f", montant)   + " x " 
           + this.monnaie.toString()            + " = "
           + String.format("%10.1f", valeurEnEuros());
  }

}
