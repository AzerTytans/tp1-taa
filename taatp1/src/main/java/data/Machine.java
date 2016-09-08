package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Machine {
  private int id;
  private List<Logiciel> leslogiciels = new ArrayList<Logiciel>();
  private Personne root;
  
  /**
   * Constructeur vide
   */
  public Machine(){}

  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @OneToMany(mappedBy= "machine", cascade = CascadeType.PERSIST)
  public List<Logiciel> getLeslogiciels() {
    return leslogiciels;
  }

  public void setLeslogiciels(List<Logiciel> leslogiciels) {
    this.leslogiciels = leslogiciels;
  }

  @OneToOne
  public Personne getRoot() {
    return root;
  }

  public void setRoot(Personne root) {
    this.root = root;
  }
}
