package data;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Logiciel {
  private int id;
  
  @Temporal(TemporalType.DATE)
  private Date date_installation;
  private int taille;
  private Machine machine;

  /**
   * Constructeur vide
   */
  public Logiciel(){}

  @Id
  @GeneratedValue
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDate_installation() {
    return date_installation;
  }

  public void setDate_installation(Date date_installation) {
    this.date_installation = date_installation;
  }

  public int getTaille() {
    return taille;
  }

  public void setTaille(int taille) {
    this.taille = taille;
  }

  @ManyToOne
  public Machine getMachine() {
    return machine;
  }

  public void setMachine(Machine machine) {
    this.machine = machine;
  }   
}
