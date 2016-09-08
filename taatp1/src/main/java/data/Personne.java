package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Personne {
  private int id;
  private String nom;
  private String prenom;
  private String mail;
  private Machine monpc; 
  
  /**
   * Constructeur vide
   */
  public Personne(){}
  
  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public String getNom() {
    return nom;
  }
  
  public void setNom(String nom) {
    this.nom = nom;
  }
  
  public String getPrenom() {
    return prenom;
  }
  
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }
  
  public String getMail() {
    return mail;
  }
  
  public void setMail(String mail) {
    this.mail = mail;
  }

  @OneToOne(mappedBy="root")
  public Machine getMonpc() {
    return monpc;
  }

  public void setMonpc(Machine monpc) {
    this.monpc = monpc;
  }
  
  
}
