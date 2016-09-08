package jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import data.Logiciel;
import data.Machine;
import data.Personne;

public class JpaTest {

  private EntityManager manager;

  public JpaTest(EntityManager manager) {
    this.manager = manager;
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();
    JpaTest jpa = new JpaTest(manager);

    EntityTransaction tx = manager.getTransaction();
    tx.begin();
    try {

      jpa.createPersonne("Legendre", "Matthieu", "t@t.t");

    } catch (Exception e) {
      e.printStackTrace();
    }
    tx.commit();

    manager.close();
    factory.close();
  }

  private void createMachine(Personne p) {
    Machine m = new Machine();
    m.setRoot(p);
    p.setMonpc(m);
    manager.persist(m);
    this.createLogiciel(p, m);
  }
  
  private void createPersonne(String nom, String prenom, String mail){
    Personne p = new Personne();
    p.setMail(mail);
    p.setNom(nom);
    p.setPrenom(prenom);
    manager.persist(p);
    this.createMachine(p);
  }
  
  private void createLogiciel(Personne p, Machine m) {
    List<Logiciel> machines = new ArrayList<Logiciel>();
    int rand = (int)Math.round(Math.random()*10);
    for(int i = 0 ; i <= rand ; i++){
      Logiciel l = new Logiciel();
      l.setDate_installation(new Date());
      l.setMachine(m);
      machines.add(l);
      manager.persist(l);
    }
    m.setLeslogiciels(machines);
    manager.persist(m);
    manager.persist(p);
  }
  
}
